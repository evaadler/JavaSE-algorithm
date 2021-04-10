package designpattern.state;

import algorithms.RandNumber;

import java.util.Random;

/**
 * CanRaffleState
 *
 * @author Alicia
 * @description
 * @date 2021/4/10
 */
public class CanRaffleState extends State{
    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("已经扣取过积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等！");
        Random r = new Random();
        int num = r.nextInt();
        // %10的中奖机会
        if (num == 0){
            activity.setState(activity.getDispenseState());
            return true;
        }else{
            System.out.println("很遗憾没有抽中奖品！");
            // 改变状态为不能抽奖
            activity.setState(activity.getNoRaffleState());
            return false;
        }

    }

    @Override
    public void dispensePrize() {

    }
}
