#ifndef TRIANGLE_H
#define TRIANGLE_H
#include "Shape.h"

class Triangle : public Shape
{
    public:
        Triangle(double height, double base);
        std::string name() override;
        double area() override;
        std::string to_string() override;
    
    private:
        double _height;
        double _base;
};

#endif