package br.com.axsilva.account.domain

import br.com.axsilva.account.domain.exception.InvalidValueException
import br.com.axsilva.account.domain.exception.TransferDefautlException
import br.com.axsilva.account.domain.constants.Constants.Companion.INSUFFICIENT_BALANCE
import br.com.axsilva.account.domain.constants.Constants.Companion.INVALID_AGENGY_CODE

class Account(
    private val code: Long,
    private val client: Client,
    agency: Long
) {

    // on this case a value from create account is 100.00$
    private var balance: Double = 100.00
    private val agency: Long

    init {
        this.agency = setAgency(agency)
    }

    private fun setAgency(agency: Long): Long {
        if (agency < 1) throw InvalidValueException(INVALID_AGENGY_CODE)
        return agency
    }

    private fun withdrawMoney(value: Double){
        if (this.balance < value)
            throw TransferDefautlException(INSUFFICIENT_BALANCE)
        this.balance -= value;
    }

    fun deposit(value: Double) {
        this.balance += value
    }

    fun transfer(value: Double, destiny: Account) {
        this.withdrawMoney(value)
        destiny.deposit(value)
    }
}