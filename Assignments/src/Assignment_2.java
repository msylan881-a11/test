import java.util.*;

public class Assignment_2 {

    // 1️⃣ عكس النص باستخدام Stack
    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    // 2️⃣ ترتيب Stack باستخدام Stack آخر
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > tmp) {
                stack.push(tempStack.pop());
            }
            tempStack.push(tmp);
        }
        return tempStack;
    }

    // 3️⃣ عكس العناصر في Queue
    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        return q;
    }

    // 4️⃣ Priority Queue (الأصغر يخرج أولاً)
    static class Assignment_2_PriorityQueue {
        private PriorityQueue<Integer> pq;

        public Assignment_2_PriorityQueue() {
            pq = new PriorityQueue<>();
        }

        public void enqueue(int val) {
            pq.add(val);
        }

        public int dequeue() {
            return pq.poll();
        }
    }

    // 5️⃣ دمج صفّين مرتبَين في صف واحد مرتب
    public static Queue<Integer> mergeSortedQueues(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> result = new LinkedList<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) {
                result.add(q1.poll());
            } else {
                result.add(q2.poll());
            }
        }
        result.addAll(q1);
        result.addAll(q2);
        return result;
    }
}
    // ============================
    // Main لاختبار كل الدوال
    // ============================