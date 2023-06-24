package cz.pavelstibal.mapper;

import cz.pavelstibal.domain.Account;
import cz.pavelstibal.domain.BillingAccount;
import jakarta.annotation.Nonnull;

public class BillingAccountMapper {

    private static final String SPACE = " ";

    public static BillingAccount toBillingAccount(@Nonnull final Account account) {
        final BillingAccount billingAccount = new BillingAccount();
        billingAccount.setId(account.getId());
        billingAccount.setName(account.getFirstname() + SPACE + account.getLastname());
        billingAccount.setLastUpdate(account.getUpdatedAt());
        return billingAccount;
    }

    private BillingAccountMapper() {
    }
}
