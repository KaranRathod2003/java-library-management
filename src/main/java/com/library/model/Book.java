package com.library.model;

public class Book {
    private String title;
    private String author;
    private int id;
    private boolean available;
    // constructor
    public Book(int id, String author, String title){
            this.id =id;
            this.title =title;
            this.author = author;
            this.available = true;
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

    public void setAvailable(boolean available){
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
    public boolean borrow(int inputId){
        if(this.id == inputId && available) {
            available = false;
            return true;
        }return false;
    }
    public boolean returnBook(int inputId){
        if(this.id == inputId && !available){
            available = true;
            return true;
        }return false;
    }
    public String toString(){
        return "Book{" +
                "id = " + id +
                ", Title = " + title + '\'' +
                ", Author = " + author + '\'' +
                ", Available = " + available +
                "}";
        }
}
