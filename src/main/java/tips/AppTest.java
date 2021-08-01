public class AppTest{
  public static void main(String[] args) {
    String s = "京"；
    byte[] bb = s.getBytes("gbk");
    System.out.println(Arrays.toString(bb));
    
    byte[] bb2 = s.getBytes("unicode");
    System.out.println(Arrays.toString(bb2));
  }
}