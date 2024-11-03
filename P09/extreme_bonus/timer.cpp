#include "timer.h"
#include <iostream>

Timer::Timer(int hours, int minutes, int seconds) : Clock{hours, minutes, seconds}
{
}

Timer::~Timer()
{
}

void Timer::tic() 
{
	_seconds--;
	if (_seconds < 0)
	{
		_seconds += 60;
		_minutes--;
	}
	if (_minutes < 0)
	{
		_minutes += 60;
		_hours--;
	}
	if (!_hours && !_minutes && !_seconds)
	{
		throw Timer_expired();
	}
}
