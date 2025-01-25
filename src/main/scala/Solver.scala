package sudokuSolver
import sudokuSolver.*

object Solver {

  def sudoku(board : Board) : List[Board]=
    def sudokuInside(boards: List[Board], moves : List[(Int,Int)]) : List[Board] =
        moves match
          case x :: xs =>
              val newBoards = (
                for board <- boards
                    i <- (1 to 9)
                    if board.isValid(x._1,x._2, i)
                yield (board.change(x._1,x._2, i))).toList
              sudokuInside(newBoards,xs)
          case Nil => boards
    sudokuInside(List(board), board.getEmpty())
  
} 
