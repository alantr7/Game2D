package com.alant7_.game2d.engine.world.light;

import com.alant7_.game2d.engine.framework.Graphics;
import com.alant7_.game2d.engine.framework.Window;
import com.alant7_.game2d.engine.math.Vector;
import com.alant7_.game2d.engine.world.GameWorld;

import java.awt.*;
import java.awt.geom.Line2D;

public class Light {

    public Vector Position = new Vector(8, 8);
    public int Power;

    public Light(int Power) {
        this.Power = Power;
        Graphics.Lights.add(this);
    }

    public void Render(Graphics2D G) {

        long Elapsed = 0, RenderElapsed = 0, Start = System.nanoTime(), RenderStart = 0;

        double WIDTH = GameWorld.TileSize.X / Graphics.LightTilesPerTile.X;
        double HEIGHT = GameWorld.TileSize.Y / Graphics.LightTilesPerTile.Y;

        double MAX_DISTANCE = Power * Math.sqrt(2);

        Position = GameWorld.GetMousePosition().Divide(new Vector((int)WIDTH, (int)HEIGHT)).IntegerValues();

        Elapsed += System.nanoTime() - Start;

        Vector CENTER = new Vector(Position.X * WIDTH, Position.Y * HEIGHT);

        for (int i = -(int)MAX_DISTANCE; i <= (int)MAX_DISTANCE; i++) {
            Check: for (int j = -(int)(MAX_DISTANCE); j <= (int)MAX_DISTANCE; j++) {

                Start = System.nanoTime();

                double Distance = Math.sqrt(i * i + j * j);
                int Alpha = 150 - (int)(Distance / MAX_DISTANCE * 150);

                if (Alpha < 0) Alpha = 0;

                Elapsed += System.nanoTime() - Start;

                RenderStart = System.nanoTime();
                G.setColor(new Color(0, 0, 0, Alpha));

                Vector POSITION = new Vector((i + Position.X) * WIDTH, (j + Position.Y) * HEIGHT);

                for (int k = 0; k < Graphics.LightObstructions.size(); k++) {
                    if (Graphics.LightObstructions.get(k).Rectangle().intersectsLine(new Line2D.Float((int)CENTER.X, (int)CENTER.Y, (int)POSITION.X, (int)POSITION.Y))) {
                        continue Check;
                    }
                }

                G.fillRect((int)POSITION.X, (int)POSITION.Y, (int)WIDTH, (int)HEIGHT);

                RenderElapsed += System.nanoTime() - RenderStart;

            }
        }

        System.out.println("Elapsed: " + Elapsed + "ns  Render Elapsed: " + RenderElapsed + "ns");

    }

}
