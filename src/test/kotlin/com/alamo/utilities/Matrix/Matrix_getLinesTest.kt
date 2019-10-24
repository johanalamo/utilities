package com.alamo.utilities

import com.alamo.utilities.*
import org.junit.Test
import org.junit.Before
import org.junit.Assert.*


class Matrix_getLinesTest {
  var m:Matrix<String?> = Matrix(4,4,null)
  var c1 = "X"
  var c2 = "O"
  var c3 = "P"

  @Before
  fun init(){
    m = Matrix(4,4,null)
    c1 = "X"
    c2 = "O"
    c3 = "P"
    //table for this example
    //  c1  c1  c3  c2
    //  --  --  c2  c2
    //  --  c2  --  c2
    //  c2  c3  c1  c1

    //sets for c1
    m.set(0,0,c1)
    m.set(0,1,c1)
    m.set(3,2,c1)
    m.set(3,3,c1)
    //sets for c2
    m.set(0,3,c2)
    m.set(1,2,c2)
    m.set(2,1,c2)
    m.set(3,0,c2)
    m.set(1,3,c2)
    m.set(2,3,c2)
    //sets for c3
    m.set(0,2,c3)
    m.set(3,1,c3)
  }


  @Test
  fun whenGetLines_ShouldReturnListOfLines(){
    //asserts for c1
    assertEquals(2,m.getLines(2,c1).size) //there are two lines of length two for c1
    assertEquals(4,m.getLines(1,c1).size)//there are four lines of length one for c1

    //asserts for c2
    assertEquals(1,m.getLines(4,c2).size) //there are four lines of length one for c2
    assertEquals(3,m.getLines(3,c2).size) //there three lines of length three for c2

    //asserts for c3
    assertEquals(2,m.getLines(1,c3).size)//there are two lines of length one for c3
    assertEquals(0,m.getLines(2,c3).size)//there are zero lines of length two for c3
    assertEquals(0,m.getLines(5,c3).size)//there are zero lines of length two for c3

    //check lines of nulls
    assertEquals(4,m.getLines(2,null).size)//there are four lines of length two for null

    //check when size Line is smaller than 1
    assertEquals(0,m.getLines(-1,null).size)//there are four lines of length two for null

  }
}
