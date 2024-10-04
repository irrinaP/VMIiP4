package org.example;

import lombok.Data;
import java.util.List;

@Data
class Visitor {
    private String name;
    private String surname;
    private String phone;
    private boolean subscribed;
    private List<Book> favoriteBooks;
}