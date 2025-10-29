package flexibleconstructorbodies;

///
/// # This Savings Account is empty, just like me. Thanks, Obama.
/// Topics to cover here:
/// - Validation before calling super
/// - Final field initialisation before calling super to prevent incorrect states
/// - Constructor chaining with derived values
///
public class SavingsAccount extends BankAccount {
  private final double interestRate;// final field, not initialized yet

  /**
   * Primary constructor with validation
   */
  public SavingsAccount(String accountNumber, double balance, double interestRate) {
    // Lovely validation before super(...) call
    // This is called the Prologue
    // You can throw exceptions here with your hands in the air like you just do care
    if (balance < 100) {
      throw new IllegalArgumentException("Minimum opening balance of 100 required");
    }
    if (interestRate <= 0 || interestRate > 0.1) {
      throw new IllegalArgumentException("Interest rate must be between 0 and 10%");
    }

    // Calling the super constructor after validation.
    // This was not possible in previous LTS versions
    super(accountNumber, balance);
    this.interestRate = interestRate;
  }

  /**
   * Chained constructor: derives interest rate based on balance tier
   * @param accountNumber an account number
   * @param balance a balance
   */
  public SavingsAccount(String accountNumber, double balance) {
    // Compute derived interest rate before chaining
    double derivedRate = balance >= 1000 ? 0.08 : 0.03;

    // Chain to primary constructor
    this(accountNumber, balance, derivedRate);
  }

  public double getInterestRate() {
    return interestRate;
  }
}
