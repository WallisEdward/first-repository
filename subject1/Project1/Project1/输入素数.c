#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int x;

	for (x = 100; x <= 200; x++)
	{
		int i;
		int k=1;
		for (i = 2; i < x; i++)
		{
			if (x%i == 0)
			{
				k = 0;
				break;
			}
		}
		if (k == 1)
		{
			printf("%d ", x);
		}
	}
	system("pause");
	return 0;
}