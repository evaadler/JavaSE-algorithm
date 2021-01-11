/**
 * TestException
 *
 * @author Alicia
 * @description
 * @date 2020/8/13
 */
public class TestException {

    public static void main(String[] args) {
        int y = 0;
        try{
            for(int i=0; i<5; i++){
                if (i == 3){
                    y = i/0;
                }
                System.out.println(i);
            }
        }catch (Exception ex){
            System.out.println("exception happen");
        }

    }
}
