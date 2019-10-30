#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <iomanip>
using namespace std;

//����ָ�루�˺������õ���f����x0��y0Ϊ��ʼ�㣬xnΪ����������������㣬timsΪ�������
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
	else//�ݹ�
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
	cout << "�������ֵx0,y0:";
	cin >> x0 >> y0;
	cout << "���������䣺";
	cin >> a >> b;
	double x, steplen;
	long i;
	cout << "�����벽����";
	cin >> steplen;
	cout.precision(10);//��������Ϊ10
	for (i = 0; i <= (b - a) / steplen; i++)
	{
		x = x0 + i*steplen;
		cout << setw(8) << x << setw(18) << RK(f, x0, y0, x, i) << endl;//�������
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