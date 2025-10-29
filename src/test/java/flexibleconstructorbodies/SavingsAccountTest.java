package flexibleconstructorbodies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

  @Test
  void shouldCreateAccountWithValidInputs() {
    SavingsAccount account = new SavingsAccount("SA001", 1000, 0.05);
    assertEquals(1000, account.getBalance());
    assertEquals(0.05, account.getInterestRate());
  }

  @Test
  void shouldThrowExceptionForLowBalance() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new SavingsAccount("SA002", 50, 0.05)
    );
    assertEquals("Minimum opening balance of 100 required", exception.getMessage());
  }

  @Test
  void shouldThrowExceptionForInvalidInterestRate() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new SavingsAccount("SA003", 500, 0.15)
    );
    assertEquals("Interest rate must be between 0 and 10%", exception.getMessage());
  }

  @Test
  void shouldChainConstructorsAndDeriveInterestRate() {
    SavingsAccount account = new SavingsAccount("SA004", 1500);
    assertEquals(0.08, account.getInterestRate());
  }
}