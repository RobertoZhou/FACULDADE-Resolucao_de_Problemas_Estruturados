package ArrayDinamico;

public class Main {

    public static void main(String[] args) {

        ArrayList lista = new ArrayList();

        lista.add(10);
        lista.add(20);
        lista.add(30);

        System.out.println(lista.get(1)); // 20

        lista.remove(1);

        System.out.println(lista.get(1)); // 30

    }
}