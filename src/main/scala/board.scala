package sudokuSolver


class Board(board : Vector[Vector[Int]]){

    def show : Unit =
        this.board.foreach(row => println((row.map(cell => if cell == 0 then "." else cell.toString())).mkString(" ")))

    def getRow(y: Int) : Vector[Int] =
        board(y)

    def getCol(x : Int) : Vector[Int] =
        (for y <- (0 until board.size)
        yield(board(y)(x))).toVector

  
    def getEmpty() : List[(Int,Int)] =
        (for y <- (0 until board.size)
            x <- (0 until board(0).size)
            if board(y)(x) == 0 
        yield (x,y)).toList
    
    
    def getSquare(x : Int, y: Int) : Vector[Int] =
        val startingX =(x / 3)*3
        val startingY =(y / 3)*3
        val a = (
            for increaseX <- (0 until 3)
            increaseY <- (0 until 3)
        yield(board(startingY+ increaseY)(startingX + increaseX)))
        a.toVector

    def change(x:Int,y:Int,value : Int) : Board =
        Board(board.updated(y,board(y).updated(x,value)))
    

    def isValid(x : Int, y : Int, value : Int) : Boolean =
        !(this.getCol(x).contains(value) || this.getRow(y).contains(value) || this.getSquare(x,y).contains(value))

    
    

}



object Board {

    def from(board: Vector[Vector[Int]]) =
        Board(board)

    def empty() = 
        Board(Vector.fill(9,9)(0))
}

