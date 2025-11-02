package com.library.model;

public class Book {
    private String title;
    private String author;
    private int bookId;
    private boolean isBorrowed;

    public int getBookId() { return bookId; }


    // constructor
    public Book(int bookId, String author, String title){
            this.bookId = bookId;
            this.title =title;
            this.author = author;
            this.isBorrowed = true;
    }

    public void setTitle(String title){
         this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
    public boolean borrow(int inputId ){
        if(this.bookId == inputId && !isBorrowed) {
            isBorrowed = true;
            return true;
        }
        return false;
    }
    public boolean returnBook(int inputId){
        if(this.bookId == inputId && isBorrowed){
            isBorrowed = false;
            return true;
        }return false;
    }
    public String toString(){
        return "Book{" +
                "id = " + bookId +
                ", Title = " + title + '\'' +
                ", Author = " + author + '\'' +
                ", Available = " + (!isBorrowed) +
                "}";
        }
}
