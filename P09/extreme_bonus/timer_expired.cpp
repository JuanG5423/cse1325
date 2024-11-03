#include "timer_expired.h"
#include <iostream>

Timer_expired::Timer_expired() : std::runtime_error{"\nTimer expired"}
{
}

