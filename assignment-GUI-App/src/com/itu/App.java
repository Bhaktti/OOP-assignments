package com.itu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bhakti on 12/9/17.
 */
public class App extends JFrame {
    private JPanel panel;
    private JButton firstButton;
    private JButton nextButton;
    private JButton lastButton;
    private JTextField codeField;
    private JTextField titleField;
    private JTextField priceField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton exitButton;
    private JButton prevButton;

    private BookDB dao;

    public App() throws SQLException {
        dao = new BookDB();
        dao.loadDB();
        initGUI();
    }

    private void initGUI() {
        updateButton.setEnabled(false);
        performBookDisplay();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                enableButtons(false);
                codeField.setText("");
                titleField.setText("");
                priceField.setText("");
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableButtons(true);
                System.out.println("Update button clicked");
                Book book = getBookFromUI();
                dao.addRecord(book);
                performBookDisplay();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete button clicked");
                dao.deleteRecord(getBookFromUI());
                performBookDisplay();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit button clicked");
                System.exit(0);
            }
        });

        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("FirstButton clicked");
                Book book = dao.moveFirst();
                showThisBook(book);
            }
        });
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Prev Button clicked");
                Book book = dao.movePrevious();
                showThisBook(book);
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Next button clicked");
                Book book = dao.moveNext();
                showThisBook(book);
            }
        });
        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Last button clicked");
                Book book = dao.moveLast();
                showThisBook(book);
            }
        });

        codeField.addKeyListener(new ESCKeyListener());
        titleField.addKeyListener(new UpdateListener());
        priceField.addKeyListener(new UpdateListener());



    }

    private void showThisBook(Book book) {
        codeField.setText(book.getCode());
        titleField.setText(book.getTitle());
        priceField.setText("$" + book.getPrice());
    }

    private void performBookDisplay() {
        int currentIndex = dao.getCurrentIndex();
        List<Book> bookList = dao.getBookList();
        if (!bookList.isEmpty()) {
            Book book = bookList.get(currentIndex);
            codeField.setText(book.getCode());
            titleField.setText(book.getTitle());
            priceField.setText("$" + book.getPrice());
        }
    }

    private Book getBookFromUI() {
        String codeFieldText = codeField.getText();
        String titleFieldText = titleField.getText();
        String priceFieldText = priceField.getText();

        String priceFieldTextWithoutDollar = priceFieldText.replace("$", "").trim();

        return new Book(codeFieldText, titleFieldText, Double.valueOf(priceFieldTextWithoutDollar));
    }


    public static void main(String args[]) throws SQLException {
        JFrame frame = new JFrame("App");
        App app = new App();
        frame.setContentPane(app.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private class ESCKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_ESCAPE) {
                codeField.requestFocus();
                performBookDisplay();
                enableButtons(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class UpdateListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_ESCAPE) {
                codeField.requestFocus();
                performBookDisplay();
                enableButtons(true);
            } else {
                enableButtons(false);
                System.out.println("Modification clicked");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }


    private void enableButtons(boolean enableAllButtons) {
        boolean enableUpdateButton = false;
        if (!enableAllButtons)
            enableUpdateButton = true;
        updateButton.setEnabled(enableUpdateButton);
        addButton.setEnabled(enableAllButtons);
        deleteButton.setEnabled(enableAllButtons);
        firstButton.setEnabled(enableAllButtons);
        nextButton.setEnabled(enableAllButtons);
        prevButton.setEnabled(enableAllButtons);
        lastButton.setEnabled(enableAllButtons);
    }

}
