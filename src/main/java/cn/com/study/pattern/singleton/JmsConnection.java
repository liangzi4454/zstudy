package cn.com.study.pattern.singleton;

public class JmsConnection {
	
	private JmsConnection() {
		System.out.println("0000000000000000");
	}
	
	public final static JmsConnection INSTANCE = new JmsConnection();
	
	public void start() {
		System.out.println(123);
	}
	public static void main(String[] args) {
		JmsConnection.INSTANCE.start();
	}
}
