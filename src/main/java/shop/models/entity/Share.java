package shop.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="Share")
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @NotNull
    @Temporal(TemporalType.DATE)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//задаю формат даты

        try {
            this.startDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//задаю формат даты

        try {
            this.endDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
