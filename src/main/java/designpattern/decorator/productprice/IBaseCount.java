package designpattern.decorator.productprice;

import java.math.BigDecimal;

/**
 * IBaseCount 计算支付金额接口类
 *
 * @author Alicia
 * @description
 * @date 2021/8/20
 */
public interface IBaseCount {
    BigDecimal countPayMoney(OrderDetail orderDetail);
}
