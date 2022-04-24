import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode begin = head;
        while (begin !=  null){

            list.add(begin.val);
            begin = begin.next;
        }
        int front = 0;
        int back = list.size() - 1;
        while (front < back){
            if (!list.get(front).equals(list.get(back))){
              return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
