package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.protocal.c.bww;
import com.tencent.mm.protocal.c.bxc;
import com.tencent.mm.protocal.c.bxj;
import com.tencent.mm.protocal.c.bxn;
import com.tencent.mm.protocal.d;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class g {
    final HashMap<Integer, a> iTA = new HashMap();
    int iTB = 0;
    long iTC = 0;
    j iTf;
    final bww iTg;
    private String iTh;
    private int iTi = 0;
    private int iTj = 0;
    bxn iTk;
    h iTl;
    AtomicInteger iTm = new AtomicInteger(0);
    long iTn = 0;
    long iTo = 0;
    long iTp;
    long iTq = System.currentTimeMillis();
    AtomicInteger iTr = new AtomicInteger(0);
    private boolean iTs;
    private boolean iTt;
    final HashMap<String, Method> iTu = new HashMap();
    final HashMap<String, bxj> iTv = new HashMap();
    LinkedList<Pair<String, ValueCallback<String>>> iTw = new LinkedList();
    final LinkedList<j> iTx = new LinkedList();
    final Map<String, f> iTy = new HashMap();
    final LinkedList<bxc> iTz = new LinkedList();
    final Object mLock = new Object();
    private int mStatus = 0;

    public g(j jVar) {
        this.iTf = jVar;
        this.iTg = new bww();
        this.iTg.vWW = d.vHl;
    }

    public final synchronized String acz() {
        return this.iTh;
    }

    public final synchronized void rz(String str) {
        this.iTh = str;
    }

    public final synchronized int acA() {
        return this.iTi;
    }

    public final synchronized void jU(int i) {
        this.iTi = i;
    }

    public final synchronized int acB() {
        return this.iTj;
    }

    public final synchronized void jV(int i) {
        if (this.iTj < i) {
            this.iTj = i;
        }
    }

    public final synchronized void bA(int i, int i2) {
        if (this.iTj >= i && this.iTj <= i2) {
            this.iTj = i2;
        }
    }

    public final synchronized void eR(int i) {
        this.mStatus = i;
    }

    public final synchronized int getStatus() {
        return this.mStatus;
    }

    public final synchronized boolean isBusy() {
        return this.iTs;
    }

    public final synchronized void cw(boolean z) {
        this.iTs = z;
    }

    public final synchronized boolean it() {
        return getStatus() == 3;
    }

    public final synchronized boolean acC() {
        return this.iTt;
    }

    public final synchronized void cx(boolean z) {
        this.iTt = z;
    }

    public final boolean acD() {
        return getStatus() == 4;
    }

    public final boolean acE() {
        return this.iTl.iTH == 3;
    }
}
