import java.util.Stack;
import java.util.Scanner;

public class Homework1 {

public static Node Tree;
public static Stack<Character> Temp = new Stack<Character>();  

public static class Node{
        Node left;
        Node right;
        Character key;
    public Node c;

    public Node(char n) {
            key = n;
        }
        public  String toString(){
            return key.toString();
        }
}
  
    public static void main(String[] args){
        System.out.print("Input : ");
        Scanner inputs = new Scanner(System.in);
        String input =  inputs.nextLine();

        for(int i=0;i<input.length();i++){
            Temp.add(input.charAt(i));
        }
        Tree = new Node(Temp.pop());
        infix(Tree);
        inorder(Tree);
        System.out.print("=" + calculate(Tree));
        TreeDemo.main(args);
    }

    public static void infix(Node n) {

                    if (n.key == '+' || n.key == '-' || n.key == '*' || n.key == '/') {
                            n.right = new Node(Temp.pop());
                            infix(n.right);
                            n.left = new Node(Temp.pop());
                            infix(n.left);
                    }
    }
    
    public static void inorder(Node n){
        if (n.key == '+' || n.key == '-' || n.key == '*' || n.key == '/'){
                if(n!=Tree){
                        System.out.print("(");
                    }
                    inorder(n.left);
                    System.out.print(n.key);
                    inorder(n.right);
                if(n!=Tree){
                    System.out.print(")");
                    }
                }else {
                            System.out.print(n.key);
                    }
    }
   
    public static int calculate(Node n) {
            switch (n.key) {
                case '+':
                    return calculate(n.left) + calculate(n.right);
                case '-':
                    return calculate(n.left) - calculate(n.right);
                case '/':
                    return calculate(n.left) / calculate(n.right);
                case '*':
                    return calculate(n.left) * calculate(n.right);
            }        
            return Integer.parseInt(n.key.toString());
    }
}
//
