#include <iostream>

class Clock
{
	public:
		Clock(int hours, int minutes, int seconds) : __hours{hours}, __minutes{minutes}, __seconds{seconds}
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
			std::cout << std::setw(2) << __hours << ":" << std::setw(2) << __minutes << ":" << std::setw(2) << __seconds << std::endl;
		}

		void tic()
		{
			__seconds++;
			if (__seconds >= 60)
			{
				__seconds -= 60;
				__minutes++;
			}
			if (__minutes >= 60)
			{
				__minutes -=60;
				__hours++;
			}
			if (__hours >= 24)
			{
				__hours -= 24;
			}
		}
}
		
