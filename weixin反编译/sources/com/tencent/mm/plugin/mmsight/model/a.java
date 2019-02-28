package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a {
    static a owI;
    public int fGt = 0;
    public long fileSize;
    public int gHV;
    int mlH;
    String model = Build.MODEL;
    String owJ = (VERSION.SDK_INT);
    int owK;
    String owL;
    int owM;
    int owN;
    public String owO;
    public String owP;
    public String owQ;
    public String owR;
    public int owS;
    public int owT;
    public int owU;
    public int owV;
    public int owW;
    public int owX;
    public int owY;
    public int owZ;
    public int oxa;
    public int oxb;
    public int oxc;
    public int oxd;
    public int oxe;
    int oxf;
    public int oxg;
    public int oxh;
    public int oxi;
    public long oxj;
    public int oxk;
    JSONObject oxl = null;
    public int videoBitrate;

    public static a baz() {
        if (owI == null) {
            reset();
        }
        return owI;
    }

    public static void reset() {
        a aVar = new a();
        owI = aVar;
        aVar.mlH = ((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass();
        owI.owK = d.dd(ad.getContext());
        owI.owL = m.yx();
        Point dc = d.dc(ad.getContext());
        owI.owM = dc.x;
        owI.owN = dc.y;
    }

    public final String baA() {
        if (this.oxl == null) {
            try {
                this.oxl = new JSONObject();
                JSONObject jSONObject = new JSONObject();
                this.oxl.put("wxcamera", jSONObject);
                jSONObject.put("model", this.model);
                jSONObject.put("apiLevel", this.owJ);
                jSONObject.put("screen", String.format("%dx%d", new Object[]{Integer.valueOf(this.owM), Integer.valueOf(this.owN)}));
                jSONObject.put("crop", String.format("%dx%d", new Object[]{Integer.valueOf(this.owS), Integer.valueOf(this.owT)}));
                jSONObject.put("preview", String.format("%dx%d", new Object[]{Integer.valueOf(this.owU), Integer.valueOf(this.owV)}));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_ENCODER, String.format("%dx%d", new Object[]{Integer.valueOf(this.owW), Integer.valueOf(this.owX)}));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, this.fGt);
                jSONObject.put("deviceoutfps", this.owY);
                jSONObject.put("recordfps", this.owZ);
                jSONObject.put("recordertype", this.oxa);
                jSONObject.put("needRotateEachFrame", this.gHV);
                jSONObject.put("isNeedRealtimeScale", this.oxb);
                jSONObject.put("resolutionLimit", this.oxc);
                jSONObject.put("videoBitrate", this.videoBitrate);
                jSONObject.put("wait2playtime", this.oxj);
                jSONObject.put("useback", this.oxk);
                jSONObject.put("presetIndex", j.oyD != null ? j.oyD.oyM : -1);
                jSONObject.put("recorderOption", q.gHM.gIb);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CaptureStatistics", e, "buildJson error", new Object[0]);
            }
        }
        return this.oxl.toString();
    }
}
