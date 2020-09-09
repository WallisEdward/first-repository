import java.io.RandomAccessFile;

public class RandomAccessFileTester {
    String Filename;
    public RandomAccessFileTester(String Filename){
        this.Filename = Filename;
    }
    //写第n条记录
    public void writeEmployee(Employee e, int n)throws Exception{
        RandomAccessFile ra = new RandomAccessFile(Filename,"rw");
        //将位置指示器移到指定位置上
        ra.seek(n*20);
        for (int i = 0; i < 8; i++) {
            ra.writeChar(e.name[i]);
        }
        ra.writeInt(e.age);
        ra.close();
    }

    //读第n条记录
    public void readEmployee(int n)throws Exception{
        char buf[] = new char[8];
        RandomAccessFile ra = new RandomAccessFile(Filename,"r");
        ra.seek(n*20);
        for (int i = 0; i < 8; i++){
            buf[i] = ra.readChar();
        }
        System.out.print("name:");
        System.out.println(buf);
        System.out.println("age" + ra.readInt());
        ra.close();
    }

    public static void main(String[] args) throws Exception{
        RandomAccessFileTester t = new RandomAccessFileTester("1.txt");
        Employee e1 = new Employee("ZhangSantt",23);
        Employee e2 = new Employee("小不点",34);
        Employee e3 = new Employee("王华",19);
        //写入第一个雇员为第0条记录
        t.writeEmployee(e1,0);
        t.writeEmployee(e3,2);
        System.out.println("第一个雇员信息");
        //读取第一条信息
        t.readEmployee(0);
        System.out.println("第三个雇员信息");
        t.readEmployee(2);
        t.writeEmployee(e2,1);
        System.out.println("第二个雇员信息");
        t.readEmployee(1);
    }
}
