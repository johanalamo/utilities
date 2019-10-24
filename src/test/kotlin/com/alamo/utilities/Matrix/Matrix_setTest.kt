package com.alamo.utilities

import com.alamo.utilities.*
import org.junit.Test
import org.junit.Before
import org.junit.Assert.*


class Matrix_setTest {

  @Test
  fun whenSet_shouldAssignTheValue() {
    //1
    var m = Matrix<Int>(20,20, 99)

    //2
    m.set(10,10,77)

    //3
    assertEquals(77, m.get(10,10))
  }
}
