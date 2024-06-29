package com.alamo.utilities


import com.alamo.utilities.Coord

/**

 * The Matrix class defines a matrix object with different numbers of rows and colums,
 * of a generic type. It provides to user several functions to manage this efficiently.
 * The numbering of rows and columns starts at 0
 *
 * @author Johan Alamo (johan.alamo@gmail.com)
 *
 * @param T the type of a generic type.
 * @param initValue the value of type T to iniatize all cells
 * @param rows the number of rows the matrix will have
 * @param cols the number of columns the matrix will have
 *
 * @property rows the number of rows the matrix has
 * @property cols the number of columns the matrix has
 * @property initValue The init value for all cells
 *
 * @constructor Creates a new Matrix object
 *
 */

class Matrix<T>(val rows: Int = 3, val cols: Int = 3, initValue: T) : Iterable<T> {
    private var data: MutableList<MutableList<T>> = mutableListOf<MutableList<T>>()

    init {
        if ((rows > 1000 || cols > 1000) || (rows < 1 || cols < 1))
            throw Exception("Rows and cols must be between 1 and 1000");
        data = mutableListOf<MutableList<T>>()
        repeat(rows) {
            var dataRow = mutableListOf<T>()
            repeat(cols) {
                dataRow.add(initValue)
            }
            data.add(dataRow)
        }
    }

    /** Set a value in a specific row and column
     * @param row Row where the value will be placed (it must be between 0 and rows - 1)
     * @param col Column where the value will be placed (it must be between 0 and cols - 1)
     * @param value Value to be placed at position ( row, col )
     * @throws IndexOutOfBoundsException if row or col is greater than rows - 1 and cols - 1
     * respectively
     */
    fun set(row: Int, col: Int, value: T) {
        data[row][col] = value
    }


    /** Returns the value inside of a specific cell
     * @param row Row where is the value to return (it must be between 0 and rows - 1)
     * @param col Column where is the value to return (it must be between 0 and cols - 1)
     * @throws IndexOutOfBoundsException if row or col is greater than rows - 1 and cols - 1
     * respectively
     * @returns the value inside the possition ( row, col )
     */
    fun get(row: Int, col: Int): T = data[row][col]

    /** Count the number of times a specific item appears
     * @param value The item to verify
     * @returns The number of times the 'value' element appears
     */
    fun count(value: T): Int = getCellsWith(value).size

    /** Obtains a list of Coord which have a specific value
     * @param value The item to search inside the matrix
     * @returns A list of Coord objects, which one will have the row and colum where the value
     * appears. If the value does not exists inside the Matrix, it will return an empty
     * list.
     */
    fun getCellsWith(value: T?): List<Coord> {
        var list: List<Coord> = listOf()
        for (r in 0..(rows - 1))
            for (c in 0..(cols - 1))
                if (data[r][c] == value)
                    list += listOf(Coord(r, c))
        return list
    }

    /** Obtains a list of Coord which have a null value
     * @returns A list of Coord objects, which one will have the row and colum where the null
     * value appears inside the matrix. If the null value does not exists, it will return an empty
     * list.
     */
    fun getEmptyCells(): List<Coord> = getCellsWith(null)

    /** Permits obtains elements formed inline inside the matrix
     *
     *  @param size the size of the lines that you want to find
     *  @param value The value that you want to find formed in line
     *
     *  @returns A list of list of Coord.
     *    It will returns a list which each LINE found. Each LINE element is a list
     *   of Coord that forms one whole line
     *   If there are no lines, then an empty list will be returned

     */
    fun getLines(size: Int, value: T): List<List<Coord>> {
        var directions: List<Direction> =
            listOf(
                Direction.EAST,
                Direction.SOUTHEAST,
                Direction.SOUTH,
                Direction.SOUTHWEST
            )
        var solutions = listOf<List<Coord>>();

        if (size < 1)
            return solutions

        for (r in 0..(rows - 1))
            for (c in 0..(cols - 1))
                if (data[r][c] == value) {
                    if (size == 1)
                        solutions += listOf(listOf(Coord(r, c)))
                    else
                        for (dir in directions) {
                            var line = getOneLine(size, value, r, c, dir)
                            if (line.size == size)
                                solutions += listOf(line)
                        }
                }

        return solutions
    }

    private fun getOneLine(size: Int, element: T, row: Int, col: Int, direction: Direction): List<Coord> {
        try {
            if (element == data[row][col]) {
                if (size == 1)
                    return listOf(Coord(row, col))
                else
                    return listOf(Coord(row, col)) + getOneLine(
                        size - 1,
                        element,
                        row + direction.row,
                        col + direction.col,
                        direction
                    )
            } else
                return listOf<Coord>()
        } catch (e: IndexOutOfBoundsException) {
            return listOf<Coord>()
        }
    }

    override fun iterator(): Iterator<T> {
        return MatrixIterator()
    }

    private inner class MatrixIterator : Iterator<T> {
        private var currentCol = 0
        private var currentRow = 0

        override fun hasNext(): Boolean = (currentRow < rows)

        override fun next(): T = get(row = currentRow, col = currentCol).apply {
            currentCol++
            if (currentCol >= cols) {
                currentCol = 0
                currentRow++
            }
        }
    }
}
