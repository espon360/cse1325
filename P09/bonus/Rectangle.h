#ifndef RECTANGLE_H
#define RECTANGLE_H
#include "Shape.h"

class Rectangle : public Shape
{
    public:
        Rectangle(double height, double width);
        virtual std::string name() const override;
        virtual double area() const override;
        virtual std::string to_string() const override;
    
    private:
        double _height;
        double _width;
};

#endif