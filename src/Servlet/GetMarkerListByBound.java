package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.*;

import JavaBean.DataBean;
import JavaBean.MarkerBean;

public class GetMarkerListByBound extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetMarkerListByBound() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		float boundNorthEastLat = Float.parseFloat(request.getParameter("boundNorthEastLat"));
		float boundNorthEastLng = Float.parseFloat(request.getParameter("boundNorthEastLng"));
		float boundSouthWestLat = Float.parseFloat(request.getParameter("boundSouthWestLat"));
		float boundSouthWestLng = Float.parseFloat(request.getParameter("boundSouthWestLng"));
		
		DataBean db = new DataBean();
		ArrayList<MarkerBean> markerList = db.getMarkerListByBound(boundNorthEastLat, boundNorthEastLng, boundSouthWestLat, boundSouthWestLng);
		JSONArray storyList = new JSONArray();
		// 20 limited
		for(int i=0; i<markerList.size(); i++){
			JSONObject story = new JSONObject();
			story.put("lat", markerList.get(i).getLatitude());
			story.put("lng", markerList.get(i).getLongitude());
			story.put("title", markerList.get(i).getStoryTitle());
			story.put("id", markerList.get(i).getStoryId());
			storyList.add(story);
		}
		
		out.println(storyList);
		db.closeConnection();
		out.flush();
		out.close();
	}



	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
