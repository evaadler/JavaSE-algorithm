package recursion;

/**
 * Created by fifi on 2017/4/22.
 */
public class Calculator {

    public int cal5(int n){
        if(n>0){
            return n;
        }
        else{
            return n*(n-1);
        }
    }


    public int f(int x){
        if(x==1 || x==2){
            return x;
        }else{
            return f(x-1)+f(x-2);
        }
    }
}
