package org.applied_geodesy.adjustment.factories;

import org.applied_geodesy.adjustment.network.observation.Observation;
import org.applied_geodesy.adjustment.point.Point;
import org.json.JSONObject;

import java.util.Map;

public interface ObservationFactoryInterface {

    public Observation create(JSONObject config, Map<String, Point> point_repository);

}
