package com.example.au.WebDevDemo.repository;

import com.example.au.WebDevDemo.model.Book;
import com.example.au.WebDevDemo.rowmapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks() {
        final String GET_ALL_BOOKS = "SELECT id, name, author_name from book";
        return jdbcTemplate.query(GET_ALL_BOOKS, new BookRowMapper());
    }

    public int saveBook(Book book) {
        final String SAVE_BOOK = "insert into book(name, author_name) values(?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement stmt = connection.prepareStatement(SAVE_BOOK, new String[]{"id"});
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getAuthorName());
            return stmt;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Book findBookById(int id) {
        final String FIND_BY_ID = "select id, name, author_name from book where id = ?";
        return jdbcTemplate.queryForObject(FIND_BY_ID, this::mapRowToBook, id);
    }

    public void updateBook(Book book) {
        final String UPDATE_BOOK_QUERY = "update book set name = ?, author_name = ? where id = ?";
        jdbcTemplate.update(UPDATE_BOOK_QUERY, book.getName(), book.getAuthorName(), book.getId());
    }

    public boolean deleteBookById(int id) {
        final String DELETE_QUERY = "delete from book where id = ?";
        return jdbcTemplate.update(DELETE_QUERY, id) > 0;
    }

    private Book mapRowToBook(ResultSet resultSet, int rowNumber) throws SQLException {
        return new Book()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name"))
                .setAuthorName(resultSet.getString("author_name"));
    }
}
