public class Course{
	
	public static void printIsGreatThan10(int n){
		if (n>10){
			// Linux \n  Windows \r\n
			//回车用%n，不要直接用 \n
			System.out.printf("%d 是大于10的",n);
		}
	}
	
	public static void printColor(String color){
		switch(color){
			case"Red":
				System.out.println("红色");
				break;
			case"Yellow":
				System.out.println("黄色");
				break;
			default:
				System.out.println("未知颜色");
		
			
		}
	}
	
	public static void foreach(int[] array){
		for(int item:array){
			System.out.println(item);
		}
	}
	
	public static void displayMutipyCation(){
		for(int i = 1; i <= 9;i++){
			for(int j = 1; j <=i; j++){
				System.out.printf("%d*%d=%d ", i, j, i * j);
			}
			System.out.println();//回车
		}
	}
	
	public static void find(){
		int[] array={1,2,3,4,5,6,7};
		
		for (int i=0; i<array.length; i++)
		{
			if(array[i]==3){
				break;
			}
		}
		
		int [][] twoArray={
			{1,2,3},
				{4,5,6},
					{7,8,9},
		};
		
	found:
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(twoArray[i][j]==5){
					break found;//若不加标签则只跳出一层
					//continue也一样
				}
			}
		}
	}
	
	public static void hannoi(int n,int src,int dest)
	{
		if( n == 1)
		{
				System.out.printf("从%d移到%d%n",src,dest);
		}
		else
		{
			int other=3-src-dest;
			hannoi(n-1,src,other);
			System.out.printf("从%d移到%d%n",src,dest);
			hannoi(n-1,other,dest);
		}
	}
	
	//算一个数的位数
	public static int count(int num){
		int sum=0,n=1;
		if((num/10==0)&&(num%10>=0)){
			return n;
		}
		else{
			sum=count(num/10)+1;
			return sum;
			}
	}
	
	
	//求n的阶乘
	public static long factorial(long n)
	{
		long result=0;
		if(n==1||n==0){
			return 1;
		}
		else {
			result=factorial(n-1)*n;
			return result;
		}
	}
	
	
	//计算自然对数e
	public static double clce(double precision)
	{
		long n=0;
		while(((double)1/(double)factorial(n))>precision)
		{
				n=n+1;
		}
		
		double sum=0;
		
			for(long i=0;i<=n;i++){
			sum=((double)1/(double)factorial(i))+sum;
			}
			return sum;
	}
		
	//求pi，pi/4=1-1/3+1/5...
	public static double calcPi(double precision){
		double pi = 0;
		int n = 0;
		while(true){
			double item = 1.0 / (2*n+1);
			if(n % 2 == 0){
				pi += item;
			}
			else{
				pi -= item;
			}
			if(item < precision){
				break;
			}
			n++;
		}
		return 4*pi;
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
	
	//十进制转十六进制
	public static String dTH(int num){
		//首先要区分开十六进制的几个表示符号，即，若余数为0 1 2 3...9即正常表示
		//然鹅，为10=A 11=B 12=C 13=D 14=E 15=F
		//所以选择存储方式为字符串类型
		String r = "";
		char ch = '0';
		while((num!=0)){
		int yushu = num%16;
		int shang = num/16;
		switch(yushu){
		case 0:
			 ch = '0';
			 break;
		case 1:
			 ch = '1';
			 break;
		case 2:
			 ch = '2';
			 break;
		case 3:
			 ch = '3';
			 break;
		case 4:
			 ch = '4';
			 break;
		case 5:
			 ch = '5';
			 break;
		case 6:
			 ch = '6';
			 break;
		case 7:
			 ch = '7';
			 break;
		case 8:
			 ch = '8';
			 break;
		case 9:
			 ch = '9';
			 break;
		case 10:
			 ch = 'A';
			 break;
		case 11:
			 ch = 'B';
			 break;
		case 12:
			 ch = 'C';
			 break;
		case 13:
			 ch = 'D';
			 break;
		case 14:
			 ch = 'E';
			 break;
		case 15:
			 ch = 'F';
			 break;
		default:
			System.out.println("程序错误");
		}
		r = r + ch;
		num = shang;
		}
		return reverse(r);
	}
	
	//命令行参数 int main(int argc,char **argv){}
	
	public static void main(String[] args){
		printIsGreatThan10(100);
		printIsGreatThan10(9);
		
		printColor(args[0]);//传入一个字符串打印对应的颜色
		
		foreach(new int[]{1,3,4,6,7});
		
		displayMutipyCation();
		
		hannoi(6,0,2);
		
		System.out.println(count(1902387));//七位数
		//把string类型的数字找出来
		//long m=Long.parseLong(args[0]);
		//System.out.printf("%d一共有%d位 %n",m,count(m));需要转换long类型，修改函数的参数类型
		System.out.println(factorial(0));
		System.out.println(clce(((double)1/(double)6)));
		double s=((double)1/(double)6);
		System.out.println(s);
		System.out.println(((double)1/(double)factorial(3)));
		//给定精度去求pi,成功
		double pi = calcPi(0.2);
		System.out.printf("pi=%f%n",pi);
		
		//逆置字符串
		System.out.println(reverse("Hello"));
		//进制转换
		System.out.println(dTH(21954));
		
		
		
	}
	
	

	
}
