#include "purse.h"

Purse::Purse(int pounds, int shillings, int pence) : _pounds{pounds}, _shillings{shillings}, _pence{pence}
{
	rationalize();
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse)
{
	return ost << "£" << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
}

Purse& Purse::operator++()
{
	++_pence;
	rationalize();
	return *this;
}

Purse Purse::operator++(int)
{
	Purse purse{*this};
	++*this;
	return purse++;
}

