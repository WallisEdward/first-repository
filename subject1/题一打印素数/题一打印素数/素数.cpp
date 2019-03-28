#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <stdlib.h>

/*int main()
{
	int i, j;
	int n = 5;
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= i; j++)
		{
			printf("*");
		}
		printf("\n");
	}
	system("pause"); 0x80000000 下限 上限0x7fffffff
	return 0;
}*/
int main()
{
	int a, b, c,tmp;
	scanf("%d%d%d", &a, &b, &c);
	if (a>b)
	{
		tmp = a;
		a = b;
		b = tmp;
	}
	if (c>b)
	{
		if (c>a)
		{
			printf("%d %d %d\n", c, a, b);
		}
		else
		{
			printf("%d %d %d\n", a, c, b);
		}
	}
	
	system("pause");
	return 0;
}
 
