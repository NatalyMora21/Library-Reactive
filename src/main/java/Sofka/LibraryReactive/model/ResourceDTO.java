package Sofka.LibraryReactive.model;

import Sofka.LibraryReactive.collections.values.Thematic;
import Sofka.LibraryReactive.collections.values.Type;

import java.time.LocalDate;

public class ResourceDTO {
    private String id;
    private String title;
    private Type type;
    private Thematic thematic;
    private Integer stock;
    private Integer lending;
    private LocalDate date;

    public ResourceDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Thematic getThematic() {
        return thematic;
    }

    public void setThematic(Thematic thematic) {
        this.thematic = thematic;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLending() {
        return lending;
    }

    public void setLending(Integer lending) {
        this.lending = lending;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
