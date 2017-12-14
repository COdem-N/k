package model;

import java.io.Serializable;
import java.util.List;

/**
 * Model for the Project Object.
 * 
 * @author Peter Bae
 * @author Logan Stafford (editing)
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ProjectModel implements Serializable {
	
    /************************************
     **          CLASS FIELDS         **
     ***********************************/
	
	/**
	 * Keeps track of the ID given to new objects.
	 */
	private static int myRunningID = 0;
	
	/**
	 * The ID of the project.
	 */
	private final int myID;
	
	/**
	 * Name of the project.
	 */
	private final String myName;
	
	/**
	 * Link of the image of the project.
	 */
	private final String myImageLink;
	
	/**
	 * The material requirements of the project.
	 */
	private final String myMaterials;
	
	/**
	 * The difficulty of the project.
	 */
	private final int myDifficulty;
	
	/**
	 * The cost of the project.
	 */
	private final int myCost;
	
	/**
	 * The directions of the project.
	 */
	private final String myBody;
	
	/**
	 * List of tags that describe the project.
	 */
	private final List<String> myTags;
	
    /************************************
     ** CLASS CONSTRUCTOR AND METHODS **
     ***********************************/
	
	/**
	 * Initializes the ProjectModel object.
	 * 
	 * @author Peter Bae
	 * 
	 * @param theName The name of the project.
	 * @param theImageLink The image link of the project.
	 * @param theMaterials The material requirements of the project.
	 * @param theDifficulty The estimated difficulty of the project.
	 * @param theCost The estimated cost of the project.
	 * @param theBody The directions of the project.
	 * @param theTags The list of tags that describe the project.
	 */
	public ProjectModel(String theName,
						String theImageLink,
						String theMaterials,
						int theDifficulty,
						int theCost,
						String theBody,
						List<String> theTags) {
		myID= myRunningID;
		myRunningID++;
		myName = theName;
		myImageLink = theImageLink;
		myMaterials = theMaterials;
		myDifficulty = theDifficulty;
		myCost = theCost;
		myBody = theBody;
		myTags = theTags;
	}
	
	/**
	 * Edits the runningID. 
	 * 
	 * @author Peter Bae
	 * 
	 * @param theRunningID The desired runningID value.
	 */
	public static void setRunningID(int theRunningID) {
		myRunningID = theRunningID;
	}
	
	/**
	 * Gets the total amount of projects.
	 * 
	 * @author Peter Bae
	 * 
	 * @return the total amount of projects.
	 */
	public static int getRunningID() {
		return myRunningID;
	}
	
	/**
	 * Returns the unique ID of the project.
	 * 
	 * @author Peter Bae
	 * 
	 * @return The unique ID of the project.
	 */
	public int getID() {
		return myID;
	}
	
	/**
	 * Returns the name of the project.
	 * 
	 * @author Peter Bae
	 * 
	 * @return The name of the project.
	 */
	public String getName() {
		return myName;
	}
	
	/**
	 * Returns the image link of the project.
	 * 
	 * @author Peter Bae
	 * 
	 * @return The image link of the project.
	 */	
	public String getImageLink() {
		return myImageLink;
	}
	
	/**
	 * Returns the required materials of the project.
	 * 
	 * @author Peter Bae
	 * 
	 * @return The required materials of the project.
	 */
	public String getMaterials() {
		return myMaterials;
	}
	
	/**
	 * Returns the difficulty of the project.
	 * 
	 * @author Peter Bae
	 * 
	 * @return The difficulty of the project.
	 */
	public int getDifficulty() {
		return myDifficulty;
	}
	
	/**
	 * Returns the cost of the project.
	 * 
	 * @author Peter Bae
	 * 
	 * @return The cost of the project.
	 */
	public int getCost() {
		return myCost;
	}
	
	/**
	 * Returns the directions of the project.
	 * 
	 * @author Peter Bae
	 * 
	 * @return The directions of the project.
	 */
	public String getBody() {
		return myBody;
	}
	
	/**
	 * Returns the list of tags that describe the project.
	 * 
	 * @author Peter Bae
	 * 
	 * @return The list of tags that describe the project.
	 */
	public List<String> getTags() {
		return myTags;
	}
	
	/**
	 * Returns the string representation of the project (for debugging purposes).
	 * 
	 * @author Peter Bae
	 * 
	 * @return The string representation of the project.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(myRunningID + "," + myID + "\n");
		str.append(myName + "\n");
		str.append(myImageLink + "\n");
		str.append(myMaterials + "\n");
		str.append(myDifficulty + "," + myCost + "\n");
		str.append(myBody + "\n");
		for (String s : myTags) {
			str.append(s + ", ");
		}
		str.append("\n\n");
		
		return str.toString();
	}
}