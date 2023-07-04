package linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
public class Main {

    public static void main(String[] args) {

        LList arrayList = new LList();

        System.out.println(arrayList);

        arrayList.add("s1");
        arrayList.add("s2");
        arrayList.add("s3");
        arrayList.add("end");

        arrayList.add(2, "123");

        arrayList.remove(4);

        arrayList.exposeArray();
    }
}

class LList {
    Node first;
    Node last;
    int size;

    public void add(String elem){
        Node node = new Node();
        node.value = elem;

        if (size==0){
            first = node;
            last = node;
        }else {
           last.next = node;//2
            node.prev = last;
            last = node;//3
        }
        size++;
    }

    public void add(int index, String elem){

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node node = new Node();
        node.value = elem;

        if (index == 0) {
            node.next = first;
            first = node;
        } else {
            Node current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }

        size++;
    }

    public void remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        String removedElement;

        if (index == 0) {
            removedElement = first.value;
            first = first.next;
        } else {
            Node current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedElement = current.next.value;
            current.next = current.next.next;
        }

        size--;
    }

    public String get(int index){
        Node tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    public void exposeArray(){
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.get(i));
        }
    }


    class Node{
        String value;
        Node next;
        Node prev;
    }

}
