import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by fifi on 2017/2/19.
 */
public class FileManage {
    public static void main(String[] args) {
        listCurFiles();
    }

    /**
     * 列出当前文件夹下的文件
     */
    public static void listCurFiles(){
        File file = new File("/Users/fifi/Downloads");
        for (File temp : file.listFiles()){
            if(temp.isFile()){
                System.out.println(temp.getName());
            }
        }
    }

    public static void showDirectory(){
        File file = new File("/Users/fifi/Downloads");
        reverseDirectory(file, 0);
    }

    private static void reverseDirectory(File file, int level){
        if(file.isDirectory()){
            for (File temp : file.listFiles()){
                reverseDirectory(temp, level + 1);
            }
        }else {
            for (int i = 0; i < level - 1; i++){
                System.out.println("\t");
            }
            System.out.println(file.getName());
        }
    }

    /**
     * NIO 的方式实现
     * @throws IOException
     */
    public static void showFilesByNIO() throws IOException {
        Path initPath = Paths.get("/Users/fifi/Downloads");
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
        });

    }


}
