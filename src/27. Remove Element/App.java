public class App {
  public static void main(String[] args) throws Exception {
    int[] nums = { 3, 2, 2, 3 };
    int val = 3;
    int expectedAnswer = 2;

    assert expectedAnswer == removeElement(nums, val) : "Fail!";
    System.out.println("Success!");
    return;
  }

  private static int removeElement(int[] nums, int val) {
    int lengthCount = 0;
    for (int num : nums) {
      if (num != val) {
        nums[lengthCount] = num;
        lengthCount += 1;
      }
    }
    return lengthCount;
  }
}
