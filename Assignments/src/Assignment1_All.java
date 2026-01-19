
import java.util.*;

// ===== Assignment 1 – Data Structures =====
public class Assignment1_All{
    public static void Q1_CloneArray() {
        int[] arr = {1, 2, 3, 4};
        int[] clone = arr.clone();
        System.out.println("Q1 Clone: " + Arrays.toString(clone));
    }

    public static void Q2_RemoveRandom() {
        int[] arr = {10, 20, 30, 40, 50};
        Random rand = new Random();
        int index = rand.nextInt(arr.length);
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) newArr[j++] = arr[i];
        }
        System.out.println("Q2 Remove Random: " + Arrays.toString(newArr));
    }

    public static void Q3_RemoveElement() {
        int[] arr = {1, 2, 3, 4, 5};
        int element = 3;
        int[] newArr = Arrays.stream(arr).filter(num -> num != element).toArray();
        System.out.println("Q3 Remove Element: " + Arrays.toString(newArr));
    }

    public static void Q4_ReverseArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println("Q4 Reverse: " + Arrays.toString(arr));
    }

    // ===== Singly Linked List =====
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    static class LinkedList {
        Node head;

        void append(int d) {
            Node n = new Node(d);
            if (head == null) {
                head = n;
                return;
            }
            Node t = head;
            while (t.next != null) t = t.next;
            t.next = n;
        }

        void print() {
            Node t = head;
            while (t != null) {
                System.out.print(t.data + " -> ");
                t = t.next;
            }
            System.out.println("null");
        }
    }

    public static void Q5_ConcatLists() {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(2);
        LinkedList l2 = new LinkedList();
        l2.append(3);
        l2.append(4);
        Node t = l1.head;
        while (t.next != null) t = t.next;
        t.next = l2.head;
        System.out.print("Q5 Concat: ");
        l1.print();
    }

    public static Node Q6_RotateRight(Node head, int k) {
        if (head == null || k == 0) return head;
        Node temp = head;
        int len = 1;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        temp.next = head;
        k = k % len;
        int steps = len - k;
        Node newTail = head;
        for (int i = 1; i < steps; i++) newTail = newTail.next;
        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public static int Q7_Search(Node head, int key) {
        int pos = 0;
        while (head != null) {
            if (head.data == key) return pos;
            head = head.next;
            pos++;
        }
        return -1;
    }

    public static int Q8_FindIndex(Node head, int val) {
        int idx = 0;
        while (head != null) {
            if (head.data == val) return idx;
            head = head.next;
            idx++;
        }
        return -1;
    }

    public static Node Q9_Remove(Node head, int pos) {
        if (head == null) return null;
        if (pos == 0) return head.next;
        Node t = head;
        for (int i = 0; t != null && i < pos - 1; i++) t = t.next;
        if (t == null || t.next == null) return head;
        t.next = t.next.next;
        return head;
    }

    // ===== Doubly Linked List =====
    static class DNode {
        int data;
        DNode next, prev;

        DNode(int d) {
            data = d;
        }
    }

    public static void Q10_RemoveDuplicates(DNode head) {
        DNode cur = head;
        while (cur != null) {
            DNode run = cur.next;
            while (run != null) {
                if (run.data == cur.data) {
                    if (run.next != null) run.next.prev = run.prev;
                    run.prev.next = run.next;
                }
                run = run.next;
            }
            cur = cur.next;
        }
    }

    public static void Q11_PrintReverse(DNode head) {
        DNode t = head;
        while (t.next != null) t = t.next;
        while (t != null) {
            System.out.print(t.data + " <- ");
            t = t.prev;
        }
        System.out.println("null");
    }

    public static int Q12_Search(DNode head, int key) {
        int pos = 0;
        while (head != null) {
            if (head.data == key) return pos;
            head = head.next;
            pos++;
        }
        return -1;
    }

    // ===== Circular Linked List =====
    static class CNode {
        int data;
        CNode next;

        CNode(int d) {
            data = d;
        }
    }

    public static CNode Q13_Insert(CNode head, int data, int pos) {
        CNode n = new CNode(data);
        if (head == null) {
            head = n;
            head.next = head;
            return head;
        }
        if (pos == 0) {
            CNode t = head;
            while (t.next != head) t = t.next;
            t.next = n;
            n.next = head;
            head = n;
            return head;
        }
        CNode t = head;
        for (int i = 0; i < pos - 1 && t.next != head; i++) t = t.next;
        n.next = t.next;
        t.next = n;
        return head;
    }

    public static CNode Q14_Delete(CNode head, int pos) {
        if (head == null) return null;
        if (pos == 0) {
            CNode t = head;
            while (t.next != head) t = t.next;
            t.next = head.next;
            head = head.next;
            return head;
        }
        CNode t = head;
        for (int i = 0; i < pos - 1 && t.next != head; i++) t = t.next;
        t.next = t.next.next;
        return head;
    }

    public static int Q15_Search(CNode head, int key) {
        if (head == null) return -1;
        CNode t = head;
        int pos = 0;
        do {
            if (t.data == key) return pos;
            t = t.next;
            pos++;
        } while (t != head);
        return -1;
    }

    public static void Q16_Split(CNode head) {
        if (head == null) return;
        CNode slow = head, fast = head;
        while (fast.next != head && fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }
        CNode head1 = head;
        CNode head2 = slow.next;
        fast.next = head2;
        slow.next = head1;
        System.out.print("First half: ");
        printCircular(head1);
        System.out.print("Second half: ");
        printCircular(head2);
    }

    public static void printCircular(CNode head) {
        CNode t = head;
        do {
            System.out.print(t.data + " -> ");
            t = t.next;
        } while (t != head);
        System.out.println("(back to head)");
    }

}