package javastudy3;

public class DVDPlayer implements ExPlayers{
	public void play() {
		System.out.println("DVD 재생 시작!"); //재생
	}
	public void stop() {
		System.out.println("DVD 재생 정지!"); //정지
	}
	public void slow() {
		System.out.println("DVD 느린 재생 시작!");
	}
}
