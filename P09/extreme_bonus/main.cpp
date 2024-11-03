#include <iostream>
#include "timer.h"

int main(int argc, char **argv)
{
	if (argc != 4)
	{
		std::cout << "usage: timer <hour> <minutes> <seconds>" << std::endl;
		exit(-1);
	}
	try
	{
		Timer timer{atoi(argv[1]), atoi(argv[2]), atoi(argv[3])};

		std::cout << std::endl << "Enter 'q' to quit." << std::endl << std::endl;
		std::string input = "";
		do
		{
			timer.print();
			timer.tic();
			std::getline(std::cin, input);
		}
		while (input != "q");
	}
	catch (std::runtime_error& e)
	{
		std::cerr << e.what() << std::endl;
	}
}			
