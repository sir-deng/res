package com.tencent.mm.plugin.appbrand.widget.input;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.e.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.u.g;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h {
    public final Map<Integer, c> kcT;

    private static final class a {
        private static final h kcY = new h();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.h$2 */
    class AnonymousClass2 implements ab {
        final /* synthetic */ WeakReference jno;
        final /* synthetic */ int jnq;
        final /* synthetic */ String kcW;

        public AnonymousClass2(WeakReference weakReference, int i, String str) {
            this.jno = weakReference;
            this.jnq = i;
            this.kcW = str;
        }

        public final void a(String str, int i, com.tencent.mm.plugin.appbrand.widget.input.ab.a aVar) {
            try {
                p pVar = (p) this.jno.get();
                if (pVar != null) {
                    JSONObject put = new JSONObject().put(Columns.VALUE, str).put("inputId", this.jnq).put("cursor", i);
                    if (com.tencent.mm.plugin.appbrand.widget.input.ab.a.CHANGED.equals(aVar)) {
                        f bVar = new b();
                        bVar.aA(pVar.mAppId, pVar.hashCode());
                        bVar.mData = put.put(SlookAirButtonFrequentContactAdapter.DATA, this.kcW).toString();
                        bVar.afI();
                        return;
                    }
                    String str2;
                    switch (AnonymousClass4.kcX[aVar.ordinal()]) {
                        case 1:
                            str2 = "onKeyboardComplete";
                            break;
                        case 2:
                            str2 = "onKeyboardConfirm";
                            break;
                        default:
                            str2 = null;
                            break;
                    }
                    if (!bi.oN(str2)) {
                        pVar.j(str2, put.toString(), 0);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.h$4 */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] kcX = new int[com.tencent.mm.plugin.appbrand.widget.input.ab.a.values().length];

        static {
            try {
                kcX[com.tencent.mm.plugin.appbrand.widget.input.ab.a.COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kcX[com.tencent.mm.plugin.appbrand.widget.input.ab.a.CONFIRM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.h$1 */
    class AnonymousClass1 implements e {
        final /* synthetic */ int jnq;

        public AnonymousClass1(int i) {
            this.jnq = i;
        }

        public final void onDestroy() {
            c.runOnUiThread(new Runnable() {
                public final void run() {
                    h.this.kcT.remove(Integer.valueOf(AnonymousClass1.this.jnq));
                }
            });
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.h$3 */
    class AnonymousClass3 implements aa {
        final /* synthetic */ WeakReference jno;
        final /* synthetic */ int jnq;

        public AnonymousClass3(WeakReference weakReference, int i) {
            this.jno = weakReference;
            this.jnq = i;
        }

        public final void ml(int i) {
            try {
                p pVar = (p) this.jno.get();
                if (pVar != null) {
                    pVar.j("onKeyboardShow", g.Ck().C("inputId", this.jnq).C("height", com.tencent.mm.plugin.appbrand.q.f.lZ(i)).toString(), 0);
                }
            } catch (Exception e) {
            }
        }
    }

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
        this.kcT = new HashMap();
    }
}
