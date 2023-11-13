# Compiler and compiler flags
CXX = g++
CXXFLAGS = -std=c++17 -Wall -Wextra

# Target executable
TARGET = testtime

# Object files
OBJS = Time.o TestTime.o

# Rule to create the executable
$(TARGET): $(OBJS)
	$(CXX) $(CXXFLAGS) $(OBJS) -o $(TARGET)

# Rule to compile Time.cpp
Time.o: Time.cpp Time.h
	$(CXX) $(CXXFLAGS) -c Time.cpp

# Rule to compile TestTime.cpp
TestTime.o: TestTime.cpp Time.h
	$(CXX) $(CXXFLAGS) -c TestTime.cpp

# Clean rule
clean:
	rm -f $(OBJS) $(TARGET)
