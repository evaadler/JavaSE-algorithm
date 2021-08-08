package tips;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;


/**
 * @author fifi
 */
public class AppTest{
  public static String loadFile(String path) throws Exception{
    Reader in = new FileReader(path);
    BufferedReader br = new BufferedReader(in);

    String line;
    StringBuilder sb = new StringBuilder();

    while ((line = br.readLine()) != null){
      sb.append(line);
    }

    br.close();
    return sb.toString();
  }

  public static void main(String[] args) throws Exception {
    String str = loadFile("");
    String[] strs = str.split("[^a-zA-Z]");
    System.out.println(strs.length);
  }
}