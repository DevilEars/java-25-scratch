# Java 25 Scratch
Breeding ground for Java 25 features.

## Getting Java 25 SDK
I use [SDKMan](https://sdkman.io/) to manage Java SDKs.

Use this command to find a list of available Java 25 SDKs: 
```Bash
sdk list java | grep "25"
```
It will also show you how to install a default SDK, for example:
```Bash
sdk install java 25.0.1-tem
```
I set up my IDE to use the current version as controlled by SDKMan, 
and I rely on OS environment variables for managing default Java settings.

This means project specific Java SDK settings are handled by each individual project.

## Reading list
- [Java 25 Released](https://www.infoq.com/news/2025/09/java25-released/)
- [The Arrival of Java 25](https://blogs.oracle.com/java/post/the-arrival-of-java-25)
- [Java 25 Flexible Constructor Bodies](https://www.baeldung.com/java-25-flexible-constructor-bodies)
- [Pattern Matching for Switch](https://www.baeldung.com/java-switch-pattern-matching), this is prior to Java 25.
- [Primitive Types in Patterns, instanceof, and switch](https://openjdk.org/jeps/507), contains better use cases than mine.
- [Remove the 32-bit x86 Port](https://openjdk.org/jeps/501) since virtually nobody is going to miss it
- [Scoped Values](https://www.baeldung.com/java-20-scoped-values), to replace thread-local variables
- [Method Timing in Java 25](https://blog.kelunik.com/2025/08/24/method-trace-java-25.html), for enhanced observability
- [Shenandoah GC](https://wiki.openjdk.org/display/shenandoah/Main) main page, including an implementation overview
- [KDF](https://openjdk.org/jeps/510), Key Derivation Function API