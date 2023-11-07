#include "Shape.h"

std::string Shape::to_string() const
{
    std::ostringstream s;
    s << name() << " with area" << area();
    return s.str();
}