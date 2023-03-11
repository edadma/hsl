package io.github.edadma.hsl

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class UnitTests extends AnyFreeSpec with Matchers {
  "reversible" in {
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
        (255, 200, 0), // orange
      )

    for ((r, g, b) <- colors)
      HSL.fromRGB(r, g, b).toRGBInt shouldBe (r, g, b)
  }
}
