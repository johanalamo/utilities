package com.alamo.utilities

import com.alamo.utilities.*
import org.junit.Test
import org.junit.Before
import org.junit.Assert.*


class Coord_getColTest {
  @Test
  fun whenGetCol_shouldReturnTheColumnsAmount(){
    //1
    var c = Coord(8,8)

    //2
    var r = c.col

    //3
    assertEquals(8, r)
  }
}
