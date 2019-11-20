package com.alamo.utilities

import com.alamo.utilities.*
import org.junit.Test
import org.junit.Before
import org.junit.Assert.*


class Matrix_constructTest {

  @Test(expected=Exception::class)
  fun whenRowsLessThanOne_shouldProduceAnException() {
    Matrix<Int>(0,1, 99)
  }

  @Test(expected=Exception::class)
  fun whenRowsGreaterThan1000_shouldProduceAnException() {
    Matrix<Int>(1001,1, 99)
  }

  @Test(expected=Exception::class)
  fun whenColsLessThanOne_shouldProduceAnException() {
    Matrix<Int>(1,0, 99)
  }

  @Test(expected=Exception::class)
  fun whenColsGreaterThan1000_shouldProduceAnException() {
    Matrix<Int>(1,1001, 99)
  }

  @Test
  fun whenColsAndRowsAreInRange_shouldConstructTheMatrix() {
    Matrix<Int>(1,1000, 99)
  }
}
