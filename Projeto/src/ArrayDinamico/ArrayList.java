package ArrayDinamico;

public class ArrayList<T> {
    private Object[] data;
    private int size;

    public ArrayList() {
        this.data = new Object[10];
        this.size = 0;
    }

    public void add(T value) {
        if (this.size == this.data.length) {
            resize();
        }

        this.data[size] = value;
        this.size++;
    }

    private void resize() {
        int newCapacity = this.data.length + (this.data.length / 2);

        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < this.data.length; i++) {
            newArray[i] = this.data[i];
        }

        this.data = newArray;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        return (T) this.data[index]; // casting
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.size--;
    }
}