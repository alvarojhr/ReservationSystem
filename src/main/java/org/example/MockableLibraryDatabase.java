package org.example;

import java.util.List;
import java.util.ArrayList;

public class MockableLibraryDatabase implements LibraryDatabase {

    private List<Student> students = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    @Override
    public void saveBookData(Book book) {
        books.add(book);
    }

    @Override
    public void saveStudentData(Student student) {
        students.add(student);
    }

    @Override
    public Book getBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}
