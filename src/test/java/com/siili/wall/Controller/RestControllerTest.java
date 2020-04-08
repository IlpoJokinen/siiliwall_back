package com.siili.wall.Controller;

import com.siili.wall.Domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RestControllerTest {

    private RestController restControllerUnderTest;

    @Before
    public void setUp() {
        restControllerUnderTest = new RestController();
        restControllerUnderTest.brepository = mock(BoardRepository.class);
        restControllerUnderTest.crepository = mock(ColumnRepository.class);
        restControllerUnderTest.ccrepository = mock(CardRepository.class);
    }

    @Test
    public void testBoardListRest() {
        // Setup
        when(restControllerUnderTest.brepository.findAll()).thenReturn(Arrays.asList(new Board("boardName")));

        // Run the test
        final List<Board> result = restControllerUnderTest.boardListRest();

        // Verify the results
    }

    @Test
    public void testFindBoardRest() {
        // Setup
        when(restControllerUnderTest.brepository.findById(0L)).thenReturn(Optional.of(new Board("boardName")));

        // Run the test
        final Optional<Board> result = restControllerUnderTest.findBoardRest(0L);

        // Verify the results
    }

    @Test
    public void testColumnListRest() {
        // Setup
        //when(restControllerUnderTest.crepository.findAll()).thenReturn(Arrays.asList(new Column("name", 0)));

        // Run the test
        final List<Column> result = restControllerUnderTest.columnListRest();

        // Verify the results
    }

    @Test
    public void testFindColumnRest() {
        // Setup
        //when(restControllerUnderTest.crepository.findById(0L)).thenReturn(Optional.of(new Column("name", 0)));

        // Run the test
        final Optional<Column> result = restControllerUnderTest.findColumnRest(0L);

        // Verify the results
    }

    @Test
    public void testCardListRest() {
        // Setup

        // Configure CardRepository.findAll(...).
        final Iterable<Card> cards = Arrays.asList(new Card("id", "cardName", "content", "cardColor", "cardOwner", 0, 0));
        when(restControllerUnderTest.ccrepository.findAll()).thenReturn(cards);

        // Run the test
        final List<Card> result = restControllerUnderTest.cardListRest();

        // Verify the results
    }

    @Test
    public void testFindCardRest() {
        // Setup

        // Configure CardRepository.findById(...).
        final Optional<Card> card = Optional.of(new Card("id", "cardName", "content", "cardColor", "cardOwner", 0, 0));
        when(restControllerUnderTest.ccrepository.findById("id")).thenReturn(card);

        // Run the test
        final Optional<Card> result = restControllerUnderTest.findCardRest("id");

        // Verify the results
    }

    @Test
    public void testAddNewBoard() {
        // Setup
        final Board board = new Board("boardName");
        when(restControllerUnderTest.brepository.save(any(Board.class))).thenReturn(new Board("boardName"));

        // Run the test
        final Board result = restControllerUnderTest.addNewBoard(board);

        // Verify the results
    }

    @Test
    public void testAddNewColumn() {
        // Setup
        //final Column column = new Column("name", 0);
        //when(restControllerUnderTest.crepository.save(any(Column.class))).thenReturn(new Column("name", 0));

        // Run the test
        //final Column result = restControllerUnderTest.addNewColumn(column);

        // Verify the results
    }

    @Test
    public void testAddNewCard() {
        // Setup
        final Card card = new Card("id", "cardName", "content", "cardColor", "cardOwner", 0, 0);

        // Configure CardRepository.save(...).
        final Card card1 = new Card("id", "cardName", "content", "cardColor", "cardOwner", 0, 0);
        when(restControllerUnderTest.ccrepository.save(any(Card.class))).thenReturn(card1);

        // Run the test
        final Card result = restControllerUnderTest.addNewCard(card);

        // Verify the results
    }

    @Test
    public void testBoardsAddColumn() {
        // Setup
        //final Column column = new Column("name", 0);
        when(restControllerUnderTest.brepository.findById(0L)).thenReturn(Optional.of(new Board("boardName")));
        when(restControllerUnderTest.brepository.save(any(Board.class))).thenReturn(new Board("boardName"));
        //when(restControllerUnderTest.crepository.findAll()).thenReturn(Arrays.asList(new Column("name", 0)));

        // Run the test
        //final Iterable<Column> result = restControllerUnderTest.boardsAddColumn(0L, column);

        // Verify the results
    }

    @Test
    public void testColumnsAddCard() {
        // Setup
        final Card card = new Card("id", "cardName", "content", "cardColor", "cardOwner", 0, 0);
        //when(restControllerUnderTest.crepository.findById(0L)).thenReturn(Optional.of(new Column("name", 0)));
        //when(restControllerUnderTest.crepository.save(any(Column.class))).thenReturn(new Column("name", 0));

        // Configure CardRepository.findAll(...).
        final Iterable<Card> cards = Arrays.asList(new Card("id", "cardName", "content", "cardColor", "cardOwner", 0, 0));
        when(restControllerUnderTest.ccrepository.findAll()).thenReturn(cards);

        // Run the test
        final Iterable<Card> result = restControllerUnderTest.columnsAddCard(0L, card);

        // Verify the results
    }

    @Test
    public void testDeleteboard() {
        // Setup
        when(restControllerUnderTest.brepository.findAll()).thenReturn(Arrays.asList(new Board("boardName")));

        // Run the test
        final Iterable<Board> result = restControllerUnderTest.deleteboard(0L);

        // Verify the results
        verify(restControllerUnderTest.brepository).deleteById(0L);
    }

    @Test
    public void testDeleteboardcolumn() {
        // Setup
        //when(restControllerUnderTest.crepository.findById(0L)).thenReturn(Optional.of(new Column("name", 0)));
        when(restControllerUnderTest.brepository.findById(0L)).thenReturn(Optional.of(new Board("boardName")));
        when(restControllerUnderTest.brepository.save(any(Board.class))).thenReturn(new Board("boardName"));
        when(restControllerUnderTest.brepository.findAll()).thenReturn(Arrays.asList(new Board("boardName")));

        // Run the test
        final Iterable<Board> result = restControllerUnderTest.deleteboardcolumn(0L, 0L);

        // Verify the results
        verify(restControllerUnderTest.crepository).deleteById(0L);
    }
}
