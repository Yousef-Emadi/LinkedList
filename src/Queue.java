/**
 * Developed by: Yousef Emadi
 * Date: 23-06-2021
 * Subject: Create a singly linked list from the scratch
 */

class Node3 {
    String item;
    int count;
    Node3 next;
    Node3 previous;
}

class Queue {

    Node3 head;

    Queue() {
        head = null;
    }

    void addToHead(String item, int count){
        //creat new node
        Node3 newNode3 = new Node3();
        newNode3.item = item;
        newNode3.count = count;

        //replace head
        newNode3.next = head;
        newNode3.previous = null;
        head = newNode3;
    }

    void addToTail
            (String item, int count) {
        //creat new node
        Node3 newNode3 = new Node3();
        newNode3.item = item;
        newNode3.count = count;

        //if list is empty
        if (head == null) {
            head = newNode3;
            return;
        }

        //if list is not empty
        Node3 pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = newNode3;
        newNode3.previous = pointer;
    }

    void deleteTail(){
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

    void deleteHead(){
        //if list is empty
        if(head == null) System.out.println("List is empty");;

        Node3 targetNode = head;

        head = targetNode.next;
        targetNode.next = null;

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

    void showQueue(){
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
}

class Test3 {
    public static void main(String[] args) {

        Queue queue = new Queue();

        System.out.println("---------------Add to Head------------");
        queue.addToHead("A",10);
        queue.addToHead("B",20);
        queue.addToHead("C",30);
        queue.showQueue();

        System.out.println("---------------Add to Tail------------");
        queue.addToTail("X",80);
        queue.addToTail("Y",90);
        queue.addToTail("Z",100);

        queue.showQueue();

        System.out.println("---------------Delete from the head------------");
        queue.deleteHead();
        queue.showQueue();
        System.out.println();

        System.out.println("---------------Delete from the tail------------");
        queue.deleteTail();
        queue.showQueue();
        System.out.println();

        System.out.println("---------------Size------------");
        queue.size();

        System.out.println("---------------Empty the Queue------------");
        queue.clear();
        queue.showQueue();



    }
}
