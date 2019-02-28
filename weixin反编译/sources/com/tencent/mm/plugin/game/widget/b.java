package com.tencent.mm.plugin.game.widget;

import java.util.LinkedList;

public final class b<E> extends LinkedList<E> {
    private a nDI;

    public interface a {
        void aPI();

        void aPJ();
    }

    public b(a aVar) {
        this.nDI = aVar;
    }

    public final synchronized E pop() {
        E pop;
        pop = super.pop();
        if (this.nDI != null) {
            this.nDI.aPJ();
        }
        return pop;
    }

    public final void push(E e) {
        super.push(e);
        if (this.nDI != null) {
            this.nDI.aPI();
        }
    }
}
