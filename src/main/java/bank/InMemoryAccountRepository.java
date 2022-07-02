package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InMemoryAccountRepository implements AccountRepository  {

  private final Map<Integer, Account> values = new HashMap<>();

  @Override
  public void save(Account account) {
    values.put(account.getAccountNumber(), account);
  }

  @Override
  public Account getByNumber(int accountNumber) {
    return values.get(accountNumber);
  }

  @Override
  public void delete(int accountNumber) {
    values.remove(accountNumber);
  }

  @Override
  public List<Account> findAll() {
    return new ArrayList<>(values.values());
  }

}
