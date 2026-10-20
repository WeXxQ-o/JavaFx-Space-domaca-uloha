package com.example.space;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Asteroid extends SpaceObject {
    private int dx, dy;

    public Asteroid(int x, int y, Color f) {
        super(30, 30, x, y, f);
        dx = Math.random() < 0.5 ? 3 : -3;
        dy = Math.random() < 0.5 ? 3 : -3;
    }

    @Override
    protected void posun() {
        if (getParent() == null) return;
        Pane rodic = (Pane) getParent();

        if (getLayoutX() + dx < 0 || getLayoutX() + dx + getWidth() > rodic.getWidth())
            dx = -dx;
        if (getLayoutY() + dy < 0 || getLayoutY() + dy + getHeight() > rodic.getHeight())
            dy = -dy;

        setLayoutX(getLayoutX() + dx);
        setLayoutY(getLayoutY() + dy);
    }

    @Override
    protected void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(farba);
        double[] x = {5, 20 + obrazok * 2, 29, 24, 10, 1};
        double[] y = {1, 2, 15, 28 - obrazok * 2, 29, 14};
        gc.fillPolygon(x, y, x.length);
    }
}