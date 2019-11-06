#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<stdlib.h>
using namespace std;

//G-DE法解线性方程

int main(){

	int m, i, j, n = 0, mn;//n迭代次数 mn是最大迭代次数限制

	double erro, he, he1, merro;

	cout << "请输入是几元方程组：" << endl;

	cin >> m ;

	double **A = new double *[m];//二维数组

	for (i = 0; i<m; i++) {

		A[i] = new double[m];

	}

	double *B = new double[m];

	double *X = new double[m];

	double *D = new double[m];

	double *DE = new double[m];//迭代中的实际误差存储

	cout << "请输入系数矩阵A：" << endl;

	for (i = 0; i < m; i++){
		for (j = 0; j<m; j++)
			cin >> A[i][j];
	}

	cout << "请输入常数列向量B：" << endl;

	for (i = 0; i < m; i++){
		cin >> B[i];
	}

		
	cout << "请输入误差erro:" << endl;

	cin >> erro;

	cout << "请输入最大迭代次数:" << endl;

	cin >> mn;
	//cout << "请输入零向量X:" << endl;

	for (i = 0; i<m; i++){

		//cin >> X[i];

		X[i] = 0;
		D[i] = X[i];//D[]存放上一次迭代结果

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

			DE[i] = (D[i] - X[i])*(D[i] - X[i]);//求误差

		}
		for (i = 0; i < m; i++){
			D[i] = X[i];
		}
		n++;//迭代次数统计
		merro = DE[0];

		for (i = 1; i<m; i++){
			if (DE[i]>merro){
				merro = DE[i];
			}		
		}	
	} while ((merro>erro*erro) && (n<mn));

	cout << "该方程组的解为：" << endl;
	for (i = 0; i < m; i++){
		cout << X[i] << " ";
	}
		
	cout << endl << "迭代次数为:" << n-1 << endl;

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