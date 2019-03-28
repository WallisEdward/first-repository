#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int year, n = 0;
	for (year = 1000; year <= 2000; year++)
	{
		if (year % 4 == 0)
		{
			if (year % 100 != 0)printf("%d ", year, n++);
		}
		if (year % 400 == 0)printf("%d ", year, n++);
	}
	printf("\n闰年的数量=%d", n);
	system("pause");
	return  0;
}