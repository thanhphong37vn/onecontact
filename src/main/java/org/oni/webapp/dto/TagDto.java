package org.oni.webapp.dto;

/**
 * 
 * @author DungTV
 *
 */
public class TagDto {
	private String name;
	private boolean selected;

	
	/**
	 * @param name
	 * @param selected
	 */
	public TagDto(String name, boolean selected) {
		super();
		this.name = name;
		this.selected = selected;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
