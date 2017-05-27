package shop.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 1, max = 80)
    private String title;

    @NotNull
    @Size(min = 1, max = 80)
    private String code;

    @NotNull
    @Size(min = 1, max = 80)
    private double price;

    @Lob
    @NotNull
    @Size(min = 1)
    private byte[] image;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Size(min = 1, max = 40)
    private Date createDate;

    @NotNull
    @Size(min = 3, max = 50)
    private boolean active;

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

    public Product(String title, String code, double price, byte[] image, Date createDate, boolean active, Category category) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
