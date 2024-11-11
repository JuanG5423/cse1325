#include "purse.h"

Purse::Purse(int pounds, int shillings, int pence) : _pounds{pounds}, _shillings{shillings}, _pence{pence}
{
	rationalize();
}

Purse::operator<<(ostream& ost, const Purse&, purse)
{
	return ost << "£" << _pounds << " " << _shillings << "s" << _pence << "d";
}

Purse::operator++();
{
	++_pence;
	rationalize();
}

Purse::operator++(int);
{
	_pence++;
	rationalize();
}


