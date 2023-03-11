package io.github.edadma.hsl

object HSL:
  def fromRGB(red: Int, green: Int, blue: Int): HSL = fromRGB(red / 255.0, green / 255.0, blue / 255.0)

  def fromRGB(red: Double, green: Double, blue: Double): HSL =
    val max = red max green max blue
    val min = red min green min blue

    val l = (max + min) / 2
    var h = l
    var s = l

    if (max == min)
      h = 0
      s = 0
    else
      val d = max - min

      s = if (l > 0.5) d / (2 - max - min) else d / (max + min)

      max match
        case `red`   => h = (green - blue) / d + (if (green < blue) 6 else 0)
        case `green` => h = (blue - red) / d + 2
        case `blue`  => h = (red - green) / d + 4

      h /= 6

    HSL(h, s, l)

  def shading(h: Double, s: Double, shades: Int, margin: Double): Seq[HSL] =
    for (i <- 1 to shades)
      yield HSL(h, s, (1 - margin * 2) / shades * i + margin)
end HSL

case class HSL(h: Double, s: Double, l: Double):
  def hue(newh: Double): HSL = HSL(newh, s, l)

  def saturation(news: Double): HSL = HSL(h, news, l)

  def luminosity(newl: Double): HSL = HSL(h, s, newl)

  def toRGBInt: (Int, Int, Int) =
    val (r, g, b) = toRGB

    ((r * 255).round.toInt, (g * 255).round.toInt, (b * 255).round.toInt)

  def toRGB: (Double, Double, Double) =
    if (s == 0) (l, l, l)
    else
      def hue2rgb(p: Double, q: Double, t: Double) =
        val _t =
          if (t < 0)
            t + 1
          else if (t > 1)
            t - 1
          else
            t

        if (_t < 1 / 6.0)
          p + (q - p) * 6 * _t
        else if (_t < 1 / 2.0)
          q
        else if (_t < 2 / 3.0)
          p + (q - p) * (2 / 3.0 - _t) * 6
        else
          p
      end hue2rgb

      val q = if (l < 0.5) l * (1 + s) else l + s - l * s
      val p = 2 * l - q

      (hue2rgb(p, q, h + 1 / 3.0), hue2rgb(p, q, h), hue2rgb(p, q, h - 1 / 3.0))
  end toRGB
end HSL
