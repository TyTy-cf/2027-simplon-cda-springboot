package fr.simplon.domedespuys.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String path;

    @Column(nullable = false, length = 180)
    private String extension;

    @Column(nullable = false)
    private boolean isDefault = false;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Product product;

}
