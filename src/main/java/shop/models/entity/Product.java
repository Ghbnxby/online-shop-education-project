package shop.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String code;

    @NotNull
   private Integer price;

    @Lob
    @NotNull
    private byte[] image;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @NotNull
    private String active;

    @ManyToOne(fetch = FetchType.LAZY,optional = true,
            cascade = CascadeType.ALL)
    @JoinTable(name = "product2category",
    joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_category"))
    private Category category;

    public Product() {    }

    public Product(long id) {this.id = id;}

    public Product(String title) {
        this.title = title;
    }

    public Product(String title, String code, Integer price, byte[] image, Date createDate, String active, Category category) {
        this.title = title;
        this.code = code;
        this.price = price;
        this.image = image;
        this.createDate = createDate;
        this.active = active;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(String pr) {

        this.price = Integer.valueOf(pr);
    }

    public String getImage() {
        String img = new String(image);
        return img;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//задаю формат даты

        try {
            this.createDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        this.createDate = createDate;

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
