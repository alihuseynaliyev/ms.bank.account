package az.alinazim.ms.bank.account.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    private String accountNumber;
    private String accountName;
    private BigDecimal balance;
}
