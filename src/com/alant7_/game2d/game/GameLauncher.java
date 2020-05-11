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

        new Light(20);
        new LightObstruction(12, 12, 2, 2);
        new LightObstruction(20, 12, 2, 2);
        new LightObstruction(20, 20, 2, 2);
        new LightObstruction(12, 20, 2, 2);
    }

}
