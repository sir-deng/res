package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.utils.V8ObjectUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

final class e extends b {
    final AtomicInteger jBy = new AtomicInteger(0);
    final HashMap<Integer, a> jBz = new HashMap();

    private final class a {
        int id;
        V8Function jBE;
        V8Array jBF;
        Timer jBG;
        boolean jBH = false;

        public a(Timer timer, int i, V8Function v8Function, V8Array v8Array) {
            this.jBE = v8Function;
            this.jBF = v8Array;
            this.id = i;
            this.jBG = timer;
        }

        public final void df(boolean z) {
            if (!this.jBE.isReleased()) {
                this.jBE.call(null, this.jBF);
            }
            if (z) {
                cleanup();
            }
        }

        final void cleanup() {
            e.this.jBz.remove(Integer.valueOf(this.id));
            this.jBE.release();
            this.jBF.release();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.g.a.e$5 */
    class AnonymousClass5 extends TimerTask {
        final /* synthetic */ a jBB;
        final /* synthetic */ f jBw;

        AnonymousClass5(f fVar, a aVar) {
            this.jBw = fVar;
            this.jBB = aVar;
        }

        public final void run() {
            this.jBw.jBK.p(new Runnable() {
                public final void run() {
                    AnonymousClass5.this.jBB.df(true);
                }
            });
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.g.a.e$6 */
    class AnonymousClass6 extends TimerTask {
        final /* synthetic */ a jBB;
        final /* synthetic */ f jBw;

        AnonymousClass6(f fVar, a aVar) {
            this.jBw = fVar;
            this.jBB = aVar;
        }

        public final void run() {
            this.jBw.jBK.p(new Runnable() {
                public final void run() {
                    AnonymousClass6.this.jBB.df(false);
                }
            });
        }
    }

    e() {
    }

    static /* synthetic */ void a(e eVar, int i) {
        if (eVar.jBz.containsKey(Integer.valueOf(i))) {
            a aVar = (a) eVar.jBz.get(Integer.valueOf(i));
            aVar.jBG.cancel();
            aVar.cleanup();
        }
    }

    protected final void a(final f fVar, V8Object v8Object) {
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                if (v8Array.length() <= 0 || v8Array.getType(0) != 7) {
                    return null;
                }
                int i;
                V8Array toV8Array;
                V8Function v8Function = (V8Function) v8Array.getObject(0);
                if (v8Array.length() <= 1) {
                    i = 0;
                } else if (v8Array.getType(1) != 1) {
                    return null;
                } else {
                    i = v8Array.getInteger(1);
                }
                if (v8Array.length() > 2) {
                    List toList = V8ObjectUtils.toList(v8Array);
                    toV8Array = V8ObjectUtils.toV8Array(fVar.jBI, toList.subList(2, toList.size() - 1));
                } else {
                    toV8Array = new V8Array(fVar.jBI);
                }
                e eVar = e.this;
                f fVar = fVar;
                Timer timer = new Timer();
                Integer valueOf = Integer.valueOf(eVar.jBy.addAndGet(1));
                a aVar = new a(timer, valueOf.intValue(), v8Function, toV8Array);
                timer.schedule(new AnonymousClass5(fVar, aVar), (long) i);
                eVar.jBz.put(valueOf, aVar);
                return Integer.valueOf(valueOf.intValue());
            }
        }, "setTimeout");
        v8Object.registerJavaMethod(new JavaCallback() {
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                if (v8Array.length() < 2 || v8Array.getType(0) != 7 || v8Array.getType(1) != 1) {
                    return null;
                }
                V8Array toV8Array;
                V8Function v8Function = (V8Function) v8Array.getObject(0);
                int integer = v8Array.getInteger(1);
                if (v8Array.length() > 2) {
                    List toList = V8ObjectUtils.toList(v8Array);
                    toV8Array = V8ObjectUtils.toV8Array(fVar.jBI, toList.subList(2, toList.size() - 1));
                } else {
                    toV8Array = new V8Array(fVar.jBI);
                }
                e eVar = e.this;
                f fVar = fVar;
                Timer timer = new Timer();
                Integer valueOf = Integer.valueOf(eVar.jBy.addAndGet(1));
                a aVar = new a(timer, valueOf.intValue(), v8Function, toV8Array);
                timer.scheduleAtFixedRate(new AnonymousClass6(fVar, aVar), (long) integer, (long) integer);
                eVar.jBz.put(valueOf, aVar);
                return Integer.valueOf(valueOf.intValue());
            }
        }, "setInterval");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                if (v8Array.length() > 0 && v8Array.getType(0) == 1) {
                    e.a(e.this, v8Array.getInteger(0));
                }
            }
        }, "clearTimeout");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                if (v8Array.length() > 0 && v8Array.getType(0) == 1) {
                    e.a(e.this, v8Array.getInteger(0));
                }
            }
        }, "clearInterval");
    }
}
