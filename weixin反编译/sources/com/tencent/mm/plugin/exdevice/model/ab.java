package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ac.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.d;
import com.tencent.mm.af.y;
import com.tencent.mm.f.a.gx;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.exdevice.a;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.bfz;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bnj;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab extends c<gx> implements e {
    private ProgressDialog inI;
    gx lTc;

    public ab() {
        this.xmG = gx.class.getName().hashCode();
    }

    private boolean a(gx gxVar) {
        if (gxVar instanceof gx) {
            this.lTc = gxVar;
            String str = this.lTc.fxW.result;
            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", Integer.valueOf(this.lTc.fxW.actionCode), str);
            if (!bi.oN(str)) {
                switch (this.lTc.fxW.actionCode) {
                    case 15:
                        if (this.lTc.fxW.context != null && (this.lTc.fxW.context instanceof Activity)) {
                            as.CN().a(540, (e) this);
                            final k uVar = new u(str);
                            as.CN().a(uVar, 0);
                            Context context = this.lTc.fxW.context;
                            this.lTc.fxW.context.getString(R.l.dGZ);
                            this.inI = h.a(context, this.lTc.fxW.context.getString(R.l.eIc), new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    as.CN().c(uVar);
                                    if (ab.this.lTc.frD != null) {
                                        ab.this.lTc.fxX.ret = 1;
                                        ab.this.lTc.frD.run();
                                    }
                                }
                            });
                            break;
                        }
                }
            }
        }
        x.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
        }
        if (kVar == null) {
            aEP();
        } else if (i == 0 && i2 == 0) {
            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", Integer.valueOf(kVar.getType()));
            if (kVar.getType() == 540) {
                as.CN().b(540, (e) this);
                u uVar = (u) kVar;
                bfz bfz = (uVar.gLB == null || uVar.gLB.hnR.hnY == null) ? null : (bfz) uVar.gLB.hnR.hnY;
                if (bfz == null) {
                    x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
                    aEP();
                    return;
                }
                String str2;
                String str3;
                LinkedList linkedList;
                String str4;
                ArrayList arrayList;
                int i3;
                int i4;
                bnj bnj;
                Intent intent;
                Object obj;
                boolean contains;
                asc asc;
                String oM;
                ag Xv;
                com.tencent.mm.storage.x xVar;
                bmk bmk;
                d jN;
                py pyVar;
                ake ake = bfz.vSI;
                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", ake.kyJ, ake.vQr);
                akf akf = bfz.vSJ;
                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", akf.vPY, akf.wxU, Integer.valueOf(akf.wxX), akf.wxV, Integer.valueOf(akf.wxW), akf.vSj);
                String str5 = "";
                String str6 = "";
                LinkedList linkedList2 = new LinkedList();
                if (bfz.wRR != null) {
                    if (bfz.wRR.vOm != null) {
                        str5 = bfz.wRR.vOm;
                    }
                    if (bfz.wRR.title != null) {
                        str6 = bfz.wRR.title;
                    }
                    if (bfz.wRR.vOn != null) {
                        str2 = str5;
                        str3 = str6;
                        linkedList = bfz.wRR.vOn;
                        str4 = str3;
                        arrayList = new ArrayList();
                        if (linkedList != null && linkedList.size() > 0) {
                            i3 = 0;
                            while (true) {
                                i4 = i3;
                                if (i4 < linkedList.size()) {
                                    break;
                                }
                                bnj = (bnj) linkedList.get(i4);
                                if (bnj.type.contains("text")) {
                                    arrayList.add(bnj.content);
                                }
                                i3 = i4 + 1;
                            }
                        }
                        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", bfz.vSo);
                        if (bfz.wRQ != 1) {
                            intent = new Intent();
                            intent.putExtra("device_scan_mode", "SCAN_CATALOG");
                            obj = (akf.wxV.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || akf.wxV.contains("1")) ? 1 : null;
                            contains = akf.wxV.contains("4");
                            if (obj == null && contains) {
                                x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
                                return;
                            }
                            if (obj != null) {
                                intent.putExtra("device_scan_conn_proto", "blue");
                            } else if (contains) {
                                intent.putExtra("device_scan_conn_proto", "wifi");
                            }
                            intent.putExtra("device_id", ake.kyJ);
                            intent.putExtra("device_type", ake.vQr);
                            intent.putExtra("device_title", akf.wyb);
                            intent.putExtra("device_desc", akf.wyc);
                            intent.putExtra("device_icon_url", akf.nlA);
                            intent.putExtra("device_category_id", akf.wyd);
                            intent.putExtra("device_brand_name", akf.wxU);
                            intent.putExtra("bind_ticket", bfz.vSo);
                            intent.putExtra("device_ble_simple_proto", akf.ggQ);
                            intent.putExtra("device_airkiss_key", str2);
                            intent.putExtra("device_airkiss_title", str4);
                            intent.putStringArrayListExtra("device_airkiss_steps", arrayList);
                            com.tencent.mm.bl.d.b(this.lTc.fxW.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent);
                            arM();
                        }
                        asc = bfz.vSp;
                        if (asc != null) {
                            x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                            aEP();
                            return;
                        }
                        arM();
                        if (asc != null) {
                            x.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                        } else {
                            str2 = n.a(asc.wfM);
                            oM = bi.oM(asc.wGt);
                            if (bi.oN(str2) || !bi.oN(oM)) {
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", str2);
                                as.Hm();
                                Xv = com.tencent.mm.y.c.Ff().Xv(str2);
                                if (Xv == null && str2.equals(Xv.field_encryptUsername)) {
                                    x.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
                                } else {
                                    xVar = new com.tencent.mm.storage.x(str2);
                                    xVar.cZ(asc.hxj);
                                    xVar.setType(asc.weQ & asc.weR);
                                    if (bi.oN(oM)) {
                                        xVar.di(oM);
                                    } else if (Xv != null && ((int) Xv.gKO) > 0) {
                                        xVar.di(Xv.field_encryptUsername);
                                    }
                                    xVar.gKO = Xv != null ? 0 : (long) ((int) Xv.gKO);
                                    xVar.dc(n.a(asc.wzM));
                                    xVar.dd(n.a(asc.wfA));
                                    xVar.de(n.a(asc.wfB));
                                    xVar.eD(asc.hxe);
                                    xVar.eG(asc.weW);
                                    xVar.db(n.a(asc.wGn));
                                    xVar.eH(asc.wfa);
                                    xVar.eI(asc.hxi);
                                    xVar.dv(RegionCodeDecoder.ai(asc.hxn, asc.hxf, asc.hxg));
                                    xVar.dp(asc.hxh);
                                    xVar.ez(asc.wCq);
                                    xVar.du(asc.wCr);
                                    xVar.setSource(asc.vON);
                                    xVar.ey(asc.wCu);
                                    xVar.df(asc.wCt);
                                    if (s.hw(asc.wCs)) {
                                        xVar.dt(asc.wCs);
                                    }
                                    xVar.eK((int) bi.Wx());
                                    xVar.da(n.a(asc.wFS));
                                    xVar.dg(n.a(asc.wFU));
                                    xVar.dh(n.a(asc.wFT));
                                    xVar.dw(asc.vPF);
                                    xVar.dx(asc.wGD);
                                    if (!(Xv == null || bi.oM(Xv.fXu).equals(bi.oM(asc.wGD)))) {
                                        com.tencent.mm.ba.c.QS();
                                        com.tencent.mm.ba.c.lT(str2);
                                    }
                                    as.Hm();
                                    com.tencent.mm.y.c.Ff().XA(str2);
                                    if (bi.oN(xVar.field_username)) {
                                        str5 = xVar.field_username;
                                        com.tencent.mm.ac.n.JW().a(b.a(str5, asc));
                                        bmk = asc.wCw;
                                        if (!(xVar.field_username.endsWith("@chatroom") || bmk == null)) {
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + bmk.hxp + " " + asc.wfM);
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + bmk.hxq);
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + bmk.hxr);
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + bmk.wWj);
                                            if (com.tencent.mm.plugin.sns.b.n.qWC != null) {
                                                com.tencent.mm.plugin.sns.b.n.qWC.a(xVar.field_username, bmk);
                                            }
                                        }
                                        str6 = q.FY();
                                        if (!(str6 == null || str6.equals(str5))) {
                                            jN = y.Ml().jN(str5);
                                            jN.field_username = str5;
                                            jN.field_brandList = asc.hxo;
                                            pyVar = asc.wCx;
                                            if (pyVar != null) {
                                                jN.field_brandFlag = pyVar.hxs;
                                                jN.field_brandInfo = pyVar.hxu;
                                                jN.field_brandIconURL = pyVar.hxv;
                                                jN.field_extInfo = pyVar.hxt;
                                                jN.field_attrSyncVersion = null;
                                                jN.field_incrementUpdateTime = 0;
                                            }
                                            if (!y.Ml().e(jN)) {
                                                y.Ml().d(jN);
                                            }
                                            xVar.eL(jN.field_type);
                                        }
                                    } else {
                                        x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                                    }
                                    xVar.eB(asc.wGC);
                                    if (!(asc.wGy == null || asc.wGy.vOb == null)) {
                                        xVar.dy(asc.wGy.vOb.vSL);
                                        xVar.dz(asc.wGy.vOb.vSM);
                                        xVar.dA(asc.wGy.vOb.vSN);
                                    }
                                    if (s.hq(str2)) {
                                        xVar.Aw();
                                    }
                                    if (xVar.ciN()) {
                                        xVar.Az();
                                    }
                                    if (bi.oN(oM)) {
                                        as.Hm();
                                        com.tencent.mm.y.c.Ff().b(oM, xVar);
                                    } else {
                                        as.Hm();
                                        com.tencent.mm.y.c.Ff().R(xVar);
                                    }
                                    if (!(Xv == null || (Xv.field_type & 2048) == (xVar.field_type & 2048))) {
                                        if ((xVar.field_type & 2048) == 0) {
                                            as.Hm();
                                            com.tencent.mm.y.c.Fk().XK(xVar.field_username);
                                        } else {
                                            as.Hm();
                                            com.tencent.mm.y.c.Fk().XL(xVar.field_username);
                                        }
                                    }
                                }
                            } else {
                                x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", str2, oM);
                            }
                        }
                        str5 = n.a(asc.wfM);
                        if (this.lTc != null || this.lTc.fxW == null || this.lTc.fxW.context == null) {
                            x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                            return;
                        }
                        as.Hm();
                        ag Xv2 = com.tencent.mm.y.c.Ff().Xv(str5);
                        if (Xv2 == null) {
                            return;
                        }
                        if (akf.ggP != 0) {
                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
                            Context context = this.lTc.fxW.context;
                            Intent intent2 = new Intent(context, ExdeviceDeviceProfileUI.class);
                            if (!(context instanceof Activity)) {
                                intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            }
                            intent2.putExtra("device_id", ake.kyJ);
                            intent2.putExtra("device_type", ake.vQr);
                            intent2.putExtra("device_mac", akf.vSj);
                            intent2.putExtra("device_brand_name", akf.wxU);
                            intent2.putExtra("device_alias", akf.hxj);
                            intent2.putExtra("device_desc", akf.wyc);
                            intent2.putExtra("device_title", akf.wyb);
                            intent2.putExtra("device_icon_url", akf.nlA);
                            intent2.putExtra("device_jump_url", akf.nkN);
                            intent2.putExtra("bind_ticket", bfz.vSo);
                            intent2.putExtra("device_has_bound", ad.aER().cw(Xv2.field_username, ake.kyJ) != null);
                            context.startActivity(intent2);
                            return;
                        }
                        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
                        intent = new Intent();
                        intent.putExtra("Contact_User", str5);
                        intent.putExtra("KIsHardDevice", true);
                        intent.putExtra("KHardDeviceBindTicket", bfz.vSo);
                        intent.putExtra("device_id", ake.kyJ);
                        intent.putExtra("device_type", ake.vQr);
                        a.lPD.d(intent, this.lTc.fxW.context);
                        return;
                    }
                }
                str2 = str5;
                str3 = str6;
                linkedList = linkedList2;
                str4 = str3;
                arrayList = new ArrayList();
                i3 = 0;
                while (true) {
                    i4 = i3;
                    if (i4 < linkedList.size()) {
                        break;
                    }
                    bnj = (bnj) linkedList.get(i4);
                    if (bnj.type.contains("text")) {
                        arrayList.add(bnj.content);
                    }
                    i3 = i4 + 1;
                }
                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", bfz.vSo);
                if (bfz.wRQ != 1) {
                    asc = bfz.vSp;
                    if (asc != null) {
                        arM();
                        if (asc != null) {
                            str2 = n.a(asc.wfM);
                            oM = bi.oM(asc.wGt);
                            if (bi.oN(str2)) {
                            }
                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", str2);
                            as.Hm();
                            Xv = com.tencent.mm.y.c.Ff().Xv(str2);
                            if (Xv == null) {
                            }
                            xVar = new com.tencent.mm.storage.x(str2);
                            xVar.cZ(asc.hxj);
                            xVar.setType(asc.weQ & asc.weR);
                            if (bi.oN(oM)) {
                                xVar.di(Xv.field_encryptUsername);
                            } else {
                                xVar.di(oM);
                            }
                            if (Xv != null) {
                            }
                            xVar.gKO = Xv != null ? 0 : (long) ((int) Xv.gKO);
                            xVar.dc(n.a(asc.wzM));
                            xVar.dd(n.a(asc.wfA));
                            xVar.de(n.a(asc.wfB));
                            xVar.eD(asc.hxe);
                            xVar.eG(asc.weW);
                            xVar.db(n.a(asc.wGn));
                            xVar.eH(asc.wfa);
                            xVar.eI(asc.hxi);
                            xVar.dv(RegionCodeDecoder.ai(asc.hxn, asc.hxf, asc.hxg));
                            xVar.dp(asc.hxh);
                            xVar.ez(asc.wCq);
                            xVar.du(asc.wCr);
                            xVar.setSource(asc.vON);
                            xVar.ey(asc.wCu);
                            xVar.df(asc.wCt);
                            if (s.hw(asc.wCs)) {
                                xVar.dt(asc.wCs);
                            }
                            xVar.eK((int) bi.Wx());
                            xVar.da(n.a(asc.wFS));
                            xVar.dg(n.a(asc.wFU));
                            xVar.dh(n.a(asc.wFT));
                            xVar.dw(asc.vPF);
                            xVar.dx(asc.wGD);
                            com.tencent.mm.ba.c.QS();
                            com.tencent.mm.ba.c.lT(str2);
                            as.Hm();
                            com.tencent.mm.y.c.Ff().XA(str2);
                            if (bi.oN(xVar.field_username)) {
                                str5 = xVar.field_username;
                                com.tencent.mm.ac.n.JW().a(b.a(str5, asc));
                                bmk = asc.wCw;
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + bmk.hxp + " " + asc.wfM);
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + bmk.hxq);
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + bmk.hxr);
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + bmk.wWj);
                                if (com.tencent.mm.plugin.sns.b.n.qWC != null) {
                                    com.tencent.mm.plugin.sns.b.n.qWC.a(xVar.field_username, bmk);
                                }
                                str6 = q.FY();
                                jN = y.Ml().jN(str5);
                                jN.field_username = str5;
                                jN.field_brandList = asc.hxo;
                                pyVar = asc.wCx;
                                if (pyVar != null) {
                                    jN.field_brandFlag = pyVar.hxs;
                                    jN.field_brandInfo = pyVar.hxu;
                                    jN.field_brandIconURL = pyVar.hxv;
                                    jN.field_extInfo = pyVar.hxt;
                                    jN.field_attrSyncVersion = null;
                                    jN.field_incrementUpdateTime = 0;
                                }
                                if (y.Ml().e(jN)) {
                                    y.Ml().d(jN);
                                }
                                xVar.eL(jN.field_type);
                            } else {
                                x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                            }
                            xVar.eB(asc.wGC);
                            xVar.dy(asc.wGy.vOb.vSL);
                            xVar.dz(asc.wGy.vOb.vSM);
                            xVar.dA(asc.wGy.vOb.vSN);
                            if (s.hq(str2)) {
                                xVar.Aw();
                            }
                            if (xVar.ciN()) {
                                xVar.Az();
                            }
                            if (bi.oN(oM)) {
                                as.Hm();
                                com.tencent.mm.y.c.Ff().R(xVar);
                            } else {
                                as.Hm();
                                com.tencent.mm.y.c.Ff().b(oM, xVar);
                            }
                            if ((xVar.field_type & 2048) == 0) {
                                as.Hm();
                                com.tencent.mm.y.c.Fk().XL(xVar.field_username);
                            } else {
                                as.Hm();
                                com.tencent.mm.y.c.Fk().XK(xVar.field_username);
                            }
                        } else {
                            x.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                        }
                        str5 = n.a(asc.wfM);
                        if (this.lTc != null) {
                        }
                        x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                        return;
                    }
                    x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                    aEP();
                    return;
                }
                intent = new Intent();
                intent.putExtra("device_scan_mode", "SCAN_CATALOG");
                if (!akf.wxV.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                }
                contains = akf.wxV.contains("4");
                if (obj == null) {
                }
                if (obj != null) {
                    intent.putExtra("device_scan_conn_proto", "blue");
                } else if (contains) {
                    intent.putExtra("device_scan_conn_proto", "wifi");
                }
                intent.putExtra("device_id", ake.kyJ);
                intent.putExtra("device_type", ake.vQr);
                intent.putExtra("device_title", akf.wyb);
                intent.putExtra("device_desc", akf.wyc);
                intent.putExtra("device_icon_url", akf.nlA);
                intent.putExtra("device_category_id", akf.wyd);
                intent.putExtra("device_brand_name", akf.wxU);
                intent.putExtra("bind_ticket", bfz.vSo);
                intent.putExtra("device_ble_simple_proto", akf.ggQ);
                intent.putExtra("device_airkiss_key", str2);
                intent.putExtra("device_airkiss_title", str4);
                intent.putStringArrayListExtra("device_airkiss_steps", arrayList);
                com.tencent.mm.bl.d.b(this.lTc.fxW.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent);
                arM();
            }
        } else {
            x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", Integer.valueOf(kVar.getType()));
            aEP();
        }
    }

    private void aEP() {
        if (this.lTc != null && this.lTc.frD != null) {
            this.lTc.fxX.ret = 1;
            this.lTc.frD.run();
        }
    }

    private void arM() {
        if (this.lTc != null && this.lTc.frD != null) {
            this.lTc.fxX.ret = 2;
            this.lTc.frD.run();
        }
    }
}
