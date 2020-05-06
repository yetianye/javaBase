package ThreadSych.demo3;

import java.util.Date;

public class SingleSynchronized {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = {new AddStudentThread(), new DecStudentThread(), new AddTeacherThread(), new DecTeacherThread() };

        long start = new Date().getTime();

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println(Counter.studentCount);
        System.out.println(Counter.teacherCount);

        long end = new Date().getTime();
        System.out.println("执行时间："+(end-start));

    }
}

class Counter {
    static final Object lock = new Object();
    static  int studentCount = 0;
    static  int teacherCount = 0;
}

class AddStudentThread extends Thread {
    public void run() {
        for (int i=0; i<100000; i++) {
            synchronized(Counter.lock) {
                Counter.studentCount += 1;
            }
        }
    }
}

class DecStudentThread extends Thread {
    public void run() {
        for (int i=0; i<100000; i++) {
            synchronized(Counter.lock) {
                Counter.studentCount -= 1;
            }
        }
    }
}

class AddTeacherThread extends Thread {
    public void run() {
        for (int i=0; i<100000; i++) {
            synchronized(Counter.lock) {
                Counter.teacherCount += 1;
            }
        }
    }
}

class DecTeacherThread extends Thread {
    public void run() {
        for (int i=0; i<100000; i++) {
            synchronized(Counter.lock) {
                Counter.teacherCount -= 1;
            }
        }
    }
}
