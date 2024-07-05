package formas;
import java.util.Scanner;

public class TesteFormas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        
        do{
            System.out.println("Escolha a opção:\n1 - Triangulo\n2 - Retangulo\n3 - Quadrado\n4 - Circulo");
            option = sc.nextInt();
        }while(option < 1 || option > 4);
        
        Calculavel forma;
        switch (option){
            case 1:
                forma = new Triangulo(sc.nextDouble(), sc.nextDouble());
                break;
            case 2:
                forma = new Retangulo(sc.nextDouble(), sc.nextDouble());
                break;
            case 3:
                forma = new Quadrado(sc.nextDouble());
                break;
            case 4:
                forma = new Circulo(sc.nextDouble());
                break;            
            default:
                forma = new Circulo(0);
                break;
        }
        System.out.println(forma.calculaArea());
    }
}
