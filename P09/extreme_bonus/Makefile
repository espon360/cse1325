CXX = g++
APPNAME = Shapes
CXXFLAGS += --std=c++17
LDFLAGS += -lsfml-graphics -lsfml-window -lsfml-system
SOURCES = $(wildcard *.cpp)
OBJS = $(SOURCES:.cpp=.o)
HEADERS = $(wildcard *.h)

$(APPNAME): $(OBJS)
	$(CXX) $(CXXFLAGS) -o $(APPNAME) $(OBJS) $(LDFLAGS)

%.o: %.cpp $(HEADERS)
	$(CXX) $(CXXFLAGS) -c $< -o $@

clean:
	rm -f $(OBJS) $(APPNAME)

.PHONY: clean
