package ca.hyperreal.hsl

import org.scalatest._
import prop.PropertyChecks

import java.awt.Color
import java.awt.Color._


class HSLTest extends FreeSpec with PropertyChecks with Matchers
{
	"reversible" in
	{
		for (c <- List(WHITE, GRAY, RED, GREEN, BLUE, BLACK, YELLOW, MAGENTA, ORANGE))
			HSL.fromColor( c ).toColor shouldBe c
	}
}