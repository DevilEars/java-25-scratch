package flexibleconstructorbodies;

class BankAccount {
  String accountNumber;
  double balance;

  /**
   * Constructor
   *
   * @param accountNumber an account number
   * @param balance a balance
   */
  public BankAccount(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  /**
   * This prints out the balance. Override this method in sub-classes to demonstrate flexible construction bodies
   */
  void printBalance() {
    System.out.println("Balance:" + balance);
  }

  public double getBalance() {
    return balance;
  }
}
