package sungwook.sungwook;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private int id;
    private String name;
    private String author;
    private int price;
}
