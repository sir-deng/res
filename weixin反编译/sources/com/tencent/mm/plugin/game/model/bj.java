package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

public class bj {
    private static bj nkh;
    private static TMQQDownloaderOpenSDK nki;

    private static final class a {
        public String SNGAppId;
        public String actionFlag;
        public String nkj;
        public String taskApkId;
        public String taskAppId;
        public String taskPackageName;
        public int taskVersion;
        public String uin;
        public String uinType;
        public String via;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final TMQQDownloaderOpenSDKParam CG(String str) {
            x.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", str);
            if (bi.oN(str)) {
                x.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.taskApkId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APKID);
                    this.via = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_VIA);
                    this.taskVersion = jSONObject.optInt(OpenSDKTool4Assistant.EXTRA_TASK_VERSION);
                    this.nkj = jSONObject.optString("channelID");
                    this.uin = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UIN);
                    this.SNGAppId = jSONObject.optString("SNGAppId");
                    this.taskAppId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APPID);
                    this.uinType = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UINTYPE);
                    this.taskPackageName = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_PACKAGENAME);
                    this.actionFlag = jSONObject.optString("actionFlag");
                } catch (Exception e) {
                    x.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", e.getMessage());
                }
            }
            return new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.nkj, this.actionFlag);
        }
    }

    private bj() {
    }

    public static bj aRF() {
        if (nkh == null) {
            synchronized (bj.class) {
                if (nkh == null) {
                    nkh = new bj();
                }
            }
        }
        return nkh;
    }

    private static TMQQDownloaderOpenSDK aRG() {
        if (nki == null) {
            TMQQDownloaderOpenSDK instance = TMQQDownloaderOpenSDK.getInstance();
            nki = instance;
            instance.initQQDownloaderOpenSDK(ad.getContext());
        }
        return nki;
    }

    public static void aRH() {
        boolean z = false;
        String str = "MicroMsg.QQDownloaderSDKWrapper";
        String str2 = "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(nki == null);
        if (nkh == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (nki != null) {
            nki.destroyQQDownloaderOpenSDK();
        }
        nki = null;
        nkh = null;
    }

    public static void ab(Context context, String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
        } else if (context == null) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
        } else {
            x.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", str);
            TMQQDownloaderOpenSDKParam CG = new a().CG(str);
            try {
                aRF();
                aRG().startToDownloadTaskList(context, CG, true, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", e, "", new Object[0]);
            }
        }
    }

    public static int CF(String str) {
        if (!bi.oN(str)) {
            return a(new a().CG(str));
        }
        x.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
        return -1;
    }

    private static int a(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        try {
            aRF();
            TMAssistantDownloadTaskInfo downloadTaskState = aRG().getDownloadTaskState(tMQQDownloaderOpenSDKParam);
            if (downloadTaskState != null) {
                return downloadTaskState.mState;
            }
        } catch (Exception e) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", e.getMessage());
        }
        return -1;
    }

    public static int h(Context context, String str, int i) {
        int i2 = -1;
        if (bi.oN(str)) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
        } else {
            try {
                PackageInfo packageInfo = p.getPackageInfo(context, str);
                if (packageInfo == null) {
                    i2 = 1;
                } else {
                    x.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", Integer.valueOf(packageInfo.versionCode));
                    i2 = packageInfo.versionCode >= i ? 0 : 2;
                }
            } catch (Exception e) {
                x.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", e.getMessage());
            }
            x.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", Integer.valueOf(i2));
        }
        return i2;
    }

    public static void startToAuthorized(Context context, String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
            return;
        }
        TMQQDownloaderOpenSDKParam CG = new a().CG(str);
        try {
            aRF();
            aRG().startToAuthorized(context, CG, "1");
        } catch (Exception e) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", e.getMessage());
        }
    }

    public static boolean registerListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        aRF();
        return aRG().registerListener(iTMQQDownloaderOpenSDKListener);
    }

    public static boolean unregisterListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        aRF();
        return aRG().unregisterListener(iTMQQDownloaderOpenSDKListener);
    }
}
