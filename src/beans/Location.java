package beans;

public class Location {
	int locationId;
	String latitude;
	String longitude;
	
	public Location(int locationId, String latitude, String longitude){
		this.locationId = locationId;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Location() {}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
