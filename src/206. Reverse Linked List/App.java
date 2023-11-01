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

  public ListNode reverseList(ListNode head) {
    ListNode leftPointer = null;
    // right pointer = null 時結束翻轉
    ListNode rightPointer = head;
    while (rightPointer != null) {
      ListNode temp = rightPointer.next;
      rightPointer.next = leftPointer;
      leftPointer = rightPointer;
      rightPointer = temp;
    }
    return leftPointer;
  }
}

public class App {
  public static void main(String[] args) throws Exception {
    ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
    head.print();
    head = head.reverseList(head);
    head.print();
  }
}
