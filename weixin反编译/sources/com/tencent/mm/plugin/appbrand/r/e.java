package com.tencent.mm.plugin.appbrand.r;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.d.d;
import java.util.LinkedList;
import java.util.Queue;

public abstract class e<Task> extends d {
    final b jXC = new b();
    private final a jXD = new a();
    final String jXE;
    public final Queue<Task> jXF = new LinkedList();

    private final class a extends com.tencent.mm.plugin.appbrand.report.d {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final boolean j(Message message) {
            if (2 != message.what) {
                return super.j(message);
            }
            e.this.b(e.this.jXC);
            return true;
        }

        public final String getName() {
            return e.this.jXE + "|StateExecuting";
        }
    }

    private final class b extends com.tencent.mm.plugin.appbrand.report.d {
        private b() {
        }

        /* synthetic */ b(e eVar, byte b) {
            this();
        }

        public final void enter() {
            super.enter();
            e.a(e.this);
        }

        public final boolean j(Message message) {
            if (1 != message.what && 2 != message.what) {
                return super.j(message);
            }
            e.a(e.this);
            return true;
        }

        public final String getName() {
            return e.this.jXE + "|StateIdle";
        }
    }

    public abstract boolean afU();

    public abstract void bd(Task task);

    static /* synthetic */ void a(e eVar) {
        Object poll;
        synchronized (eVar.jXF) {
            poll = eVar.jXF.poll();
        }
        if (poll != null) {
            eVar.b(eVar.jXD);
            eVar.bd(poll);
        }
    }

    public e(String str, Looper looper) {
        super(str, looper);
        this.jXE = str;
        a(this.jXC);
        a(this.jXD);
        b(this.jXC);
        start();
    }

    protected final void ZQ() {
        super.ZQ();
        synchronized (this.jXF) {
            this.jXF.clear();
        }
    }
}
