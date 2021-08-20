package designpattern.decorator.productprice;

import java.math.BigDecimal;

/**
 * RedPacketDecorator
 *
 * @author Alicia
 * @description
 * @date 2021/8/20
 */
public class RedPacketDecorator extends BaseCountDecorator{

    public RedPacketDecorator(IBaseCount count) {
        super(count);
    }

    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail) {
        BigDecimal payTotalMoney = new BigDecimal(0);
        payTotalMoney = super.countPayMoney(orderDetail);
        payTotalMoney = countRedPacketPayMoney(orderDetail);
        return payTotalMoney;
    }

    private BigDecimal countRedPacketPayMoney(OrderDetail orderDetail) {
        BigDecimal redPacket = orderDetail.getMerchandise()
                .getSupportPromotions().get(PromotionType.REDPACKED).getUserRedPacket().getRedPacket();

    }
}
