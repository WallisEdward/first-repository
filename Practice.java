public class Practice{
	public static long factorial1(long n){
		//终止条件1!==1  0!==1
		if (n==0||n==1){
			return 1;
		}
		//递推公式
		//n!==(n-1)!*n
		return factorial1(n-1)*n;

	}
	
	public static long factorial2(long n){
		//一共循环n次
		long fact = 1;
		for(long i=1;i<=n;i++){
			fact = fact * i;
		}
		return fact;
	}
	
	public static double calcE(int n){
		double e=0;
		for(int i = 0; i < n; i++){
			e = e + (1.0/factorial1(i));
		}
		return e;
	}
	//重载
	public static double calcE(double precision){
		double e = 0;
		int n = 0;
		while(true){
			double item = 1.0 / factorial1(n++);
			e += item;
			if(item < precision){
				break;
			}
		}
		return e;
	}
	
	//反转字符串
	public static String reverse(String s){
		int length = s.length();
		String r = "";
		for(int i = length - 1; i >= 0; i--){
			char ch = s.charAt(i); //取该字符串的第几个元素
			r = r + ch;//加？
		}
		return r;
	}
	
	//10进制转换16进制
	public static String decToHex(int dec){
		String hex = "";
		while(dec >= 16){
			int remainder = dec % 16;
			dec = dec / 16;
			
			if(remainder < 10){
				hex += remainder;
			}
			else{
				char ch = (char)('A'+(remainder-10)); //把10-15的数字转换为对应字母
				hex += ch;	
			}
		}
		
		if(dec!= 0){
				hex += dec;
			}											//最后一位直接附上
			
		return reverse(hex);
	}
	
	public static void main(String[] args){
		long n = 12;
		//求阶乘的方法
		//通过递归
		long fact1 = factorial1(n);
		System.out.printf("阶乘是%d%n",fact1);
		//通过循环
		long fact2 = factorial2(n);
		System.out.printf("阶乘是%d%n",fact2);
		//求e
		//计算多少项去求
		double e = calcE(10);
		System.out.printf("e=%f%n",e);
		//给定精度去求，要求最后一项的结果<精度
		e = calcE(1E-4);
		System.out.printf("e=%f%n",e);
		//10进制转换16进制
		System.out.printf(decToHex(21954));
		
		
		
	}
}