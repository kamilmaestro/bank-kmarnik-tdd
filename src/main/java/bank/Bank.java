package bank;

import java.util.Optional;

class Bank implements BankOperation {

  static int accountNumber = 0;
  private final AccountRepository accountRepository;

  public Bank() {
    this.accountRepository = new InMemoryAccountRepository();
  }

  @Override
  public int createAccount() {
    ++accountNumber;
    accountRepository.save(Account.createNewAccount(accountNumber));

    return accountNumber;
  }

  @Override
  public Account getAccount(int accountNumber) {
    return accountRepository.getByNumber(accountNumber);
  }

  @Override
  public boolean deposit(int accountNumber, int amount) {
    return Optional.ofNullable(getAccount(accountNumber))
        .map(account -> {
          account.deposit(amount);
          accountRepository.save(account);
          return true;
        })
        .orElse(false);
  }

  @Override
  public boolean withdraw(int accountNumber, int amount) {
    return Optional.ofNullable(getAccount(accountNumber))
        .map(account -> {
          final boolean wasWithdrawn = account.withdraw(amount);
          accountRepository.save(account);
          return wasWithdrawn;
        })
        .orElse(false);
  }

  @Override
  public int accountBalance(int accountNumber) {
    final Account account = getAccount(accountNumber);
    return Optional.ofNullable(account)
        .map(Account::getAccountBalance)
        .orElse(ACCOUNT_NOT_EXISTS);
  }

  @Override
  public int deleteAccount(int accountNumber) {
    final int deletedAccountBalance = accountBalance(accountNumber);
    if (deletedAccountBalance != ACCOUNT_NOT_EXISTS) {
      accountRepository.delete(accountNumber);
    }

    return deletedAccountBalance;
  }

  @Override
  public boolean transfer(int fromAccountNumber, int toAccountNumber, int amount) {
    final Account account = getAccount(fromAccountNumber);
    final Account transferTo = getAccount(toAccountNumber);
    if (Optional.ofNullable(account).isPresent() && Optional.ofNullable(transferTo).isPresent()) {
      return account.transfer(transferTo, amount);
    }

    return false;
  }

}
