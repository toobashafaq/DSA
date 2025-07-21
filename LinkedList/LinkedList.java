import java.io.*;

// Java program to implement 
// a Singly Linked List 
public class LinkedList {

    static Node head; // head of list

    // Linked list Node. 
    // This inner class is made static 
    // so that main() can access it 
    static class Node {

        int data;
        Node next;

        // Constructor 
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node 
    public static LinkedList insertAtEnd(LinkedList list, int data)
    {
        // Create a new node with given data 
        Node new_node = new Node(data);


        // If the Linked List is empty, 
        // then make the new node as head 
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node 
            // and insert the new_node there 
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node 
            last.next = new_node;
        }

        // Return the list by head 
        return list;
    }

    // Method to print the LinkedList. 
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList 
        while (currNode != null) {
            // Print the data at current node 
            System.out.print(currNode.data + " ");

            // Go to next node 
            currNode = currNode.next;
        }
    }

    // Driver code 
    public static void main(String[] args)
    {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        // 
        // ******INSERTION****** 
        // 

        // Insert the values 
        //list = insertAtEnd(list, 1);
        list = insertAtEnd(list, 2);
        list = insertAtEnd(list, 3);
        //list = insertAtEnd(list, 4);
        list = insertAtEnd(list, 5);
       // list = insertAtEnd(list, 6);


        // Print the LinkedList
        printList(list);
        System.out.println("");

        System.out.println("After inserting Nodes at the front:");
        int data = 1;
        head = insertAtFront(head, data);

        printList(list);
        System.out.println("");
        int after =3 ;
        data=4;
        System.out.println("After a Nodes "+after);

        head = insertAfterNode(head, data,after);

        printList(list);
        System.out.println("");
        int pos=3;
        System.out.println("At specific position "+pos);
        head=specificPosition(head,data,pos);
        printList(list);
    }

    private static Node specificPosition(Node head, int data, int pos) {
        Node newNode=new Node(100);

        if(pos==1){
            newNode.next=head;
            return newNode;
        }
        Node currNode=head;
        int count=1;

        while (currNode!=null && count<pos-1){
            currNode=currNode.next;
            count++;
        }

        if(currNode==null){
            System.out.println("Position out of bounds.");
            return head;
        }
        newNode.next=currNode.next;
        currNode.next=newNode;

        return head;
    }

    private static Node insertAfterNode(Node head, int value, int after) {
        Node currNode=head;
        while(currNode!=null){
            if(currNode.data==after){
                Node newNode=new Node(value);
                newNode.next=currNode.next;
                currNode.next=newNode;
                break;
            }
            currNode=currNode.next;
        }
        return head;
    }

    private static Node insertAtFront(Node head, int data) {
        Node newNode=new Node(data);
        newNode.next=head;
        return newNode;
    }
}