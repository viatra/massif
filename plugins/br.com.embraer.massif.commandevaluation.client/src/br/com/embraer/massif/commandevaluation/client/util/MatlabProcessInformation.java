package br.com.embraer.massif.commandevaluation.client.util;

/**
 * DTO(data transfer object) class used to hold information about the
 * current running matlab processes
 * 
 * @author ldnascim
 */
public class MatlabProcessInformation {
	public String path = "";
	public int pid = 0;
	public String release = "";
	public boolean is32bits;
	
	/**
	 * If path, pid or release are empty, then the instance has no proper
	 * information about a Matlab process
	 * 
	 * @return True if neither path, pid nor release are empty
	 */
	public boolean isEmpty() {
		return (pid == 0) || (path.isEmpty())|| (release.isEmpty());
	}
}