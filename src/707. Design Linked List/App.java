final class ListNode {
  int val;
  ListNode next;

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

final class MyLinkedList {
  ListNode dummyHead;

  MyLinkedList() {
    this.dummyHead = new ListNode(0, null);
  }

  public void print() {
    ListNode pointer = this.dummyHead.next;
    System.out.printf("[");

    while (pointer != null) {
      if (pointer.next == null)
        System.out.printf("%d", pointer.val);
      else
        System.out.printf("%d, ", pointer.val);
      pointer = pointer.next;
    }
    System.out.println("]");
  }

  public int get(int index) {
    int count = 0;
    ListNode pointer = this.dummyHead.next;
    while (pointer != null && count < index) {
      pointer = pointer.next;
      count += 1;
    }
    if (pointer == null)
      return -1;
    else
      return pointer.val;

  }

  public void addAtHead(int val) {
    ListNode newNode = new ListNode(val, null);
    if (this.dummyHead.next != null) {
      newNode.next = dummyHead.next;
    }
    this.dummyHead.next = newNode;
  }

  public void addAtTail(int val) {
    ListNode newNode = new ListNode(val, null);
    ListNode pointer = this.dummyHead;
    while (pointer.next != null) {
      pointer = pointer.next;
    }
    pointer.next = newNode;
  }

  public void addAtIndex(int index, int val) {
    ListNode newNode = new ListNode(val, null);
    // 期望 point 能指到 newNode 的前一個 node
    ListNode pointer = this.dummyHead;
    /** 當 count == index 時才能 add node */
    int count = 0;
    while (count < index) {
      if (pointer.next == null)
        return;
      pointer = pointer.next;
      count += 1;
    }
    if (pointer.next != null) {
      newNode.next = pointer.next;
    }
    pointer.next = newNode;
  }

  public void deleteAtIndex(int index) {
    // 期望 point 能指到 deletedNode 的前一個 node
    ListNode pointer = this.dummyHead;
    /** 當 count == index 時才能 delete node */
    int count = 0;
    while (count < index) {
      if (pointer.next == null)
        return;
      pointer = pointer.next;
      count += 1;
    }
    if (pointer.next != null && pointer.next.next != null) {
      pointer.next = pointer.next.next;
    } else {
      pointer.next = null;
    }
  }
}

public class App {
  public static void main(String[] args) throws Exception {
    MyLinkedList myLinkedList = new MyLinkedList();

    myLinkedList.print();
    myLinkedList.addAtTail(1);
    myLinkedList.print();
    myLinkedList.addAtTail(3);
    myLinkedList.print();
    myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
    myLinkedList.print();
    System.out.println(myLinkedList.get(1)); // return 2
    myLinkedList.deleteAtIndex(1); // now the linked list is 1->3
    myLinkedList.print();
    System.out.println(myLinkedList.get(1)); // return 3
  }
}
