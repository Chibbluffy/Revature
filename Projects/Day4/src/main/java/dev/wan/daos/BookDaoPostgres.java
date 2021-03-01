package dev.wan.daos;

import dev.wan.entities.Book;
import dev.wan.utils.ConnectionUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class BookDaoPostgres implements BookDAO {

    Logger logger = Logger.getLogger(BookDaoPostgres.class.getName());

    @Override
    public Book createBook(Book book) {
        // try with resources syntax
        // no matter what happens Java will close that object to prevent any resource leaks
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into book (title,author,book_condition,available,return_date) values (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getCondition());
            ps.setBoolean(4, book.isAvailable());
            ps.setLong(5, book.getDueDate());

            ps.execute(); //executes
            // result set is a cursor that starts before the actual first element
            ResultSet rs = ps.getGeneratedKeys(); // returns values of generated keys
            rs.next(); // first element
            int key = rs.getInt("book_id");
            book.setBookId(key);
            return book;

        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("unable to create book", sqlException);
            return null;
        }
    }

    @Override
    public Set<Book> getAllBooks() {
        Set<Book> allBooks = new HashSet<Book>();
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from book";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCondition(rs.getInt("book_condition"));
                book.setAvailable(rs.getBoolean("available"));
                book.setDueDate(rs.getLong("return_date"));

                allBooks.add(book);
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("unable to get all books", sqlException);
        }
        return allBooks;
    }

    @Override
    public Book getBookById(int id) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from book where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next(); // gets first actual book/moves cursor
            Book book = new Book();
            book.setBookId(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setCondition(rs.getInt("book_condition"));
            book.setAvailable(rs.getBoolean("available"));
            book.setDueDate(rs.getLong("return_date"));
            return book;

        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("unable to get book", sqlException);
            return null;
        }
    }

    @Override
    public Book updateBook(Book book) {
        try(Connection conn = ConnectionUtil.createConnection()){
            // sql using nice prepared statements
            // write a string and update the string directly with your values
            String sql = "update book set title = ?, author = ?, book_condition = ?, available = ?, return_date = ? where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getCondition());
            ps.setBoolean(4, book.isAvailable());
            ps.setLong(5, book.getDueDate());
            ps.setInt(6, book.getBookId());
            ps.execute();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("unable to update book", sqlException);
        }
        return book;
    }

    @Override
    public boolean deleteBookById(int id) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "delete from book where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;

        }catch(SQLException sqlException){
            sqlException.printStackTrace();
            logger.error("unable to delete book", sqlException);
            return false;
        }
    }
}
