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
	return purse;
}

Purse Purse::operator+(const Purse& purse)
{
	return Purse{_pounds + purse._pounds, _shillings + purse._shillings, _pence + purse._pence};
}

Purse Purse::operator-(const Purse& purse)
{
	return Purse{_pounds - purse._pounds, _shillings - purse._shillings, _pence - purse._pence};
}

Purse& Purse::operator+=(const Purse& purse)
{
	_pounds += purse._pounds;
	_shillings += purse._shillings;
	_pence += purse._pence;
	rationalize();
	return *this;
}

Purse& Purse::operator-=(const Purse& purse)
{
	_pounds -= purse._pounds;
	_shillings -= purse._shillings;
	_pence -= purse._pence;
	rationalize();
	return *this;
}

void Purse::rationalize()
{
	while (_pence >= 12 || _pence < 0)
	{
		if (_pence >= 12)
		{
			_pence -= 12;
			_shillings++;
		}
		if (_pence < 0)
		{
			_pence += 12;
			_shillings--;
		}
	}
	while (_shillings >= 20 || _shillings < 0)
	{	
		if (_shillings >= 20)
		{
			_shillings -= 20;
			_pounds++;
		}
		if (_shillings < 0)
		{
			_shillings += 20;
			_pounds--;
		}
	}	
}
