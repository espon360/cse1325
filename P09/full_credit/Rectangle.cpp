#include "Rectangle.h"

Rectangle::Rectangle(double height, double width) :
    _height(height),
    _width(width){}

std::string Rectangle::name()
{
    std::ostringstream s;
    s << _height << " x " << _width << " Rectangle";
    return s.str();
}

double Rectangle::area()
{
    return _height*_width;
}

std::string Rectangle::to_string()
{
    std::ostringstream s;
    s << name() << " with area " << area();
    return s.str();
}