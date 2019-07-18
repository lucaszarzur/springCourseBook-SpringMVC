package br.com.springMvcLivro.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Price {

    @Column(scale = 2)
    private BigDecimal value;
    private BookType bookType;

    public enum BookType {
        EBOOK,PRINTED,COMBO
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
