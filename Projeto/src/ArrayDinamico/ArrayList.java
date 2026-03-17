package ArrayDinamico;

public class ArrayList {
    private int[] data;
    private int capacity;

    public ArrayList() {
        this.data = new int[10]; // Capacidade Inicial
        this.capacity = 0; // Capacidade sendo usada no Array
    }

    public void add(int value) {
        if(this.capacity == this.data.length) {
            resize();
        }

        this.data[capacity] = value;
        this.capacity++;
    }

    private void resize() {
        int newCapacity = this.data.length + (this.data.length / 2);

        int[] newArray = new int[newCapacity];

        for (int i = 0; i < this.data.length; i++) {
            newArray[i] = this.data[i];
        }

        this.data = newArray;
    }

    public int get(int index) {

        if (index < 0 || index >= this.capacity) {
            throw new IndexOutOfBoundsException();
        }
        return this.data[index];
    }

    public void remove(int index) {

        if(index < 0 || index >= this.capacity) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < this.capacity - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.capacity--;
    }
}