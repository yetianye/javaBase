package mytest;

import sun.security.util.ArrayUtil;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {

    public static void main(String[] args) {
        String aa = "";
        aa.equals("asd");

        aa.hashCode();

        Set Hashset = new HashSet<String>();

        Set linkset = new LinkedHashSet<String>();

        Set treeSet = new TreeSet();

        HashMap hashMap = new HashMap();
        hashMap.put("","");

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("123","33");

        TreeMap treeMap  =  new TreeMap<>();
        treeMap.put("","");

        Hashtable hashtable = new Hashtable();

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        ArrayList<String> list = new ArrayList<>();
        list.add("asd");

        Thread t = new Thread();
        t.start();

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

//        CyclicBarrier cyclicBarrier = new CyclicBarrier();
        int i = 0;
        System.out.println();



    }

    abstract class aaa implements Callable{

    }
}
