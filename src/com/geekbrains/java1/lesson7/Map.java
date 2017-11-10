package ru.geekbrains.java.lesson_seven;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    static final int GAME_MODE_HVA = 0;
    static final int GAME_MODE_HVH = 1;

    Map() {
        setBackground(Color.BLACK);
    }

    void startNewGame(int mode, int sizeFieldX, int sizeFieldY, int winLength) {
        System.out.println("mode = " + mode);
        System.out.println("size = " + sizeFieldX);
        System.out.println("wlen = " + winLength);
    }

}
