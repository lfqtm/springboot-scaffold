package soundsystem;

import org.springframework.stereotype.Component;

@Component(value = "SgtPeppersCompactDisc")
//@Component
public class SgtPeppers implements CompactDisc {

	private String title = "《青花瓷》";
	private String artist = "周杰伦";

	@Override
	public void play() {
		System.out.println("playing " + title + " by " + artist);
	}
}
