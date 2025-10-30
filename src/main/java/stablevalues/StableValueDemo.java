package stablevalues;

import java.util.logging.Logger;

class StableValueDemo {
  // StableValue holding a Logger instance
  // This is a final field
  private static final StableValue<Logger> LOGGER_STABLE = StableValue.of();

  private static Logger logger() {
    // this ensures that initialization happens at most once
    // JVM may treat this as a constant now, allowing for constant folding

    // Constant folding means evaluating constant expressions at compile time instead of runtime
    // e.g. int x = 5 + 10 is folded into x = 15 by the compiler
    return LOGGER_STABLE.orElseSet(() -> Logger.getLogger(StableValueDemo.class.getName()));
  }

  static void main() {
    logger().info("First call to logger – logger is initialized lazily");
    logger().info("Second call to logger – same logger reused");
  }
}

