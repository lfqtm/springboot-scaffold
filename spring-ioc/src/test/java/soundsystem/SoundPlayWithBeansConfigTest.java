package soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SoundPlayWithBeansConfig.class)
public class SoundPlayWithBeansConfigTest {

	@Rule
	public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Autowired
	@Qualifier("sgtPeppersNewNamed")
	private SgtPeppers sgtPeppers;

	@Autowired
	@Qualifier("randomCompactDisc") //默认方法名
	private CompactDisc compactDisc;


	@Test
	public void testSgtPeppersNewNamed() {
		assertEquals("soundsystem.SgtPeppers", sgtPeppers.getClass().getName());
	}

	@Test
	public void testRandomSgtPepper() {
		assertNotNull(compactDisc);

	}
}
