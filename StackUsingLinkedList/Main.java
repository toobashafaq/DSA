class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class Stack{
    Node head;
    Stack(){
        this.head=null;
    }
    boolean isEmpty(){
        return head==null;
    }
    void push(int data){
        Node newNode=new Node(data);
        if(newNode==null){
            System.out.println("Stack overflow");
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    void pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return;
        }
        else {
            Node temp=head;
            head=head.next;
            temp=null;
        }
    }
    int peek(){
        if(!isEmpty()){
            return head.data;
        }else{
            System.out.println("Stack is empty");
            return Integer.MAX_VALUE;
        }
    }

    public void printStack() {
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return;
        }
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr=curr.next;
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);
        System.out.println("Top ele "+st.peek());
        st.printStack();
        System.out.println("Removing two ele");
        st.pop();
        st.pop();

        System.out.println("Top ele "+st.peek());

     st.printStack();

    }

}
