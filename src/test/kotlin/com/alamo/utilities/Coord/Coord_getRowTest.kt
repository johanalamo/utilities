package com.alamo.utilities

import com.alamo.utilities.*
import org.junit.Test
import org.junit.Before
import org.junit.Assert.*


class Coord_getRowTest {
  @Test
  fun whenGetRow_shouldReturnTheRowsAmount(){
    //1
    var c = Coord(7,8)

    //2
    var r = c.row

    //3
    assertEquals(7, r)
  }

}
