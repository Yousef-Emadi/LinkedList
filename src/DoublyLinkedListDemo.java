/**
 * Developed by: Yousef Emadi
 * Date: 23-06-2021
 * Subject: Create a singly linked list from the scratch
 */

class Node {
    String item;
    int count;
    Node3 next;
    Node3 previous;
}

class DoublyLinkedList {
    Node3 head;

    DoublyLinkedList(){
        head = null;
    }

    void addToFirst(String item, int count){
        //creat new node
        Node3 newNode3 = new Node3();
        newNode3.item = item;
        newNode3.count = count;

        //replace head
        newNode3.next = head;
        newNode3.previous = null;
        head = newNode3;
    }

    void addToLast(String item, int count){
        //creat new node
        Node3 newNode3 = new Node3();
        newNode3.item = item;
        newNode3.count = count;

        //if list is empty
        if(head == null) {
            head = newNode3;
            return;
        }

        //if list is not empty
        Node3 pointer = head;
        while (pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = newNode3;
        newNode3.previous = pointer;
    }

    void addAfter(int insertPoint, String item, int count){
        //creat new node
        Node3 newNode3 = new Node3();
        newNode3.item = item;
        newNode3.count = count;

        //find insert point
        Node3 insertNode3 = returnNodeByIndex(insertPoint);
        //replace next values
        newNode3.next = insertNode3.next;
        insertNode3.next = newNode3;
    }

    int size(){
        Node3 pointer = head;
        int count = 0;
        while (pointer != null){
            pointer = pointer.next;
            count++;
        }
        return count;
    }

    Node3 returnNodeByIndex(int index){
        //validation of index number
        if (index > size() - 1 ) return null;

        Node3 pointer = head;
        for(int i = 0; i <= index; i++){
            pointer = pointer.next;
        }
        return pointer;
    }

    void deleteFirst(){
        //if list is empty
        if(head == null) System.out.println("List is empty");;

        Node3 targetNode = head;

        head = targetNode.next;
        targetNode.next = null;

    }

    void deleteLast(){
        //if list is empty
        if(head == null) {
            System.out.println("List is empty");
            return;
        };

        //if list is not empty
        Node3 pointer = head;
        while (pointer.next != null){
            pointer = pointer.next;
        }

        pointer.previous.next = null;   //renewal the last node field
        pointer.previous = null;  //delete operation
    }



    void deleteNodeByIndex(int index){
        Node3 targetNode = returnNodeByIndex(index);
        Node3 previous = returnNodeByIndex(index-1);

        previous.next = targetNode.next;
        targetNode.next = null;
    }

    Node3 find(String searchKey){
        Node3 pointer = head;
        while(pointer != null){
            if(pointer.item.equals(searchKey)) return pointer;
            pointer = pointer.next;
        }
        return null;
    }

    boolean isExistsInList(String searchKey){
        return (find(searchKey) != null);
    }

    void showList(){
        Node3 pointer = head;
        if (pointer == null) {
            System.out.println("List is empty");
            return;
        }
        while(pointer != null){
            System.out.println(pointer.item+", "+pointer.count);
            pointer = pointer.next;
        }
    }

    void clear(){
        head.next = head.previous = null;
        head = null;
    }
    void emptyList(){

        Node3 pointer = head;

        //if the list is empty
        if (pointer == null) {
            System.out.println("List is empty");
            return;
        }
        // till the list gonna be empty
        while(pointer != null){
            pointer = pointer.next;
            deleteFirst();
        }
    }
}




public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println("---------------Add To First------------");
        list.addToFirst("A",10);
        list.addToFirst("B",20);
        list.addToFirst("C",30);
        list.showList();
        System.out.println();

        System.out.println("---------------Add To Last------------");
        list.addToLast("X",80);
        list.addToLast("Y",90);
        list.addToLast("Z",100);
        list.showList();
        System.out.println();

        System.out.println("---------------Delete from the first------------");
        list.deleteFirst();
        list.showList();

        System.out.println("---------------Delete from the last------------");
        list.deleteLast();
        list.showList();

        System.out.println("---------------Empty the List------------");
        list.clear();
        list.showList();

    }
}
