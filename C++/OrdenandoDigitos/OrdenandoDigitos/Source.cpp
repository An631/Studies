//https://omegaup.com/arena/problem/Ordenando-Digitos#problems

#include <stdio.h>
#include <iostream>

using namespace std;

int main()
{
	// ENTRADAS
	int N=0;	
	cin >> N;
	int *arr = new int[N]();

	for (int i = 0; i < N; i++)
	{
		int digit = 0;
		cin >> digit;
		arr[digit]++;
	}

	//PROCESO
	int total = 0;
	int *posArr = new int[N]();
	for (int j = 0; j < N; j++)
	{
		if (arr[j] >= 0)
		{
			for (int k = 0; k < arr[j]; k++)
			{
				cout << j;
				cout << ' ';
			}
		}
	}
	//system("pause");
}
