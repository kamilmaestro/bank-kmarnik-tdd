package bank;

interface AccountRepository {

  void save(Account account);
  Account getByNumber(int accountNumber);

}