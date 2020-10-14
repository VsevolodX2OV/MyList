package com.jetbrains;

public class MyList {
    class Item {

        private int value;
        private Item next;

        public Item (int value) {
            this.value = value;
            this.next = null;
        }
        public boolean hasNext() {
            if (this.next != null)
                return true;
            else
                return false;
        }

        public String toString() {
            return Long.toString(this.value);
        }

        public int getValue() {
            return value;
        }

        public Item getNext() {
            return next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Item next) {
            this.next = next;
        }
    }

    private Item run;
    private int count;

    public MyList() {
        this.run = null;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public Item end() {
        if (this.run == null)
            return null;
        Item iter = this.run;
        while (iter.hasNext()) {
            iter = iter.getNext();
        }
        return iter;
    }

    public void add(int value) {
        Item item = new Item(value);
        if (this.run == null)
            this.run = item;
        else
            end().setNext(item);
        this.count++;
    }

    public String toString() {
        String result = "[";
        if (this.run == null)
            return null;
        else {
            Item iter = this.run;
            while (iter.hasNext()) {
                result += iter.toString() + ",";
                iter = iter.getNext();
            }
        }
        result += "]";
        return result;
    }

    public Item indexAt(int index) {
        if ((index < this.count -1) && (index >= 0)) {
            Item x = run;
            for (; index > 0; --index) {
                x = x.getNext();
            }
            System.out.println(x);
            return x;
        }
        else
            return null;
    }

    public void swap(int firstPosit, int secondPosit ) {
        Item PositOne = indexAt(firstPosit - 1);
        Item PositOneSign = indexAt(firstPosit);
        Item PositOneAfter = indexAt(firstPosit + 1);
        Item PositTwo = indexAt(secondPosit - 1);
        Item PositTwoSign = indexAt(secondPosit);
        Item PositTwoAfter = indexAt(secondPosit + 1);
        if (PositOne != null)
            PositOne.setNext(PositTwo);
        else
            this.run = PositTwoSign;
        PositOneSign.setNext(PositTwoAfter);
        if(PositTwo == PositOneAfter) {
            PositTwoSign.setNext(PositOneSign);
        }
        else {
            PositTwoSign.setNext(PositOneAfter);
            PositTwo.setNext(PositOneSign);
        }
    }

    public void sort() {
        int z;
        int y;
        Item t1;
        Item t2;
        while (this.count > 0) {
            z = 0;
            y = 1;
            t1 = indexAt(z);
            t2 = indexAt(y);
            while (y < this.count) {
                if (t1.getValue() >t2.getValue()) {
                    swap(z,y);
                    z += 1;
                    y += 1;
                    t1 = indexAt(z);
                    t2 = indexAt(y);
                }
                else if (t1.getValue() <= t2.getValue()) {
                    ++z;
                    ++y;
                    t1 = t1.getNext();
                    t2 = t2.getNext();
                }
            }
            --this.count;
        }
    }
}
