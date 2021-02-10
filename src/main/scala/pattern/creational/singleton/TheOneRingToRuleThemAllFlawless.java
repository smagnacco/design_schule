package pattern.creational.singleton;

public class TheOneRingToRuleThemAllFlawless {
    private String owner = "SAURON";
    
    private TheOneRingToRuleThemAllFlawless(String owner) {
        this.owner = owner; 
    }
    
    //CAVEAT: NOT THREAD SAFE IMPLEMENTATION
    public static TheOneRingToRuleThemAllFlawless getInstance(String owner) {
        TheOneRingToRuleThemAllFlawless singletonerd = new TheOneRingToRuleThemAllFlawless(owner);
        return singletonerd;
    }

    public static void main(String[] args) {
        // private TheOneRingToRuleThemAll precious = new TheOneRingToRuleThemAll(); WON'T COMPILE
        
        TheOneRingToRuleThemAllFlawless precious = TheOneRingToRuleThemAllFlawless.getInstance("GOLLUM");
        
        TheOneRingToRuleThemAllFlawless theOne = TheOneRingToRuleThemAllFlawless.getInstance("BOROMIR");
        
        println( "Are the same? " + (precious == theOne));

        println( "Precious? " + precious);

        println( "The One? " + theOne);
    }

    public static void println(String text) {
        System.out.println(text);
    }
}
