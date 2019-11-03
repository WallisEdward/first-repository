#include<stdio.h>
#include<math.h>

double f(double x);
void main()
{
	int P = 1, m = 0, U = 0,V = 0, i = 0, j = 0, n = 0;
	double  inerro = 1.0, ap = 0.0, sum = 0.0, x = 0.0;
	double R[20][20] = { 0 };

	double a = 0;
	double b = 1;
	double h = b - a;
	double n = 2;
	double epslon = 0.000001;

	printf("求解函数y=x*x在(0,1)上的龙贝格三角表\n");
	printf("误差限为%lf\n", epslon);

	R[0][0] = h*(f(a) + f(b)) / 2;

	while (((inerro>epslon) && (U<n)) || (U<2))
	{
		U = U + 1;
		h = h / 2;

		sum = 0;
		for (m = 1; m <= P; m++)
		{
			x = a + h*(2 * m - 1);
			sum = sum + f(x);
		}

		R[U][0] = R[U - 1][0] / 2 + h*sum;

		P = 2 * P;

		for (V = 1; V <= U; V++)
		{
			R[U][V] = R[U][V - 1] + (R[U][V - 1] - R[U - 1][V - 1]) / (pow(4.0, V) - 1);//pow求4的V次方
		}
		
		inerro = fabs(R[U - 1][U - 1] - R[U][V]);
	}

	ap = R[U][U];

	printf("\n龙贝格三角形为:\n");
	for (i = 0; i<(U + 1); i++)
	{
		for (j = 0; j<(U + 1); j++)
		{
			printf("%.5lf ", R[i][j]);
		}
		printf("\n");
	}

	printf("\n积分值为:ap=%lf", ap);
	getchar();
}

double f(double x)
{
	return x*x;
}