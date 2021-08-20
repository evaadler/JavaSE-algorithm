package designpattern.decorator.productprice;

import java.math.BigDecimal;

/**
 * BaseCount 支付基本类
 *
 * @author Alicia
 * @description
 * @date 2021/8/20
 */
public class BaseCount implements IBaseCount{
    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail) {
        orderDetail.setPayMoney(orderDetail.getMerchandise().getPrice());
        System.out.println("商品元单价金额为： " + orderDetail.getPayMoney());
        return orderDetail.getPayMoney();
    }
}
