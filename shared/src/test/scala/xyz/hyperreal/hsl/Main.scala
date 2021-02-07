package xyz.hyperreal.hsl

object Main extends App {}

//import swing._
//import Swing._
//import event._
//import java.awt.Color._
//
//
//object Main extends SimpleSwingApplication
//{
//	var hue = 0.0
//	var saturation = 0.0
//	var shades = 5
//	var margin = .2
//	
//	val SIZE = 400
//	
//	def top =
//		new MainFrame
//		{
//			contents =
//				new FlowPanel(
//					new ParameterSlider(100, h => hue = h/100.0),
//					new ParameterSlider(100, s => saturation = s/100.0),
//					new ParameterSlider(20, s => shades = s),
//					new ParameterSlider(100, m => margin = m/100.0),
//					ColorPanel )
//		}
//		
//	class ParameterSlider( maxValue: Int, change: Int => Unit ) extends BoxPanel( Orientation.Vertical )
//	{
//	val label =
//		new Label( "0", null, Alignment.Left )
//		{
//			preferredSize = (40, preferredSize.height)
//		}
//	
//		contents += label
//		contents +=
//			new Slider
//			{
//				min = 0
//				max = maxValue
//				value = 0
//				orientation = Orientation.Vertical
//				preferredSize = (40, SIZE)
//				
//				reactions += {
//					case ValueChanged( _ ) =>
//						change( value )
//						label.text = value.toString
//						ColorPanel.repaint
//				}
//			}
//	}
//	
//	object ColorPanel extends Panel
//	{
//		preferredSize = (SIZE, SIZE)
//		
//		override def paintComponent( g: Graphics2D ) = {
//			super.paintComponent( g )
//
//		val colors = HSL.shading( hue, saturation, shades, margin )
//		
//			for (i <- 0 until shades)
//			{
//				g setColor colors(i)
//				g.fillRect( 0, SIZE/shades*i, SIZE, SIZE/shades )
//			}
//		}
//	}
//}
