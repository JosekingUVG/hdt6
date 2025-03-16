package uvg;

import java.util.List;

class Pokemon {
    private String nombre;
    private int numeroPokedex;
    private String tipo1;
    private String tipo2;
    private String clasificacion;
    private double altura;
    private double peso;
    private List<String> habilidades;
    private int generacion;
    private boolean esLegendario;

    public Pokemon(String nombre, int numeroPokedex, String tipo1, String tipo2, String clasificacion,
                   double altura, double peso, List<String> habilidades, int generacion, boolean esLegendario) {
        this.nombre = nombre;
        this.numeroPokedex = numeroPokedex;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.clasificacion = clasificacion;
        this.altura = altura;
        this.peso = peso;
        this.habilidades = habilidades;
        this.generacion = generacion;
        this.esLegendario = esLegendario;
    }

    @Override
    public String toString() {
        return nombre + " (#" + numeroPokedex + ") - " + 
                "Tipo 1: "+ tipo1 + " Tipo 2: "+ (tipo2.isEmpty() ? "" : "/" + 
                tipo2) +", " + 
                "Clasificación: "+clasificacion + ", Altura: " + altura + 
                " m, Peso: " + peso + " kg, " +
               ", Habilidades: " + habilidades + 
               ", Gen: " + generacion + ", Legendario: " + esLegendario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo1() {
        return tipo1;
    }

    // Agregar este getter para habilidades
    public List<String> getHabilidades() {
        return habilidades;
    }
}


