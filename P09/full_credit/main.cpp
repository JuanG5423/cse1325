#include <iostream>
#include "clock.h"

int main(int argc, char **argv)
{
	if (argc != 4)
	{
		std::cout << "usage: clock <hour> <minutes> <seconds>" << std::endl;
		exit(-1);
	}
	try
	{
		Clock clock{atoi(argv[1]), atoi(argv[2]), atoi(argv[3])};

		std::cout << std::endl << "Enter 'q' to quit." << std::endl << std::endl;
		std::string input = "";
		do
		{
			clock.print();
			clock.tic();
			std::getline(std::cin, input);
		}
		while (input != "q");
	}
	catch (std::out_of_range& e)
	{
		std::cerr << e.what() << std::endl;
		exit(-2);
	}
}			
