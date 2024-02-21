package br.com.erudio.data.vo.v1;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;


public class BooksVO extends RepresentationModel<BooksVO> implements Serializable {
    

    private Long id;
    private String author;
    private Date launch_date;
    private int price;
    private String title;

    public BooksVO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunch_date() {
        return this.launch_date;
    }

    public void setLaunch_date(Date launch_date) {
        this.launch_date = launch_date;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
