package demo;

import demo.pub.JavaType;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File scriptFile = null;
        String jsCode = "print('Calling Java type method');\n" +
                "print('Got Java message: ' + javaType.getMessage());\n" +
                "'done';";

        if (args.length == 2 && args[0].equals("-f")) {
            scriptFile = new File(args[1]);
        } else if (args.length > 1) {
            throw new RuntimeException("Options are:\n" +
                    "  -f <js-script-file>\n" +
                    "  <js-script>");
        } else if (args.length == 1) {
            jsCode = args[0];
        }

        var jsEngine = Context.newBuilder("js")
                .allowAllAccess(true)
                .allowNativeAccess(true)
                .build();

        jsEngine.getBindings("js").putMember("javaType", new JavaType());

        Source source;

        if (scriptFile != null) {
            source = Source.newBuilder("js", scriptFile).build();
        } else {
            source = Source.create("js", jsCode);
        }

        System.out.println(jsEngine.eval(source));
    }
}
