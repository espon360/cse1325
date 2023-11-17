#include "Index.h"
#include <fstream>
#include <sstream>

int main(int argc, char* argv[])
{
    Index poems;

    for(int i = 1; i < argc; i++)
    {
        std::ifstream ist(argv[i]);
        if(!ist) throw std::runtime_error(std::string(argv[i]) + " can't be opened\n");
        std::string str;
        int line = 1;
        while(std::getline(ist, str))
        {
            std::istringstream iss(str);
            std::string temp;
            while (iss >> temp)
            {
                temp[0] = std::tolower(static_cast<unsigned char>(temp[0]));
                int ascii = static_cast<int>(temp.back());
                if((ascii > 32 && ascii < 48) || (ascii > 57 && ascii < 65) 
                || (ascii > 90 && ascii < 97) || (ascii > 122 && ascii < 127))
                {
                    temp.pop_back();
                }
                poems.add_word(temp, argv[i], line);
            }
            line++;
        }
    }

    std::cout << poems;

    return 0;
}