package com.alant7_.game2d.game;

import com.alant7_.game2d.engine.framework.Graphics;
import com.alant7_.game2d.engine.framework.Window;
import com.alant7_.game2d.engine.math.Vector;
import com.alant7_.game2d.engine.world.light.Light;
import com.alant7_.game2d.engine.world.light.LightObstruction;

public class GameLauncher {

    public static void main(String[] args) {
        new Window();

        Graphics.RenderGrid = false;
        Graphics.RenderLightGrid = false;

        Graphics.LightTilesPerTile = new Vector(4, 4);

        new Light(5);

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                new LightObstruction(8 * i, 8 * j, 2, 2);
            }
    }

}
