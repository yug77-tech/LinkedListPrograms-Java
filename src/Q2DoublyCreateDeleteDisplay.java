public class Q2DoublyCreateDeleteDisplay {

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

    static Node deleteValue(Node head, int key) {
        if (head == null) return null;

        Node cur = head;
        while (cur != null && cur.data != key) {
            cur = cur.next;
        }

        if (cur == null) return head;

        if (cur.prev != null) cur.prev.next = cur.next;
        else head = cur.next;

        if (cur.next != null) cur.next.prev = cur.prev;

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
        int[] input = {5, 15, 25, 35, 45};
        Node head = createList(input);

        System.out.print("Original doubly list: ");
        displayForward(head);

        int deleteKey = 25;
        head = deleteValue(head, deleteKey);

        System.out.print("After deleting " + deleteKey + ": ");
        displayForward(head);
    }
}
