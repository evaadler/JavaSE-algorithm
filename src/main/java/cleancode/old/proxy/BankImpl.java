package cleancode.old.proxy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * BankImpl
 *
 * @author Alicia
 * @description
 * @date 2020/6/13
 */
public class BankImpl implements Bank {
    private List<Account> accounts;

    @Override
    public Collection<Account> getAccounts() {
        return accounts;
    }

    @Override
    public void setAccounts(Collection<Account> accounts) {
        this.accounts = new ArrayList<>();
        for (Account account : accounts) {
            this.accounts.add(account);
        }
    }
}
