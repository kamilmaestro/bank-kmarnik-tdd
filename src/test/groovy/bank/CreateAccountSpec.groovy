package bank

import spock.lang.Unroll
import spock.lang.Specification

class CreateAccountSpec extends Specification {

    BankOperation bank

    def setup() {
        bank = new Bank()
    }

    @Unroll
    def "should create an account with specified account number"() {
        when: "the account is created"
            int number = bank.createAccount()
        then: "account has assigned an number"
            number == 1
    }

    def "should create new account with an empty balance" () {
        when: "the account is created"
            int accountNumber = bank.createAccount()
        then: "account balance is empty"
            bank.getAccount(accountNumber).getAccountBalance() == 0
    }

}
