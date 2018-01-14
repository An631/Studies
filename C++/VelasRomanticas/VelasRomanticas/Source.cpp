// https://omegaup.com/arena/problem/velas_romanticas#problems
#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
	int t = 0;
	int r = 0;

	cin >> t;
	cin >> r;

	int remCandles = t;
	int hours = t;
	do
	{
		hours = hours + (remCandles / r);
		remCandles = (remCandles / r) + (remCandles % r);
	} while (remCandles >= r);
	 
	printf("%d",hours);
}