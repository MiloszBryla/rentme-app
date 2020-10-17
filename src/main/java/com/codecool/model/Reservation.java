package com.codecool.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name="reservations")
public class Reservation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name= "id")
    private Long id;
    @OneToOne (cascade=CascadeType.MERGE)
    @JoinColumn(name= "item_id")
    private Item item;
    @OneToOne (cascade=CascadeType.MERGE)
    @JoinColumn(name= "renter_id")
    private AppUser owner;
    @Column(name= "date_start")
    private Date dateStart;
    @Column(name= "date_end")
    private Date dateEnd;

    public Reservation() {
    }


}
