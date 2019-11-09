import java.util.Random;
import java.util.Scanner;

public class HomeWork{
// 1. 编写程序数一下 1到 100 的所有整数中出现多少个数字9。
// public static void main(String[] args) {
//     int count = 0;
//     for (int i = 1; i < 101; i++) {
//         if (i % 10 == 9) {
//             count += 1;            
//         }
//     }
//    System.out.println(count);
// }

// 2. 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
// public static void main(String[] args) {
//     for (int i = 100; i < 1000; i++) {
//         int g = 0;
//         int s = 0;
//         int b = 0;
//         int sum = 0;
//         g = i % 10;
//         s = (i % 100 - g)/10;
//         b = i / 100;
//         sum = g*g*g + s*s*s + b*b*b;
//         if(i == sum){
//             System.out.println(i);}
//     }
// } 
// 153 370 371 407

// 3. 编写代码模拟三次密码输入的场景。 
// 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 
// 可以重新输入，最多输入三次。三次均错，则提示退出程序
// public static void main(String[] args) {
//     int num = 0;
//     String entry = "";
//     String password = "123456yes";
//     Scanner scanner = new Scanner(System.in);
//     System.out.println("请输入密码");
//     entry = scanner.nextLine();
//     for(num = 0; num < 2; num++){
//         if(password.equals(entry)){
//             System.out.println("登录成功");
//             break;
//         }else{
//                 System.out.println("密码错误，请重新输入");
//                 entry = scanner.nextLine();
//             }
//     }
//     if(num >= 2)
//     System.out.println("密码输入错误已达到上限，退出程序"); 
// } 

// 4. 写一个函数返回参数二进制中 1 的个数
// public static void main(String[] args) {
//     System.out.println(countOne(15));
// } 
// public static int countOne(int num) {
//     int count = 0;
//     while (num != 0) {
//        if( num % 2 == 1){
//            count++;
//        }
//        num = num/2;
//     }
//     return count;
// }
// 比如： 15 0000 1111 4 个 1 

// 5. 获取一个数二进制序列中所有的偶数位和奇数位， 
// 分别输出二进制序列。 
// public static void main(String[] args) {
//     printOder(15);
// }
 
// public static void printOder(int num) {
//     int[] arr = new int []{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//     int j = 0;
//     while(num!=0){
//         arr[j]=num % 2;
//         num = num / 2;
//         j++;
//     }
//     System.out.println("奇数序列");
//     for (int i = j-1; i >=0 ; i-=2) {
//         System.out.println(arr[i]);
//     }
   
//     System.out.println("偶数序列");
//     for (int i = j-2; i >=0 ; i-=2) {
//         System.out.println(arr[i]);
//     }
// }
// 6. 输出一个整数的每一位. 
// public static void main(String[] args) {
//     printNum(15);
// }
// public static void printNum(int num) {
//     String a = "";
//     while(num != 0){
//         a = num % 10+" "+a;
//         num = num/10;
//     }
//     System.out.println(a);
// }
// 7. 完成猜数字游戏 
public static void main(String[] args) {
    Random random = new Random();
    int toGuess = random.nextInt(100)+1;
    while(true){
        Scanner scanner = new Scanner(System.in);
        System.out.println("猜数：");
        int num = scanner.nextInt();
        if (num < toGuess) {
            System.out.println("低了");
        }else if(num > toGuess){
            System.out.println("高了");
        }else{
            System.out.println("猜对了");
            break;
        }
    }
    
}

}