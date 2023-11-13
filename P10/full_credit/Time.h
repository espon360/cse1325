#include <iostream>

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
        Time operator

    // methods
    private:
        void rationalize();
};