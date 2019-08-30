package org.applied_geodesy.adjustment.factories;

import org.applied_geodesy.adjustment.network.observation.Observation;
import org.applied_geodesy.adjustment.network.observation.SlopeDistance;
import org.applied_geodesy.adjustment.point.Point;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class ObservationFactory implements ObservationFactoryInterface {

    @Override
    public Observation create(JSONObject config, Map<String, Point> point_repository) {
        if (config.has("slopeDist")){
            return new SlopeDistance(399,
                    point_repository.get(config.get("startPoint")),
                    point_repository.get(config.get("endPoint")),
                    0,
                    0,
                    config.getDouble("sigmaDist"),
                    config.getDouble("slopeDist"),
                    config.getDouble("slopeDist"));
        }
        throw new JSONException("");
    }
}
