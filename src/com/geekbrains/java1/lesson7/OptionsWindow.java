package ru.geekbrains.java.lesson_seven;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 230;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    private GameWindow gameWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideFieldSize;
    private JSlider slideWinLength;


    OptionsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int)gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int)gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(10, 1));
        addGameControlsMode();
        addGameControlsField();

        JButton btnStartGame = new JButton("Start New Game!");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartGameClick();
            }
        });
        add(btnStartGame);
    }

    private void addGameControlsMode() {
        add(new JLabel("Choose Mode"));
        humVSAI = new JRadioButton("Human VS AI");
        humVShum = new JRadioButton("Human VS Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVShum);
        humVSAI.setSelected(true);
        add(humVSAI);
        add(humVShum);
    }

    private void addGameControlsField() {
        final String FIELD_SIZE_PREFIX = "Field size is: ";
        JLabel lblFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lblFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLength.setMaximum(currentValue);
            }
        });

        final String WIN_LEN_PREFIX = "Winning lenght is: ";
        JLabel lblWinLength = new JLabel(WIN_LEN_PREFIX + MIN_WIN_LENGTH);
        slideWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);
        slideWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWinLength.setText(WIN_LEN_PREFIX + slideWinLength.getValue());
            }
        });

        add(new JLabel("Choose Field size"));
        add(lblFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose winning length"));
        add(lblWinLength);
        add(slideWinLength);
    }

    private void btnStartGameClick() {
        int gameMode;
        if (humVSAI.isSelected())
            gameMode = Map.GAME_MODE_HVA;
        else if (humVShum.isSelected())
            gameMode = Map.GAME_MODE_HVH;
        else
            throw new RuntimeException("Wrong button selected");

        int sizeFieldX = slideFieldSize.getValue();
        int winLen = slideWinLength.getValue();
        gameWindow.startNewGame(gameMode, sizeFieldX, sizeFieldX, winLen);
        setVisible(false);
    }
}
