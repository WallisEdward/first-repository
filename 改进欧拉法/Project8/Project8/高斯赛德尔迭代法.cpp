#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<stdlib.h>
using namespace std;

//G-DE�������Է���

int main(){

	int m, i, j, n = 0, mn;//n�������� mn����������������

	double erro, he, he1, merro;

	cout << "�������Ǽ�Ԫ�����飺" << endl;

	cin >> m ;

	double **A = new double *[m];//��ά����

	for (i = 0; i<m; i++) {

		A[i] = new double[m];

	}

	double *B = new double[m];

	double *X = new double[m];

	double *D = new double[m];

	double *DE = new double[m];//�����е�ʵ�����洢

	cout << "������ϵ������A��" << endl;

	for (i = 0; i < m; i++){
		for (j = 0; j<m; j++)
			cin >> A[i][j];
	}

	cout << "�����볣��������B��" << endl;

	for (i = 0; i < m; i++){
		cin >> B[i];
	}

		
	cout << "���������erro:" << endl;

	cin >> erro;

	cout << "����������������:" << endl;

	cin >> mn;
	//cout << "������������X:" << endl;

	for (i = 0; i<m; i++){

		//cin >> X[i];

		X[i] = 0;
		D[i] = X[i];//D[]�����һ�ε������

	}
	do{

		for (i = 0; i<m; i++){

			he = he1 = 0;

			for (j = 0; j < i; j++){
				he += A[i][j] * X[j];
			}

			for (j = i + 1; j < m; j++){
				he1 += A[i][j] * D[j];
			}

			X[i] = (B[i] - he - he1) / A[i][i];

			DE[i] = (D[i] - X[i])*(D[i] - X[i]);//�����

		}
		for (i = 0; i < m; i++){
			D[i] = X[i];
		}
		n++;//��������ͳ��
		merro = DE[0];

		for (i = 1; i<m; i++){
			if (DE[i]>merro){
				merro = DE[i];
			}		
		}	
	} while ((merro>erro*erro) && (n<mn));

	cout << "�÷�����Ľ�Ϊ��" << endl;
	for (i = 0; i < m; i++){
		cout << X[i] << " ";
	}
		
	cout << endl << "��������Ϊ:" << n-1 << endl;

	//for (i = 0; i<m; i++){
	
		//delete[] A[i];

		//A[i] = NULL;

	//}

	//delete[] A; A = 0;

	//delete[] B; B = 0;

	///delete[] D; D = 0;

	//delete[] X; X = 0;
	//delete[] DE; DE = 0;
	system("pause");
	return 0;

}