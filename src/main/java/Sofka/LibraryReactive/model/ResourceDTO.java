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
    private Boolean state;

    public ResourceDTO() {
    }



    public ResourceDTO(String id, String title, Type type, Thematic thematic, Integer stock, Integer lending, LocalDate date,Boolean estado) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.thematic = thematic;
        this.stock = stock;
        this.lending = lending;
        this.date = date;
        this.state= estado;
    }

    public ResourceDTO(String title, Type type, Thematic thematic, Integer stock) {
        this.title = title;
        this.type = type;
        this.thematic = thematic;
        this.stock = stock;
        this.lending = 0;
        this.state= false;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
