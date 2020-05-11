package com.alant7_.game2d.engine.math;

public class Vector {

    public double X = 0, Y = 0;

    public Vector() {
        this(0, 0);
    }

    public Vector(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public Vector Copy() {
        return new Vector(X, Y);
    }

    public Vector Add(Vector V) {
        X += V.X;
        Y += V.Y;
        return this;
    }

    public Vector Subtract(Vector V) {
        X -= V.X;
        Y -= V.Y;
        return this;
    }

    public Vector Multiply(Vector V) {
        X *= V.X;
        Y *= V.Y;
        return this;
    }

    public Vector Divide(Vector V) {
        X /= V.X;
        Y /= V.Y;
        return this;
    }

    public Vector IntegerValues() {
        X = (int)X;
        Y = (int)Y;
        return this;
    }

}
