#ifndef SHAPE_H
#define SHAPE_H
#include <iostream>
#include <sstream>

class Shape
{
    public:
        virtual std::string name() const = 0;
        virtual double area() const = 0;
        virtual std::string to_string() const;

        virtual ~Shape() {}
};

#endif