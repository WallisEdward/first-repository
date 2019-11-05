#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>
#include<stdlib.h>
#define N 4

int main()
{
	double x[N] = { 0 }, b[N], a[N][N + 1];
	double eps = 1e-6;
	int n, j, maxtim = 500;

	printf("请输入是几元方程组\n");
	scanf("%d", &n);

	printf("请输入系数矩阵的增广矩阵\n");
	for (int i = 0; i < n; i++){
		for (int j = 0; j < n + 1; j++){
			scanf("%lf", &a[i][j]);
		}
			
	}
		

	//for(int i = 0; i < n; i++)
	//{
	//	for(int j = 0; j < n + 1; j++)  printf("%-15f", a[i][j]);
	//	printf("\n");
	//}
	printf("\n\n迭代序列为");
	for (j = 0; j < maxtim; j++)
	{
		double fanshu = 0;

		for (int i = 0; i < n; i++)
		{
			double sum = 0;
			for (int j = 0; j < n; j++)  {
				if (j != i){
					sum += a[i][j] * x[j];
				}
					
			}

			b[i] = (a[i][n] - sum) / a[i][i];  //迭代公式

			if (fabs(b[i] - x[i]) > fanshu) {
				fanshu = fabs(b[i] - x[i]);
			}
				
		}
		printf("\nk = %2d  x =  ", j + 1);
		for (int i = 0; i < n; i++) {
			printf("%-15f", b[i]);
		} 
		for (int i = 0; i < n; i++) {
			x[i] = b[i];
		}
			
		if (fanshu < eps)  
			break;
	}
	
	printf("\n\n得到解为");
	if (j < maxtim)
	{
		printf("\n\nk = %d\n", j + 1);
		for (int i = 0; i < n; i++){
			printf("x%d = %-15f\n", i + 1, x[i]);
		}
	}else{
		printf("\n\n计算失败\n");
	} 

	system("pause");
	return 0;
}
