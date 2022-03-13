package com.qlk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JunitAppTest {

  @Autowired
  private Book book;

  @Test
  void load() {

    assertEquals(book.read(), "我读书");
  }

}