package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import JavaBean.DataBean;
import JavaBean.MarkerBean;

public class GetNearestStoryId extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetNearestStoryId() {
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
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		float clientLat = Float.parseFloat(request.getParameter("lat"));
		float clientLng = Float.parseFloat(request.getParameter("lng"));
		
		DataBean db = new DataBean();
		MarkerBean nearestMarker = db.getNearestMarker(clientLat, clientLng);
		double storyLat=nearestMarker.getLatitude();
		double storyLng=nearestMarker.getLongitude();
		double latDistance=Math.abs(storyLat-clientLat);
		double lngDistance=Math.abs(storyLng-clientLng);
		double distance = Math.sqrt(latDistance*latDistance + lngDistance*lngDistance)*40000/360;
		JSONObject JSONMarker = new JSONObject();
		JSONMarker.put("title", nearestMarker.getStoryTitle());
		JSONMarker.put("id", nearestMarker.getStoryId());
		JSONMarker.put("distance", distance);
		//System.out.println(JSONMarker.toString());
		response.getOutputStream().print(JSONMarker.toString());
		//System.out.print(nearestStoryId);
		db.closeConnection();
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
