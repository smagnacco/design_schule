package pattern.structural.adapter;

/**
 * The Geo Position Library, usually as a provided Lib, that you cannot change. Usually, it doesn't have an interface
 * to implements (like proxy pattern)
 * 
 */
public class GeoPositionLibrary {
    public Integer getBeachDistance(Float latitude, Float longitude) throws IllegalArgumentException {
        if (latitude > 90.0 || latitude < -90.0)
            throw new IllegalArgumentException("Latitude must be between -90 and 90 degrees");
        if (longitude > 360.0 || longitude < -360.0)
            throw new IllegalArgumentException("Longitude must be between -360 and 360 degrees");
        return calculate(latitude, longitude);
    }

    private Integer calculate(Float latitude, Float longitude) {
        return 10; //Dummy return until it's implemented
    } 
}
