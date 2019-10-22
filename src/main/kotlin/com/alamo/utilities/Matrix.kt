package com.alamo.utilities


import com.alamo.utilities.Coord

/**
 * The `Language` type defines a programming language with a name and hotness score.
 *
 * @property name The name of the language.
 * @property hotness A score from 1 to 10 of user enthusiasm. 10 = so hot right now
 */

class Matrix<T>(val rows:Int = 3, val cols:Int = 3, initValue:T) {
  private var data:MutableList<MutableList<T>> = mutableListOf<MutableList<T>>()

  init {
    if ((rows > 20 || cols > 20) || (rows < 1 || cols < 1))
      throw Exception("Rows and cols must be between 1 and 20");
    data = mutableListOf<MutableList<T>>()
    repeat (rows){
      var dataRow = mutableListOf<T>()
      repeat (cols) {
        dataRow.add(initValue)
      }
      data.add(dataRow)
    }
  }
  fun set(row:Int,col:Int, value:T){
    data[row][col] = value
  }
  fun get(row:Int,col:Int):T = data[row][col]

  fun count(value:T):Int = getCellsWith(value).size

  fun getCellsWith(element:T?):List<Coord>{
    var list:List<Coord> = listOf()
    for(r in 0..(rows-1))
      for (c in 0..(cols-1))
        if (data[r][c] == element)
          list += listOf(Coord(r,c))
    return list
  }

  fun getEmptyCells():List<Coord> = getCellsWith(null)

  fun getLines(size:Int,element:T):List<List<Coord>>{
    var directions:List<Direction> =
          listOf(
              Direction.EAST,
              Direction.SOUTHEAST,
              Direction.SOUTH,
              Direction.SOUTHWEST
              )
    var solutions = listOf<List<Coord>>();

    if (size < 1)
      return solutions

    for(r in 0..(rows-1))
      for (c in 0..(cols-1))
        if (data[r][c] == element){
          if (size == 1)
            solutions += listOf(listOf(Coord(r,c)))
          else
            for (dir in directions){
                var line = getOneLine(size, element, r, c, dir)
                if (line.size==size)
                  solutions += listOf(line)
            }
      }

    return solutions
  }
  private fun getOneLine(size:Int, element:T, row:Int,col:Int,direction:Direction):List<Coord>{
    try {
      if (element == data[row][col]){
        if (size == 1)
          return listOf(Coord(row,col))
        else
          return listOf(Coord(row,col)) + getOneLine(size - 1, element, row + direction.row , col + direction.col, direction)
      }else
        return listOf<Coord>()
    }catch(e:IndexOutOfBoundsException){
        return listOf<Coord>()
    }
  }

  fun newMethod(): Int = 10

  
}
