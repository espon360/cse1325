#include "Index.h"

void Index::add_word(Word word, std::string filename, int line)
{
    Location location = Location(filename, line);
    auto search = _index.find(word);

    if(search == _index.end())
    {
        Locations locations;
        locations.insert(location);
        _index[word] = locations;
    }
    else
    {
        search->second.insert(location);
    }
}

std::ostream& operator<<(std::ostream& ost, const Index& index)
{
    for(const auto& key : index._index)
    {
        ost << key.first << ": ";
        for(const auto& location : key.second)
        {
            ost << location << ", ";
        }
        ost << std::endl;
    }
    return ost;
}