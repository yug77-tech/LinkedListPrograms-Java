public class Q7DeleteFirstDoublyForward {

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

    static Node deleteFirst(Node head) {
        if (head == null) return null;
        head = head.next;
        if (head != null) head.prev = null;
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
        Node head = createList(new int[]{9, 18, 27, 36});

        System.out.print("Before deleting first node: ");
        displayForward(head);

        head = deleteFirst(head);

        System.out.print("After deleting first node (forward): ");
        displayForward(head);
    }
}
