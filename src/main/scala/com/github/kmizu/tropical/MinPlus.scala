package com
package github
package kmizu
package tropical

class MinPlus(x: Double) {
  import MinPlus._
  private val _val = valueOf(x)

  def value: Double = _val

  def this() {
    this(MinPlus._internal_infinity)
  }

  def isInfinity(): Boolean = _val == _internal_infinity

  private def valueOf(x: Double): Double = {
    if (x == _internal_infinity || x >= 0) x
    else throw new Exception("Invalid MinPlus Value")
  }

  def +(rhs: MinPlus): MinPlus = {
    new MinPlus(_min(_val, rhs._val))
  }

  def *(rhs: MinPlus): MinPlus = {
    new MinPlus(_sum(_val, rhs._val))
  }

  override def toString: String = if(isInfinity()) "∞" else value + ""
}
object MinPlus {
  private val _internal_infinity = -1

  def apply(x: Double): MinPlus = new MinPlus(x)
  def apply(): MinPlus = new MinPlus()

  def _min(x: Double, y: Double): Double = {
    if (x == _internal_infinity) y
    else if (y == _internal_infinity) x
    else if (x <= y) x
    else y
  }
  def _sum(x: Double, y: Double): Double = {
    if (x == _internal_infinity) _internal_infinity
    else if (y == _internal_infinity) _internal_infinity
    else x + y
  }
  val INFINITY: MinPlus = MinPlus(_internal_infinity)
  val Zero: MinPlus = INFINITY
  val One: MinPlus = MinPlus(0)
  implicit class RichLong(self: Long) {
    def mp: MinPlus = MinPlus(self)
  }
  implicit class RichDouble(self: Double) {
    def mp: MinPlus = MinPlus(self)
  }
  implicit def long2MinPlus(value: Long): MinPlus = MinPlus(value)
  implicit def double2MinPlus(value: Double): MinPlus = MinPlus(value)
  def inf: MinPlus = INFINITY
}
