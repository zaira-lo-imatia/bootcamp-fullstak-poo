package es.imatia.redsocial;

import java.time.LocalDate;
import java.util.List;

public class VideoPost extends Post {

	private String title;
	private String definition;
	private int seconds;
	
	
	public VideoPost(LocalDate date, List<Comment> commentlist, String title, String definition, int seconds) {
		super(date, commentlist);
		this.title = title;
		this.definition = definition;
		this.seconds = seconds;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the definition
	 */
	public String getDefinition() {
		return definition;
	}
	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	/**
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}
	/**
	 * @param seconds the seconds to set
	 */
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	
}
