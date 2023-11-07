#ifndef TRIANGLE_H
#define TRIANGLE_H
#include "Shape.h"

class Triangle : public Shape
{
    public:
        Triangle(double height, double base);
        virtual std::string name() const override;
        virtual double area() const override;
        virtual std::string to_string() const override;
    
    private:
        double _height;
        double _base;
};

#endif