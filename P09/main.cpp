#include <iostream>

int main(int argc, char **argv)
{
	if (argc != 4)
	{
		std::cout << "usage: clock <hour> <minutes> <seconds>" << std::endl;
		exit(-1);
	}
	try
	{
		Clock{atoi(argv[1]), atoi(argv[2]), atoi(argv[3])};
	}
	catch (std::out_of_range& e)
	{
		std::cerr << e.what() << std::endl;
		exit(-2);
	}
}
				
