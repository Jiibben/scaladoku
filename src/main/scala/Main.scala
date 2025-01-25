package sudokuSolver

import sudokuSolver.Solver.*

object Main {
  def main(args: Array[String]): Unit = {
    val sudokuGrid = Vector(
            Vector(0, 7, 0, 5, 8, 3, 0, 2, 0),
            Vector(0, 5, 9, 2, 0, 0, 3, 0, 0),
            Vector(3, 4, 0, 0, 0, 6, 5, 0, 7),
            Vector(7, 9, 5, 0, 0, 0, 6, 3, 2),
            Vector(0, 0, 3, 6, 9, 7, 1, 0, 0),
            Vector(6, 8, 0, 0, 0, 2, 7, 0, 0),
            Vector(9, 1, 4, 8, 3, 5, 0, 7, 6),
            Vector(0, 3, 0, 7, 0, 1, 4, 9, 5),
            Vector(5, 6, 7, 4, 2, 9, 0, 1, 3)
    )

    val sudokuGrid2 = Vector(
        Vector(2,0,0,0,3,0,0,4,0),
        Vector(0,3,0,6,0,0,0,0,7),
        Vector(0,0,9,0,0,7,1,0,8),
        Vector(0,0,4,0,7,2,0,0,0),
        Vector(0,2,5,0,8,1,9,0,0),
        Vector(1,0,3,0,0,6,0,0,5),
        Vector(0,0,0,0,2,0,4,0,0),
        Vector(4,0,6,8,0,0,0,7,0),
        Vector(5,0,0,9,0,0,3,0,0)
    )
    val sudokuBoard = Board.from(sudokuGrid2)

    sudokuBoard.show

    println("Solving the sudoku board :")
    println("Here are all the solutions :")
    
    Solver.sudoku(sudokuBoard)
    for solution <- Solver.sudoku(sudokuBoard) 
    do {
        solution.show 
        println("------------------------------------------------------")}
  
}}
    



