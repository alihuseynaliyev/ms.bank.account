package az.alinazim.ms.bank.account.controller;

import az.alinazim.ms.bank.account.dao.entity.BankAccount;
import az.alinazim.ms.bank.account.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("api/v1/accounts")
@RequiredArgsConstructor
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createBankAccount(@RequestBody BankAccount bankAccount) {
        bankAccountService.createBankAccount(bankAccount);
    }

    @GetMapping
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountService.getAllBankAccount();
    }

    @GetMapping("/{accountNumber}")
    public BankAccount getBankAccount(@PathVariable("accountNumber") String accountNumber) {
        return bankAccountService.getBankAccount(accountNumber);
    }

    @PutMapping("/{accountNumber}")
    @ResponseStatus(NO_CONTENT)
    public void updateBankAccount(@PathVariable("accountNumber") String accountNumber, @RequestBody BankAccount bankAccount) {
        bankAccountService.updateBankAccount(accountNumber, bankAccount);
    }

    @DeleteMapping("/{accountNumber}")
    @ResponseStatus(NO_CONTENT)
    public void deleteBankAccount(@PathVariable("accountNumber") String accountNumber) {
        bankAccountService.deleteBankAccount(accountNumber);
    }

}