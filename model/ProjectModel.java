package model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ProjectModel implements Serializable {
	private static int myRunningID = 0;
	private final int myID;
	private final String myName;
	private final List<String> myImageLinks;
	private final String myMaterials;
	private final int myDifficulty;
	private final int myCost;
	private final String myBody;
	private final List<String> myTags;
	
	public ProjectModel(String theName,
						List<String> theImageLinks,
						String theMaterials,
						int theDifficulty,
						int theCost,
						String theBody,
						List<String> theTags) {
		myID= myRunningID;
		myRunningID++;
		myName = theName;
		myImageLinks = theImageLinks;
		myMaterials = theMaterials;
		myDifficulty = theDifficulty;
		myCost = theCost;
		myBody = theBody;
		myTags = theTags;
	}
	
	public static void onLoad(int theRunningID) {
		myRunningID = theRunningID;
	}
	
	public static int getRunningID() {
		return myRunningID;
	}
	
	public int getID() {
		return myID;
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
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(myRunningID + "," + myID + "\n");
		str.append(myName + "\n");
		for (String s : myImageLinks) {
			str.append(s + ", ");
		}
		str.append("\n" + myMaterials + "\n");
		str.append(myDifficulty + "," + myCost + "\n");
		str.append(myBody + "\n");
		for (String s : myTags) {
			str.append(s + ", ");
		}
		
		return str.toString();
	}
}
