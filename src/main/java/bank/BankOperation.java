package bank;

public interface BankOperation {

  int ACCOUNT_NOT_EXISTS = -1;

  int createAccount();
  Account getAccount(int accountNumber);
  boolean deposit(int accountNumber, int amount);
  boolean withdraw(int accountNumber, int amount);
  int accountBalance(int accountNumber);
  int deleteAccount(int accountNumber);

}
