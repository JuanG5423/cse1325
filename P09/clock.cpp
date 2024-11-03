#include "clock.h"
#include <iostream>
#include <iomanip>

Clock::Clock(int hours, int minutes, int seconds) : _hours{hours}, _minutes{minutes}, _seconds{seconds}
{
	if (hours < 0 || hours > 23)
	{
		throw std::out_of_range{"Invalid value of " + std::to_string(hours) + " for hours"};
	}
	if (minutes < 0 || minutes > 59)
	{
		throw std::out_of_range{"Invalid value of " + std::to_string(minutes) + " for minutes"};
	}
	if (seconds < 0 || seconds > 59)
	{
		throw std::out_of_range{"Invalid value of " + std::to_string(seconds) + " for seconds"};
	}
}

Clock::~Clock()
{
}

void Clock::print()
{
	std::cout << "The time is now " << std::setfill('0') << std::setw(2) << _hours << ":" << std::setfill('0') << std::setw(2) << _minutes << ":" << std::setfill('0') << std::setw(2) << _seconds << std::endl;
}

void Clock::tic()
{
	_seconds++;
	if (_seconds >= 60)
	{
		_seconds -= 60;
		_minutes++;
	}
	if (_minutes >= 60)
	{
		_minutes -=60;
		_hours++;
	}
	if (_hours >= 24)
	{
		_hours -= 24;
	}
}

		
