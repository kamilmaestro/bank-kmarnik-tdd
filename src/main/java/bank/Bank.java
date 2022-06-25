package bank;

import java.util.Optional;

class Bank implements BankOperation {

  static int accountNumber = 0;
  private final AccountRepository accountRepository;

  public Bank() {
    this.accountRepository = new InMemoryAccountRepository();
  }

  public int createAccount() {
    ++accountNumber;
    accountRepository.save(Account.createNewAccount(accountNumber));

    return accountNumber;
  }

  public Account getAccount(int accountNumber) {
    return accountRepository.getByNumber(accountNumber);
  }

  public boolean deposit(int accountNumber, int amount) {
    return Optional.ofNullable(getAccount(accountNumber))
        .map(account -> {
          account.deposit(amount);
          accountRepository.save(account);
          return true;
        })
        .orElse(false);
  }

}
