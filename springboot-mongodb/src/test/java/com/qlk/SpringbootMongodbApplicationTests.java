package com.qlk;

import com.qlk.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;


@SpringBootTest
class SpringbootMongodbApplicationTests {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Test
  void contextLoads() {

    Book book = new Book();
    book.setId(2);
    book.setName("复习全书");
    book.setType("考研类");
    book.setDesc("考研必备");
    mongoTemplate.save(book);
  }

  @Test
  void testFindAll() {
    List<Book> all = mongoTemplate.findAll(Book.class);
    System.out.println("all = " + all);
  }

}
