package com.tencent.mm.plugin.voip_cs.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.protocal.c.bvk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static int sBZ = 0;
    public static int sCa = 1;
    public static int sCb = 2;
    public int bjS;
    public int channelStrategy;
    public String deviceModel;
    public long nJf;
    public long nKC;
    public String nKL;
    public String nKM;
    public int networkType;
    public int sCA;
    public long sCB;
    public int sCC;
    public long sCD;
    public long sCE;
    public long sCF;
    public int sCG;
    public int sCH;
    public int sCI;
    public int sCJ;
    public String sCK;
    public String sCL;
    public String sCM;
    public int sCN;
    public int sCO;
    public int sCP;
    public int sCQ;
    public int sCR;
    public int sCS;
    public int sCc;
    public int sCd;
    public int sCe;
    public int sCf;
    public int sCg;
    public int sCh;
    public int sCi;
    public int sCj;
    public int sCk;
    public int sCl;
    public int sCm;
    public int sCn;
    public long sCo;
    public String sCp;
    public int sCq;
    public int sCr;
    public int sCs;
    public int sCt;
    public int sCu;
    public int sCv;
    public int sCw;
    public int sCx;
    public int sCy;
    public int sCz;
    public int sgX;
    public int suA;
    public int suB;
    public int suh;
    public int suu;
    public int suz;
    public int svM;
    public int videoFps;

    public c() {
        this.bjS = 0;
        this.sCc = 0;
        this.sCd = 0;
        this.sCe = 0;
        this.videoFps = 0;
        this.sCf = 0;
        this.sCg = 0;
        this.sCh = 0;
        this.sCi = 0;
        this.sCj = 0;
        this.sCk = 0;
        this.networkType = 0;
        this.sCl = 0;
        this.sCn = 0;
        this.suu = 0;
        this.sCo = 0;
        this.nJf = 0;
        this.sCp = "";
        this.suh = 0;
        this.sCr = 0;
        this.sCs = 0;
        this.sCt = 0;
        this.sCu = 0;
        this.suA = 0;
        this.suz = 0;
        this.sCv = 0;
        this.sCw = 1;
        this.sCx = 0;
        this.sCy = 0;
        this.sCz = 0;
        this.sCA = 0;
        this.sCB = 0;
        this.sCD = 0;
        this.sCE = 0;
        this.sCF = 0;
        this.nKC = 0;
        this.channelStrategy = 1;
        this.svM = 0;
        this.suB = 0;
        this.sCI = -1;
        this.sCJ = 0;
        this.sCK = "";
        this.deviceModel = "";
        this.sCL = "";
        this.sCM = "";
        this.sCN = 0;
        this.sCO = 0;
        this.sCP = 0;
        this.sCQ = 0;
        this.sCR = 0;
        this.sCS = 0;
        this.sgX = m.yw();
        this.nKM = "";
        this.nKL = "";
        this.sCK = Build.MANUFACTURER;
        if (this.sCK.contains(",")) {
            this.sCK = this.sCK.replace(',', ' ');
        }
        this.deviceModel = Build.MODEL;
        if (this.deviceModel.contains(",")) {
            this.deviceModel = this.deviceModel.replace(',', ' ');
        }
        this.sCL = VERSION.SDK;
        if (this.sCL.contains(",")) {
            this.sCL = this.sCL.replace(',', ' ');
        }
        this.sCM = VERSION.RELEASE;
        if (this.sCM.contains(",")) {
            this.sCM = this.sCM.replace(',', ' ');
        }
    }

    public final void zp(int i) {
        this.suz = Math.abs(i);
    }

    public final void bJF() {
        x.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
        if (this.sCR == 0 && this.sCQ != 0) {
            this.sCR = (int) (System.currentTimeMillis() / 1000);
            this.nKC = (long) (this.sCR - this.sCQ);
        }
    }

    public final bvk bJG() {
        bvk bvk = new bvk();
        bvk.kzz = 2;
        bvk.xde = this.nKL;
        x.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", bvk.xde);
        String[] split = this.nKL.split(",");
        if (split != null && split.length > 0) {
            try {
                this.videoFps = bi.getInt(split[8], 0);
                this.sCf = bi.getInt(split[10], 0);
            } catch (Exception e) {
                x.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
            }
        }
        return bvk;
    }

    public static int bJH() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ad.getContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo == null) {
                    return sBZ;
                }
                if (networkInfo.getState() == State.CONNECTED) {
                    return sCa;
                }
                return sCb;
            }
        } catch (Exception e) {
            x.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
        }
        return sBZ;
    }

    public static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() != 0) {
                return 0;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 13) {
                return 4;
            }
            if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                return 2;
            }
            return 3;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoipCSReportHelper", e, "", new Object[0]);
            return 0;
        }
    }
}
