package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoundPlayWithBeansConfig {

	@Bean(name = "sgtPeppersNewNamed")
	public SgtPeppers sgtPeppers() {
		return new SgtPeppers();
	}

	@Bean(name = "anotherSgtPeppers")
	public SgtPeppers sgtPeppersAnother() {
		return new SgtPeppers();
	}

	@Bean
	public CompactDisc randomCompactDisc() {
		int choice = (int) Math.floor(Math.random() *4);
		if (choice == 0) {
			return sgtPeppers();
		} else if (choice == 1) {
			return sgtPeppersAnother();
		} else {
			return new SgtPeppers();
		}
	}

}
