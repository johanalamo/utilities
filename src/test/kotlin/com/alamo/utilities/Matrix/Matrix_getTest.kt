package com.alamo.utilities

import com.alamo.utilities.*
import org.junit.Test
import org.junit.Before
import org.junit.Assert.*


class Matrix_getTest {

  @Test
  fun whenGet_shouldReturnTheValue() {
    //1
    var m = Matrix<Int>(20,20, 99)

    //2
    var r = m.get(10,10)

    //3
    assertEquals(99, r)
  }
}
