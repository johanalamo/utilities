package com.alamo.utilities


/**
 * The Direction enum defines the differents directios to move in a Matrix, in
 * the form of cardinal points (north, northeast, east, southwest, etc).
 *
 * Each cardinal point has two relative values: row and col. And each one will
 * have the value (-1, 0 or 1) will satisfy the direction movement of this
 * cardinal point. For example, North direction implies up one value in the
 * matrix row (-1), but stay in the same column (value 0). For
 * Northwest, row is -1 and col is -1, for southeast row=1 and col=1
 *
 * @author Johan Alamo (johan.alamo@gmail.com)
 *
 * @property row Positions to move in the matrix row (-1, 0 or 1)
 * @property col Positions to move in the matrix column (-1, 0 or 1)
 */
enum class Direction(val row: Int,val col: Int) {
  /** North direction value (row=-1, col=0)  */
  NORTH     (-1, 0),
  /** Abbreviated NORTH */
  N         (-1, 0),

  /** Northeast direction value (row=-1, col=1)  */
  NORTHEAST (-1, 1),
  /** Abbreviated NORTHEAST */
  NE        (-1, 1),   //abbreviated

  /** East direction value (row=0, col=1)  */
  EAST      ( 0, 1),
  /** Abbreviated EAST */
  E         ( 0, 1),   //abbreviated

  /** Southeast direction value (row=1, col=1)  */
  SOUTHEAST ( 1, 1),
  /** Abbreviated SOUTHEAST */
  SE        ( 1, 1),   //abbreviated

  /** South direction value (row=1, col=0)  */
  SOUTH     ( 1, 0),
  /** Abbreviated SOUTH */
  S         ( 1, 0),   //abbreviated

  /** Southwest direction value (row=1, col=-1)  */
  SOUTHWEST ( 1,-1),
  /** Abbreviated SOUTHWEST */
  SW        ( 1,-1),   //abbreviated

  /** West direction value (row=0, col=-1)  */
  WEST      ( 0,-1),
  /** Abbreviated WEST */
  W         ( 0,-1),   //abbreviated

  /** Northwest direction value (row=-1, col=-1)  */
  NORTHWEST (-1,-1),
  /** Abbreviated NORTHWEST */
  NW        (-1,-1),   //abbreviated

  /** No direction (row=0, col=0) */
  CENTER    ( 0, 0),
  /** Abbreviated CENTER */
  C         ( 0, 0)
}
