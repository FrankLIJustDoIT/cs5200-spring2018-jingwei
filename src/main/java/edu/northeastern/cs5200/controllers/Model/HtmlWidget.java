package edu.northeastern.cs5200.controllers.Model;

public class HtmlWidget extends Widget{
	private String html;
	
	public HtmlWidget(int id, String name, int width, int height, String text, int order, String html){
		this(id, name, width, height, "", "", text, order, html);
	}
    
	public HtmlWidget(int id, String name, int width, int height, String cssClass, 
    		String cssStyle, String text, int order, String html){
        super(id, name, width, height, cssClass, cssStyle, text, order);
        super.type = Type.html;
        this.html = html;
    }
    
	public String getHtml(){
		return html;
	}
	public void setHtml(String html){
		this.html = html;
	}
}
