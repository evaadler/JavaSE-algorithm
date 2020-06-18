package cleancode.old.proxy;

import java.util.Collection;

/**
 * Bank
 * Java代理适用于简单的情况，例如在单独的对象或类中包装方法调用。
 * JDK提供的动态代理仅能与接口协同工作。对于代理类，得使用字节码操作库
 *
 * @author Alicia
 * @description
 * @date 2020/6/13
 */
public interface Bank {
    Collection<Account> getAccounts();
    void setAccounts(Collection<Account> accounts);
}
