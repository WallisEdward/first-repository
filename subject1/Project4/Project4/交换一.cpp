#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

int main()
{
	int i = 1;
	int j = 2;
	int k;
	k = i;
	i = j;
	j = k;
	printf("i=%d\nj=%d\n",i,j);
	system("pause");

	return 0;
}
