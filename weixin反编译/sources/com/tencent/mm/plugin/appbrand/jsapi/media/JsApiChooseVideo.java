package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 36;
    public static final String NAME = "chooseVideo";
    private static volatile boolean jqG = false;

    private static final class a extends AppBrandProxyUIProcessTask {
        private ChooseResult jqK = new ChooseResult();
        private ChooseRequest jqL;
        private r jqf;
        private OnCancelListener jqg;
        private String jqx;

        private a() {
        }

        protected final void a(ProcessRequest processRequest) {
            int i;
            this.jqL = (ChooseRequest) processRequest;
            this.jqL.maxDuration = Math.min(Math.max(this.jqL.maxDuration, 60), 0);
            if (bi.eZ(afu()) > 200) {
                i = 1;
            } else {
                boolean i2 = false;
            }
            if (i2 == 0) {
                u.makeText(afu(), ad.getResources().getString(j.iBe), 1).show();
            }
            afu().jCj = this;
            Intent intent = new Intent();
            intent.putExtra("key_send_raw_image", false);
            intent.putExtra("query_media_type", 2);
            if (this.jqL.jpX && this.jqL.jpY) {
                this.jqx = e.gJf + "microMsg." + System.currentTimeMillis() + ".mp4";
                intent.putExtra("record_video_force_sys_camera", true);
                intent.putExtra("record_video_quality", 1);
                intent.putExtra("record_video_time_limit", this.jqL.maxDuration);
                intent.putExtra("video_full_path", this.jqx);
                k.c(afu(), 1, 7, intent);
            } else if (this.jqL.jpX) {
                this.jqx = e.gJf + "microMsg." + System.currentTimeMillis() + ".mp4";
                k.a(afu(), this.jqx, 5, this.jqL.maxDuration, 1, false);
            } else if (this.jqL.jpY) {
                intent.putExtra("show_header_view", false);
                k.c(afu(), 1, 7, intent);
            } else {
                this.jqK.bjW = -2;
                a(this.jqK);
            }
        }

        protected final void afA() {
            super.afA();
            if (this.jqf != null) {
                this.jqf.dismiss();
                this.jqf = null;
            }
        }

        private void agP() {
            this.jqg = new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    a.this.jqK.bjW = 0;
                    a.this.a(a.this.jqK);
                }
            };
            Context afu = afu();
            ad.getResources().getString(j.dGZ);
            this.jqf = h.a(afu, ad.getResources().getString(j.iBe), true, this.jqg);
        }

        public final void b(int i, int i2, Intent intent) {
            if (i2 == 0) {
                this.jqK.bjW = 0;
                a(this.jqK);
            } else if (-1 != i2) {
                this.jqK.bjW = -2;
                a(this.jqK);
            } else {
                switch (i) {
                    case 4:
                        List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                        if (!bi.cC(stringArrayListExtra)) {
                            final String str = (String) stringArrayListExtra.get(0);
                            agP();
                            c.Dt().F(new Runnable() {
                                public final void run() {
                                    a.this.jqK.bjW = -1;
                                    a.this.jqK.jqJ = a.this.U(str, a.this.jqL.jqI);
                                    a.this.a(a.this.jqK);
                                }
                            });
                            return;
                        }
                        break;
                    case 5:
                        if (!bi.oN(this.jqx)) {
                            agP();
                            c.Dt().F(new Runnable() {
                                public final void run() {
                                    if (new File(a.this.jqx).exists()) {
                                        a.this.jqK.bjW = -1;
                                        a.this.jqK.jqJ = a.this.U(a.this.jqx, a.this.jqL.jqI);
                                        a.this.a(a.this.jqK);
                                        return;
                                    }
                                    a.this.jqK.bjW = -2;
                                    a.this.a(a.this.jqK);
                                }
                            });
                            return;
                        }
                        break;
                }
                this.jqK.bjW = -2;
                a(this.jqK);
            }
        }

        private AppBrandLocalVideoObject U(String str, boolean z) {
            int i;
            int i2;
            MediaMetadataRetriever mediaMetadataRetriever;
            if (z) {
                try {
                    boolean oQ = com.tencent.mm.plugin.a.c.oQ(str);
                    x.i("MicroMsg.JsApiChooseVideo", "checkRemux, isMp4 = %b", Boolean.valueOf(oQ));
                    int i3 = -10000;
                    if (oQ) {
                        i3 = SightVideoJNI.shouldRemuxing(str, 660, 500, 26214400, 300000.0d, Constants.MAX_BUFFER_SIZE);
                        x.i("MicroMsg.JsApiChooseVideo", "checkRemux, ret = %d", Integer.valueOf(i3));
                    }
                    if (i3 == -1 || !oQ) {
                        x.i("MicroMsg.JsApiChooseVideo", "fileLength = %d", Integer.valueOf(com.tencent.mm.a.e.bN(str)));
                        i3 = com.tencent.mm.a.e.bN(str) > 26214400 ? -1 : 1;
                    }
                    switch (i3) {
                        case -6:
                        case -5:
                        case -4:
                        case -3:
                        case -2:
                        case -1:
                            i3 = -50002;
                            break;
                        case 0:
                            i3 = -50006;
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            i3 = 1;
                            break;
                        default:
                            x.e("MicroMsg.JsApiChooseVideo", "unknown check type");
                            i3 = -50001;
                            break;
                    }
                    if (i3 == -50006) {
                        int[] iArr = new int[2];
                        com.tencent.mm.pluginsdk.model.k.d(str, iArr);
                        i = iArr[0];
                        i2 = iArr[1];
                        String str2 = e.gJf + "microMsg." + System.currentTimeMillis() + ".mp4";
                        i3 = SightVideoJNI.remuxing(str, str2, i, i2, b.qzb, b.qza, 8, 2, 25.0f, b.qzc, null, 0, false);
                        x.i("MicroMsg.JsApiChooseVideo", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                        str = str2;
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", bi.i(e));
                }
            }
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
            } catch (Exception e2) {
                x.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e2);
                mediaMetadataRetriever = null;
            }
            if (mediaMetadataRetriever == null) {
                x.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
                return null;
            }
            int i4 = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            i = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            mediaMetadataRetriever.release();
            AppBrandLocalVideoObject attachVideo = AppBrandLocalMediaObjectManager.attachVideo(this.jqL.appId, str);
            if (attachVideo == null) {
                return null;
            }
            attachVideo.duration = (i2 + 500) / 1000;
            attachVideo.width = i4;
            attachVideo.height = i;
            attachVideo.size = com.tencent.mm.a.e.bN(str);
            x.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", attachVideo);
            return attachVideo;
        }
    }

    private static final class ChooseRequest extends ProcessRequest {
        public static final Creator<ChooseRequest> CREATOR = new Creator<ChooseRequest>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ChooseRequest(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseRequest[i];
            }
        };
        String appId;
        boolean jpX;
        boolean jpY;
        boolean jqI;
        int maxDuration;

        protected final Class<? extends AppBrandProxyUIProcessTask> afD() {
            return a.class;
        }

        protected final String afC() {
            return "GalleryChooseVideo";
        }

        protected final void h(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.appId = parcel.readString();
            this.maxDuration = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.jpX = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.jpY = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.jqI = z2;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            parcel.writeString(this.appId);
            parcel.writeInt(this.maxDuration);
            if (this.jpX) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.jpY) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.jqI) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
        }

        protected final boolean afB() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            h(parcel);
        }
    }

    private static final class ChooseResult extends ProcessResult {
        public static final Creator<ChooseResult> CREATOR = new Creator<ChooseResult>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ChooseResult(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseResult[i];
            }
        };
        int bjW;
        AppBrandLocalVideoObject jqJ;

        protected final void h(Parcel parcel) {
            this.bjW = parcel.readInt();
            this.jqJ = (AppBrandLocalVideoObject) parcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader());
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bjW);
            parcel.writeParcelable(this.jqJ, i);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            h(parcel);
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.j jVar, final JSONObject jSONObject, final int i) {
        int i2 = 0;
        if (jqG) {
            jVar.E(i, e("cancel", null));
            return;
        }
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        ProcessRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        x.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", optJSONArray, jSONObject.optString("maxDuration"));
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.jpX = true;
            chooseRequest.jpY = true;
        } else {
            chooseRequest.jpX = optJSONArray.toString().contains("camera");
            chooseRequest.jpY = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        }
        chooseRequest.jqI = jSONObject.optBoolean("compressed", true);
        if (chooseRequest.jpX) {
            com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new android.support.v4.app.a.a() {
                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i == 115) {
                        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            jVar.E(i, JsApiChooseVideo.this.e("fail:system permission denied", null));
                        } else {
                            JsApiChooseVideo.this.a(jVar, jSONObject, i);
                        }
                    }
                }
            });
            Activity a2 = a(jVar);
            if (a2 == null) {
                jVar.E(i, e("fail", null));
            } else {
                i2 = com.tencent.mm.pluginsdk.g.a.a(a2, "android.permission.CAMERA", 115, "", "");
                if (i2 != 0) {
                    com.tencent.mm.plugin.appbrand.a.pj(jVar.mAppId);
                }
            }
            if (i2 == 0) {
                return;
            }
        }
        jqG = true;
        com.tencent.mm.plugin.appbrand.c.a(jVar.mAppId, new com.tencent.mm.plugin.appbrand.c.b() {
            public final void onResume() {
                JsApiChooseVideo.jqG = false;
                com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, this);
            }
        });
        chooseRequest.maxDuration = bi.getInt(r4, 60);
        chooseRequest.appId = jVar.mAppId;
        com.tencent.mm.plugin.appbrand.ipc.a.b(a, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>() {
            public final /* synthetic */ void c(ProcessResult processResult) {
                ChooseResult chooseResult = (ChooseResult) processResult;
                if (chooseResult != null) {
                    switch (chooseResult.bjW) {
                        case -1:
                            AppBrandLocalVideoObject appBrandLocalVideoObject = chooseResult.jqJ;
                            if (appBrandLocalVideoObject == null) {
                                x.e("MicroMsg.JsApiChooseVideo", "choose result code is OK but videoObj null");
                                break;
                            }
                            Map hashMap = new HashMap();
                            hashMap.put("tempFilePath", appBrandLocalVideoObject.fvn);
                            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(appBrandLocalVideoObject.duration));
                            hashMap.put("size", Integer.valueOf(appBrandLocalVideoObject.size));
                            hashMap.put("height", Integer.valueOf(appBrandLocalVideoObject.height));
                            hashMap.put("width", Integer.valueOf(appBrandLocalVideoObject.width));
                            jVar.E(i, JsApiChooseVideo.this.e("ok", hashMap));
                            return;
                        case 0:
                            jVar.E(i, JsApiChooseVideo.this.e("cancel", null));
                            return;
                    }
                }
                jVar.E(i, JsApiChooseVideo.this.e("fail", null));
            }
        });
    }
}
