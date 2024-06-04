package nl.goose.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

    @Test
    public void shoudsetStaticValue() {
        var cell = new Cell();
        cell.setFormula("1");
        assertEquals("1", cell.getValue());
    }

    @Test
    public void shouldGetReferredValue() {
        var sheet = new Sheet();
        var positionOfFirstCell = new Position("A", 1);
        var positionOfSecondCell = new Position("B", 2);
        var firstCell = new Cell();
        var secondCell = new Cell();

        sheet.addCell(positionOfFirstCell, firstCell);
        sheet.addCell(positionOfSecondCell, secondCell);
        firstCell.setFormula("1");
        secondCell.setFormula("=A1");

        assertEquals("1", secondCell.getValue());
    }

    @Test
    public void shouldUpdateWhenReferenceChange() {
        var sheet = new Sheet();
        var positionOfFirstCell = new Position("A", 1);
        var positionOfSecondCell = new Position("B", 2);
        var firstCell = new Cell();
        var secondCell = new Cell();

        sheet.addCell(positionOfFirstCell, firstCell);
        sheet.addCell(positionOfSecondCell, secondCell);
        firstCell.setFormula("1");
        secondCell.setFormula("=A1");
        firstCell.setFormula("2");

        assertEquals("2", secondCell.getValue());
    }

    @Test
    public void shouldUpdateRefererenceOfReference() {
        var sheet = new Sheet();
        var positionOfFirstCell = new Position("A", 1);
        var positionOfSecondCell = new Position("B", 2);
        var positionOfThirdCell = new Position("C", 3);
        var firstCell = new Cell();
        var secondCell = new Cell();
        var thirdCell = new Cell();

        sheet.addCell(positionOfFirstCell, firstCell);
        sheet.addCell(positionOfSecondCell, secondCell);
        sheet.addCell(positionOfThirdCell, thirdCell);
        firstCell.setFormula("1");
        secondCell.setFormula("=A1");
        thirdCell.setFormula("=B2");
        firstCell.setFormula("2");

        assertEquals("2", thirdCell.getValue());
    }

}
