package com.alamo.utilities

import com.alamo.utilities.*
import org.junit.Test
import org.junit.Before
import org.junit.Assert.*


class Matrix_getEmptyCellsTest {

  @Test
  fun whenGetEmptyCells_shouldReturnTheAmountOfEmptyCells(){
    //1. configure
    var m = Matrix<Int?>(6, 6, null)
    m.set(5,4, 88)

    //2. execute
    var r = m.getEmptyCells().contains(Coord(5,4))

    //3. verify results
    assertEquals(false, r)
  }

}
