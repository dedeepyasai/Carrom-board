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


public class CarromBoardMod
{
	public static void main(String arggs[])
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				//System.out.println("createdGui on edt?"+SwingUtilities.isEventDispatchThread());
				JFrame f=new JFrame("CARROM BOARD");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.add(new Draw());
				f.setVisible(true);
				f.pack();
				f.setBackground(Color.gray);
				f.setSize(1000,700);
				f.requestFocusInWindow();
			}
		});
		
		}

}
