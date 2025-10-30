package scopedvalues;

// Always imported by default, noice!
// import java.lang.ScopedValue;

///
/// # Scoped Value Example
/// - This is neater and cleaner than thread-local variables
/// - It is also meant to replace it
///
public class ScopedValueExample {
  // Declare a static final ScopedValue
  static final ScopedValue<String> USER_ID = ScopedValue.newInstance();

  void main() {
    // Bind a value and run code with it
    ScopedValue.where(USER_ID, "aliceNotBob").run(() -> {
      IO.println("somewhere in main(): " + USER_ID.get());
      performTask(); // This method can access the bound value
    });

    // Calling USER_ID.get() here throws an exception as it's out of scope
//    USER_ID.get();
  }

  static void performTask() {
    // 3. Read the value from anywhere within the dynamic scope
    IO.println("Task: " + USER_ID.get());
  }
}