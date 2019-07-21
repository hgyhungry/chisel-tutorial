// See LICENSE.txt for license details.
package problems

import chisel3.iotesters.PeekPokeTester

// Problem:
//
// Implement test with PeekPokeTester
//
class Max2Tests(c: Max2) extends PeekPokeTester(c) {
  for (i <- 0 until 10) {

    // Implement below ----------

    poke(c.io.in0, i)
    poke(c.io.in1, (10-i))
    step(1)
    val res = if (i>(10-i)) i else (10-i)
    expect(c.io.out, res)

    // Implement above ----------
  }
}
