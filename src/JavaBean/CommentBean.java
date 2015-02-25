package JavaBean;

import java.io.Serializable;

public class CommentBean implements Serializable{
	
	private int id;
	private String time;
	private String content;
	private int storyId;
	private int providerId;
	
	public CommentBean() {}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public int getStoryId() {return storyId;}
	public void setStoryId(int storyId) {this.storyId = storyId;}
	public int getProviderId() {return providerId;}
	public void setProviderId(int providerId) {this.providerId = providerId;}

}
