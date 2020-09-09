import java.io.*;
//雇员类
public class Employee {
    char name[] = {'\u0000','\u0000','\u0000','\u0000',
            '\u0000','\u0000','\u0000','\u0000',};
    //姓名字符数组，初始状态用8个Unico编码的空格填满
    //年龄
    int age;
    //构造函数
    public Employee(String name, int age)throws Exception{
        //如果字符长度大于8，只取前8个
        if (name.toCharArray().length > 8){
            System.arraycopy(name.toCharArray(),0,this.name,0,8);
        }
        else {
            //字符长度小于8，则有几个填几个
            System.arraycopy(name.toCharArray(),0,this.name,
                    0,name.toCharArray().length);

        }
        this.age = age;
    }
}
