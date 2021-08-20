package designpattern.decorator.productprice;

import java.math.BigDecimal;

/**
 * CouponDecorator 计算使用优惠卷后的金额
 *
 * @author Alicia
 * @description
 * @date 2021/8/20
 */
public class CouponDecorator extends BaseCountDecorator{

    public CouponDecorator(IBaseCount count) {
        super(count);
    }

    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail){
        BigDecimal payTotalMoney = new BigDecimal(0);
        payTotalMoney = super.countPayMoney(orderDetail);
        payTotalMoney = countCouponPayMoney(orderDetail);
        return payTotalMoney;
    }

    private BigDecimal countCouponPayMoney(OrderDetail orderDetail) {
        BigDecimal coupon = orderDetail.getMerchandise().getPrice();
        System.out.println("优惠卷金额： "+coupon);
        orderDetail.setPayMoney(orderDetail.getPayMoney().subtract(coupon));
        return orderDetail.getPayMoney();
    }
}
