// have fun playing with these values
var MAZE_WIDTH = 20;
var MAZE_HEIGHT = 10;

var debug = false; // step by step snapshots of the maze

var grid = makeGrid();
createMazeOnGrid(grid);
console.log(gridToString(grid));

// lifts walls on the grid using dfs to generate a maze
function createMazeOnGrid(grid) {

    var stack = []; // keep track of the path so that we can backtrack
    var currentCell, cellToVisit, unvisitedDirs, dirToVisit;

    // visit the first cell in the grid, we could really start anyware
    grid.cells[0].visited = true;
    stack.push(grid.cells[0]);

    while (stack.length > 0) {

        if (debug) {
            console.log('\n' + gridToString(grid));
        }

        // visit the cell selected by previous dfs iteration
        currentCell = stack.pop();
        currentCell.visited = true;
        unvisitedDirs = currentCell.getUnvisited();

        if (debug) {
            console.log('current cell is ' + currentCell.index + '=>'+ grid.getRow(currentCell.index) + ':' + grid.getCol(currentCell.index));
        }

        // choose a neighbor cell that has not been visited before
        if (unvisitedDirs.length > 0) {

            dirToVisit = getRandomDirection(currentCell.getUnvisited());
            cellToVisit = grid.cells[grid.getIndexByDir(currentCell.index, dirToVisit)];

            if (debug) {
                console.log('available directions are ' + currentCell.getUnvisited() + ', going ' + dirToVisit);
                console.log('will visit cell ' + cellToVisit.index + '=>' + grid.getRow(cellToVisit.index) + ':' + grid.getCol(cellToVisit.index));
            }

            // lift walls between current cell and the cell to visit next
            currentCell[dirToVisit] = true;
            cellToVisit[getOppositeDirection(dirToVisit)] = true;

            // visit the next cell
            stack.push(currentCell);
            stack.push(cellToVisit);

        // no available unvisited cells, we need to back track
        } else {
            if (debug) {
                console.log('no more unvisited cells, going back...');
            }
        }

    }

}

// creates a grid of cells with all walls in place
function makeGrid() {

    var grid = {
        width: MAZE_WIDTH,
        height: MAZE_HEIGHT,
        cells: [], // array containing all cells

        // calculates the row for a given cell array index
        getRow: function(index) {
            return Math.floor(index / MAZE_WIDTH);
        },

        // calculates the column for a given cell array index
        getCol: function(index) {
            return index % MAZE_WIDTH;
        },

        // calculates the cell array index for the given col and row
        getIndex: function(col, row) {
            return col + row * MAZE_WIDTH;
        },

        // calculates the cell array index for a neighbor cell
        getIndexByDir: function(index, direction) {

            var col = this.getCol(index);
            var row = this.getRow(index);

            switch (direction) {
                case 'left':
                    col -= 1;
                    break;
                case 'right':
                    col += 1;
                    break;
                case 'up':
                    row -= 1;
                    break;
                case 'down':
                    row += 1;
                    break;
            }

            return this.getIndex(col, row);

        }
    };

    for (var i = 0; i < MAZE_HEIGHT * MAZE_WIDTH; i++) {
        grid.cells.push(makeCell(i));
    }

    return grid;
}

// constructs a cell at the specified index
function makeCell(index) {

    return {
        index: index,

        // lifted walls are set to true
        up: false,
        down: false,
        left: false,
        right: false,
        visited: false,

        // verifies if the wall with a neighbor has been lifted,
        // which is equivalent to say the neighbor has been visited
        isVisited: function(direction) {
            return this[direction];
        },

        // gets a list of directions to all unvisited neighbors
        getUnvisited: function() {

            // remove invalid directions or directions already visited from all possible directions
            var unvisited = ['left', 'right', 'up', 'down'].filter(function(value) {
                var neighbor = grid.cells[grid.getIndexByDir(this.index, value)];
                return neighbor && neighbor.visited === false;
            }, this);

            // remove left direction if non-valid (cell on left edge)
            if (grid.getCol(this.index) === 0) {
                unvisited = unvisited.filter(function(value) {
                    return value !== 'left';
                });
            }

            // remove right direction if non-valid (cell on right edge)
            if (grid.getCol(this.index) === MAZE_WIDTH - 1) {
                unvisited = unvisited.filter(function(value) {
                    return value !== 'right';
                });
            }

            // remove up direction if non-valid (cell on upper edge)
            if (grid.getRow(this.index) === 0) {
                unvisited = unvisited.filter(function(value) {
                    return value !== 'up';
                });
            }

            // remove down direction if non-valid (cell on lower edge)
            if (grid.getRow(this.index) === MAZE_HEIGHT - 1) {
                unvisited = unvisited.filter(function(value) {
                    return value !== 'down';
                });
            }

            // return the remaning valid directions to visit
            return unvisited;
        }
    };
}

// builds a textual representation of a grid
function gridToString(grid) {

    var index, column;
    var upperWalls = '';
    var centerWalls = '';
    var gridRepresentation = '';

    // print upper and center walls for each row
    // for each cell print at most:
    // +---   -> upperWalls
    // |      -> centerWalls
    for (var i = 0; i < grid.cells.length; i++) {

        column = grid.getCol(i);

        upperWalls += '+';
        if (!grid.cells[i].up) {
            upperWalls += '---';
        } else {
            upperWalls += '   ';
        }

        if (!grid.cells[i].left) {
            centerWalls += '|   ';
        } else {
            centerWalls += '    ';
        }

        // we are on the last column, for each cell print at most:
        // +    -> upperWalls
        // |    -> centerWalls
        if (column === MAZE_WIDTH - 1) {
            upperWalls += '+';
            if (!grid.cells[i].right) {
                centerWalls += '|';
            }
            gridRepresentation += upperWalls + '\n' + centerWalls + '\n';
            centerWalls = upperWalls = '';
        }
    }

    // we are on the last row, for each cell print at most:
    // +---
    for (i = 0; i < MAZE_WIDTH; i++) {
        index = i + (MAZE_HEIGHT - 1) * MAZE_WIDTH;
        if (!grid.cells[index].down) {
            gridRepresentation += '+---';
        } else {
            gridRepresentation += '+   ';
        }
    }

    // print the last '+' and return the grid
    return gridRepresentation + '+\n';
}

// selects a random direction from the available directions array
function getRandomDirection(dirs) {
    return dirs[Math.floor(Math.random() * dirs.length)];
}

// get the opposite of a given direction
function getOppositeDirection(dir) {

    var opposite;

    switch (dir) {
        case 'left':
            opposite =  'right';
            break;
        case 'right':
            opposite = 'left';
            break;
        case 'up':
            opposite = 'down';
            break;
        case 'down':
            opposite = 'up';
            break;
    }

    return opposite;
}
