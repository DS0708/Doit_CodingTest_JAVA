package DataStructure.deque;

import java.util.*;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Node> deque = new LinkedList<>();
        List<Node> list = new ArrayList<>();

        deque.addFirst(new Node(1,5));
        deque.addFirst(new Node(2,3));
        deque.addFirst(new Node(3,4));
        deque.addLast(new Node(4,2));
        deque.addLast(new Node(5,1));

        int size = deque.size();

        for(int i=0; i<size; i++){
            list.add(deque.poll());
        }

        Collections.sort(list);

        for(Node node : list){
            deque.addLast(node);
        }

        for(Node node : deque){
            System.out.println(node.index + " : " + node.val);
        }

        System.out.println("-------------------");

        for(int i=0; i<size; i++){
            Node node = deque.pollFirst();
            System.out.println(node.index + " : " + node.val);
        }

        System.out.println("-------------------");

        deque.addFirst(new Node(1,5));
        deque.addFirst(new Node(2,3));
        deque.addFirst(new Node(3,4));
        deque.addLast(new Node(4,2));
        deque.addLast(new Node(5,1));

        System.out.println(deque.getFirst().index);
        System.out.println(deque.getFirst().index);
        System.out.println(deque.peekLast().index);
        System.out.println(deque.peekLast().index);
        System.out.println(deque.pollFirst().index);
        System.out.println(deque.pollFirst().index);
        System.out.println(deque.removeLastOccurrence(2));
    }
}

class Node implements Comparable<Node>{
    int index;
    int val;
    public Node(int index, int val){
        this.index = index;
        this.val = val;
    }
    @Override
    public int compareTo(Node o){
        return this.val - o.val;
    }
}
