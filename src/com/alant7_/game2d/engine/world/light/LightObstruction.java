package com.alant7_.game2d.engine.world.light;

import com.alant7_.game2d.engine.framework.Graphics;
import com.alant7_.game2d.engine.math.Vector;
import com.alant7_.game2d.engine.world.GameWorld;

import java.awt.*;

public class LightObstruction {

    private Vector Position = new Vector();
    private Vector Dimension = new Vector();

    public LightObstruction(int X, int Y, int W, int H) {
        Position.X = X;
        Position.Y = Y;
        Dimension.X = W;
        Dimension.Y = H;

        Graphics.LightObstructions.add(this);
    }

    public Rectangle Rectangle() {
        return new Rectangle((int)(Position.X * GameWorld.TileSize.X / Graphics.LightTilesPerTile.X), (int)(Position.Y * GameWorld.TileSize.Y / Graphics.LightTilesPerTile.Y), (int)(Dimension.X * GameWorld.TileSize.X / Graphics.LightTilesPerTile.X), (int)(Dimension.Y * GameWorld.TileSize.Y / Graphics.LightTilesPerTile.Y));
    }

}
