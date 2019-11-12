public class HomeWork{
// 2. 实现代码: 递归求 N 的阶乘 
 public static void main(String[] args) {
//     System.out.println(factor(3));
        // System.out.println(Sum(10));
        // printNum(1234);
        System.out.println(numSum(1234)); 
 }
// public static int factor(int n) {

//     if(n == 1){
//         return 1;
//     }

//     int ret = n * factor(n-1);
//     return ret;
// }
// 3. 实现代码: 递归求 1 + 2 + 3 + ... + 10 
// public static int Sum(int n) {

//     if(n == 1){
//                  return 1;
//              }

//     int ret = n + Sum(n-1);
//      return ret;
// }
// 4. 实现代码: 按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) 
public static void printNum(int n) {
    int[] arr = new int[30];
    int i = 0;
    while(n > 0){
        arr[i] = n % 10;
        n = n / 10;
        i=i+1;
    }

    for (int j = i-1;j >= 0; j--) {
        System.out.println(arr[j]);
    }
    
}

// 5. 实现代码: 写一个递归方法，输入一个非负整数，返回组成它的数字之和.
 public static int numSum(int n) {
        if( n/10 == 0){
            return n;
        }

        int sum =0;
        sum = n%10 + numSum(n/10);
        return sum;  
 }

}
