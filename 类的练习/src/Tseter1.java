import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Tseter1 {
    
    public static void main(String[] args) {
        Student[] students;
        StudentClass aClass = new StudentClass("软件0201", 3);
        students = new Student[aClass.getSize()];
        for (int i = 0; i < aClass.getSize(); i++){
            students[i] = new Student(getAStudent(i + 1));
        }

        //StudentClass的setStudents方法形参为可变长参数，传入实参为数组
        aClass.setStudents(students);
        String sss = aClass.toString();
        System.out.println(aClass);
//        //将学生信息保存到文件stu.ser中
//        try {
//            FileOutputStream fo = new FileOutputStream("stu.ser");
//            ObjectOutputStream so = new ObjectOutputStream(fo);
//            //使用增强for循环遍历数组
//            for(Student s:students){
//                so.writeObject(s);
//            }
//            so.close();
//        }catch (Exception e){
//            System.out.println(e);
//        }
    }
    public static Student getAStudent(int i){
        Student studenti;
        System.out.println("输入第"+ i + "个学生的信息：");
        System.out.print("学号");
        String id = KeyBoard.getString();
        System.out.print("姓名");
        String name = KeyBoard.getString();
        System.out.print("英语成绩");
        int eng = KeyBoard.getInteger();
        System.out.print("数学成绩");
        int math = KeyBoard.getInteger();
        System.out.print("计算机成绩");
        int comp = KeyBoard.getInteger();
        studenti = new Student(id,name,eng,math,comp);
        return studenti;
    }
}
