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
I set up my IDE to use the current version as controlled by SDK, 
and I rely on OS environment variables for managing default Java settings.

This means project specific Java SDK settings are handled by each individual project.

## Reading list
- [Java 25 Released](https://www.infoq.com/news/2025/09/java25-released/)
- [Shenandoah GC](https://wiki.openjdk.org/display/shenandoah/Main)
- [Java 25 Flexible Constructor Bodies](https://www.baeldung.com/java-25-flexible-constructor-bodies)
- 