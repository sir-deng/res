package com.tencent.mm.bb;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class e {
    public static String hMt = "";

    public static void n(int i, long j) {
        x.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", Integer.valueOf(i), Long.valueOf(j));
        switch (i) {
            case 0:
            case 3:
            case 6:
            case 9:
            case 12:
                IDKey iDKey = new IDKey();
                iDKey.SetID(79);
                iDKey.SetKey(i + 1);
                iDKey.SetValue((long) ((int) j));
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(79);
                iDKey2.SetKey(i + 2);
                iDKey2.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                g.pWK.a(arrayList, false);
                return;
            default:
                return;
        }
    }

    public static void b(String str, boolean z, int i, int i2) {
        a(str, z, i, i2, new f());
    }

    public static void a(String str, boolean z, int i, int i2, f fVar) {
        int i3;
        String format;
        switch (i2) {
            case -15:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                i3 = 2;
                break;
            case 0:
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (z) {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{str, Integer.valueOf(3), Integer.valueOf(i3), Integer.valueOf(fVar.hMu), Integer.valueOf(fVar.hMx), Integer.valueOf(fVar.hME), Integer.valueOf(fVar.hMB), Integer.valueOf(fVar.hMC)});
        } else if (i > 0) {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{str, Integer.valueOf(2), Integer.valueOf(i3), Integer.valueOf(fVar.hMu), Integer.valueOf(fVar.hMx), Integer.valueOf(fVar.hME), Integer.valueOf(fVar.hMB), Integer.valueOf(fVar.hMC)});
        } else {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{str, Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(fVar.hMu), Integer.valueOf(fVar.hMx), Integer.valueOf(fVar.hME), Integer.valueOf(fVar.hMB), Integer.valueOf(fVar.hMC)});
        }
        x.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", Integer.valueOf(11062), format);
        g.pWK.k(11062, format);
    }

    public static void a(b bVar, f fVar) {
        int i;
        int i2;
        String str;
        int i3 = bVar.mVk;
        int i4 = bVar.mVl;
        String str2 = bVar.mVm;
        long j = bVar.mVn;
        int e = e(bVar.mVp, bVar.mVq, bVar.aOg());
        if (bVar.mVj == -8) {
            i = 2;
            i2 = 1;
        } else {
            switch (bVar.kZv) {
                case 1:
                    i = 3;
                    i2 = 1;
                    break;
                case 2:
                    i = 4;
                    i2 = 1;
                    break;
                case 3:
                    i = 10;
                    i2 = 1;
                    break;
                case 4:
                    i = 5;
                    i2 = 1;
                    break;
                case 5:
                    i = 16;
                    i2 = 1;
                    break;
                case 6:
                    i = 11;
                    i2 = 1;
                    break;
                case 7:
                    i = 12;
                    i2 = 1;
                    break;
                case 8:
                    i = 13;
                    i2 = 1;
                    break;
                case 9:
                    i = 14;
                    i2 = 1;
                    break;
                case 10:
                    if (!bVar.mVo) {
                        i = 9;
                        i2 = 1;
                        break;
                    }
                    i = 8;
                    i2 = 1;
                    break;
                case 12:
                    i2 = 2;
                    if (bVar.mVj == -5) {
                        i = 16;
                        break;
                    } else if (bVar.mVj == -3) {
                        i = 4;
                        break;
                    } else if (bVar.mVj == -4) {
                        i = 3;
                        break;
                    } else if (bVar.mVj == -1) {
                        i = 12;
                        break;
                    } else if (bVar.mVj == -2) {
                        i = 11;
                        break;
                    } else {
                        return;
                    }
                case 13:
                    i = 17;
                    i2 = 1;
                    break;
                case 14:
                    i = 15;
                    i2 = 1;
                    break;
                case 16:
                    d dVar = new d();
                    str = bVar.mRM.mRl;
                    if (str != null) {
                        str = str.replaceAll(",", " ");
                    }
                    dVar.q("20KeyWordId", str + ",");
                    dVar.q("21ViewType", "1,");
                    dVar.q("22OpType", "2,");
                    dVar.q("23ResultCount", ",");
                    dVar.q("24ClickPos", bVar.mVl + ",");
                    dVar.q("25ClickAppUserName", bVar.info + ",");
                    x.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", dVar.SG());
                    g.pWK.h(13963, dVar);
                    i2 = 1;
                    i = 19;
                    break;
                case 17:
                    i = 20;
                    i2 = 1;
                    break;
                case 20:
                    i = 21;
                    i2 = 1;
                    break;
                default:
                    return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis() - fVar.hMn;
        if (currentTimeMillis < 0 || fVar.hMn == 0) {
            currentTimeMillis = 0;
        }
        x.v("MicroMsg.FTS.FTSReportLogic", "report home page click: %d, %s", Integer.valueOf(10991), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(bVar.mUl), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), bi.aD(str2, ""), Long.valueOf(j), Integer.valueOf(e), Integer.valueOf(0), Integer.valueOf(bVar.adJ()), Integer.valueOf(ip(bVar.aOf())), bVar.adI(), Long.valueOf(currentTimeMillis), Integer.valueOf(fVar.hMv), Integer.valueOf(fVar.hMw), Integer.valueOf(fVar.hMx), Integer.valueOf(fVar.hMy), Integer.valueOf(fVar.hMz), Integer.valueOf(fVar.hMA), Integer.valueOf(fVar.hMB), Integer.valueOf(fVar.hMD), Integer.valueOf(fVar.hME), hMt, bVar.mRM.mRl, Integer.valueOf(fVar.hMC)}));
        g.pWK.k(10991, str);
    }

    private static int e(int i, int i2, boolean z) {
        if (z) {
            return 15;
        }
        if (i == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            switch (i2) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 11:
                    return 8;
                case 15:
                    return 16;
                case 16:
                    return 10;
                case 17:
                case 18:
                    return 9;
                default:
                    return 0;
            }
        } else if (i == 131075) {
            switch (i2) {
                case 1:
                case 5:
                    return 12;
                case 2:
                case 6:
                    return 13;
                case 3:
                case 7:
                    return 14;
                case 29:
                case 30:
                case 31:
                case 32:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                    return 11;
                default:
                    return 0;
            }
        } else if (i == 131081) {
            return 19;
        } else {
            if (i == 65536) {
                return 17;
            }
            return 0;
        }
    }

    private static int ip(int i) {
        switch (i) {
            case 29:
                return 1;
            case 30:
                return 2;
            case 31:
                return 3;
            case 32:
                return 4;
            case 34:
                return 5;
            case 35:
            case 36:
                return 6;
            case 37:
                return 16;
            default:
                return 0;
        }
    }

    public static void a(b bVar, a aVar) {
        int i;
        String str;
        int i2 = bVar.mVk;
        String str2 = bVar.mVm;
        long j = bVar.mVn;
        int e = e(bVar.mVp, bVar.mVq, bVar.aOg());
        switch (bVar.kZv) {
            case 1:
                i = 3;
                break;
            case 2:
                i = 4;
                break;
            case 3:
                i = 10;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 16;
                break;
            case 6:
                i = 11;
                break;
            case 7:
                i = 12;
                break;
            case 8:
                i = 13;
                break;
            case 9:
                i = 14;
                break;
            case 13:
                i = 17;
                break;
            case 14:
                i = 15;
                break;
            case 16:
                d dVar = new d();
                str = bVar.mRM.mRl;
                if (str != null) {
                    str = str.replaceAll(",", " ");
                }
                dVar.q("20KeyWordId", str + ",");
                dVar.q("21ViewType", "2,");
                dVar.q("22OpType", "2,");
                dVar.q("23ResultCount", ",");
                dVar.q("24ClickPos", bVar.mVl + ",");
                dVar.q("25ClickAppUserName", bVar.info + ",");
                x.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", dVar.SG());
                g.pWK.h(13963, dVar);
                i = 19;
                break;
            case 17:
                i = 20;
                break;
            case 20:
                i = 21;
                break;
            default:
                return;
        }
        long currentTimeMillis = System.currentTimeMillis() - aVar.hMn;
        if (currentTimeMillis < 0 || aVar.hMn == 0) {
            currentTimeMillis = 0;
        }
        x.d("MicroMsg.FTS.FTSReportLogic", "report detail page click: %s", String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(bVar.mUl), Integer.valueOf(i), Integer.valueOf(i2), bi.aD(str2, ""), Long.valueOf(j), Integer.valueOf(e), Integer.valueOf(bVar.adJ()), Integer.valueOf(ip(bVar.aOf())), bVar.adI(), Long.valueOf(currentTimeMillis), Integer.valueOf(aVar.hMo)}));
        g.pWK.k(11310, str);
    }

    public static final void iq(int i) {
        x.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", Integer.valueOf(10991), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), hMt, ""}));
        g.pWK.k(10991, r0);
    }

    public static final void bT(boolean z) {
        int i;
        int i2 = 1;
        String str = "MicroMsg.FTS.FTSReportLogic";
        String str2 = "reportFTSCreateChatroom: %d %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(13970);
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        x.v(str, str2, objArr);
        g gVar = g.pWK;
        Object[] objArr2 = new Object[1];
        if (!z) {
            i2 = 0;
        }
        objArr2[0] = Integer.valueOf(i2);
        gVar.h(13970, objArr2);
    }

    public static final void a(b bVar, int i, boolean z) {
        if (bVar.mVp == 65536) {
            int i2;
            switch (bVar.pageType) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i2 = bVar.pageType;
                    break;
                case 5:
                    if (i == 1) {
                        i2 = 6;
                        break;
                    } else if (i == 2) {
                        i2 = 5;
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            }
            String str = "%s,%s,%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bVar.aOh());
            objArr[1] = Integer.valueOf(i2);
            if (z) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[2] = Integer.valueOf(i2);
            x.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", Integer.valueOf(14756), String.format(str, objArr));
            g.pWK.k(14756, r0);
        }
    }
}
