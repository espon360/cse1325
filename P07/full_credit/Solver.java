// Copyright 2023 An Duong <https://github.com/espon360/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>.

import java.util.List;
import java.util.ArrayList;

public class Solver {
    public Solver(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    // Implement a brute force search for this word
    // If the word is not found, return null
    public Solution solve(String word) {
        if(word.isEmpty()) return null;
        for(int x=0; x<puzzle.width(); ++x) {
            for(int y=0; y<puzzle.height(); ++y) {
                for(Direction d : Direction.values()) {
                    Boolean found = true;
                    for(int i=0; i<word.length(); ++i) {
                        if(word.charAt(i) != puzzle.getChar(x, y, d, i)) {
                            found = false;
                            break;
                        }
                    }
                    if(found)
                        return new Solution(puzzle.name(), word, x, y, d);
                }
            }
        }
        return null;
    }

    private Puzzle puzzle;
}
