package httpclientSpider;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/4/7.
 */
public class Queue {
    private LinkedList<Object> queue=new LinkedList<>();
    public void enQueue(Object o){
        queue.addLast(o);
    }
    public Object deQueue(){
        return queue.removeFirst();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public boolean contains(Object o){
        return queue.contains(o);
    }
}
