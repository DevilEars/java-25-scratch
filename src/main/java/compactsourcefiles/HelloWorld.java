package compactsourcefiles;
// no imports? wut?

///
/// #Compact class
/// - No need for public access modifier of the class
/// - java.io.
///
class HelloWorld {
  // main is now an instance method
  void main(){
    // common java.base packages are imported by default for a while...
    // IO is newish in the java.lang package, so here we are
    IO.println("Hello World, from instance main!");
  }
}
