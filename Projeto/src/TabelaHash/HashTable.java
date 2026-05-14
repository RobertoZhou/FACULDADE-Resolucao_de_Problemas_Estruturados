package TabelaHash;

import java.util.Arrays;
import java.util.NoSuchElementException;

// Implementação de tabela hash utilizando:
// - fator de carga de 75%
// - função hash baseada em ASCII
// - sondagem linear circular
// - null para posições nunca utilizadas
// - "<deleted>" para posições removidas

public class HashTable {

    private int tableSize;      // tamanho do array
    private int threshold;      // limite antes do resize
    private int keysAdded;      // quantidade de elementos inseridos

    private String[] keys;

    // marcador de remoção
    private static final String DELETED = "<deleted>";

    // construtor padrão
    public HashTable() {
        this(6);
    }

    // construtor com tamanho personalizado
    public HashTable(int size) {
        this.tableSize = size;
        this.threshold = (int) (size * 0.75f);
        this.keysAdded = 0;

        keys = new String[size];
    }

    // função hash
    private int hash(String key) {

        int value = 0;

        for (int i = 0; i < key.length(); i++) {
            value = (value * 31) + getAscii(key.charAt(i));
        }

        return Math.abs(value % tableSize);
    }

    // retorna valor ASCII do caractere
    private int getAscii(char c) {
        return (int) c;
    }

    // insere elemento
    public void insert(String key) {

        // impede inserção duplicada
        if (contains(key)) {
            return;
        }

        // verifica necessidade de resize
        if (keysAdded >= threshold) {
            resize();
        }

        insertWithoutResize(key);
    }

    // inserção sem resize
    private void insertWithoutResize(String key) {

        int value = hash(key);

        for (int i = 0; i < tableSize; i++) {

            int index = (value + i) % tableSize;

            // posição livre
            if (keys[index] == null || keys[index].equals(DELETED)) {

                keys[index] = key;
                keysAdded++;

                return;
            }
        }
    }

    // redimensiona tabela
    private void resize() {

        // guarda tabela antiga
        String[] oldHashTable = keys;

        // dobra tamanho
        tableSize *= 2;

        // recalcula limite
        threshold = (int) (tableSize * 0.75f);

        // cria nova tabela
        keys = new String[tableSize];

        // reseta quantidade
        keysAdded = 0;

        // rehashing
        for (String key : oldHashTable) {

            if (key != null && !key.equals(DELETED)) {
                insertWithoutResize(key);
            }
        }
    }

    // verifica se contém chave
    public boolean contains(String key) {
        return findIndex(key) != -1;
    }

    // remove chave
    public String remove(String key) {

        int index = findIndex(key);

        if (index == -1) {
            throw new NoSuchElementException("Elemento não encontrado!");
        }

        String removedKey = keys[index];

        // marca como removido
        keys[index] = DELETED;

        keysAdded--;

        return removedKey;
    }

    // encontra índice da chave
    private int findIndex(String key) {

        int value = hash(key);

        for (int i = 0; i < tableSize; i++) {

            int index = (value + i) % tableSize;

            // posição nunca usada
            if (keys[index] == null) {
                return -1;
            }

            // encontrou a chave
            if (keys[index].equals(key)) {
                return index;
            }
        }

        return -1;
    }

    // quantidade de elementos
    public int size() {
        return keysAdded;
    }

    // verifica se está vazia
    public boolean isEmpty() {
        return keysAdded == 0;
    }

    // limpa tabela
    public void clear() {

        keys = new String[tableSize];

        keysAdded = 0;
    }

    // representação visual da tabela
    @Override
    public String toString() {
        return Arrays.toString(keys);
    }
}