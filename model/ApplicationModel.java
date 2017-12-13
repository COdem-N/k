package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to aggregate and manage ProjectModel objects.
 * 
 * @author Peter Bae
 * @author Logan Stafford (editing)
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ApplicationModel implements Serializable {
	
    /************************************
     **          CLASS FIELDS         **
     ***********************************/
	
	/**
	 * List of ProjectModels.
	 */
	private List<ProjectModel> myProjectList;
	
	/**
	 * Map of Tags/Occurrences pulled from the ProjectModels.
	 */
	private Map<String, Integer> myTagMap;
	
    /************************************
     ** CLASS CONSTRUCTOR AND METHODS **
     ***********************************/
	
	/**
	 * Constructor to initialize the fields.
	 * 
	 * @author Peter Bae
	 */
	public ApplicationModel() {
		myProjectList = new ArrayList<ProjectModel>();
		myTagMap = new HashMap<String, Integer>();
	}
	
	/**
	 * Adds the passed in ProjectModel to the project list.
	 * 
	 * @author Peter Bae
	 * 
	 * @param theProject The ProjectModel to be added in.
	 */
	public void addProject(ProjectModel theProject) {
		for (int i = 0; i < theProject.getTags().size(); i++) {
			String key = theProject.getTags().get(i);
			if (myTagMap.containsKey(key)) {	
				myTagMap.put(key, myTagMap.get(key)+1);
			} else {
				myTagMap.put(key, 1);
			}
		}
		myProjectList.add(theProject);
	}
	
	/**
	 * Returns the entire project list.
	 * 
	 * @author Peter Bae
	 * 
	 * @return The entire project list.
	 */
	public List<ProjectModel> getProjects() {
		return myProjectList;
	}
	
	/**
	 * Returns a list of projects containing the passed in tag.
	 * 
	 * @author Peter Bae
	 * 
	 * @param theTag The tag to test for.
	 * @return A list of projects containing the passed in tag.
	 */
	public List<ProjectModel> getProjects(String theTag) {
		
		/* Initializing a new ArrayList for the projects. */
		List<ProjectModel> projects = new ArrayList<ProjectModel>();
		
		/* Appending each Project that contains the tag into the list. */
		for (int i = 0; i < myProjectList.size(); i++) {
			ProjectModel project = myProjectList.get(i);
			if (project.getTags().contains(theTag))
				projects.add(project);
		}
		
		return projects;
	}
	
	/**
	 * Returns the list of tags occurring in the projects in the project list
	 * in descending order of occurrences.
	 * 
	 * @author Peter Bae
	 * 
	 * @return List of tags occurring in the projects in the project list
	 * in descending order of occurrences.
	 */
	public List<String> getTags() {
		
		/* Initializing a new ArrayList for the project tags. */
		List<String> returnList = new ArrayList<String>();
		
		/* Appending each tag to the map. */
		if (myTagMap != null) {
			Map<String, Integer> map = new HashMap<String, Integer>(myTagMap);
			String largestKey = "";
			int largest = 0;
			
			for (int i = 0; i < myTagMap.size(); i++) {
				for (String key : map.keySet()) {
					if (map.get(key) > largest) {
						largestKey = key;
						largest = map.get(key);
					}
				}
				
				map.put(largestKey, 0);
				returnList.add(largestKey);
				largestKey = "";
				largest = 0;
			}
		}
		
		return returnList;
	}
	
	/**
	 * Returns the tags/occurrences map according to how many
	 * times the tag has appeared in the projects in the
	 * project list.
	 * 
	 * @author Peter Bae
	 * 
	 * @return Tags/occurrences map according to how many
	 * times the tag has appeared in the projects in the
	 * project list.
	 */
	public Map<String, Integer> getTagMap() {
		return myTagMap;
	}
	
	/**
	 * Returns a string representation of the the ApplicationModel.
	 * 
	 * @author Peter Bae
	 * 
	 * @return A String representation of the the ApplicationModel.
	 */
	public String toString() {		
		/* Initializing a new String via StringBuilder. */
		StringBuilder str = new StringBuilder();
		
		/* Populating the String with the list of Projects in myProjectList. */
		for (ProjectModel pm : myProjectList) {
			str.append(pm);
		}
		
		/* If myProjectList is empty, append "Empty" to the String. */
		if (myProjectList.size() == 0) {
			str.append("Empty");
		}
		
		return str.toString();
	}
}