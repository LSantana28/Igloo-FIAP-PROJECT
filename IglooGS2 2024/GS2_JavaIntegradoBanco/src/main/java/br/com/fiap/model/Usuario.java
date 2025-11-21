package br.com.fiap.model;

public class Usuario {
    private int id;
    private String nome;
    private String endereco;
    private double consumoMensal;
    private double producaoMensal;
    private Integer microredeId;

    //Construtores

    public Usuario(String nome, String endereco, double consumoMensal, double producaoMensal, Integer microredeId) {
        this.nome = nome;
        this.endereco = endereco;
        this.consumoMensal = consumoMensal;
        this.producaoMensal = producaoMensal;
        this.microredeId = microredeId;
    }
    public Usuario(int id, String nome, String endereco, int consumoMensal, int producaoMensal) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.consumoMensal = consumoMensal;
        this.producaoMensal = producaoMensal;
    }

    public Usuario(String nome, String endereco, int consumoMensal, int producaoMensal) {
        this.nome = nome;
        this.endereco = endereco;
        this.consumoMensal = consumoMensal;
        this.producaoMensal = producaoMensal;
    }

    public Usuario(int id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }


    //Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getConsumoMensal() {
        return consumoMensal;
    }

    public void setConsumoMensal(double consumoMensal) {
        this.consumoMensal = consumoMensal;
    }

    public double getProducaoMensal() {
        return producaoMensal;
    }

    public void setProducaoMensal(double producaoMensal) {
        this.producaoMensal = producaoMensal;
    }

    public Integer getMicroredeId() {
        return microredeId;
    }

    public void setMicroredeId(Integer microredeId) {
        this.microredeId = microredeId;
    }
}
