#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

/*int main()
{
	int a, b, tmp;
	a = 1;
	b = 2;
	tmp = a;
	a = b;
	b = tmp;
	printf("%d %d", a, b);
	system("pause");
	return 0;
}*/

int main()
{
	int a = 1, b = 2;
	printf("交换前：a=%d b=%d\n", a, b);
	a = a + b;
	b = a - b;
	a = a - b;
	printf("交换后：a=%d b=%d\n", a, b);
	system("pause");
	return 0;
}
