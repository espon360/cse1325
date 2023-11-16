#ifndef INDEX_H
#define INDEX_H

#include "Location.h"
#include <map>
#include <set>

typedef std::set<Location> Locations;
typedef std::string Word;

class Index
{
    private:
        std::map<Word, Locations> _index;

    public:
        void add_word(Word word, std::string filename, int line);
        friend std::ostream& operator<<(std::ostream& ost, const Index& index);
};

#endif