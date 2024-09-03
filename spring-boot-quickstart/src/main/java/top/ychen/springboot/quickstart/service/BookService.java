package top.ychen.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.ychen.springboot.quickstart.dto.BookDTO;

import java.util.List;

@Service
public class BookService {
    public List<BookDTO> getAllBooks() {
        return List.of(
                new BookDTO(1L,"Java Programming", "John Doe", 50.66),
                new BookDTO(2L,"Java Programming2", "John Doe2", 60.99)
        );
    }
}
