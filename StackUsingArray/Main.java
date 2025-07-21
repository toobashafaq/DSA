 class Stack {
    int top, cap;
    int a[];

    public Stack(int cap){
        this.cap=cap;
        top=-1;
        a=new int[cap];
    }
    public boolean push(int x){
        if(top>=cap-1){
            System.out.println("Stack Overflow");
            return false;
        }
        a[++top]=x;
        return true;
    }

    public int pop(){
        if(top<0){
            System.out.println("Stack Underflow");
            return 0;
        }
        return a[top--];
    }
    public int peek(){
        if(top<0){
            System.out.println("Stack is empty");
            return 0;
        }
        return a[top];
    }
    public boolean isEmpty(){
        return top<0;
    }
}
public class Main{
    public static void main(String[] args) {
        Stack s=new Stack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println(s.pop()+" popped from stack");
        System.out.println("Top ele is : "+s.peek());
        System.out.println("Elements in stack :");
        while (!s.isEmpty()){
            System.out.print(s.peek()+ " ");
            s.pop();
        }

    }
}
