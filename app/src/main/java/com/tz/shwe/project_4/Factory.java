package com.tz.shwe.project_4;

import android.content.Context;

public abstract class Factory {
    abstract Shape get_shape(ShapeType s_t);
    abstract Color get_color(Color c_t);
}
