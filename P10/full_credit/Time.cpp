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

int Time::compare(Time time) const
{
    if(hours < time.hours) return -1;
    if(hours > time.hours) return 1;
    if(minutes < time.minutes) return -1;
    if(minutes < time.minutes) return 1;
    if(seconds < time.seconds) return -1;
    if(seconds < time.seconds) return 1;
    // If times are equal
    return 0;
}

Time Time::operator+(Time time)
{
    int newS = seconds + time.seconds;
    int newM = minutes + time.minutes;
    int newH = hours + time.hours;
    if(newS >= 60)
    {
        newS -= 60;
        ++newM;
    }
    if(newM >= 60)
    {
        newM -= 60;
        ++newH;
    }
    if(newH == 24)
    {
        newH %= 24;
    }

    return Time(newH, newM, newS);
}

// Pre-increment
Time& Time::operator++()
{
    ++seconds;
    if(seconds == 60)
    {
        seconds = 0;
        ++minutes;
    }
    if(minutes == 60)
    {
        minutes = 0;
        ++hours;
    }
    if(hours == 24)
    {
        hours = 0;
    }

    return *this;
}

// Post-increment
Time Time::operator++(int)
{
    Time time{*this};
    ++*this;
    return time;
}

std::ostream& operator<<(std::ostream& ost, const Time& time)
{
    ost << std::setfill('0') << std::setw(2) <<time.hours << ":" 
    << std::setfill('0') << std::setw(2) << time.minutes << ":" 
    << std::setfill('0') << std::setw(2) << time.seconds;
    return ost;
}

std::istream& operator>>(std::istream& ist, Time& time)
{
    std::string in;
    char colon1, colon2;

    if(std::getline(ist, in))
    {
        std::istringstream iss(in);
        if((iss >> time.hours >> colon1 >> time.minutes >> colon2 >> time. seconds) &&
        (colon1 == ':' && colon2 == ':') &&
        (time.hours >= 0 || time.hours < 24) &&
        (time.minutes >= 0 || time.minutes < 60) &&
        (time.seconds >= 0 || time.seconds < 60)) {}
        else
        {
            ist.setstate(std::ios::failbit);
            time.rationalize();
        }
    }
    else
    {
        ist.setstate(std::ios::failbit);
        time.rationalize();
    }
    
    return ist;
}