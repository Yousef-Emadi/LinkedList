/**
 * Developed by: Yousef Emadi
 * Date: 23-06-2021
 * Subject: Create a singly linked list from the scratch
 */

class Node8 {
    String item;
    int count;
    Node8 next;
    Node8 previous;
}

class Queue {

    Node8 head;

    Queue() {
        head = null;
    }

    void addToHead(String item, int count){
        //creat new node
        Node8 newNode8 = new Node8();
        newNode8.item = item;
        newNode8.count = count;

        //replace head
        newNode8.next = head;
        newNode8.previous = null;
        head = newNode8;
    }

    void addToTail
            (String item, int count) {
        //creat new node
        Node8 newNode8 = new Node8();
        newNode8.item = item;
        newNode8.count = count;

        //if list is empty
        if (head == null) {
            head = newNode8;
            return;
        }

        //if list is not empty
        Node8 pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = newNode8;
        newNode8.previous = pointer;
    }

    void deleteTail(){
        //if list is empty
        if(head == null) {
            System.out.println("List is empty");
            return;
        };

        //if list is not empty
        Node8 pointer = head;
        while (pointer.next != null){
            pointer = pointer.next;
        }

        pointer.previous.next = null;   //renewal the last node field
        pointer.previous = null;  //delete operation
    }

    void deleteHead(){
        //if list is empty
        if(head == null) System.out.println("List is empty");;

        Node8 targetNode = head;

        head = targetNode.next;
        targetNode.next = null;

    }

    int size(){
        Node8 pointer = head;
        int count = 0;
        while (pointer != null){
            pointer = pointer.next;
            count++;
        }
        return count;
    }

    void showQueue(){
        Node8 pointer = head;
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
