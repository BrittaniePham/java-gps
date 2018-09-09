package gps;

public class GpsPosition {
	
	private double latitude;
	private double longitude;
	private double elevation;
	
	public GpsPosition(double latitude, double longitude, double elevation) {
		if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180){
			throw new IllegalArgumentException("Invalid latitude and/or longitude");
		}
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getElevation() {
		return elevation;
	}
	
	@Override
	public String toString() {
		return String.format("%.6f, %.6f (%.1f)", latitude, longitude, elevation);	
	}
}
