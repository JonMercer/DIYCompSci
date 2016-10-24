package data_structure;

/**
 * Created by Odin on 2016-10-23.
 */
public class DIYQueueImpl implements DIYQueue {
    private String[] arr;
    private int head = 0;
    private int tail = 0;
    private int maxQueueSize;


    public DIYQueueImpl(int maxQueueSize) {
        arr = new String[maxQueueSize];
        this.maxQueueSize = maxQueueSize;
    }

    @Override
    public void enqueue(String s) {
        if (s == null) {
            return; //Throw an error instead?
        }

        if (arr[head] == null) {
            arr[head] = s;
            return;
        }

        if ((head + 1) % maxQueueSize == tail) {
            System.out.println("Queue is full");
            return;
        }


        if (arr[head] != null) {
            head = (head + 1) % maxQueueSize;
            arr[head] = s;
        }
    }

    @Override
    public String dequeue() {
        if (arr[tail] == null) {
            return null;
        }

        if (tail == head) {
            String temp = arr[tail];
            arr[tail] = null;
            return temp;
        }

        String temp = arr[tail];
        arr[tail] = null;
        tail = (tail + 1) % maxQueueSize;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return arr[tail] == null;
    }

    @Override
    public int size() {
        if (arr[tail] == null) {
            return 0;
        }
        if (tail == head) {
            return 1;
        } else if (tail > head) {
            return maxQueueSize - tail + head + 1;
        } else {
            return head - tail + 1;
        }
    }
}
