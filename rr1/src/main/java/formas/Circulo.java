package formas;

public class Circulo implements Calculavel {
    private double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    @Override
    public double calculaArea(){
        return Math.PI * this.raio * this.raio;
    }
}
