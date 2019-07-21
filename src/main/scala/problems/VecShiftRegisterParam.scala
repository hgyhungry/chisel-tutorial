// See LICENSE.txt for license details.
package problems

import chisel3._

// Problem:
//
// Implement a parametrized simple shift register.
// 'n' is the number of elements in the shift register.
// 'w' is the width of one element.

class VecShiftRegisterParam(val n: Int, val w: Int) extends Module {
  val io = IO(new Bundle {
    val in  = Input(UInt(w.W))
    val out = Output(UInt(w.W))
  })

  // Implement below ----------

  val shiftReg = RegInit(VecInit(Seq.fill(n){0.U(w.W)}))
  shiftReg(0) := io.in
  for (i <- 1 until n) shiftReg(i) := shiftReg(i-1)
  
  io.out := shiftReg(n-1)
}
// Implement above ----------
