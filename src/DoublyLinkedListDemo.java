/**
 * Developed by: Yousef Emadi
 * Date: 23-06-2021
 * Subject: Create a singly linked list from the scratch
 */

class Node11 {
    String item;
    int count;
    Node11 next;
    Node11 previous;
}

class DoublyLinkedList {
    Node11 head;

    DoublyLinkedList(){
        head = null;
    }

    void addToFirst(String item, int count){
        //creat new node
        Node11 newNode11 = new Node11();
        newNode11.item = item;
        newNode11.count = count;

        //replace head
        newNode11.next = head;
        newNode11.previous = null;
        head = newNode11;
    }

    void addToLast(String item, int count){
        //creat new node
        Node11 newNode11 = new Node11();
        newNode11.item = item;
        newNode11.count = count;

        //if list is empty
        if(head == null) {
            head = newNode11;
            return;
        }

        //if list is not empty
        Node11 pointer = head;
        while (pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = newNode11;
        newNode11.previous = pointer;
    }

    void addAfter(int insertPoint, String item, int count){
        //creat new node
        Node11 newNode11 = new Node11();
        newNode11.item = item;
        newNode11.count = count;

        //find insert point
        Node11 insertNode11 = returnNodeByIndex(insertPoint);
        //replace next values
        newNode11.next = insertNode11.next;
        insertNode11.next = newNode11;
    }

    int size(){
        Node11 pointer = head;
        int count = 0;
        while (pointer != null){
            pointer = pointer.next;
            count++;
        }
        return count;
    }

    Node11 returnNodeByIndex(int index){
        //validation of index number
        if (index > size() - 1 ) return null;

        Node11 pointer = head;
        for(int i = 0; i <= index; i++){
            pointer = pointer.next;
        }
        return pointer;
    }

    void deleteFirst(){
        //if list is empty
        if(head == null) System.out.println("List is empty");;

        Node11 targetNode = head;

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
        Node11 pointer = head;
        while (pointer.next != null){
            pointer = pointer.next;
        }

        pointer.previous.next = null;   //renewal the last node field
        pointer.previous = null;  //delete operation
    }



    void deleteNodeByIndex(int index){
        Node11 targetNode = returnNodeByIndex(index);
        Node11 previous = returnNodeByIndex(index-1);

        previous.next = targetNode.next;
        targetNode.next = null;
    }

    Node11 find(String searchKey){
        Node11 pointer = head;
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
        Node11 pointer = head;
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

        Node11 pointer = head;

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
