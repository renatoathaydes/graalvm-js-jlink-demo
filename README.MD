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

```
java -p build/libs/graalvm-js-jlink-demo-1.0-SNAPSHOT.jar -m "demo.app/demo.Main" <options>
```
