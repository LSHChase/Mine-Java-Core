
package com.me.demo.mjc1.chapter;

import com.me.demo.mjc1.common.MyConstant;
import com.me.demo.mjc1.entity.common.Item;

import java.time.LocalDate;
import java.util.*;

public class Nine {
    public void mainfunction(){
//    useIterator();
//        useLinkList();
//        useHashSet();
//        useTreeSet();
        usePriorityQueue();
    }

    //list迭代器
    private void useIterator(){
        List<String> list = new ArrayList<>();
        MyConstant.addFakeDataOne(list);
        ListIterator<String> listIter = list.listIterator();

        System.out.println(list.toString());
        listIter.next();
        listIter.next();
        listIter.remove();
        System.out.println(list.toString());
    }

    //linkList，迭代器测试
    private void useLinkList(){
        List<String> listA = new LinkedList<>();
        MyConstant.addFakeDataOne(listA);
        List<String> listB = new LinkedList<>();
        MyConstant.addFakeDataOther(listB);

        ListIterator<String> aIter = listA.listIterator();
        Iterator<String> bIter = listB.listIterator();

        //merge the words from B into A
        while (bIter.hasNext()){
            if (aIter.hasNext()){
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(listA);

        //remove every second word from B
        bIter = listB.iterator();
        while (bIter.hasNext()){
            bIter.next();
            if (bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(listB);

        //bulk operation: remove all words in b from a
        listA.removeAll(listB);
        System.out.println(listA);
    }

    //HashSet
    private void useHashSet(){
        Set<String> words = new HashSet<>();
        long totalTime = 0;

        Scanner in = new Scanner(System.in);
        try  {
            while (in.hasNext() && !in.next().equals("-1")){
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i ++){
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " distinct words, " + totalTime + " milliseconds.");

    }

    //TreeSet
    private void useTreeSet(){
        SortedSet<String> sorter = new TreeSet<>();
        MyConstant.addFakeDataOne(sorter);
        System.out.println(sorter);

        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);
        NavigableSet<Item> sortByDescription = new TreeSet<>(
                Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }

    //优先级队列
    private void usePriorityQueue(){
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903, 12, 3));
        pq.add(LocalDate.of(1910, 6, 22));

        System.out.println("Iterating over elements...");
        for (LocalDate date : pq) {
            System.out.println(date);
        }
        System.out.println("Removing elements");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

}
