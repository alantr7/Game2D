package com.alant7_.game2d.engine.world;

import com.alant7_.game2d.engine.math.Vector;

public abstract class GameObject {

    public Vector Position = new Vector(), Velocity = new Vector();

    public GameObject() {
        GameWorld.Objects.add(this);
    }

    public abstract void Render(java.awt.Graphics g);
    public abstract void Update();

}
