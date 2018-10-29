/**
 * Program to model a video 
 */

import java.io.Serializable;

//Class to medel the video's information
@SuppressWarnings("serial")
public class Video implements Serializable, Comparable<Video>{
	private String title;
	private int id;
	private int year_Release;
	private String director;
	

	/**
	 * Overloaded constructor
	 * @param title of the movie
	 * @param id id of the movie
	 * @param year year of release
	 * @param director name of movie director
	 */
	public Video(String title, int id, int year, String director) {

		this.title = title;
		this.id = id;
		this.year_Release = year;
		this.director = director;
	

	}

	/**
	 * Function to get the title of the movie
	 * @return title
	 */
	public String getTitle() {

		return title;
	}

	/**
	 * Function to get movie id
	 * @return id
	 */
	public int getId() {

		return id;
	}

	/**
	 * Function to get the year of the release of the movie
	 * @return the year
	 */
	public int getYear() {

		return year_Release;
	}
/**
 * Function to get the name of the movie director
 * @return the director's name
 */
	public String getdirector() {

		return director;
	}

	/**
	 * String representation of the movie
	 */
	public String toString() {

		return "Movie Title : " + title + "\nMovie ID : " + id + "\nYear of Releaase : " + year_Release
				+ "\nMovie Director : " + director;
	}

	@Override
	public int compareTo(Video o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
