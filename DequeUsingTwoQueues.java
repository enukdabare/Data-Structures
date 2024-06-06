package DataStructures;
import java.util.LinkedList;
import java.util.Queue;

public class DequeUsingTwoQueues{
     Queue<Integer> queue1 = new LinkedList<>();
     Queue<Integer> queue2 = new LinkedList<>();

    // Push an element to the back of the deque
    public void pushBack(int item){
        queue1.add(item);
    }

    // Push an element to the front of the deque
    public void pushFront(int item){
        queue2.add(item);
        
        while (!queue1.isEmpty()){
            queue2.add(queue1.remove());
        }
        
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop an element from the front of the deque
    public int popFront(){
        return queue1.remove();
    }

    // Pop an element from the back of the deque
    public int popBack(){
        return queue1.remove();
    }
    
    public int size(){
        return queue1.size();
    }

    public static void main(String[] args){
        DequeUsingTwoQueues deque = new DequeUsingTwoQueues();
        deque.pushBack(1);
        deque.pushBack(2);
        deque.pushFront(3);

        System.out.println("Popped element from front: " + deque.popFront()); 
        System.out.println("Popped element from back: " + deque.popBack()); 
        System.out.println("Size of deque after popping: " + deque.size());
    }
}
