public class Q6InsertEndDoublyForward {

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node createList(int[] values) {
        Node head = null, tail = null;
        for (int v : values) {
            Node n = new Node(v);
            if (head == null) {
                head = tail = n;
            } else {
                tail.next = n;
                n.prev = tail;
                tail = n;
            }
        }
        return head;
    }

    static Node insertAtEnd(Node head, int value) {
        Node n = new Node(value);
        if (head == null) return n;

        Node temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = n;
        n.prev = temp;
        return head;
    }

    static void displayForward(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = createList(new int[]{100, 200, 300});

        System.out.print("Before insertion: ");
        displayForward(head);

        head = insertAtEnd(head, 400);

        System.out.print("After insertion at end (forward): ");
        displayForward(head);
    }
}
