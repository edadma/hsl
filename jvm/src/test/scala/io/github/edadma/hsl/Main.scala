package io.github.edadma.hsl

import swing._
import Swing._
import event._

object Main extends SimpleSwingApplication {
  var hue = 0.0
  var saturation = 0.0
  var shades = 5
  var margin = .2

  val SIZE = 400

  def top: MainFrame =
    new MainFrame {
      contents = new FlowPanel(
        new ParameterSlider("hue", 100, h => hue = h / 100.0),
        new ParameterSlider("saturation", 100, s => saturation = s / 100.0),
        new ParameterSlider("shades", 20, s => shades = s),
        new ParameterSlider("margin", 100, m => margin = m / 100.0),
        ColorPanel
      )
    }

  class ParameterSlider(name: String, maxValue: Int, change: Int => Unit)
      extends BoxPanel(Orientation.Vertical) {
    val label: Label =
      new Label("0", null, Alignment.Left) {
        preferredSize = (40, preferredSize.height)
      }

    contents += new Label(name)
    contents += label
    contents +=
      new Slider {
        min = 0
        max = maxValue
        value = 0
        orientation = Orientation.Vertical
        preferredSize = (40, SIZE)

        reactions += {
          case ValueChanged(_) =>
            change(value)
            label.text = value.toString
            ColorPanel.repaint()
        }
      }
  }

  object ColorPanel extends Panel {
    preferredSize = (SIZE, SIZE)

    override def paintComponent(gr: Graphics2D): Unit = {
      super.paintComponent(gr)

      val colors = HSL.shading(hue, saturation, shades, margin)

      for (i <- 0 until shades) {
        val HSL(r, g, b) = colors(i)

        gr setColor new Color(r.toFloat, g.toFloat, b.toFloat)
        gr.fillRect(0, SIZE / shades * i, SIZE, SIZE / shades)
      }
    }
  }
}
