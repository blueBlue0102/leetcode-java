final class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  void print() {
    ListNode pointer = this;
    while (pointer != null) {
      System.out.printf("%d, ", pointer.val);
      pointer = pointer.next;
    }
    System.out.println("");
  }
}

public class App {

  public static void main(String[] args) throws Exception {
    ListNode head = new ListNode(1,
        new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
    int val = 6;

    ListNode result = removeElements(head, val);
    result.print();
  }

  private static ListNode removeElements(ListNode head, int val) {
    while (head != null && head.val == val) {
      head = head.next;
    }

    ListNode pointer = head;
    while (pointer != null) {
      if (pointer.next != null && pointer.next.val == val) {
        pointer.next = pointer.next.next;
      } else {
        pointer = pointer.next;
      }
    }
    return head;
  }

}
