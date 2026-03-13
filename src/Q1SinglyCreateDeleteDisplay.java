public class Q1SinglyCreateDeleteDisplay {

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

    static Node deleteValue(Node head, int key) {
        if (head == null) return null;

        if (head.data == key) return head.next;

        Node prev = head;
        Node cur = head.next;

        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
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
        int[] input = {10, 20, 30, 40, 50};
        Node head = createList(input);

        System.out.print("Original list: ");
        display(head);

        int deleteKey = 30;
        head = deleteValue(head, deleteKey);

        System.out.print("After deleting " + deleteKey + ": ");
        display(head);
    }
}
