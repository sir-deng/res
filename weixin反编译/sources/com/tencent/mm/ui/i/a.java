package com.tencent.mm.ui.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f.a.e;
import java.util.ArrayList;
import java.util.List;
import org.b.d.i;
import org.b.d.j;
import org.b.d.k;
import org.b.g.d;

@SuppressLint({"HandlerLeak"})
public final class a implements com.tencent.mm.ui.i.b.a {
    Context context = null;
    ag rxb = new ag() {
        public final void handleMessage(Message message) {
            if (message.what == 1000) {
                String str = (String) message.obj;
                if (str != null) {
                    Context context = a.this.context;
                    com.tencent.mm.ui.i.b.a aVar = a.this;
                    if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
                        e.C(context, "Error", "Application requires permission to access the Internet");
                    } else {
                        new b(context, str, aVar).show();
                    }
                } else {
                    a.this.c(c.Failed);
                }
            }
            if (message.what == HardCoderJNI.FUNC_REG_ANR_CALLBACK) {
                c cVar = (c) message.obj;
                a aVar2 = a.this;
                aVar2.zzc = false;
                if (cVar == c.Failed) {
                    aVar2.zza = null;
                    a.a(null);
                }
                if (aVar2.zze != null) {
                    aVar2.zze.b(cVar);
                }
            }
        }
    };
    org.b.e.b zyY = null;
    public i zyZ = null;
    i zza = null;
    private boolean zzb = false;
    boolean zzc = false;
    public b zzd = null;
    public a zze = null;

    public enum c {
        Finished,
        Failed,
        Canceled
    }

    public interface a {
        void b(c cVar);
    }

    public interface b {
        void a(c cVar);
    }

    public a() {
        i iVar;
        org.b.a.a aVar = new org.b.a.a();
        aVar.AHC = org.b.a.a.S(org.b.a.a.c.a.class);
        String str = "XMr2y8FEVEqZBcZ1TU3gLA";
        d.gu(str, "Invalid Api key");
        aVar.AHz = str;
        str = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
        d.gu(str, "Invalid Api secret");
        aVar.AHA = str;
        str = "wechatapp://sign-in-twitter.wechatapp.com/";
        d.j(str, "Callback can't be null");
        aVar.AHB = str;
        d.j(aVar.AHC, "You must specify a valid api through the provider() method");
        d.gu(aVar.AHz, "You must provide an api key");
        d.gu(aVar.AHA, "You must provide an api secret");
        this.zyY = aVar.AHC.a(new org.b.d.a(aVar.AHz, aVar.AHA, aVar.AHB, aVar.AHD, aVar.scope, aVar.AHE));
        if (g.Do().CF()) {
            str = (String) g.Dq().Db().get(69377, null);
            String str2 = (String) g.Dq().Db().get(69378, null);
            iVar = (bi.oN(str) || bi.oN(str2)) ? null : new i(str, str2);
        } else {
            x.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
            iVar = null;
        }
        this.zyZ = iVar;
    }

    public final void a(b bVar, Context context) {
        if (!this.zzb) {
            com.tencent.mm.plugin.report.service.g.pWK.a(583, 0, 1, false);
            this.zzd = bVar;
            this.context = context;
            this.zzb = true;
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    Object b;
                    try {
                        a.this.zza = a.this.zyY.cLf();
                        b = a.this.zyY.b(a.this.zza);
                    } catch (org.b.b.a e) {
                        b = null;
                    }
                    a.this.rxb.sendMessage(a.this.rxb.obtainMessage(1000, b));
                }
            }, "Twitter_doOAuth");
        }
    }

    public final boolean czn() {
        return this.zyZ != null;
    }

    public final void a(a aVar) {
        if (!this.zzc) {
            this.zze = aVar;
            this.zzc = true;
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    Object obj = c.Finished;
                    if (a.this.zyZ == null) {
                        obj = c.Failed;
                    } else {
                        org.b.d.c cVar = new org.b.d.c(j.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
                        a.this.zyY.a(a.this.zyZ, cVar);
                        try {
                            if (cVar.cLa().code != 200) {
                                obj = c.Failed;
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.Twitter", e, "request error.", new Object[0]);
                            obj = c.Failed;
                        }
                    }
                    a.this.rxb.sendMessage(a.this.rxb.obtainMessage(HardCoderJNI.FUNC_REG_ANR_CALLBACK, obj));
                }
            }, "Twitter_validationAccessToken");
        }
    }

    static void a(i iVar) {
        ad.getContext().getSharedPreferences(ad.cgf(), 0);
        if (iVar == null) {
            g.Dq().Db().set(69377, "");
            g.Dq().Db().set(69378, "");
            return;
        }
        g.Dq().Db().set(69377, iVar.token);
        g.Dq().Db().set(69378, iVar.wFv);
    }

    final void c(c cVar) {
        this.zzb = false;
        this.zza = null;
        if (this.zzd != null) {
            this.zzd.a(cVar);
        }
    }

    public final void k(final Bundle bundle) {
        g.Dt().F(new Runnable() {
            public final void run() {
                i iVar = null;
                if (a.this.zza != null) {
                    a.nF(true);
                    String string = bundle.getString("oauth_verifier");
                    if (string != null) {
                        try {
                            iVar = a.this.zyY.a(a.this.zza, new k(string));
                        } catch (org.b.b.a e) {
                        }
                    }
                    if (iVar != null) {
                        a.this.zyZ = iVar;
                        a.a(a.this.zyZ);
                        new ag(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                a.this.c(c.Finished);
                                com.tencent.mm.plugin.report.service.g.pWK.a(583, 1, 1, false);
                            }
                        });
                        return;
                    }
                    new ag(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            a.this.c(c.Failed);
                            com.tencent.mm.plugin.report.service.g.pWK.a(583, 4, 1, false);
                        }
                    });
                }
            }

            public final String toString() {
                return super.toString() + "|onComplete";
            }
        });
    }

    public final void czo() {
        nF(false);
        c(c.Failed);
        com.tencent.mm.plugin.report.service.g.pWK.a(583, 2, 1, false);
    }

    public final void onCancel() {
        nF(false);
        c(c.Canceled);
        com.tencent.mm.plugin.report.service.g.pWK.a(583, 3, 1, false);
    }

    static void nF(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.ax.i.a(10251, z ? "1" : "2"));
        ((h) g.h(h.class)).Fe().b(new com.tencent.mm.ax.i(arrayList));
    }
}
