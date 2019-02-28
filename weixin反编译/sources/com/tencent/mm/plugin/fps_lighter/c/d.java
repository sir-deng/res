package com.tencent.mm.plugin.fps_lighter.c;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public final class d {
    public int axZ;
    public int hUW;
    public long mHf;
    public boolean mHg;
    public long mHh;
    public long mHi;
    public List<String> mHm;
    public List<String> mHn;
    public long mHo;
    public a mHp;
    public Stack<Long> mHq = new Stack();

    public d(a aVar, c cVar) {
        this.mHm = cVar.mHm;
        this.mHn = cVar.mHn;
        this.mHh = cVar.mHh;
        this.mHi = cVar.mHi;
        this.mHo = cVar.mHo;
        this.axZ = cVar.axZ;
        this.hUW = cVar.hUW;
        this.mHp = aVar;
        this.mHf = aVar.mHf;
        this.mHg = aVar.mHg;
    }

    public final void du(long j) {
        this.mHq.push(Long.valueOf(j));
    }

    public final void a(Stack<Long> stack) {
        this.mHq.clear();
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            this.mHq.push(Long.valueOf(((Long) it.next()).longValue()));
        }
    }

    public final String aLy() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mHi);
        stringBuilder.append(" > ");
        ListIterator listIterator = this.mHq.listIterator(this.mHq.size());
        while (listIterator.hasPrevious()) {
            stringBuilder.append(listIterator.previous());
            stringBuilder.append(" > ");
        }
        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        return stringBuilder.toString();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("\t");
        stringBuilder.append("scene:");
        stringBuilder.append(this.mHp.scene);
        stringBuilder.append(" ");
        stringBuilder.append("preMs:");
        stringBuilder.append(this.mHp.mHa);
        stringBuilder.append(" ");
        stringBuilder.append("dropCount:");
        stringBuilder.append(this.mHp.mHc);
        stringBuilder.append(" ");
        stringBuilder.append("dropTime:");
        stringBuilder.append(this.mHp.aLw());
        stringBuilder.append(" ");
        stringBuilder.append("cpu:");
        stringBuilder.append(this.mHp.mHd + "%");
        stringBuilder.append(" ");
        stringBuilder.append("isOnCreate:");
        stringBuilder.append(this.mHp.mHb);
        stringBuilder.append(" ");
        stringBuilder.append("methodId:");
        stringBuilder.append(this.mHi);
        stringBuilder.append(" ");
        stringBuilder.append("costTime:");
        stringBuilder.append(this.mHo);
        stringBuilder.append(" ");
        stringBuilder.append("percent:");
        stringBuilder.append(Math.round(((((double) this.mHo) * 1.0d) / ((double) this.mHp.aLw())) * 100.0d) + "%");
        stringBuilder.append(" ");
        stringBuilder.append("exec num:");
        stringBuilder.append(this.hUW);
        stringBuilder.append(" ");
        stringBuilder.append("inputHandlingTime:");
        stringBuilder.append(this.mHf);
        stringBuilder.append(" ");
        stringBuilder.append("isInputHandling:");
        stringBuilder.append(this.mHg);
        stringBuilder.append(" ");
        stringBuilder.append("stack:");
        stringBuilder.append(aLy());
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.mHi == this.mHi && this.mHq.size() == dVar.mHq.size()) {
                int i = 0;
                while (i < this.mHq.size() && this.mHq.elementAt(i) == dVar.mHq.elementAt(i)) {
                    i++;
                }
            }
        }
        return false;
    }
}
