
package com.me.demo.mjc1.chapter;

import com.me.demo.mjc1.common.MyConstant;
import com.me.demo.mjc1.entity.common.Item;
import com.me.demo.mjc1.entity.office.Employee;

import java.time.LocalDate;
import java.util.*;

public class Nine {
    public void function(){
//    useIterator();
//        useLinkList();
//        useHashSet();
//        useTreeSet();
//        usePriorityQueue();
//        useHashMap();
//        useWeakHashMap();
//        useLinkedHashSetAndMap();
        useEnumSetAndMap();
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

    //映射：散列映射HashMap，树映射TreeMap，
    private void useHashMap(){
        //映射的简单操作
        Map<String, Employee> staffMap = new HashMap<>();
        staffMap.put("1", new Employee("zhangsan", 10000, 1999, 12, 31));
        staffMap.put("2", new Employee("lisi", 12000, 2000, 1, 1));
        staffMap.put("3", new Employee("wangwu", 15000, 1996, 8, 8));
        staffMap.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));

        //更新映射：统计一个单词在文件中出现的频度
        List<String> list = new ArrayList<>();
        Map<String, Integer> updateMap = new HashMap<>();

        MyConstant.addFakeDataOne(list);
        list.forEach(word -> {
//                updateMap.put(word, updateMap.getOrDefault(word, 0) + 1));
//            updateMap.putIfAbsent(word,0);
//            updateMap.put(word, updateMap.get(word) + 1);
            updateMap.merge(word, 1, Integer::sum);
        });
        updateMap.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));

        //映射视图:3种,键集(keySet()),值集合(values()),键/值对集(entrySet())
        Set<String> keys = updateMap.keySet();
        keys.forEach(key ->
            System.out.println("key=" + key));
        updateMap.values().forEach(value ->
                System.out.println("value=" + value));
        Set<Map.Entry<String, Integer>> keyValues = updateMap.entrySet();
        keyValues.forEach( entrySet ->
                System.out.println("key=" + entrySet.getKey() + ", value=" + entrySet.getValue()));
    }

    /**
     * 弱散列映射
     */
    private void useWeakHashMap(){
        Map<String, Integer> weakHashMap = new WeakHashMap<>();
        weakHashMap.put("1", 1);
        weakHashMap.put("2", 2);
        weakHashMap.put("3", 3);
        weakHashMap.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));
    }

    /**
     * 链接散列集与映射:有顺序的
     */
    private void useLinkedHashSetAndMap(){
        Map<String, Integer> linkHashMap = new LinkedHashMap<>();
        linkHashMap.put("1", 9);
        linkHashMap.put("2", 5);
        linkHashMap.put("3", 32);
        linkHashMap.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));
        System.out.println(linkHashMap.keySet().iterator() + linkHashMap.values().iterator().toString());

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("1");
        linkedHashSet.add("2");
        linkedHashSet.add("3");
        linkedHashSet.forEach(set ->
                System.out.println("set=" + set));

        Map<String, Integer> cacheMap = new LinkedHashMap<String, Integer>(128, 0.75F, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 4;
            }
        };
        cacheMap.put("q", 1);
        cacheMap.put("w", 2);
        cacheMap.put("bb", 55);
        cacheMap.put("e", 3);
        cacheMap.put("r", 4);
        cacheMap.put("t", 5);
        cacheMap.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));
    }

    /**
     * 枚举集和映射
     */
    private void useEnumSetAndMap(){
        EnumSet<WeekDay> always = EnumSet.allOf(WeekDay.class);
        EnumSet<WeekDay> never = EnumSet.noneOf(WeekDay.class);
        EnumSet<WeekDay> workday = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        EnumSet<WeekDay> mwf = EnumSet.of(WeekDay.MONDAY, WeekDay.WEDNESDAY, WeekDay.FRIDAY);

        System.out.println("always=" + always.toString() + "\nnever" +never.toString()
                + "\nworkday=" + workday.toString() + "\nmwf" + mwf.toString());
    }
    enum WeekDay {SUNDAY, MONDAY, TUESDAT,WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};

    //TODO:9.4
}
