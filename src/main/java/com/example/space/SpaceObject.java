package com.example.space;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class SpaceObject extends Canvas {
    protected GraphicsContext gc;
    protected Color farba;
    protected int obrazok = 0;
    private Timeline casovac;

    public SpaceObject(int w, int h, int x, int y, Color f) {
        super(w, h);
        farba = f;
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();

        casovac = new Timeline(new KeyFrame(Duration.millis(50), e -> tik()));
        casovac.setCycleCount(Animation.INDEFINITE);
        casovac.play();
    }

    private void tik() {
        posun();
        obrazok = (obrazok + 1) % 2;
        vykresli();
    }


    protected abstract void posun();


    protected abstract void vykresli();

    public void zmenaFarby(Color f) {
        farba = f;
    }
}