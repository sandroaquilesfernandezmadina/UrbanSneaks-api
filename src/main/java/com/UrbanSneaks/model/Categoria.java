package com.UrbanSneaks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "categoria"
)
@SQLDelete(
        sql = "UPDATE categoria SET estado = false WHERE id_categoria = ?"
)
@SQLRestriction("estado = true")

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCatategoria;
    @Column(name = "nombre")
    private  String nomCategoria;
    @Column(name = "estado")
    private Boolean estadoCategiria;

}
