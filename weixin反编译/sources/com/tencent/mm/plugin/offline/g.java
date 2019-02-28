package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.HashSet;
import java.util.Map;

public final class g {
    public static String TAG = "MicroMsg.OfflineGetMsgLogic";
    public static int paS = 5000;
    private static int paT;
    private static int paU = 5000;
    public static int paV = 0;
    public static int paW = 24;
    public static int paX = 4;
    public static int paY = 8;
    public static int paZ = 23;
    public static int pba = 6;
    public static int pbb = 5;
    public static int pbc = 20;
    public static int pbd = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;
    public static int pbe = CdnLogic.kMediaTypeBackupFile;
    public static int pbf = 10001;
    public static int pbg;
    public e pbh = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            if ((kVar instanceof d) && i == 0 && i2 == 0) {
                d dVar = (d) kVar;
                g.pbg = dVar.pbR;
                if (g.pbg == 0) {
                    g.pbg = g.paU;
                }
                x.i(g.TAG, "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", dVar.pbS, dVar.pbQ);
                if (bi.oN(dVar.pbQ) || bi.oN(dVar.pbS)) {
                    x.i(g.TAG, "OfflineGetMsgLogic msg is null");
                } else if (g.dM(dVar.pbS, dVar.pbQ)) {
                    x.i(g.TAG, "from cgi");
                    if (bj.y(dVar.pbQ, "sysmsg") != null) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(135, 71, 1, true);
                        k.bhD();
                        s bhE = k.bhE();
                        String str2 = dVar.pbQ;
                        if (!TextUtils.isEmpty(str2)) {
                            String str3 = null;
                            int i3 = -1;
                            Map y = bj.y(str2, "sysmsg");
                            if (y != null) {
                                String str4 = (String) y.get(".sysmsg.paymsg.ack_key");
                                str3 = str4;
                                i3 = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                            }
                            if (!a.biP()) {
                                g.dM(str3, str2);
                                bhE.Hu(str2);
                                bhE.Hv(str2);
                            } else if (!(i3 == 7 || i3 == 10 || !g.dM(str3, str2))) {
                                com.tencent.mm.plugin.report.service.g.pWK.a(135, 70, 1, true);
                                bhE.Hu(str2);
                                bhE.Hv(str2);
                            }
                        }
                    } else {
                        return;
                    }
                }
                x.i(g.TAG, "mIntercal=" + g.pbg);
                long bm = (long) g.pbg;
                g.this.pbj.K(bm, bm);
            }
        }
    };
    public boolean pbi = true;
    public al pbj = new al(new al.a() {
        public final boolean uG() {
            if (g.this.pbj != null) {
                if (!com.tencent.mm.kernel.g.Do().CF()) {
                    long aqk = (long) g.paS;
                    g.this.pbj.K(aqk, aqk);
                } else if (a.biP() && a.bin()) {
                    g.bhA();
                }
            }
            return false;
        }
    }, false);
    public int status = 0;

    static /* synthetic */ void bhA() {
        x.i(TAG, "doGetOfflineMsg doScene:NetSceneOfflineGetMsg");
        k dVar = new d();
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(dVar, 0);
    }

    static {
        int intValue;
        paT = 30000;
        pbg = paU;
        com.tencent.mm.kernel.g.Dr();
        Object obj = com.tencent.mm.kernel.g.Dq().Db().get(w.a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, null);
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
            pbg = intValue;
            if (intValue == 0) {
                pbg = paU;
            }
        }
        com.tencent.mm.kernel.g.Dr();
        obj = com.tencent.mm.kernel.g.Dq().Db().get(w.a.BUSINESS_OFFLINE_GETMSG_MAX_POS_TIME_INT, Integer.valueOf(0));
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
            if (intValue != 0) {
                paT = intValue;
            }
        }
    }

    public static int bhy() {
        return paT;
    }

    public g() {
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(385, this.pbh);
    }

    private static boolean a(r rVar) {
        boolean z = false;
        if (rVar != null) {
            x.i(TAG, "isOrderClosed lastest status req_key=" + rVar.field_reqkey);
        }
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(pbd));
        hashSet.add(Integer.valueOf(pba));
        hashSet.add(Integer.valueOf(pbb));
        hashSet.add(Integer.valueOf(paX));
        hashSet.add(Integer.valueOf(-1));
        if (rVar == null || hashSet.contains(Integer.valueOf(rVar.field_status))) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("isOrderClosed true;status==null?");
            if (rVar == null) {
                z = true;
            }
            x.i(str, stringBuilder.append(z).toString());
            if (rVar != null) {
                x.i(TAG, "isOrderClosed status.field_status=" + rVar.field_status);
            }
            return true;
        }
        x.i(TAG, "isOrderClosed false");
        if (rVar != null) {
            x.i(TAG, "status=" + rVar.field_status + ";req_key=" + rVar.field_reqkey);
            return false;
        }
        x.i(TAG, "isOrderClosed status=null");
        return false;
    }

    public static boolean dM(String str, String str2) {
        Object obj;
        Map y;
        String str3;
        int i;
        if (bi.oN(str2)) {
            x.i(TAG, "shouldDeal appmsg is null");
            obj = null;
        } else {
            String str4;
            String str5;
            Object[] objArr;
            Object[] objArr2;
            int i2;
            boolean z;
            y = bj.y(str2, "sysmsg");
            str3 = (String) y.get(".sysmsg.paymsg.req_key");
            i = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
            k.bhD();
            r Hw = k.bhH().Hw(str3);
            k.bhD();
            r bhL = k.bhH().bhL();
            boolean a = a(bhL);
            if (Hw != null) {
                com.tencent.mm.plugin.report.service.g.pWK.a(135, 63, 1, true);
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.a(135, 64, 1, true);
            }
            String str6;
            if (bhL != null) {
                str6 = TAG;
                Object[] objArr3 = new Object[3];
                objArr3[0] = bhL.field_reqkey;
                objArr3[1] = Integer.valueOf(bhL.field_status);
                str4 = "latestStatus: reqKey: %s, status:%d, isLatestClose: %b";
                str5 = str6;
                objArr = objArr3;
                objArr2 = objArr3;
                i2 = 2;
                z = a;
            } else {
                str4 = TAG;
                str6 = "latestStatus is null. isLatestClose: %b, localStatus is null ?: %b";
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(a);
                i2 = 1;
                if (Hw == null) {
                    z = true;
                    str5 = str4;
                    str4 = str6;
                    objArr2 = objArr;
                } else {
                    z = false;
                    str5 = str4;
                    str4 = str6;
                    objArr2 = objArr;
                }
            }
            objArr[i2] = Boolean.valueOf(z);
            x.i(str5, str4, objArr2);
            if (Hw == null) {
                if (bhL == null) {
                    x.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", str3, Integer.valueOf(i));
                    obj = 1;
                } else if (a) {
                    x.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", str3, Integer.valueOf(i), bhL.field_reqkey, Integer.valueOf(bhL.field_status));
                    obj = 1;
                } else {
                    x.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", str3, Integer.valueOf(i), bhL.field_reqkey, Integer.valueOf(bhL.field_status));
                    obj = null;
                }
            } else if (a(Hw)) {
                x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", Hw.field_reqkey, Integer.valueOf(i), Integer.valueOf(Hw.field_status));
                obj = null;
            } else if (bhL == null) {
                x.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", str3, Integer.valueOf(i), Integer.valueOf(Hw.field_status));
                k.bhD();
                k.bhH().Hx(str3);
                obj = null;
            } else {
                x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", str3, Integer.valueOf(i), Integer.valueOf(Hw.field_status), bhL.field_reqkey, Integer.valueOf(bhL.field_status));
                if (Hw.field_reqkey.equals(bhL.field_reqkey)) {
                    if (df(bhL.field_status, i)) {
                        x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", str3, Integer.valueOf(i), Integer.valueOf(Hw.field_status), bhL.field_reqkey, Integer.valueOf(bhL.field_status));
                        obj = 1;
                    } else {
                        x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", str3, Integer.valueOf(i), Integer.valueOf(Hw.field_status), bhL.field_reqkey, Integer.valueOf(bhL.field_status));
                        if (bhL.field_status != i) {
                            x.i(TAG, "mark reqKey: %s as give up", str3);
                            k.bhD();
                            k.bhH().Hx(str3);
                        }
                        obj = null;
                    }
                } else if (a) {
                    x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", str3, Integer.valueOf(i), Integer.valueOf(Hw.field_status), bhL.field_reqkey, Integer.valueOf(bhL.field_status));
                    obj = 1;
                } else {
                    x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", str3, Integer.valueOf(i), Integer.valueOf(Hw.field_status), bhL.field_reqkey, Integer.valueOf(bhL.field_status));
                    k.bhD();
                    k.bhH().Hx(str3);
                    obj = null;
                }
            }
        }
        if (obj != null) {
            k.bhD();
            r bhL2 = k.bhH().bhL();
            y = bj.y(str2, "sysmsg");
            i = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
            str3 = (String) y.get(".sysmsg.paymsg.req_key");
            if (i == 24) {
                com.tencent.mm.plugin.report.service.g.pWK.a(135, 58, 1, true);
            } else if (i == 6) {
                com.tencent.mm.plugin.report.service.g.pWK.a(135, 59, 1, true);
            } else if (i == 4 || i == 5 || i == 20) {
                com.tencent.mm.plugin.report.service.g.pWK.a(135, 60, 1, true);
            } else if (i == 23) {
                com.tencent.mm.plugin.report.service.g.pWK.a(135, 66, 1, true);
            }
            if (bhL2 == null || bhL2.field_reqkey == null || !bhL2.field_reqkey.equals(str3)) {
                r rVar = new r();
                rVar.field_reqkey = str3;
                if (!bi.oN(str)) {
                    rVar.field_ack_key = str;
                }
                rVar.field_status = paV;
                a(rVar, i);
            } else {
                a(bhL2, i);
            }
            x.i(TAG, "dealMsg true");
            return true;
        }
        x.i(TAG, "dealMsg false");
        return false;
    }

    private static boolean df(int i, int i2) {
        x.i(TAG, "checkStatus from=" + i + ";to=" + i2);
        if (i == i2) {
            return false;
        }
        if (i == paV) {
            return true;
        }
        if (i == paW) {
            if (i2 != paW) {
                return true;
            }
            return false;
        } else if (i == pba) {
            if (i2 == pbd) {
                return true;
            }
            return false;
        } else if (i == pbb) {
            if (i2 == pbd) {
                return true;
            }
            return false;
        } else if (i == paX) {
            if (i2 == pbd) {
                return true;
            }
            return false;
        } else if (i == pbc) {
            if (i2 == pbd) {
                return true;
            }
            return false;
        } else if (i == paY || i == paZ) {
            if (i2 == pba || i2 == pbd) {
                return true;
            }
            return false;
        } else if (i != pbf) {
            return false;
        } else {
            if (i2 == pba || i2 == pbd) {
                return true;
            }
            return false;
        }
    }

    private static boolean a(r rVar, int i) {
        if (i == paX) {
            i = pbd;
        }
        boolean df = df(rVar.field_status, i);
        x.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", Boolean.valueOf(df), Integer.valueOf(rVar.field_status), Integer.valueOf(i));
        if (df) {
            rVar.field_status = i;
            k.bhD();
            k.bhH().b(rVar);
        }
        return df;
    }

    public static void bT(String str, int i) {
        if (!bi.oN(str)) {
            k.bhD();
            r Hw = k.bhH().Hw(str);
            if (Hw != null) {
                a(Hw, i);
                return;
            }
            Hw = new r();
            Hw.field_reqkey = str;
            Hw.field_status = i;
            k.bhD();
            k.bhH().b(Hw);
        }
    }

    public static void bhz() {
        long j;
        x.i(TAG, "endAllOldOrder");
        k.bhD();
        com.tencent.mm.plugin.offline.b.a bhH = k.bhH();
        x.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", Integer.valueOf(bhH.bhN()), bhH.bhM());
        Cursor a = bhH.gLA.a(String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", new Object[]{"rowid", "OfflineOrderStatus", "rowid"}), null, 2);
        if (a == null) {
            x.e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
            j = 0;
        } else {
            a.moveToFirst();
            j = (a.isAfterLast() || a.getColumnCount() <= 0) ? 0 : a.getLong(0);
            a.close();
        }
        if (j - 10 > 0) {
            x.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", Long.valueOf(j), String.format("DELETE FROM %s WHERE %s < %d;", new Object[]{"OfflineOrderStatus", "rowid", Long.valueOf(j - 10)}));
            bhH.gLA.fD("OfflineOrderStatus", r2);
        } else {
            x.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", Long.valueOf(j));
        }
        bhH.gLA.fD("OfflineOrderStatus", "UPDATE OfflineOrderStatus SET status=" + pbd + " where status!=" + pbd);
    }

    public final void stop() {
        if (a.biP()) {
            x.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.pbj.cgx());
            if (!this.pbj.cgx()) {
                com.tencent.mm.plugin.report.service.g.pWK.a(135, 62, 1, true);
                this.pbj.TN();
            }
        }
    }
}
