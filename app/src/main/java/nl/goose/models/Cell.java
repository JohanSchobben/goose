package nl.goose.models;


import java.util.Set;
import java.util.HashSet;

import lombok.Getter;
import lombok.Setter;

public class Cell {
    private Set<Cell> references = new HashSet<>();
    @Getter private String formula;
    @Getter private String value;
    @Getter @Setter private Sheet sheet;

    public void setFormula(String value) {
        this.formula = value;
        this.calculate();
    }

    private void register(Cell cell) {
        references.add(cell);
    }

    
    private void calculate() {
        if(formula.startsWith("=")) {
           var cell = sheet.getCell(new Position(String.valueOf(formula.charAt(1)), formula.charAt(2) - '0'));
           cell.register(this);
           value = cell.getValue();
        } else {
            value = formula;
        }

        for (var ref : references) {
            ref.calculate();
        }
    }
}
