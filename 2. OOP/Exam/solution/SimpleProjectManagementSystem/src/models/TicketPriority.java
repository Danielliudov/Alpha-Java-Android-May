package models;

public enum TicketPriority {
    HIGH, LOW;

    public static TicketPriority fromName(String name) {
        return TicketPriority.valueOf(name);
    }
}
