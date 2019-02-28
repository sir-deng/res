package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a implements Comparable<a> {
    public boolean iu = false;
    public int mPriority = Integer.MAX_VALUE;
    public long mQV = 0;
    public long mQW = 0;
    public List<a> mQX;
    public Object mQY;

    public class a {
        public String mQZ;
        public long timestamp;
    }

    public abstract boolean execute();

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.mPriority - ((a) obj).mPriority;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public boolean isCancelled() {
        return this.iu;
    }

    public int getId() {
        return -1;
    }

    public final void BL(String str) {
        if (this.mQX == null) {
            this.mQX = new ArrayList();
        }
        a aVar = new a();
        aVar.mQZ = str;
        aVar.timestamp = System.currentTimeMillis();
        this.mQX.add(aVar);
    }

    public String getName() {
        return "";
    }

    public String adF() {
        return "";
    }
}
