package shop.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="Share")
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String title;

    @NotNull
    @Size(min = 3, max = 500)
    private String description;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Size(min = 1, max = 40)
    private Date startDate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Size(min = 1, max = 40)
    private Date endDate;

    public Share() {}

    public Share(long id) { this.id = id; }

    public Share(String title) {
        this.title = title;
    }

    public Share(String title, String description, Date startDate, Date endDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
