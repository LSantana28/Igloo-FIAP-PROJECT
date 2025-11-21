package br.com.fiap.model;

public class Credito {
    private int idUsuario;
    private double saldo;

    public Credito(int idUsuario) {
        this.idUsuario = idUsuario;
        this.saldo = 0.0;
    }

    public void adicionarCredito(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Créditos adicionados: " + valor);
        } else {
            System.out.println("Valor inválido para adição de créditos.");
        }
    }
    // Método para subtrair créditos
    public void subtrairCredito(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Créditos subtraídos: " + valor);
        } else {
            System.out.println("Valor inválido para subtração ou saldo insuficiente.");
        }
    }

    // Método para exibir o saldo atual de créditos
    public void exibirSaldo() {
        System.out.println("Saldo de créditos: " + this.saldo);
    }

    // Método para verificar se o saldo é suficiente
    public boolean verificarSaldoSuficiente(double valor) {
        return this.saldo >= valor;
    }

    //getters e setters

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
