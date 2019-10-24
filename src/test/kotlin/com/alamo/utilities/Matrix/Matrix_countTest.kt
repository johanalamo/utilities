package com.alamo.utilities

import com.alamo.utilities.*
import org.junit.Test
import org.junit.Before
import org.junit.Assert.*


class Matrix_countTest {
  @Test
  fun whenCount_shouldReturnCantOfElements(){
    //1. configure
    var m = Matrix<Int>(7,7, 10)
    m.set(2,1, 22)
    m.set(3,4, 33)

    //2. execute
    var a = m.count(10)

    //3. verify
    assertEquals( 7*7 - 2, a)

  }
}
