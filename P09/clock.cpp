#include <iostream>

class Clock
{
	public:
		Clock(int hours, int minutes, int seconds) : _hours{hours}, _minutes{minutes}, _seconds{seconds}
		{
			if (hours < 0 || hours > 23)
			{
				throw std::out_of_range{"Invalid value of " + hours + " for hours"};
			}
			if (minutes < 0 || minutes > 59)
			{
				throw std::out_of_range{"Invalid value of " + minutes + " for minutes"};
			}
			if (seconds < 0 || seconds > 59)
			{
				throw std::out_of_range{"Invalid value of " + seconds + " for seconds"};
			}
		}

		~Clock()
		{
		}

		void print()
		{
			std::cout << std::setw(2) << _hours << ":" << std::setw(2) << _minutes << ":" << std::setw(2) << _seconds << std::endl;
		}

		void tic()
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
}
		
