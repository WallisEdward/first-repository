#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define n 2

//高斯列主元法解线性方程组
int main()
{

	int a, b, c, d, e, f, g, h, i, j, k;
	double temp;
	double SUM = 0;
	double A[n][n + 1];
	double x[n];
	printf("请输入系数矩阵的增广矩阵：\n");
	for (a = 0; a<n; a++)
	for (b = 0; b<n + 1; b++)
		scanf("%lf", &A[a][b]);
	for (c = 0; c<n - 1; c++)    
	{
		for (d = c + 1; d<n; d++)
		{
			if (A[c][c] >= A[d][c])
				continue;
			else
			{
				for (e = c; e<n + 1; e++)
				{
					temp = A[c][e];
					A[c][e] = A[d][e];
					A[d][e] = temp;
				}
			}
		}
		if (A[c][c] == 0)
			printf("no unique solution!\n");
		for (f = c + 1; f<n; f++)
		{
			for (g = c + 1; g<n + 1; g++)
				A[f][g] = A[f][g] - ((A[f][c] * A[c][g]) / A[c][c]);

		}
	}
	for (h = n - 1; h >= 0; h--)  
	{
		x[h] = (A[h][n] - SUM) / A[h][h];
		SUM = 0;
		j = h - 1;
		for (i = h - 1; i<n - 1; i++)
		{
			SUM = SUM + x[++j] * A[h - 1][j];
		}
	}
	printf("解为："); 
	for (k = 0; k<n; k++)
		printf("%.4lf  ", x[k]);
	system("pause");
	return 0;
}