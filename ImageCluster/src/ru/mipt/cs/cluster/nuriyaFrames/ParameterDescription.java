package ru.mipt.cs.cluster.nuriyaFrames;

public class ParameterDescription {
	
	private String parameter;
	private String description;
	
	public ParameterDescription (String parameter, String description) {
		
		this.parameter = parameter;
		this.description = description;
	}
	
	public String getParameter () {
		return parameter;
	}
	
	public String getDescription () {
		return description;
	}
	
	public String toString () {
		return parameter;
	}
}
