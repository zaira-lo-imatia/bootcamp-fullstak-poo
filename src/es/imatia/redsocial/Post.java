package es.imatia.redsocial;

import java.time.LocalDate;
import java.util.List;

public class Post {
	private LocalDate date;
	private List<Comment> commentlist;
	
	
	public Post() {
	}
	
	public Post(LocalDate date, List<Comment> commentlist) {
		this.date = date;
		this.commentlist = commentlist;
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
	 * @return the commentlist
	 */
	public List<Comment> getCommentlist() {
		return commentlist;
	}
	/**
	 * @param commentlist the commentlist to set
	 */
	public void setCommentlist(List<Comment> commentlist) {
		this.commentlist = commentlist;
	}
	


}
