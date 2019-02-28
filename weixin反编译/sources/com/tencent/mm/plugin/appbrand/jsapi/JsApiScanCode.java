package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.ad.u.a;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiScanCode extends a {
    public static final int CTRL_INDEX = 148;
    public static final String NAME = "scanCode";
    private static volatile boolean jgM = false;

    public static class GetA8KeyTask extends MainProcessTask {
        public static final Creator<GetA8KeyTask> CREATOR = new Creator<GetA8KeyTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                GetA8KeyTask getA8KeyTask = new GetA8KeyTask();
                getA8KeyTask.f(parcel);
                return getA8KeyTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetA8KeyTask[i];
            }
        };
        public int actionCode;
        public int fqW;
        public int fqX;
        public String jho;
        public String jhp;
        public Runnable jhq;

        public final void YA() {
            final l lVar = new l(this.jho, 36, this.fqW, this.fqX, null, (int) System.currentTimeMillis(), new byte[0]);
            u.a(lVar.gLB, new a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (i == 0 && i2 == 0) {
                        GetA8KeyTask.this.actionCode = lVar.RN();
                        switch (GetA8KeyTask.this.actionCode) {
                            case 26:
                                GetA8KeyTask.this.jhp = lVar.RL();
                                break;
                            default:
                                GetA8KeyTask.this.jhp = "";
                                break;
                        }
                        GetA8KeyTask.this.afF();
                    } else {
                        GetA8KeyTask.this.actionCode = -1;
                        GetA8KeyTask.this.afF();
                    }
                    return 0;
                }
            }, true);
        }

        public final void YB() {
            if (this.jhq != null) {
                this.jhq.run();
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.jho);
            parcel.writeInt(this.actionCode);
            parcel.writeString(this.jhp);
            parcel.writeInt(this.fqW);
            parcel.writeInt(this.fqX);
        }

        public final void f(Parcel parcel) {
            this.jho = parcel.readString();
            this.actionCode = parcel.readInt();
            this.jhp = parcel.readString();
            this.fqW = parcel.readInt();
            this.fqX = parcel.readInt();
        }
    }

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        if (jgM) {
            jVar.E(i, e("cancel", null));
            return;
        }
        jgM = true;
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        a.jCj = new MMActivity.a() {
            public final void b(int i, int i2, Intent intent) {
                JsApiScanCode.jgM = false;
                if (i == (JsApiScanCode.this.hashCode() & 65535)) {
                    switch (i2) {
                        case -1:
                            Object stringExtra;
                            int intExtra;
                            int intExtra2;
                            int intExtra3;
                            String str = "";
                            if (intent != null) {
                                stringExtra = intent.getStringExtra("key_scan_result");
                                intExtra = intent.getIntExtra("key_scan_result_type", 0);
                                intExtra2 = intent.getIntExtra("key_scan_result_code_type", 0);
                                intExtra3 = intent.getIntExtra("key_scan_result_code_version", 0);
                            } else {
                                intExtra2 = 0;
                                intExtra = 0;
                                String stringExtra2 = str;
                                intExtra3 = 0;
                            }
                            final HashMap hashMap = new HashMap();
                            hashMap.put("charSet", ProtocolPackage.ServerEncoding);
                            if (intExtra != 1) {
                                String[] split = stringExtra2.split(",");
                                String str2 = "result";
                                if (split.length > 1) {
                                    stringExtra2 = split[1];
                                }
                                hashMap.put(str2, stringExtra2);
                                hashMap.put("scanType", split.length > 1 ? split[0] : "");
                                jVar.E(i, JsApiScanCode.this.e("ok", hashMap));
                                return;
                            }
                            hashMap.put("result", intExtra2 == 22 ? "" : stringExtra2);
                            hashMap.put("scanType", "QR_CODE");
                            final MainProcessTask getA8KeyTask = new GetA8KeyTask();
                            getA8KeyTask.jho = stringExtra2;
                            getA8KeyTask.fqW = intExtra2;
                            getA8KeyTask.fqX = intExtra3;
                            getA8KeyTask.jhq = new Runnable() {
                                public final void run() {
                                    getA8KeyTask.afz();
                                    if (getA8KeyTask.actionCode == 26) {
                                        Uri parse = Uri.parse(getA8KeyTask.jhp);
                                        if (jVar.iuk.isS.foe.equals(parse.getQueryParameter("username"))) {
                                            hashMap.put("path", URLDecoder.decode(bi.oM(parse.getQueryParameter("path"))));
                                        }
                                    }
                                    jVar.E(i, JsApiScanCode.this.e("ok", hashMap));
                                }
                            };
                            getA8KeyTask.afy();
                            AppBrandMainProcessService.a(getA8KeyTask);
                            return;
                        case 0:
                            jVar.E(i, JsApiScanCode.this.e("cancel", null));
                            return;
                        default:
                            jVar.E(i, JsApiScanCode.this.e("fail", null));
                            return;
                    }
                }
            }
        };
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 1);
        intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
        intent.putExtra("key_is_finish_on_scanned", true);
        intent.putExtra("key_is_hide_right_btn", jSONObject.optBoolean("onlyFromCamera", false));
        d.a(a, "scanner", ".ui.SingleTopScanUI", intent, hashCode() & 65535, false);
    }
}
