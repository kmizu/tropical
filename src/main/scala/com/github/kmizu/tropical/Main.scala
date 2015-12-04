package com.github.kmizu.tropical
import com.github.kmizu.tropical.MinPlus._

object Main {
  def main(args: Array[String]): Unit = {

    println((1L.mp + 3L + inf) * 5L + 3L * 2L)

    // 1 + 1 = 1
    println(s"1 + 1 = ${1L.mp + 1L}")

    // 2 + 3 = 3
    println(s"2 + 3 = ${2L + 3L.mp}")

    // 2 * 3 = 5
    println(s"2 * 3 = ${2L * 3L.mp}")

    // 2 * 0 = 2
    println(s"2 * 0 = ${2L * 0L.mp}")

    // 3 + ∞ = 3
    println(s"3 + ∞ = ${3L + inf}")

    // 3 * ∞ = ∞
    println(s"3 * ∞ = ${3L * inf}")
  }
}
