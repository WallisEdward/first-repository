
import java.util.Arrays;

public class ArrayPractice {
public static void main(String[] args) {

    // 数组转字符串
    // int[] arr = {1,2,3,4};
    // String a = Arrays.toString(arr);
    // System.out.println(a);

    //数组拷贝
    // int[] arr = {1,2,3,4};
    // int[] a = Arrays.copyOf(arr,arr.length);
    // arr[0] = 2;
    // String a1 = Arrays.toString(a);
    // System.out.println(a1);

    //找数组中的最大元素
    // int[] arr = {1,2,3,4};
    // System.out.println(max(arr));

    //求数组中元素的平均值
    // int[] arr = {1,2,3,4};
    // System.out.println(average(arr));

    //查找数组中指定元素（顺序查找）
    // int[] arr = {1,2,3,4};
    // System.out.println(find(arr,4));

    //查找数组中指定元素（二分查找）
    // int[] arr = {1,2,3,4,5,6,7,8,9};
    // System.out.println(binaryChop(arr,2));

    //检查数组的序性
    // int[] arr = {1,2,3,4,5,6,7,8,9};
    // System.out.println(isOrder(arr)); 

    //数组排序（冒泡排序）
    // int[] arr = {9,1,3,5,3,8,10,2};
    // String arr1 = Arrays.toString(bubbleSort(arr));
    // System.out.println(arr1);

    //数组逆序
    // int[] arr = {1,2,3,4,5,6,7,8,9};
    // String arr1 = Arrays.toString(invertedArray(arr));
    // System.out.println(arr1);

    //数组数字排序（将所有偶数放在前，奇数放在后）
    // int[] arr = {1,2,3,4,5,6,7,8,9};
    // System.out.println(Arrays.toString(oderArray(arr)));
}
public static int[] oderArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int tmp = 0;
        while(left < right){
            if (left < right && arr[left]%2 == 0) {
                left++;
            }
            if (left < right && arr[right]%2 != 0) {
                right--;
            }
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }

        return arr;
}

// public static int[] invertedArray(int[] arr) {
//     int left = 0;
//     int right = arr.length-1;
//     int tmp = 0;
//    while (left < right) {
//        tmp = arr[left];
//        arr[left] = arr[right];
//        arr[right] = tmp;
//        left++;
//        right--;
//    }
//    return arr;
// }

// public static int[] bubbleSort(int[] arr) {
//     int tmp =0;
//     for(int j = 0;j < arr.length;j++){
//         for (int i = 0; i < arr.length-1-j; i++) {
//             if (arr[i] > arr[i+1]) {
//                 tmp = arr[i+1];
//                 arr[i+1] = arr[i];
//                 arr[i] = tmp;
//             }
//     }
//     }
//     return arr;
// }

// public static boolean isOrder(int[] arr) {
//     for (int i = 0; i < arr.length-1; i++) {
//         if (arr[i] > arr[i+1]) {
//             return false;
//         }
//     }
//     return true;
// }

// public static int binaryChop(int[] arr, int a) {
//     int right = arr.length -1;
//     int left = 0;
//     int mid = arr.length/2;
//     int index = 0;
//     while(true){
//         if (arr[mid] > a) {
//             right = mid;
//             mid = (right+left)/2;
//         } 
//         if (arr[mid] < a) {
//             left = mid;
//             mid = (right+left)/2;
//         }
//         if (arr[mid] == a) {
//             break;
//         }
//     }

//     index = mid;
//     return index;
// }

// public static int find(int[]arr,int a) {
//     int index = 0;
//     for (int i = 0; i < arr.length; i++) {
//         if (arr[i] == a) {
//         index = i;
//         }
//     }
//     return index;
// }
// public static double average(int[] arr) {
//     int sum = 0;
//     int len = arr.length;
//     for (int i = 0; i < len; i++) {
//         sum += arr[i];
//     }
//     return (double)sum/(double)len;
// }
// public static int max(int[] arr) {
//     int max = arr[0];
//     for (int i = 0; i < arr.length; i++) {
//         if (arr[i]>max) {
//             max = arr[i];
//         }
//     }
//     return max;
// }
// public static void copyOf(int[]a,int n) {
//     int[] ret = new int[a.length];
//     for (int i = 0; i <a.length ; i++) {
//         ret[i] = a[i];
//     } 
// }

}