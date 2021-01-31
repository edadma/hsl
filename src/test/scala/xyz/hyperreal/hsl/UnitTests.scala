package xyz.hyperreal.hsl

import utest._

object UnitTests extends TestSuite {
  val tests: Tests = Tests {
    test("reversible") {
      val colors =
        List(
          (255, 255, 255), // white
          (128, 128, 128), // gray
          (255, 0, 0), // red
          (0, 255, 0), // green
          (0, 0, 255), // blue
          (0, 0, 0), // black
          (255, 255, 0), // yellow
          (255, 0, 255), // magenta
          (255, 200, 0) // orange
        )

      for ((r, g, b) <- colors)
        HSL.fromRGB(r, g, b).toRGB ==> (r, g, b)
    }
  }
}
