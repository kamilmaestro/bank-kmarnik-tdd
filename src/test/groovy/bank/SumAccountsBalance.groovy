package bank

import spock.lang.Specification

class SumAccountsBalance extends Specification {

    BankOperation bank

    def setup() {
        bank = new Bank()
    }

    def cleanup () {
        Bank.accountNumber = 0
    }

    def "should get balance of all accounts" () {
        given: "there are two accounts"
            int accountNumber = bank.createAccount()
            int sndAccountNumber = bank.createAccount()
        and: "those account have balances"
            bank.deposit(accountNumber, 100)
            bank.deposit(sndAccountNumber, 15)
        when: "gets balance of all accounts"
            int accountBalance = bank.sumAccountsBalance()
        then: "obtained balance contains balances of all accounts"
            accountBalance == 115
    }
}
