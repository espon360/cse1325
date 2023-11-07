#include "Shape.h"
#include "Triangle.h"
#include "Rectangle.h"
#include "vector"

int main()
{
    std::vector<Shape*> shapes;
    Shape* rectangle = new Rectangle(5.0,10.0);
    shapes.push_back(rectangle);
    Shape* triangle = new Triangle(5.0,10.0);
    shapes.push_back(triangle);

    for(const Shape* i : shapes)
    {
        std::cout << i->to_string() << std::endl;
    }

    for(Shape* j : shapes)
    {
        delete j;
    }
    shapes.clear();

    return 0;
}