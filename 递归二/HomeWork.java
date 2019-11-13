public class HomeWork{
// private static int count = 0;
   public static void main(String[] args) {
   // System.out.println(FibN(4));
//    String A = "A";
//    String B = "B";
//    String C = "C";
//    hanoi(3, A, B, C);
//   System.out.println(count);
//System.out.println(upSteps(4));
}

// 1. 实现代码: 求斐波那契数列的第 N 项 
// public static int FibN(int N) {
//     int result;
//     if(N==1||N==2){
//         return 1;
//     }
//     result = FibN(N-1)+FibN(N-2);
//     return result;
// }

// 2. 实现代码: 求解汉诺塔问题(提示, 使用递归) 
// 汉诺塔问题是一个经典的问题。汉诺塔（Hanoi Tower），又称河内塔，源于印度一个古老传说。 
// 大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。 
// 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。 
// 并且规定，任何时候，在小圆盘上都不能放大圆盘，且在三根柱子之间一次只能移动一个圆盘。 
// 问应该如何操作？ 
//    public static void move(int n,String a,String b) {
//       System.out.println("将第"+n+"个盘子从"+a+"移到"+b);
//    }
//    public static void hanoi(int n,String A,String B,String C) {
//       count++;
//       if (n == 1) {
//          move(1,A,B);
//          return;
//       } else {
//          hanoi(n-1,A,C,B);
//          move(n,A,B);
//          hanoi(n-1,C,B,A);
//          return;
//       }
//    }

// 8. 实现代码: 青蛙跳台阶问题(提示, 使用递归) 
// 一只青蛙一次可以跳上 1 级台阶，也可以跳上2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法 
 public static int upSteps(int n) {
     if (n == 1) {
         return 1;
     }
     if (n == 2) {
         return 2;
     }
         return upSteps(n-1)+upSteps(n-2);
 }

}