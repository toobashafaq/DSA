class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class Main {

    static Node insertInEmptyList(Node last,int data){
        if(last!=null) {
            System.out.println("List is not empty");
            return last;
        }

        //Create a new node
        Node newNode=new Node(data);

        //point new node to itself
        newNode.next=newNode;

        //update last
        last=newNode;

        return last;
    }
    private static Node insertAtBeginning(Node last, int i) {
        Node newNode=new Node(i);
        if(last==null){
            newNode.next=newNode;
            return newNode;
        }
//        insert the new node
        newNode.next=last.next;
        last.next=newNode;
        return last;
    }

    //Print the circular LL
    static void printList(Node last){
        if(last==null) return;

        //start from the head
        Node head=last.next;
        while(true){
            System.out.print(head.data+ " ");
            head=head.next;
            if(head==last.next)break;
        }
        System.out.println();
    }


    private static Node insertAtEnd(Node last, int i) {
        Node newNode=new Node(i);
        if(last==null){
           last=newNode;
           newNode.next=newNode;
            return last;
        }
        newNode.next=last.next;
        last.next=newNode;
        last=newNode;
        return last;
    }
    private static Node insertAtPosition(Node last, int pos, int data) {
        if(last==null){
            if(pos!=1){
                System.out.println("Invalid position");
            }
            Node newNode=new Node(data);
            last=newNode;
            last.next=last;
            return last;
        }
        Node newNode=new Node(data);
        Node curr=last.next;
        if(pos==1){
            newNode.next=curr;
            last.next=newNode;
            return last;
        }
        //traverse

        for(int i=1;i<pos-1;i++){
            curr=curr.next;
            if(curr==last.next){
                System.out.println("Invalid position");
                return last;
            }
        }
        newNode.next=curr.next;
        curr.next=newNode;

        if(curr==last)
            last=newNode;

        return last;
    }

    private static Node deleteFirstNode(Node last) {
        if(last==null){
            System.out.println("List is empty");
            return null;
        }
        Node head=last.next;
        if(head==last){
//            only one node
            last=null;
        }else {
            last.next=head.next;
        }
        return last;
    }
    private static Node deleteSpecificNode(Node last, int i) {
        if(last==null){
            System.out.println("List is empty");
        }
        Node curr=last.next;
        Node prev=last;

        if(curr==last && curr.data==i){
            last=null;
            return last;
        }
        if(curr.data==i){
            last.next=curr.next;
            return last;
        }
        while(curr!=last && curr.data!=i){
            prev=curr;
            curr=curr.next;
        }
        if(curr.data==i){
            prev.next=curr.next;
            if(curr==last){
                last=prev;
            }
        }
        else {
            System.out.println("Node not found");
        }
        return last;
    }
    private static Node deleteLastNode(Node last) {
        if(last==null){
            System.out.println("list is empty");
            return null;
        }
        Node head=last.next;
        if(head==last){
            last=null;
            return last;
        }
        Node curr=head;
        while (curr.next!=last){
            curr=curr.next;
        }
        curr.next=head;
        last=curr;

        return last;
    }
    private static void findNode(Node last,int i) {
        Node temp=last.next;
        int f=0;
        if(last.next==null){
            System.out.println("list is empty");
        }else{
            do{
                if(temp.data==i){
                    System.out.println("Found");
                    f=1;
                    break;
                }
                temp=temp.next;
            }while (temp!=last.next);
            if(f==0){
                System.out.println("Not found");
            }
        }
    }
    public static void main(String[] args) {
        Node last=null;

        //insert a node into empty list
       last= insertInEmptyList(last,1);
        printList(last);

//        last= insertInEmptyList(last,2);
//        printList(last);


//        Insert at the beginning
        last=insertAtBeginning(last,5);
        printList(last);
        last=insertAtBeginning(last,4);
        printList(last);
        last=insertAtBeginning(last,3);
        printList(last);


        //        Insert at the end
        last=insertAtEnd(last,5);
        printList(last);
        last=insertAtEnd(last,4);
        printList(last);

        last=insertAtPosition(last,1,19);
        printList(last);
        last=insertAtPosition(last,0,10);
        printList(last);
        last=insertAtPosition(last,12,10);
        printList(last);



        //Deletion
        //delete the first node
        last=deleteFirstNode(last);
        printList(last);


        //delete specific node
        last = deleteSpecificNode(last, 3);
        printList(last);
        last = deleteSpecificNode(last, 10);
        printList(last);
        last = deleteSpecificNode(last, 4);
        printList(last);


        //deletion end of list
        last = deleteLastNode(last);
        printList(last);

        //searching
        findNode(last,2);
        findNode(last,5);

    }




}
