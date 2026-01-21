package com.UrbanSneaks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "color"
)
@SQLDelete(
        sql = "UPDATE categoria SET estado = false WHERE id_color = ?"
)
@SQLRestriction("estado = true")

public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_color")
    private Integer idColor;
    @Column(name = "nombre")
    private String NomColor;
    @Column(name = "estado")
    private Boolean estadoColor;

}
