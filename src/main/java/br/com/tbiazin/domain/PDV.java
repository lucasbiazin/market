package br.com.tbiazin.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PDV")
public class PDV {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pdv_seq")
    @SequenceGenerator(name = "pdv_seq", sequenceName = "sq_pdv", initialValue = 1, allocationSize = 1)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    public PDV() {}

    public PDV(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
