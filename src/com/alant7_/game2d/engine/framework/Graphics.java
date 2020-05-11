package com.alant7_.game2d.engine.framework;

import com.alant7_.game2d.engine.math.Vector;
import com.alant7_.game2d.engine.world.GameObject;
import com.alant7_.game2d.engine.world.GameWorld;
import com.alant7_.game2d.engine.world.light.Light;
import com.alant7_.game2d.engine.world.light.LightObstruction;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Graphics extends Canvas {

    public void StartRender() {
        new Thread(this::Render).start();
    }

    public static Vector LightTilesPerTile = new Vector(16, 16);
    public static boolean RenderGrid = false, RenderLightGrid = false;

    public static List<Light> Lights = new ArrayList<>();
    public static List<LightObstruction> LightObstructions = new ArrayList<>();

    public void Render() {

        while (true) {

            BufferStrategy bs = this.getBufferStrategy();

            if (bs == null) {
                createBufferStrategy(3);
                continue;
            }

            java.awt.Graphics2D Graphics = (Graphics2D)bs.getDrawGraphics();

            Graphics.setColor(Color.BLACK);
            Graphics.fillRect(0, 0, 1920, 1080);

            Graphics.setStroke(new BasicStroke(1));

            Graphics.setColor(Color.BLACK);
            if (RenderLightGrid)
                for (int i = 0; i < 64; i++)
                    for (int j = 0; j < 64; j++) {
                        Graphics.drawRect(i * (int)GameWorld.TileSize.X / (int)LightTilesPerTile.X, j * (int)GameWorld.TileSize.Y / (int)LightTilesPerTile.Y, (int)GameWorld.TileSize.X / (int)LightTilesPerTile.X, (int)GameWorld.TileSize.Y / (int)LightTilesPerTile.Y);
                    }

            if (RenderGrid)
                Graphics.setStroke(new BasicStroke(2));
                for (int i = 0; i < 64; i++)
                    for (int j = 0; j < 64; j++) {
                        Graphics.drawRect(i * (int)GameWorld.TileSize.X, j * (int)GameWorld.TileSize.Y, (int)GameWorld.TileSize.X, (int)GameWorld.TileSize.Y);
                    }

            for (int i = 0; i < Lights.size(); i++)
                Lights.get(i).Render(Graphics);

            for (int i = 0; i < GameWorld.Objects.size(); i++) {
                GameWorld.Objects.get(i).Render(Graphics);
                GameWorld.Objects.get(i).Update();
            }

            try {
                Thread.sleep(16);
            } catch (Exception e) {}

            bs.show();

        }

    }

}
