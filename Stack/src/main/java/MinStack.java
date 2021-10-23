import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MinStack {

    List<Integer[]> minList;
    /** initialize your data structure here. */
    public MinStack() {
        minList = new ArrayList<Integer[]>();
    }

    public void push(int x) {
       if(!minList.isEmpty() && getMin() < x){
           minList.add(new Integer[]{x,getMin()});
        }else {
           minList.add(new Integer[]{x, x});
       }
    }

    public void pop() {
        minList.remove(minList.size()-1);
    }

    public int top() {
        return minList.get(minList.size()-1)[0];
    }

    public int getMin() {
        return minList.get(minList.size()-1)[1];
    }

}
