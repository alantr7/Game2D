package com.alant7_.game2d.engine.framework;

import java.awt.*;
import java.io.File;
import java.io.InputStream;

public abstract class ResourceLoader {

    public File GetFile(String Path) {
        try {
            return new File(this.getClass().getResource(Path).toURI());
        } catch (Exception e) {}
        return null;
    }

    public InputStream GetInputStream(String Path) {
        return this.getClass().getResourceAsStream(Path);
    }

}
