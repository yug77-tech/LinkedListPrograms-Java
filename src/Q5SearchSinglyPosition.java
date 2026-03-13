public class Q5SearchSinglyPosition {

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

    static int searchPosition(Node head, int key) {
        int pos = 1;
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return pos;
            temp = temp.next;
            pos++;
        }
        return -1;
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
        Node head = createList(new int[]{11, 22, 33, 44, 55});
        int target = 33;

        System.out.print("List: ");
        display(head);

        int position = searchPosition(head, target);
        if (position == -1) {
            System.out.println(target + " not found in the list.");
        } else {
            System.out.println(target + " found at position: " + position);
        }
    }
}
