# scaladoku

A small, purely functional Sudoku solver in Scala 3 that finds **every** solution of a grid, not just the first one.

## How it works

- **Immutable board.** The grid is a `Vector[Vector[Int]]` (`0` = empty cell). Placing a digit returns a new `Board`; nothing is ever mutated.
- **Constraint check.** A digit is valid in a cell if it does not already appear in the cell's row, column or 3×3 box (`Board.isValid`).
- **Breadth-first search.** The solver walks through the empty cells one by one. For each cell, it expands every partial board kept so far with every valid digit, and keeps the results. When no empty cell is left, the remaining boards are exactly the solutions.

```scala
val board = Board.from(grid)         // grid: Vector[Vector[Int]], 0 = empty
val solutions = Solver.sudoku(board) // List[Board], every valid completion
solutions.foreach(_.show)
```

## Project structure

```
src/main/scala/
├── board.scala   // Board: rows, columns, 3×3 boxes, validity check, immutable updates
├── Solver.scala  // Solver.sudoku: breadth-first search returning all solutions
└── Main.scala    // example: prints a grid and all its solutions
```

## Run it

Requires [sbt](https://www.scala-sbt.org/) (Scala 3.6.3 is fetched automatically).

```bash
sbt run
```

Edit the grid in `Main.scala` to solve another puzzle.

## Limitations and next steps

- The search keeps every partial board in memory, so very open grids can get slow and memory-hungry.
- Cells are filled in reading order. Picking the most constrained cell first would prune the search a lot.
- The test suite (`MySuite.scala`) is still a placeholder.
