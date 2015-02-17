//package Carromfinal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
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
import java.awt.Font;
import java.awt.RenderingHints;

class Draw extends JPanel implements Runnable
{
	int shotplayed=0;
	int setstroke=0;
	static Board b=new Board();
	static Coins striker = new Coins(b);
	static Coins queen=new Coins(b);
	 static final int BOX_WIDTH=800;
	 static final int BOX_HEIGHT=800;
	 double pf=0.23;
	 Point mouse = new Point();
	 		
			int lowery=542;
			int uppery=103;
			int count=1;
			int numberofcoins=18;
			Coins[] bcoin  = new Coins[numberofcoins]; 
			/*int gap1=0;
			int gap2=0;
			int gap3=0;
			int gap4=0;*/
			int gap=0;
			boolean st=false;
			int countcoins1=0;
			int countcoins2=0;
	 public Draw()
	  {
		 
		 setKeyBindings();
			//striker=new Coins();
			for(int j=0;j<numberofcoins;j++)
			{
				bcoin[j]=new Coins(b);
			}
			for(int j=0; j < numberofcoins; j++)
			{
				int x=259;
				int y=245;
				Random r = new Random();
				//bcoin[j].setx(b.x + 50+r.nextInt(510));
				//bcoin[j].sety(b.y +50+ r.nextInt(510));
				bcoin[j].setx(147+r.nextInt(388));
				bcoin[j].sety(133+r.nextInt(395));
			
				bcoin[j].setdx(0);
				bcoin[j].setdy(0);
			
			}
				striker.setx(337);
			   striker.sety(lowery);
			   queen.setx(337);
				queen.sety(500);
				queen.setdx(0);
				queen.setdy(0);
			System.out.println("here2");
			
				
				addMouseMotionListener(new MouseAdapter()
				{
					public void mouseDragged(MouseEvent e)
						{
						
							
					     if(striker.player==1&&shotplayed!=1)
					     {
							if(e.getX() > b.x  && e.getX() < b.x + b.width
									&&e.getY() < b.y + b.height && e.getY() > lowery)
								{
									setstroke=1;
									mouse.x = e.getX();
									mouse.y = e.getY();
									repaint();
								}
								else
								{
									setstroke=0;
								
								}
					     }
					     if(striker.player==2&&shotplayed!=1)
					     {
							if(e.getX() > b.x  && e.getX() < b.x + b.width
									&&e.getY() > (b.y-7) && e.getY() < uppery)
								{
									setstroke=1;
									mouse.x = e.getX();
									mouse.y = e.getY();
									repaint();
								}
								else
								{
									setstroke=0;
								
								}
					     }
							
						}
				});
				addMouseListener(new MouseAdapter()
				{
					public void mouseReleased(MouseEvent e)
					{
						System.out.println("hai");
						if(striker.player==1&& shotplayed!=1&&e.getX() > b.x  && e.getX() < b.x + b.width &&e.getY() < b.y + b.height && e.getY() > lowery)
						{
							setstroke=0;
							shotplayed=1;
						
							striker.setdx(pf * 1.3*(striker.getx() - e.getX()));
							striker.setdy(pf * 1.3*(striker.gety() - e.getY()));
							st=true;
						
							
							
						}
						if(striker.player==2&& shotplayed!=1&&e.getX() > b.x  && e.getX() < b.x + b.width &&e.getY() < uppery && e.getY() >( b.y-6))
						{
							setstroke=0;
							shotplayed=1;
						
							striker.setdx(pf * 1.3*(striker.getx() - e.getX()));
							striker.setdy(pf * 1.3*(striker.gety() - e.getY()));
							st=true;
						}
						
					}
				}); 
				
				Thread game=new Thread(this);
			
							game.start();
							this.setFocusable(true);;
							 this.requestFocus();
	  }
		
	 
		private void setKeyBindings() 
		{
		// TODO Auto-generated method stub
			      ActionMap actionMap = getActionMap();
			      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
			      InputMap inputMap = getInputMap(condition );

			      String vkLeft = "VK_LEFT";
			      String vkRight = "VK_RIGHT";
			      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), vkLeft);
			      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), vkRight);

			      actionMap.put(vkLeft, new KeyAction(vkLeft));
			      actionMap.put(vkRight, new KeyAction(vkRight));

			   
	}
		private class KeyAction extends AbstractAction {
		      public KeyAction(String actionCommand) {
		         putValue(ACTION_COMMAND_KEY, actionCommand);
		      }

		      
		      public void actionPerformed(ActionEvent actionEvt) {
		    	  String keycode=actionEvt.getActionCommand();
		    	  System.out.println("keycodeinit="+keycode);
		    	  int num=0;
		    	  if(keycode=="VK_LEFT")
		    	  {
		    		  num=1;
		    	  }
		    	  else if(keycode=="VK_RIGHT")
		    	  {
		    		  num=2;
		    	  }
		    	  switch(num)
					{
							case 1: //striker.moveleft(striker.getx()-1);
									striker.moveleft();
							break;
							case 2: //striker.moveright(striker.getx()+1);
								striker.moveright();
							break;
	
					}
		         System.out.println(actionEvt.getActionCommand() + " pressed");
		      }
		   }

		public void run()
					{
					int i=1;
					//	System.out.println("thread created");
						while(true)
						{
							for(int p=0;p<numberofcoins;p++)
							{
								if((bcoin[p].x >52&&bcoin[p].x <78)&&(bcoin[p].y>42 &&bcoin[p].y<63))
								{
									
									
									System.out.println("in hole, positions=b.x="+bcoin[p].getx()+"b.y="+bcoin[p].gety());
									bcoin[p].setx(-970-gap);
									bcoin[p].sety(-70-gap);
									bcoin[p].setdx(0);
									bcoin[p].setdy(0);
									gap=gap-40;
									System.out.println("after in hole, positions=b.x="+bcoin[p].getx()+"b.y="+bcoin[p].gety());
									if(striker.player==1)
									{
									countcoins1++;
									//striker.player=2;
									}
									else
									{
										countcoins2++;
										//striker.player=1;
									}
									
								}
								else if((bcoin[p].x>590 &&bcoin[p].x<716)&&(bcoin[p].y>36&&bcoin[p].y<63))
								{
									
									System.out.println("in hole, positions=b.x="+bcoin[p].getx()+"b.y="+bcoin[p].gety());
									bcoin[p].setx(-8700-gap);
									bcoin[p].sety(-700-gap);
									bcoin[p].setdx(0);
									bcoin[p].setdy(0);
									gap=gap-40;
									System.out.println("after in hole, positions=b.x="+bcoin[p].getx()+"b.y="+bcoin[p].gety());
									if(striker.player==1)
									{
									countcoins1++;
									//striker.player=2;
									}
									else
									{
										countcoins2++;
										//striker.player=1;
									}
									
								}
								else if((bcoin[p].x>590 &&bcoin[p].x<720)&&(bcoin[p].y>580&&bcoin[p].y<615))
								{
									//countcoins++;
									
									System.out.println("in hole 4, positions=b.x="+bcoin[p].getx()+"b.y="+bcoin[p].gety());
									bcoin[p].setx(-3000-gap);
									bcoin[p].sety(-400-gap);
									bcoin[p].setdx(0);
									bcoin[p].setdy(0);
									gap=gap-40;
									System.out.println("after in hole, positions=b.x="+bcoin[p].getx()+"b.y="+bcoin[p].gety());
									if(striker.player==1)
									{
									countcoins1++;
									//striker.player=2;
									}
									else
									{
										countcoins2++;
										//striker.player=1;
									}
								}
								else if((bcoin[p].x>52 &&bcoin[p].x<78)&&(bcoin[p].y>584&&bcoin[p].y<610))
								{
									//countcoins++;
									
									System.out.println("in hole, positions=b.x="+bcoin[p].getx()+"b.y="+bcoin[p].gety());
									bcoin[p].setx(-5000-gap);
									bcoin[p].sety(-1000-gap);
									bcoin[p].setdx(0);
									bcoin[p].setdy(0);
									gap=gap-40;
									System.out.println("after in hole, positions=b.x="+bcoin[p].getx()+"b.y="+bcoin[p].gety());
									if(striker.player==1)
									{
									countcoins1++;
									//striker.player=2;
									}
									else
									{
										countcoins2++;
										//striker.player=1;
									}
								}
							}
							
								if((queen.x >52&&queen.x <78)&&(queen.y>42 &&queen.y<63))
								{
									
									
									System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									queen.setx(-970-gap);
									queen.sety(-70-gap);
									//queen.setdx(0);
									//queen.setdy(0);
									gap=gap-40;
									System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									if(striker.player==1)
									{
									countcoins1++;
									//striker.player=2;
									}
									else
									{
										countcoins2++;
										//striker.player=1;
									}
									
								}
								else if((queen.x>590 &&queen.x<716)&&(queen.y>36&&queen.y<63))
								{
									
									System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									queen.setx(-8700-gap);
									queen.sety(-700-gap);
									//queen.setdx(0);
									//queen.setdy(0);
									gap=gap-40;
									System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									if(striker.player==1)
									{
									countcoins1++;
									//striker.player=2;
									}
									else
									{
										countcoins2++;
										//striker.player=1;
									}
									
								}
								else if((queen.x>590 &&queen.x<720)&&(queen.y>580&&queen.y<615))
								{
									//countcoins++;
									
									System.out.println("in hole 4, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									queen.setx(-3000-gap);
									queen.sety(-400-gap);
									//queen.setdx(0);
									//queen.setdy(0);
									gap=gap-40;
									System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									if(striker.player==1)
									{
									countcoins1++;
									//striker.player=2;
									}
									else
									{
										countcoins2++;
										//striker.player=1;
									}
								}
								else if((queen.x>52 &&queen.x<78)&&(queen.y>584&&queen.y<610))
								{
									//countcoins++;
									
									System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									queen.setx(-5000-gap);
									queen.sety(-1000-gap);
									//queen.setdx(0);
									//queen.setdy(0);
									gap=gap-40;
									System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									if(striker.player==1)
									{
									countcoins1++;
									//striker.player=2;
									}
									else
									{
										countcoins2++;
										//striker.player=1;
									}
								}
							
								
								
							
								
								
							
								/*if((striker.x >52&&striker.x <78)&&(striker.y>42 &&striker.y<63))
								{
									
									
									//System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									striker.setx(-970-gap);
							striker.sety(-70-gap);
									striker.setdx(0);
									striker.setdy(0);
									gap=gap-40;
									System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									if(striker.player==1)
									{
									countcoins1--;
									//striker.player=2;
									}
									else
									{
										countcoins2--;
										//striker.player=1;
									}
									
								}
								else if((striker.x>590 &&striker.x<716)&&(striker.y>36&&striker.y<63))
								{
									
									//System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									striker.setx(-8700-gap);
									striker.sety(-700-gap);
									striker.setdx(0);
									striker.setdy(0);
									gap=gap-40;
									//System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									if(striker.player==1)
									{
									countcoins1--;
									//striker.player=2;
									}
									else
									{
										countcoins2--;
										//striker.player=1;
									}
									
								}
								else if((striker.x>590 &&striker.x<720)&&(striker.y>580&&striker.y<615))
								{
									//countcoins++;
									
									//System.out.println("in hole 4, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									striker.setx(-3000-gap);
									striker.sety(-400-gap);
									striker.setdx(0);
									striker.setdy(0);
									gap=gap-40;
									System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									if(striker.player==1)
									{
									countcoins1--;
									//striker.player=2;
									}
									else
									{
										countcoins2--;
										//striker.player=1;
									}
								}
								else if((queen.x>52 &&queen.x<78)&&(queen.y>584&&queen.y<610))
								{
									//countcoins++;
									
									//System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									striker.setx(-5000-gap);
									striker.sety(-1000-gap);
									striker.setdx(0);
									striker.setdy(0);
									gap=gap-40;
									//System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
									if(striker.player==1)
									{
									countcoins1--;
									//striker.player=2;
									}
									else
									{
										countcoins2--;
										//striker.player=1;
									}
								}*/
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							for(int j =0; j < numberofcoins ;j++)
							{
								int vals = 0;
								int vals1=0;
								int vals2=0;
								int value1=0;
								for(int k=0; k < numberofcoins; k++)
								{
									int value =0;
									if(j!=k && bcoin[j].bflag[k]!=1)
										value = bcoin[j].checkcollision(bcoin[k]);
									if(value == 1)
									{
										bcoin[k].bflag[j]=1;
										bcoin[j].bflag[k]=1;
										bcoin[j].collide(bcoin[k]);
									}
								}
								if(bcoin[j].qflag!=1)
								{
								  value1=bcoin[j].checkcollision(queen);
								}
								if(value1==1)
								{
									queen.bflag[j]=1;
									bcoin[j].qflag=1;
									bcoin[j].collide(queen);
									
									
								}
								
								/*if(vals2==1&&st==true)
								{
									queen.sflag=1;
									striker.qflag=1;
									queen.collide(striker);
								} */
								if(bcoin[j].sflag!=1&&st==true)
								{
									
									vals = bcoin[j].checkcollision(striker);
								}
								if(queen.sflag!=1)
								{
								   vals2=queen.checkcollision(striker);	
								}
								/*if(vals1==1)
								{
									bcoin[j].qflag=1;
									queen.bflag[j]=1;
									bcoin[j].collide(queen);
								}*/
								
								if(vals == 1&&st==true)
								{
									bcoin[j].sflag=1;
									striker.bflag[j]=1;
									bcoin[j].collide(striker);
									
									
								}
								if(vals2==1&&st==true)
								{
									queen.sflag=1;
									striker.qflag=1;
									queen.collide(striker);
								}
								
								 
								
								/*if(vals == 1&&st==true)
								{
									bcoin[j].sflag=1;
									striker.bflag[j]=1;
									bcoin[j].collide(striker);
									
									
								}*/
								//int vals2=0;
								/*if(queen.sflag!=1)
								{
								   vals2=queen.checkcollision(striker);	
								}*/
								
								
								
								  
								
								  
								
								bcoin[j].doupdate();
								//queen.doupdate();
								//striker.doupdate();
							}
							queen.doupdate();
							striker.doupdate();
							
							
						
							if(shotplayed==1)
							
							 checkifstopped();
							for(int j =0; j < numberofcoins ;j++)
							{
								for(int k=0; k < numberofcoins; k++)
								{
									bcoin[j].bflag[k]=0;
								}
								bcoin[j].sflag = 0;
								bcoin[j].qflag=0;
								
							}
							queen.sflag=0;
							
							
							repaint();
							
							
							try
							{
								Thread.sleep(18);
								
							}
							catch(InterruptedException e)
							{
								e.printStackTrace();
							}
							
						
						}
						
						
					}
				private void checkifstopped()
				{
					int p;
					if(queen.getdx()!=0&&queen.getdy()!=0)
						return;
					for( p =0; p < numberofcoins; p++)
					{
				        if(bcoin[p].getdx() != 0 || bcoin[p].getdy() != 0)
							return;
					}
					if(striker.getdx() != 0 && striker.getdy() != 0)
						return;
					
					
						try
						{
							Thread.sleep(2000);
						} 
						catch (InterruptedException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						striker.changeplayer();
						shotplayed=0;
						int position;
						if(striker.player==1)
						{
							position=lowery;
							st=false;
						}
						else
						{
							position=uppery;
							st=false;
						}
						striker.setx(337);
						striker.sety(position);
						//System.out.println("coins count="+countcoins);
						
				}
		//@Override
			public void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					//b.paint(g);
					
					
					b.draw(g);
					striker.draw(g,3);
					queen.draw(g,4);
				
					Graphics2D g2 = (Graphics2D) g;
					if(setstroke==1)
					{
					g2.setColor(Color.red);
					g2.setStroke(new BasicStroke(3));
					if(mouse.x!=0&&mouse.y!=0)
					{
						
					g2.drawLine((int)striker.getx(), (int)striker.gety(), mouse.x, mouse.y);
					
					}
					Graphics2D g3=(Graphics2D)g;
					
					}
					for(int j =0; j <( numberofcoins/2) ;j++)
					{
						
						bcoin[j].draw(g,1);
					}
					for(int j = (numberofcoins/2); j < (numberofcoins) ;j++)
					{
						
						bcoin[j].draw(g,2);
					}
					//int j=numberofcoins;
					//bcoin[j].draw(g, 4);
					
					Graphics2D g4=(Graphics2D)g;
					 g4.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						        RenderingHints.VALUE_ANTIALIAS_ON);
						    Font font = new Font("Serif", Font.PLAIN, 50);
						    g4.setFont(font);
                          g4.setColor(Color.BLUE);
					//g4.drawString("coins in holes=\n"+countcoins,650,200);44
                          
                          Graphics2D g5=(Graphics2D)g;
      					g5.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
      					        RenderingHints.VALUE_ANTIALIAS_ON);
      					    Font font1 = new Font("Serif", Font.PLAIN, 50);
      					    g5.setFont(font1);
      					//g5.setColor(Color.RED);
					if(striker.player==1)
					{
						g4.drawString("Turn: Player 1.",650,200);
						g4.drawString("score=\n"+countcoins1,650,300);
						
						if((striker.x >52&&striker.x <78)&&(striker.y>42 &&striker.y<63))
						{
							//g5.setColor(Color.RED);
							
							g5.drawString("Foul!", 650, 400);
							//System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							striker.setx(-970-gap);
					striker.sety(-70-gap);
							striker.setdx(0);
							striker.setdy(0);
							gap=gap-40;
							System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							if(striker.player==1)
							{
								
							countcoins1--;
							//striker.player=2;
							//g5.drawString("Foul!", 650, 400);
							}
							else
							{
								
								countcoins2--;
								//g5.drawString("Foul!", 650, 400);
								//striker.player=1;
							}
							//g5.drawString("Foul!", 650, 400);
							
						}
						else if((striker.x>590 &&striker.x<716)&&(striker.y>36&&striker.y<63))
						{
							//g5.setColor(Color.RED);
							g5.drawString("Foul!", 650, 400);
							//drawString("Foul!", 650, 400);
							//System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							striker.setx(-8700-gap);
							striker.sety(-700-gap);
							striker.setdx(0);
							striker.setdy(0);
							gap=gap-40;
							//System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							if(striker.player==1)
							{
								
							countcoins1--;
							//g5.drawString("Foul!", 650, 400);
							//striker.player=2;
							}
							else
							{
								
								countcoins2--;
								//g5.drawString("Foul!", 650, 400);
								//striker.player=1;
							}
							//g5.drawString("Foul!", 650, 400);
						}
						else if((striker.x>590 &&striker.x<720)&&(striker.y>580&&striker.y<615))
						{
							//g5.setColor(Color.RED);
							g5.drawString("Foul!", 650, 400);
							
							//g5.drawString("Foul!", 650, 400);
							//countcoins++;
							
							//System.out.println("in hole 4, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							striker.setx(-3000-gap);
							striker.sety(-400-gap);
							striker.setdx(0);
							striker.setdy(0);
							gap=gap-40;
							//System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							if(striker.player==1)
							{
								
							countcoins1--;
							//g5.drawString("Foul!", 650, 400);
							//striker.player=2;
							}
							else
							{
								
								countcoins2--;
								//g5.drawString("Foul!", 650, 400);
								//striker.player=1;
							}
							//g5.drawString("Foul!", 650, 400);
						}
						else if((striker.x>52 &&striker.x<78)&&(striker.y>584&&striker.y<610))
						{
							//g5.setColor(Color.RED);
							
						g5.drawString("Foul!", 650, 400);
							//countcoins++;
							//g5.drawString("Foul!", 650, 400);
							//System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							striker.setx(-5000-gap);
							striker.sety(-1000-gap);
							striker.setdx(0);
							striker.setdy(0);
							gap=gap-40;
							//System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							if(striker.player==1)
							{
								
							countcoins1--;
							//g5.drawString("Foul!", 650, 400);
							//striker.player=2;
							}
							else
							{
								 
								countcoins2--;
								//g5.drawString("Foul!", 650, 400);
								//striker.player=1;
							}
							//g5.drawString("Foul!", 650, 400);
						}
		
						
						
					}
					else if(striker.player==2)
					{
						//g5.setColor(Color.RED);
						g4.setColor(Color.RED);
						g4.drawString("Turn: Player 2",650,200);
						g4.drawString("score=\n"+countcoins2,650,300);
						
						if((striker.x >52&&striker.x <78)&&(striker.y>42 &&striker.y<63))
						{
							
							//g5.setColor(Color.RED);
							g5.drawString("Foul!", 650, 400);
							//System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							striker.setx(-970-gap);
					striker.sety(-70-gap);
							striker.setdx(0);
							striker.setdy(0);
							gap=gap-40;
							System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							if(striker.player==1)
							{
								
							countcoins1--;
							//striker.player=2;
							//g5.drawString("Foul!", 650, 400);
							}
							else
							{
								
								countcoins2--;
								//g5.drawString("Foul!", 650, 400);
								//striker.player=1;
							}
							//g5.drawString("Foul!", 650, 400);
							
						}
						else if((striker.x>590 &&striker.x<716)&&(striker.y>36&&striker.y<63))
						{
							//g5.setColor(Color.RED);
							g5.drawString("Foul!", 650, 400);
							
							//g5.drawString("Foul!", 650, 400);
							//System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							striker.setx(-8700-gap);
							striker.sety(-700-gap);
							striker.setdx(0);
							striker.setdy(0);
							gap=gap-40;
							//System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							if(striker.player==1)
							{
								
							countcoins1--;
							//g5.drawString("Foul!", 650, 400);
							//striker.player=2;
							}
							else
							{
								
								countcoins2--;
								//g5.drawString("Foul!", 650, 400);
								//striker.player=1;
							}
							//g5.drawString("Foul!", 650, 400);
						}
						else if((striker.x>590 &&striker.x<720)&&(striker.y>580&&striker.y<615))
						{
							//g5.setColor(Color.RED);
							//g5.drawString("Foul!", 650, 400);
							g5.drawString("Foul!", 650, 400);
							//countcoins++;
							
							//System.out.println("in hole 4, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							striker.setx(-3000-gap);
							striker.sety(-400-gap);
							striker.setdx(0);
							striker.setdy(0);
							gap=gap-40;
							//System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							if(striker.player==1)
							{
								
							countcoins1--;
							//g5.drawString("Foul!", 650, 400);
							//striker.player=2;
							}
							else
							{
								
								countcoins2--;
								//g5.drawString("Foul!", 650, 400);
								//striker.player=1;
							}
							//g5.drawString("Foul!", 650, 400);
						}
						else if((striker.x>52 &&striker.x<78)&&(striker.y>584&&striker.y<610))
						{
							//g5.setColor(Color.RED);
							g5.drawString("Foul!", 650, 400);
							//countcoins++;
							//g5.drawString("Foul!", 650, 400);
							//System.out.println("in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							striker.setx(-5000-gap);
							striker.sety(-1000-gap);
							striker.setdx(0);
							striker.setdy(0);
							gap=gap-40;
							//System.out.println("after in hole, positions=b.x="+queen.getx()+"b.y="+queen.gety());
							if(striker.player==1)
							{
								
							   countcoins1--;
							//g5.drawString("Foul!", 650, 400);
							//striker.player=2;
							}
							else
							{
								 
								countcoins2--;
								//g5.drawString("Foul!", 650, 400);
								//striker.player=1;
							}
							//g5.drawString("Foul!", 650, 400);
						}
		
					
					}
					
					
					
					
					
				
				}
				
			
				
}
