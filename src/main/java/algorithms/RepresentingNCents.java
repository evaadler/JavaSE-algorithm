package algorithms;

/**
 * Created by fifi on 2017/4/18.
 */
public class RepresentingNCents {
    int makeChange(int n) {
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[n + 1][denoms.length]; //precomputed vals
        return makeChange(n, denoms, 0, map);
    }

    int makeChange(int amount, int[] denoms, int index, int[][] map) {
        if(map[amount][index] > 0) { //retrieve value
            return map[amount][index];
        }
        if(index >= denoms.length - 1) return 1; //one denom remaining
        int denomAmount = denoms[index];
        int ways = 0;
        for(int i = 0; i * denomAmount <= amount; i++) {
            //go to next denom, assuming i coints of denomAmount
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1, map);
        }
        map[amount][index] = ways;
        return ways;
    }

    public static void main(String[] args){
        RepresentingNCents rn = new RepresentingNCents();
        int num = rn.makeChange(10);
        System.out.println(num);
    }
}
