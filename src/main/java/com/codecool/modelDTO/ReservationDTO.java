package com.codecool.modelDTO;


import com.codecool.model.AppUser;
import com.codecool.model.Item;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
public class ReservationDTO {
    private Long id;
    private Item item;
    private AppUser owner;
    private Date dateStart;
    private Date dateEnd;


    public static final class Builder {
        private Long id;
        private Item item;
        private AppUser owner;
        private Date dateStart;
        private Date dateEnd;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder item(Item item) {
            this.item = item;
            return this;
        }

        public Builder owner(AppUser owner) {
            this.owner = owner;
            return this;
        }

        public Builder dateStart(Date dateStart) {
            this.dateStart = dateStart;
            return this;
        }

        public Builder dateEnd(Date dateEnd) {
            this.dateEnd = dateEnd;
            return this;
        }

        public ReservationDTO build() {
            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.id = this.id;
            reservationDTO.item = this.item;
            reservationDTO.owner = this.owner;
            reservationDTO.dateStart = this.dateStart;
            reservationDTO.dateEnd = this.dateEnd;

            return reservationDTO;
        }
    }
}
