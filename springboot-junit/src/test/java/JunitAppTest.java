import com.qlk.Book;
import com.qlk.JunitApp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = JunitApp.class)
class JunitAppTest {

  @Autowired
  private Book book;

  @Test
  void load() {

    assertEquals(book.read(), "我读书");
  }

}