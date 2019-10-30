#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <iomanip>
using namespace std;

//函数指针（此函数中用到了f），x0、y0为起始点，xn为按步长增长的所求点，tims为计算次数
double RK(double(*f)(double x, double y), double x0, double y0, double xn, long tims)
{
	double k1, k2, k3, k4, result;
	double h = (xn - x0) / tims;
	if (tims <= 0)
		return(y0);
	if (tims == 1)
	{
		k1 = f(x0, y0);
		k2 = f(x0 + h / 2, y0 + h*k1 / 2);
		k3 = f(x0 + h / 2, y0 + h*k2 / 2);
		k4 = f(x0 + h, y0 + h*k3);
		result = y0 + h*(k1 + 2 * k2 + 2 * k3 + k4) / 6;
	}
	else//递归
	{
		double x1, y1;
		x1 = xn - h;
		y1 = RK(f, x0, y0, xn - h, tims - 1);
		k1 = f(x1, y1);
		k2 = f(x1 + h / 2, y1 + h*k1 / 2);
		k3 = f(x1 + h / 2, y1 + h*k2 / 2);
		k4 = f(x1 + h, y1 + h*k3);
		result = y1 + h*(k1 + 2 * k2 + 2 * k3 + k4) / 6;
	}
	return(result);
}

int main()
{
	double f(double x, double y);
	double x0, y0;
	double a, b;
	cout << "请输入初值x0,y0:";
	cin >> x0 >> y0;
	cout << "请输入区间：";
	cin >> a >> b;
	double x, steplen;
	long i;
	cout << "请输入步长：";
	cin >> steplen;
	cout.precision(10);//精度设置为10
	for (i = 0; i <= (b - a) / steplen; i++)
	{
		x = x0 + i*steplen;
		cout << setw(8) << x << setw(18) << RK(f, x0, y0, x, i) << endl;//宽度设置
	}
	system("pause");
	return(0);
}

double f(double x, double y)
{
	double r;
	r = y- 2*x/ y;
	return(r);
}