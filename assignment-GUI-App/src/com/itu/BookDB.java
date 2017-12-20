package com.itu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhakti on 12/9/17.
 */
public class BookDB {

    private Connection conn;
    private List<Book> bookList = new ArrayList<>();
    private int currentIndex = 0;

    BookDB() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/book_management", "bhakti", "Password1234");
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void loadDB() {
        bookList.clear();
        try {
            String query = "SELECT * FROM Books";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String title = rs.getString("title");
                double price = rs.getDouble("price");
                // print the results
                System.out.format("%s, %s, %s, %s\n", id, code, title, price);
                Book book = new Book(code, title, price);
                bookList.add(book);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveDB() {
        for (Book book : bookList) {
            try {
                String query = " insert into books (code, title, price)"
                        + " values (?, ?, ?)";
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, book.getCode());
                preparedStmt.setString(2, book.getTitle());
                preparedStmt.setDouble(3, book.getPrice());
                preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Book moveFirst() {
        currentIndex = 0;
        return bookList.get(0);
    }

    public Book movePrevious() {
        if (currentIndex == 0) {
            return bookList.get(0);
        } else {
            currentIndex = currentIndex - 1;
            return bookList.get(currentIndex);
        }
    }

    public Book moveNext() {
        if (currentIndex == bookList.size() - 1) {
            return bookList.get(currentIndex);
        } else {
            currentIndex = currentIndex + 1;
            return bookList.get(currentIndex);
        }
    }

    public Book moveLast() {
        currentIndex = bookList.size() - 1;
        return bookList.get(currentIndex);
    }

    public void addRecord(Book book) {
        String code = book.getCode();
        Book foundbook = findOnCode(code);
        if (foundbook != null) {
            foundbook.setPrice(book.getPrice());
            foundbook.setTitle(book.getTitle());
            updateBook(foundbook);
        } else {
            try {
                String query = " insert into books (code, title, price)"
                        + " values (?, ?, ?)";
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, book.getCode());
                preparedStmt.setString(2, book.getTitle());
                preparedStmt.setDouble(3, book.getPrice());
                preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            bookList.add(book);
            currentIndex = bookList.size() - 1;

        }


    }

    private void updateBook(Book foundbook) {
        // create the java mysql update preparedstatement
        try {
            String query = "update books set title = ?  ,  price = ? where code = ?";
            PreparedStatement preparedStmt = null;

            preparedStmt = conn.prepareStatement(query);

            preparedStmt.setString(1, foundbook.getTitle());
            preparedStmt.setDouble(2, foundbook.getPrice());
            preparedStmt.setString(3, foundbook.getCode());
            // execute the java preparedstatement
            preparedStmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(Book book) {
        try {
            int indexToRemove = currentIndex;
            if (currentIndex == bookList.size() - 1) {
                currentIndex = currentIndex - 1;
            }

            bookList.remove(indexToRemove);
            String query = "delete from books where code = ? and title = ? and price = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, book.getCode());
            preparedStmt.setString(2, book.getTitle());
            preparedStmt.setDouble(3, book.getPrice());
            preparedStmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Book findOnCode(String inputCode) {
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            if (inputCode.equals(book.getCode())) {
                return book;
            }
        }

        return null;
    }


    public List<Book> getBookList() {
        return bookList;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
}
