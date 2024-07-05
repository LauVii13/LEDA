package formas;

public class Retangulo implements Calculavel {
    
    private double base;
    private double altura;

    public Retangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculaArea(){
        return this.base * this.altura;
    }
}
