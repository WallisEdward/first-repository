#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>


double f(double x);
double MOB(double a, double b, double eps, double(*f)(double x));

void main()
{
	double a = 0.0, b = 0.0, eps = 0.0;
	printf("用二分法寻找方程x^2-2x+1=0的根\n");
	printf("请输入精度eps= \n");
	scanf("%lf", &eps);
	printf("隔根区间左端点为a= \n");
	scanf("%lf", &a);
	printf("隔根区间右端点为b= \n");
	scanf("%lf", &b);
	printf("方程的近似根为:X = %lf\n", MOB(a, b,eps, f));
		getchar();
		system("pause");

}
double f(double x)//函数存储
{
	return x*exp(x) - 1;
}
double MOB(double a, double b, double eps,double(*f)(double x))//二分法算法
{
	double i = 0.0, j = 0.0, k = 0.0, c = 0.0;
	i = f(a);
	j = f(b);
	while ((b - a) > eps)
	{
		c = (a + b) / 2;
		k = f(c);

		if (k == 0){
			break;
		}
			
		else if (k*j < 0){
			a = c;
			i = k;
		}
		else{
			b = c;
			j = k;
		}
	}

	return b;
}