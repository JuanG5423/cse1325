#ifndef __TIMER_H
#include <iostream>
#include "clock.h"
#define __TIMER_H

class Timer : public Clock
{
	public:
		Timer(int hours, int minutes, int seconds);
		~Timer();
		void tic();
};
#endif