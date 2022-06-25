package bank;

final class Account {

  private static final int EMPTY_BALANCE = 0;

  private final int accountNumber;
  private int accountBalance;

  Account(int accountNumber, int accountBalance) {
    this.accountNumber = accountNumber;
    this.accountBalance = accountBalance;
  }

  static Account createNewAccount(int accountNumber) {
    return new Account(accountNumber, EMPTY_BALANCE);
  }

  void deposit(int amount) {
    this.accountBalance += amount;
  }

  int getAccountNumber() {
    return accountNumber;
  }

  int getAccountBalance() {
    return accountBalance;
  }

}
