package az.alinazim.ms.bank.account.service;

import az.alinazim.ms.bank.account.dao.entity.BankAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BankAccountService {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    public void createBankAccount(BankAccount bankAccount) {
        log.info("ActionLog.createBankAccount.start accountNumber: {}", bankAccount.getAccountNumber());
        bankAccounts.add(bankAccount);
        log.info("ActionLog.createBankAccount.end accountNumber: {}", bankAccount.getAccountNumber());
    }

    public List<BankAccount> getAllBankAccount() {
        log.info("ActionLog.getAllBankAccount.start");
        if (bankAccounts != null) {
            log.info("ActionLog.getAllBankAccount.success");
        } else {
            log.info("ActionLog.getAllBankAccount.error");
        }
        return bankAccounts;
    }

    public BankAccount getBankAccount(String accountNumber) {
        var foundBankAccount = bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
        if (foundBankAccount == null) {
            log.error("ActionLog.getBankAccount.error not found with accountNumber {}", accountNumber);
        } else {
            log.info("ActionLog.getBankAccount.success  accountNumber {}", accountNumber);
        }
        return foundBankAccount;
    }

    public void updateBankAccount(String accountNumber, BankAccount bankAccount) {
        var updatedBankAccount = bankAccounts.stream()
                .filter(bankAccount1 -> bankAccount1.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
        if (updatedBankAccount == null) {
            log.error("ActionLog.getBankAccount.error  accountNumber {}", accountNumber);
        } else {
            updatedBankAccount.setAccountName(bankAccount.getAccountName());
            updatedBankAccount.setBalance(bankAccount.getBalance());
            log.info("ActionLog.getBankAccount.success  bankAccount {}", bankAccount);
        }
    }

    public void deleteBankAccount(String accountNumber) {
        boolean removed = bankAccounts.removeIf(bankAccount -> bankAccount.getAccountNumber().equals(accountNumber));
        if (!removed) {
            log.error("ActionLog.getBankAccount.error  accountNumber {}", accountNumber);
        } else {
            log.info("ActionLog.getBankAccount.success  accountNumber {}", accountNumber);
        }

    }
}