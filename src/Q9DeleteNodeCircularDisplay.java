public class Q9DeleteNodeCircularDisplay {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node createCircularList(int[] values) {
        if (values.length == 0) return null;

        Node head = new Node(values[0]);
        Node tail = head;

        for (int i = 1; i < values.length; i++) {
            tail.next = new Node(values[i]);
            tail = tail.next;
        }
        tail.next = head;
        return head;
    }

    static Node deleteValue(Node head, int key) {
        if (head == null) return null;

        if (head.next == head) {
            return head.data == key ? null : head;
        }

        if (head.data == key) {
            Node tail = head;
            while (tail.next != head) tail = tail.next;
            head = head.next;
            tail.next = head;
            return head;
        }

        Node prev = head;
        Node cur = head.next;

        while (cur != head) {
            if (cur.data == key) {
                prev.next = cur.next;
                return head;
            }
            prev = cur;
            cur = cur.next;
        }

        return head;
    }

    static void display(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        Node head = createCircularList(new int[]{10, 20, 30, 40});

        System.out.print("Before deletion: ");
        display(head);

        head = deleteValue(head, 30);

        System.out.print("After deleting 30: ");
        display(head);
    }
}
