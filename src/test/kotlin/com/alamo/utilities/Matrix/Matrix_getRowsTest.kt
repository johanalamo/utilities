package com.alamo.utilities

import com.alamo.utilities.*
import org.junit.Test
import org.junit.Before
import org.junit.Assert.*


class Matrix_getRowsTest {

  @Test
  fun whenGetRows_shouldReturnRows() {
    //1
    var m = Matrix<Int>(1,1000, 99)

    //2
    var r = m.rows

    //3
    assertEquals(1, r)
  }
}
