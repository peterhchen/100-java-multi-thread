public class Test {
    public static void main (String[] args) {
        Queue q = new Queue();
        q.enqueue (10);
        q.enqueue (20);
        q.dequeue ();
        q.dequeue();
        q.enqueue(30);
        q.enqueue (40);
        q.enqueue (50);

        String kw;
        boolean flag = true;
        while (flag) {
            System.out.println("q.peek(): " + q.peek());
            if (q.peek() == null) {
                flag = false;
                System.out.println("exit");
                System.exit(1);
            } else {
                flag = true;
                System.out.println("Dequeued item 1 is: " + q.dequeue().key);

            }

        }
    }
}
