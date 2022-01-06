# GraalVM.js with JPMS Demo

This project shows how to use GraalVM.js with a modular Java application.

## Build

```
./gradlew jar
```

## Run

Run the `demo.Main` class to execute a JS script.

The script will have access to a variable called `javaType` of type [JavaType](src/main/java/demo/pub/JavaType.java).

Options:

* `<js-code>` - execute any JS code, e.g. `2+2` or `javaType.getMessage()`
* `-f <js-file>` - execute a JS file.

### Running Without JPMS

```
java -cp build/libs/graalvm-js-jlink-demo-1.0-SNAPSHOT.jar demo.Main <options>
```

### Running with the JPMS

> Notice that the JS code can only see `JavaType` because it's exported by the `demo.app` module.
> If you do not export the `demo` package, then the script can't call anything on the `javaType` variable.
> This might be a bug in GraalVM, as it may be desirable to be able to load and run JS code from wthin a module
> while allowing the JS code to "see" public, but not exported, members of the module.
> See https://github.com/oracle/graal/issues/4038

```
java -p build/libs/graalvm-js-jlink-demo-1.0-SNAPSHOT.jar -m "demo.app/demo.Main" <options>
```
