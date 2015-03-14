package JavaBean;

import java.io.Serializable;

public class CommentBean implements Serializable{

	private String time;
	private String content;
	private String providerName;
	private String providerPicture;
	
	public CommentBean() {}
	
	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public String getProviderName() {return providerName;}
	public void setProviderName(String providerName) {this.providerName = providerName;}
	public String getProviderPicture() {return providerPicture;}
	public void setProviderPicture(String providerPicture) {this.providerPicture = providerPicture;}
}
