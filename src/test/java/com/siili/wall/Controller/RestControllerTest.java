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
        restControllerUnderTest.irepository = mock(ItemRepository.class);
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
        when(restControllerUnderTest.crepository.findAll()).thenReturn(Arrays.asList(new Column(0L, "name", 0)));

        // Run the test
        final List<Column> result = restControllerUnderTest.columnListRest();

        // Verify the results
    }

    @Test
    public void testFindColumnRest() {
        // Setup
        when(restControllerUnderTest.crepository.findById(0L)).thenReturn(Optional.of(new Column(0L, "name", 0)));

        // Run the test
        final Optional<Column> result = restControllerUnderTest.findColumnRest(0L);

        // Verify the results
    }

    @Test
    public void testCardListRest() {
        // Setup

        // Configure ItemRepository.findAll(...).
        final Iterable<Item> cards = Arrays.asList(new Item("id", "cardName", "content", "cardColor", "cardOwner", 0, 0));
        when(restControllerUnderTest.irepository.findAll()).thenReturn(cards);

        // Run the test
        final List<Item> result = restControllerUnderTest.cardListRest();

        // Verify the results
    }

    @Test
    public void testFindCardRest() {
        // Setup

        // Configure ItemRepository.findById(...).
        final Optional<Item> card = Optional.of(new Item("id", "cardName", "content", "cardColor", "cardOwner", 0, 0));
        when(restControllerUnderTest.irepository.findById("id")).thenReturn(card);

        // Run the test
        final Optional<Item> result = restControllerUnderTest.findCardRest("id");

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
        final Column column = new Column(0L, "name", 0);
        when(restControllerUnderTest.crepository.save(any(Column.class))).thenReturn(new Column(0L, "name", 0));

        // Run the test
        final Column result = restControllerUnderTest.addNewColumn(column);

        // Verify the results
    }

    @Test
    public void testAddNewCard() {
        // Setup
        final Item item = new Item("id", "cardName", "content", "cardColor", "cardOwner", 0, 0);

        // Configure ItemRepository.save(...).
        final Item item1 = new Item("id", "cardName", "content", "cardColor", "cardOwner", 0, 0);
        when(restControllerUnderTest.irepository.save(any(Item.class))).thenReturn(item1);

        // Run the test
        final Item result = restControllerUnderTest.addNewCard(item);

        // Verify the results
    }

    @Test
    public void testBoardsAddColumn() {
        // Setup
        final Column column = new Column(0L, "name", 0);
        when(restControllerUnderTest.brepository.findById(0L)).thenReturn(Optional.of(new Board("boardName")));
        when(restControllerUnderTest.brepository.save(any(Board.class))).thenReturn(new Board("boardName"));
        when(restControllerUnderTest.crepository.findAll()).thenReturn(Arrays.asList(new Column(0L, "name", 0)));

        // Run the test
        final Iterable<Column> result = restControllerUnderTest.boardsAddColumn(0L, column);

        // Verify the results
    }

    @Test
    public void testColumnsAddCard() {
        // Setup
        final Item item = new Item("id", "cardName", "content", "cardColor", "cardOwner", 0, 0);
        when(restControllerUnderTest.crepository.findById(0L)).thenReturn(Optional.of(new Column(0L, "name", 0)));
        when(restControllerUnderTest.crepository.save(any(Column.class))).thenReturn(new Column(0L, "name", 0));

        // Configure ItemRepository.findAll(...).
        final Iterable<Item> cards = Arrays.asList(new Item("id", "cardName", "content", "cardColor", "cardOwner", 0, 0));
        when(restControllerUnderTest.irepository.findAll()).thenReturn(cards);

        // Run the test
        final Iterable<Item> result = restControllerUnderTest.columnsAddCard(0L, item);

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
        when(restControllerUnderTest.crepository.findById(0L)).thenReturn(Optional.of(new Column(0L, "name", 0)));
        when(restControllerUnderTest.brepository.findById(0L)).thenReturn(Optional.of(new Board("boardName")));
        when(restControllerUnderTest.brepository.save(any(Board.class))).thenReturn(new Board("boardName"));
        when(restControllerUnderTest.brepository.findAll()).thenReturn(Arrays.asList(new Board("boardName")));

        // Run the test
        final Iterable<Board> result = restControllerUnderTest.deleteboardcolumn(0L, 0L);

        // Verify the results
        verify(restControllerUnderTest.crepository).deleteById(0L);
    }

    @Test
    public void testDeletecolumncard() {
        // Setup

        // Configure ItemRepository.findById(...).
        final Optional<Item> card = Optional.of(new Item("id", "cardName", "content", "cardColor", "cardOwner", 0, 0));
        when(restControllerUnderTest.irepository.findById("id")).thenReturn(card);

        when(restControllerUnderTest.crepository.findById(0L)).thenReturn(Optional.of(new Column(0L, "name", 0)));
        when(restControllerUnderTest.crepository.save(any(Column.class))).thenReturn(new Column(0L, "name", 0));
        when(restControllerUnderTest.crepository.findAll()).thenReturn(Arrays.asList(new Column(0L, "name", 0)));

        // Run the test
        final Iterable<Column> result = restControllerUnderTest.deletecolumncard(0L, "id");

        // Verify the results
        verify(restControllerUnderTest.irepository).deleteById("id");
    }

    @Test
    public void testEditboard() {
        // Setup
        final Board board = new Board("boardName");
        when(restControllerUnderTest.brepository.findById(0L)).thenReturn(Optional.of(new Board("boardName")));
        when(restControllerUnderTest.brepository.save(any(Board.class))).thenReturn(new Board("boardName"));
        when(restControllerUnderTest.brepository.findAll()).thenReturn(Arrays.asList(new Board("boardName")));

        // Run the test
        final Iterable<Board> result = restControllerUnderTest.editboard(0L, board);

        // Verify the results
    }

    @Test
    public void testEditcolumn() {
        // Setup
        final Column column = new Column(0L, "name", 0);
        when(restControllerUnderTest.crepository.findById(0L)).thenReturn(Optional.of(new Column(0L, "name", 0)));
        when(restControllerUnderTest.crepository.save(any(Column.class))).thenReturn(new Column(0L, "name", 0));
        when(restControllerUnderTest.crepository.findAll()).thenReturn(Arrays.asList(new Column(0L, "name", 0)));

        // Run the test
        final Iterable<Column> result = restControllerUnderTest.editcolumn(0L, column);

        // Verify the results
    }

    @Test
    public void testRemovecard() {
        // Setup

        // Configure ItemRepository.findById(...).
        final Optional<Item> card = Optional.of(new Item("id", "cardName", "content", "cardColor", "cardOwner", 0, 0));
        when(restControllerUnderTest.irepository.findById("id")).thenReturn(card);

        when(restControllerUnderTest.crepository.findById(0L)).thenReturn(Optional.of(new Column(0L, "name", 0)));
        when(restControllerUnderTest.crepository.save(any(Column.class))).thenReturn(new Column(0L, "name", 0));
        when(restControllerUnderTest.crepository.findAll()).thenReturn(Arrays.asList(new Column(0L, "name", 0)));

        // Run the test
        final Iterable<Column> result = restControllerUnderTest.removecard(0L, 0L, "id", 0);

        // Verify the results
        verify(restControllerUnderTest.irepository).deleteById("id");
    }
}
