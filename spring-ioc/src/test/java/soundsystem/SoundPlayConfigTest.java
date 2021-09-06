package soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class) //使用SpringJUnit4ClassRunner无差别，@RunWith是值在测试类在某个启动器环境下执行，SpringRunner指定在spring环境下执行
//默认加载好spring的上下文
@ContextConfiguration(classes = SoundPlayConfig.class) //@ContextConfiguration注解来标注我们想要导入这个测试类的某些bean，
//springboot环境下，使用SpringBootTest，导入主类下的所有bean
public class SoundPlayConfigTest {

	@Autowired
	@Qualifier("SgtPeppersCompactDisc")
	private CompactDisc cd;

	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(cd);
		System.out.println();
	}

}
