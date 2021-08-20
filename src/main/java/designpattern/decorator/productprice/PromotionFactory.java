package designpattern.decorator.productprice;

import java.math.BigDecimal;
import java.util.Map;

/**
 * PromotionFactory 计算促销后的支付价格
 *
 * @author Alicia
 * @description
 * @date 2021/8/20
 */
public class PromotionFactory {
    public static BigDecimal getPayMoney(OrderDetail orderDetail) {
        // 获取给商品设定的促销类型
        Map<PromotionType, SupportPromotions> supportPromotionslist = orderDetail.getMerchandise().getSupportPromotions();

        // 初始化计算类
        IBaseCount baseCount = new BaseCount();
        if (supportPromotionslist != null && supportPromotionslist.size() > 0){
            // 便利设置的促销类型，通过装饰起组合促销类型
            for (PromotionType promotionType : supportPromotionslist.keySet()){
                baseCount = promotion(supportPromotionslist.get(promotionType), baseCount);
            }
        }
        return baseCount.countPayMoney(orderDetail);
    }

    /**
     * 组合促销类型
     * @param supportPromotions
     * @param baseCount
     * @return
     */
    private static IBaseCount promotion(SupportPromotions supportPromotions, IBaseCount baseCount) {
        if (supportPromotions.getPromotionType() == PromotionType.COUPON){
            baseCount = new CouponDecorator(baseCount);
        }else if(supportPromotions.getPromotionType() == PromotionType.REDPACKED){
            baseCount = new RedPacketDecorator(baseCount);
        }
        return baseCount;
    }

    public static void main(String[] args) {
        Order order = new Order();
        init(order);

        for (OrderDetail orderDetail : order.getList()){
            BigDecimal payMoney = PromotionFactory.getPayMoney(orderDetail);
            orderDetail.setPayMoney(payMoney);
            System.out.println("最终支付金额： "+orderDetail.getPayMoney());
        }
    }

    private static void init(Order order) {
    }


}
