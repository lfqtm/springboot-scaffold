package com.qlk;

import org.springframework.stereotype.Repository;

@Repository
public class BookImpl implements Book {
  @Override
  public String read() {
    return "我读书";
  }
}
