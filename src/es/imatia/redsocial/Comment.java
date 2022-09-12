package es.imatia.redsocial;

import java.time.LocalDate;

public class Comment {
	private String text;
	private LocalDate date;
	private User owner;
	
	
	public Comment() {
	}
	
	
	public Comment(String text, LocalDate date, User owner) {
		this.text = text;
		this.date = date;
		this.owner = owner;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	

}
