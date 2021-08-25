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
        int x = e.getPoint().x;
        int y = e.getPoint().y;
        if (x >= 820 && x < 950 && y >= 10 && y < 590) {
            x -= 820;
            x /= 65;
            y /= 58;
            board.PlayerSandWich = x * 10 + y;
            board.PlayerSand = Sand.INVENTORY[board.PlayerSandWich];
        }
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
