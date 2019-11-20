package com.alamo.utilities

import com.alamo.utilities.*
import org.junit.Test
import org.junit.Before
import org.junit.Assert.*


class Matrix_getColsTest {

  @Test
  fun whenGetCols_shouldReturnCols() {
    //1. Configure
    var m = Matrix<Int>(1,1000, 99)

    //2. Execute
    var c = m.cols

    //3. verify results
    assertEquals(1000, c)
  }
}
