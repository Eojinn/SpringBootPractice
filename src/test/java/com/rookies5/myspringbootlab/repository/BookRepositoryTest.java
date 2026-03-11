package com.rookies5.myspringbootlab.repository;

import com.rookies5.myspringbootlab.entity.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("홍길동과 박둘리 도서 저장 테스트")
    void 도서저장_테스트() {
        // 1. 홍길동 도서 생성 (Given)
        Book book1 = Book.builder()
                .title("스프링 부트 입문")
                .author("홍길동")
                .isbn("9788956746425")
                .publishDate(LocalDate.of(2025, 5, 7))
                .price(30000)
                .build();

        // 2. 박둘리 도서 생성 (Given)
        Book book2 = Book.builder()
                .title("JPA 프로그래밍")
                .author("박둘리")
                .isbn("9788956746432")
                .publishDate(LocalDate.of(2025, 4, 30))
                .price(35000)
                .build();

        // 저장 (When)
        Book savedBook1 = bookRepository.save(book1);
        Book savedBook2 = bookRepository.save(book2);

        // 검증 (Then)
        assertThat(savedBook1.getAuthor()).isEqualTo("홍길동");
        assertThat(savedBook2.getAuthor()).isEqualTo("박둘리");
    }
}