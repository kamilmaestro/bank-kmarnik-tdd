package bank;

import java.util.List;

interface AccountRepository {

  void save(Account account);
  Account getByNumber(int accountNumber);
  void delete(int accountNumber);
  List<Account> findAll();

}
