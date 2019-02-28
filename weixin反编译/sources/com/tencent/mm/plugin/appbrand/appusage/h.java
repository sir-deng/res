package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class h extends j implements u {
    private boolean iMl = false;

    private static final class a implements com.tencent.mm.ipcinvoker.j<IPCInteger, Parcel> {
        private a() {
        }

        public final /* synthetic */ Object at(Object obj) {
            return a((IPCInteger) obj);
        }

        private static Parcel a(IPCInteger iPCInteger) {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeTypedList(((g) e.u(g.class)).v(iPCInteger.value, false));
                return obtain;
            } catch (Exception e) {
                obtain.setDataPosition(0);
                obtain.writeTypedList(null);
                return obtain;
            }
        }
    }

    private static final class c implements com.tencent.mm.ipcinvoker.j<AppIdentity, IPCBoolean> {
        private c() {
        }

        public final /* synthetic */ Object at(Object obj) {
            return a((AppIdentity) obj);
        }

        private static IPCBoolean a(AppIdentity appIdentity) {
            try {
                return new IPCBoolean(((g) e.u(g.class)).an(appIdentity.username, appIdentity.iNi));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandLocalUsageStorageIPCImpl", e, "ipc removeUsage", new Object[0]);
                return new IPCBoolean(false);
            }
        }
    }

    private static final class b implements com.tencent.mm.ipcinvoker.h<IPCVoid, Parcel> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, final i iVar) {
            ((g) e.u(g.class)).a(new com.tencent.mm.sdk.e.j.a() {
                public final void a(String str, l lVar) {
                    if (iVar != null) {
                        Parcel obtain = Parcel.obtain();
                        obtain.writeString(str);
                        obtain.writeInt(lVar.jcn);
                        obtain.writeString(lVar.obj == null ? null : lVar.obj.toString());
                        iVar.as(obtain);
                    }
                }
            }, com.tencent.mm.plugin.appbrand.r.c.Dt().oFY.getLooper());
        }
    }

    public final boolean an(String str, int i) {
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", new AppIdentity(str, i), c.class);
        return iPCBoolean == null ? false : iPCBoolean.value;
    }

    public final List<LocalUsageInfo> jH(int i) {
        Parcel parcel = (Parcel) XIPCInvoker.a("com.tencent.mm", new IPCInteger(12), a.class);
        if (parcel == null) {
            return null;
        }
        List<LocalUsageInfo> arrayList = new ArrayList(12);
        parcel.readTypedList(arrayList, LocalUsageInfo.CREATOR);
        return arrayList;
    }

    public final void c(com.tencent.mm.sdk.e.j.a aVar) {
        a(aVar, Looper.getMainLooper());
    }

    public final void a(com.tencent.mm.sdk.e.j.a aVar, Looper looper) {
        Object obj = 1;
        super.a(aVar, looper);
        synchronized (h.class) {
            if (this.iMl) {
                obj = null;
            }
            this.iMl = true;
        }
        if (obj != null) {
            XIPCInvoker.a("com.tencent.mm", IPCVoid.gOQ, b.class, new i<Parcel>() {
                public final /* synthetic */ void as(Object obj) {
                    Parcel parcel = (Parcel) obj;
                    h.this.b(parcel.readString(), parcel.readInt(), parcel.readString());
                }
            });
        }
    }
}
