#include "purse.h"
#include <map>

int main()
{
	std::map<std::string, Purse> vault;
	int accounts;
	std::cout << "Welcome to Ye Olde Bank of Merry England" << std::endl << std::endl << std::endl << "How many accounts? ";
	std::cin >> accounts;
	for (int i = 0; i < accounts; ++i)
	{
		std::cout << "Name account " << i << ": ";
		std::string name;
		std::getline(std::cin, name);
		int pence;
		int shillings;
		int pounds;
		std::cout << "Enter your initial deposit (pounds shillings pence): ";
		Purse purse{pounds, shillings, pence};
		vault[name] = purse;
		std::cout << "Account " << name << " created with " << purse << std::endl;
	}

	std::cout << std::endl << std::endl << std::endl << "Account List" << std::endl << "============" << std::endl << std::endl;
	Purse total{};
	
	for (const auto& pair : vault)
	{
		std::cout << pair.first << " with " << pair.second << std::endl;
		total += pair.second;
	}
	std::cout << "Total in bak is " << total << std::endl;


}
