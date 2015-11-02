package server;

public class Communication {

	private int command;
	private Object data;

	public Communication(int command, Object data) {

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

}
