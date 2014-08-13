package ca.hyperreal.color

import swing._
import Swing._
import event._
import java.awt.Color._


object Main extends SimpleSwingApplication
{
	var hsl = HSL.fromColor( BLACK )
	var shades = 5
	var margin = .2
	
	val SIZE = 100
	
	def top =
		new MainFrame
		{
			contents =
				new FlowPanel(
					new ParameterSlider(h => {hsl = hsl.hue(h/100.0)}),
					new ParameterSlider(s => {hsl = hsl.saturation(s/100.0)}),
					new ParameterSlider(l => {hsl = hsl.luminosity(l/100.0)}),
					ColorPanel )
		}
		
	class ParameterSlider( notify: Int => Unit ) extends Slider
	{
		min = 0
		max = 100
		value = 0
		orientation = Orientation.Vertical
		preferredSize = (preferredSize.width, SIZE)
		
		reactions += {
			case ValueChanged( _ ) =>
				notify( value )
				ColorPanel.repaint
		}
	}
	
	object ColorPanel extends Panel
	{
		preferredSize = (SIZE, SIZE)
		
		override def paintComponent( g: Graphics2D )
		{
			super.paintComponent( g )

		val colors = hsl.shading( shades, margin )
		
			for (i <- 0 until shades)
			{
				g setColor colors(i)
				g.fillRect( 0, SIZE/shades*i, SIZE, SIZE/shades )
			}
		}
	}
}