package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.mm.bl.d;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.f.a.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddNativeDownloadTask extends a {
    private static final int CTRL_INDEX = 428;
    private static final String NAME = "addNativeDownloadTask";

    private static class AddNativeDownloadTaskTask extends MainProcessTask {
        public static final Creator<AddNativeDownloadTaskTask> CREATOR = new Creator<AddNativeDownloadTaskTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AddNativeDownloadTaskTask addNativeDownloadTaskTask = new AddNativeDownloadTaskTask();
                addNativeDownloadTaskTask.f(parcel);
                return addNativeDownloadTaskTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddNativeDownloadTaskTask[i];
            }
        };
        public int fEo = 0;
        public long fnS = 0;
        private c jfV;
        Runnable jfW;

        public final void YA() {
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "runInMainProcess flag:%d", Integer.valueOf(this.fEo));
            this.jfV = new c<i>() {
                {
                    this.xmG = i.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    i iVar = (i) bVar;
                    if (!(iVar instanceof i)) {
                        x.w("MicroMsg.JsApiAddNativeDownloadTask", "mismatched event");
                        return false;
                    } else if (iVar.fnQ.scene != 1) {
                        x.i("MicroMsg.JsApiAddNativeDownloadTask", "not jsapi api callback");
                        return false;
                    } else {
                        if (iVar.fnQ.fnR) {
                            x.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, cancel");
                            AddNativeDownloadTaskTask.this.fEo = 0;
                            AddNativeDownloadTaskTask.this.afF();
                        } else if (iVar.fnQ.fnS > 0) {
                            new HashMap().put("download_id", Long.valueOf(iVar.fnQ.fnS));
                            AddNativeDownloadTaskTask.this.fnS = iVar.fnQ.fnS;
                            x.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, ok downloadId:%s", Long.valueOf(AddNativeDownloadTaskTask.this.fnS));
                            AddNativeDownloadTaskTask.this.fEo = 2;
                            AddNativeDownloadTaskTask.this.afF();
                        } else {
                            x.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, failed");
                            AddNativeDownloadTaskTask.this.fEo = 1;
                            AddNativeDownloadTaskTask.this.afF();
                        }
                        a.xmy.c(AddNativeDownloadTaskTask.this.jfV);
                        return true;
                    }
                }
            };
            a.xmy.a(this.jfV);
        }

        public final void YB() {
            if (this.jfW != null) {
                this.jfW.run();
            }
        }

        public final void f(Parcel parcel) {
            this.fEo = parcel.readInt();
            this.fnS = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.fEo);
            parcel.writeLong(this.fnS);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiAddNativeDownloadTask", "data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        String optString = jSONObject.optString("taskName");
        String optString2 = jSONObject.optString("taskUrl");
        long j = bi.getLong(jSONObject.optString("taskSize"), 0);
        String optString3 = jSONObject.optString("fileMD5");
        String optString4 = jSONObject.optString("thumbUrl");
        String optString5 = jSONObject.optString("title");
        final Context context = jVar.getContext();
        x.i("MicroMsg.JsApiAddNativeDownloadTask", "taskUrl : %s, taskSize : %s, fileMD5:[%s], title : %s, thumbUrl : %s", optString2, Long.valueOf(j), optString3, optString5, optString4);
        if (!ao.isNetworkConnected(context)) {
            jVar.E(i, e("fail:fail network not connected", null));
            ah.y(new Runnable() {
                public final void run() {
                    Toast.makeText(context, context.getString(q.j.emu), 0).show();
                }
            });
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, network not ready");
        } else if (!f.zl()) {
            jVar.E(i, e("fail:fail sdcard not ready", null));
            ah.y(new Runnable() {
                public final void run() {
                    Toast.makeText(context, context.getString(q.j.emw), 0).show();
                }
            });
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, sdcard not ready");
        } else if (j > 0 && !f.aD(j)) {
            jVar.E(i, e("fail:fail sdcard has not enough space", null));
            ah.y(new Runnable() {
                public final void run() {
                    Toast.makeText(context, context.getString(q.j.emv), 0).show();
                }
            });
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, not enough space, require size = " + j);
        } else if (bi.oN(optString2)) {
            x.e("MicroMsg.JsApiAddNativeDownloadTask", "doAddDownloadTask fail, url is null");
            jVar.E(i, e("fail:taskUrl is null or nil", null));
        } else {
            Intent intent = new Intent();
            intent.putExtra("task_name", optString);
            intent.putExtra("task_url", optString2);
            intent.putExtra("task_size", j);
            intent.putExtra("file_md5", optString3);
            intent.putExtra("appid", jVar.mAppId);
            intent.putExtra("thumb_url", optString4);
            intent.putExtra("title", optString5);
            p b = e.b(jVar);
            if (b != null) {
                intent.putExtra("page_url", b.getURL());
            } else {
                x.e("MicroMsg.JsApiAddNativeDownloadTask", "getCurrentPageView is null");
            }
            intent.putExtra("page_scene", 1);
            d.b(context, "webview", ".ui.tools.WebViewDownloadUI", intent);
            final MainProcessTask addNativeDownloadTaskTask = new AddNativeDownloadTaskTask();
            final j jVar2 = jVar;
            final int i2 = i;
            addNativeDownloadTaskTask.jfW = new Runnable() {
                public final void run() {
                    addNativeDownloadTaskTask.afz();
                    Map hashMap = new HashMap();
                    switch (addNativeDownloadTaskTask.fEo) {
                        case 0:
                            jVar2.E(i2, JsApiAddNativeDownloadTask.this.e("fail:cancel", null));
                            return;
                        case 1:
                            jVar2.E(i2, JsApiAddNativeDownloadTask.this.e("fail:download fail", null));
                            return;
                        case 2:
                            hashMap.put("download_id", Long.valueOf(addNativeDownloadTaskTask.fnS));
                            jVar2.E(i2, JsApiAddNativeDownloadTask.this.e("ok", hashMap));
                            return;
                        default:
                            return;
                    }
                }
            };
            addNativeDownloadTaskTask.afy();
            AppBrandMainProcessService.a(addNativeDownloadTaskTask);
        }
    }
}
