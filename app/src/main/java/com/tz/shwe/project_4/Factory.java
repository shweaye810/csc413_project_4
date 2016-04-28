package com.tz.shwe.project_4;

import android.content.Context;
import android.graphics.Color;

public abstract class Factory {
    static public ShapeFactory get_shape_factory(int border, int fill) {
        return new ShapeFactory(border, fill);
    }
}
