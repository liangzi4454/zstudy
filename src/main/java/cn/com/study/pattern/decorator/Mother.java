package cn.com.study.pattern.decorator;

public class Mother implements Work {
	public Mother() {
	}
	private Work work;
	
	public Mother(Work work) {
		this.work = work;
	}
	
	public void paint() {
		System.out.println("妈妈准本画纸和画笔");
		work.paint();
		System.out.println("妈妈将画笔和画纸收好");
	}
}
