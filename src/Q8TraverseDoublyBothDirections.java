public class Q8TraverseDoublyBothDirections {

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

    static Node getTail(Node head) {
        if (head == null) return null;
        Node t = head;
        while (t.next != null) t = t.next;
        return t;
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

    static void displayBackward(Node tail) {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.prev != null) System.out.print(" <-> ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = createList(new int[]{7, 14, 21, 28});

        System.out.print("Forward traversal: ");
        displayForward(head);

        System.out.print("Backward traversal: ");
        displayBackward(getTail(head));
    }
}
