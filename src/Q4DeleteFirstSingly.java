public class Q4DeleteFirstSingly {

    static class Node {
        int data;
        Node next;

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
                tail = n;
            }
        }
        return head;
    }

    static Node deleteFirst(Node head) {
        if (head == null) return null;
        return head.next;
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = createList(new int[]{10, 20, 30, 40});

        System.out.print("Before deleting first node: ");
        display(head);

        head = deleteFirst(head);

        System.out.print("After deleting first node: ");
        display(head);
    }
}
