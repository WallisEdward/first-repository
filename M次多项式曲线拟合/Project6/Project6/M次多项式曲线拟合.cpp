#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#define Z 30

void inv(double X[Z][Z], int n, double E[Z][Z]);

void main()
{

	int  m = 0, n = 0, a = 0, b = 0, c = 0;

	double x[Z] = { 0 }, y[Z] = { 0 }, G[Z][Z] = { 0 }, B[Z] = { 0 };

	double A[Z][Z] = { 0 }, BG[Z][Z] = { 0 }, E[Z][Z] = { 0 }, C[Z] = { 0 };

	printf("��������ϵĵ�ĸ���:");

	scanf("%d",&n);

		printf("\n������%d�����x����:\n", n);

		for (a = 0; a < n; a++){
			scanf("%lf", &x[a]);
		}
		
	printf("\n������%d�����y����:\n", n);

	for (a = 0; a < n; a++)
	{
		scanf("%lf", &y[a]);
	}

	printf("\n��������ϴ���:");

	scanf("%d", &m);

	for (a = 0; a<n; a++)
		for (c = 1; c <= m + 1; c++)
			G[a][c - 1] = pow(x[a], c - 1);

		//��G��ת��
		for (a = 0; a<n; a++)
		{
			for (b = 0; b<m + 1; b++)
			{
				BG[b][a] = G[a][b];
			}
		}


		//����G ����ת�õ�BG�ĳ˻�
		for (a = 0; a<m + 1; a++)
			for (b = 0; b<m + 1; b++)
				for (c = 0; c<n; c++)
					A[a][b] += BG[a][c] * G[c][b];

		//����G��ת��BG��y�ĳ˻�
		for (a = 0; a<m + 1; a++)
			for (b = 0; b<n; b++)
				B[a] += BG[a][b] * y[b];

		inv(A, n, E);

		//����A����E��B�ĳ˻�
		for (a = 0; a < m + 1; a++){
			for (b = 0; b < n; b++){
				C[a] += E[a][b] * B[b];
			}
				
		}
			
		printf("\n��Ϻ��%d�ζ���ʽϵ��Ϊ: \n", c);

		for (a = m; a >= 0; a--){
			printf("%lf\t", C[a]);
		}
		printf("\n");

		printf("\n��Ϻ��%d�ζ���ʽΪ:\n", c);

		printf("\nP(x)=");

		for (a = m; a >= 0; a--)
		{
			if (a == 0)
				printf("% +.3lf\n", C[a]);
			else
				printf("% +.3lf*x^%d",C[a], a);
		}
		getchar();

		system("pause");
}

//XΪ���������EΪ�����
void inv(double X[Z][Z], int n, double E[Z][Z])

{

	int a = 0, b = 0, c = 0;

	double mid = 0.0;

	for (a = 0; a<Z; a++)

	{

		for (b = 0; b<Z; b++)

		if (a == b)

			E[a][b] = 1;

	}

	for (a = 0; a<n - 1; a++)

	{

		mid = X[a][a];

		for (b = 0; b<n; b++)

		{

			X[a][b] = X[a][b] / mid;

			E[a][b] = E[a][b] / mid;

		}

		for (c = 0; c<n; c++)

		{

			if (c == a)

				continue;

			mid = -X[a][a] * X[c][a];

			for (b = 0; b<n; b++)

			{

				X[c][b] = X[c][b] + mid*X[a][b];

				E[c][b] = E[c][b] + mid*E[a][b];

			}

		}

	}

}

