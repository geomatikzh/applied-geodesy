package org.applied_geodesy.adjustment.factories;

import org.applied_geodesy.adjustment.point.Point;
import org.json.*;

public interface PointFactoryInterface {

    public Point create(JSONObject object);


}
