package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.game.e.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
    private static volatile d jbQ;
    public c jbO;
    public b jbP;
    private c jbR = new c();
    public Context mContext;
    public volatile int mState = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.d$2 */
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] jbT = new int[a.aew().length];

        static {
            try {
                jbT[a.jbU - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jbT[a.jbV - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jbT[a.jbW - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                jbT[a.jbX - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static class b implements Runnable {
        private c jbO;
        private c jbR;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void run() {
            if (this.jbO != null && this.jbR != null) {
                this.jbR.j(this);
            }
        }
    }

    public enum a {
        ;

        public static int[] aew() {
            return (int[]) jbY.clone();
        }

        static {
            jbU = 1;
            jbV = 2;
            jbW = 3;
            jbX = 4;
            jbY = new int[]{jbU, jbV, jbW, jbX};
        }
    }

    private static class c extends f<b> {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        protected final /* synthetic */ Object aep() {
            return new b();
        }
    }

    public static d aev() {
        if (jbQ == null) {
            synchronized (d.class) {
                if (jbQ == null) {
                    jbQ = new d();
                }
            }
        }
        return jbQ;
    }

    public static void release() {
        if (jbQ != null) {
            synchronized (d.class) {
                if (jbQ != null) {
                    jbQ.mState = 2;
                    jbQ.jbR.jdG.clear();
                    jbQ = null;
                }
            }
        }
    }

    private d() {
    }

    public final void sj(final String str) {
        if (this.mState == 1 && this.jbP != null) {
            this.jbP.post(new Runnable() {
                public final void run() {
                    if (d.this.jbP != null) {
                        b a = d.this.jbP;
                        String str = str;
                        if (a.jbG) {
                            a.sh(str);
                            return;
                        }
                        if (a.jbF == null) {
                            a.jbF = new LinkedList();
                        }
                        a.jbF.add(str);
                    }
                }
            });
        }
    }

    public final void G(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("wxClient: " + str);
            jSONObject.put("logs", jSONArray);
            sj(jSONObject.toString());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameInspector", e, "hy: vConsole json error", new Object[0]);
        }
    }
}
