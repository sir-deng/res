package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.bl.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseImage extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 29;
    public static final String NAME = "chooseImage";
    private static volatile boolean jpV = false;

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
        ArrayList<AppBrandLocalMediaObject> jqb;

        protected final void h(Parcel parcel) {
            this.bjW = parcel.readInt();
            this.jqb = parcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bjW);
            parcel.writeTypedList(this.jqb);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            super(parcel);
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
        int count;
        boolean jpX;
        boolean jpY;
        boolean jpZ;
        boolean jqa;

        protected final Class<? extends AppBrandProxyUIProcessTask> afD() {
            return a.class;
        }

        protected final void h(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.appId = parcel.readString();
            this.count = parcel.readInt();
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
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.jpZ = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.jqa = z2;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            parcel.writeString(this.appId);
            parcel.writeInt(this.count);
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
            if (this.jpZ) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.jqa) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
        }

        protected final String afC() {
            return "GalleryChooseImage";
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

    private static final class a extends AppBrandProxyUIProcessTask {
        ChooseRequest jqc;
        ChooseResult jqd = new ChooseResult();
        int jqe;
        private r jqf;
        private OnCancelListener jqg;

        private a() {
        }

        static /* synthetic */ void a(a aVar, String str, String str2, Intent intent) {
            aVar.afu().jCj = aVar;
            d.b(aVar.afu(), str, str2, intent, 3);
        }

        protected final void a(ProcessRequest processRequest) {
            int i;
            boolean i2;
            this.jqc = (ChooseRequest) processRequest;
            this.jqc.count = Math.max(1, Math.min(9, this.jqc.count));
            this.jqe = (this.jqc.jpZ & this.jqc.jqa) != 0 ? 8 : 7;
            if (bi.eZ(afu()) > 200) {
                i2 = 1;
            } else {
                i2 = false;
            }
            if (i2 == 0) {
                u.makeText(afu(), ad.getResources().getString(j.iBc), 1).show();
            }
            afu().jCj = this;
            Intent intent = new Intent();
            String str = "key_send_raw_image";
            if (this.jqc.jpZ) {
                i2 = false;
            } else {
                i2 = true;
            }
            intent.putExtra(str, i2);
            intent.putExtra("query_media_type", 1);
            if (this.jqc.jpX && this.jqc.jpY) {
                k.a(afu(), 1, this.jqc.count, this.jqe, intent);
            } else if (this.jqc.jpY) {
                intent.putExtra("show_header_view", false);
                k.a(afu(), 1, this.jqc.count, this.jqe, intent);
            } else if (this.jqc.jpX) {
                k.c(afu(), e.gJf, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
            } else {
                x.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
                this.jqd.bjW = -2;
                a(this.jqd);
            }
        }

        private void kD(int i) {
            this.jqg = new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    a.this.jqd.bjW = 0;
                    a.this.a(a.this.jqd);
                }
            };
            Context afu = afu();
            ad.getResources().getString(j.dGZ);
            this.jqf = h.a(afu, ad.getResources().getString(i), true, this.jqg);
        }

        private static String sQ(String str) {
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            if (orientationInDegree == 0) {
                return str;
            }
            orientationInDegree %= 360;
            try {
                Options options = new Options();
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options, 0);
                if (decodeFile == null) {
                    x.e("MicroMsg.JsApiChooseImage", "rotate image, get null bmp");
                    return str;
                }
                Bitmap b = com.tencent.mm.sdk.platformtools.d.b(decodeFile, (float) orientationInDegree);
                String str2 = e.gJf + "microMsg.tmp." + System.currentTimeMillis() + (com.tencent.mm.plugin.appbrand.r.a.a(options) ? ".jpg" : ".png");
                try {
                    com.tencent.mm.sdk.platformtools.d.a(b, 100, com.tencent.mm.plugin.appbrand.r.a.a(options) ? CompressFormat.JPEG : CompressFormat.PNG, str2, true);
                    if (com.tencent.mm.plugin.appbrand.r.a.a(options) && com.tencent.mm.a.e.bO(str) && com.tencent.mm.a.e.bO(str2)) {
                        try {
                            android.support.b.a aVar = new android.support.b.a(str2);
                            b.a(new android.support.b.a(str), aVar);
                            aVar.setAttribute(android.support.b.a.TAG_ORIENTATION, null);
                            aVar.setAttribute(android.support.b.a.TAG_IMAGE_WIDTH, null);
                            aVar.setAttribute(android.support.b.a.TAG_THUMBNAIL_IMAGE_WIDTH, null);
                            aVar.saveAttributes();
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.JsApiChooseImage", e, "duplicate exif", new Object[0]);
                        }
                    }
                    return str2;
                } catch (Exception e2) {
                    x.e("MicroMsg.JsApiChooseImage", "rotate image, exception occurred when saving | %s", e2);
                    b.deleteFile(str2);
                    return str;
                }
            } catch (OutOfMemoryError e3) {
                return str;
            } catch (NullPointerException e4) {
                return str;
            }
        }

        private static String sR(String str) {
            Bitmap decodeFile;
            String str2 = e.gJf + "microMsg." + System.currentTimeMillis() + ".jpg";
            try {
                decodeFile = MMBitmapFactory.decodeFile(str, 0);
            } catch (OutOfMemoryError e) {
                x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom");
                try {
                    decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                } catch (OutOfMemoryError e2) {
                    x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, oom again");
                    decodeFile = null;
                } catch (Exception e3) {
                    x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, e " + e3);
                    decodeFile = null;
                }
            } catch (NullPointerException e4) {
                try {
                    decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                } catch (Exception e32) {
                    x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp npe retry, e " + e32);
                    decodeFile = null;
                }
            } catch (Exception e322) {
                x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp e " + e322);
                decodeFile = null;
            }
            if (decodeFile == null) {
                x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp return null");
                return null;
            }
            long Wy = bi.Wy();
            x.i("MicroMsg.JsApiChooseImage", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", Boolean.valueOf(com.tencent.mm.plugin.appbrand.r.a.bL(str2, str)), Long.valueOf(bi.Wy() - Wy), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length()));
            return com.tencent.mm.plugin.appbrand.r.a.bL(str2, str) ? str2 : str;
        }

        protected final void afA() {
            super.afA();
            if (this.jqf != null) {
                this.jqf.dismiss();
                this.jqf = null;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(int r12, int r13, android.content.Intent r14) {
            /*
            r11 = this;
            r3 = -2;
            r5 = 1;
            r1 = 0;
            if (r13 != 0) goto L_0x000f;
        L_0x0005:
            r0 = r11.jqd;
            r0.bjW = r1;
            r0 = r11.jqd;
            r11.a(r0);
        L_0x000e:
            return;
        L_0x000f:
            switch(r12) {
                case 1: goto L_0x001c;
                case 2: goto L_0x00e7;
                case 3: goto L_0x001c;
                default: goto L_0x0012;
            };
        L_0x0012:
            r0 = r11.jqd;
            r0.bjW = r3;
            r0 = r11.jqd;
            r11.a(r0);
            goto L_0x000e;
        L_0x001c:
            if (r14 != 0) goto L_0x0028;
        L_0x001e:
            r0 = r11.jqd;
            r0.bjW = r1;
            r0 = r11.jqd;
            r11.a(r0);
            goto L_0x000e;
        L_0x0028:
            r0 = "CropImage_OutputPath_List";
            r2 = r14.getStringArrayListExtra(r0);
            r0 = "CropImage_Compress_Img";
            r6 = r14.getBooleanExtra(r0, r1);
            r0 = r11.jqc;
            r3 = r0.jpZ;
            r0 = r11.jqc;
            r0 = r0.jqa;
            if (r0 != 0) goto L_0x00db;
        L_0x0040:
            r0 = r5;
        L_0x0041:
            r0 = r0 & r3;
            if (r0 != 0) goto L_0x0050;
        L_0x0044:
            r0 = r11.jqc;
            r0 = r0.jpZ;
            r3 = r11.jqc;
            r3 = r3.jqa;
            r0 = r0 & r3;
            r0 = r0 & r6;
            if (r0 == 0) goto L_0x00de;
        L_0x0050:
            r4 = r5;
        L_0x0051:
            r0 = "isTakePhoto";
            r0 = r14.getBooleanExtra(r0, r1);
            if (r0 != 0) goto L_0x0063;
        L_0x005a:
            r0 = "isPreviewPhoto";
            r0 = r14.getBooleanExtra(r0, r1);
            if (r0 == 0) goto L_0x00e1;
        L_0x0063:
            r3 = r5;
        L_0x0064:
            r0 = "MicroMsg.JsApiChooseImage";
            r7 = "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b";
            r8 = 5;
            r8 = new java.lang.Object[r8];
            r9 = java.lang.Boolean.valueOf(r3);
            r8[r1] = r9;
            r9 = r11.jqc;
            r9 = r9.jpZ;
            r9 = java.lang.Boolean.valueOf(r9);
            r8[r5] = r9;
            r9 = 2;
            r10 = r11.jqc;
            r10 = r10.jqa;
            r10 = java.lang.Boolean.valueOf(r10);
            r8[r9] = r10;
            r9 = 3;
            r6 = java.lang.Boolean.valueOf(r6);
            r8[r9] = r6;
            r6 = 4;
            r9 = java.lang.Boolean.valueOf(r4);
            r8[r6] = r9;
            com.tencent.mm.sdk.platformtools.x.d(r0, r7, r8);
            if (r4 == 0) goto L_0x00a0;
        L_0x009b:
            r0 = com.tencent.mm.plugin.appbrand.q.j.iBd;
            r11.kD(r0);
        L_0x00a0:
            if (r4 != 0) goto L_0x00e5;
        L_0x00a2:
            r0 = com.tencent.mm.sdk.platformtools.bi.cC(r2);
            if (r0 != 0) goto L_0x00e3;
        L_0x00a8:
            r6 = r2.iterator();
        L_0x00ac:
            r0 = r6.hasNext();
            if (r0 == 0) goto L_0x00e3;
        L_0x00b2:
            r0 = r6.next();
            r0 = (java.lang.String) r0;
            r0 = com.tencent.mm.compatible.util.Exif.fromFile(r0);
            r0 = r0.getOrientationInDegree();
            if (r0 == 0) goto L_0x00ac;
        L_0x00c2:
            r0 = r5;
        L_0x00c3:
            if (r0 == 0) goto L_0x00e5;
        L_0x00c5:
            if (r5 == 0) goto L_0x00cc;
        L_0x00c7:
            r0 = com.tencent.mm.plugin.appbrand.q.j.iCi;
            r11.kD(r0);
        L_0x00cc:
            r6 = com.tencent.mm.plugin.appbrand.r.c.Dt();
            r0 = new com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage$a$2;
            r1 = r11;
            r0.<init>(r2, r3, r4, r5);
            r6.F(r0);
            goto L_0x000e;
        L_0x00db:
            r0 = r1;
            goto L_0x0041;
        L_0x00de:
            r4 = r1;
            goto L_0x0051;
        L_0x00e1:
            r3 = r1;
            goto L_0x0064;
        L_0x00e3:
            r0 = r1;
            goto L_0x00c3;
        L_0x00e5:
            r5 = r1;
            goto L_0x00c5;
        L_0x00e7:
            r0 = r11.afu();
            r0 = r0.getApplicationContext();
            r2 = com.tencent.mm.compatible.util.e.gJf;
            r0 = com.tencent.mm.pluginsdk.ui.tools.k.b(r0, r14, r2);
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r2 == 0) goto L_0x010f;
        L_0x00fb:
            r0 = "MicroMsg.JsApiChooseImage";
            r1 = "take photo, but result is null";
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);
            r0 = r11.jqd;
            r0.bjW = r3;
            r0 = r11.jqd;
            r11.a(r0);
            goto L_0x000e;
        L_0x010f:
            r2 = "MicroMsg.JsApiChooseImage";
            r3 = "take photo, result[%s]";
            r4 = new java.lang.Object[r5];
            r4[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
            r1 = new com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage$a$3;
            r1.<init>(r0);
            com.tencent.mm.sdk.platformtools.ah.y(r1);
            goto L_0x000e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.b(int, int, android.content.Intent):void");
        }
    }

    static /* synthetic */ String i(ArrayList arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.JsApiChooseImage", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        return jSONArray.toString();
    }

    static /* synthetic */ JSONArray j(ArrayList arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.JsApiChooseImage", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        return jSONArray;
    }

    public final void a(final com.tencent.mm.plugin.appbrand.j jVar, final JSONObject jSONObject, final int i) {
        int i2 = 0;
        if (jpV) {
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
        String optString = jSONObject.optString("sizeType");
        x.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", optJSONArray, optString, jSONObject.optString("count"));
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.jpX = true;
            chooseRequest.jpY = true;
        } else {
            chooseRequest.jpX = optJSONArray.toString().contains("camera");
            chooseRequest.jpY = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        }
        if (chooseRequest.jpX) {
            com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new android.support.v4.app.a.a() {
                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i == 113) {
                        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            jVar.E(i, JsApiChooseImage.this.e("fail:system permission denied", null));
                        } else {
                            JsApiChooseImage.this.a(jVar, jSONObject, i);
                        }
                    }
                }
            });
            Activity a2 = a(jVar);
            if (a2 == null) {
                jVar.E(i, e("fail", null));
            } else {
                i2 = com.tencent.mm.pluginsdk.g.a.a(a2, "android.permission.CAMERA", 113, "", "");
                if (i2 != 0) {
                    com.tencent.mm.plugin.appbrand.a.pj(jVar.mAppId);
                }
            }
            if (i2 == 0) {
                return;
            }
        }
        jpV = true;
        c.a(jVar.mAppId, new c.b() {
            public final void onResume() {
                JsApiChooseImage.jpV = false;
                c.b(jVar.mAppId, this);
            }
        });
        if (bi.oN(optString)) {
            optString = "compressed";
        }
        chooseRequest.jpZ = optString.contains("compressed");
        chooseRequest.jqa = optString.contains("original");
        chooseRequest.count = bi.getInt(r5, 9);
        chooseRequest.appId = jVar.mAppId;
        com.tencent.mm.plugin.appbrand.ipc.a.b(a, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>() {
            public final /* synthetic */ void c(ProcessResult processResult) {
                ChooseResult chooseResult = (ChooseResult) processResult;
                if (chooseResult != null) {
                    switch (chooseResult.bjW) {
                        case -1:
                            ArrayList arrayList = chooseResult.jqb;
                            if (bi.cC(arrayList)) {
                                x.e("MicroMsg.JsApiChooseImage", "onActivityResult, result list is null or nil");
                                break;
                            }
                            ArrayList arrayList2 = new ArrayList(arrayList.size());
                            ArrayList arrayList3 = new ArrayList(arrayList.size());
                            ArrayList arrayList4 = new ArrayList(arrayList.size());
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                AppBrandLocalMediaObject appBrandLocalMediaObject = (AppBrandLocalMediaObject) it.next();
                                if (!(appBrandLocalMediaObject == null || bi.oN(appBrandLocalMediaObject.fvn))) {
                                    arrayList2.add(appBrandLocalMediaObject.fvn);
                                    arrayList3.add(Long.valueOf(appBrandLocalMediaObject.igZ));
                                    arrayList4.add(appBrandLocalMediaObject.hjJ);
                                }
                            }
                            x.i("MicroMsg.JsApiChooseImage", "onActivityResult, localIds json list string = %s", JsApiChooseImage.i(arrayList2));
                            Map hashMap = new HashMap(1);
                            hashMap.put("tempFilePaths", JsApiChooseImage.j(arrayList2));
                            hashMap.put("tempFileSizes", JsApiChooseImage.j(arrayList3));
                            if (com.tencent.mm.sdk.a.b.cfx()) {
                                hashMap.put("__realPaths", JsApiChooseImage.j(arrayList4));
                            }
                            jVar.E(i, JsApiChooseImage.this.e("ok", hashMap));
                            return;
                        case 0:
                            jVar.E(i, JsApiChooseImage.this.e("cancel", null));
                            return;
                    }
                }
                jVar.E(i, JsApiChooseImage.this.e("fail", null));
            }
        });
    }
}
