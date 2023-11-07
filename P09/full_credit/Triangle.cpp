#include "Triangle.h"

Triangle::Triangle(double height, double base) :
    _height(height),
    _base(base){}

std::string Triangle::name()
{
    std::ostringstream s;
    s << "Triangle with base of " << _base << " and height of " << _height;
    return s.str();
}

double Triangle::area()
{
    return _height*(_base / 2);
}

std::string Triangle::to_string()
{
    std::ostringstream s;
    s << name() << " with area " << area();
    return s.str();
}