import javax.swing.plaf.synth.SynthSeparatorUI;

public class SamsungCDPlayer implements CDPlayer {

	@Override
	public void play() {
		System.out.println("위이이이이이이잉이이이잉?");
		System.out.println("음악을 재생하고 있습니다.");
	}

	@Override
	public void stop() {
		System.out.println("드르르르륵....");
		System.out.println("음악을 일시정지 했습니다.");
	}

	@Override
	public void next() {
		System.out.println("드르르륵... 위이이이잉이잉...");
		System.out.println("다음 트랙을 찾아 재생합니다.");
	}

	@Override
	public void prev() {
		System.out.println("드르르르르륵..... 위이이이이잉");
		System.out.println("이전 트랙을 찾아 재생합니다.");
	}

	@Override
	public void supple() {
		System.out.println("그런건 없다.");
	}
	
	

}
