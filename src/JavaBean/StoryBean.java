package JavaBean;

import java.io.Serializable;
import java.util.ArrayList;

public class StoryBean implements Serializable{

	private int id;
	private int journeyId;
	private String title;
	private String content;
	private String date;
	private double longitude;
	private double latitude;
	private String duration;
	private ArrayList<CommentBean> commentList;

	public StoryBean() {}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public int getJourneyId() {return journeyId;}
	public void setJourneyId(int journeyId) {this.journeyId = journeyId;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}
	public double getLongitude() {return longitude;}
	public void setLongitude(double longitude) {this.longitude = longitude;}
	public double getLatitude() {return latitude;}
	public void setLatitude(double latitude) {this.latitude = latitude;}
	public String getDuration() {return duration;}
	public void setDuration(String duration) {this.duration = duration;}
	public ArrayList<CommentBean> getCommentList() {return commentList;}
	public void setCommentList(ArrayList<CommentBean> commentList) {this.commentList = commentList;}

}
