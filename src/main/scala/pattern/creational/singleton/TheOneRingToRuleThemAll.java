package pattern.creational.singleton;

public final class TheOneRingToRuleThemAll {
    private static TheOneRingToRuleThemAll ring;
    private String owner;
    
    private TheOneRingToRuleThemAll(String owner) {
        this.owner = owner; 
    }
    
    private static synchronized void createInstance(String owner) {
        if (ring == null)
            ring = new TheOneRingToRuleThemAll(owner);
    }
    
    public static TheOneRingToRuleThemAll getInstance(String owner) {
        if ( ring == null ) {
            createInstance(owner);
        }
        return ring;
    }

    public static void main(String[] args) {
        TheOneRingToRuleThemAll theEyeRing = TheOneRingToRuleThemAll.getInstance("SAURON");
        TheOneRingToRuleThemAll precious = TheOneRingToRuleThemAll.getInstance("GOLLUM");
        TheOneRingToRuleThemAll theOne = TheOneRingToRuleThemAll.getInstance("BOROMIR");
        
        println( "Are the same ring? " + (precious == theOne));

        println( "Precious? " + precious);

        println( "The One? " + theOne);
        
        println("Who owns the ring? The one: " + theOne.owner + ". And preciuos? " + precious.owner);
    }
        
    public static void println(String text) {
            System.out.println(text);
    }
    
    //TODO: METERLO A CORRER EN UN THREADPOOL EXECUTOR QUE SE EJECUTEN LOS 3 DE MANERA CONCURRENTE, A VER QUIEN SETEA EL OWNER
}
