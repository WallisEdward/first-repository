import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTester {
    public static void main(String[] args) {
        String fileName = "C:/Hello.txt";
        String line;
        try{
            //创建文件输入流并放入缓冲流当中
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            //读取一行内容
            line = in.readLine();
            //控制循环条件直到循环终点
            while (line != null){
                System.out.println(line);
                line = in.readLine();
            }
            //关闭缓冲流，文件输入流自动也被关闭
            in.close();
        }catch (IOException iox){
            //如出现I/O异常则进入本快处理
            System.out.println("Promble reading" + fileName);
        }
    }
}
