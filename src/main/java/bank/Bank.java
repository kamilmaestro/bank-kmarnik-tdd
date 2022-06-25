package bank;

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

}
