package pattermatchingenhancements;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankRiskCalculatorTest {
  private final BankRiskCalculator calculator = new BankRiskCalculator();

  @Test
  void testSavingsLowBalance() {
    var acc = new BankRiskCalculator.SavingsAccount(500);
    assertEquals(0.1, calculator.calculateRisk(acc));
  }

  @Test
  void testCreditCardHighUsage() {
    var acc = new BankRiskCalculator.CreditCardAccount(5000, 4500);
    assertEquals(0.2, calculator.calculateRisk(acc));
  }

  @Test
  void testLoanLowPayment() {
    var acc = new BankRiskCalculator.LoanAccount(10000, 500);
    assertEquals(0.15, calculator.calculateRisk(acc));
  }
}