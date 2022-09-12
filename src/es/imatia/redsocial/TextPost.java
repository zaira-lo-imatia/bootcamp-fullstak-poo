package es.imatia.redsocial;

import java.time.LocalDate;
import java.util.List;

public class TextPost extends Post {
	private String content;

	public TextPost(LocalDate date, List<Comment> commentlist, String content) {
		super(date, commentlist);
		this.content = content;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
 
}
