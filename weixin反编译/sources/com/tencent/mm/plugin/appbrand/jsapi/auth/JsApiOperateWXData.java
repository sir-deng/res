package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.c.c;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiOperateWXData extends b {
    public static final int CTRL_INDEX = 79;
    public static final String NAME = "operateWXData";

    private static class OperateWXDataTask extends MainProcessTask {
        public static final Creator<OperateWXDataTask> CREATOR = new Creator<OperateWXDataTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OperateWXDataTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateWXDataTask[i];
            }
        };
        public String appId;
        public int iNi;
        public String iYN;
        j jga;
        public int jgb;
        int jhi;
        public String jjA;
        public String jjB;
        b jjk;
        a jjl;
        public String jjn;
        public String jjo;
        public int jjp;
        public int jjq;
        public Bundle jjr;
        public String jjz;
        public String mAppName;

        public interface a {
            void a(LinkedList<bfh> linkedList, String str, String str2);

            void fs(String str);

            void pH(String str);
        }

        public OperateWXDataTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            a anonymousClass1 = new a() {
                public final void pH(String str) {
                    x.d("MicroMsg.JsApiOperateWXData", "onSuccess !");
                    OperateWXDataTask.this.jjA = str;
                    OperateWXDataTask.this.jjo = "ok";
                    OperateWXDataTask.this.afF();
                }

                public final void fs(String str) {
                    x.e("MicroMsg.JsApiOperateWXData", "onFailure !");
                    OperateWXDataTask.this.jjo = "fail:" + str;
                    OperateWXDataTask.this.afF();
                }

                public final void a(LinkedList<bfh> linkedList, String str, String str2) {
                    x.d("MicroMsg.JsApiOperateWXData", "onConfirm !");
                    OperateWXDataTask.this.jjq = linkedList.size();
                    int i = 0;
                    while (i < OperateWXDataTask.this.jjq) {
                        try {
                            OperateWXDataTask.this.jjr.putByteArray(String.valueOf(i), ((bfh) linkedList.get(i)).toByteArray());
                            i++;
                        } catch (Throwable e) {
                            x.e("MicroMsg.JsApiOperateWXData", "IOException %s", e.getMessage());
                            x.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                            OperateWXDataTask.this.jjo = "fail";
                            OperateWXDataTask.this.afF();
                            return;
                        }
                    }
                    OperateWXDataTask.this.mAppName = str;
                    OperateWXDataTask.this.iYN = str2;
                    OperateWXDataTask.this.jjo = "needConfirm";
                    OperateWXDataTask.this.afF();
                }
            };
            if (this.jjn.equals(JsApiOperateWXData.NAME)) {
                a(this.appId, this.jjz, "", this.iNi, this.jjp, anonymousClass1);
            } else if (this.jjn.equals("operateWXDataConfirm")) {
                a(this.appId, this.jjz, this.jjB, this.iNi, this.jjp, anonymousClass1);
            }
        }

        public final void YB() {
            afz();
            if (!this.jga.Vx) {
                return;
            }
            if (this.jjo.equals("ok")) {
                Map hashMap = new HashMap();
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, this.jjA);
                this.jga.E(this.jgb, this.jjk.e("ok", hashMap));
                this.jjl.afS();
            } else if (this.jjo.contains("fail")) {
                this.jjk.a(this.jga, this.jgb, this.jjo);
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
                        x.e("MicroMsg.JsApiOperateWXData", "IOException %s", e.getMessage());
                        x.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                        this.jjk.a(this.jga, this.jgb, "fail");
                        this.jjl.afS();
                        return;
                    }
                }
                if (linkedList.size() > 0) {
                    ah.y(new Runnable() {
                        public final void run() {
                            OperateWXDataTask.this.jga.iuk.a(new c(OperateWXDataTask.this.jjk.a(OperateWXDataTask.this.jga), linkedList, OperateWXDataTask.this.mAppName, OperateWXDataTask.this.iYN, new com.tencent.mm.plugin.appbrand.widget.c.c.a() {
                                public final void d(int i, Bundle bundle) {
                                    x.i("MicroMsg.JsApiOperateWXData", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                                    switch (i) {
                                        case 1:
                                        case 2:
                                            OperateWXDataTask.this.jjn = "operateWXDataConfirm";
                                            ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                            if (arrayList == null || arrayList.size() <= 0) {
                                                OperateWXDataTask.this.jjB = "";
                                            } else {
                                                OperateWXDataTask.this.jjB = (String) arrayList.get(0);
                                            }
                                            OperateWXDataTask.this.jjp = i;
                                            AppBrandMainProcessService.a(OperateWXDataTask.this);
                                            if (i == 2) {
                                                OperateWXDataTask.this.jjk.a(OperateWXDataTask.this.jga, OperateWXDataTask.this.jgb, "fail auth deny");
                                                OperateWXDataTask.this.jjl.afS();
                                                return;
                                            }
                                            return;
                                        default:
                                            x.d("MicroMsg.JsApiOperateWXData", "press back button!");
                                            OperateWXDataTask.this.jjk.a(OperateWXDataTask.this.jga, OperateWXDataTask.this.jgb, "fail auth cancel");
                                            OperateWXDataTask.this.jjl.afS();
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
            this.appId = parcel.readString();
            this.jjo = parcel.readString();
            this.mAppName = parcel.readString();
            this.iYN = parcel.readString();
            this.jjz = parcel.readString();
            this.jjA = parcel.readString();
            this.jgb = parcel.readInt();
            this.jjn = parcel.readString();
            this.jjB = parcel.readString();
            this.jjq = parcel.readInt();
            this.jjr = parcel.readBundle(JsApiOperateWXData.class.getClassLoader());
            this.iNi = parcel.readInt();
            this.jjp = parcel.readInt();
            this.jhi = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.jjo);
            parcel.writeString(this.mAppName);
            parcel.writeString(this.iYN);
            parcel.writeString(this.jjz);
            parcel.writeString(this.jjA);
            parcel.writeInt(this.jgb);
            parcel.writeString(this.jjn);
            parcel.writeString(this.jjB);
            parcel.writeInt(this.jjq);
            parcel.writeBundle(this.jjr);
            parcel.writeInt(this.iNi);
            parcel.writeInt(this.jjp);
            parcel.writeInt(this.jhi);
        }

        private void a(String str, String str2, String str3, int i, final int i2, final a aVar) {
            g.Dp().gRu.a(new com.tencent.mm.plugin.appbrand.i.c(str, str2, str3, i, i2, this.jhi, new com.tencent.mm.plugin.appbrand.i.c.a<com.tencent.mm.plugin.appbrand.i.c>() {
                public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                    com.tencent.mm.plugin.appbrand.i.c cVar = (com.tencent.mm.plugin.appbrand.i.c) kVar;
                    x.d("MicroMsg.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i != 0 || i2 != 0) {
                        aVar.fs("");
                    } else if (!(cVar instanceof com.tencent.mm.plugin.appbrand.i.c)) {
                    } else {
                        if (i2 == 2) {
                            x.d("MicroMsg.JsApiOperateWXData", "press reject button");
                            return;
                        }
                        anc anc = cVar.gLB == null ? null : (anc) cVar.gLB.hnR.hnY;
                        int i3 = anc.wAp.fun;
                        String str2 = anc.wAp.fuo;
                        bfh bfh = anc.wAw;
                        LinkedList linkedList = new LinkedList();
                        if (bfh != null) {
                            linkedList.add(bfh);
                        }
                        String str3 = anc.noG;
                        String str4 = anc.vML;
                        x.d("MicroMsg.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", Integer.valueOf(i3));
                        if (i3 == -12000) {
                            aVar.a(linkedList, str3, str4);
                        } else if (i3 == 0) {
                            x.d("MicroMsg.JsApiOperateWXData", "resp data %s", anc.kyn.cec());
                            aVar.pH(r0);
                        } else {
                            x.e("MicroMsg.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", str2);
                            aVar.fs(str2);
                        }
                    }
                }
            }), 0);
        }
    }

    public final /* bridge */ /* synthetic */ void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
    }

    public final void a(j jVar, JSONObject jSONObject, int i, a aVar) {
        try {
            String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.DATA);
            MainProcessTask operateWXDataTask = new OperateWXDataTask();
            operateWXDataTask.appId = jVar.mAppId;
            operateWXDataTask.jjn = NAME;
            AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
            if (appBrandSysConfig != null) {
                operateWXDataTask.iNi = appBrandSysConfig.iRU.iJa;
            }
            operateWXDataTask.jjk = this;
            operateWXDataTask.jga = jVar;
            operateWXDataTask.jjz = string;
            operateWXDataTask.jgb = i;
            operateWXDataTask.jjl = aVar;
            operateWXDataTask.jjr = new Bundle();
            AppBrandStatObject pl = a.pl(operateWXDataTask.appId);
            if (pl != null) {
                operateWXDataTask.jhi = pl.scene;
            }
            operateWXDataTask.afy();
            AppBrandMainProcessService.a(operateWXDataTask);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiOperateWXData", "Exception %s", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}
