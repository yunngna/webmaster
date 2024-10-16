package chap08;

public class Audio implements RemoteControl{
	//필드
	private int volume;
	//생성자
	//메소드
	@Override
	public void turnOn() {
		System.out.println("오디오를 킵니다.");
		
	}
	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다.");
		
	}
	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 오디오 볼륨:" + this.volume);
		//System.out.println("현재 오디오 볼륨:" + volume); 이 경우 if 적용 안되고 그냥 적는대로 volume이 인출된다. 
	}

}
