package fr.simplon.domedespuys.entity;


import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.AddressView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(AddressView.Id.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(AddressView.Line.class)
    private String line;

    @Column
    @JsonView(AddressView.ExtraLine.class)
    private String extraLine;

    @Column(nullable = false)
    @JsonView(AddressView.City.class)
    private String city;

    @Column(nullable = false)
    @JsonView(AddressView.ZipCode.class)
    private String zipCode;

    @Column(nullable = false)
    @JsonView(AddressView.Country.class)
    private String country;

    @Column(length = 20)
    @JsonView(AddressView.Phone.class)
    private String phone;

    @Column(nullable = false, length = 80)
    @JsonView(AddressView.FirstName.class)
    private String firstName;

    @Column(nullable = false, length = 80)
    @JsonView(AddressView.LastName.class)
    private String lastName;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;

}
