package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppBrandCameraView extends RelativeLayout implements d, e, f {
    private ImageView fwa;
    private int jlA = 1080;
    private int jlB = 1920;
    c jlC;
    b jlD;
    MMSightRecordView jlE;
    private String jlF;
    private String jlG;
    private String jlH;
    int jlI = -1;
    boolean jlJ = false;
    long jlK = -1;
    long jlL = -1;
    a jlM = new a() {
    };
    p jlr;
    int jls;
    private String jlt = "back";
    String jlu = "auto";
    String jlv = "high";
    boolean jlw;
    private boolean jlx = false;
    private int jly = 1080;
    private int jlz = 1920;
    String mAppId;
    Context mContext;

    static /* synthetic */ void a(AppBrandCameraView appBrandCameraView, int i, String str, String str2) {
        x.i("MicroMsg.AppBrandCameraView", "onTakePhoto.ret:%d, path:%s, errMsg:%s", Integer.valueOf(i), str, str2);
        if (appBrandCameraView.jlC != null) {
            appBrandCameraView.jlC.b(i, str, str2, appBrandCameraView.jlA, appBrandCameraView.jlB);
        }
        appBrandCameraView.jlJ = false;
        appBrandCameraView.agt();
        appBrandCameraView.jlI = 1;
    }

    public AppBrandCameraView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(h.izh, this);
    }

    public final void initView() {
        x.i("MicroMsg.AppBrandCameraView", "initView");
        if (a.jlq.ago()) {
            agu();
            agt();
            agr();
            ags();
        }
    }

    public final void T(String str, boolean z) {
        if (!bi.fA(this.jlt, str)) {
            this.jlt = str;
            if (!z && this.jlE != null) {
                this.jlE.owD.switchCamera();
            }
        }
    }

    public final void sG(String str) {
        if (!bi.fA(this.jlu, str)) {
            this.jlu = str;
        }
    }

    public final boolean bH(int i, int i2) {
        if (this.jly == i && this.jlz == i2) {
            return false;
        }
        x.i("MicroMsg.AppBrandCameraView", "setViewSize");
        this.jly = i;
        this.jlz = i2;
        return true;
    }

    public final void afQ() {
        Map hashMap;
        String jSONObject;
        com.tencent.mm.plugin.appbrand.jsapi.f a;
        x.i("MicroMsg.AppBrandCameraView", "onUIPause");
        if (this.jlI == 2) {
            x.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
            hashMap = new HashMap();
            hashMap.put("cameraId", Integer.valueOf(this.jls));
            hashMap.put("errMsg", "stop on record");
            jSONObject = new JSONObject(hashMap).toString();
            a = new g().a(this.jlr);
            a.mData = jSONObject;
            a.afI();
        }
        if (this.jlE != null) {
            Bitmap Yv = this.jlE.owD.Yv();
            if (Yv != null) {
                this.fwa.setImageBitmap(Yv);
            }
        }
        release();
        hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(this.jls));
        jSONObject = new JSONObject(hashMap).toString();
        a = new e().a(this.jlr);
        a.mData = jSONObject;
        a.afI();
    }

    public final void agq() {
        x.i("MicroMsg.AppBrandCameraView", "onUIResume");
        synchronized (AppBrandCameraView.class) {
            agr();
        }
    }

    public final void onDestroy() {
        release();
    }

    public final void release() {
        x.i("MicroMsg.AppBrandCameraView", "release");
        synchronized (AppBrandCameraView.class) {
            if (this.jlE != null) {
                this.jlE.owD.release();
                removeView(this.jlE);
                this.jlI = -1;
                this.jlE = null;
            }
        }
    }

    private String sH(String str) {
        if (bi.oN(str)) {
            return str;
        }
        AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(this.mAppId, str, true);
        if (attach != null) {
            return attach.fvn;
        }
        return null;
    }

    private void agr() {
        x.i("MicroMsg.AppBrandCameraView", "initCamera.");
        if (!a.jlq.ago()) {
            Toast.makeText(this.mContext, j.iEt, 1).show();
            x.w("MicroMsg.AppBrandCameraView", "no permission");
        } else if (this.jlE != null) {
            x.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
        } else {
            if (this.fwa == null) {
                this.fwa = new ImageView(this.mContext);
                this.fwa.setScaleType(ScaleType.FIT_XY);
                addView(this.fwa, new LayoutParams(-1, -1));
            } else {
                this.fwa.setImageBitmap(null);
            }
            this.jlE = new MMSightRecordView(this.mContext);
            addView(this.jlE);
            this.jlE.js(720);
            this.jlE.owD.Yu();
            this.jlE.R((((float) this.jly) * 1.0f) / ((float) this.jlz));
            this.jlE.tc(600000);
            this.jlE.ph(this.jlF);
            this.jlE.bay();
            this.jlE.bax();
            MMSightRecordView mMSightRecordView = this.jlE;
            mMSightRecordView.owD.cm("back".equals(this.jlt));
            this.jlE.owD.startPreview();
            this.jlE.owD.Yl();
            mMSightRecordView = this.jlE;
            mMSightRecordView.owD.a(new c() {
                public final void agx() {
                    x.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
                    Map hashMap = new HashMap();
                    hashMap.put("cameraId", Integer.valueOf(AppBrandCameraView.this.jls));
                    String jSONObject = new JSONObject(hashMap).toString();
                    com.tencent.mm.plugin.appbrand.jsapi.f a = new d().a(AppBrandCameraView.this.jlr);
                    a.mData = jSONObject;
                    a.afI();
                }
            });
            this.jlI = 1;
        }
    }

    public final void ags() {
        if (this.jlE == null) {
            x.i("MicroMsg.AppBrandCameraView", "recordView is null");
            return;
        }
        if (this.jlw) {
            this.jlE.a(this.jlM);
        } else {
            this.jlE.a(null);
        }
        agv();
    }

    private void agt() {
        this.jlH = com.tencent.mm.compatible.util.e.gJf + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
    }

    private void agu() {
        String str = "MicroMsg_" + System.currentTimeMillis();
        this.jlF = com.tencent.mm.compatible.util.e.gJf + str + ".mp4";
        this.jlG = com.tencent.mm.compatible.util.e.gJf + str + ".jpeg";
        if (this.jlE != null) {
            this.jlE.ph(this.jlF);
        }
    }

    public final void agv() {
        if (this.jlE != null && this.jlu != null) {
            if (this.jlI != 2) {
                if (this.jlE.owD.Ys() == 1) {
                    this.jlE.jt(2);
                }
                if (this.jlu.equals("auto")) {
                    this.jlE.jt(3);
                }
            } else if (this.jlu.equals("on")) {
                this.jlE.jt(1);
            } else {
                this.jlE.jt(2);
            }
        }
    }

    final void I(int i, String str) {
        if (this.jlC != null) {
            this.jlC.I(i, str);
        }
    }

    public final void uF() {
        x.i("MicroMsg.AppBrandCameraView", JsApiStopRecordVoice.NAME);
        if (this.jlE == null) {
            x.i("MicroMsg.AppBrandCameraView", "recordView is null");
            c(-1, "camera is null", null, null);
        } else if (this.jlI != 2) {
            x.w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
            c(-1, "is not recording", null, null);
        } else if (this.jlx) {
            x.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
            c(-1, "is stopping", null, null);
        } else {
            this.jlx = true;
            this.jlE.a(new MMSightRecordView.f() {
                public final void cL(boolean z) {
                    x.i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", Boolean.valueOf(z));
                    if (AppBrandCameraView.this.jlE == null) {
                        x.i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
                        AppBrandCameraView.this.c(-1, "camera is null", null, null);
                        return;
                    }
                    AppBrandCameraView.this.jlI = 1;
                    if (z) {
                        AppBrandCameraView.this.c(-1, "stop error", null, null);
                    } else {
                        AppBrandCameraView.this.a(com.tencent.mm.plugin.sight.base.d.U(AppBrandCameraView.this.jlE.owD.Yk(), AppBrandCameraView.this.jly, AppBrandCameraView.this.jlz), AppBrandCameraView.this.jlG);
                        AppBrandCameraView.this.c(0, "", AppBrandCameraView.this.jlG, AppBrandCameraView.this.jlE.owD.Yk());
                    }
                    AppBrandCameraView.this.agu();
                    AppBrandCameraView.this.jlx = false;
                }
            });
        }
    }

    private void c(int i, String str, String str2, String str3) {
        if (this.jlC != null) {
            this.jlC.c(i, str, sH(str2), sH(str3));
        }
        agv();
    }

    private boolean a(Bitmap bitmap, String str) {
        if (!(bitmap == null || bitmap.isRecycled())) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (!(width == 0 || height == 0)) {
                    if ("normal".equals(this.jlv)) {
                        bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, (height * 2) / 3, (width * 2) / 3, false, true);
                    } else if ("low".equals(this.jlv)) {
                        bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, height / 2, width / 2, false, true);
                    }
                }
                this.jlA = bitmap.getWidth();
                this.jlB = bitmap.getHeight();
                com.tencent.mm.sdk.platformtools.d.a(bitmap, 90, CompressFormat.JPEG, str, true);
                x.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", Long.valueOf(FileOp.mi(str)));
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", e.getMessage());
            }
        }
        return false;
    }
}
