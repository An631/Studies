//https://omegaup.com/arena/problem/Maximo-repetido#problems
#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
	int N = 0;
	int arr[100] = {};
	cin >> N;
	int biggest = 0;
	for(int i = 0; i < N; i++ )
	{
		int n;
		cin >> n;
		arr[n] = arr[n] + 1;
		if (n > biggest)
		{
			biggest = n;
		}
	}

	printf("%d",arr[biggest]);
}