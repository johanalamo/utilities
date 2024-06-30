package com.alamo.utilities.Matrix

import com.alamo.utilities.Matrix
import org.junit.Before
import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertTrue


class Matrix_forEach {

    lateinit var sut:Matrix<Int>

    @Before
    fun setUp() {
        sut = Matrix(ROWS,COLS,0)
        for (r in 0..<ROWS) {
            for(c in 0..<COLS) {
                sut.set(row = r, col = c, Random.nextInt(100))
            }
        }
    }

    @Test
    fun whenForEachIsExecuted_processesEveryElementInTheMatrix() {
        var r = 0
        var c = 0
        sut.myOwnForEach {
            assertTrue { it == sut.get(r,c) }
            c++
            if (c>= COLS) {
                c = 0
                r++
            }
        }
        assertTrue { c == 0 }
        assertTrue { r == ROWS }
    }

    companion object {
        private const val COLS = 5
        private const val ROWS = 4
    }
}

