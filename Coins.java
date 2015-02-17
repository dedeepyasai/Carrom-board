//package Carromfinal;
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
import java.awt.Color;
class Coins
{

	
	 double x = 0;
	 double y = 0;
	 double radius = 14;
	 double dx = 0;
	 double dy = 0;
	 double dist=0;
	 double velx=0;
	 double vely=0;
	 double angleInDegree=0;
	 double friction=0.10;
	 int player=1;
	Board board;
	int[] bflag=new int[18];
	int sflag=0;
	int qflag=0;
	//private double coinradius=12;
	
	

	public Coins(Board b){
		board=b;
	}
	
	public void changeplayer()
	{
		if(player==1)
			player=2;
		else
			player=1;
	}

	public int  checkcollision(Coins c)
	{
		// TODO Auto-generated method stub
		if(Math.pow(this.x - c.x, 2) + Math.pow(this.y - c.y, 2)  <= 4*radius*radius){
			System.out.println("collision at " + this.x + "and" + c.x);
			return(1);
		}
		return(0);
	}
	
	
	public void doupdate()
	{
		speed();
		//m.repaint();
	}
	
	
	public void speed()
	{
		//double x1=x;
		//double y1=y;
		//dist=Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
		
		double angle=Math.abs(Math.atan(dy/dx));
		
	//	System.out.println("angle="+angle);
		//double speed=3*dist;
		velx=(double)(friction* Math.cos(angle));
		vely=(double)(friction* Math.sin(angle));
	//	System.out.println("x="+x+"dx="+dx);
		//System.out.println("board.x"+board.x);
		//System.out.println("board.width"+board.width);
	//	System.out.println("radius"+radius);
		
		if(x + dx > board.x + board.width -  radius)
		{
		//	System.out.println("1");
			x = board.x + board.width - radius ;
			dx = -dx;
		}
		else if(x + dx < (board.x + radius+5)&&x+dx>-50)
		{
			
			
		//	System.out.println("2");
			x = board.x + radius +5;
			dx = -dx;
		}
		else 
		{
			//	System.out.println("3");
				x += dx ;
		}
		if(dx > 0)
		{
		//System.out.println("4");
		dx -= velx;
				if(dx < 0)
				{
					dx = 0 ;
					dy = 0 ;
				}
			}
			if(dx < 0){
				dx += velx;
				if(dx > 0 ){
					dx = 0;
					dy = 0 ;
				}
			}
		
			
		if(y + dy > board.y+ board.height - radius){
			y = board.y+ board.height - radius ;
			dy = -dy;
		}
		else if(y + dy < (board.y + radius)&&y+dy>-50){
			y = board.y + radius ;
			dy = -dy;
		}
		else {
			y += dy ;
			}
		/*	if(Math.abs(dy) < 0.25  ){
				//dx=0;
				dy=0;}*/
				
		
			if(dy > 0){
				dy -= vely;
				if(dy < 0){
					dy = 0 ;
					dx=0;
					}
			}
			if(dy < 0){
				dy += vely;
				if(dy > 0 ){
					dy = 0;
					dx = 0;
					}
			}
	}
		
		
	  public void draw(Graphics g, int i){
		if(i==1)
		
			g.setColor(Color.BLACK);
			
		
		if(i==2)
		
			g.setColor(Color.white);
			
		
		if(i==3)
		
			g.setColor(Color.BLUE);
		if(i==4)
			g.setColor(Color.RED);
			
		
		
		g.fillOval((int)(x-radius), (int)(y-radius) ,(int) (radius*2), (int)(radius*2));
		
	}
	public double  getx(){
		return(this.x);
	}
	
	public double gety(){
		return(this.y);
	}
	
	public void setx(double x){
		this.x = x;
	}
	
	public void sety(double y){
		this.y = y;
	}
	public double  getdx(){
		return(this.dx);
	}
	public double  getdy(){
		return(this.dy);
	}
	public void setdx(double dx){
		this.dx = dx;
	}
	public void setdy(double dy){
		this.dy = dy;
	}
	
	/*public void moveleft(double x) {
		this.x=x;
			// TODO Auto-generated method stub
			//if(x > (123))
				//x=x-3;
		}

		public void moveright(double x) {
		this.x=x;

			// TODO Auto-generated method stub
			//if(x < (555))
				//	x=x+3; 
		}*/
	public void moveleft()
	{
		if(x>168/*&&y>529&&y<559*/)
		{
			/*if(y>529&&y<559)
			{
				System.out.println("collided with the coin1");
				x=x+5;
			}
			else*/
				x=x-3;
		}
		
	}
	public void moveright()
	{
		if(x<512/*&&y>529&&y<559*/)
		{
			/*if(y>529&&y<559)
			{
				System.out.println("collided with the coin2");
				x=x+5;
			}	
			else*/
			x=x+3;
		}
		
		
	}
	public void collide(Coins c) 
	{
		// TODO Auto-generated method stub
		//System.out.println("collide method");
		int nx = (int)(c.getx() - this.getx());
		int ny = (int)(c.gety() - this.gety());
		double nmag =  Math.sqrt((nx*nx)+(ny*ny));
		double unx = nx/nmag;
		double uny = ny/nmag;
		double utx = -1*uny;
		double uty = unx;
		double u1y = this.getdy();
		System.out.println("u1y="+u1y);
		double u1x = this.getdx();
		System.out.println("u1x="+u1x);
		double u2y = c.getdy();
		System.out.println("c.getdy()"+c.getdy());
		double u2x = c.getdx();
		System.out.println("c.getdx="+c.getdx());
		
		double v1n = u2y*uny + u2x*unx;
		double v2n = u1y*uny + u1x*unx;
		double v1t = u1y*uty + u1x*utx;
		double v2t = u2y*uty + u2x*utx;
		
		double v1x = unx*v1n + utx*v1t;
		double v1y = uny*v1n + uty*v1t;
		double v2x = unx*v2n + utx*v2t;
		double v2y = uny*v2n + uty*v2t;
		
		
		c.setx(this.getx() + (int)(2*(radius+2)* unx));
		c.sety(this.gety() + (int)(2*(radius+2)* uny));
		
		this.setdx(v1x);
		this.setdy(v1y);
	
		
		c.setdx(v2x);
		c.setdy(v2y);
		
		//System.out.println("collide ");
		
	}

	
	
}
