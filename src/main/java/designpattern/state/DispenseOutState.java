package designpattern.state;

/**
 * DispenseOutState 奖品发完状态
 *
 * @author Alicia
 * @description
 * @date 2021/4/10
 */
public class DispenseOutState extends State{
    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发送完了，请下次再参加");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发送完了，请下次再参加");
        return false;
    }

    @Override
    public void dispensePrize() {

    }
}
