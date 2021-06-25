/**
 * Developed by: Yousef Emadi
 * Date: 23-06-2021
 * Subject: Create a singly linked list from the scratch
 */

class Node2{
    String item;
    int count;
    Node8 next;
}

class LinkedList2 {
    Node8 head;

    LinkedList2(){
        head = null;
    }

    void addToFirst(String item, int count){
        //creat new node
        Node8 newNode5 = new Node8();
        newNode5.item = item;
        newNode5.count = count;

        //replace head
        newNode5.next = head;
        head = newNode5;
    }

    void addToLast(String item, int count){
        //creat new node
        Node8 newNode5 = new Node8();
        newNode5.item = item;
        newNode5.count = count;

        //if list is empty
        if(head == null) {
            head = newNode5;
            return;
        }

        //if list is not empty
        Node8 pointer = head;
        while (pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = newNode5;
    }

    void addAfter(int insertPoint, String item, int count){
        //creat new node
        Node8 newNode5 = new Node8();
        newNode5.item = item;
        newNode5.count = count;

        //find insert point
        Node8 insertNode5 = returnNodeByIndex(insertPoint);
        //replace next values
        newNode5.next = insertNode5.next;
        insertNode5.next = newNode5;
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

    Node8 returnNodeByIndex(int index){
        //validation of index number
        if (index > size() - 1 ) return null;

        Node8 pointer = head;
        for(int i = 0; i <= index; i++){
            pointer = pointer.next;
        }
        return pointer;
    }

    void deleteFirst(){
        //if list is empty
        if(head == null) return;

        Node8 targetNode = head;
        head = targetNode.next;
        targetNode.next = null;
    }



    void deleteNodeByIndex(int index){
        Node8 targetNode = returnNodeByIndex(index);
        Node8 previous = returnNodeByIndex(index-1);

        previous.next = targetNode.next;
        targetNode.next = null;
    }

    Node8 find(String searchKey){
        Node8 pointer = head;
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
        head.next = null;
        head = null;
    }

    void emptyList(){

        Node8 pointer = head;

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




public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();

        System.out.println("---------------Add a head node with some dummy data, then print the list------------");
        list.addToFirst("adam",10);
        list.addToFirst("marji",20);
        list.addToFirst("tom",30);
        list.showList();
        System.out.println();

        System.out.println("-----------Append four new nodes with dummy data, then print the list.------------------");
        list.addToFirst("jose",40);
        list.addToFirst("nelly",50);
        list.addAfter(3,"mahan",60);
        list.addToLast("zack",70);
        list.showList();
        System.out.println();

        System.out.println("------------Delete the head node then print the list.-----------------");
        list.deleteFirst();
        list.showList();
        System.out.println();

        System.out.println("------------5. Check if the list has a node that contains an \"orange\" value in its item field.-----------------");
        System.out.println(list.isExistsInList("orange"));
        System.out.println();

        System.out.println("------------insert a node with some dummy data after the nth node of the list.-----------------");
        list.addAfter(3,"Brian",80);
        list.addAfter(2,"Liam",90);
        list.showList();
        System.out.println();

        System.out.println("------------delete the nth node of the list-----------------");
        list.deleteNodeByIndex(4);
        list.showList();
        System.out.println();

        System.out.println("------------Empty the list, then print the list-----------------");
        list.emptyList();
        list.showList();
        System.out.println();

    }
}
