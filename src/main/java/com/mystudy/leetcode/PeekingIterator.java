package com.mystudy.leetcode;

import java.util.Iterator;

/**
 * Created by tianyuzhi on 16/8/24.
 */
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter = null;
    private Integer peek;
    private boolean shouldEndFetch = false;
    private boolean shouldEndIter = false;
    private boolean hasElement = false;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter == null) {
            shouldEndFetch = true;
            shouldEndIter = true;
            hasElement = false;
        }
        else {
            shouldEndFetch = !iter.hasNext();
            if (!shouldEndFetch) {
                peek = iter.next();
                hasElement = true;
            }
            else {
                hasElement = false;
            }
            shouldEndIter = iter.hasNext();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (hasElement) {
            return peek;
        }
        else {
            throw new RuntimeException();
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasElement) {
            Integer ret = peek;
            shouldEndFetch = !iter.hasNext();
            if (!shouldEndFetch) {
                peek = iter.next();
                hasElement = true;
            }
            else {
                hasElement = false;
            }
            shouldEndIter = iter.hasNext();
            return ret;
        }
        else {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean hasNext() {
        return hasElement;
    }
}
