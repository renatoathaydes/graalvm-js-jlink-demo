package demo.pub;

public class JavaType {

    public final String stringField = "public field";

    public String getMessage() {
        return "hello world";
    }

    public boolean getTrue() {
        return true;
    }

    private String privateMethod() {
        return "should not be able to call me";
    }
}
