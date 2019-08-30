package org.applied_geodesy.adjustment.factories;

import org.applied_geodesy.adjustment.point.Point;
import org.applied_geodesy.adjustment.point.Point1D;
import org.applied_geodesy.adjustment.point.Point2D;
import org.applied_geodesy.adjustment.point.Point3D;
import org.json.JSONException;
import org.json.JSONObject;


public class PointFactory implements PointFactoryInterface {

    @Override
    public Point create(JSONObject object) {

        String name = object.getString("name");

        boolean hasX = object.has("x");
        boolean hasY = object.has("y");
        boolean hasZ = object.has("z");
        boolean hasSX = object.has("sX");
        boolean hasSY = object.has("sY");
        boolean hasSZ = object.has("SZ");

        if(hasX && hasY && hasZ){
            double x = object.getDouble("x");
            double y = object.getDouble("y");
            double z = object.getDouble("z");
            if(hasSX && hasSY && hasSZ){
                return new Point3D(name, x,y,z,
                        object.getDouble("sX"),
                        object.getDouble("sY"),
                        object.getDouble("sZ"));
            }
            return  new Point3D(name, x, y, z);
        }else if(hasX && hasY){
            double x = object.getDouble("x");
            double y = object.getDouble("y");
            if(hasSX && hasSY){
                return new Point2D(name, x, y,
                        object.getDouble("sX"),
                        object.getDouble("sY"));
            }
            return new Point2D(name, x, y);
        }else if (hasZ){
            double z = object.getDouble("z");
            if(hasSZ){
                return new Point1D(name, z, object.getDouble("sZ"));
            }
            return new Point1D(name, z);
        }
        throw new JSONException("JSONObject does not define a point.");
    }
}
