package soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(SoundPlayConfig.class)
@Configuration
public class CombinationBeansConfig {
}
