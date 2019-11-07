#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>


double f(double x);
double MOB(double a, double b, double eps, double(*f)(double x));

void main()
{
	double a = 0.0, b = 0.0, eps = 0.0;
	printf("�ö��ַ�Ѱ�ҷ���x^2-2x+1=0�ĸ�\n");
	printf("�����뾫��eps= \n");
	scanf("%lf", &eps);
	printf("����������˵�Ϊa= \n");
	scanf("%lf", &a);
	printf("���������Ҷ˵�Ϊb= \n");
	scanf("%lf", &b);
	printf("���̵Ľ��Ƹ�Ϊ:X = %lf\n", MOB(a, b,eps, f));
		getchar();
		system("pause");

}
double f(double x)//�����洢
{
	return x*exp(x) - 1;
}
double MOB(double a, double b, double eps,double(*f)(double x))//���ַ��㷨
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