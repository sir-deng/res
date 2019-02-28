package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.au.b;
import com.tencent.mm.au.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetMusicPlayerState extends a {
    public static final int CTRL_INDEX = 46;
    public static final String NAME = "getMusicPlayerState";
    private GetMusicPlayerState jhT;

    private static class GetMusicPlayerState extends MainProcessTask {
        public static final Creator<GetMusicPlayerState> CREATOR = new Creator<GetMusicPlayerState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetMusicPlayerState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetMusicPlayerState[i];
            }
        };
        private e jfZ;
        private j jga;
        private int jgb;
        public String jhM;
        public boolean jhO = false;
        public String jhU;
        public int jhV;
        public String jhW;
        public int mDuration;
        public int mPosition;
        public int mStatus;

        public GetMusicPlayerState(e eVar, j jVar, int i) {
            this.jfZ = eVar;
            this.jga = jVar;
            this.jgb = i;
        }

        public GetMusicPlayerState(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            int i = -1;
            String str = a.jFe.jFc;
            if (bi.oN(str) || str.equals(this.jhU)) {
                ati Qz = b.Qz();
                if (Qz != null) {
                    int i2;
                    d QA = b.QA();
                    if (QA != null) {
                        i2 = QA.mDuration;
                        i = QA.mPosition;
                        this.mStatus = QA.mStatus;
                        this.jhV = QA.hJL;
                    } else {
                        i2 = -1;
                    }
                    this.mDuration = i2 / 1000;
                    this.mPosition = i / 1000;
                    this.jhW = Qz.wHz;
                    this.jhM = "";
                    this.jhO = false;
                } else {
                    this.mStatus = 2;
                    this.jhM = "";
                    this.jhO = false;
                }
                x.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", Integer.valueOf(this.mDuration), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.jhV), this.jhW);
                afF();
                return;
            }
            x.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
            this.jhO = true;
            this.jhM = "appid not match cannot operate";
            afF();
        }

        public final void YB() {
            String str;
            Map hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.mDuration));
            hashMap.put("currentPosition", Integer.valueOf(this.mPosition));
            hashMap.put(DownloadInfo.STATUS, Integer.valueOf(this.mStatus));
            hashMap.put("downloadPercent", Integer.valueOf(this.jhV));
            hashMap.put("dataUrl", this.jhW);
            j jVar = this.jga;
            int i = this.jgb;
            e eVar = this.jfZ;
            if (this.jhO) {
                str = "fail" + (TextUtils.isEmpty(this.jhM) ? "" : ":" + this.jhM);
            } else {
                str = "ok";
            }
            jVar.E(i, eVar.e(str, hashMap));
        }

        public final void f(Parcel parcel) {
            this.jhU = parcel.readString();
            this.jhO = parcel.readByte() != (byte) 0;
            this.mDuration = parcel.readInt();
            this.mPosition = parcel.readInt();
            this.mStatus = parcel.readInt();
            this.jhV = parcel.readInt();
            this.jhW = parcel.readString();
            this.jhM = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.jhU);
            parcel.writeByte(this.jhO ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.mDuration);
            parcel.writeInt(this.mPosition);
            parcel.writeInt(this.mStatus);
            parcel.writeInt(this.jhV);
            parcel.writeString(this.jhW);
            parcel.writeString(this.jhM);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        this.jhT = new GetMusicPlayerState(this, jVar, i);
        this.jhT.jhU = jVar.mAppId;
        AppBrandMainProcessService.a(this.jhT);
    }
}
