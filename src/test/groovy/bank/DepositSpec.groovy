package bank

import spock.lang.Specification

class DepositSpec extends Specification {

    BankOperation bank

    def setup() {
        bank = new Bank()
    }

    def cleanup () {
        Bank.accountNumber = 0
    }

    def "should deposit amount of money to an existing account" () {
        given: "there is an account"
            int accountNumber = bank.createAccount()
        when: "deposits an amount of money to account"
            boolean isDeposited = bank.deposit(accountNumber, 200)
        then: "money is deposited"
            isDeposited
    }

    def "should not deposit amount of money if account does not exist" () {
        when: "deposits amount of money to the not existing account"
            boolean isDeposited = bank.deposit(1, 200)
        then: "money is not deposited"
            !isDeposited
    }

}
