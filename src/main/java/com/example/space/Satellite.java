package com.example.space;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Satellite extends SpaceObject {
    private int dy = 3;

    public Satellite(int x, int y, Color f) {
        super(50, 30, x, y, f);
    }

    @Override
    protected void posun() {
        if (getParent() == null) return;
        Pane rodic = (Pane) getParent();

        if (getLayoutY() + dy < 0 || getLayoutY() + dy + getHeight() > rodic.getHeight())
            dy = -dy;
        setLayoutY(getLayoutY() + dy);
    }

    public void posunDoprava(int px) {
        setLayoutX(getLayoutX() + px);
    }

    @Override
    protected void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(Color.ROYALBLUE);
        gc.fillRect(0, 10, 15, 10);
        gc.fillRect(35, 10, 15, 10);
        gc.setFill(farba);
        gc.fillRect(15, 7, 20, 16);
        gc.setFill(obrazok == 0 ? Color.RED : Color.DARKRED);
        gc.fillOval(23, 12, 5, 5);
    }
}