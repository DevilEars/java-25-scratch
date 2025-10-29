package pattermatchingenhancements;

///
/// This is a preview feature. All manner of red flags to up
/// so you can't realistically switch on primitive types directly, yet.
///
/// Boxed types are fine
///
class PrimitiveSwitchExamples {
  void main() {
    Object value = 3.14;
    // the singularity is near when you do this:
//     double value = 3.14;

    // Direct primitive matching in instanceof
    if (value instanceof int i) {
      // won't happen for our double
      IO.println("It's an int, init? " + i);
    }

    // Clean type dispatch in switch
    // no instanceof or casts needed
    switch (value) {
      // should get here
      case double d when d > 0 -> IO.println("Positive double: " + d);
      // should not get here or further
      case Integer i -> IO.println("Integer: " + i);
      case null, default -> IO.println("Other or null");
    }

    boolean flag = false;

    // Switch on a primitive boolean? no problem since JDK 23-ish
    switch (flag) {
      case true -> IO.println("Flag is true");
      case false -> IO.println("Flag is false");
    }

    // You could always do this (mostly)
    int httpStatus = 200;

    switch (httpStatus) {
      case 200 -> IO.println("Status Ultramega OK");
      default -> IO.println("We've gone too far, we've seen too much");
    }
  }
}
