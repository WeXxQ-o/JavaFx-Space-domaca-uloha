package com.example.space;

import javafx.scene.paint.Color;

public class Planet extends SpaceObject {
    private static final double POLOMER = 40;

    private double stredX, stredY;
    private double uhol = 0;


    public Planet(int x, int y, Color f) {
        super(40, 40, x, y, f);
        stredX = x;
        stredY = y;
    }

    @Override
    protected void posun() {
        uhol += 0.1;
        setLayoutX(stredX + POLOMER * Math.cos(uhol) - getWidth() / 2);
        setLayoutY(stredY + POLOMER * Math.sin(uhol) - getHeight() / 2);
    }

    @Override
    protected void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(farba);
        gc.fillOval(10, 10, 20, 20);
        gc.setStroke(Color.GOLDENROD);
        gc.setLineWidth(2);
        gc.strokeOval(2, 15 + obrazok * 2, 36, 10 - obrazok * 4);
    }
}