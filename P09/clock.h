#ifndef __CLOCK_H
#include <iostream>
#define __COMPLEX_H

class Clock
{
	protected:
		int _hours;
		int _minutes;
		int _seconds;
	public:
		Clock(int hours, int minutes, int seconds);
		void print();
		void tic();
		~Clock();
};
#endif
