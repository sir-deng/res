package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Deprecated
public enum AppBrandStickyBannerLogic {
    ;

    static final class OperateTask extends MainProcessTask {
        public static final Creator<OperateTask> CREATOR = null;
        boolean jUi;
        int jUj;
        String jUk;
        String jrv;
        int op;

        OperateTask() {
            this.op = 0;
        }

        public final void YA() {
            switch (this.op) {
                case 1:
                    this.jUi = b.aO(this.jrv, this.jUj);
                    afF();
                    return;
                case 2:
                    b.b(this);
                    return;
                case 3:
                    b.aP(this.jrv, this.jUj);
                    return;
                default:
                    return;
            }
        }

        static OperateTask q(String str, int i, String str2) {
            OperateTask operateTask = new OperateTask();
            operateTask.op = 2;
            operateTask.jrv = str;
            operateTask.jUj = i;
            operateTask.jUk = str2;
            return operateTask;
        }

        static OperateTask aQ(String str, int i) {
            OperateTask operateTask = new OperateTask();
            operateTask.op = 3;
            operateTask.jrv = str;
            operateTask.jUj = i;
            return operateTask;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.op);
            parcel.writeByte(this.jUi ? (byte) 1 : (byte) 0);
            parcel.writeString(this.jrv);
            parcel.writeInt(this.jUj);
            parcel.writeString(this.jUk);
        }

        public final void f(Parcel parcel) {
            this.op = parcel.readInt();
            this.jUi = parcel.readByte() != (byte) 0;
            this.jrv = parcel.readString();
            this.jUj = parcel.readInt();
            this.jUk = parcel.readString();
        }

        static {
            CREATOR = new Creator<OperateTask>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    OperateTask operateTask = new OperateTask();
                    operateTask.f(parcel);
                    return operateTask;
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new OperateTask[i];
                }
            };
        }
    }

    public static final class b {
        static final Set<f> gDT = null;

        static {
            gDT = new HashSet();
        }

        public static void y(final Intent intent) {
            if (intent != null && g.Do().CF()) {
                g.Dt().F(new Runnable() {
                    public final void run() {
                        if (b.x(intent)) {
                            b.alR();
                        }
                    }
                });
            }
        }

        static void b(OperateTask operateTask) {
            if (b.a(operateTask)) {
                alR();
            }
        }

        static void alK() {
            AppBrandStickyBannerLogic.access$200();
        }

        private static void alR() {
            BannerModel alS = BannerModel.alS();
            String str = alS == null ? null : alS.appId;
            int i = alS == null ? -1 : alS.iNi;
            synchronized (gDT) {
                for (f al : gDT) {
                    al.al(str, i);
                }
            }
        }

        public static void d(f fVar) {
            if (fVar != null) {
                synchronized (gDT) {
                    gDT.add(fVar);
                }
            }
        }

        public static void c(f fVar) {
            if (fVar != null) {
                synchronized (gDT) {
                    gDT.remove(fVar);
                }
            }
        }

        public static boolean aO(String str, int i) {
            AppBrandStickyBannerLogic.access$200();
            return false;
        }

        public static void aP(String str, int i) {
            AppBrandStickyBannerLogic.access$200();
        }
    }

    public static final class a {
        private static final Watcher jUc = null;
        private static final Set<f> jUd = null;
        private static final HashMap<String, Boolean> jUe = null;
        private static final HashMap<String, f> jUf = null;
        private static final c jUg = null;
        private static final Map<String, String> jUh = null;

        static {
            jUc = new Watcher();
            jUd = new HashSet();
            jUe = new HashMap();
            jUf = new HashMap();
            jUg = new c();
            jUh = new HashMap();
        }

        static void aN(String str, int i) {
            synchronized (jUd) {
                for (f al : jUd) {
                    al.al(str, i);
                }
            }
        }

        public static void a(Context context, String str, int i, String str2, String str3) {
            if (!bi.oN(str)) {
                Context context2;
                String str4;
                if (context == null) {
                    context2 = ad.getContext();
                } else {
                    context2 = context;
                }
                Intent addFlags = new Intent().setClassName(context2, "com.tencent.mm.ui.LauncherUI").addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864).addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                synchronized (jUh) {
                    str4 = (String) jUh.get(str);
                }
                b.a(addFlags, str, i, str2, str3, bi.oM(str4));
                context2.startActivity(addFlags);
                if (context2 instanceof Activity) {
                    try {
                        ((Activity) context2).moveTaskToBack(false);
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrandStickyBannerLogic.ClientLogic", "stickOnChatting e = %s", e.getMessage());
                    }
                }
            }
        }

        public static boolean aO(String str, int i) {
            AppBrandStickyBannerLogic.access$200();
            return false;
        }

        public static void c(f fVar) {
            if (fVar != null) {
                synchronized (jUd) {
                    jUd.remove(fVar);
                }
            }
        }

        public static void d(f fVar) {
            jUc.jUl = ad.By();
            AppBrandMainProcessService.a(jUc);
            if (fVar != null) {
                synchronized (jUd) {
                    jUd.add(fVar);
                }
            }
        }

        public static void Y(final String str, boolean z) {
            jUe.put(str, Boolean.valueOf(z));
            f anonymousClass1 = new f() {
                public final void al(String str, int i) {
                    if (bi.oN(str)) {
                        if (Boolean.TRUE.equals(a.jUe.get(str))) {
                            a.jUg.X(str, false);
                        }
                        a.jUe.put(str, Boolean.valueOf(false));
                    } else if (str.equals(str)) {
                        a.jUe.put(str, Boolean.valueOf(true));
                        a.jUg.X(str, true);
                    } else {
                        a.jUe.put(str, Boolean.valueOf(false));
                        a.jUg.X(str, false);
                    }
                }
            };
            d(anonymousClass1);
            jUf.put(str, anonymousClass1);
        }

        public static void vb(String str) {
            jUe.remove(str);
            x.i("MicroMsg.AppBrandStickyBannerLogic", "release(%s)", str);
        }

        public static void vc(String str) {
            if (!bi.oN(str)) {
                int i = com.tencent.mm.plugin.appbrand.a.pk(str).iRU.iJa;
                if (i >= 0) {
                    i.sz(str);
                    AppBrandMainProcessService.a(OperateTask.aQ(str, i));
                }
            }
        }

        public static void bK(String str, String str2) {
            if (!bi.oN(str)) {
                synchronized (jUh) {
                    jUh.put(str, bi.oM(str2));
                }
                AppBrandSysConfig pk = com.tencent.mm.plugin.appbrand.a.pk(str);
                if (pk != null) {
                    AppBrandMainProcessService.a(OperateTask.q(str, pk.iRU.iJa, str2));
                }
            }
        }
    }

    private static final class Watcher extends MainProcessTask {
        public static final Creator<Watcher> CREATOR = null;
        private static final transient Map<String, f> jUo = null;
        String jUl;
        String jUm;
        int jUn;

        static {
            jUo = new HashMap();
            CREATOR = new Creator<Watcher>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    Watcher watcher = new Watcher();
                    watcher.f(parcel);
                    return watcher;
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new Watcher[i];
                }
            };
        }

        public final void YA() {
            if (!bi.oN(this.jUl)) {
                synchronized (jUo) {
                    if (jUo.containsKey(this.jUl)) {
                        b.c((f) jUo.get(this.jUl));
                    }
                    f anonymousClass1 = new f() {
                        public final void al(String str, int i) {
                            Watcher.this.jUm = str;
                            Watcher.this.jUn = i;
                            Watcher.this.afF();
                        }
                    };
                    b.d(anonymousClass1);
                    jUo.put(this.jUl, anonymousClass1);
                }
            }
        }

        public final void YB() {
            a.aN(this.jUm, this.jUn);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.jUl);
            parcel.writeString(this.jUm);
            parcel.writeInt(this.jUn);
        }

        public final void f(Parcel parcel) {
            this.jUl = parcel.readString();
            this.jUm = parcel.readString();
            this.jUn = parcel.readInt();
        }

        Watcher() {
        }
    }
}
