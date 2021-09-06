package soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SoundPlayConfig.class)
public class CdPlayerTest {

	// StandardOutputStreamLog被弃用了
	@Rule  //https://www.jianshu.com/p/e74ca1b42730
	public final SystemOutRule log = new SystemOutRule().enableLog();

	@Autowired
	private CdPlayer cdPlayer;

	@Test
	public void cdPlayerWithCd() {
		cdPlayer.play();
		assertEquals("playing 《青花瓷》 by 周杰伦\r\n",log .getLog()); //cr: \r; lf: \n

	}
}
