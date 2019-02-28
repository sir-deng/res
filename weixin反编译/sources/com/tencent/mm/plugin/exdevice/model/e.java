package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.d;
import com.tencent.mm.af.f;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.cu;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.f.a.cx;
import com.tencent.mm.f.a.cy;
import com.tencent.mm.f.a.cz;
import com.tencent.mm.f.a.da;
import com.tencent.mm.f.a.db;
import com.tencent.mm.f.a.dc;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.de;
import com.tencent.mm.f.a.df;
import com.tencent.mm.f.a.dg;
import com.tencent.mm.f.a.dh;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.f.a.dq;
import com.tencent.mm.f.a.ds;
import com.tencent.mm.f.a.dt;
import com.tencent.mm.f.a.du;
import com.tencent.mm.f.a.dv;
import com.tencent.mm.f.a.dw;
import com.tencent.mm.f.a.dx;
import com.tencent.mm.f.a.dz;
import com.tencent.mm.f.a.ea;
import com.tencent.mm.f.a.eb;
import com.tencent.mm.f.a.ed;
import com.tencent.mm.f.a.ee;
import com.tencent.mm.f.a.ef;
import com.tencent.mm.f.a.eg;
import com.tencent.mm.f.a.eh;
import com.tencent.mm.f.a.ej;
import com.tencent.mm.f.a.ek;
import com.tencent.mm.f.a.el;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.en;
import com.tencent.mm.f.a.eo;
import com.tencent.mm.f.a.ep;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.f.a.jc;
import com.tencent.mm.f.a.jd;
import com.tencent.mm.f.a.kw;
import com.tencent.mm.f.a.ky;
import com.tencent.mm.f.a.lb;
import com.tencent.mm.f.a.qz;
import com.tencent.mm.f.a.ra;
import com.tencent.mm.f.a.re;
import com.tencent.mm.f.a.y;
import com.tencent.mm.f.b.br;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.j.g;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.i.i;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.q.aa;
import com.tencent.mm.protocal.c.adc;
import com.tencent.mm.protocal.c.ade;
import com.tencent.mm.protocal.c.adf;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.aky;
import com.tencent.mm.protocal.c.akz;
import com.tencent.mm.protocal.c.alb;
import com.tencent.mm.protocal.c.alc;
import com.tencent.mm.protocal.c.ald;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public com.tencent.mm.sdk.b.c kAi = new com.tencent.mm.sdk.b.c<y>() {
        {
            this.xmG = y.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return e.aEF();
        }
    };
    List<b> lQF = new LinkedList();
    Map<String, b> lQG = new HashMap();
    public com.tencent.mm.sdk.b.c lQH = new com.tencent.mm.sdk.b.c<jd>() {
        {
            this.xmG = jd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.plugin.exdevice.h.b bVar2;
            jd jdVar = (jd) bVar;
            e eVar = e.this;
            int i = jdVar.fAz.opType;
            int i2 = jdVar.fAz.fAB;
            String str = jdVar.fAz.fAA;
            if (i == 1) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "Just enter, so clear previous state.");
                com.tencent.mm.sdk.b.b lbVar = new lb();
                lbVar.fDh.op = 3;
                lbVar.fDh.fAA = jdVar.fAz.fAA;
                com.tencent.mm.sdk.b.a.xmy.m(lbVar);
            }
            LinkedList zO = ad.aER().zO(str);
            d jV = f.jV(str);
            if (jV != null) {
                com.tencent.mm.af.d.b bK = jV.bK(false);
                if (bK != null) {
                    com.tencent.mm.af.d.b.b LE = bK.LE();
                    if (LE != null && LE.LN() && LE.hqM == 1) {
                        List<com.tencent.mm.plugin.exdevice.h.b> aFx = ad.aER().aFx();
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat sport biz...");
                        if (aFx.size() != 0) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : aFx) {
                                if (0 != (bVar22.ggQ & 1)) {
                                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE connected device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d), connProto(%s)", Long.valueOf(bVar22.field_mac), bVar22.field_deviceID, bVar22.field_deviceType, Long.valueOf(bVar22.ggQ), bVar22.field_connProto);
                                    zO.add(bVar22);
                                }
                            }
                        }
                    }
                }
            }
            if (zO == null) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName failed : %s", str);
                return false;
            } else if (zO.size() == 0) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName(%s) result count is 0 ", str);
                return true;
            } else {
                if (i == 2) {
                    x.d("MicroMsg.exdevice.ExdeviceEventManager", "exit chattingui, clear observers.");
                    eVar.lQG.clear();
                }
                List linkedList = new LinkedList();
                Iterator it = zO.iterator();
                Object obj = null;
                while (it.hasNext()) {
                    bVar22 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                    if (bVar22 == null || bi.oN(bVar22.field_brandName)) {
                        return false;
                    }
                    String oM = bi.oM(bVar22.field_connProto);
                    if (oM.contains("4")) {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz.");
                        linkedList.add(bVar22);
                    } else {
                        if (oM.contains("1") || oM.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || oM.contains("5") || oM.length() == 0) {
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "BlueTooth biz.");
                            if (com.tencent.mm.plugin.g.a.e.a.asc()) {
                                obj = null;
                                eVar.a(bVar22, i, i2);
                            } else {
                                x.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                                obj = 1;
                            }
                        }
                        obj = obj;
                    }
                }
                i2 = linkedList.size();
                if (i2 > 0) {
                    eVar.e(linkedList, i);
                    bVar22 = (com.tencent.mm.plugin.exdevice.h.b) linkedList.get(i2 - 1);
                    if (i2 == zO.size()) {
                        e.e(bVar22.field_brandName, bVar22.field_url, 0, bVar22.field_deviceID);
                    }
                }
                e.bi(str, obj != null ? 0 : -1);
                return false;
            }
        }
    };
    public com.tencent.mm.sdk.b.c lQI = new com.tencent.mm.sdk.b.c<jc>() {
        {
            this.xmG = jc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            u.aFt().a(new i(((jc) bVar).fAy.opType));
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lQJ = new com.tencent.mm.sdk.b.c<dv>() {
        {
            this.xmG = dv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dv dvVar = (dv) bVar;
            e eVar = e.this;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOpInChattingUIEvent");
            dvVar = dvVar;
            if (bi.oN(dvVar.ftn.userName)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceOpInChattingUIEventListener, userName is null");
                return false;
            }
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "This biz is binded a device, notify chatting view to dimiss connect fail tips");
            e.bi(dvVar.ftn.userName, -1);
            if ((dvVar.ftn.op != 0 && dvVar.ftn.op != 3) || !i.lSx.eM(false)) {
                return eVar.ab(dvVar.ftn.op, dvVar.ftn.userName);
            }
            i.lSx.a(dvVar.ftn.context, new AnonymousClass39(dvVar));
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lQK = new com.tencent.mm.sdk.b.c<cu>() {
        {
            this.xmG = cu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cu cuVar = (cu) bVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceBindHardDeviceEvent");
            cuVar = cuVar;
            int i = cuVar.frS.opType;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "now optype is %d, subscribeFlag is %d", Integer.valueOf(i), Integer.valueOf(cuVar.frS.frV));
            if (i == 1) {
                k lVar = new l(cuVar.frS.frU, r1);
                as.CN().a(lVar, 0);
                cuVar.frT.frW = lVar;
            } else if (i == 2 && cuVar.frS.frW != null) {
                as.CN().c((l) cuVar.frS.frW);
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lQL = new com.tencent.mm.sdk.b.c<ep>() {
        {
            this.xmG = ep.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ep epVar = (ep) bVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceUnBindHardDeviceEvent");
            ad.aEY().ps(0);
            epVar = epVar;
            if (bi.oN(epVar.fua.fsi)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "brandName is null, can not unbind device");
                return false;
            }
            ake ake = new ake();
            ake.kyJ = "";
            ake.vQr = epVar.fua.fsi;
            as.CN().a(new x(ake, 1), 0);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lQM = new com.tencent.mm.sdk.b.c<qz>() {
        {
            this.xmG = qz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return e.aEC();
        }
    };
    public com.tencent.mm.sdk.b.c lQN = new com.tencent.mm.sdk.b.c<ra>() {
        {
            this.xmG = ra.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ra raVar = (ra) bVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelWithParamsEvent");
            raVar = raVar;
            ad.aEY();
            d.eK(raVar.fJG.fJH);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lQO = new com.tencent.mm.sdk.b.c<re>() {
        {
            this.xmG = re.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            e eVar = e.this;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive SyncExdeviceDataEvent");
            int Ks = as.CN().Ks();
            if (Ks == 4 || Ks == 6) {
                boolean z;
                String value = g.Af().getValue("DeviceAutoSyncClose");
                x.i("MicroMsg.exdevice.Util", "handleSyncExdeviceDataEvent, auto sync has close : %s", value);
                if (bi.oN(value) || !value.equalsIgnoreCase("1")) {
                    z = true;
                } else {
                    x.i("MicroMsg.exdevice.Util", "auto sync has closed, ignore this sync request");
                    z = false;
                }
                if (!z) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "not allowed to sync exdevice data");
                    return false;
                } else if (!com.tencent.mm.plugin.g.a.e.a.cp(ad.getContext())) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
                    return false;
                } else if (com.tencent.mm.plugin.g.a.e.a.asc()) {
                    ad.aEY();
                    if (d.aEz() == 1) {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "it is in brand");
                        return false;
                    } else if (i.lSx.eM(false)) {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound harddevices");
                        i.lSx.a(null, new com.tencent.mm.plugin.exdevice.model.i.a() {
                            public final void eL(boolean z) {
                                e.aEB();
                            }
                        });
                        return true;
                    } else {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "now do not need to get bound device, do sync directly");
                        return e.aEB();
                    }
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
                    return false;
                }
            }
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, now state is %d", Integer.valueOf(Ks));
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lQP = new com.tencent.mm.sdk.b.c<dc>() {
        {
            this.xmG = dc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = ((dc) bVar).fsq.fsr;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "------handleGetBoundDeviceEvent------ check if need to get bound device after auth");
            if (i.lSx.eM(z)) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "do get bound device after auth");
                i.lSx.a(null, null);
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lQQ = new com.tencent.mm.sdk.b.c<dk>() {
        {
            this.xmG = dk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dk dkVar = (dk) bVar;
            if (dkVar != null && (dkVar instanceof dk)) {
                dkVar = dkVar;
                String str = dkVar.fsP.fsR;
                boolean z = dkVar.fsP.fsO;
                d aEY = ad.aEY();
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
                as.Dt().F(new com.tencent.mm.plugin.exdevice.model.d.AnonymousClass5(str, z));
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lQR = new com.tencent.mm.sdk.b.c<dx>() {
        {
            this.xmG = dx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return e.this.g((dx) bVar);
        }
    };
    public com.tencent.mm.sdk.b.c lQS = new com.tencent.mm.sdk.b.c<dh>() {
        {
            this.xmG = dh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return e.this.f((dh) bVar);
        }
    };
    public com.tencent.mm.sdk.b.c lQT = new com.tencent.mm.sdk.b.c<cz>() {
        {
            this.xmG = cz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = false;
            cz czVar = (cz) bVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleConnectDeviceEvent: brandName=%s, deviceId=%s, type=%b", czVar.fsg.fsi, czVar.fsg.ffG, Boolean.valueOf(czVar.fsg.fsj));
            String str = czVar.fsg.fsi;
            String str2 = czVar.fsg.ffG;
            boolean z2 = czVar.fsg.fsj;
            if (bi.oN(str) || bi.oN(str2)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "connectBluetoothDevice %s, %s, %s", str, str2, Boolean.valueOf(z2));
            } else {
                com.tencent.mm.plugin.exdevice.h.b zM = ad.aER().zM(str2);
                if (zM == null) {
                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", str2);
                } else if (!zM.field_brandName.equals(str)) {
                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", zM.field_brandName, str);
                } else if (bi.oM(zM.field_connProto).contains("4")) {
                    e.e(str, zM.field_url, -1, zM.field_deviceType);
                    e.bi(str, -1);
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz, Just leave");
                } else if (com.tencent.mm.plugin.g.a.e.a.asc()) {
                    e.bi(str, -1);
                    int a = e.a(zM);
                    if (a == 1) {
                        if (!com.tencent.mm.plugin.g.a.e.a.asa()) {
                            x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BC, but you phone not support BC.");
                        }
                    } else if (a == 0 && !com.tencent.mm.plugin.g.a.e.a.cp(ad.getContext())) {
                        e.bi(str, 1);
                        x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                    }
                    if (z2) {
                        if (aa.aEO().lSi) {
                            aa.aEO().pt(a);
                        }
                        d aEY = ad.aEY();
                        if (!(aEY.lQq == null || aEY.lQq.size() == 0)) {
                            aEY.lQq.clear();
                        }
                        ad.aEY().a(zM.field_brandName, zM.field_mac, a);
                    } else {
                        ad.aEY();
                        d.co(zM.field_mac);
                    }
                    z = true;
                } else {
                    x.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                    e.bi(str, 0);
                }
            }
            czVar.fsh.fsk = z;
            return z;
        }
    };
    public com.tencent.mm.sdk.b.c lQU = new com.tencent.mm.sdk.b.c<db>() {
        {
            this.xmG = db.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            db dbVar = (db) bVar;
            com.tencent.mm.plugin.exdevice.h.b cw = ad.aER().cw(dbVar.fsn.fsp, dbVar.fsn.ffG);
            if (cw == null || (cw.field_connStrategy & 16) != 0) {
                dbVar.fso.fsk = false;
            } else {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "CONNECT_STRATEGY_IGNORE_ON_CHAT disable, (%s) do not disconnect ble device(%s)", dbVar.fsn.fsp, dbVar.fsn.ffG);
                dbVar.fso.fsk = true;
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lQV = new com.tencent.mm.sdk.b.c<dz>() {
        {
            this.xmG = dz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return e.e((dz) bVar);
        }
    };
    public com.tencent.mm.sdk.b.c lQW = new com.tencent.mm.sdk.b.c<dq>() {
        {
            this.xmG = dq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleDeviceOPFromJSAPIEvent: %d", Integer.valueOf(((dq) bVar).fth.op));
            if (((dq) bVar).fth.op == 1) {
                d aEY = ad.aEY();
                if (aEY.lQm == null) {
                    aEY.lQm = new com.tencent.mm.plugin.exdevice.service.c();
                    aEY.lQm.lVO = new com.tencent.mm.plugin.exdevice.model.d.AnonymousClass11(0);
                    aEY.lQm.cy(ad.getContext());
                }
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lQX = new com.tencent.mm.sdk.b.c<de>() {
        {
            this.xmG = de.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return e.d((de) bVar);
        }
    };
    public com.tencent.mm.sdk.b.c lQY = new com.tencent.mm.sdk.b.c<ed>() {
        {
            this.xmG = ed.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ed edVar = (ed) bVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSetSendDataDirectionEvent: %s, %s, %s", edVar.ftG.ffG, Integer.valueOf(edVar.ftG.direction), Boolean.valueOf(edVar.ftG.clear));
            if (edVar.ftG.clear) {
                com.tencent.mm.plugin.exdevice.b.k.aEs().lPT.clear();
                edVar.ftH.fsk = true;
            } else if (bi.oN(edVar.ftG.ffG)) {
                edVar.ftH.fsk = false;
            } else {
                com.tencent.mm.plugin.exdevice.b.k aEs = com.tencent.mm.plugin.exdevice.b.k.aEs();
                String str = edVar.ftG.ffG;
                int i = edVar.ftG.direction;
                if (!bi.oN(str)) {
                    aEs.lPT.put(str, Integer.valueOf(i));
                }
                edVar.ftH.fsk = true;
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lQZ = new com.tencent.mm.sdk.b.c<ek>() {
        {
            this.xmG = ek.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ek ekVar = (ek) bVar;
            if (ekVar == null || !(ekVar instanceof ek)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTScanDeviceEvent");
                return false;
            }
            ekVar = ekVar;
            if (e.aEE()) {
                ekVar.ftT.fsk = true;
                return true;
            }
            ekVar.ftT.fsk = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRa = new com.tencent.mm.sdk.b.c<eg>() {
        {
            this.xmG = eg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            eg egVar = (eg) bVar;
            e eVar = e.this;
            if (egVar == null || !(egVar instanceof eg)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTConnectDeviceEvent");
                return false;
            }
            egVar = egVar;
            if (egVar.ftN.fsj ? eVar.zx(egVar.ftN.mac) : e.zw(egVar.ftN.mac)) {
                egVar.ftO.fsk = true;
                return true;
            }
            egVar.ftO.fsk = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRb = new com.tencent.mm.sdk.b.c<el>() {
        {
            this.xmG = el.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            el elVar = (el) bVar;
            e eVar = e.this;
            if (elVar == null || !(elVar instanceof el)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTSendDataToDeviceEvent");
                return false;
            }
            elVar = elVar;
            if (eVar.m(elVar.ftU.mac, elVar.ftU.data)) {
                elVar.ftV.fsk = true;
                return true;
            }
            elVar.ftV.fsk = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRc = new com.tencent.mm.sdk.b.c<ef>() {
        {
            this.xmG = ef.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ef efVar = (ef) bVar;
            if (efVar == null || !(efVar instanceof ef)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTBindDeviceEvent");
                return false;
            }
            efVar = efVar;
            if (ad.aER().cK(com.tencent.mm.plugin.exdevice.j.b.Aa(efVar.ftJ.mac)) != null) {
                x.d("MicroMsg.exdevice.ExdeviceEventManager", "device(" + efVar.ftJ.mac + ") has been binded");
                efVar.ftK.fsk = true;
            } else {
                boolean z;
                String str = efVar.ftJ.mac;
                String str2 = efVar.ftJ.ftL;
                long j = efVar.ftJ.ftM;
                if (bi.oN(str)) {
                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
                    z = false;
                } else {
                    String str3 = "MicroMsg.exdevice.ExdeviceEventManager";
                    String str4 = "handleExDeviceSimpleBTBindDevice. mac = %s, broadcastName = %s, profileType = %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = str;
                    objArr[1] = str2 == null ? "null" : str2;
                    objArr[2] = Long.valueOf(j);
                    x.d(str3, str4, objArr);
                    int Ks = as.CN().Ks();
                    if (Ks == 4 || Ks == 6) {
                        if (as.CN().a(new m(com.tencent.mm.plugin.exdevice.j.b.Aa(str), str2, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, j), 0)) {
                            z = true;
                        } else {
                            x.e("MicroMsg.exdevice.ExdeviceEventManager", "do NetSceneBindUnauthDevice fail");
                            z = false;
                        }
                    } else {
                        x.e("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, current state is %d", Integer.valueOf(Ks));
                        z = false;
                    }
                }
                if (z) {
                    efVar.ftK.fsk = true;
                } else {
                    efVar.ftK.fsk = false;
                }
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRd = new com.tencent.mm.sdk.b.c<em>() {
        {
            this.xmG = em.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            em emVar = (em) bVar;
            if (emVar == null || !(emVar instanceof em)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTUploadDataToServerEvent");
                return false;
            }
            emVar = emVar;
            if (e.b(emVar.ftW.mac, emVar.ftW.fsi, emVar.ftW.data)) {
                emVar.ftX.fsk = true;
                return true;
            }
            emVar.ftX.fsk = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRe = new com.tencent.mm.sdk.b.c<cy>() {
        {
            this.xmG = cy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.f.a.cy.b bVar2;
            com.tencent.mm.f.a.cy.b bVar3;
            boolean z;
            cy cyVar = (cy) bVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceIsBoundEvent: deviceType(%s), deviceId(%s)", cyVar.fsd.fsb, cyVar.fsd.ffG);
            if (cyVar.fsd.fsb == null || cyVar.fsd.ffG == null) {
                bVar2 = cyVar.fse;
            } else {
                com.tencent.mm.plugin.exdevice.h.b cv = ad.aER().cv(cyVar.fsd.ffG, cyVar.fsd.fsb);
                bVar2 = cyVar.fse;
                if (cv != null) {
                    bVar3 = bVar2;
                    z = true;
                    bVar3.fsf = z;
                    return true;
                }
            }
            bVar3 = bVar2;
            z = false;
            bVar3.fsf = z;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRf = new com.tencent.mm.sdk.b.c<cx>() {
        {
            this.xmG = cx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cx cxVar = (cx) bVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceHasAbilityEvent: deviceType(%s), deviceId(%s)", cxVar.frZ.fsb, cxVar.frZ.ffG);
            if (cxVar.frZ.fsb == null || cxVar.frZ.ffG == null) {
                cxVar.fsa.fsc = false;
            } else {
                br cw = ad.aER().cw(cxVar.frZ.fsb, cxVar.frZ.ffG);
                if (cw != null) {
                    String str = cw.ggR;
                    com.tencent.mm.f.a.cx.b bVar2 = cxVar.fsa;
                    ad.aER();
                    bVar2.fsc = com.tencent.mm.plugin.exdevice.h.c.zN(str);
                } else {
                    cxVar.fsa.fsc = false;
                }
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRg = new com.tencent.mm.sdk.b.c<dd>() {
        {
            this.xmG = dd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dd ddVar = (dd) bVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceGetCurrentSSIDEvent: opCode = %b", Boolean.valueOf(ddVar.fss.fsj));
            if (ddVar.fss.fsj) {
                String ssid = ao.getWifiInfo(ad.getContext()).getSSID();
                if (!bi.oN(ssid)) {
                    ddVar.fst.fsk = true;
                    ddVar.fst.fsu = ssid.replaceAll("\"", "");
                    return true;
                }
            }
            ddVar.fst.fsk = false;
            ddVar.fst.fsu = null;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRh = new com.tencent.mm.sdk.b.c<kw>() {
        {
            this.xmG = kw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((kw) bVar) == null) {
                x.w("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent, event is null.");
            } else {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent");
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lRi = new com.tencent.mm.sdk.b.c<ky>() {
        {
            this.xmG = ky.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "OnSubCoreInited, process : %s", ad.By());
            return !ad.cgm();
        }
    };
    public com.tencent.mm.sdk.b.c lRj = new com.tencent.mm.sdk.b.c<di>() {
        {
            this.xmG = di.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            di diVar = (di) bVar;
            long j = diVar.fsL.frh;
            String str = diVar.fsL.fsC;
            List<com.tencent.mm.plugin.exdevice.h.b> aFv = ad.aER().aFv();
            if (aFv.size() > 0) {
                boolean z;
                if (j == -1 || j == Long.MIN_VALUE) {
                    z = false;
                } else {
                    as.Hm();
                    cg dI = com.tencent.mm.y.c.Fh().dI(j);
                    if (dI.field_msgId == 0) {
                        z = false;
                    } else {
                        int type = dI.getType();
                        String str2 = dI.field_content;
                        String str3;
                        if (dI.aNJ()) {
                            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str2);
                            if (fV == null) {
                                x.e("MicroMsg.exdevice.ExdeviceEventManager", "get content is null");
                                z = false;
                            } else if (fV.type == 3) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar2 : aFv) {
                                    str3 = bVar2.ggR;
                                    if (str3 != null && str3.contains("wxmsg_music")) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            } else if (fV.type == 4) {
                                z = false;
                            } else if (fV.type == 6) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar22 : aFv) {
                                    str3 = bVar22.ggR;
                                    if (str3 != null && str3.contains("wxmsg_file")) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            } else if (fV.type == 5) {
                                z = e.e(fV.url, (List) aFv);
                            } else {
                                if (fV.type == 2) {
                                    for (com.tencent.mm.plugin.exdevice.h.b bVar222 : aFv) {
                                        str3 = bVar222.ggR;
                                        if (str3 != null && str3.contains("wxmsg_image")) {
                                            z = true;
                                            break;
                                        }
                                    }
                                    z = false;
                                }
                                z = false;
                            }
                        } else if (type == 3) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar2222 : aFv) {
                                str3 = bVar2222.ggR;
                                if (str3 != null && str3.contains("wxmsg_image")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else if (type == 48) {
                            for (com.tencent.mm.plugin.exdevice.h.b bVar22222 : aFv) {
                                str3 = bVar22222.ggR;
                                if (str3 != null && str3.contains("wxmsg_poi")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else {
                            if (type == 62) {
                                for (com.tencent.mm.plugin.exdevice.h.b bVar222222 : aFv) {
                                    str3 = bVar222222.ggR;
                                    if (str3 != null && str3.contains("wxmsg_video")) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            z = false;
                        }
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsMsgType = " + z + ", msgType = " + type);
                    }
                }
                if (z || e.f(str, aFv)) {
                    diVar.fsM.fsk = true;
                    return true;
                }
            }
            diVar.fsM.fsk = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRk = new com.tencent.mm.sdk.b.c<dg>() {
        {
            this.xmG = dg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dg dgVar = (dg) bVar;
            e eVar = e.this;
            dgVar = dgVar;
            eVar.lRv = new g();
            g gVar = eVar.lRv;
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "startScanWCLanDevice...");
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
            gVar.lRE = false;
            new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    int size = g.this.lRS.size();
                    int i = 0;
                    while (i < size) {
                        if (((b) g.this.lRS.get(i)).ggR.contains("internet_to_device") && ((b) g.this.lRS.get(i)).ggR.contains("wechat_to_device") && !g.this.lRT.contains(g.this.lRS.get(i))) {
                            g.this.lRT.add(g.this.lRS.get(i));
                            g.a(g.this, g.this.lRT);
                        }
                        i++;
                    }
                    return true;
                }
            }, false).K(3000, 3000);
            g gVar2 = eVar.lRv;
            long j = dgVar.fsA.frh;
            String str = dgVar.fsA.fsC;
            String str2 = dgVar.fsA.fsD;
            int i = dgVar.fsA.fsE;
            List arrayList = new ArrayList();
            gVar2.gBK = j;
            gVar2.lRH = str;
            gVar2.lRI = str2;
            gVar2.lRJ = i;
            int size = gVar2.lRT.size();
            for (int i2 = 0; i2 < size; i2++) {
                HashMap hashMap = new HashMap();
                hashMap.put("deviceType", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lRT.get(i2)).field_deviceType);
                hashMap.put("deviceID", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lRT.get(i2)).field_deviceID);
                hashMap.put("displayName", g.c((com.tencent.mm.plugin.exdevice.h.b) gVar2.lRT.get(i2)));
                hashMap.put("iconUrl", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lRT.get(i2)).iconUrl);
                hashMap.put("ability", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lRT.get(i2)).ggR);
                hashMap.put("abilityInf", ((com.tencent.mm.plugin.exdevice.h.b) gVar2.lRT.get(i2)).ggS);
                arrayList.add(hashMap);
            }
            if (arrayList.size() > 0) {
                dgVar.fsB.fsF = arrayList;
                dgVar.fsB.fsk = true;
            } else {
                dgVar.fsB.fsk = false;
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRl = new com.tencent.mm.sdk.b.c<eb>() {
        {
            this.xmG = eb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            eb ebVar = (eb) bVar;
            e eVar = e.this;
            ebVar = ebVar;
            if (bi.oN(ebVar.fty.fsb) || bi.oN(ebVar.fty.ffG)) {
                ebVar.ftz.ftC = false;
            } else {
                String str;
                Boolean valueOf;
                int i;
                com.tencent.mm.f.a.eb.b bVar2 = ebVar.ftz;
                g gVar = eVar.lRv;
                String str2 = ebVar.fty.fsb;
                String str3 = ebVar.fty.ffG;
                String str4 = ebVar.fty.ftA;
                long j = ebVar.fty.frh;
                String str5 = ebVar.fty.fsC;
                boolean z = ebVar.fty.ftB;
                gVar.gBK = j;
                gVar.lRF = false;
                gVar.lRG = z;
                x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "deviceType: %s, deviceId: %s", str2, str3);
                int i2 = 0;
                if (str4 == null || !str4.contains("wechat_to_device") || gVar.lRU.get(str3) == null) {
                    if (str4 != null && str4.contains("internet_to_device")) {
                        i2 = 1;
                        if (!z && (g.cq(j).booleanValue() || g.cp(j).booleanValue() || g.cs(j).booleanValue() || g.cr(j).booleanValue())) {
                            str4 = "MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice";
                            str5 = "mDeviceMsgForUseCdn %s deviceId %s deviceType %s";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(gVar.lRQ == null);
                            objArr[1] = str3;
                            objArr[2] = str2;
                            x.d(str4, str5, objArr);
                            if (gVar.lRQ != null) {
                                as.CN().a(new n(gVar.lRQ, str2, str3, 1), 0);
                            } else {
                                gVar.lRP.put(str3, str2);
                                if (!gVar.lRO) {
                                    Object obj;
                                    str4 = "";
                                    str = "";
                                    gVar.lRN = true;
                                    as.Hm();
                                    cg dI = com.tencent.mm.y.c.Fh().dI(j);
                                    Object[] objArr2;
                                    com.tencent.mm.modelcdntran.i iVar;
                                    if (g.cq(j).booleanValue()) {
                                        com.tencent.mm.ap.e n = o.PC().n(dI);
                                        str4 = o.PC().m(n.hBB, "", "");
                                        str = o.PC().m(n.hBD, "", "");
                                        gVar.gNA = n.hBA;
                                        if (bi.oN(gVar.hCY)) {
                                            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", Long.valueOf(dI.field_createTime), dI.field_talker, Long.valueOf(dI.field_msgId), Long.valueOf(gVar.gNA), Integer.valueOf(0));
                                            gVar.hCY = com.tencent.mm.modelcdntran.d.a("upimg", dI.field_createTime, dI.field_talker, dI.field_msgId + "_" + gVar.gNA + "_0");
                                        }
                                        com.tencent.mm.modelcdntran.g.MP();
                                        if (!com.tencent.mm.modelcdntran.c.hx(1) && bi.oN(n.hBL)) {
                                            objArr2 = new Object[2];
                                            com.tencent.mm.modelcdntran.g.MP();
                                            objArr2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hx(1));
                                            objArr2[1] = n.hBL;
                                            x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%s", objArr2);
                                            obj = null;
                                        }
                                        if (g.cq(j).booleanValue() || g.cr(j).booleanValue()) {
                                            gVar.lRR = new Random().nextLong();
                                            str4 = g.x(str4, gVar.lRR);
                                            str = g.x(str, gVar.lRR);
                                        }
                                        iVar = new com.tencent.mm.modelcdntran.i();
                                        iVar.hve = gVar.hDi;
                                        iVar.field_mediaId = gVar.hCY;
                                        iVar.field_fullpath = str4;
                                        iVar.field_thumbpath = str;
                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.htD;
                                        iVar.field_talker = dI.field_talker;
                                        iVar.field_priority = com.tencent.mm.modelcdntran.b.htt;
                                        iVar.field_needStorage = false;
                                        iVar.field_isStreamMedia = false;
                                        iVar.field_appType = 202;
                                        iVar.field_bzScene = 2;
                                        if (!g.cp(j).booleanValue()) {
                                            iVar.field_fileType = com.tencent.mm.modelcdntran.b.htD;
                                            iVar.field_appType = 202;
                                        } else if (g.cs(j).booleanValue()) {
                                            iVar.field_appType = 102;
                                            iVar.field_fileType = com.tencent.mm.modelcdntran.b.htz;
                                            iVar.field_bzScene = 1;
                                        }
                                        if (com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
                                            obj = 1;
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(111, 205, 1, false);
                                            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", gVar.hCY);
                                            gVar.hCY = "";
                                            obj = null;
                                        }
                                    } else if (g.cp(j).booleanValue() || g.cr(j).booleanValue()) {
                                        com.tencent.mm.pluginsdk.model.app.b Se = an.aqK().Se(com.tencent.mm.x.g.a.fV(dI.field_content).for);
                                        if (Se != null) {
                                            str4 = Se.field_fileFullPath;
                                            com.tencent.mm.modelcdntran.g.MP();
                                            if (com.tencent.mm.modelcdntran.c.hx(4) || Se.field_isUseCdn == 1) {
                                                if (!bi.oN(dI.field_imgPath)) {
                                                    str = o.PC().lp(dI.field_imgPath);
                                                }
                                                int bN = com.tencent.mm.a.e.bN(str);
                                                int bN2 = com.tencent.mm.a.e.bN(Se.field_fileFullPath);
                                                if (bN >= com.tencent.mm.modelcdntran.b.htQ) {
                                                    x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Integer.valueOf(bN));
                                                    obj = null;
                                                } else {
                                                    gVar.hCY = com.tencent.mm.modelcdntran.d.a("upattach", Se.field_createTime, dI.field_talker, new StringBuilder("0").toString());
                                                    if (bi.oN(gVar.hCY)) {
                                                        x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn compressType:%d", Integer.valueOf(0));
                                                        obj = null;
                                                    } else {
                                                        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra checkUseCdn id:%d file[%s][%d] thumb[%s][%d]", Long.valueOf(Se.field_msgInfoId), Se.field_fileFullPath, Integer.valueOf(bN2), str, Integer.valueOf(bN));
                                                        gVar.lRR = new Random().nextLong();
                                                        str4 = g.x(str4, gVar.lRR);
                                                        str = g.x(str, gVar.lRR);
                                                        iVar = new com.tencent.mm.modelcdntran.i();
                                                        iVar.hve = gVar.hDi;
                                                        iVar.field_mediaId = gVar.hCY;
                                                        iVar.field_fullpath = str4;
                                                        iVar.field_thumbpath = str;
                                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.htD;
                                                        iVar.field_talker = dI.field_talker;
                                                        iVar.field_priority = com.tencent.mm.modelcdntran.b.htt;
                                                        iVar.field_needStorage = false;
                                                        iVar.field_isStreamMedia = false;
                                                        iVar.field_appType = 202;
                                                        iVar.field_bzScene = 2;
                                                        if (!g.cp(j).booleanValue()) {
                                                            iVar.field_fileType = com.tencent.mm.modelcdntran.b.htD;
                                                            iVar.field_appType = 202;
                                                        } else if (g.cs(j).booleanValue()) {
                                                            iVar.field_appType = 102;
                                                            iVar.field_fileType = com.tencent.mm.modelcdntran.b.htz;
                                                            iVar.field_bzScene = 1;
                                                        }
                                                        if (com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
                                                            obj = 1;
                                                        } else {
                                                            com.tencent.mm.plugin.report.service.g.pWK.a(111, 205, 1, false);
                                                            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", gVar.hCY);
                                                            gVar.hCY = "";
                                                            obj = null;
                                                        }
                                                    }
                                                }
                                            } else {
                                                objArr2 = new Object[2];
                                                com.tencent.mm.modelcdntran.g.MP();
                                                objArr2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hx(4));
                                                objArr2[1] = Integer.valueOf(Se.field_isUseCdn);
                                                x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", objArr2);
                                                obj = null;
                                            }
                                        } else {
                                            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                                            obj = null;
                                        }
                                    } else {
                                        if (g.cs(j).booleanValue()) {
                                            r nv = com.tencent.mm.modelvideo.o.Ub().nv(dI.field_imgPath);
                                            if (nv == null) {
                                                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Get info Failed file:" + dI.field_imgPath);
                                                obj = null;
                                            } else {
                                                com.tencent.mm.modelcdntran.g.MP();
                                                if (com.tencent.mm.modelcdntran.c.hx(2) || nv.hXA == 1) {
                                                    gVar.hCY = com.tencent.mm.modelcdntran.d.a("upvideo", nv.hXs, nv.Uk(), nv.getFileName());
                                                    if (bi.oN(gVar.hCY)) {
                                                        x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn file:%s", nv.getFileName());
                                                        obj = null;
                                                    } else {
                                                        com.tencent.mm.modelvideo.o.Ub();
                                                        str = s.ny(dI.field_imgPath);
                                                        com.tencent.mm.modelvideo.o.Ub();
                                                        str4 = s.nx(dI.field_imgPath);
                                                    }
                                                } else {
                                                    r5 = new Object[2];
                                                    com.tencent.mm.modelcdntran.g.MP();
                                                    r5[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hx(2));
                                                    r5[1] = Integer.valueOf(nv.hXA);
                                                    x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", r5);
                                                    obj = null;
                                                }
                                            }
                                        }
                                        gVar.lRR = new Random().nextLong();
                                        str4 = g.x(str4, gVar.lRR);
                                        str = g.x(str, gVar.lRR);
                                        iVar = new com.tencent.mm.modelcdntran.i();
                                        iVar.hve = gVar.hDi;
                                        iVar.field_mediaId = gVar.hCY;
                                        iVar.field_fullpath = str4;
                                        iVar.field_thumbpath = str;
                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.htD;
                                        iVar.field_talker = dI.field_talker;
                                        iVar.field_priority = com.tencent.mm.modelcdntran.b.htt;
                                        iVar.field_needStorage = false;
                                        iVar.field_isStreamMedia = false;
                                        iVar.field_appType = 202;
                                        iVar.field_bzScene = 2;
                                        if (!g.cp(j).booleanValue()) {
                                            iVar.field_fileType = com.tencent.mm.modelcdntran.b.htD;
                                            iVar.field_appType = 202;
                                        } else if (g.cs(j).booleanValue()) {
                                            iVar.field_appType = 102;
                                            iVar.field_fileType = com.tencent.mm.modelcdntran.b.htz;
                                            iVar.field_bzScene = 1;
                                        }
                                        if (com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(111, 205, 1, false);
                                            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", gVar.hCY);
                                            gVar.hCY = "";
                                            obj = null;
                                        } else {
                                            obj = 1;
                                        }
                                    }
                                    if (obj == null) {
                                        g.ct(str3, gVar.lRL);
                                        gVar.lRO = false;
                                    } else {
                                        gVar.lRO = true;
                                    }
                                }
                            }
                            valueOf = Boolean.valueOf(true);
                            bVar2.ftC = valueOf.booleanValue();
                        }
                    }
                    i = i2;
                } else {
                    i = 0;
                }
                aky aky = new aky();
                are are;
                if (!z) {
                    gVar.a(aky, gVar.gBK);
                } else if (gVar.aEG().wYj.wfg != 1 || i != 0 || gVar.lRI != null) {
                    if (str5 != null) {
                        bpb aEG = gVar.aEG();
                        switch (aEG.wYj.wfg) {
                            case 1:
                                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns photo!");
                                int i3 = -1;
                                String str6 = null;
                                String str7 = null;
                                str = null;
                                String str8 = gVar.lRI;
                                if (str8 != null && str8.length() > 0) {
                                    File file = new File(str8);
                                    str7 = file.getName();
                                    i3 = (int) file.length();
                                    str = str7.substring(str7.lastIndexOf(".") + 1, str7.length());
                                    str6 = com.tencent.mm.a.g.i(file);
                                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "dataSnsInit filePath %s, fileSize %s, fileMd5 %s", str8, Integer.valueOf(i3), str6);
                                }
                                akz akz = new akz();
                                akz.whT = str;
                                akz.nkW = str7;
                                akz.kzt = i3;
                                akz.wgP = str6;
                                if (i == 1) {
                                    are = (are) aEG.wYj.wfh.get(gVar.lRJ);
                                    if (are == null) {
                                        x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                                        break;
                                    }
                                    akz.nlE = are.nlE;
                                    akz.wyW = are.wFg;
                                    if (!bi.oN(akz.wyW)) {
                                        akz.nlE += "?idx=" + are.wFf + "&token=" + are.wFe;
                                    }
                                }
                                aky.wyS = akz;
                                aky.wyP = 3;
                                break;
                            case 3:
                                are = (are) aEG.wYj.wfh.get(0);
                                if (are != null) {
                                    gVar.lRF = true;
                                    alc alc = new alc();
                                    alc.nlE = are.nlE;
                                    alc.fpg = are.fpg;
                                    alc.wyZ = are.nkL;
                                    aky.wyU = alc;
                                    aky.wyP = 5;
                                    break;
                                }
                                x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObUrl is null");
                                break;
                            case 4:
                                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns music!");
                                are = (are) aEG.wYj.wfh.get(0);
                                if (are != null) {
                                    gVar.lRF = true;
                                    alb alb = new alb();
                                    alb.fpg = are.fpg;
                                    alb.wyZ = are.nkL;
                                    alb.nlE = aEG.wYj.nlE;
                                    alb.wdh = are.nlE;
                                    alb.wzb = are.wET;
                                    alb.noG = aEG.wYi.noG;
                                    aky.wyQ = alb;
                                    aky.wyP = 1;
                                    break;
                                }
                                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObj is null");
                                break;
                            case 15:
                                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns sight!");
                                are = (are) aEG.wYj.wfh.get(0);
                                if (are != null) {
                                    gVar.lRF = true;
                                    ald ald = new ald();
                                    ald.nlE = are.nlE;
                                    x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "videoMsg.url = %s", ald.nlE);
                                    aky.wyV = ald;
                                    aky.wyP = 6;
                                    break;
                                }
                                x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjSight is null");
                                break;
                        }
                    }
                } else {
                    gVar.lSc = aky;
                    gVar.lSd = str2;
                    gVar.lSe = str3;
                    gVar.lSf = 0;
                    are = (are) gVar.aEG().wYj.wfh.get(gVar.lRJ);
                    if (are == null) {
                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                        g.ct(str3, gVar.lRL);
                    } else {
                        gVar.fAO = are.nlE;
                        com.tencent.mm.sdk.f.e.post(gVar.lSb, "ExdeviceDownloadImage");
                    }
                    valueOf = Boolean.valueOf(true);
                    bVar2.ftC = valueOf.booleanValue();
                }
                as.CN().a(new n(aky, str2, str3, i), 0);
                valueOf = Boolean.valueOf(true);
                bVar2.ftC = valueOf.booleanValue();
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRm = new com.tencent.mm.sdk.b.c<eo>() {
        {
            this.xmG = eo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            eo eoVar = (eo) bVar;
            com.tencent.mm.ad.e eVar = e.this.lRv;
            if (!eVar.lRE) {
                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "stopScanNetworkDevice...");
                Java2CExDevice.stopScanWCLanDevice();
                eVar.lRE = true;
            }
            as.Dt().F(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "releaseWCLanDeviceLib...");
                    Java2CExDevice.releaseWCLanDeviceLib();
                }
            });
            as.CN().b(1717, eVar);
            j.aEI().b(14, eVar.lRX);
            j.aEI().b(12, eVar.lRY);
            j.aEI().b(13, eVar.lRZ);
            j.aEI().b(15, eVar.lSa);
            eoVar.ftZ.ftC = true;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRn = new com.tencent.mm.sdk.b.c<ee>() {
        {
            this.xmG = ee.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ee eeVar = (ee) bVar;
            if (ad.aER().aFw().size() > 0) {
                eeVar.ftI.fsk = true;
            } else {
                eeVar.ftI.fsk = false;
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRo = new com.tencent.mm.sdk.b.c<cv>() {
        {
            this.xmG = cv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cv cvVar = (cv) bVar;
            e eVar = e.this;
            String str = cvVar.frX.ffG;
            g gVar = eVar.lRv;
            gVar.lRP.remove(str);
            if (gVar.lRV.get(str) != null) {
                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cancelWCLanDeviceTask cmdId: " + gVar.lRV.get(str));
                Java2CExDevice.cancelWCLanDeviceTask(((Integer) gVar.lRV.get(str)).intValue());
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRp = new com.tencent.mm.sdk.b.c<dw>() {
        {
            this.xmG = dw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dw dwVar = (dw) bVar;
            e eVar = e.this;
            dwVar = dwVar;
            if (eVar.lRu == null) {
                eVar.lRu = new ExdeviceWCLanSDKUtil();
            }
            ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil = eVar.lRu;
            if (dwVar.fto.fsj) {
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "initWCLanDeviceLib...");
                Java2CExDevice.initWCLanDeviceLib();
                j.aEI().a(14, exdeviceWCLanSDKUtil.lRX);
                j.aEI().a(10, exdeviceWCLanSDKUtil.lSp);
                j.aEI().a(13, exdeviceWCLanSDKUtil.lRZ);
                j.aEI().a(16, exdeviceWCLanSDKUtil.lSq);
            } else {
                as.Dt().F(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "releaseWCLanDeviceLib...");
                        Java2CExDevice.releaseWCLanDeviceLib();
                    }
                });
                x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "unregisterReceiver...");
                if (exdeviceWCLanSDKUtil.jle != null) {
                    exdeviceWCLanSDKUtil.mContext.unregisterReceiver(exdeviceWCLanSDKUtil.jle);
                    exdeviceWCLanSDKUtil.jle = null;
                }
                j.aEI().b(14, exdeviceWCLanSDKUtil.lRX);
                j.aEI().b(10, exdeviceWCLanSDKUtil.lSp);
                j.aEI().b(13, exdeviceWCLanSDKUtil.lRZ);
                j.aEI().b(16, exdeviceWCLanSDKUtil.lSq);
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRq = new com.tencent.mm.sdk.b.c<en>() {
        {
            this.xmG = en.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((en) bVar).ftY.fsj) {
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "startScanWCLanDevice...");
                Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
            } else {
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "stopScanWCLanDevice...");
                Java2CExDevice.stopScanWCLanDevice();
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lRr = new com.tencent.mm.sdk.b.c<da>() {
        {
            this.xmG = da.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            da daVar = (da) bVar;
            e eVar = e.this;
            daVar = daVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceConnectLanDeviceEvent: brandName=%s, deviceId=%s, type=%b", daVar.fsl.fsi, daVar.fsl.ffG, Boolean.valueOf(daVar.fsl.fsj));
            if (e.zv(daVar.fsl.fsi)) {
                com.tencent.mm.plugin.exdevice.h.b zM = ad.aER().zM(daVar.fsl.ffG);
                if (zM == null) {
                    daVar.fsm.fsk = false;
                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", daVar.fsl.ffG);
                    return false;
                } else if (zM.field_brandName.equals(daVar.fsl.fsi)) {
                    boolean ae = eVar.lRu.ae(daVar.fsl.ffG, daVar.fsl.fsj);
                    daVar.fsm.fsk = ae;
                    return ae;
                } else {
                    daVar.fsm.fsk = false;
                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", zM.field_brandName, daVar.fsl.fsi);
                    return false;
                }
            }
            daVar.fsm.fsk = false;
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lRs = new com.tencent.mm.sdk.b.c<ea>() {
        {
            this.xmG = ea.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ea eaVar = (ea) bVar;
            e eVar = e.this;
            eaVar = eaVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceSendDataToLanDeviceEvent: brandName=%s, deviceId=%s", eaVar.ftw.fsi, eaVar.ftw.ffG);
            if (!e.zv(eaVar.ftw.fsi) || bi.oN(eaVar.ftw.data)) {
                eaVar.ftx.fsk = false;
                return false;
            } else if (ad.aER().zM(eaVar.ftw.ffG) == null) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                eaVar.ftx.fsk = false;
                return false;
            } else {
                eaVar.ftx.fsk = eVar.lRu.cu(eaVar.ftw.ffG, eaVar.ftw.data);
                return true;
            }
        }
    };
    public com.tencent.mm.sdk.b.c lRt = new com.tencent.mm.sdk.b.c<df>() {
        {
            this.xmG = df.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return e.this.c((df) bVar);
        }
    };
    ExdeviceWCLanSDKUtil lRu;
    g lRv;
    private final long lRw = 300000;
    private boolean lRx = false;
    private c lRy;
    ag mHandler;

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$39 */
    class AnonymousClass39 implements com.tencent.mm.plugin.exdevice.model.i.a {
        final /* synthetic */ dv lRB;

        AnonymousClass39(dv dvVar) {
            this.lRB = dvVar;
        }

        public final void eL(boolean z) {
            if (z) {
                e.this.ab(this.lRB.ftn.op, this.lRB.ftn.userName);
            }
        }
    }

    private class c implements Runnable {
        List<com.tencent.mm.plugin.exdevice.h.b> hkg;

        public c(List<com.tencent.mm.plugin.exdevice.h.b> list) {
            this.hkg = list;
        }

        public final void run() {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
            if (this.hkg != null && this.hkg.size() > 0) {
                for (com.tencent.mm.plugin.exdevice.h.b bVar : this.hkg) {
                    u.aFt().a(new com.tencent.mm.plugin.exdevice.i.k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, 1));
                }
                e.this.mHandler.postDelayed(this, 300000);
            }
        }
    }

    public interface b {
        void b(String str, byte[] bArr, boolean z);

        void c(String str, int i, long j);

        void k(String str, String str2, boolean z);
    }

    public class a implements b {
        private String bpq;
        private String lRC;
        private String lRD;
        private String mURL;

        public a(String str, String str2, String str3, String str4) {
            this.lRC = str;
            this.bpq = str2;
            this.mURL = str3;
            this.lRD = str4;
            x.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", str, str2);
        }

        public final void k(String str, String str2, boolean z) {
            if (this.bpq == null || !this.bpq.equals(str2)) {
                x.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", this.bpq, str2, Boolean.valueOf(z));
            }
        }

        public final void b(String str, byte[] bArr, boolean z) {
            if (this.bpq == null || !this.bpq.equals(str)) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", this.bpq, str, Boolean.valueOf(z));
            } else if (z && bArr != null) {
                try {
                    ad.aFc();
                    if (!e.b(this.bpq, this.lRC, bArr)) {
                        x.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
                }
            }
        }

        public final void c(String str, int i, long j) {
            if (this.bpq == null || !this.bpq.equals(str)) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", this.bpq, str, Integer.valueOf(i), Long.valueOf(j));
                return;
            }
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", str, Integer.valueOf(i), Long.valueOf(j));
            switch (i) {
                case 0:
                    e.e(this.lRC, this.mURL, 0, this.lRD);
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", str);
                    return;
                case 1:
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", str);
                    e.e(this.lRC, this.mURL, 1, this.lRD);
                    return;
                case 2:
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", str);
                    e.e(this.lRC, this.mURL, 2, this.lRD);
                    com.tencent.mm.plugin.g.a.b.a.f fVar = new com.tencent.mm.plugin.g.a.b.a.f();
                    fVar.kEc = com.tencent.mm.plugin.g.a.b.a.f.kFh;
                    fVar.kEd = 2;
                    ad.aFc().m(this.bpq, com.tencent.mm.plugin.exdevice.j.b.bq(fVar));
                    return;
                case 4:
                    e.e(this.lRC, this.mURL, 4, this.lRD);
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", str);
                    return;
                default:
                    x.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", str, Integer.valueOf(i), Long.valueOf(j));
                    e.e(this.lRC, this.mURL, -1, this.lRD);
                    return;
            }
        }
    }

    public e() {
        HandlerThread WL = com.tencent.mm.sdk.f.e.WL("wifi_device_heart_beat");
        WL.start();
        this.mHandler = new ag(WL.getLooper());
    }

    final boolean c(com.tencent.mm.sdk.b.b bVar) {
        df dfVar = (df) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", dfVar.fsy.fsi, dfVar.fsy.context);
        if (zv(dfVar.fsy.fsi)) {
            LinkedList zO = ad.aER().zO(dfVar.fsy.fsi);
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator it = zO.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                    if (!zO.isEmpty() && bi.oM(bVar2.field_connProto).contains("4")) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("deviceId", bVar2.field_deviceID);
                        if (this.lRu.zz(bVar2.field_deviceID)) {
                            jSONObject.put("state", "connected");
                        } else {
                            jSONObject.put("state", "disconnected");
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", e.getMessage());
            }
            dfVar.fsz.fsx = jSONArray;
            dfVar.fsz.fsk = true;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", jSONArray.toString());
        } else {
            dfVar.fsz.fsx = null;
            dfVar.fsz.fsk = false;
        }
        return true;
    }

    static boolean e(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        String host = Uri.parse(str).getHost();
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
        JSONArray jSONArray = null;
        boolean z = false;
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            boolean z2;
            String str2 = bVar.ggR;
            String str3 = bVar.ggS;
            if (str3 == null || str3.length() <= 0 || str2 == null || !str2.contains("wxmsg_url")) {
                z2 = z;
            } else {
                JSONArray jSONArray2;
                boolean z3;
                try {
                    jSONArray2 = new JSONObject(str3).getJSONArray("wxmsg_url");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e, "", new Object[0]);
                    jSONArray2 = jSONArray;
                }
                int length = jSONArray2.length();
                int i = 0;
                while (i < length) {
                    try {
                        if (jSONArray2.getString(i).equals(host)) {
                            z3 = true;
                            break;
                        }
                        i++;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e2, "", new Object[0]);
                    }
                }
                z3 = z;
                if (z3) {
                    return z3;
                }
                JSONArray jSONArray3 = jSONArray2;
                z2 = z3;
                jSONArray = jSONArray3;
            }
            z = z2;
        }
        return z;
    }

    static boolean f(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        if (str == null) {
            return false;
        }
        boolean z;
        com.tencent.mm.sdk.b.b huVar = new hu();
        huVar.fyW.fsC = str;
        com.tencent.mm.sdk.b.a.xmy.m(huVar);
        bpb bpb = huVar.fyX.fyY;
        int i = bpb.wYj.wfg;
        String str2;
        if (i == 1) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
                str2 = bVar.ggR;
                if (str2 != null && str2.contains("wxmsg_image")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 4) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar2 : list) {
                str2 = bVar2.ggR;
                if (str2 != null && str2.contains("wxmsg_music")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 15) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : list) {
                str2 = bVar22.ggR;
                if (str2 != null && str2.contains("wxmsg_video")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = i == 3 ? e(bpb.wYj.nlE, (List) list) : false;
        }
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + z + ", snsLocalId = " + str);
        return z;
    }

    static boolean d(com.tencent.mm.sdk.b.b bVar) {
        de deVar = (de) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", deVar.fsv.fsi, deVar.fsv.context);
        LinkedList zO = ad.aER().zO(deVar.fsv.fsi);
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = zO.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                if (!zO.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceId", bVar2.field_deviceID);
                    if (u.aFs().cy(bVar2.field_mac)) {
                        jSONObject.put("state", "connected");
                    } else {
                        jSONObject.put("state", "disconnected");
                    }
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", e.getMessage());
        }
        deVar.fsw.fsx = jSONArray;
        deVar.fsw.fsk = true;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", jSONArray.toString());
        return true;
    }

    static boolean e(com.tencent.mm.sdk.b.b bVar) {
        dz dzVar = (dz) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", dzVar.ftu.fsi, dzVar.ftu.ffG);
        if (bi.by(dzVar.ftu.data)) {
            dzVar.ftv.fsk = false;
            return false;
        }
        com.tencent.mm.plugin.exdevice.h.b zM = ad.aER().zM(dzVar.ftu.ffG);
        if (zM == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
            dzVar.ftv.fsk = false;
            return false;
        } else if (!u.aFs().cy(zM.field_mac)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
            dzVar.ftv.fsk = false;
            return false;
        } else if (u.aFs().cE(zM.field_mac)) {
            if (aa.aEO().lSi) {
                aa.aEO().pt(a(zM));
            }
            u.aFt().a(new com.tencent.mm.plugin.exdevice.i.g(dzVar.ftu.data, 10001, zM.field_mac));
            dzVar.ftv.fsk = true;
            return true;
        } else {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
            dzVar.ftv.fsk = false;
            return false;
        }
    }

    static int a(com.tencent.mm.plugin.exdevice.h.b bVar) {
        if (bi.oM(bVar.field_connProto).contains("1")) {
            return 1;
        }
        if (bi.oM(bVar.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            return 0;
        }
        return -1;
    }

    final boolean f(com.tencent.mm.sdk.b.b bVar) {
        final dh dhVar = (dh) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", dhVar.fsG.fsi, dhVar.fsG.ffG, Integer.valueOf(dhVar.fsG.type));
        adc adc = new adc();
        adc.wsu = dhVar.fsG.type;
        adc.wsv = 0;
        adc.vSq = new ake();
        adc.vSq.kyJ = dhVar.fsG.ffG;
        adc.vSq.vQr = dhVar.fsG.fsi;
        LinkedList linkedList = new LinkedList();
        linkedList.add(adc);
        com.tencent.mm.ad.e anonymousClass36 = new com.tencent.mm.ad.e() {
            public final void a(int i, int i2, String str, k kVar) {
                if (kVar == null || kVar.getType() != 543) {
                    dhVar.fsH.fsJ = true;
                    dhVar.fsH.fsK = null;
                    if (dhVar.frD != null) {
                        dhVar.frD.run();
                        return;
                    }
                    return;
                }
                as.CN().b(543, (com.tencent.mm.ad.e) this);
                if (i == 0 && i2 == 0) {
                    ade ade;
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                    z zVar = (z) kVar;
                    if (zVar.lSH == null || zVar.lSH.hnR.hnY == null) {
                        ade = null;
                    } else {
                        ade = (ade) zVar.lSH.hnR.hnY;
                    }
                    Iterator it = ade.wsy.iterator();
                    Object obj = null;
                    while (it.hasNext()) {
                        adf adf = (adf) it.next();
                        if (adf != null) {
                            String str2 = null;
                            String str3 = null;
                            if (adf.vSq != null) {
                                str2 = adf.vSq.kyJ;
                                str3 = adf.vSq.vQr;
                            }
                            if (adf.vQL != 0 || bi.oN(adf.wgO)) {
                                x.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", str2, Integer.valueOf(adf.vQL), adf.wgO);
                            } else {
                                Object obj2;
                                x.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", str2, str3, adf.wgO, Integer.valueOf(adf.wsu));
                                dhVar.fsH.fsJ = true;
                                dhVar.fsH.fsK = adf.wgO;
                                if (dhVar.frD != null) {
                                    dhVar.frD.run();
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                obj = obj2;
                            }
                        }
                    }
                    if (obj == null) {
                        dhVar.fsH.fsJ = true;
                        dhVar.fsH.fsK = null;
                        if (dhVar.frD != null) {
                            dhVar.frD.run();
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                dhVar.fsH.fsJ = true;
                dhVar.fsH.fsK = null;
                if (dhVar.frD != null) {
                    dhVar.frD.run();
                }
            }
        };
        k zVar = new z(linkedList, dhVar.fsG.fsi, dhVar.fsG.fsI);
        as.CN().a(543, anonymousClass36);
        if (as.CN().a(zVar, 0)) {
            return false;
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
        as.CN().b(543, anonymousClass36);
        dhVar.fsH.fsJ = true;
        dhVar.fsH.fsK = null;
        if (dhVar.frD == null) {
            return true;
        }
        dhVar.frD.run();
        return true;
    }

    final boolean g(com.tencent.mm.sdk.b.b bVar) {
        dx dxVar = (dx) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", dxVar.ftp.fsi, Boolean.valueOf(dxVar.ftp.fsj), Integer.valueOf(dxVar.ftp.ftr));
        int i = dxVar.ftp.ftr;
        if (!(i == 0 || i == 1)) {
            if (com.tencent.mm.plugin.g.a.e.a.cp(ad.getContext())) {
                x.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", Integer.valueOf(i));
                i = 0;
            } else {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", Integer.valueOf(i));
                dxVar.ftq.fsk = false;
                return false;
            }
        }
        if (dxVar.ftp.fsj) {
            j aEO = aa.aEO();
            String str = dxVar.ftp.fsi;
            com.tencent.mm.plugin.exdevice.model.aa.a anonymousClass37 = new com.tencent.mm.plugin.exdevice.model.aa.a() {
                public final void a(String str, byte[] bArr, boolean z) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", str);
                    if (bArr == null) {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", str, Boolean.valueOf(z));
                    } else {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", str, Base64.encodeToString(bArr, 0), Boolean.valueOf(z));
                    }
                    com.tencent.mm.sdk.b.b duVar = new du();
                    duVar.ftm.fte = bArr;
                    duVar.ftm.ffG = str;
                    duVar.ftm.aow = z;
                    com.tencent.mm.sdk.b.a.xmy.a(duVar, Looper.getMainLooper());
                }
            };
            x.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", str);
            if (bi.oN(str)) {
                x.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
            } else {
                aEO.lRC = str;
                aEO.lSW = anonymousClass37;
                aEO.lSX.clear();
                Iterator it = aEO.lSY.iterator();
                while (it.hasNext()) {
                    k kVar = (k) it.next();
                    if (kVar != null) {
                        as.CN().c(kVar);
                    }
                }
                aEO.lSY.clear();
                synchronized (aa.hrp) {
                    aa.lSZ.clear();
                }
                if (aEO.lSi) {
                    x.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
                } else {
                    aEO.lSi = true;
                    as.CN().a(542, (com.tencent.mm.ad.e) aEO);
                    ad.aEY().a(i, aEO);
                    x.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
                    aEO.jcp.K(12000, 12000);
                }
            }
        } else {
            aa.aEO().pt(i);
        }
        dxVar.ftq.fsk = true;
        return true;
    }

    static boolean zv(String str) {
        d jV = f.jV(str);
        if (jV == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            return false;
        }
        com.tencent.mm.af.d.b bK = jV.bK(false);
        if (bK != null && bK.LE() != null && bK.LE().LN()) {
            return true;
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        return false;
    }

    final boolean a(com.tencent.mm.plugin.exdevice.h.b bVar, int i, int i2) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
        if (bVar == null) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
            return false;
        }
        String str = bVar.field_brandName;
        com.tencent.mm.plugin.exdevice.service.f.a cA = u.aFs().cA(bVar.field_mac);
        if (cA == null) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            return false;
        }
        if (cA.ftb == 2) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", str);
            u.aFt().a(new com.tencent.mm.plugin.exdevice.i.j(i, i2, bVar.field_mac));
        }
        ad.aEY().ps(i == 1 ? 1 : 0);
        if (i == 2) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
            al alVar = (al) ad.aEY().lQo.remove(Long.valueOf(bVar.field_mac));
            if (alVar != null) {
                alVar.TN();
            }
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", Integer.valueOf(bVar.field_closeStrategy));
            if (!((bVar.field_closeStrategy & 1) == 0 && u.aFs().cE(cA.lVU) && (2 == cA.ftb || cA.ftb == 0))) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", Integer.valueOf(cA.ftb), str);
                if (u.aFt().lQh != null) {
                    u.aFt().lQh.cG(cA.lVU);
                }
            }
            if (f.b(bVar)) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", Long.valueOf(bVar.field_mac));
                zw(com.tencent.mm.plugin.exdevice.j.b.cL(bVar.field_mac));
            }
            return true;
        } else if (2 == cA.ftb || aa.vjm == null || !aa.vjm.bPl()) {
            return true;
        } else {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
            return false;
        }
    }

    final boolean e(List<com.tencent.mm.plugin.exdevice.h.b> list, int i) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
        if (list.size() == 0) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
            return false;
        }
        int i2 = -1;
        switch (i) {
            case 1:
                if (this.lRx) {
                    this.mHandler.removeCallbacks(this.lRy);
                }
                this.lRy = new c(list);
                this.mHandler.postDelayed(this.lRy, 300000);
                this.lRx = true;
                i2 = 2;
                break;
            case 2:
                if (this.lRx) {
                    this.mHandler.removeCallbacks(this.lRy);
                    this.lRx = false;
                }
                i2 = 0;
                break;
        }
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            u.aFt().a(new com.tencent.mm.plugin.exdevice.i.k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, i2));
        }
        return true;
    }

    static boolean aEB() {
        LinkedList aFx = ad.aER().aFx();
        if (aFx.isEmpty()) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
            return false;
        }
        ad.aEY().ps(2);
        Iterator it = aFx.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.h.b bVar = (com.tencent.mm.plugin.exdevice.h.b) it.next();
            as.Hm();
            com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(bVar.field_brandName);
            if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", bVar.field_brandName);
            } else if ((bVar.field_connStrategy & 4) == 0) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", Integer.valueOf(bVar.field_connStrategy));
            } else {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", bVar.field_brandName);
                ad.aEY().a(bVar.field_brandName, bVar.field_mac, 0, true);
            }
        }
        return true;
    }

    static boolean aEC() {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
        ad.aEY();
        d.eK(false);
        ad.aEY().aEA();
        return true;
    }

    final boolean ab(int i, String str) {
        x.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
        d jV = f.jV(str);
        if (jV == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            return false;
        }
        com.tencent.mm.af.d.b bK = jV.bK(false);
        if (bK != null) {
            com.tencent.mm.af.d.b.b LE = bK.LE();
            if (LE != null && LE.LN()) {
                List<com.tencent.mm.plugin.exdevice.h.b> zO = ad.aER().zO(str);
                if (LE.hqM == 1) {
                    List<com.tencent.mm.plugin.exdevice.h.b> aFx = ad.aER().aFx();
                    if (aFx.size() != 0) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar : aFx) {
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", Long.valueOf(bVar.field_mac), bVar.field_deviceID, bVar.field_deviceType, Long.valueOf(bVar.ggQ));
                            if (0 != (bVar.ggQ & 1)) {
                                zO.add(bVar);
                            }
                        }
                    }
                }
                if (zO == null) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
                    return false;
                } else if (zO.size() == 0) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
                    return true;
                } else {
                    int i2 = 0;
                    int i3 = 0;
                    for (com.tencent.mm.plugin.exdevice.h.b bVar2 : zO) {
                        if (bVar2 == null) {
                            x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                        } else if (bi.oM(bVar2.field_connProto).contains("4")) {
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", bVar2.field_brandName);
                        } else if ((bVar2.field_connStrategy & 16) != 0) {
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", bVar2.field_brandName, Integer.valueOf(bVar2.field_connStrategy));
                        } else {
                            int i4;
                            int i5;
                            int i6;
                            if (bi.oM(bVar2.field_connProto).contains("1")) {
                                i6 = i2 + 1;
                                if (com.tencent.mm.plugin.g.a.e.a.asa()) {
                                    i4 = i3;
                                    i5 = i6;
                                    i3 = 1;
                                } else {
                                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", bVar2.field_brandName);
                                    i2 = i6;
                                }
                            } else if (bi.oM(bVar2.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                i6 = i3 + 1;
                                if (com.tencent.mm.plugin.g.a.e.a.cp(ad.getContext())) {
                                    i3 = 0;
                                    i4 = i6;
                                    i5 = i2;
                                } else {
                                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                                    i3 = i6;
                                }
                            } else {
                                i4 = i3;
                                i5 = i2;
                                i3 = -1;
                            }
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", Integer.valueOf(i), bVar2.field_brandName, bVar2.field_connProto);
                            if (i == 0) {
                                d aEY = ad.aEY();
                                long j = bVar2.field_mac;
                                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", Long.valueOf(j));
                                if (aEY.lQp.containsKey(Long.valueOf(j))) {
                                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
                                    al alVar = (al) aEY.lQp.remove(Long.valueOf(j));
                                    if (alVar != null) {
                                        alVar.TN();
                                    } else {
                                        x.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", Long.valueOf(j));
                                    }
                                }
                                if (u.aFs().cy(bVar2.field_mac)) {
                                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", bVar2.field_brandName, Long.valueOf(bVar2.field_mac));
                                    if (u.aFs().cE(bVar2.field_mac)) {
                                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
                                        e(bVar2.field_brandName, bVar2.field_url, 2, bVar2.field_deviceID);
                                        i3 = i4;
                                        i2 = i5;
                                    } else {
                                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
                                        i3 = i4;
                                        i2 = i5;
                                    }
                                } else if (!com.tencent.mm.plugin.exdevice.service.d.cz(ad.getContext())) {
                                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
                                    i3 = i4;
                                    i2 = i5;
                                } else if (f.b(bVar2)) {
                                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", com.tencent.mm.plugin.exdevice.j.b.cL(bVar2.field_mac), bVar2.field_brandName);
                                    a(bVar2.field_brandName + bVar2.field_mac, new a(bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.cL(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                    zx(com.tencent.mm.plugin.exdevice.j.b.cL(bVar2.field_mac));
                                    i3 = i4;
                                    i2 = i5;
                                } else {
                                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", com.tencent.mm.plugin.exdevice.j.b.cL(bVar2.field_mac), bVar2.field_brandName);
                                    ad.aEY().ps(1);
                                    ad.aEY().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                    ad.aEY().a(bVar2.field_brandName, bVar2.field_mac, i3);
                                    i3 = i4;
                                    i2 = i5;
                                }
                            } else if (i != 1) {
                                if (i == 2) {
                                    if (f.b(bVar2)) {
                                        zw(com.tencent.mm.plugin.exdevice.j.b.cL(bVar2.field_mac));
                                        i3 = i4;
                                        i2 = i5;
                                    } else {
                                        ad.aEY();
                                        d.co(bVar2.field_mac);
                                    }
                                }
                                i3 = i4;
                                i2 = i5;
                            } else if (f.b(bVar2)) {
                                a(bVar2.field_brandName + bVar2.field_mac, new a(bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.cL(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                zx(com.tencent.mm.plugin.exdevice.j.b.cL(bVar2.field_mac));
                                i3 = i4;
                                i2 = i5;
                            } else {
                                ad.aEY().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                ad.aEY().a(bVar2.field_brandName, bVar2.field_mac, i3);
                                i3 = i4;
                                i2 = i5;
                            }
                        }
                    }
                    if (i2 + i3 <= 0) {
                        bi(str, -1);
                    } else if (!com.tencent.mm.plugin.g.a.e.a.asc()) {
                        x.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                        bi(str, 0);
                    } else if (i3 > 0 && i2 == 0 && !com.tencent.mm.plugin.g.a.e.a.cp(ad.getContext())) {
                        bi(str, 1);
                    }
                    return true;
                }
            }
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        return false;
    }

    private static boolean aED() {
        if (!com.tencent.mm.plugin.g.a.e.a.cp(ad.getContext())) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
            return false;
        } else if (com.tencent.mm.plugin.g.a.e.a.asc()) {
            return true;
        } else {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
            return false;
        }
    }

    public static boolean aEE() {
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
        if (aED()) {
            ad.aFd().aEH();
            return true;
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
        return false;
    }

    public static boolean zw(String str) {
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", str);
        if (!aED()) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            return false;
        } else if (bi.oN(str)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            return false;
        } else {
            ad.aFd();
            h.co(com.tencent.mm.plugin.exdevice.j.b.Aa(str));
            return true;
        }
    }

    public final boolean zx(String str) {
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
        if (!aED()) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            return false;
        } else if (bi.oN(str)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            return false;
        } else {
            ad.aFd().a(com.tencent.mm.plugin.exdevice.j.b.Aa(str), new com.tencent.mm.plugin.exdevice.model.h.a() {
                public final void a(long j, int i, int i2, int i3, long j2) {
                    List<b> linkedList;
                    x.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
                    e eVar = e.this;
                    String cL = com.tencent.mm.plugin.exdevice.j.b.cL(j);
                    synchronized (eVar.lQF) {
                        linkedList = new LinkedList(eVar.lQF);
                    }
                    for (b c : linkedList) {
                        c.c(cL, i2, j2);
                    }
                    linkedList.clear();
                    for (b c2 : eVar.lQG.values()) {
                        c2.c(cL, i2, j2);
                    }
                    com.tencent.mm.sdk.b.b ehVar = new eh();
                    ehVar.ftP.mac = cL;
                    ehVar.ftP.ftb = i2;
                    ehVar.ftP.ftM = j2;
                    com.tencent.mm.sdk.b.a.xmy.a(ehVar, Looper.getMainLooper());
                }
            });
            return true;
        }
    }

    public final boolean m(String str, byte[] bArr) {
        String str2;
        String str3;
        Object[] objArr;
        if (bi.oN(str) || bi.by(bArr)) {
            String str4;
            int i;
            str2 = "MicroMsg.exdevice.ExdeviceEventManager";
            str3 = "input error. mac = %s, dataLen = %d";
            objArr = new Object[2];
            if (bi.oN(str)) {
                str4 = "null";
            } else {
                str4 = "mac";
            }
            objArr[0] = str4;
            if (bi.by(bArr)) {
                i = 0;
            } else {
                i = bArr.length;
            }
            objArr[1] = Integer.valueOf(i);
            x.e(str2, str3, objArr);
            return false;
        }
        str2 = "MicroMsg.exdevice.ExdeviceEventManager";
        str3 = "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d";
        objArr = new Object[2];
        objArr[0] = bi.oN(str) ? "null" : str;
        objArr[1] = Integer.valueOf(bi.by(bArr) ? 0 : bArr.length);
        x.e(str2, str3, objArr);
        long Aa = com.tencent.mm.plugin.exdevice.j.b.Aa(str);
        com.tencent.mm.plugin.exdevice.service.f.a cB = ad.aFd().lSj.cB(Aa);
        if (cB == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            return false;
        } else if (cB.ftb != 2) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
            return false;
        } else {
            ad.aFd();
            return h.a(Aa, bArr, new com.tencent.mm.plugin.exdevice.service.t.a() {
                public final void b(long j, int i, int i2, String str) {
                    String str2 = "MicroMsg.exdevice.ExdeviceEventManager";
                    String str3 = "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s";
                    Object[] objArr = new Object[4];
                    objArr[0] = Long.valueOf(j);
                    objArr[1] = Integer.valueOf(i);
                    objArr[2] = Integer.valueOf(i2);
                    if (str == null) {
                        str = "null";
                    }
                    objArr[3] = str;
                    x.d(str2, str3, objArr);
                    e eVar = e.this;
                    String cL = com.tencent.mm.plugin.exdevice.j.b.cL(j);
                    x.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", cL, Boolean.valueOf(i2 == 0));
                    if (!(i2 == 0)) {
                        List<b> linkedList;
                        synchronized (eVar.lQF) {
                            linkedList = new LinkedList(eVar.lQF);
                        }
                        for (b b : linkedList) {
                            b.b(cL, null, false);
                        }
                        linkedList.clear();
                        for (b b2 : eVar.lQG.values()) {
                            b2.b(cL, null, false);
                        }
                    }
                }
            });
        }
    }

    public static boolean b(String str, String str2, byte[] bArr) {
        String str3;
        String str4;
        Object[] objArr;
        if (bi.oN(str) || bi.oN(str2) || bi.by(bArr)) {
            int i;
            str3 = "MicroMsg.exdevice.ExdeviceEventManager";
            str4 = "input error. mac = %s, brandName = %s, dataLen = %d";
            objArr = new Object[3];
            if (bi.oN(str)) {
                str = "null";
            }
            objArr[0] = str;
            if (bi.oN(str2)) {
                str2 = "null";
            }
            objArr[1] = str2;
            if (bi.by(bArr)) {
                i = 0;
            } else {
                i = bArr.length;
            }
            objArr[2] = Integer.valueOf(i);
            x.e(str3, str4, objArr);
            return false;
        }
        str3 = "MicroMsg.exdevice.ExdeviceEventManager";
        str4 = "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d";
        objArr = new Object[3];
        objArr[0] = bi.oN(str) ? "null" : str;
        objArr[1] = bi.oN(str2) ? "null" : str2;
        objArr[2] = Integer.valueOf(bi.by(bArr) ? 0 : bArr.length);
        x.d(str3, str4, objArr);
        com.tencent.mm.plugin.exdevice.h.b cK = ad.aER().cK(com.tencent.mm.plugin.exdevice.j.b.Aa(str));
        if (cK == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", str, str2);
            return false;
        }
        com.tencent.mm.plugin.g.a.b.a.a af = com.tencent.mm.plugin.g.a.b.a.a.af(bArr);
        if (1 != af.kDv) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", Long.valueOf(1), Long.valueOf(af.kDv));
            return false;
        }
        com.tencent.mm.plugin.g.a.b.a.f fVar = (com.tencent.mm.plugin.g.a.b.a.f) af;
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).a(cK.field_deviceID, cK.field_deviceType, (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), fVar.kFj, "");
        return true;
    }

    public final void j(String str, String str2, boolean z) {
        List<b> linkedList;
        synchronized (this.lQF) {
            linkedList = new LinkedList(this.lQF);
        }
        for (b k : linkedList) {
            k.k(str, str2, z);
        }
        linkedList.clear();
        for (b k2 : this.lQG.values()) {
            k2.k(str, str2, z);
        }
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + str + ", mac=" + str2 + ", isCompleted=" + z);
        com.tencent.mm.sdk.b.b ejVar = new ej();
        ejVar.ftR.ftL = str;
        ejVar.ftR.mac = str2;
        ejVar.ftR.aow = z;
        com.tencent.mm.sdk.b.a.xmy.a(ejVar, Looper.getMainLooper());
    }

    public static void e(String str, String str2, int i, String str3) {
        com.tencent.mm.sdk.b.b lbVar = new lb();
        lbVar.fDh.op = 2;
        lbVar.fDh.fAA = str;
        lbVar.fDh.ftb = i;
        lbVar.fDh.url = str2;
        lbVar.fDh.ffG = str3;
        com.tencent.mm.sdk.b.a.xmy.a(lbVar, Looper.getMainLooper());
    }

    public static void bi(String str, int i) {
        com.tencent.mm.sdk.b.b lbVar = new lb();
        lbVar.fDh.op = 1;
        lbVar.fDh.fAA = str;
        lbVar.fDh.aAk = i;
        com.tencent.mm.sdk.b.a.xmy.a(lbVar, Looper.getMainLooper());
    }

    public static void c(String str, String str2, byte[] bArr) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", str, str2);
        com.tencent.mm.sdk.b.b dtVar = new dt();
        dtVar.ftl.ffG = str;
        dtVar.ftl.fsi = str2;
        dtVar.ftl.data = bArr;
        com.tencent.mm.sdk.b.a.xmy.a(dtVar, Looper.getMainLooper());
    }

    public static void ad(String str, boolean z) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", str, Boolean.valueOf(z));
        com.tencent.mm.sdk.b.b dsVar = new ds();
        dsVar.ftk.ffG = str;
        dsVar.ftk.fsf = z;
        com.tencent.mm.sdk.b.a.xmy.a(dsVar, Looper.getMainLooper());
    }

    public final boolean a(b bVar) {
        if (bVar == null || this.lQF.contains(bVar)) {
            return false;
        }
        return this.lQF.add(bVar);
    }

    public final boolean b(b bVar) {
        return bVar != null && this.lQF.remove(bVar);
    }

    private b a(String str, b bVar) {
        return (b) this.lQG.put(str, bVar);
    }

    static boolean aEF() {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
        Context context = ad.getContext();
        try {
            ad.aEY().aEA();
        } catch (Throwable e) {
            x.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", e.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", e, "", new Object[0]);
        }
        context.stopService(new Intent(context, ExDeviceService.class));
        return true;
    }
}
