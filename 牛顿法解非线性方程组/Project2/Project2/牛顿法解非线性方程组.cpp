#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#define N 2 //��Ԫ�ķ�����
#define eps 2.2204e-16

int culFAep(double* C, double FAep)
{
	if (fabs(C[0])<FAep&&fabs(C[1])<FAep)//�����ֵ����
		return 1;
	else
		return 0;
}


double *MM(double* J, double C[])//����˷�
{
	double *B = NULL;
	int i = 0, j = 0;
	B = (double*)malloc(N*sizeof(double));
	for (i = 0; i < N; i++){
		B[i] = 0;
	}
		
	for (i = 0; i < N; i++){
		for (j = 0; j < N; j++){
			B[i] += J[i*N + j] * C[j];
		}		
	}
	return B;
}

double *Minv(double *J)//�������
{
	double B[4] = { 0 }, temp = 0.0;
	int i = 0;
	temp = 1 / (J[0] * J[3] - J[1] * J[2]);
	B[0] = J[3];
	B[1] = -J[1];
	B[2] = -J[2];
	B[3] = J[0];
	for (i = 0; i < 4; i++){
		J[i] = temp*B[i];
	}
	return J;
}

double miderro(double D[])//�����ֵ
{
	double max = 0.0;
	int i = 0;
	for (i = 0; i<N; i++)
	{
		if (D[i]>max){
			max = D[i];
		}
	}
	return max;
}

double* F(double B[]) //F��A��
{
	double x = B[0];
	double y = B[1];
	double *E = NULL;
	E = (double*)malloc(2 * sizeof(double));
	E[0] = x*x - 2 * x - y + 0.5;
	E[1] = x*x + 4 * y*y - 4;
	return E;
}

double* JF(double B[]) //F��A�����ſɱ�����ʽ
{
	double x = B[0];
	double y = B[1];
	double *G = NULL;
	G = (double*)malloc(4 * sizeof(double));
	G[0] = 2 * x - 2;
	G[1] = -1;
	G[2] = 2 * x;
	G[3] = 8 * y;
	return G;
}

int reltims(double A[], double Aep, double FAep, int maxitera, double *ero) //ʵ�ʵ��������ĺ����������ֱ��ǳ�ʼֵ��A������ޣ�F��A��������ޣ���������������ʵ�ʵ����
{
	double *C = NULL, *J = NULL, D[2] = { 0 }, *E = NULL, *temp = NULL;
	double H = 0.0;
	int k = 0, i = 0, tims = 0;
	C = F(A);
	for (k = 1; k<maxitera; k++)
	{
		J = JF(A);
		temp = MM(Minv(J), C);
		for (i = 0; i < N; i++){
			D[i] = A[i] - temp[i];
		}
		E = F(D);
		for (i = 0; i < N; i++){
			temp[i] = D[i] - A[i];
		}
		*ero = miderro(temp);
		H = *ero / (miderro(D) + eps);
		for (i = 0; i < N; i++){
			A[i] = D[i];//��ֵ����
		}
		for (i = 0; i < N; i++){
			C[i] = E[i];//��ֵ���£�E=F��D�� C = F(A)
		}
		tims = k;
		if ((*ero < Aep) || (H < Aep) || culFAep(C, FAep)){
			break;
		}
	}
	return tims;
}



int main()
{
	double A[2] = { 0 };

	double Aep = 0.0, FAep = 0.0, ero = 0.0;

	int maxitera = 0, tims = 0, i = 0;

	printf("������Է�����:\nx^2-2*x-y+0.5=0\nx^2+4*y^2-4=0\n");

	printf("\n�����ʼ����ֵx0,y0\n");

	for (i = 0; i<2; i++)

		scanf("%lf", &A[i]);

	printf("����������A������ޣ�F(A)������޺�����������\n");

	scanf("%lf%lf%d", &Aep, &FAep, &maxitera);

	tims = reltims(A, Aep, FAep, maxitera, &ero);

	printf("������A�Ľ�Ϊ:\n");

	for (i = 0; i<2; i++)

		printf("A(%d)=%lf\n", i + 1, A[i]);

	printf("\n��������Ϊ:%d", tims);

	printf("\n���Ϊ:%lf\n", ero);

	getchar();

	system("pause");

	return 0;
}