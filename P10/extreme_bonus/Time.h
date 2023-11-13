#include <iostream>
#include <ostream>
#include <istream>
#include <iomanip>
#include <sstream>
#include <map>

class Time
{
    // fields
    private:
        int hours;
        int minutes;
        int seconds;

    // constructor and operator overloads
    public:
        Time(int hour, int minute, int second);
        Time();

        Time operator+(Time time);
        const Time operator+(int seconds);
        Time& operator++(); // pre-increment
        Time operator++(int); // post-increment
        int operator[](int index) const;
        inline bool operator==(const Time& time) const {return (compare(time) == 0);}
        inline bool operator!=(const Time& time) const {return (compare(time) != 0);}
        inline bool operator<(const Time& time) const {return (compare(time) < 0);}
        inline bool operator>(const Time& time) const {return (compare(time) > 0);}
        inline bool operator<=(const Time& time) const {return (compare(time) <= 0);}
        inline bool operator>=(const Time& time) const {return (compare(time) >= 0);}
        friend std::ostream& operator<<(std::ostream& ost, const Time& time);
        friend std::istream& operator>>(std::istream& ist, Time& time);

    // methods
    private:
        void rationalize();
        int compare(Time time) const;
};

Time operator+(int seconds, Time& time);