import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class main {

    // ===== MAIN =====
    public static void main(String args[]) {
        System.out.println("Ibrahim Hadi homi  :: Assignment_1 ");


        System.out.println("=== Arrays ===");

        Assignment1_All.Q1_CloneArray();
        Assignment1_All.Q2_RemoveRandom();
        Assignment1_All.Q3_RemoveElement();
        Assignment1_All.Q4_ReverseArray();
        Assignment1_All.Q5_ConcatLists();
        System.out.println("\n=== Singly Linked List ===");
        Assignment1_All.Q5_ConcatLists();
        Assignment1_All.LinkedList l = new Assignment1_All.LinkedList();
        l.append(10);
        l.append(20);
        l.append(30);
        System.out.println("Q7 Search: " + Assignment1_All.Q7_Search(l.head, 20));
        System.out.println("Q8 FindIndex: " + Assignment1_All.Q8_FindIndex(l.head, 30));
        l.head = Assignment1_All.Q9_Remove(l.head, 1);
        System.out.print("Q9 After Remove: ");
        l.print();

        System.out.println("\n===");





// Assignment_2 main

        System.out.println("Ibrahim Hadi homi  :: Assignment_2 ");

        // 1️⃣ عكس النص
        System.out.println("Reverse String: " + Assignment_2.reverseString("Ibrahim "));

        // 2️⃣ ترتيب Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
        System.out.println("Sorted Stack: " + Assignment_2.sortStack(stack));

        // 3️⃣ عكس Queue
        Queue<Integer> q = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Reversed Queue: " + Assignment_2.reverseQueue(q));

        // 4️⃣ Priority Queue
        Assignment_2.Assignment_2_PriorityQueue pq = new Assignment_2.Assignment_2_PriorityQueue();
        pq.enqueue(5);
        pq.enqueue(1);
        pq.enqueue(3);
        System.out.println("PriorityQueue Dequeue: " + pq.dequeue()); // 1
        System.out.println("PriorityQueue Dequeue: " + pq.dequeue()); // 3

        // 5️⃣ دمج صفّين مرتبَين
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(1, 4, 7));
        Queue<Integer> q2 = new LinkedList<>(Arrays.asList(2, 3, 6, 8));
        System.out.println("Merged Queue: " + Assignment_2.mergeSortedQueues(q1, q2));

}
}

