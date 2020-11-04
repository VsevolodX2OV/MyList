package com.jetbrains;

public class MyList {

    class Item {
        private int value;
        private Item next;

        public Item(int value) {
            this.value = value;
            this.next = null;
        }

        public boolean hasNext() {
            if (this.next != null) {
                return true;
            } else {
                return false;
            }
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Item getNext() {
            return next;
        }

        public void setNext(Item next) {
            this.next = next;
        }

        public String toString() {
            return Long.toString(this.value);
        }
    }

    private Item begin;
    private long calculator;

    public MyList() {
        this.begin = null;
        this.calculator = 0;
    }

    public long getCalculator() {
        return calculator;
    }

    public void add(int value) {
        Item item = new Item(value);
        if (this.begin == null) {
            this.begin = item;
        } else {
            end().setNext(item);
        }
        this.calculator++;
    }

    public Item end() {
        if (this.begin == null) {
            return null;
        }
        Item iter = this.begin;
        while (iter.hasNext()) {
            iter = iter.getNext();
        }
        return iter;

    }

    public String toString() {
        String result = "[ ";
        if (this.begin == null) {
            return null;
        } else {
            Item iter = this.begin;
            while (iter.hasNext()) {
                result += iter.toString() + ", ";
                iter = iter.getNext();
            }
            result += iter.toString();
        }
        result += " ]";
        return result;

    }

    public Item indexAt(int index) {
        if ((index <= this.calculator - 1) & (index >= 0)) {
            Item iter = this.begin;
            for (; index > 0; --index) {
                iter = iter.getNext();
            }
            return iter;
        } else
            return null;
    }

    public void swap(int firstPos, int secondPos) {
        if (firstPos > secondPos) {
            int tmp = firstPos;
            firstPos = secondPos;
            secondPos = tmp;
        }
        if (firstPos >= 0) {
            Item signOneBefore = indexAt(firstPos - 1);
            Item signOne = this.indexAt(firstPos);
            Item signOneAfter = this.indexAt(firstPos + 1);
            Item signTwoBefore = this.indexAt(secondPos - 1);
            Item signTwo = this.indexAt(secondPos);
            Item signTwoAfter = this.indexAt(secondPos + 1);

            signOne.setNext(signTwoAfter);
            if (signOneBefore != null)
                signOneBefore.setNext(signTwo);
            else
                this.begin = signTwo;
            if (signTwoBefore != signOne) {
                signTwoBefore.setNext(signOne);
                signTwo.setNext(signOneAfter);
            } else {
                signTwo.setNext(signOne);
            }
        }
    }

    public void sort() {
        long number = this.calculator;
        int x1;
        int x2;
        Item var1;
        Item var2;
        while (number > 0) {
            x1 = 0;
            x2 = 1;
            var1 = indexAt(x1);
            var2 = indexAt(x2);
            while (x2 < number) {
                if (var1.getValue() > var2.getValue()) {
                    swap(x1, x2);
                    x1 += 1;
                    x2 += 1;
                    var1 = indexAt(x1);
                    var2 = indexAt(x2);
                } else if (var1.getValue() <= var2.getValue()) {
                    ++x1;
                    ++x2;
                    var1 = var1.getNext();
                    var2 = var2.getNext();
                }
            }
            --number;
        }
    }
}
