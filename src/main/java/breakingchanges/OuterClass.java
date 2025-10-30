package breakingchanges;

///
/// # Implicit null checks for enclosing instances of inner classes
/// - Checks for NPEs that were technically possible, if unlikely
/// - Break hard and fast, not soft and slow
///
class OuterClass {
  private final String name;

  public OuterClass(String name) {
    this.name = name;
  }

  class InnerClass {
    void greet() {
      // This implicitly uses OuterClass.this.name
      IO.println("Hello from " + name + "!");
    }
  }

  public static void main(String[] args) throws Exception {
    // Normal, correct way to create an InnerClass instance
    OuterClass outerclass = new OuterClass("Correct");
    InnerClass innerclass = outerclass.new InnerClass();
    innerclass.greet(); // Works: "Hello from Correct!"

    IO.println("*****************");

    // Attempt to create InnerClass with null outer using reflection
    try {
      var constructor = InnerClass.class.getDeclaredConstructor(OuterClass.class);
      // This immediately throws an NPE
      InnerClass innerclassNullOuter = constructor.newInstance((OuterClass) null);
      innerclassNullOuter.greet(); // This line would never be reached
    } catch (NullPointerException e) {
      IO.println("Caught NPE: " + e.getMessage());
      IO.println("This is expected in Java 25+ due to the new null check.");
    }
  }
}