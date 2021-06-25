import java.util.LinkedList;

/**
 * Developed by: Yousef Emadi
 * Date: 23-06-2021
 * Subject: Bubble sort on Linked list
 * Assignment: create a new java application that implements the bubble sort using a linked list.
 */


class Nodd {
    int data;
    Nodd next;
}


class BubbleSortLinkedList {
    Nodd head;

    BubbleSortLinkedList(){
        head = null;
    }

//    public static int[] sorter(int[] arr){
//        boolean neadNextPass = true;
//        for (int i = 0 ; i < arr.length && neadNextPass; i++){
//            neadNextPass = false;
//            for (int j = 1 ; j < arr.length-i ; j++){
//                if (arr[j] < arr[j-1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j-1];
//                    arr[j-1] = temp;
//                    neadNextPass = true;
//                }
//            }
//
//        }
//        return arr;
//    }

    /**  Bubble Sort  */
    void bubbleSort(){
        int size = size();

        for (int i = 0 ; i < size-1; i++){

            Nodd pointer = head;
            Nodd nextPointer = pointer.next;;

            for (int j = 1 ; j < size  ; j++){


                if (nextPointer.data < pointer.data){
                    int temp = pointer.data;
                    pointer.data = nextPointer.data;
                    nextPointer.data = temp;
                }
                pointer = nextPointer;
                nextPointer = nextPointer.next;
            }
        }
    }


    void addToFirst( int data){
        //creat new node
        Nodd newNodd = new Nodd();
        newNodd.data = data;

        //replace head
        newNodd.next = head;
        head = newNodd;
    }

    void addToLast( int data){
        //creat new node
        Nodd newNodd = new Nodd();
        newNodd.data = data;

        //if list is empty
        if(head == null) {
            head = newNodd;
            return;
        }

        //if list is not empty
        Nodd pointer = head;
        while (pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = newNodd;
    }

    void addAfter(int insertPoint,  int data){
        //creat new node
        Nodd newNodd = new Nodd();
        newNodd.data = data;

        //find insert point
        Nodd insertNodd = returnNodeByIndex(insertPoint);
        //replace next values
        newNodd.next = insertNodd.next;
        insertNodd.next = newNodd;
    }

    int size(){
        Nodd pointer = head;
        int count = 0;
        while (pointer != null){
            pointer = pointer.next;
            count++;
        }
        return count;
    }

    Nodd returnNodeByIndex(int index){
        //validation of index number
        if (index > size() - 1 ) return null;

        Nodd pointer = head;
        for(int i = 0; i <= index; i++){
            pointer = pointer.next;
        }
        return pointer;
    }

    void deleteFirst(){
        //if list is empty
        if(head == null) return;

        Nodd targetNode = head;
        head = targetNode.next;
        targetNode.next = null;
    }



    void deleteNodeByIndex(int index){
        Nodd targetNode = returnNodeByIndex(index);
        Nodd previous = returnNodeByIndex(index-1);

        previous.next = targetNode.next;
        targetNode.next = null;
    }

    Nodd find(int searchKey){
        Nodd pointer = head;
        while(pointer != null){
            if(pointer.data == searchKey) return pointer;
            pointer = pointer.next;
        }
        return null;
    }

    boolean isExistsInList(int searchKey){
        return (find(searchKey) != null);
    }

    void showList(){
        Nodd pointer = head;
        if (pointer == null) {
            System.out.println("List is empty");
            return;
        }
        while(pointer != null){
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }

    void clear(){
        head.next = null;
        head = null;
    }

    void emptyList(){

        Nodd pointer = head;

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

    public static void main(String[] args) {
        BubbleSortLinkedList list = new BubbleSortLinkedList();

        list.addToFirst(99);
        list.addToFirst(12);
        list.addToFirst(1);
        list.addToFirst(50);
        list.addToFirst(4);
        list.addToFirst(126598);
        list.addToFirst(25);
        list.addToFirst(-9);
        list.addToFirst(11);
        list.addToFirst(100);
        list.addToFirst(0);
        list.showList();
        System.out.println("------------------ after Bubble sort---------------");
//      System.out.println(list.size());
        list.bubbleSort();
        list.showList();


    }
}




