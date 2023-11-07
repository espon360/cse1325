#include "Shape.h"
#include "Triangle.h"
#include "Rectangle.h"
#include "vector"
#include <SFML/Graphics.hpp>

int main()
{
    std::vector<Shape*> shapes;
    Shape* rectangle = new Rectangle(50.0,100.0);
    shapes.push_back(rectangle);
    Shape* triangle = new Triangle(50.0,100.0);
    shapes.push_back(triangle);

    for(const Shape* i : shapes)
    {
        std::cout << i->to_string() << std::endl;
    }

    sf::RenderWindow window(sf::VideoMode(800, 600), "Rectangle Drawing");
    sf::RectangleShape draw_rectangle(sf::Vector2f(50.f, 100.f));
    draw_rectangle.setPosition(40.f, 20.f);

    while (window.isOpen()) {
        sf::Event event;
        while (window.pollEvent(event)) {
            if (event.type == sf::Event::Closed)
                window.close();
        }

        window.clear();
        window.draw(draw_rectangle);
        window.display();
    }

    for(Shape* j : shapes)
    {
        delete j;
    }
    shapes.clear();

    return 0;
}