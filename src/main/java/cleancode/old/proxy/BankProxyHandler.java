package cleancode.old.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * BankProxyHandler
 * [InvocationHandler] 代理 API
 *
 * @author Alicia
 * @description
 * @date 2020/6/13
 */
public class BankProxyHandler implements InvocationHandler {
    private Bank bank;

    public BankProxyHandler(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("getAccounts")) {
            bank.setAccounts(getAccountsFromDatabase());
            return bank.getAccounts();
        } else if(methodName.equals("setAccounts")) {
            bank.setAccounts((Collection<Account>)args[0]);
            setAccountsToDatabase(bank.getAccounts());
            return null;
        } else{

        }
        return null;
    }

    private void setAccountsToDatabase(Collection<Account> accounts) { }

    private Collection<Account> getAccountsFromDatabase() {
        return null;
    }
}
