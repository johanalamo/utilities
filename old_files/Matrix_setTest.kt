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


  fun getRealTimesLarge(times:Int):Int{
    var a:Int = 0
    if (times < 0 ){
//      a = 4 - abs( col % 4)
//      a = 4 - (( col % 4) * -1)
//      a = 4 - (-( col % 4) )
      a = (4  + ( times % 4)) % 4
//        a = 4 -( times % 4) % 4
    }else{
      a = times % 4
    }
//    println("flagflag: " + a.toString())
    return a;
  }

  /** returns a value between 0 and 3 */
  fun getRealTimes(times:Int):Int {
    var r: Int = 0
    if (times < 0 )
      r =  ((4  + ( times % 4)) % 4)
    else
      r = (times % 4)
    return r

  }
  @Test
  fun realTime(){
    assertEquals ( 0, getRealTimes(-8))
    assertEquals ( 3, getRealTimes(-5))
    assertEquals ( 2, getRealTimes(-2))
    assertEquals ( 0, getRealTimes(0))
    assertEquals ( 2, getRealTimes(2))
    assertEquals ( 0, getRealTimes(4))
    assertEquals ( 1, getRealTimes(5))
    assertEquals ( 3, getRealTimes(11))
//para mas detalles:
/*
    var a:Int = 3
   for (a in -8..8) {
          println("flagflag: " + a.toString() + "  ->  " + getRealTimes(a).toString() );
    }
*/

  }


}
