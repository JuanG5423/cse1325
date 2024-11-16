#include "date.h"
#include <map>
#include <fstream>

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
	}
}
