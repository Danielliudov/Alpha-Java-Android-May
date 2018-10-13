package models.base;

public class Item implements IHaveId {
    private static int lastId = 0;
    private int id;
    private String title;
    private String description;

    public Item(String title, String description) {
        this.id = lastId += 1;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}