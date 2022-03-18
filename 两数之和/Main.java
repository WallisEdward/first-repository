import java.util.*;
public class Main {
    //题目：字符串A和字符串B，有多少种插入办法可以使
    // 将字符串B插入字符串A使产生的字符串是一个回文串
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int count = 0;
        for(int i = 0; i <= str1.length(); i ++){
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i,str2);
            if(huiWen(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean huiWen(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i)!= s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;

    }
}
