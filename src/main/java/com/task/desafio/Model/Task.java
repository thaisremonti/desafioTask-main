package com.task.desafio.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "status")
    private String status;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "data_removido")
    private LocalDateTime dataRemovido;

    @Column(name = "concluido")
    private Character concluido;

    @Column(name = "excluido")
    private Character excluido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public LocalDateTime getDataRemovido() {
        return dataRemovido;
    }

    public void setDataRemovido(LocalDateTime dataRemovido) {
        this.dataRemovido = dataRemovido;
    }

    public Character getConcluido() {
        return concluido;
    }

    public void setConcluido(Character concluido) {
        this.concluido = concluido;
    }

    public Character getExcluido() {
        return excluido;
    }

    public void setExcluido(Character excluido) {
        this.excluido = excluido;
    }

}
