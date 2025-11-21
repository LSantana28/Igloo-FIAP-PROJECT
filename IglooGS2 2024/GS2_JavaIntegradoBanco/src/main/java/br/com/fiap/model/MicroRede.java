package br.com.fiap.model;

import java.util.List;

public class MicroRede {

    private int id;
    private String nome;
    private double totalProduzido;
    private double totalConsumido;
    private double energiaArmazenada;
    private List<Usuario> usuarios;

    public MicroRede(int id, String nome, double totalProduzido, double totalConsumido, double energiaArmazenada){
        this.id = id;
        this.nome = nome;
        this.totalProduzido = totalProduzido;
        this.totalConsumido = totalConsumido;
        this.energiaArmazenada = energiaArmazenada;
    }

    public MicroRede(){}

    public MicroRede(String nome, double totalProduzido, double totalConsumido, double energiaArmazenada){
        this.nome = nome;
        this.totalProduzido = totalProduzido;
        this.totalConsumido = totalConsumido;
        this.energiaArmazenada = energiaArmazenada;
    }

    // Getters e Setters
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

    public double getTotalProduzido() {
        return totalProduzido;
    }

    public void setTotalProduzido(double totalProduzido) {
        this.totalProduzido = totalProduzido;
    }

    public double getTotalConsumido() {
        return totalConsumido;
    }

    public void setTotalConsumido(double totalConsumido) {
        this.totalConsumido = totalConsumido;
    }

    public double getEnergiaArmazenada() {
        return energiaArmazenada;
    }

    public void setEnergiaArmazenada(double energiaArmazenada) {
        this.energiaArmazenada = energiaArmazenada;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Microrede" +
                "\nID da rede = " + id +
                "\nNome da rede='" + nome +
                "\nTotal Produzido=" + totalProduzido +
                "\nTotal Consumido=" + totalConsumido +
                "\nEnergia Armazenada=" + energiaArmazenada;
    }
}
