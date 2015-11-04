package model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Communication implements Serializable {

	private int command;
	private Object data;

	public Communication(int command, Object data) {
		this.command = command;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}
	
	@SuppressWarnings("unchecked")
	public String toString() {
		String str = "Command " + this.command;
		if (command == 1)
			str += " | " + ((List<PieceIHM>)data);
		return str;
	}

}
