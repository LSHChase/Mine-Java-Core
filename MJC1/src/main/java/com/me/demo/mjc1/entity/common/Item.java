
package com.me.demo.mjc1.entity.common;

import java.util.Objects;

public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    public Item(String desc, int partNum) {
        this.description = desc;
        this.partNumber = partNum;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[description=" + description + ", partNumber=" + partNumber + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Item objItem = (Item) obj;
        return Objects.equals(description, objItem.description) && partNumber == objItem.partNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNumber, o.partNumber);
        return diff != 0? diff: description.compareTo(o.description);
    }
}
