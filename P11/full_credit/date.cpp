#include "date.h"
#include <iomanip>

Date::Date(int year, int month, int day) : _year{year}, _month{month}, _day{day}
{
}

std::ostream& operator<<(std::ostream& ost, const Date& date)
{
	return ost << std::setw(4) << _year << "/" << std::setw(2) << std::setfill('0') << _month << "/" << std::setw(2) << std::setfill('0') << _day;
}

