package com.tencent.mm.permission;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.a.jm;
import com.tencent.mm.f.a.lq;
import com.tencent.mm.f.a.lr;
import com.tencent.mm.j.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class b {
    static final String ffG;
    static final String ffH;
    static Map<Integer, a> ied;
    c iee = new c<lq>() {
        {
            this.xmG = lq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            lq lqVar = (lq) bVar;
            if (true == lqVar.fDS.fDU) {
                if (!b.iX(lqVar.fDS.type)) {
                    if (com.tencent.mm.compatible.f.a.gIJ == null) {
                        List<b> arrayList = new ArrayList();
                        List<a> arrayList2 = new ArrayList();
                        com.tencent.mm.compatible.f.a.a(e.hbv + "permissioncfg.cfg", arrayList, arrayList2);
                        PInt pInt = new PInt(0);
                        PBool pBool = new PBool();
                        for (b bVar2 : arrayList) {
                            pInt.value = 0;
                            pBool.value = true;
                            if (com.tencent.mm.compatible.f.a.a(Build.MANUFACTURER, bVar2.gIO, pInt, pBool) && com.tencent.mm.compatible.f.a.a(Build.MODEL, bVar2.model, pInt, pBool)) {
                                com.tencent.mm.compatible.f.a.a(VERSION.RELEASE, bVar2.version, pInt, pBool);
                            }
                            if (pBool.value && pInt.value > 0) {
                                com.tencent.mm.compatible.f.a.gIJ = Boolean.valueOf(1 == bVar2.gIM);
                            }
                        }
                        if (com.tencent.mm.compatible.f.a.gIJ == null || true != com.tencent.mm.compatible.f.a.gIJ.booleanValue()) {
                            for (PackageInfo packageInfo : com.tencent.mm.compatible.f.a.bj(false)) {
                                for (a aVar : arrayList2) {
                                    pInt.value = 0;
                                    pBool.value = true;
                                    if (com.tencent.mm.compatible.f.a.a(packageInfo.packageName, aVar.ffM, pInt, pBool)) {
                                        if (aVar.gIK == 0 && aVar.gIL == 0) {
                                            pBool.value = true;
                                        } else if (aVar.gIK > packageInfo.versionCode || aVar.gIL < packageInfo.versionCode) {
                                            pBool.value = false;
                                        } else {
                                            pInt.value++;
                                            pBool.value = true;
                                        }
                                    }
                                    if (pBool.value && pInt.value > 0) {
                                        com.tencent.mm.compatible.f.a.gIJ = Boolean.valueOf(1 == aVar.gIM);
                                    }
                                }
                                if (com.tencent.mm.compatible.f.a.gIJ != null && true == com.tencent.mm.compatible.f.a.gIJ.booleanValue()) {
                                    break;
                                }
                            }
                            if (com.tencent.mm.compatible.f.a.gIJ == null) {
                                com.tencent.mm.compatible.f.a.gIJ = Boolean.valueOf(false);
                            }
                        }
                    }
                    if (com.tencent.mm.compatible.f.a.gIJ.booleanValue()) {
                        lqVar.fDT.fDW = b.t(lqVar.fDS.type, true);
                        b.b(lqVar.fDS.type, false, true);
                    }
                }
                lqVar.fDT.fDW = false;
                b.b(lqVar.fDS.type, true, false);
            } else {
                lqVar.fDT.fDW = false;
                b.b(lqVar.fDS.type, false, lqVar.fDS.fDV);
            }
            return false;
        }
    };
    private c ief = new c<lr>() {
        {
            this.xmG = lr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            lr lrVar = (lr) bVar;
            lrVar.fDY.fDW = b.t(lrVar.fDX.type, false);
            return false;
        }
    };
    private c ieg = new c<jm>() {
        {
            this.xmG = jm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.PermissionMgr", "show mute dlg");
            PermissionWarningDialog.bD(ad.getContext());
            return false;
        }
    };

    private static class a {
        public int iei;
        public int iej;
        public int iek;
        public int iel;
        public int iem;

        public a(int i, int i2, int i3, int i4, int i5) {
            this.iei = i;
            this.iej = i2;
            this.iek = i3;
            this.iel = i4;
            this.iem = i5;
        }
    }

    static /* synthetic */ void b(int i, boolean z, boolean z2) {
        x.i("MicroMsg.PermissionMgr", "makeMark, setOrClear: " + z);
        as.Hk().setInt(((a) ied.get(Integer.valueOf(i))).iei, z ? 1 : 0);
        if (true == z) {
            a.Wi().Wj();
        }
        if (!z && true == z2) {
            long j = as.Hk().getLong(((a) ied.get(Integer.valueOf(i))).iej, 0);
            if (0 != j && System.currentTimeMillis() - j >= 86400000) {
                ab("LastTick: " + j + ", CurrentTtick: " + System.currentTimeMillis() + "\n", as.Hk().DE(((a) ied.get(Integer.valueOf(i))).iek) == 1 ? 6 : 5);
                as.Hk().setLong(((a) ied.get(Integer.valueOf(i))).iej, 0);
            }
        }
    }

    static /* synthetic */ boolean iX(int i) {
        int DE = as.Hk().DE(((a) ied.get(Integer.valueOf(i))).iei);
        x.i("MicroMsg.PermissionMgr", "current mark status: " + DE);
        return DE == 0;
    }

    static /* synthetic */ boolean t(int i, boolean z) {
        int oC;
        int oC2;
        int oC3;
        boolean z2;
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        if (as.Hp()) {
            oC = oC("ShowPermissionDialog");
            oC2 = oC("OnlyScanRunningService");
            oC3 = oC("Interval4ShowPmsDialog");
        } else {
            oC = 1;
            oC2 = 1;
            oC3 = 3600000;
        }
        x.i("MicroMsg.PermissionMgr", "showDlg: %d, filter: %d, interval: %d", Integer.valueOf(oC), Integer.valueOf(oC2), Integer.valueOf(oC3));
        long j = 0;
        for (a aVar2 : ied.values()) {
            long j2 = as.Hk().getLong(aVar2.iej, 0);
            if (j < j2) {
                j = j2;
            }
        }
        boolean z3 = 1 == oC && System.currentTimeMillis() - j >= ((long) oC3);
        if (z3) {
            String str;
            z2 = 1 == oC2;
            List arrayList = new ArrayList();
            List<b> arrayList2 = new ArrayList();
            List<a> arrayList3 = new ArrayList();
            com.tencent.mm.compatible.f.a.a(e.hbv + "permissioncfg.cfg", arrayList2, arrayList3);
            String str2 = null;
            PInt pInt = new PInt(0);
            PBool pBool = new PBool();
            for (b bVar : arrayList2) {
                pInt.value = 0;
                pBool.value = true;
                if (com.tencent.mm.compatible.f.a.a(Build.MANUFACTURER, bVar.gIO, pInt, pBool) && com.tencent.mm.compatible.f.a.a(Build.MODEL, bVar.model, pInt, pBool)) {
                    com.tencent.mm.compatible.f.a.a(VERSION.RELEASE, bVar.version, pInt, pBool);
                }
                str = (!pBool.value || pInt.value <= 0) ? str2 : (String) bVar.gIN.get(i);
                str2 = str;
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            List<PackageInfo> bj = com.tencent.mm.compatible.f.a.bj(z2);
            if (bj != null) {
                for (PackageInfo packageInfo : bj) {
                    str2 = null;
                    for (a aVar3 : arrayList3) {
                        pInt.value = 0;
                        pBool.value = true;
                        if (com.tencent.mm.compatible.f.a.a(packageInfo.packageName, aVar3.ffM, pInt, pBool)) {
                            if (aVar3.gIK == 0 && aVar3.gIL == 0) {
                                pBool.value = true;
                            } else if (aVar3.gIK > packageInfo.versionCode || aVar3.gIL < packageInfo.versionCode) {
                                pBool.value = false;
                            } else {
                                pInt.value++;
                                pBool.value = true;
                            }
                        }
                        str = (!pBool.value || pInt.value <= 0) ? str2 : (String) aVar3.gIN.get(i);
                        str2 = str;
                    }
                    if (str2 != null) {
                        arrayList.add(str2);
                    }
                }
            }
            x.i("MicroMsg.PermissionMgr", "len of tips list: " + Integer.valueOf(arrayList.size()));
            if (arrayList.size() != 0) {
                a(i, arrayList, z);
                c(arrayList, z);
                z2 = true;
            } else {
                if (System.currentTimeMillis() - as.Hk().getLong(42, 0) < 2592000000L) {
                    ci(z);
                } else if (1 == i) {
                    as.Hk().setLong(42, System.currentTimeMillis());
                    PermissionWarningDialog.a(ad.getContext(), 1 == oC2, z);
                }
                z2 = false;
            }
            as.Hk().setLong(((a) ied.get(Integer.valueOf(i))).iej, System.currentTimeMillis());
        } else {
            z2 = false;
        }
        x.i("MicroMsg.PermissionMgr", "showPermissionDialog cost: " + aVar.zp() + ", needShowDlg: " + z3);
        return z2;
    }

    static {
        String yM = q.yM();
        ffG = yM;
        ffH = o.getString(yM.hashCode());
        Map hashMap = new HashMap();
        ied = hashMap;
        hashMap.put(Integer.valueOf(1), new a(38, 40, 41, R.l.dGr, R.l.dGj));
        ied.put(Integer.valueOf(2), new a(43, 44, 45, R.l.dGq, R.l.dGk));
    }

    public b() {
        com.tencent.mm.sdk.b.a.xmy.b(this.iee);
        com.tencent.mm.sdk.b.a.xmy.b(this.ief);
        com.tencent.mm.sdk.b.a.xmy.b(this.ieg);
    }

    private static int oC(String str) {
        int i = 0;
        try {
            return bi.getInt(g.Af().getValue(str), 0);
        } catch (Exception e) {
            x.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: " + str);
            return i;
        }
    }

    public static void ci(boolean z) {
        ab("App_List:\n", z ? 4 : 3);
    }

    public static void j(boolean z, boolean z2) {
        StringBuilder stringBuilder = new StringBuilder();
        PackageManager packageManager = ad.getContext().getPackageManager();
        List<PackageInfo> bj = com.tencent.mm.compatible.f.a.bj(z);
        if (bj != null) {
            stringBuilder.append("App_List:\n");
            for (PackageInfo packageInfo : bj) {
                if (packageInfo != null) {
                    String str = "";
                    if (!(packageInfo.applicationInfo == null || packageManager == null)) {
                        str = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                    }
                    stringBuilder.append(str + ":" + packageInfo.packageName + ":" + packageInfo.versionCode + "\n");
                }
            }
        }
        ab(stringBuilder.toString(), z2 ? 4 : 3);
    }

    private static void c(List<String> list, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Match_Tips:\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            stringBuilder.append((String) list.get(i2));
            stringBuilder.append("\n");
            i = i2 + 1;
        }
        ab(stringBuilder.toString(), z ? 2 : 1);
    }

    private static void a(int i, List<String> list, boolean z) {
        int i2;
        int i3;
        int size = list.size() > 5 ? 5 : list.size();
        int[] iArr = new int[]{R.l.dGn, R.l.dGs, R.l.dGp, R.l.dGm, R.l.dGl};
        Context context = ad.getContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getString(((a) ied.get(Integer.valueOf(i))).iem));
        for (i2 = 0; i2 < size; i2++) {
            stringBuilder.append(context.getString(iArr[i2]));
            stringBuilder.append((String) list.get(i2));
            stringBuilder.append(10);
        }
        s Hk = as.Hk();
        i2 = ((a) ied.get(Integer.valueOf(i))).iek;
        if (z) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        Hk.setInt(i2, i3);
        PermissionWarningDialog.i(context, context.getString(((a) ied.get(Integer.valueOf(i))).iel), stringBuilder.toString());
    }

    private static void ab(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n#client.version=").append(d.vHl).append("\n");
        stringBuilder.append("#accinfo.revision=").append(com.tencent.mm.sdk.platformtools.e.REV).append("\n");
        stringBuilder.append("#accinfo.uin=").append(ar.hhz.H("last_login_uin", ffH)).append("\n");
        stringBuilder.append("#accinfo.dev=").append(ffG).append("\n");
        stringBuilder.append("#accinfo.build=").append(com.tencent.mm.sdk.platformtools.e.TIME).append(":").append(com.tencent.mm.sdk.platformtools.e.HOSTNAME).append(":").append(f.fei).append("\n");
        Date date = new Date();
        stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append("\n");
        stringBuilder.append("#permission.type=").append(String.valueOf(i)).append(10);
        stringBuilder.append("#permission.content:\n");
        Intent intent = new Intent();
        intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionWriteSdcard", false);
        intent.putExtra("exceptionPid", Process.myPid());
        String str2 = "userName";
        String H = ar.hhz.H("login_weixin_username", "");
        if (bi.oN(H)) {
            H = ar.hhz.H("login_user_name", "never_login_crash");
        }
        intent.putExtra(str2, H);
        intent.putExtra("tag", "permission");
        x.d("MicroMsg.PermissionMgr", "report type: %d, len: %d", Integer.valueOf(i), Integer.valueOf((stringBuilder.toString() + str).length()));
        intent.putExtra("exceptionMsg", Base64.encodeToString(H.getBytes(), 2));
        ad.getContext().startService(intent);
    }
}
