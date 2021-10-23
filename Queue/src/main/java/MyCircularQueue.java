class MyCircularQueue {

    private int front;
    private int rear;
    private int[] data;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        data = new int[k];
        front = -1;
        rear = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (!isFull()) {
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % data.length;
            data[rear] = value;
            return true;
        }
        return false;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (!isEmpty()) {
            if(front == rear){
                front = -1;
                rear = -1;
                return true;
            }
            front = (front + 1) % data.length;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[rear];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return ((rear + 1) % data.length) == front;
        /*int full = rear - front;
        if (Math.abs(full) == data.length - 1) {
            return true;
        }
        return false;*/
    }
}

