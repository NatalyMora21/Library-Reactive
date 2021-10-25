package Sofka.LibraryReactive.model;

import java.time.LocalDate;

public class AvalibleResourceDto {

    private String title;
    private String message;
    private LocalDate date;

    public AvalibleResourceDto() {
    }

    public AvalibleResourceDto(String title, String message, LocalDate date) {
        this.title = title;
        this.message = message;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
