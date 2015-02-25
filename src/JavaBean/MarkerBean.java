package JavaBean;

import java.io.Serializable;

public class MarkerBean implements Serializable{
	
	private int storyId;
	private String storyTitle;
	private double longitude;
	private double latitude;
		
	public MarkerBean() {}
	
	public int getStoryId() {return storyId;}
	public void setStoryId(int storyId) {this.storyId = storyId;}
	public String getStoryTitle() {return storyTitle;}
	public void setStoryTitle(String storyTitle) {this.storyTitle = storyTitle;}
	public double getLongitude() {return longitude;}
	public void setLongitude(double longitude) {this.longitude = longitude;}
	public double getLatitude() {return latitude;}
	public void setLatitude(double latitude) {this.latitude = latitude;}

}
