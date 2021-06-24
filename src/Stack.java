/**
 * Developed by: Yousef Emadi
 * Date: 23-06-2021
 * Subject: Create a singly linked list from the scratch
 */


class Node4 {
    String item;
    int count;
    Node4 next;
    Node4 previous;
}

class Stack {

    Node4 head;

    Stack() {
        head = null;
    }

    void push(String item, int count) {
        //creat new node
        Node4 newNode = new Node4();
        newNode.item = item;
        newNode.count = count;

        //if list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        //if list is not empty
        Node4 pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = newNode;
        newNode.previous = pointer;
    }

    void pop(){
        //if list is empty
        if(head == null) {
            System.out.println("List is empty");
            return;
        };

        //if list is not empty
        Node4 pointer = head;
        while (pointer.next != null){
            pointer = pointer.next;
        }

        pointer.previous.next = null;   //renewal the last node field
        pointer.previous = null;  //delete operation
    }

    int size(){
        Node4 pointer = head;
        int count = 0;
        while (pointer != null){
            pointer = pointer.next;
            count++;
        }
        return count;
    }

    void showStack(){
        Node4 pointer = head;
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

class Test4 {
    public static void main(String[] args) {

        Stack stack = new Stack();

        System.out.println("---------------Push------------");
        stack.push("A",10);
        stack.push("B",20);
        stack.push("C",30);
        stack.showStack();
        System.out.println();

        System.out.println("---------------Pop------------");
        stack.pop();
        stack.showStack();
        System.out.println();

        System.out.println("---------------Empty the List-------------");
        stack.clear();
        System.out.println();

        System.out.println("---------------Size------------");
        stack.size();
        stack.showStack();

    }
}
