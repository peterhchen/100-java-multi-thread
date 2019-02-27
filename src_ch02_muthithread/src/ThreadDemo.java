// Create thread by two ways:
// One by extends the Thread.
// Another one by implementing interface Runnable

class A {}

//class Hi {
//class Hi extends Thread {
class Hi extends A implements Runnable {
    // public void show () {
    public void run () {
        for (int i =1; i <=5; i++){
            System.out.println ("Hi");
            try { Thread.sleep (500); // sleep 0.5 sec
            } catch (Exception e) {}
        }
    }
}

//class Hello {
//class Hello extends Thread {
class Hello implements Runnable {
    //public void show () {
    public void run () {
        for (int i =1; i <=5; i++) {
            System.out.println("Hello");
            try { Thread.sleep (500); // sleep 0.5 sec
            } catch (Exception e) {}
        }

    }

}
public class ThreadDemo {
    public static void main (String[] args) {
        //System.out.println ("Good");

        /*
        // The following code run sequentially.
        Hi obj1 = new Hi();
        Hello obj2 = new Hello ();
        obj1.show();
        obj2.show();
        */
        /*
        Hi obj1 = new Hi();
        Hello obj2 = new Hello ();

        // We do not have start () in Runnable

        obj1.start ();
        try { Thread.sleep (50); // sleep 0.05 sec
        } catch (Exception e) {}
        obj2.start ();
        // We do not need to call run. the start will trigger the run() automatically.
        //obj1.run ();
        //obj2.run ();
*/
        // How to link the thread with run?
        Runnable obj1 = new Hi ();
        Runnable obj2 = new Hello ();
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start ();
        try { Thread.sleep (50); // sleep 0.05 sec
        } catch (Exception e) {}
        t2.start ();


    }
}
