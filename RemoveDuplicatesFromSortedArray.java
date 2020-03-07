import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * @author fomeiherz
 * @date 2020/3/7 16:27
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        // 数组为null
        new RemoveDuplicatesFromSortedArray().execute(null);
        // 数组为空
        new RemoveDuplicatesFromSortedArray().execute(new int[]{});
        // 数组长度为1
        new RemoveDuplicatesFromSortedArray().execute(new int[]{0});
        // 数组长度为2
        new RemoveDuplicatesFromSortedArray().execute(new int[]{0, 0});
        new RemoveDuplicatesFromSortedArray().execute(new int[]{0, 0, 1});
        new RemoveDuplicatesFromSortedArray().execute(new int[]{0, 0, 1, 1});
        new RemoveDuplicatesFromSortedArray().execute(new int[]{0, 0, 1, 2});
        new RemoveDuplicatesFromSortedArray().execute(new int[]{0, 0, 1, 2, 2, 3, 4, 5, 5});
        new RemoveDuplicatesFromSortedArray().execute(new int[]{1,1,2});
        new RemoveDuplicatesFromSortedArray().execute(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
    
    private void execute(int[] nums) {
        System.out.println("---------------------------------");
        System.out.println("origin: " + Arrays.toString(nums));
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = removeDuplicates(nums);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println("\nlength: " + len);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        // 没有元素或者1个元素都返回本身长度即可
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int point = 1;
        // 从第1个开始遍历
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[point++] = nums[i];
            }
        }
        return point;
    }
    
}
