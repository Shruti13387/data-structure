import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MinStack {

    List<Integer> minList;
    /** initialize your data structure here. */
    public MinStack() {
        minList = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        minList.add(x);
    }
    
    public void pop() {
        minList.remove(minList.size()-1);
    }
    
    public int top() {
        return minList.get(minList.size()-1);
    }
    
    public int getMin() {
        List<Integer> temp = minList;
        Collections.sort(temp);
        return temp.get(0);
    }
}
