import java.io.*;
public class CopyMaker {
    //声明类
    String sourceName,destName;
    BufferedReader source;
    BufferedWriter dest;
    String line;

    //这个私有方法用来打开源文件和目的文件，无异常返回true
    private boolean openFiles() {
        try {
            //打开源文件
            source = new BufferedReader(new FileReader(sourceName));
        }catch(IOException iox) {
            //出现异常显示错误信息
            System.out.println("Problem opening" + sourceName);
            return false;
        }
        try{
            //打开目的文件
            dest = new BufferedWriter(new FileWriter(destName));
        }catch (IOException iox){
            System.out.println("Problem opening" + destName);
            return false;
        }
        return true;
    }

    //这个私有方法用来复制文件，无异常返回true
    private boolean copyFiles(){
        try {
           //从源文件读取数据
           line = source.readLine();
           //一直读到文件末尾
           while (line != null){
               //向目的文件写一行数据
               dest.write(line);
               //在此行数据末尾换行，保持和源文件相同的格式
               dest.newLine();
               //读下一行数据，如到文件末尾，则line为null
               line = source.readLine();
           }
        }catch(IOException iox){
            System.out.println("Promble reading or writing");
            return false;
        }
        return true;
    }

    //这个私有方法用来关闭文件，无异常返回true
    private boolean closeFiles(){
        boolean retVal = true;
        try {
            source.close();
        }catch (IOException iox){
            System.out.println("Problem closing" + sourceName);
            retVal = false;
        }
        try {
            dest.close();
        }catch (IOException iox){
            System.out.println("Problem closing" + destName);
            retVal = false;
        }
        return retVal;
    }

    //公有方法，需要两个字符参数
    public boolean copy(String src, String dst){
        sourceName = src;
        destName = dst;
        //调用三个私有方法，都正常返回true，有问题返回false显示出错信息
        return openFiles()&&copyFiles()&&closeFiles();
    }
}
