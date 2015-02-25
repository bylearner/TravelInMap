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
		float boundCenterLat = Float.parseFloat(request.getParameter("boundCenterLat"));
		float boundCenterLng = Float.parseFloat(request.getParameter("boundCenterLng"));
		
		DataBean db = new DataBean();

		JSONObject story1 = new JSONObject();
		story1.put("lat", new Float(40.44));
		story1.put("lng", new Float(112.144));
		story1.put("title", "place one");
		story1.put("id", new Integer(12));
		
		JSONObject story2 = new JSONObject();
		story2.put("lat", new Float(41.44));
		story2.put("lng", new Float(119.144));
		story2.put("title", "place two");
		story2.put("id", new Integer(13));
		
		JSONObject story3 = new JSONObject();
		story3.put("lat", new Float(39.44));
		story3.put("lng", new Float(119.144));
		story3.put("title", "place three");
		story3.put("id", new Integer(14));
		
		ArrayList<JSONObject> storyListAll = new ArrayList<JSONObject>();
		storyListAll.add(story1);
		storyListAll.add(story2);
		storyListAll.add(story3);
		JSONArray storyList = new JSONArray();
		for (int i=0; i<storyListAll.size();i++){
			//System.out.println(storyListAll.get(i).get("lat"));
			//if(storyListAll.get(i).get("lat")<=boundNorthEastLat){}
		}
		
		
		storyList.add(story1);
		storyList.add(story2);
		storyList.add(story3);
		
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
