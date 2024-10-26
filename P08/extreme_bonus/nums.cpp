#include <iostream>
#include <vector>
#include <algorithm>
#include <random>
#include <chrono>

int main(int argc, char **argv)
{
	std::vector<std::string> numbers;
	std::vector<std::string> *words = new std::vector<std::string>;
	
	for (int i = 1; i < argc; i++)
	{
		std::string str(argv[i]);
		if (isdigit(argv[i][0]))
		{
			numbers.push_back(argv[i]);
		}
		else
		{
			(*words).push_back(argv[i]);
		}
	}

	unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();

	std::cout << "Numbers:" << std::endl;
	for (std::string number : numbers)
	{
		std::cout << number << std::endl;
	}
	std::cout << std::endl << "Words:" << std::endl;
	for (std::string word : *words)
	{
		std::cout << word << std::endl;
	}	
}	

