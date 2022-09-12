package es.imatia.redsocial;

import java.time.LocalDate;
import java.util.List;

public class ImagePost extends Post {
	
	private String title;
	private int width;
	private int height;


	public ImagePost(LocalDate date, List<Comment> commentlist, String title, int width, int height) {
		super(date, commentlist);
		this.title = title;
		this.width = width;
		this.height = height;
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
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	
}
