package com.tencent.mm.sdk.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

public class d {
    public String mName;
    public volatile c xrk;
    volatile HandlerThread xrl;

    public static class a {
        private d xrm;
        private long xrn;
        private int xro;
        private String xrp;
        private a xrq;
        private a xrr;
        private a xrs;

        a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            a(dVar, message, str, aVar, aVar2, aVar3);
        }

        public final void a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            this.xrm = dVar;
            this.xrn = System.currentTimeMillis();
            this.xro = message != null ? message.what : 0;
            this.xrp = str;
            this.xrq = aVar;
            this.xrr = aVar2;
            this.xrs = aVar3;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("time=");
            Calendar.getInstance().setTimeInMillis(this.xrn);
            stringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{r0, r0, r0, r0, r0, r0}));
            stringBuilder.append(" processed=");
            stringBuilder.append(this.xrq == null ? "<null>" : this.xrq.getName());
            stringBuilder.append(" org=");
            stringBuilder.append(this.xrr == null ? "<null>" : this.xrr.getName());
            stringBuilder.append(" dest=");
            stringBuilder.append(this.xrs == null ? "<null>" : this.xrs.getName());
            stringBuilder.append(" what=");
            Object obj = this.xrm != null ? null : "";
            if (TextUtils.isEmpty(obj)) {
                stringBuilder.append(this.xro);
                stringBuilder.append("(0x");
                stringBuilder.append(Integer.toHexString(this.xro));
                stringBuilder.append(")");
            } else {
                stringBuilder.append(obj);
            }
            if (!TextUtils.isEmpty(this.xrp)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.xrp);
            }
            return stringBuilder.toString();
        }
    }

    private static class b {
        private int mCount;
        private Vector<a> xrt;
        private int xru;
        private int xrv;
        private boolean xrw;

        /* synthetic */ b(byte b) {
            this();
        }

        private b() {
            this.xrt = new Vector();
            this.xru = 20;
            this.xrv = 0;
            this.mCount = 0;
            this.xrw = false;
        }

        final synchronized boolean chv() {
            return this.xrw;
        }

        final synchronized void cleanup() {
            this.xrt.clear();
        }

        final synchronized void b(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            this.mCount++;
            if (this.xrt.size() < this.xru) {
                this.xrt.add(new a(dVar, message, str, aVar, aVar2, aVar3));
            } else {
                a aVar4 = (a) this.xrt.get(this.xrv);
                this.xrv++;
                if (this.xrv >= this.xru) {
                    this.xrv = 0;
                }
                aVar4.a(dVar, message, str, aVar, aVar2, aVar3);
            }
        }
    }

    private static class c extends Handler {
        private static final Object xry = new Object();
        private boolean jMT;
        private b xrA;
        private boolean xrB;
        private c[] xrC;
        private int xrD;
        private c[] xrE;
        private int xrF;
        private a xrG;
        private b xrH;
        private HashMap<c, c> xrI;
        private c xrJ;
        private c xrK;
        private ArrayList<Message> xrL;
        private d xrm;
        private boolean xrx;
        private Message xrz;

        private class a extends c {
            private a() {
            }

            /* synthetic */ a(c cVar, byte b) {
                this();
            }

            public final boolean j(Message message) {
                c.this.xrm;
                return true;
            }
        }

        private class b extends c {
            private b() {
            }

            /* synthetic */ b(c cVar, byte b) {
                this();
            }

            public final boolean j(Message message) {
                return false;
            }
        }

        private class c {
            boolean ahf;
            c xrN;
            c xrO;

            private c() {
            }

            /* synthetic */ c(c cVar, byte b) {
                this();
            }

            public final String toString() {
                String str;
                StringBuilder append = new StringBuilder("state=").append(this.xrN.getName()).append(",active=").append(this.ahf).append(",parent=");
                if (this.xrO == null) {
                    str = "null";
                } else {
                    str = this.xrO.xrN.getName();
                }
                return append.append(str).toString();
            }
        }

        /* synthetic */ c(Looper looper, d dVar, byte b) {
            this(looper, dVar);
        }

        static /* synthetic */ void b(c cVar, c cVar2) {
            if (cVar.xrx) {
                new StringBuilder("setInitialState: initialState=").append(cVar2.getName());
            }
            cVar.xrJ = cVar2;
        }

        static /* synthetic */ void f(c cVar) {
            int i = 0;
            for (c cVar2 : cVar.xrI.values()) {
                int i2 = 0;
                c cVar22;
                while (cVar22 != null) {
                    cVar22 = cVar22.xrO;
                    i2++;
                }
                if (i >= i2) {
                    i2 = i;
                }
                i = i2;
            }
            if (cVar.xrx) {
                cVar.xrC = new c[i];
                cVar.xrE = new c[i];
                cVar.chy();
                cVar.sendMessageAtFrontOfQueue(cVar.obtainMessage(-2, xry));
            } else {
                cVar.xrC = new c[i];
                cVar.xrE = new c[i];
                cVar.chy();
                cVar.sendMessageAtFrontOfQueue(cVar.obtainMessage(-2, xry));
            }
        }

        public final void handleMessage(Message message) {
            if (!this.jMT) {
                if (this.xrx) {
                    new StringBuilder("handleMessage: E msg.what=").append(message.what);
                }
                this.xrz = message;
                c cVar = null;
                if (this.xrB) {
                    cVar = s(message);
                } else if (!this.xrB && this.xrz.what == -2 && this.xrz.obj == xry) {
                    this.xrB = true;
                    DC(0);
                } else {
                    throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + message);
                }
                a(cVar, message);
            }
        }

        private void a(c cVar, Message message) {
            b bVar;
            a aVar = this.xrC[this.xrD].xrN;
            boolean z = this.xrm.h(this.xrz) && message.obj != xry;
            if (this.xrA.chv()) {
                if (this.xrK != null) {
                    this.xrA.b(this.xrm, this.xrz, "", cVar, aVar, this.xrK);
                }
            } else if (z) {
                this.xrA.b(this.xrm, this.xrz, "", cVar, aVar, this.xrK);
            }
            c cVar2 = this.xrK;
            if (cVar2 != null) {
                while (true) {
                    bVar = cVar2;
                    this.xrF = 0;
                    c cVar3 = (c) this.xrI.get(bVar);
                    do {
                        c[] cVarArr = this.xrE;
                        int i = this.xrF;
                        this.xrF = i + 1;
                        cVarArr[i] = cVar3;
                        cVar3 = cVar3.xrO;
                        if (cVar3 == null) {
                            break;
                        }
                    } while (!cVar3.ahf);
                    if (this.xrx) {
                        new StringBuilder("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=").append(this.xrF).append(",curStateInfo: ").append(cVar3);
                    }
                    a(cVar3);
                    DC(chx());
                    chw();
                    if (bVar == this.xrK) {
                        break;
                    }
                    cVar2 = this.xrK;
                }
                this.xrK = null;
            } else {
                c bVar2 = cVar2;
            }
            if (bVar2 != null && bVar2 == this.xrH) {
                this.xrm.ZQ();
                if (this.xrm.xrl != null) {
                    getLooper().quit();
                    this.xrm.xrl = null;
                }
                this.xrm.xrk = null;
                this.xrm = null;
                this.xrz = null;
                this.xrA.cleanup();
                this.xrC = null;
                this.xrE = null;
                this.xrI.clear();
                this.xrJ = null;
                this.xrK = null;
                this.xrL.clear();
                this.jMT = true;
            }
        }

        private final c s(Message message) {
            c cVar = this.xrC[this.xrD];
            if (this.xrx) {
                new StringBuilder("processMsg: ").append(cVar.xrN.getName());
            }
            Object obj = (message.what == -1 && message.obj == xry) ? 1 : null;
            if (obj != null) {
                b(this.xrH);
            } else {
                while (!cVar.xrN.j(message)) {
                    cVar = cVar.xrO;
                    if (cVar == null) {
                        this.xrm.i(message);
                        break;
                    } else if (this.xrx) {
                        new StringBuilder("processMsg: ").append(cVar.xrN.getName());
                    }
                }
            }
            if (cVar != null) {
                return cVar.xrN;
            }
            return null;
        }

        private final void a(c cVar) {
            while (this.xrD >= 0 && this.xrC[this.xrD] != cVar) {
                c cVar2 = this.xrC[this.xrD].xrN;
                if (this.xrx) {
                    new StringBuilder("invokeExitMethods: ").append(cVar2.getName());
                }
                cVar2.exit();
                this.xrC[this.xrD].ahf = false;
                this.xrD--;
            }
        }

        private final void DC(int i) {
            while (i <= this.xrD) {
                if (this.xrx) {
                    new StringBuilder("invokeEnterMethods: ").append(this.xrC[i].xrN.getName());
                }
                this.xrC[i].xrN.enter();
                this.xrC[i].ahf = true;
                i++;
            }
        }

        private final void chw() {
            for (int size = this.xrL.size() - 1; size >= 0; size--) {
                Message message = (Message) this.xrL.get(size);
                if (this.xrx) {
                    new StringBuilder("moveDeferredMessageAtFrontOfQueue; what=").append(message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.xrL.clear();
        }

        private final int chx() {
            int i = this.xrD + 1;
            int i2 = i;
            for (int i3 = this.xrF - 1; i3 >= 0; i3--) {
                if (this.xrx) {
                    new StringBuilder("moveTempStackToStateStack: i=").append(i3).append(",j=").append(i2);
                }
                this.xrC[i2] = this.xrE[i3];
                i2++;
            }
            this.xrD = i2 - 1;
            if (this.xrx) {
                new StringBuilder("moveTempStackToStateStack: X mStateStackTop=").append(this.xrD).append(",startingIndex=").append(i).append(",Top=").append(this.xrC[this.xrD].xrN.getName());
            }
            return i;
        }

        private final void chy() {
            if (this.xrx) {
                new StringBuilder("setupInitialStateStack: E mInitialState=").append(this.xrJ.getName());
            }
            c cVar = (c) this.xrI.get(this.xrJ);
            this.xrF = 0;
            while (cVar != null) {
                this.xrE[this.xrF] = cVar;
                cVar = cVar.xrO;
                this.xrF++;
            }
            this.xrD = -1;
            chx();
        }

        private final c a(c cVar, c cVar2) {
            if (this.xrx) {
                new StringBuilder("addStateInternal: E state=").append(cVar.getName()).append(",parent=");
            }
            c cVar3 = (c) this.xrI.get(cVar);
            if (cVar3 == null) {
                cVar3 = new c();
                this.xrI.put(cVar, cVar3);
            }
            if (cVar3.xrO == null || cVar3.xrO == null) {
                cVar3.xrN = cVar;
                cVar3.xrO = null;
                cVar3.ahf = false;
                if (this.xrx) {
                    new StringBuilder("addStateInternal: X stateInfo: ").append(cVar3);
                }
                return cVar3;
            }
            throw new RuntimeException("state already added");
        }

        private c(Looper looper, d dVar) {
            super(looper);
            this.jMT = false;
            this.xrx = false;
            this.xrA = new b();
            this.xrD = -1;
            this.xrG = new a();
            this.xrH = new b();
            this.xrI = new HashMap();
            this.xrL = new ArrayList();
            this.xrm = dVar;
            a(this.xrG, null);
            a(this.xrH, null);
        }

        private final void b(a aVar) {
            this.xrK = (c) aVar;
            if (this.xrx) {
                new StringBuilder("transitionTo: destState=").append(this.xrK.getName());
            }
        }
    }

    public d(String str, Looper looper) {
        this.mName = str;
        this.xrk = new c(looper, this, (byte) 0);
    }

    public final void a(c cVar) {
        this.xrk.a(cVar, null);
    }

    public final void b(c cVar) {
        c.b(this.xrk, cVar);
    }

    public final Message cht() {
        c cVar = this.xrk;
        if (cVar == null) {
            return null;
        }
        return cVar.xrz;
    }

    public final a chu() {
        c cVar = this.xrk;
        if (cVar == null) {
            return null;
        }
        return cVar.xrC[cVar.xrD].xrN;
    }

    public final void b(a aVar) {
        this.xrk.b(aVar);
    }

    public void i(Message message) {
        if (this.xrk.xrx) {
            new StringBuilder(" - unhandledMessage: msg.what=").append(message.what);
        }
    }

    public void ZQ() {
    }

    public boolean h(Message message) {
        return true;
    }

    private Message obtainMessage(int i) {
        return Message.obtain(this.xrk, i);
    }

    public final void DA(int i) {
        c cVar = this.xrk;
        if (cVar != null) {
            cVar.sendMessage(obtainMessage(i));
        }
    }

    public final void DB(int i) {
        c cVar = this.xrk;
        if (cVar != null) {
            cVar.sendMessageAtFrontOfQueue(obtainMessage(i));
        }
    }

    public final void quit() {
        c cVar = this.xrk;
        if (cVar != null) {
            cVar.sendMessage(cVar.obtainMessage(-1, c.xry));
        }
    }

    public void start() {
        c cVar = this.xrk;
        if (cVar != null) {
            c.f(cVar);
        }
    }
}
