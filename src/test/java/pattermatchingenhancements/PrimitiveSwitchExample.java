package pattermatchingenhancements;

///
/// This is a preview feature. All manner of red flags to up
/// so you can't realistically switch on primitive types directly, yet.
///
/// Boxed types are fine
///
public class PrimitiveSwitchExample {
  public static void main(String[] args) {
    Object value = 3.14;
    // the singularity is near when you do this:
    // double value = 3.14;

    // Switch on boxed primitive types? No problem
    switch (value) {
      case Double d when d > 0 -> System.out.println("Positive double: " + d);
      case Integer i -> System.out.println("Integer: " + i);
      case null, default -> System.out.println("Other or null");
    }

    boolean flag = false;

    // Switch on a primitive boolean? no problem - no chance of null
    switch (flag) {
      case true -> System.out.println("Flag is true");
      case false -> System.out.println("Flag is false");
      // default case? IDE hasn't caught up to Java 25 yet
    }
  }
}
