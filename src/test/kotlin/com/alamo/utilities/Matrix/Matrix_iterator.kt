package com.alamo.utilities.Matrix

import com.alamo.utilities.Matrix
import org.junit.Before
import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class Matrix_iterator {

    lateinit var sut:Matrix<Int>
    @Before
    fun setUp() {
        sut = Matrix(6,5,0)
        for (row in 0..sut.rows-1) {
            for (col in 0..sut.cols-1) {
                sut.set(row = row, col = col, Random.nextInt(100))
            }
        }
    }
    @Test
    fun whenMatrixIsIterated_shouldDoItLeftToRightAndTopToBottom() {
        val iterator = sut.iterator()

        for (r in 0..sut.rows-1) {
            for (c in 0..sut.cols-1) {
                assertTrue { iterator.hasNext() }
                assertEquals(expected = sut.get(r,c), actual = iterator.next())
            }
        }
        assertFalse { iterator.hasNext() }
    }
}