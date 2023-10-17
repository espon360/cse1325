// Copyright 2023 An Duong <https://github.com/espon360/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>.

import java.util.Comparator;

public class Solution implements Comparator<Solution>{

    public Solution(String name, String word, int x, int y, Direction direction) {
        this.name = name;
        this.word = word;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public int compare(Solution solution1, Solution solution2)
    {
        int nameCompare = solution1.name.compareTo(solution2.name);
        if(nameCompare == 0)
        {
            return solution1.word.compareTo(solution2.word);
        }
        else
        {
            return nameCompare;
        }
    }

    @Override
    public String toString() {
        return String.format("In %s: %s found at (%d,%d,%s)", name, word, x, y, direction);
    }

    private String name;
    private String word;
    private int x;
    private int y;
    private Direction direction;
}
