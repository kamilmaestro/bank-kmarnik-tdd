package bank

import spock.lang.Unroll
import spock.lang.Specification

class CreateAccountSpec extends Specification {

    Bank bank

    def setup() {
        bank = new Bank()
    }

    @Unroll
    def "should create an account with specified account number"() {
        when: "the account is created"
            int number = bank.createAccount()
        then: "check account number"
            number == accountNumber
        where:
            user   | accountNumber
            'John' | 1
            'Tom'  | 2
            'Mike' | 3
            'Todd' | 4
    }

    def "should create new account with empty balance" () {
        when: "the account is created"
            int accountNumber = bank.createAccount()
        then: "account balance is empty"
            bank.getAccount(accountNumber).getAccountBalance() == 0
    }

}
