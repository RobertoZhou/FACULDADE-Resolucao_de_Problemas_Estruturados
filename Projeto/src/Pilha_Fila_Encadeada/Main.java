package Pilha_Fila_Encadeada;

public class Main {
    public static void main(String[] args) {

        // PILHA
        Stack<String> pilha = new Stack<>();
        pilha.push("Mari");
        pilha.push("Rafa");
        pilha.push("Josi");

        System.out.println(pilha.pop()); // Josi

        // FILA
        Queue<String> fila = new Queue<>();
        fila.enqueue("Mari");
        fila.enqueue("Rafa");
        fila.enqueue("Josi");

        System.out.println(fila.dequeue()); // Mari
    }
}