package com.alant7_.game2d.engine.world.light;

import com.alant7_.game2d.engine.framework.Graphics;
import com.alant7_.game2d.engine.framework.Window;
import com.alant7_.game2d.engine.math.Vector;
import com.alant7_.game2d.engine.world.GameWorld;

import java.awt.Graphics2D;
import java.awt.Color;

public class Light {

    public Vector Position = new Vector(8, 8);
    public int Power;

    public Light(int Power) {
        this.Power = Power;
        Graphics.Lights.add(this);
    }

    public void Render(Graphics2D G) {

        long Elapsed = 0, RenderElapsed = 0, Start = System.currentTimeMillis(), RenderStart = 0;

        double WIDTH = GameWorld.TileSize.X / Graphics.LightTilesPerTile.X;
        double HEIGHT = GameWorld.TileSize.Y / Graphics.LightTilesPerTile.Y;

        double MAX_DISTANCE = Power * Math.sqrt(2);

        Position = GameWorld.GetMousePosition().Divide(new Vector((int)WIDTH, (int)HEIGHT)).IntegerValues();

        Elapsed += System.currentTimeMillis() - Start;

        for (int i = -(int)MAX_DISTANCE; i <= (int)MAX_DISTANCE; i++) {
            for (int j = -(int)(MAX_DISTANCE); j <= (int)MAX_DISTANCE; j++) {

                Start = System.currentTimeMillis();

                double Distance = Math.sqrt(i * i + j * j);
                int Alpha = 150 - (int)(Distance / MAX_DISTANCE * 150);

                if (Alpha < 0) Alpha = 0;

                Elapsed += System.currentTimeMillis() - Start;

                RenderStart = System.currentTimeMillis();
                G.setColor(new Color(255, 255, 180, Alpha));
                G.fillRect((int)((i + Position.X) * WIDTH), (int)((j + Position.Y) * HEIGHT), (int)WIDTH, (int)HEIGHT);

                RenderElapsed += System.currentTimeMillis() - RenderStart;

            }
        }

        System.out.println("Elapsed: " + Elapsed + "ms  Render Elapsed: " + RenderElapsed + "ms");

    }

}
