package org.oni.webapp.form;

/**
 * This is a abstract form of all screen.
 * @author DungTV
 */
public class AbstractForm {
	/** command (list/register) */
	private String command;
	
	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}


	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}
}
