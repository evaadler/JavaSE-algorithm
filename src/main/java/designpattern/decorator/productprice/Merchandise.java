package designpattern.decorator.productprice;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Merchandise 商品
 * 商品信息中包含了促销类型信息，一个商品可以包含多个促销类型
 *
 * @author Alicia
 * @description
 * @date 2021/8/20
 */
public class Merchandise {
    private String sku;//商品SKU
    private String name; //商品名称
    private BigDecimal price; //商品单价
    private Map<PromotionType, SupportPromotions> supportPromotions; //支持促销类型

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Map<PromotionType, SupportPromotions> getSupportPromotions() {
        return supportPromotions;
    }

    public void setSupportPromotions(Map<PromotionType, SupportPromotions> supportPromotions) {
        this.supportPromotions = supportPromotions;
    }
}
