package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.c.c;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize extends b {
    private static final int CTRL_INDEX = 54;
    private static final String NAME = "authorize";

    private static class AuthorizeTask extends MainProcessTask {
        public static final Creator<AuthorizeTask> CREATOR = new Creator<AuthorizeTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AuthorizeTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AuthorizeTask[i];
            }
        };
        public String appId;
        public String data;
        public int iNi;
        public String iYN;
        j jga;
        public int jgb;
        private int jhi;
        b jjk;
        a jjl;
        public Bundle jjm;
        public String jjn;
        public String jjo;
        public int jjp;
        public int jjq;
        public Bundle jjr;
        public String mAppName;

        public interface a {
            void a(LinkedList<bfh> linkedList, String str, String str2);

            void afW();

            void onSuccess();
        }

        public AuthorizeTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            final a anonymousClass1 = new a() {
                public final void onSuccess() {
                    x.d("MicroMsg.JsApiAuthorize", "onSuccess !");
                    AuthorizeTask.this.jjo = "ok";
                    AuthorizeTask.this.afF();
                }

                public final void afW() {
                    x.e("MicroMsg.JsApiAuthorize", "onFailure !");
                    AuthorizeTask.this.jjo = "fail";
                    AuthorizeTask.this.afF();
                }

                public final void a(LinkedList<bfh> linkedList, String str, String str2) {
                    x.d("MicroMsg.JsApiAuthorize", "onConfirm !");
                    AuthorizeTask.this.jjq = linkedList.size();
                    int i = 0;
                    while (i < AuthorizeTask.this.jjq) {
                        try {
                            AuthorizeTask.this.jjr.putByteArray(String.valueOf(i), ((bfh) linkedList.get(i)).toByteArray());
                            i++;
                        } catch (Throwable e) {
                            x.e("MicroMsg.JsApiAuthorize", "IOException %s", e.getMessage());
                            x.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                            AuthorizeTask.this.jjo = "fail";
                            AuthorizeTask.this.afF();
                            return;
                        }
                    }
                    AuthorizeTask.this.mAppName = str;
                    AuthorizeTask.this.iYN = str2;
                    AuthorizeTask.this.jjo = "needConfirm";
                    AuthorizeTask.this.afF();
                }
            };
            if (this.jjn.equals("authorize")) {
                try {
                    JSONArray jSONArray = new JSONArray(new JSONObject(this.data).optString("scope"));
                    LinkedList linkedList = new LinkedList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        linkedList.add(jSONArray.optString(i));
                    }
                    g.Dp().gRu.a(new com.tencent.mm.t.a.a(this.appId, linkedList, this.iNi, this.jhi, new com.tencent.mm.t.a.a.a<com.tencent.mm.t.a.a>() {
                        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                            com.tencent.mm.t.a.a aVar = (com.tencent.mm.t.a.a) kVar;
                            x.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (i != 0 || i2 != 0) {
                                anonymousClass1.afW();
                            } else if (aVar instanceof com.tencent.mm.t.a.a) {
                                amw Cc = aVar.Cc();
                                int i3 = Cc.wAp.fun;
                                String str2 = Cc.wAp.fuo;
                                x.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorize jsErrcode %d", Integer.valueOf(i3));
                                if (i3 == -12000) {
                                    anonymousClass1.a(Cc.woV, Cc.noG, Cc.vML);
                                } else if (i3 == 0) {
                                    anonymousClass1.onSuccess();
                                } else {
                                    x.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", str2);
                                    anonymousClass1.afW();
                                }
                            }
                        }
                    }), 0);
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiAuthorize", "Exception %s", e.getMessage());
                    this.jjo = "fail";
                    afF();
                }
            } else if (this.jjn.equals("authorizeConfirm")) {
                a(this.appId, this.jjm, this.iNi, this.jjp, anonymousClass1);
            }
        }

        public final void YB() {
            afz();
            if (!this.jga.Vx) {
                return;
            }
            if (this.jjo.equals("ok")) {
                this.jjk.a(this.jga, this.jgb, "ok");
                this.jjl.afS();
            } else if (this.jjo.equals("fail")) {
                this.jjk.a(this.jga, this.jgb, "fail");
                this.jjl.afS();
            } else if (this.jjo.equals("needConfirm")) {
                final LinkedList linkedList = new LinkedList();
                int i = 0;
                while (i < this.jjq) {
                    byte[] byteArray = this.jjr.getByteArray(String.valueOf(i));
                    bfh bfh = new bfh();
                    try {
                        bfh.aH(byteArray);
                        linkedList.add(bfh);
                        i++;
                    } catch (Throwable e) {
                        x.e("MicroMsg.JsApiAuthorize", "IOException %s", e.getMessage());
                        x.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                        this.jjk.a(this.jga, this.jgb, "fail");
                        this.jjl.afS();
                        return;
                    }
                }
                if (linkedList.size() > 0) {
                    ah.y(new Runnable() {
                        public final void run() {
                            AuthorizeTask.this.jga.iuk.a(new c(AuthorizeTask.this.jjk.a(AuthorizeTask.this.jga), linkedList, AuthorizeTask.this.mAppName, AuthorizeTask.this.iYN, new com.tencent.mm.plugin.appbrand.widget.c.c.a() {
                                public final void d(int i, Bundle bundle) {
                                    x.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                                    switch (i) {
                                        case 1:
                                        case 2:
                                            AuthorizeTask.this.jjn = "authorizeConfirm";
                                            AuthorizeTask.this.jjm = bundle;
                                            AuthorizeTask.this.jjp = i;
                                            AppBrandMainProcessService.a(AuthorizeTask.this);
                                            if (i == 2) {
                                                AuthorizeTask.this.jjk.a(AuthorizeTask.this.jga, AuthorizeTask.this.jgb, "fail auth deny");
                                                AuthorizeTask.this.jjl.afS();
                                                return;
                                            }
                                            return;
                                        default:
                                            x.d("MicroMsg.JsApiAuthorize", "press back button!");
                                            AuthorizeTask.this.jjk.a(AuthorizeTask.this.jga, AuthorizeTask.this.jgb, "fail auth cancel");
                                            AuthorizeTask.this.jjl.afS();
                                            return;
                                    }
                                }
                            }));
                        }
                    });
                    return;
                }
                this.jjk.a(this.jga, this.jgb, "fail");
                this.jjl.afS();
            }
        }

        public final void f(Parcel parcel) {
            this.data = parcel.readString();
            this.jgb = parcel.readInt();
            this.appId = parcel.readString();
            this.jjo = parcel.readString();
            this.jjn = parcel.readString();
            this.mAppName = parcel.readString();
            this.iYN = parcel.readString();
            this.jjq = parcel.readInt();
            this.jjr = parcel.readBundle(JsApiAuthorize.class.getClassLoader());
            this.jjm = parcel.readBundle(JsApiAuthorize.class.getClassLoader());
            this.iNi = parcel.readInt();
            this.jjp = parcel.readInt();
            this.jhi = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.data);
            parcel.writeInt(this.jgb);
            parcel.writeString(this.appId);
            parcel.writeString(this.jjo);
            parcel.writeString(this.jjn);
            parcel.writeString(this.mAppName);
            parcel.writeString(this.iYN);
            parcel.writeInt(this.jjq);
            parcel.writeBundle(this.jjr);
            parcel.writeBundle(this.jjm);
            parcel.writeInt(this.iNi);
            parcel.writeInt(this.jjp);
            parcel.writeInt(this.jhi);
        }

        private void a(String str, Bundle bundle, int i, final int i2, final a aVar) {
            ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
            LinkedList linkedList = new LinkedList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                linkedList.add((String) it.next());
            }
            g.Dp().gRu.a(new b(str, linkedList, i, i2, this.jhi, new com.tencent.mm.t.a.b.a<b>() {
                public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                    b bVar = (b) kVar;
                    x.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i != 0 || i2 != 0) {
                        aVar.afW();
                    } else if (!(bVar instanceof b)) {
                    } else {
                        if (i2 == 2) {
                            x.d("MicroMsg.JsApiAuthorize", "press reject button");
                            return;
                        }
                        amu Cd = bVar.Cd();
                        int i3 = Cd.wAp.fun;
                        String str2 = Cd.wAp.fuo;
                        x.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorizeConfirm jsErrcode %d", Integer.valueOf(i3));
                        if (i3 == 0) {
                            aVar.onSuccess();
                            return;
                        }
                        x.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", str2);
                        aVar.afW();
                    }
                }
            }), 0);
        }
    }

    public final /* bridge */ /* synthetic */ void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
    }

    public final void a(j jVar, JSONObject jSONObject, int i, a aVar) {
        x.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
        MainProcessTask authorizeTask = new AuthorizeTask();
        authorizeTask.appId = jVar.mAppId;
        authorizeTask.jjn = "authorize";
        AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
        if (appBrandSysConfig != null) {
            authorizeTask.iNi = appBrandSysConfig.iRU.iJa;
        }
        AppBrandStatObject pl = a.pl(jVar.mAppId);
        if (pl != null) {
            authorizeTask.jhi = pl.scene;
        }
        String jSONObject2 = jSONObject.toString();
        authorizeTask.jjk = this;
        authorizeTask.jga = jVar;
        authorizeTask.data = jSONObject2;
        authorizeTask.jgb = i;
        authorizeTask.jjl = aVar;
        authorizeTask.jjr = new Bundle();
        authorizeTask.afy();
        AppBrandMainProcessService.a(authorizeTask);
    }
}
