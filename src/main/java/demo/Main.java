package demo;

import demo.pub.JavaType;
import org.graalvm.polyglot.Context;

public class Main {
    public static void main(String[] args) {
        if (args.length > 1) throw new RuntimeException("Please provide JS source code to run as the only argument");

        var jsCode = "print('Calling Java type method');\n" +
                "print('Got Java message: ' + javaType.getMessage());\n" +
                "'done';";

        if (args.length == 1) {
            jsCode = args[0];
        }

        var jsEngine = Context.newBuilder("js")
                .allowAllAccess(true)
                .allowNativeAccess(true)
                .build();

        jsEngine.getBindings("js").putMember("javaType", new JavaType());

        System.out.println(jsEngine.eval("js", jsCode));
    }
}
