package chat;

public class Message {
	
	private String sender;
	private String msg;
	
	public Message(String sender, String msg) {
		super();
		this.sender = sender;
		this.msg = msg;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		return "Sender: " + this.getSender() + " msg: " + this.getMsg();
	}
}
