package JavaBean;

import java.sql.*;
import java.util.ArrayList;
import java.io.Serializable;

public class DataBean implements Serializable{

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/qpf7";
	private static final String USER = "root";
	private static final String PASSWORD = "bupt";
	private Connection connection = null;
	
	public DataBean() {
		establishConnection();
	}
	
    public void establishConnection(){
    	try{
    		Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
    	}
    	catch(Exception e){e.printStackTrace();}
    }
    
    public void closeConnection(){
    	try{
    		connection.close();
    	}
    	catch(Exception e){e.printStackTrace();}
    }

    public void maintainConnection(){
    	try {
			if(connection.isClosed()){
				closeConnection();
				establishConnection();
			}

    	}
    	catch (Exception e) {e.printStackTrace();}
    }
    
	public boolean checkUserValid(String passedName, String passedPassword) {
		boolean isValid = false;
    	try {
			Statement statement = connection.createStatement();
			String sql = "SELECT user_password FROM user WHERE user_name=\""+passedName+"\"";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				String password = result.getString("user_password");
				if(password.equals(passedPassword)){
					isValid = true;
					break;
				}
			}
			result.close();
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
		return isValid;
	}
	
	public boolean checkNewUserNameValid(String passedName){
		boolean isValid = true;
    	try {
			Statement statement = connection.createStatement();
			String sql = "SELECT user_name FROM user WHERE user_name=\""+passedName+"\"";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				String name = result.getString("user_name");
				if(name.equals(passedName)){
					isValid = false;
					break;
				}
			}
			result.close();
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
		return isValid;
	}
	
	public void addNewUser(String passedName, String passedPassword, String passedEmail, String passedgender){
    	try {
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO user (user_name, user_password, user_email, user_gender) VALUES "
					+ "(\""+passedName+"\",\""+passedPassword+"\",\""+passedEmail+"\",\""+passedgender+"\")";
			statement.executeUpdate(sql);
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
	}
	
	public UserBean getUserByUserId(int passedUserId){
		UserBean user = new UserBean();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM user WHERE user_id=\""+passedUserId+"\"";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				user.setId(result.getInt("user_id"));
				user.setName(result.getString("user_name"));
				user.setPassword(result.getString("user_password"));
				user.setEmail(result.getString("user_email"));
				user.setGender(result.getString("user_gender"));
				user.setHeadPicture(result.getString("user_picture_url"));
				break;
			}
			result.close();
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
		return user;
	}
	
	public void addNewJourney(int passedJourneyProviderId, String passedJourneyTitle){
    	try {
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO journey (journey_provider_id, journey_title) VALUES "
					+ "("+passedJourneyProviderId+",\""+passedJourneyTitle+"\")";
			statement.executeUpdate(sql);
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
	}
	
	public JourneyBean getJourneyByJourneyId(int passedJourneyId){
		JourneyBean journey = new JourneyBean();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM journey WHERE journey_id=\""+passedJourneyId+"\"";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				journey.setId(result.getInt("journey_id"));	
				journey.setProviderId(result.getInt("journey_provider_id"));
				journey.setTitle(result.getString("journey_title"));
				break;
			}
			journey.setStoryIdList(getStoryIdListByJourneyId(passedJourneyId));
			result.close();
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
		return journey;
	}
	
	public void addNewStory(int journeyId, String passedTitle, String passedContent, String passedDate, double passedLongitude, double passedLatitude, String passedDuration){
    	try {
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO story (journey_id, story_title, story_content, story_date, story_longitude, story_latitude, story_duration) VALUES ("
					+journeyId+",\""+passedTitle+"\",\""+passedContent+"\",\""+passedDate+"\","+passedLongitude+","+passedLatitude+",\""+passedDuration+"\")";
			statement.executeUpdate(sql);
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
	}
	
	public StoryBean getStoryByStoryId(int passedStoryId){
		StoryBean story = new StoryBean();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM story WHERE story_id=\""+passedStoryId+"\"";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				story.setId(result.getInt("story_id"));
				story.setJourneyId(result.getInt("journey_id"));
				story.setTitle(result.getString("story_title"));
				story.setContent(result.getString("story_content"));
				story.setDate(result.getString("story_date"));
				story.setLongitude(result.getDouble("story_longitude"));
				story.setLatitude(result.getDouble("story_latitude"));
				story.setDuration(result.getString("story_duration"));
				break;
			}
			story.setCommentList(getCommentListByStoryId(passedStoryId));
			result.close();
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
		return story;
	}
	
	public ArrayList<MarkerBean> getMarkerListByBound(float boundNorthEastLat, float boundNorthEastLng, float boundSouthWestLat, float boundSouthWestLng){
		ArrayList<MarkerBean> markerList = new ArrayList<MarkerBean>();
		try {
			Statement statement = connection.createStatement();
			String sql;
			sql = "SELECT story_id,story_title,story_longgitude,story_latitude FROM story "
					+"WHERE (story_latitude<"+boundNorthEastLat+" AND story_latitude>"+boundSouthWestLat
					+" And story_longitude<"+boundNorthEastLng+" AND story_longitude>"+boundSouthWestLng+")";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				MarkerBean marker = new MarkerBean();
				marker.setStoryId(result.getInt("story_id"));
				marker.setStoryTitle(result.getString("story_title"));
				marker.setLongitude(result.getDouble("story_longitude"));
				marker.setLatitude(result.getDouble("story_latitude"));
				markerList.add(marker);
			}
			result.close();
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
		return markerList;
	}
	
	public ArrayList<Integer> getStoryIdListByJourneyId(int passedJourneyId){
		ArrayList<Integer> storyIdList = new ArrayList<Integer>();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT story_id FROM story WHERE journey_id=\""+passedJourneyId+"\" ORDER BY story_date";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				storyIdList.add(result.getInt("story_id"));
			}
			result.close();
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
		return storyIdList;
	}
	
	public void addNewComment(String passedContent, String passedTime, int passedStoryId, int passedProviderId){
    	try {
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO comment (comment_content, comment_time, story_id, comment_provider_id) VALUES "
					+ "(\""+passedContent+"\",\""+passedTime+"\","+passedStoryId+","+passedProviderId+")";
			statement.executeUpdate(sql);
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
	}
	
	public ArrayList<CommentBean> getCommentListByStoryId(int passedStoryId){
		ArrayList<CommentBean> commentList = new ArrayList<CommentBean>();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM comment WHERE story_id=\""+passedStoryId+"\" ORDER BY comment_time";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				CommentBean comment = new CommentBean();
				comment.setId(result.getInt("comment_id"));
				comment.setContent(result.getString("comment_content"));
				comment.setTime(result.getString("comment_time"));
				comment.setStoryId(result.getInt("story_id"));
				comment.setProviderId(result.getInt("comment_provider_id"));
				commentList.add(comment);
			}
			result.close();
			statement.close();
		}
    	catch (Exception e) {e.printStackTrace();}
		return commentList;
	}
}