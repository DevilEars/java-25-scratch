package flexibleconstructorbodies;

class BankAccount {
  String accountNumber;
  double balance;

  /**
   * Constructor
   *
   * @param accountNumber an account number
   * @param balance       a balance
   */
  public BankAccount(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }
}
