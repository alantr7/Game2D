package com.alant7_.game2d.engine.world;

import com.alant7_.game2d.engine.framework.Window;
import com.alant7_.game2d.engine.math.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameWorld {

    public static List<GameObject> Objects = new ArrayList<>();
    public static Camera Camera = new Camera();

    public static Vector TileSize = new Vector(64, 64);

    public static Vector GetMousePosition() {
        Point P = Window.Instance.Frame.getMousePosition();
        return P == null ? new Vector(0, 0) : new Vector(P.x, P.y);
    }

}
