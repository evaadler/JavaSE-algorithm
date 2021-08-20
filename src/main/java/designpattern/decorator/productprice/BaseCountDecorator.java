package designpattern.decorator.productprice;

import java.math.BigDecimal;

/**
 * BaseCountDecorator 计算支付金额的抽象类，由抽象类调用基本类
 *
 * @author Alicia
 * @description
 * @date 2021/8/20
 */
public abstract class BaseCountDecorator implements IBaseCount{
    private IBaseCount count;

    public BaseCountDecorator(IBaseCount count){
        this.count = count;
    }

    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail){
        BigDecimal payTotalMoney = new BigDecimal(0);
        if (count != null){
            payTotalMoney = count.countPayMoney(orderDetail);
        }
        return payTotalMoney;
    }
}
