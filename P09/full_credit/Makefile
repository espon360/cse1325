CXXFLAGS += --std=c++17

shapes: Shapes.o Shape.o Circle.o Rectangle.o *.h
	$(CXX) $(CXXFLAGS) Shapes.o Shape.o Triangle.o Rectangle.o -o Shapes

Circle.o: Triangle.cpp *.h
	$(CXX) $(CXXFLAGS) -c Triangle.cpp -o Triangle.o

Rectangle.o: Rectangle.cpp *.h
	$(CXX) $(CXXFLAGS) -c Rectangle.cpp -o Rectangle.o

Shape.o: Shape.cpp *.h
	$(CXX) $(CXXFLAGS) -c Shape.cpp -o Shape.o

Shapes.o: Shapes.cpp *.h
	$(CXX) $(CXXFLAGS) -c Shapes.cpp -o Shapes.o

clean:
	rm -f *.o *.gch *~ a.out Shapes
