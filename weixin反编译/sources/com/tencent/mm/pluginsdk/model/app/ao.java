package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.y.a.a.a;
import com.tencent.mm.protocal.c.agx;
import com.tencent.mm.protocal.c.apv;
import com.tencent.mm.protocal.c.apw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao implements e, t {
    private static ao vmb;
    public String lang;
    public boolean vmc = false;
    public boolean vmd = false;
    private List<String> vme = new LinkedList();
    public long vmf;
    private final int vmg = 20;
    public int vmh = 0;
    public long vmi;

    private ao() {
    }

    public static ao bZI() {
        if (vmb == null) {
            vmb = new ao();
        }
        return vmb;
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (g.Do().CF()) {
            this.vmc = false;
            x.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
            if (wVar == null) {
                x.e("MicroMsg.SuggestionAppListLogic", "scene == null");
            } else if (i == 0 && i2 == 0) {
                switch (wVar.getType()) {
                    case 4:
                        x.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", Integer.valueOf(((agx) ((ag) wVar).lSH.hnR.hnY).wva));
                        LinkedList linkedList = r13.vlz;
                        if (linkedList == null || linkedList.size() <= 0) {
                            x.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
                            return;
                        } else if (ad.getContext() == null || a.biY() == null) {
                            x.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
                            return;
                        } else {
                            f fVar;
                            LinkedList linkedList2 = new LinkedList();
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                fVar = (f) it.next();
                                String str2 = "MicroMsg.SuggestionAppListLogic";
                                String str3 = "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]";
                                Object[] objArr = new Object[5];
                                objArr[0] = fVar.field_appName;
                                objArr[1] = fVar.field_packageName;
                                objArr[2] = fVar.field_signature;
                                objArr[3] = fVar.fRF;
                                objArr[4] = Boolean.valueOf(fVar.fRE != null);
                                x.d(str2, str3, objArr);
                                linkedList2.add(fVar.field_appId);
                            }
                            a.biY().aa(linkedList2);
                            List<f> ei = g.ei(ad.getContext());
                            if (ei.size() > 0) {
                                i biW = a.biY().biW();
                                for (f fVar2 : ei) {
                                    if (fVar2.field_appId != null) {
                                        Object obj;
                                        Iterator it2 = linkedList.iterator();
                                        while (it2.hasNext()) {
                                            fVar = (f) it2.next();
                                            if (fVar.field_appId != null && fVar2.field_appId.equals(fVar.field_appId)) {
                                                obj = 1;
                                                if (obj != null) {
                                                    if (g.a(ad.getContext(), fVar2)) {
                                                        fVar2.field_status = 4;
                                                    } else {
                                                        fVar2.field_status = 1;
                                                    }
                                                    biW.a(fVar2, new String[0]);
                                                }
                                            }
                                        }
                                        obj = null;
                                        if (obj != null) {
                                            if (g.a(ad.getContext(), fVar2)) {
                                                fVar2.field_status = 4;
                                            } else {
                                                fVar2.field_status = 1;
                                            }
                                            biW.a(fVar2, new String[0]);
                                        }
                                    }
                                }
                            }
                            g.Dr();
                            g.Dq().Db().setLong(352275, System.currentTimeMillis());
                            this.vmf = System.currentTimeMillis();
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    public final void ek(Context context) {
        if (!g.Do().CF() || context == null) {
            return;
        }
        if (this.vmd) {
            x.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
            return;
        }
        this.vmd = true;
        if (this.lang == null) {
            this.lang = w.d(context.getSharedPreferences(ad.cgf(), 0));
        }
        x.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
        cV(this.lang, this.vmh);
    }

    public static void cV(String str, int i) {
        x.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", Integer.valueOf(i), str);
        k afVar = new af(i, str);
        g.Dr();
        g.Dp().gRu.a(afVar, 0);
    }

    public final void reset() {
        x.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
        g.Dr();
        g.Dq().Db().setLong(352276, 0);
        this.vmi = 0;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (g.Do().CF()) {
            this.vmd = false;
            if (kVar == null) {
                x.e("MicroMsg.SuggestionAppListLogic", "scene == null");
                this.vmh = 0;
                this.vme.clear();
                return;
            } else if (i == 0 && i2 == 0) {
                x.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                af afVar = (af) kVar;
                apv apv = (afVar.gLB == null || afVar.gLB.hnR.hnY == null) ? null : (apv) afVar.gLB.hnR.hnY;
                if (apv == null) {
                    x.e("MicroMsg.SuggestionAppListLogic", "resp == null");
                    this.vmh = 0;
                    this.vme.clear();
                    return;
                } else if (apv.wDj == null || apv.wDj.size() <= 0) {
                    x.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
                    a(a.biY().biW(), this.vme);
                    this.vmh = 0;
                    this.vme.clear();
                    g.Dr();
                    g.Dq().Db().setLong(352276, System.currentTimeMillis());
                    this.vmi = System.currentTimeMillis();
                    return;
                } else {
                    x.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", Integer.valueOf(this.vmh), Integer.valueOf(apv.wDj.size()));
                    i biW = a.biY().biW();
                    List linkedList = new LinkedList();
                    Iterator it = apv.wDj.iterator();
                    while (it.hasNext()) {
                        apw apw = (apw) it.next();
                        x.v("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", apw.wbJ, Integer.valueOf(apw.wDo), Integer.valueOf(apw.wDs), Integer.valueOf(apw.wDr), Integer.valueOf(apw.wDp), apw.fGh);
                        if (!bi.oN(apw.fGh)) {
                            if (f.vkQ.equals(apw.fGh)) {
                                apw.wDp = (apw.wDp ^ 253) ^ -1;
                                x.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", Integer.valueOf(apw.wDp));
                            }
                            this.vme.add(apw.fGh);
                            f aZ = g.aZ(apw.fGh, true);
                            if (aZ != null) {
                                Object obj = aZ.field_serviceAppInfoFlag != apw.wDp ? 1 : aZ.field_serviceAppType != apw.wDo ? 1 : aZ.fRS != apw.wDr ? 1 : aZ.field_serviceShowFlag != apw.wDs ? 1 : !bi.oM(aZ.field_appName).equals(bi.oM(apw.wbJ)) ? 1 : !bi.oM(aZ.field_appName_en).equals(bi.oM(apw.wDk)) ? 1 : !bi.oM(aZ.field_appName_tw).equals(bi.oM(apw.wDl)) ? 1 : !bi.oM(aZ.field_appName_hk).equals(bi.oM(apw.wDw)) ? 1 : !bi.oM(aZ.fRQ).equals(bi.oM(apw.wDn)) ? 1 : !bi.oM(aZ.fRP).equals(bi.oM(apw.wDm)) ? 1 : !bi.oM(aZ.fRR).equals(bi.oM(apw.wDq)) ? 1 : null;
                                if (obj != null) {
                                    String str2 = aZ.fRQ;
                                    String str3 = aZ.fRP;
                                    a(aZ, apw);
                                    boolean a = biW.a(aZ, new String[0]);
                                    if (!bi.oM(str2).equals(bi.oM(apw.wDn))) {
                                        x.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bi.oM(apw.wDn));
                                        com.tencent.mm.plugin.y.a.biR().cS(aZ.field_appId, 5);
                                    }
                                    if (!bi.oM(str3).equals(bi.oM(apw.wDm))) {
                                        x.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bi.oM(apw.wDm));
                                        com.tencent.mm.plugin.y.a.biR().cS(aZ.field_appId, 4);
                                    }
                                    x.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", apw.fGh, Boolean.valueOf(a));
                                }
                            } else {
                                aZ = new f();
                                aZ.field_appId = apw.fGh;
                                a(aZ, apw);
                                boolean l = biW.l(aZ);
                                x.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", apw.fGh, Boolean.valueOf(l));
                            }
                            if (bi.oN(aZ.field_openId)) {
                                linkedList.add(apw.fGh);
                            }
                        }
                    }
                    if (linkedList.size() > 0) {
                        x.d("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", Integer.valueOf(linkedList.size()));
                        com.tencent.mm.plugin.y.a.biV().cx(linkedList);
                    }
                    if (apv.wDj.size() == 20) {
                        this.vmh += 20;
                        cV(this.lang, this.vmh);
                    } else {
                        a(biW, this.vme);
                        this.vmh = 0;
                        this.vme.clear();
                    }
                    g.Dr();
                    g.Dq().Db().setLong(352276, System.currentTimeMillis());
                    this.vmi = System.currentTimeMillis();
                    return;
                }
            } else {
                x.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                this.vmh = 0;
                this.vme.clear();
                return;
            }
        }
        x.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
        this.vmh = 0;
        this.vme.clear();
    }

    private static void a(i iVar, List<String> list) {
        if (iVar != null && list != null && list.size() > 0) {
            x.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
            List<f> arrayList = new ArrayList();
            if (a.biY() == null) {
                x.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
            } else {
                Cursor biX = a.biY().biX();
                if (biX != null) {
                    while (biX.moveToNext()) {
                        f fVar = new f();
                        fVar.b(biX);
                        if (!bi.oN(fVar.field_openId)) {
                            arrayList.add(fVar);
                        }
                    }
                    biX.close();
                }
            }
            x.d("MicroMsg.SuggestionAppListLogic", "oldList %d", Integer.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                for (f fVar2 : arrayList) {
                    if (fVar2.field_appId != null) {
                        int i;
                        for (String equals : list) {
                            if (fVar2.field_appId.equals(equals)) {
                                i = 1;
                                break;
                            }
                        }
                        i = 0;
                        if (i == 0) {
                            boolean b = iVar.b(fVar2, new String[0]);
                            x.d("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", fVar2.field_appId, Boolean.valueOf(b));
                        }
                    }
                }
            }
        }
    }

    private static void a(f fVar, apw apw) {
        fVar.field_appName = apw.wbJ;
        fVar.field_appName_en = apw.wDk;
        fVar.field_appName_tw = apw.wDl;
        fVar.field_appName_hk = apw.wDw;
        fVar.fRP = apw.wDm;
        fVar.fQS = true;
        fVar.fRQ = apw.wDn;
        fVar.fQS = true;
        fVar.fRR = apw.wDq;
        fVar.fQS = true;
        fVar.field_serviceAppInfoFlag = apw.wDp;
        fVar.field_serviceAppType = apw.wDo;
        fVar.fRS = apw.wDr;
        fVar.fQS = true;
        fVar.field_serviceShowFlag = apw.wDs;
    }
}
