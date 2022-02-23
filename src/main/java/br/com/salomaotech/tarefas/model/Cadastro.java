package br.com.salomaotech.tarefas.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cadastro")
public class Cadastro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String descricao;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
