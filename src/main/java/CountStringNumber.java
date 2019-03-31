import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 统计给定文件中给定字符串的出现次数
 * Created by fifi on 2017/2/19.
 */
public class CountStringNumber {

    private CountStringNumber(){
        throw new AssertionError();
    }

    /**
     *
     * @param filename 文件名
     * @param word 字符串
     * @return 字符串出现的次数
     */
    public static int countWordInFile(String filename, String word) {
        int counter = 0;
        try (FileReader fr = new FileReader(filename)){
            try (BufferedReader br = new BufferedReader(fr)){
                String line = null;
                while ((line = br.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index == line.indexOf(word))){
                        counter ++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return counter;
    }
}
