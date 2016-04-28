package com.tz.shwe.project_4;

import android.content.Context;

/**
 * Created by blo on 3/24/16.
 */

public class ColorFactory {

    public Shape getShape(Context cnxt, ShapeType shape) {
        if (shape == null)
            return null;
        if (shape == ShapeType.Circle)
            return new Circle(cnxt);
        else if (shape == ShapeType.Rectangle)
            return new Rectangle(cnxt);
        return null;
    }
}
