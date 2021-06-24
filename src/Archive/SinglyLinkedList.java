package Archive;

import Archive.Node3;

public class SinglyLinkedList {

    public Node3 head;
    public Node3 tail;


    public void add(int data){

        Node3 newNode3 = new Node3(data);
        if(head == null) {
            head = newNode3;
           tail = newNode3;
        }
        else
        {
            tail.next = newNode3;
           tail = newNode3;
       }

    }

    public void showList(){
        Node3 position = head;

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        System.out.println("Nodes in the List are:");
        while (position != null){
            System.out.println(position.data);
            position = position.next;
        }
    }


}
