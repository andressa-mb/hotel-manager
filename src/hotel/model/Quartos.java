package hotel.model;

public class Quartos {

    private static int idCounter = 1;
    private int id;
    private int numero;
    private String tipo;
    private boolean disponivel;
    private double valor_diaria;
    private String comodidades;

    public Quartos(int numero, String tipo, boolean disponivel, double valor_diaria, String comodidades) {
        this.id = idCounter++;
        this.numero = numero;
        this.tipo = tipo;
        this.disponivel = disponivel;
        this.valor_diaria = valor_diaria;
        this.comodidades = comodidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getValor_diaria() {
        return valor_diaria;
    }

    public void setValor_diaria(double valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    public String getComodidades() {
        return comodidades;
    }

    public void setComodidades(String comodidades) {
        this.comodidades = comodidades;
    }
}
