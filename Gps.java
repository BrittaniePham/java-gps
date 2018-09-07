package gps;

import java.util.ArrayList;
import java.util.Random;

public class Gps {
	
//	private ArrayList<GpsPosition> route;
	private ArrayList<GpsPosition> route = new ArrayList<>();

	public Gps(GpsPosition position) {
		route.add(position);
	}
	
	public ArrayList<GpsPosition> getRoute() {
		return route;
	}
	
	public void update(GpsPosition position) {
		route.add(position);
	}
	
	public void randomUpdate() {
		Random rand = new Random();
        double latitude = route.get(route.size()-1).getLatitude() + rand.nextDouble() - 0.5;
        double longitude = route.get(route.size()-1).getLongitude() + rand.nextDouble() - 0.5;
        double elevation = route.get(route.size()-1).getElevation();
        GpsPosition position = new GpsPosition(latitude, longitude, elevation);
		route.add(position);
	}
	
	public GpsPosition position() {
		GpsPosition currentPosition = route.get(route.size()-1);
		return currentPosition; //TODO
	}
	
	public double distanceTraveled() {
		double total = 0;
		for (int i = 1; i < route.size(); i++){
			total += distance(route.get(i-1), route.get(i));
        }
		return total; //TODO
	}
	
	private double distance(GpsPosition from, GpsPosition to) {
		double lat1 = from.getLatitude();
		double lon1 = from.getLongitude();
		double el1 = from.getElevation();
		double lat2 = to.getLatitude();
		double lon2 = to.getLongitude();
		double el2 = to.getElevation();
		
		final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = (el1 - el2);

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    return Math.sqrt(distance)/1000;
	}
	
	public void reset() {
		GpsPosition resetPosition = route.get(route.size()-1);
		route.clear();
		route.add(resetPosition);
	}
}
