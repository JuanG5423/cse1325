#include "date.h"
#include <iomanip>
#include <map>
#include <fstream>
#include <sstream>

int main(int argc, char **argv)
{
	typedef double Temp;
	if (argc <= 1)
	{
		std::cout << "usage: <program name> <data file>." << std::endl;
	}
	else
	{
		std::string filename{argv[1]};
		std::ifstream ifs{filename};
		if (!ifs)
		{
			std::cerr << "Can't open input file " << filename << std::endl;
			exit(-1);
		}
		std::map<Date, Temp> temps;
		std::string line;
		while (std::getline(ifs, line))
		{
			std::istringstream iss{line};
			std::string value;

			for (int i = 0; i < 4; i++)
			{
				std::getline(iss, value, ',');
			}

			int year;
			int month;
			int day;
			
			std::getline(iss, value, ',');
			month = std::stoi(value);

			std::getline(iss, value, ',');
			day = std::stoi(value);

			std::getline(iss, value, ',');
			year = std::stoi(value);

			std::getline(iss, value, ',');
			Temp temperature = std::stod(value);

			Date date{year, month, day};
			temps[date] = temperature;
		}

		while (std::cin.good())
		{
			std::cout << "Starting date to list (year month day): ";
			int year;
			int month;
			int day;

			std::cin >> year >> month >> day;
			Date start{year, month, day};
			std::cout << "Ending date to list (year month day): ";
			std::cin >> year >> month >> day;
			Date end{year, month, day};	
			std::map<Date, Temp>::iterator it = temps.begin();

			std::cout << std::fixed << std::setprecision(1);
			do
			{
				if (it->first >= start && it->first <= end)
				{
					std::cout << it->first << "\t" << it->second << std::endl;
				}
			}
			while (++it != temps.end());
		}
	}
}
