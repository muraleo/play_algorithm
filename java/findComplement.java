public class Solution {
    public int findComplement(int num) {
        int mask = ((Integer.highestOneBit(num)<<1)-1);
        return ~num & mask;
    }
}
//details in http://blog.csdn.net/xiaochunyong/article/details/7748713