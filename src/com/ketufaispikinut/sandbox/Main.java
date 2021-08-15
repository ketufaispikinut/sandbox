package com.ketufaispikinut.sandbox;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private Board board=new Board();
    public Main(){
        init();
    }
    public static int W=2;
    public static int H=2;
    private void init(){
        add(board);
        setTitle("Sandbox");
        setSize(new Dimension((400+50+100)*2,(300+50)*2));//+100/2
        setVisible(true);
        setIconImage(new ImageIcon("src/logo.png").getImage());
        //setIconImage();
        //setDefaultCloseOperation(0);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
	// write your code here
        Board board=new Board();
        Main e=new Main();
    }
}
