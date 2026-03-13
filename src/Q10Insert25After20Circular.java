public class Q10Insert25After20Circular {

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

    static Node insertAfter(Node head, int target, int value) {
        if (head == null) return null;

        Node cur = head;
        do {
            if (cur.data == target) {
                Node n = new Node(value);
                n.next = cur.next;
                cur.next = n;
                return head;
            }
            cur = cur.next;
        } while (cur != head);

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
        // Given circular list: 10 -> 20 -> 30 -> 10
        Node head = createCircularList(new int[]{10, 20, 30});

        System.out.print("Original circular list: ");
        display(head);

        head = insertAfter(head, 20, 25);

        System.out.print("After inserting 25 after 20: ");
        display(head);
    }
}
