// See LICENSE.txt for license details.
package problems

import chisel3._

// Problem:
//
// Implement a loadable shift register with four 4-bit stages using Vec
// Shift occurs if 'shift' is asserted
// Load  occurs if 'load'  is asserted
// Whole state should be replaced with 'ins' when loaded
//
class VecShiftRegister extends Module {
  val io = IO(new Bundle {
    val ins   = Input(Vec(4, UInt(4.W)))
    val load  = Input(Bool())
    val shift = Input(Bool())
    val out   = Output(UInt(4.W))
  })
  // Implement below ----------
  
  val shiftReg = Reg(VecInit(Seq.fill(4){0.U(4.W)}))
  when (io.load) {
    shiftReg(0) := io.ins(0)
    shiftReg(1) := io.ins(1)
    shiftReg(2) := io.ins(2)
    shiftReg(3) := io.ins(3)
  }
  .elsewhen (io.shift) {
    shiftReg(0) := io.ins(0)
    shiftReg(1) := shiftReg(0)
    shiftReg(2) := shiftReg(1)
    shiftReg(3) := shiftReg(2)
  }

  io.out := shiftReg(3)

  // Implement above ----------
}
