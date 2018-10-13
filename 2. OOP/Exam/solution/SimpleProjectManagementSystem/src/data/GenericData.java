package data;

import data.base.Data;
import models.base.IHaveId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenericData<T extends IHaveId> implements Data<T> {

    private static List<Object> values;

    static {
        values = new ArrayList<>();
    }

    @Override
    public void add(T ticket) {
        values.add(ticket);
    }

    @Override
    public List<T> getAll() {
        return values.stream()
            .map(x -> (T) x)
            .collect(Collectors.toList());
    }

    @Override
    public T getById(int id) {
        return values.stream()
            .map(x -> (T) x)
            .filter(x -> x.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
