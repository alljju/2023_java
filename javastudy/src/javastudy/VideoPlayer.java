package javastudy;

interface controllable {
	void play();
	void stop();
}

public class VideoPlayer implements controllable{
	
	@Override
	public void play() {
		System.out.println("비디오 플레이어 Play");
	}
	@Override
	public void stop() {
		System.out.println("비디오 플레이어 Stop");
	}
	
	public static void main(String[] args) {
		
		controllable c = new VideoPlayer();
		c.play();
		c.stop();
		
	}

}