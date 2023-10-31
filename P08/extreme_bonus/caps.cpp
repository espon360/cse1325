#include <iostream>
#include <vector>
#include <algorithm>

bool compare_alp(std::string a, std::string b);
bool compare_len(std::string a, std::string b);

int main(int argc, char* argv[])
{
    std::vector<std::string> up;
    std::vector<std::string> low;

    std::string temp;

    for(int i = 1; i < argc; i++)
    {
        temp = argv[i];
        if(std::isupper(temp.at(0)))
        {
            up.push_back(temp);
        }
        else if(std::islower(temp.at(0)))
        {
            low.push_back(temp);
        }
    }

    std::sort(up.begin(), up.end());
    std::cout << "Capitalized:" << std::endl;
    for(auto i : up) std::cout << i << std::endl;

    std::sort(low.begin(), low.end(), compare_alp);
    std::sort(low.begin(), low.end(), compare_len);
    std::cout << "\nLower Case:" << std::endl;
    for(auto i : low) std::cout << i << std::endl;

    return 0;
}

bool compare_alp(std::string a, std::string b)
{
    return a.at(0) < b.at(0);
}

bool compare_len(std::string a, std::string b)
{
    return a.size() < b.size();
}

