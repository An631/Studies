// https://omegaup.com/arena/problem/Incrementar-la-hora-un-segundo#problems
#include <iostream>
#include <stdio.h>

using namespace std;

int main() {
	int h, m, s;

	cin >> h;

	cin >> m;

	cin >> s;

	if ((h > 23) | (h < 0)) {
		return 1;
	}

	if ((m > 59) | (m < 0)) {
		return 1;
	}

	if ((s > 59) | (s < 0)) {
		return 1;
	}

	s = s + 1;

	if (s > 59)
	{
		s = 0;
		m = m + 1;
		if (m > 59)
		{
			m = 0;
			h = h + 1;
		}

		if (h > 23)
		{
			h = 0;
		}
	}

	printf("%d %d %d", h, m, s);
}