#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#define simple 4

double *cha(double X[], int n)//计算相邻点的差值
{
	int i = 0;
	double *H = NULL;
	H = (double*)malloc((n - 1)*sizeof(double));
	for (i = 1; i <= n - 1; i++)
	{
		H[i - 1] = X[i] - X[i - 1];
	}
	return H;
}

double *sv(double Y[], int N, double H[])//计算比值
{
	int i = 0;
	double *D = NULL;
	D = (double*)malloc(N*sizeof(double));
	for (i = 0; i<N; i++)
	{
		D[i] = Y[i] / H[i];
	}
	return D;
}

int main()
{
	double X[simple] = { -1,0, 1, 2, }, Y[simple] = { -1.0, 0.0, 1.0, 0.0 }, S[simple][simple] = { 0 }, temp = 0.0, M[simple] = { 0 };
	int N = simple - 1, i = 0, k = 0;
	double A[simple - 1 - 2] = { 0 }, B[simple - 1 - 1] = { 0 }, C[simple - 1 - 1] = { 0 };
	double dx0 = 0.0, dxn = 1.0;
	double *H = NULL, *D = NULL, *U = NULL;
	printf("求解经过点（-1，-1.0），（0，0.0），（1，1.0）和（2，0.0）\n而且一阶导数边界条件S'(0)=0.0和S'(2)=1.0的三次压紧样条曲线\n\n");
	H = cha(X, simple);
	D = sv(cha(Y, simple), N, H);
	for (i = 1; i<N - 2; i++)
		A[i] = H[i + 1];
	for (i = 0; i<N - 1; i++)
		B[i] = 2 * (H[i] + H[i + 1]);
	for (i = 1; i<N - 1; i++)
		C[i] = H[i + 1];
	U = cha(D, N);
	for (i = 0; i<N; i++)
		U[i] = U[i] * 6;
	B[0] = B[0] - H[0] / 2;
	U[0] = U[0] - 3 * (D[0] - dx0);
	B[N - 2] = B[N - 2] - H[N - 1] / 2;
	U[N - 2] = U[N - 2] - 3 * (dxn - D[N - 1]);
	for (k = 2; k <= N - 1; k++)
	{
		temp = A[k - 2] / B[k - 2];
		B[k - 1] = B[k - 1] - temp*C[k - 2];
		U[k - 1] = U[k - 1] - temp*U[k - 2];
	}
	M[N - 1] = U[N - 2] / B[N - 2];
	for (k = N - 2; k >= 1; k--)
		M[k] = (U[k - 1] - C[k - 1] * M[k + 1]) / B[k - 1];
	M[0] = 3 * (D[0] - dx0) / H[0] - M[0] / 2;
	M[N] = 3 * (dxn - D[N - 1]) / H[N - 1] - M[N - 1] / 2;
	for (k = 0; k <= N - 1; k++)
	{
		S[k][0] = (M[k + 1] - M[k]) / (6 * H[k]);
		S[k][1] = M[k] / 2;
		S[k][2] = D[k] - H[k] * (2 * M[k] + M[k + 1]) / 6;
		S[k][3] = Y[k];
	}
	//printf("求得的三次压紧样条曲线的矩阵S为:\n");
	//for (i = 0; i<simple - 1; i++)
	//{
	//	for (k = 0; k<simple; k++)
		//{
		//	printf("%lf\t", S[i][k]);
		//}
		//printf("\n");
	//}
	for (i = 0; i<N; i++)
		printf("\n样条插值函数为:y=%+lfx^3%+lfx^2%+lfx%+lf", S[i][0], S[i][1], S[i][2], S[i][3]);
	getchar();
	system("pause");
	return 1;
}