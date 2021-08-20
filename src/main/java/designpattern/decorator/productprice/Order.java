package designpattern.decorator.productprice;

import jdk.nashorn.internal.objects.annotations.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Order 主订单
 * 主订单包含若干详细订单，详细订单中记录了商品信息，商品信息中包含了促销类型信息，
 * 一个商品可以包含多个促销类型（本案例只讨论单个促销和组合促销
 *
 * @author Alicia
 * @description
 * @date 2021/8/20
 */

public class Order {
    private int id; //订单ID
    private String orderNo; //订单号
    private BigDecimal totalPayMoney; //总支付金额
    private List<OrderDetail> list; //详细订单列表

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getTotalPayMoney() {
        return totalPayMoney;
    }

    public void setTotalPayMoney(BigDecimal totalPayMoney) {
        this.totalPayMoney = totalPayMoney;
    }

    public List<OrderDetail> getList() {
        return list;
    }

    public void setList(List<OrderDetail> list) {
        this.list = list;
    }
}
