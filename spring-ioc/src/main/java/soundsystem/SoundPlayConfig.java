package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan //默认扫描同包下component
//@ComponentScan(basePackages = {"com.weaver.soundsystem"}) //指定扫描的包名
@ComponentScan(basePackageClasses = {SgtPeppers.class}) //指定类所在的包将会作为组件扫描的基础包
public class SoundPlayConfig {
}
