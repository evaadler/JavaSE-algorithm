package cleancode.old.fitness;



/**
 * SimpleResponse
 *
 * @author Alicia
 * @description
 * @date 2020/6/11
 */
public class SimpleResponse extends Response{

    private int maxAge;
    private String content;

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
