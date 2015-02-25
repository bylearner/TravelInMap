package JavaBean;

public class TestApp {

	public static void main(String[] args) {
		//DataBean db = new DataBean();
		//db.addNewComment("this is good", "3 hour", 143, 134);
		//db.closeConnection();
		String journeyId = "150202";
		String storySequence = "150202";
		String passedContent = "150202";
		String passedDate = "150202";
		String passedLongitude = "150202";
		String passedLatitude = "150202";
		String passedDuration = "150202";
		String sql = "INSERT INTO story (journey_id, story_content, story_date, story_longitude, story_latitude, story_duration) VALUES ("
		+journeyId+",\""+passedContent+"\",\""+passedDate+"\","+passedLongitude+","+passedLatitude+",\""+passedDuration+"\")";
		System.out.print(sql);
	}

}
