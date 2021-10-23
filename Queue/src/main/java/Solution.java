// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(Tree T) {
        // write your code in Java SE 8
        if(T == null){
            return 0;
        }

        if(T.l == null && T.r == null){
            return 1;
        }

        Stack<Tree> stack = new Stack<>();
        List<Integer> maxNoList = new ArrayList<>();
        int maxNum = T.x;
        stack.push(T);
        Tree temp;
        while(!stack.empty()){
            temp = stack.pop();

            if(temp.x>=maxNum){
                maxNoList.add(temp.x);
            }

            System.out.println(temp.x+"Stack Size "+stack.size());
            temp = T.r;
            if(T.r!=null){
                stack.push(T.r);
            }

            temp = T.l;
            if(T.l!=null){
                stack.push(T.l);
            }
        }
        return maxNoList.size();
    }

    class Tree{
        int x;
        Tree l;
        Tree r;
    }
}