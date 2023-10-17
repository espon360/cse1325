// Copyright 2023 An Duong <https://github.com/espon360/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>.

public enum Direction {N(0,-1), NE(1,-1), E(1,0), SE(1,1), S(0,1), SW(-1,1), W(-1,0), NW(-1,-1);

    private Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }
    public int deltaX() {
        return deltaX;
    }

    public int deltaY() {
        return deltaY;
    }

    private int deltaX;
    private int deltaY;
}
