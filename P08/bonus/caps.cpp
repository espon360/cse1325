#include <iostream>
#include <vector>
#include <cstring>
#include <cctype>

int main(int argc, char* argv[])
{
    std::vector<std::string> up;
    std::vector<std::string> low;

    char temp[50];

    for(int i = 1; i < argc; i++)
    {
        strcpy(temp, argv[i]);
        if(isupper(temp[0]))
        {
            up.push_back(temp);
        }
        else if(islower(temp[0]))
        {
            low.push_back(temp);
        }
    }

    std::cout << "Capitalized:" << std::endl;
    for(auto i : up) std::cout << i << std::endl;

    std::cout << "\nLower Case:" << std::endl;
    for(auto i : low) std::cout << i << std::endl;

    return 0;
}