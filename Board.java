//package Carromfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
import  java.lang.Cloneable;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BasicStroke;
import java.awt.Point;
import java.util.Random;

class Board
{

	
	/*int x= 35;
	int y= 20;*/
	int x=45;
	int y=40;
	/*int x=112;
	int y=166;*/
	int width=580;
	int height=575;
	public void draw(Graphics g)
			{
				
				
				Graphics2D g1=(Graphics2D)g;
				Color cream=new Color(238,243,129);
				g1.setColor(cream);
				g1.fillRect(40,25,600,600);
				
				Color brown= new Color(62,0,0);
				g1.setColor(brown);
				g1.drawRect(40,25,600,600);
				g1.drawRect(39,24,600,600);
				g1.drawRect(38,23,600,600);
				g1.drawRect(41,26,600,600);
				g1.drawRect(42,27,600,600);
				g1.drawRect(37,22,600,600);
				g1.drawRect(36,21,600,600);
				g1.drawRect(35,20,600,600);
				g1.drawRect(50,35,577,577);
				g1.drawRect(49,34,579,579);
				g1.drawRect(48,33,581,581);
				g1.drawRect(47,32,583,583);
				g1.drawRect(46,31,585,585);
				g1.drawRect(45,30,587,587);
				g1.drawRect(44,29,589,589);
				g1.drawRect(43,28,591,591);
				g1.drawRect(42,27,593,593);
				g1.drawRect(41,26,595,595);
				g1.drawRect(40,25,593,593);
				g1.drawRect(39,24,595,595);
				g1.drawRect(38,23,597,597);
				g1.drawRect(37,22,599,599);
				
				g1.setColor(Color.black);
				//for drawing the four rectangles
				g1.drawRect(158,91,362,25);
				g1.drawRect(158,529,362,25);
				g1.drawRect(112,141,25,362);
				g1.drawRect(540,141,25,362);
				
				Color maron=new Color(185,0,0);
				g1.setColor(maron);
				//for drawing the circles in the rectangles
				g1.fillOval(110,131,30,30);
				g1.fillOval(152,88,30,30);
				g1.fillOval(497,88,30,30);
				g1.fillOval(537,131,30,30);
				g1.fillOval(537,487,30,30);
				g1.fillOval(110,487,30,30);
				g1.fillOval(152,527,30,30);
				g1.fillOval(497,527,30,30);
				
				//for drawing outlines
				g1.setColor(Color.black);
				g1.drawOval(110,131,30,30);
				g1.drawOval(152,88,30,30);
				g1.drawOval(497,88,30,30);
				g1.drawOval(537,131,30,30);
				g1.drawOval(537,487,30,30); 
				g1.drawOval(110,487,30,30);
				g1.drawOval(152,527,30,30);
				g1.drawOval(497,527,30,30);
				
				//darkening one side of rectangles
				g1.drawLine(158,90,520,90);
				g1.drawLine(158,89,520,89);
				g1.drawLine(111,141,111,503);
				g1.drawLine(110,141,110,503);
				g1.drawLine(566,141,566,503);
				g1.drawLine(567,141,567,503);
				g1.drawLine(158,555 ,520,555 );
				g1.drawLine(158,556,520,556);
				
				//center
				g1.drawOval(259,245,140,140);
				
				//Graphics2D g3=(Graphics2D)g;
				g1.setColor(Color.black);
				g1.fillOval(45,30,40,40);
				g1.fillOval(592,30,40,40);
				g1.fillOval(592,577,40,40);
				g1.fillOval(45,577,40,40);

			}
}
