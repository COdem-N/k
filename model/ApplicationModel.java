package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class ApplicationModel implements Serializable {
	private List<ProjectModel> myProjectList;
	private Map<String, Integer> myTagMap;
	
	public ApplicationModel() {
		myProjectList = new ArrayList<ProjectModel>();
		myTagMap = new HashMap<String, Integer>();
	}
	
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
	
	public List<ProjectModel> getProjects() {
		return myProjectList;
	}
	
	public List<ProjectModel> getProjects(String theTag) {
		List<ProjectModel> projects = new ArrayList<ProjectModel>();
		
		for (int i = 0; i < myProjectList.size(); i++) {
			ProjectModel project = myProjectList.get(i);
			if (project.getTags().contains(theTag))
				projects.add(project);
		}
		
		return projects;
	}
	
	public List<String> getTags() {
		Map<String, Integer> map = new HashMap<String, Integer>(myTagMap);
		List<String> returnList = new ArrayList<String>();
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
		
		return returnList;
	}
	
	public Map<String, Integer> getTagMap() {
		return myTagMap;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (ProjectModel pm : myProjectList) {
			str.append(pm);
		}
		
		if (myProjectList.size() == 0) {
			str.append("Empty");
		}
		
		return str.toString();
	}
}
