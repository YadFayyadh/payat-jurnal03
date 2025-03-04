package Jurnal.Jurnal03;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private String name;

    public SinglyLinkedList() {
        this("Daftar Resep : ");
    }

    public SinglyLinkedList(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    public void tambahResepDepan(E insertItem) {
        ListNode newNode = new ListNode(insertItem);

        if (isEmpty()) {
            // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<E>(insertItem);
        } else { // firstNode refers to new node
            newNode.next = firstNode;
            firstNode = newNode;
        }
    }

    public void tambahResepBelakang(E insertItem) {
        ListNode newNode = new ListNode(insertItem);
        if (isEmpty()) { // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<E>(insertItem);
        } else { // lastNode refers to new node
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    public E hapusResepBelakang() throws NoSuchElementException {
        if (isEmpty()) { // throw exception if List is empty
            throw new NoSuchElementException(name + " is empty");
        }
        E removedItem = lastNode.data; // retrieve data being removed
        // update references firstNode and lastNode
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else { // locate new last node
            ListNode<E> current = firstNode;
            // loop while current node does not refer to lastNode
            while (current.next != lastNode) {
                current = current.next;
            }
            lastNode = current; // current is new lastNode
            current.next = null;
        }
        return removedItem; // return removed node data
    }

    public E hapusResepDepan() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException(name + " is empty");
        }

        E removedItem = firstNode.data;
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.next;
        }
        return removedItem;
    }

    private boolean isEmpty() {
        return firstNode == null;
    }

    public void cetakResep() {
        if (isEmpty()) {
            System.out.printf("Resep tidak ada", name);
            return;
        }
        ListNode<E> current = firstNode;
        // while not at end of list, output current node's data
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.next;
        }

        System.out.println();
    }

    public void cariResep(String name) {
        ListNode<E> current = firstNode;
        while (current != null) {
            if (current.data instanceof Resep) {
                Resep resep = (Resep) current.data;
                if (resep.namaResep.equalsIgnoreCase(name)) {
                    System.out.println("Resep ditemukan: " + resep);
                    return;
                }
            }
            current = current.next;
        }
        System.out.println("Resep tidak ditemukan.");
    }

}
