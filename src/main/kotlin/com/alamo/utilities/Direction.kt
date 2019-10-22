package com.alamo.utilities

enum class Direction(val row: Int,val col: Int) {

  NORTH     (-1, 0),
  N         (-1, 0),   //abbreviated

  NORTHEAST (-1, 1),
  NE        (-1, 1),   //abbreviated

  EAST      ( 0, 1),
  E         ( 0, 1),   //abbreviated

  SOUTHEAST ( 1, 1),
  SE        ( 1, 1),   //abbreviated

  SOUTH     ( 1, 0),
  S         ( 1, 0),   //abbreviated

  SOUTHWEST ( 1,-1),
  SW        ( 1,-1),   //abbreviated

  WEST      ( 0,-1),
  W         ( 0,-1),   //abbreviated

  NORTHWEST (-1,-1),
  NW        (-1,-1),   //abbreviated
}
