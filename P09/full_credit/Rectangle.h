#ifndef RECTANGLE_H
#define RECTANGLE_H
#include "Shape.h"

class Rectangle : public Shape
{
    public:
        Rectangle(double height, double width);
        std::string name() override;
        double area() override;
        std::string to_string() override;
    
    private:
        double _height;
        double _width;
};

#endif