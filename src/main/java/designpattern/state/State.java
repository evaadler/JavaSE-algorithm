package designpattern.state;

/**
 * State
 *
 * @author Alicia
 * @description
 * @date 2021/4/10
 */
public abstract class State {
    // 扣除积分
    public abstract void deductMoney();

    // 是否抽中奖品
    public abstract boolean raffle();
    // 发放奖品
    public abstract void dispensePrize();
}
