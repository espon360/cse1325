// Copyright 2023 An Duong <https://github.com/espon360/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>.

import java.io.IOException;

public class BadPuzzleFileException extends IOException {
    public BadPuzzleFileException(String name, int lineNumber) {
        super("Malformed puzzle '" + name + "' at line " + lineNumber);
    }
}
