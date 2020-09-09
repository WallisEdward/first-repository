import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        String str = in.next();
        int k = in.nextInt();
        System.out.println("加密：");
        encryption(k,str);
        System.out.println();
        System.out.println("解密：");
        decryption(k,str);
    }

    public static void encryption(int k, String str){
        if (k<1 || k >25){
            System.out.println("输入不合法");
            return;
        }
        char[] chars = new char[100];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
            chars[i] = (char)((str.charAt(i)- 97 + k)%26 + 97);
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(chars[i] + "");
        }
    }

    public static void decryption(int k, String str){
        if (k<1 || k >25){
            System.out.println("输入不合法");
            return;
        }
        char[] chars = new char[100];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
            chars[i] = (char)((str.charAt(i)- 97 + (26-k))%26 + 97);
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(chars[i] + "");
        }
    }
}
