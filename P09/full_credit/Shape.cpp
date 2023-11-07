#include "Shape.h"

std::string Shape::name()
{
    return "Shape";
}

double Shape::area()
{
    return 0.0;
}

std::string Shape::to_string()
{
    std::ostringstream s;
    s << name() << " with area" << area();
    return s.str();
}