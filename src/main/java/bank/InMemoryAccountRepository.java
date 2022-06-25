package bank;

import java.util.HashMap;
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

}
