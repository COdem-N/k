package model;

import java.io.Serializable;
import java.util.List;

public class ProjectModel implements Serializable{
	private static final long serialVersionUID = -5249021995124520760L;
	private final String myName;
	private final List<String> myImageLinks;
	private final String myMaterials;
	private final int myDifficulty;
	private final int myCost;
	private final String myBody;
	private final List<String> myTags;
	private static int myID = 0;
	private int myRunningID;
	
	public ProjectModel(String theName,
						List<String> theImageLinks,
						String theMaterials,
						int theDifficulty,
						int theCost,
						String theBody,
						List<String> theTags) {
		myName = theName;
		myImageLinks = theImageLinks;
		myMaterials = theMaterials;
		myDifficulty = theDifficulty;
		myCost = theCost;
		myBody = theBody;
		myTags = theTags;
		myID= myRunningID;
		myRunningID++;
	}
	
	public String getName() {
		return myName;
	}
	
	public List<String> getImageLinks() {
		return myImageLinks;
	}
	
	public String getMaterials() {
		return myMaterials;
	}
	
	public int getDifficulty() {
		return myDifficulty;
	}
	
	public float getCost() {
		return myCost;
	}
	
	public String getBody() {
		return myBody;
	}
	
	public List<String> getTags() {
		return myTags;
	}

}
