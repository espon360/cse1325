#include "Time.h"

Time::Time(int hour, int minute, int second) :
    hours(hour),
    minutes(minute),
    seconds(second){rationalize();}

void Time::rationalize()
{
    if(this->hours < 0 || this->hours > 23 || 
    this->minutes < 0 || this->minutes > 59 ||
    this->seconds < 0 || this->seconds > 59)
    {
        this->hours = 0;
        this->minutes = 0;
        this->seconds = 0;
    }
                
}

int Time::compare(Time time)
{

}