package cn.com.study.pattern.decorator;

public class Father implements Work {

	public Father() {
	}
	
	private Work work;
	
	public Father(Work work) {
		this.work = work;
	}
	
	public void paint() {
		System.out.println("爸爸准本画板和画架");
		work.paint();
		System.out.println("爸爸将话本和画架收好");
	}

}
