package moduleimports;

// Import the base module
import module java.base;

import static java.lang.IO.println;

///
/// # Module imports
/// - Importing the module gives access to everything in the module
/// - No need for individual imports
/// - Syntactic sugar?
///
class ListFruits {
  void main(){
    // The whole shebang from the base module is imported already
    // no need to specify individual imports
    // no need for wildcards
    List<String> fruits = List.of("apple", "banana", "cherry", "date", "elderberry");

    // fruity and loopy
    for (String fruit: fruits){
      println(fruit);
    }

    // getting fruity without the loopy
    fruits.stream().forEach(IO::println);
  }
}
