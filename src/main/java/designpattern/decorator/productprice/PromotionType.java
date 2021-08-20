package designpattern.decorator.productprice;

/**
 * PromotionType 促销类型
 *
 * @author Alicia
 * @description
 * @date 2021/8/20
 */
public class PromotionType implements Cloneable{
    public static final int REDPACKED = 0;
    public static final int COUPON = 1;
    private int id; // 该商品促销的 id
    private PromotionType promotionType; // 促销类型：1 优惠卷 2 红包
    private int priority; // 优先级
    private UserCoupon userCoupon; // 用户领取该商品的优惠卷
    private UserRedPacket userRedPacket; // 用户领取该商品的红包

    @Override
    protected SupportPromotions clone() throws CloneNotSupportedException {
        SupportPromotions supportPromotions = null;
        supportPromotions = (SupportPromotions) super.clone();
        return supportPromotions;
    }
}
