package com.ketufaispikinut.sandbox;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PosMouseListener implements MouseListener {
    private Board board;

    public PosMouseListener(Board e){
        super();
        board=e;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        board.MousePressed=true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        board.MousePressed=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
