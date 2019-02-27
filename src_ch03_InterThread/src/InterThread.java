// Iter-communication between the Threads
// Telusko: Java Multithreading
class Q {
    int num;
    boolean valueSet = false;

    // Need synchronized keyword for both wait() and notify
    public synchronized void put (int num) {
        // when the value is set, always wait.
        // wait for consumer to consumer the value.
        while (valueSet) {
            // When you are in wait state, someone will notfiy you some time.
            try { wait(); } catch (Exception e) {}
        }
        // It valueSet is not set, we are going to set the data,
        System.out.println ("Put: " + num);
        this.num = num;
        // the the flag to true after write and notifu others.
        valueSet = true;
        notify(); // This notify notify consumer
    }
    public synchronized void get () {
        // If everything is not set, just wait.
        while (!valueSet) {
            try { wait(); } catch (Exception e) {}
        }// otherwsie, we will print the message
        System.out.println ("Get: " + num);
        // Set the flag to false after read and notify others.
        valueSet = false;
        notify(); // This notify notify producer
    }
}

class Producer implements Runnable {
    Q q;
    public Producer(Q q) {
        this.q = q;
        // Producer run needs the Thread.
        Thread t = new Thread (this, "Producer");
        t.start();
    }
    public void run () {
        int i = 0;
        while (true) {
            q.put (i++);
            try { Thread.sleep (1000); } catch (Exception e) {}
        }
    }
}

class Consumer implements Runnable {
    Q q;
    public Consumer(Q q) {
        this.q = q;
        Thread t = new Thread (this, "Consumer");
        t.start();
    }
    public void run () {
        while (true) {
            q.get();
            try { Thread.sleep (1000); } catch (Exception e) {}
        }

    }
}

public class InterThread {
    public static void main (String[] args) {
        Q q = new Q();
        new Producer (q);
        new Consumer (q);


    }
}
