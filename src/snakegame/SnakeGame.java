/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.*;


/**
 *
 * @author neliloghmani
 */
public class SnakeGame extends JPanel implements ActionListener, KeyListener{ //Can detect when a key is pressed

   Timer time = new Timer(5, this); // every 5 seconds calls on action listener
   public int head, tail, speedX, speedY;
   public Rectangle food, snake, bodypart;
   public int xFoody, yFoodx, score = 0;
   
   public SnakeGame()
   {
       time.start();
       addKeyListener(this);
       setFocusable(true);
       setBounds(80,80,80,80);
       

       getFood();
       
       
      score();

       
       food = new Rectangle(xFoody, yFoodx, 10, 10);
       snake = new Rectangle(head, tail, 10, 10);
       bodypart = new Rectangle(10,10);

   }
   
   @Override
   public void paintComponent(Graphics g){
        super.paintComponent(g);
         Graphics2D g2 = (Graphics2D) g;
         g2.setColor(Color.red);
         g2.draw(snake);
         g2.fill(snake);
          
         
         Graphics2D g3 = (Graphics2D) g;
         g3.setColor(Color.MAGENTA);
         g3.draw(food);
         g3.fill(food); 
       
   }
   
   
   public void actionPerformed(ActionEvent e){
       
       int scale = 10;
       repaint();
       snake = new Rectangle(head, tail, scale , scale );
       food = new Rectangle(xFoody, yFoodx, 10, 10);
       head += speedX;
       tail += speedY;
       
       
       if (snake.intersects(food)){
          snake.add(snake);
          snake.intersection(food);
          getFood();
          score();
       }

       }

   public void score()
{
    JLabel scorepanel = new JLabel("Score: 0");

    scorepanel.setText("Score: " + score);
}
    


   public void getFood()
   {
       xFoody = (int)(Math.random() * 500);
       yFoodx = (int)(Math.random() * 500);
       score = 10;

   }
   public void up(){
       speedY= -1;
       speedX = 0;
   }
   public void down(){
       speedY= 1;
       speedX = 0;
   }
   public void left(){
       speedX= -1;
       speedY = 0;
   }
   public void right(){
       speedX= 1;
       speedY = 0;
   }
   public void keyPressed(KeyEvent e){
       int code = e.getKeyCode();    // returns the integer keycode of the key pressed
       if (code == KeyEvent.VK_UP){
           up();
       }
       if (code == KeyEvent.VK_DOWN){
           down();
       }
       if (code == KeyEvent.VK_LEFT){
           left();
       }
       if (code == KeyEvent.VK_RIGHT){
           right();
       }
       
   }
   @Override
   public void keyTyped(KeyEvent e){}
   @Override
   public void keyReleased(KeyEvent e){}

                       
        
    }
    

