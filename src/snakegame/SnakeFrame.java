/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakegame;

import javax.swing.JFrame;

/**
 *
 * @author neliloghmani
 */
public class SnakeFrame {

        public static void main(String[] args) {
        // TODO code application logic here
             JFrame frame = new JFrame();
             SnakeGame snake = new SnakeGame();
             SnakeGame food = new SnakeGame();

            
             
             frame.add(snake);
             frame.setTitle("The Game Of SNAKE");
             frame.setVisible(true);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.pack();
             frame.setSize(800, 700);
             frame.setResizable(false);
             
             
            
    }

}