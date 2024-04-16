package br.unipar.programacaointernet.servicecep.bibliotecaapi.model;

import com.sun.jdi.PrimitiveValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Livro {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60)
    private String titulo;

    @Column(length = 120)
    private String autor;

    @Column(length = 100)
    private String arquivo_pdf;

    @Column(length = 10)
    private String classificacao_etaria;

    @ManyToOne
    @JoinColumn(name = "estante_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_estante"))
    private Estante estante;
}
