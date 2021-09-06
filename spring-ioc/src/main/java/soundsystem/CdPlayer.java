package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CdPlayer {

	private CompactDisc cd;

	// 构造器注入
	@Autowired
	public CdPlayer(@Qualifier("anotherSgtPeppers") CompactDisc cd) {
		this.cd = cd;
	}


	//setter注入
//	@Autowired(required = false) //required=false spring会尝试自动装配，没有匹配也不会强制，但是慎用，空指针问题哦
//	@Inject //javax.inject jar包导入
//	@Qualifier("anotherSgtPeppers") //或者在参数列表中指定@Name("anotherSgtPeppers")
//	public void setCd(@Named("anotherSgtPeppers") CompactDisc cd) {
//		this.cd = cd;
//	}

	public void play() {
		cd.play();
	}
}
