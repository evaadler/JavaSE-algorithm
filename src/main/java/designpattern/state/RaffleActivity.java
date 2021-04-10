package designpattern.state;

/**
 * RaffleActivity
 *
 * @author Alicia
 * @description
 * @date 2021/4/10
 */
public class RaffleActivity {
    // 当前状态
    State state = null;
    int count = 0;
    // 四个属性表示四种状态
    State noRaffleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);
    State dispenseState = new DispenseState(this);
    State dispenseOutState = new DispenseOutState(this);

    public RaffleActivity(int count) {
        this.state = getNoRaffleState();
        this.count = count;
    }

    public void debuctMoney(){
        state.deductMoney();
    }

    public void raffle(){

    }

    public State getCanRaffleState() {
        return null;
    }

    public void setState(Object canRaffleState) {

    }

    public State getDispenseState() {
        return null;
    }

    public State getNoRaffleState() {
        return null;
    }

    public int getCount() {
        int curCount = count;
        count--;
        return curCount;
    }
}
