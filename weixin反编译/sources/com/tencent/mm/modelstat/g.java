package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class g {
    private final String fFK;
    private a hTj = null;

    public static class a {
        public String extraInfo = "";
        public int fqh = 0;
        public int hTk = 0;
        boolean hTl = false;
        public String ispName = "";
    }

    public g(String str) {
        this.fFK = str;
    }

    public final a Tc() {
        a aVar = null;
        if (this.hTj != null) {
            return this.hTj;
        }
        a aVar2;
        String str = this.fFK + "mobileinfo.ini";
        File file = new File(str);
        if (file.exists()) {
            com.tencent.mm.sdk.e.a aVar3 = new com.tencent.mm.sdk.e.a(str);
            aVar2 = new a();
            aVar2.hTk = bi.e(aVar3.WH("ispCode"));
            aVar2.ispName = aVar3.getValue("ispName");
            aVar2.fqh = bi.e(aVar3.WH("subType"));
            aVar2.extraInfo = aVar3.getValue("extraInfo");
            long lastModified = file.lastModified();
            if (CdnLogic.kMediaTypeBeatificFile == r.ifN && r.ifO > 0) {
                lastModified = bi.Wy() - ((long) r.ifO);
                x.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", Integer.valueOf(r.ifO), Long.valueOf(lastModified));
                r.ifO = 0;
            }
            if (lastModified > 0 && bi.bA(lastModified) > 259200000) {
                x.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", Long.valueOf(bi.bA(lastModified)), str);
                aVar2.hTl = true;
            }
            x.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", Integer.valueOf(aVar2.fqh), Integer.valueOf(aVar2.hTk), aVar2.ispName, aVar2.extraInfo, Boolean.valueOf(aVar2.hTl));
        } else {
            x.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", str);
            aVar2 = null;
        }
        this.hTj = aVar2;
        if (this.hTj == null || this.hTj.hTl) {
            Context context = ad.getContext();
            if (context == null) {
                x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
                    } else if (activeNetworkInfo.getType() == 1) {
                        x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
                    } else {
                        aVar = new a();
                        aVar.fqh = activeNetworkInfo.getSubtype();
                        aVar.hTk = ao.getISPCode(context);
                        aVar.ispName = ao.getISPName(context);
                        aVar.extraInfo = activeNetworkInfo.getExtraInfo();
                        x.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", Integer.valueOf(aVar.fqh), Integer.valueOf(aVar.hTk), aVar.ispName, aVar.extraInfo);
                    }
                }
            }
            if (aVar == null) {
                x.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
                return this.hTj;
            }
            this.hTj = aVar;
            aVar2 = this.hTj;
            if (aVar2 == null) {
                x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
            } else if (bi.oN(str)) {
                x.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
            } else {
                com.tencent.mm.sdk.e.a aVar4 = new com.tencent.mm.sdk.e.a(str);
                aVar4.da("ispCode", aVar2.hTk);
                aVar4.fB("ispName", aVar2.ispName);
                aVar4.da("subType", aVar2.fqh);
                aVar4.fB("extraInfo", aVar2.extraInfo);
            }
            return this.hTj;
        }
        x.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
        return this.hTj;
    }
}
