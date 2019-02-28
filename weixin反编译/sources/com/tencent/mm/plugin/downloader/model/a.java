package com.tencent.mm.plugin.downloader.model;

import java.util.HashSet;

public final class a<E> extends HashSet<E> {
    private q lxq;

    public a(q qVar) {
        this.lxq = qVar;
    }

    private synchronized void aAE() {
        this.lxq.aAD();
    }

    private synchronized void aAF() {
        this.lxq.remove();
    }

    private synchronized void aAG() {
        this.lxq.clear();
    }

    public final synchronized boolean add(E e) {
        boolean add;
        add = super.add(e);
        aAE();
        return add;
    }

    public final void clear() {
        super.clear();
        aAG();
    }

    public final synchronized boolean remove(Object obj) {
        boolean remove;
        remove = super.remove(obj);
        aAF();
        return remove;
    }
}
