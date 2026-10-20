package com.example.space;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Pane root;

    @FXML
    protected void drawPlaneta() {
        int x = 60 + (int) (Math.random() * (root.getWidth() - 120));
        int y = 60 + (int) (Math.random() * (root.getHeight() - 120));
        root.getChildren().add(new Planet(x, y, Color.DEEPSKYBLUE));
    }

    @FXML
    protected void drawAsteroid() {
        int x = (int) (Math.random() * (root.getWidth() - 30));
        int y = (int) (Math.random() * (root.getHeight() - 30));
        root.getChildren().add(new Asteroid(x, y, Color.GRAY));
    }

    @FXML
    protected void drawSatelit() {
        int x = (int) (Math.random() * (root.getWidth() - 50));
        int y = (int) (Math.random() * (root.getHeight() - 30));
        root.getChildren().add(new Satellite(x, y, Color.LIGHTGRAY));
    }

    @FXML
    protected void asteroidRed() {
        for (int i = 0; i < root.getChildren().size(); i++) {
            Node n = root.getChildren().get(i);
            if (n instanceof Asteroid) ((Asteroid) n).zmenaFarby(Color.RED);
        }
    }

    @FXML
    protected void satelitRight() {
        for (int i = 0; i < root.getChildren().size(); i++) {
            Node n = root.getChildren().get(i);
            if (n instanceof Satellite) ((Satellite) n).posunDoprava(20);
        }
    }
}