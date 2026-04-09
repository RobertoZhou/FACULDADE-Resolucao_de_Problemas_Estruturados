package Pilha_Fila_Encadeada;

class Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    // Enfileirar
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }

        last = newNode;
        size++;
    }

    // Desenfileirar
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return null;
        }

        T value = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }

        size--;
        return value;
    }

    // Ver início
    public T front() {
        if (isEmpty()) return null;
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }
}