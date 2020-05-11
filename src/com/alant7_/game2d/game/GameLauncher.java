package com.alant7_.game2d.game;

import com.alant7_.game2d.engine.framework.Graphics;
import com.alant7_.game2d.engine.framework.Window;
import com.alant7_.game2d.engine.math.Vector;
import com.alant7_.game2d.engine.world.light.Light;

public class GameLauncher {

    public static void main(String[] args) {
        new Window();

        Graphics.RenderGrid = false;
        Graphics.RenderLightGrid = false;

        Graphics.LightTilesPerTile = new Vector(4, 5.6);

        new Light(3);
    }

}
