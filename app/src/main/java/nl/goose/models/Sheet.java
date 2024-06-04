package nl.goose.models;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class Sheet {
    @Getter @Setter private String name;
    private Map<Position, Cell> cells = new HashMap<>();

    public void addCell(Position position, Cell cell) {
        if(cells.containsKey(position)) return;
        this.cells.put(position, cell);
        cell.setSheet(this);
    }

    public Cell getCell(Position position) {
        return this.cells.get(position);
    }


}

