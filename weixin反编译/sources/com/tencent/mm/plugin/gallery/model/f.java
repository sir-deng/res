package com.tencent.mm.plugin.gallery.model;

import java.util.LinkedList;

public final class f<E> extends LinkedList<E> {
    private byte[] gUq = new byte[0];

    public final E aOE() {
        E poll;
        synchronized (this.gUq) {
            if (size() > 0) {
                poll = super.poll();
            } else {
                poll = null;
            }
        }
        return poll;
    }

    public final boolean bu(E e) {
        boolean contains;
        synchronized (this.gUq) {
            contains = super.contains(e);
        }
        return contains;
    }

    public final void bv(E e) {
        synchronized (this.gUq) {
            if (bu(e)) {
                super.remove(e);
            }
        }
    }

    public final boolean add(E e) {
        boolean add;
        synchronized (this.gUq) {
            add = super.add(e);
        }
        return add;
    }

    public final int size() {
        int size;
        synchronized (this.gUq) {
            size = super.size();
        }
        return size;
    }
}
