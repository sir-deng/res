package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.i.a.b.b;
import com.tencent.mm.pluginsdk.i.a.b.i;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig implements Parcelable {
    public static final Creator<AppBrandGlobalSystemConfig> CREATOR = new Creator<AppBrandGlobalSystemConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandGlobalSystemConfig(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandGlobalSystemConfig[i];
        }
    };
    private static volatile AppBrandGlobalSystemConfig iQs;
    private static final AppBrandGlobalSystemConfig iQt;
    public HttpSetting iQA;
    public int[] iQB;
    public int iQC;
    public int iQD;
    public int iQE;
    public int iQF;
    public int iQG;
    public int iQH;
    public int iQI;
    public int iQJ;
    public int iQK;
    public String[] iQL;
    public double iQM;
    public int iQN;
    public WeAppSyncVersionSetting iQO;
    public int iQu = Integer.MAX_VALUE;
    public int iQv;
    public int iQw;
    public int iQx;
    public int iQy;
    public String iQz;

    public static final class WeAppSyncVersionSetting implements Parcelable {
        public static final Creator<WeAppSyncVersionSetting> CREATOR = new Creator<WeAppSyncVersionSetting>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new WeAppSyncVersionSetting(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WeAppSyncVersionSetting[i];
            }
        };
        public long iQY = 21600;
        public long iQZ = 604800;
        public int iRa = 1000;
        public int iRb = 100;

        WeAppSyncVersionSetting() {
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.iQY);
            parcel.writeLong(this.iQZ);
            parcel.writeInt(this.iRa);
            parcel.writeInt(this.iRb);
        }

        WeAppSyncVersionSetting(Parcel parcel) {
            this.iQY = parcel.readLong();
            this.iQZ = parcel.readLong();
            this.iRa = parcel.readInt();
            this.iRb = parcel.readInt();
        }
    }

    public static final class HttpSetting implements Parcelable {
        public static final Creator<HttpSetting> CREATOR = new Creator<HttpSetting>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new HttpSetting(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new HttpSetting[i];
            }
        };
        public ArrayList<String> iQR;
        public ArrayList<String> iQS;
        public int iQT;
        public int iQU;
        public int iQV;
        public int iQW;
        public String iQX;
        public int mode;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mode);
            parcel.writeStringList(this.iQR);
            parcel.writeStringList(this.iQS);
            parcel.writeInt(this.iQT);
            parcel.writeInt(this.iQU);
            parcel.writeInt(this.iQV);
            parcel.writeInt(this.iQW);
            parcel.writeString(this.iQX);
        }

        HttpSetting(Parcel parcel) {
            this.mode = parcel.readInt();
            this.iQR = parcel.createStringArrayList();
            this.iQS = parcel.createStringArrayList();
            this.iQT = parcel.readInt();
            this.iQU = parcel.readInt();
            this.iQV = parcel.readInt();
            this.iQW = parcel.readInt();
            this.iQX = parcel.readString();
        }
    }

    public interface a {
        public static final int[] iQP = new int[0];
        public static final String[] iQQ = new String[]{"https://wx.qlogo.cn/"};
    }

    static {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
        iQt = appBrandGlobalSystemConfig;
        appBrandGlobalSystemConfig.iQv = 5;
        iQt.iQw = 300;
        iQt.iQx = 10;
        iQt.iQy = 1048576;
        iQt.iQB = a.iQP;
        iQt.iQC = 10;
        iQt.iQD = 11;
        iQt.iQE = 1800;
        iQt.iQF = 307200;
        iQt.iQG = 25;
        iQt.iQH = 10485760;
        iQt.iQI = 314572800;
        iQt.iQJ = 1;
        iQt.iQK = 50;
        iQt.iQL = a.iQQ;
        iQt.iQM = 0.0d;
        iQt.iQN = 60;
        iQt.iQO = new WeAppSyncVersionSetting();
    }

    static synchronized void acf() {
        synchronized (AppBrandGlobalSystemConfig.class) {
            iQs = null;
        }
    }

    static String acg() {
        File file = new File(e.hbw.replace("/data/user/0", "/data/data"), "wxaapp/res/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "AppService.conf").getAbsolutePath();
    }

    private static synchronized AppBrandGlobalSystemConfig ach() {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = null;
        int i = 0;
        synchronized (AppBrandGlobalSystemConfig.class) {
            if (iQs == null) {
                String bT;
                try {
                    bT = com.tencent.mm.a.e.bT(acg());
                } catch (FileNotFoundException e) {
                    b bZZ = c.vnr;
                    c.vnr;
                    q SB = a.voG.SB(i.eB(38, 1));
                    if (SB != null) {
                        i = bi.getInt(SB.field_fileVersion, 0);
                    }
                    bZZ.e(38, 1, i, false);
                    bT = null;
                } catch (IOException e2) {
                    x.e("MicroMsg.AppBrandGlobalSystemConfig", "read config file, exp = %s", e2);
                    bT = null;
                }
                if (!bi.oN(bT)) {
                    iQs = qY(bT);
                }
            }
            appBrandGlobalSystemConfig = iQs;
        }
        return appBrandGlobalSystemConfig;
    }

    public static AppBrandGlobalSystemConfig aci() {
        AppBrandGlobalSystemConfig ach = ach();
        return ach == null ? iQt : ach;
    }

    private static AppBrandGlobalSystemConfig qY(String str) {
        x.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", str);
        try {
            int i;
            JSONObject jSONObject = new JSONObject(str);
            AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
            JSONObject optJSONObject = jSONObject.optJSONObject("HTTPSetting");
            if (optJSONObject != null) {
                appBrandGlobalSystemConfig.iQA = new HttpSetting();
                String optString = optJSONObject.optString("HTTPHeaderMode", "");
                if (optString.equals("BlackList")) {
                    appBrandGlobalSystemConfig.iQA.mode = 1;
                } else if (optString.equals("WhiteList")) {
                    appBrandGlobalSystemConfig.iQA.mode = 2;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("HeaderBlackList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.iQA.iQR = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.iQA.iQR.add(optJSONArray.getString(i));
                    }
                }
                optJSONArray = optJSONObject.optJSONArray("HeaderWhiteList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.iQA.iQS = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.iQA.iQS.add(optJSONArray.getString(i));
                    }
                }
                appBrandGlobalSystemConfig.iQA.iQT = optJSONObject.optInt("WebsocketMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iQA.iQU = optJSONObject.optInt("UploadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iQA.iQV = optJSONObject.optInt("DownloadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iQA.iQW = optJSONObject.optInt("RequestMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iQA.iQX = optJSONObject.optString("HTTPHeaderReferer");
            }
            appBrandGlobalSystemConfig.iQO = new WeAppSyncVersionSetting();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("SyncVersionSetting");
            if (optJSONObject2 != null) {
                appBrandGlobalSystemConfig.iQO.iQY = optJSONObject2.optLong("PullVersionInterval", appBrandGlobalSystemConfig.iQO.iQY);
                appBrandGlobalSystemConfig.iQO.iQZ = optJSONObject2.optLong("PullVersionWxaUsageLastInterval", appBrandGlobalSystemConfig.iQO.iQZ);
                appBrandGlobalSystemConfig.iQO.iRa = optJSONObject2.optInt("PullVersionMaxCount", appBrandGlobalSystemConfig.iQO.iRa);
                appBrandGlobalSystemConfig.iQO.iRb = optJSONObject2.optInt("PullVersionMaxCountPerRequest", appBrandGlobalSystemConfig.iQO.iRb);
            }
            appBrandGlobalSystemConfig.iQz = jSONObject.optString("CDNBaseURL");
            appBrandGlobalSystemConfig.iQv = jSONObject.optInt("AppMaxRunningCount", 5);
            appBrandGlobalSystemConfig.iQw = jSONObject.optInt("TempFileSizeLimitTotal", 300);
            appBrandGlobalSystemConfig.iQx = jSONObject.optInt("DownloadFileSizeLimit", 10);
            appBrandGlobalSystemConfig.iQy = jSONObject.optInt("MaxLocalStorageItemSize", 1048576);
            appBrandGlobalSystemConfig.iQH = jSONObject.optInt("NativeBufferSizeLimitByte", 10485760);
            appBrandGlobalSystemConfig.iQI = jSONObject.optInt("NativeBufferQueueLimitByte", 314572800);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("SyncLaunchSceneList");
            if (optJSONArray2 != null) {
                appBrandGlobalSystemConfig.iQB = new int[optJSONArray2.length()];
                for (i = 0; i < optJSONArray2.length(); i++) {
                    appBrandGlobalSystemConfig.iQB[i] = optJSONArray2.optInt(i, 0);
                }
            }
            if (appBrandGlobalSystemConfig.iQB == null) {
                appBrandGlobalSystemConfig.iQB = a.iQP;
            }
            appBrandGlobalSystemConfig.iQC = jSONObject.optInt("StarNumberLimitation", 10);
            appBrandGlobalSystemConfig.iQD = jSONObject.optInt("TaskBarItemCountLimitation", 11);
            appBrandGlobalSystemConfig.iQE = jSONObject.optInt("WidgetImageFlowLimitDuration", 1800);
            appBrandGlobalSystemConfig.iQF = jSONObject.optInt("WidgetImageFlowLimitMaxSize", 307200);
            appBrandGlobalSystemConfig.iQG = jSONObject.optInt("WidgetDrawMinInterval", 25);
            appBrandGlobalSystemConfig.iQJ = jSONObject.optInt("GameMaxRunningCount", 1);
            appBrandGlobalSystemConfig.iQK = jSONObject.optInt("GameDownloadFileSizeLimit", 50);
            optJSONArray2 = jSONObject.optJSONArray("SubContextImgDomain");
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                appBrandGlobalSystemConfig.iQL = a.iQQ;
            } else {
                appBrandGlobalSystemConfig.iQL = new String[optJSONArray2.length()];
                for (i = 0; i < optJSONArray2.length(); i++) {
                    appBrandGlobalSystemConfig.iQL[i] = optJSONArray2.optString(i, null);
                }
            }
            appBrandGlobalSystemConfig.iQM = jSONObject.optDouble("GamePerfCollectSamplePercentage", 0.0d);
            appBrandGlobalSystemConfig.iQN = jSONObject.optInt("GamePerfCollectInterval", 60);
            return appBrandGlobalSystemConfig;
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", bi.i(e));
            return null;
        }
    }

    private AppBrandGlobalSystemConfig() {
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.iQu);
        parcel.writeInt(this.iQv);
        parcel.writeInt(this.iQw);
        parcel.writeInt(this.iQx);
        parcel.writeInt(this.iQy);
        parcel.writeString(this.iQz);
        parcel.writeParcelable(this.iQA, i);
        parcel.writeIntArray(this.iQB);
        parcel.writeInt(this.iQC);
        parcel.writeInt(this.iQD);
        parcel.writeInt(this.iQE);
        parcel.writeInt(this.iQF);
        parcel.writeInt(this.iQG);
        parcel.writeInt(this.iQH);
        parcel.writeInt(this.iQI);
        parcel.writeInt(this.iQJ);
        parcel.writeInt(this.iQK);
        parcel.writeStringArray(this.iQL);
        parcel.writeDouble(this.iQM);
        parcel.writeInt(this.iQN);
        parcel.writeParcelable(this.iQO, i);
    }

    protected AppBrandGlobalSystemConfig(Parcel parcel) {
        this.iQu = parcel.readInt();
        this.iQv = parcel.readInt();
        this.iQw = parcel.readInt();
        this.iQx = parcel.readInt();
        this.iQy = parcel.readInt();
        this.iQz = parcel.readString();
        this.iQA = (HttpSetting) parcel.readParcelable(HttpSetting.class.getClassLoader());
        this.iQB = parcel.createIntArray();
        this.iQC = parcel.readInt();
        this.iQD = parcel.readInt();
        this.iQE = parcel.readInt();
        this.iQF = parcel.readInt();
        this.iQG = parcel.readInt();
        this.iQH = parcel.readInt();
        this.iQI = parcel.readInt();
        this.iQJ = parcel.readInt();
        this.iQK = parcel.readInt();
        this.iQL = parcel.createStringArray();
        this.iQM = parcel.readDouble();
        this.iQN = parcel.readInt();
        this.iQO = (WeAppSyncVersionSetting) parcel.readParcelable(WeAppSyncVersionSetting.class.getClassLoader());
    }
}
