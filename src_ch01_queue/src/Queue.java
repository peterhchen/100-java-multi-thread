class QNode {
    int key;
    QNode next;
    public QNode (int key) {
        this.key = key;
        this.next = null;
    }
}
public class Queue {
    QNode front, rear;
    public Queue () {
        this.front = this.rear = null;
    }
    void enqueue (int key) {
        QNode temp = new QNode (key);
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }
    QNode dequeue () {
        if (this.front == null)
            return null;
        QNode temp = this.front;
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;
        return temp;
    }
    QNode peek () {
        if (this.front == null)
            return null;
        QNode temp = this.front;
        if (this.front == null)
            this.rear = null;
        return temp;
    }
}
