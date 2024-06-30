package com.alamo.utilities.Matrix

import com.alamo.utilities.Matrix
import org.junit.Before
import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class Matrix_myOwnReduce {

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
    fun whenMyOwnReduceIsExecutedWithPlus_processesEveryElementInTheMatrixAndGetTheSum() {
        val i = sut.iterator()
        var expectedSum = i.next()
        while (i.hasNext()) { expectedSum += i.next() }

        var currentSum = sut.myOwnReduce({a, b -> a + b})
        assertTrue { expectedSum == currentSum }
    }

    @Test
    fun whenMyOwnReduceIsExecutedWithMinus_processesEveryElementInTheMatrixAndGetTheSubstract() {
        val i = sut.iterator()
        var expectedResult = i.next()
        while (i.hasNext()) { expectedResult -= i.next() }

        var currentResult = sut.myOwnReduce({a, b -> a - b})
        assertTrue { expectedResult == currentResult }
    }

    @Test
    fun whenMyOwnReduceIsExecutedWithString_shoulrReturnTheConcatenation () {
        var sut: Matrix<String> = Matrix(2,2,"")
        sut.set(0,0,"aA")
        sut.set(0,1,"bB")
        sut.set(1,0,"cC")
        sut.set(1,1,"dD")
        val expectedResult = "aAbBcCdD"

        val actualResult = sut.myOwnReduce { s, s2 -> s + s2 }

        assertEquals(expected = expectedResult, actual = actualResult)
    }

    companion object {
        private const val COLS = 5
        private const val ROWS = 4
    }
}

