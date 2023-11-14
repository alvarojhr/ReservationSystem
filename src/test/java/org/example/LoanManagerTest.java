package org.example;

import dao.ConferenceRoomDao;
import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanManagerTest {

    @InjectMocks
    private LoanManager loanManager;

    @Mock
    private ConferenceRoomDao conferenceRoomDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBook() {
        // Arrange
        Book book = new Book("1", "cuento 1", "carlitos");

        // Act
        loanManager.addBook(book);

        List<Book> addedBooks = loanManager.getAddedBooks();
        assertEquals(1, addedBooks.size());
        assertEquals(book, addedBooks.get(0));

        verifyZeroInteractions(conferenceRoomDao);
    }
