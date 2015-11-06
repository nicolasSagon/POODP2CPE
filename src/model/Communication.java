package model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Communication implements Serializable {

	private int code;
	private Object data;

	public Communication(int command, Object data) {
		this.code = command;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int command) {
		this.code = command;
	}
	
	@SuppressWarnings("unchecked")
	public String toString() {
		String str = "Code " + this.code;
		if (code == 1)
			str += " | " + ((List<PieceIHM>)data);
		return str;
	}

}
