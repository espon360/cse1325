#ifndef SHAPE_H
#define SHAPE_H
#include <iostream>
#include <sstream>

class Shape
{
    public:
        virtual std::string name();
        virtual double area();
        virtual std::string to_string();
};

#endif