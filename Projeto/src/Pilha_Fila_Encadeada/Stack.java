package Pilha_Fila_Encadeada;

class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    // Empilhar
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = this.top;
        this.top = newNode;
        this.size++;
    }

    // Desempilhar
    public T pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        T value = this.top.data;
        this.top = this.top.next;
        this.size--;
        return value;
    }

    // Ver topo
    public T peek() {
        if (isEmpty()) return null;
        return this.top.data;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int size() {
        return this.size;
    }
}