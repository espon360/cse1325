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
        Time(int hour = 0, int minute = 0, int second = 0);

        Time operator+(Time time);
        Time& operator++(); // pre-increment
        Time operator++(int); // post-increment
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