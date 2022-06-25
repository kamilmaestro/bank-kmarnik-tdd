package bank;

public interface BankOperation {

  int createAccount();
  Account getAccount(int accountNumber);
  boolean deposit(int accountNumber, int amount);
  boolean withdraw(int accountNumber, int amount);

}
