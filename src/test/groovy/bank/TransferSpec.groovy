package bank

import spock.lang.Specification

class TransferSpec extends Specification {

    BankOperation bank

    def setup() {
        bank = new Bank()
    }

    def cleanup () {
        Bank.accountNumber = 0
    }

    def "should make a transfer between two existing accounts if balance of the first account enables this" () {
        given: "there are two accounts"
            int accountNumber = bank.createAccount()
            int secondAccountNumber = bank.createAccount()
        and: "the first account has some amount of money"
            bank.deposit(accountNumber, 200)
        when: "transfers some money to the second account"
            boolean isTransferred = bank.transfer(accountNumber, secondAccountNumber, 100)
        then: "money is transferred"
            isTransferred
    }

    def "should not make a transfer between two accounts if balance of the first account does not enable it" () {
        given: "there are two accounts"
            int accountNumber = bank.createAccount()
            int sndAccountNumber = bank.createAccount()
        and: "the first account has some amount of money"
            bank.deposit(accountNumber, 200)
        when: "transfers bigger amount of money than balance of the first account"
            boolean isTransferred = bank.transfer(accountNumber, sndAccountNumber, 300)
        then: "money is not transferred"
            !isTransferred
    }

    def "should not make a transfer between two accounts if there is no such accounts" () {
        when: "transfers money"
            boolean isTransferred = bank.transfer(1, 2, 300)
        then: "money is not transferred"
            !isTransferred
    }

}
