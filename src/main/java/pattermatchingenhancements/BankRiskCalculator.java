package pattermatchingenhancements;

public class BankRiskCalculator {

  // a sealed interface limits implementation to only the permitted record types
  public sealed interface Account permits SavingsAccount, CreditCardAccount, LoanAccount {}

  // the record types (since Java 14)
  public record SavingsAccount(double balance) implements Account {}
  public record CreditCardAccount(double limit, double used) implements Account {}
  public record LoanAccount(double total, double paid) implements Account {}

  /**
   *
   * @param account an account
   * @return a risk score
   */
  public double calculateRisk(Account account) {
    // switch on an interface, wut?
    return switch (account) {
      // Record patterns in switch, wut wuut?
      case SavingsAccount(double bal) -> bal < 1000 ? 0.1 : 0.01;
      case CreditCardAccount(double lim, double used) ->
          used / lim > 0.8 ? 0.2 : 0.05;
      case LoanAccount(double total, double paid) ->
          paid < 1000 ? 0.15 : 0.08;
      // no default case, wut wuut wuuut?
      // Account is sealed,  the compiler verifies that all subtypes are handled
    };
  }

}