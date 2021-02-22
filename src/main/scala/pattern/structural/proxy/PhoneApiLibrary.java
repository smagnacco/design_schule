package pattern.structural.proxy;

public class PhoneApiLibrary implements PhoneApi {
    public Long getPhoneNumber(String user) throws IllegalArgumentException {
        if (user.equals(""))
            throw new IllegalArgumentException();
        return 15465465654L;
    }
}
