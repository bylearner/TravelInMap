package JavaBean;

import java.io.Serializable;
import java.util.ArrayList;

public class JourneyBean implements Serializable{
	
	private int id;
	private int providerId;
	private String title;
	private ArrayList<StoryBean> storyList;
	public JourneyBean() {}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public int getProviderId() {return providerId;}
	public void setProviderId(int providerId) {this.providerId = providerId;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public ArrayList<StoryBean> getStoryList() {return storyList;}
	public void setStoryList(ArrayList<StoryBean> storyList) {this.storyList = storyList;}
	
}
