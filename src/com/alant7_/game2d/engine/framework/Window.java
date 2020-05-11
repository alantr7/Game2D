package com.alant7_.game2d.engine.framework;

import javax.swing.*;

public class Window {

    private Graphics Canvas;
    public static Window Instance;

    public JFrame Frame;

    public Window() {

        Instance = this;

        Frame = new JFrame();
        Frame.add(Canvas = new Graphics());
        Frame.setSize(800,600);

        Frame.setVisible(true);
        Canvas.StartRender();

        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
