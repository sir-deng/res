package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.br;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.protocal.c.aad;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.protocal.c.asl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public enum i implements e {
    ;
    
    private ProgressDialog inI;
    private boolean lSy;
    public a lSz;

    public interface a {
        void eL(boolean z);
    }

    private i(String str) {
        this.lSy = false;
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        if (sharedPreferences.getLong(stringBuilder.append(c.Cn()).toString(), 0) != 0) {
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", Long.valueOf(sharedPreferences.getLong(stringBuilder.append(c.Cn()).toString(), 0)));
            return;
        }
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
    }

    public final void a(Context context, final a aVar) {
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
        if (this.lSy) {
            if (this.lSz == null) {
                this.lSz = aVar;
            }
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
            return;
        }
        final k oVar = new o();
        if (!(context == null || !(context instanceof Activity) || ((Activity) context).isFinishing())) {
            if (this.inI != null && this.inI.isShowing()) {
                this.inI.dismiss();
            }
            context.getString(R.l.dGZ);
            this.inI = h.a(context, context.getString(R.l.eIc), new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(oVar);
                    i.this.inI.dismiss();
                    i.this.lSy = false;
                    if (aVar != null) {
                        aVar.eL(false);
                    }
                }
            });
        }
        this.lSz = aVar;
        as.CN().a(oVar, 0);
    }

    public final boolean eM(boolean z) {
        if (this.lSy) {
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        long j = sharedPreferences.getLong(stringBuilder.append(c.Cn()).toString(), 0);
        if (z || currentTimeMillis - j >= 86400000) {
            return true;
        }
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
        return false;
    }

    public static void cu(long j) {
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", Long.valueOf(j));
        Editor edit = ad.getContext().getSharedPreferences("exdevice_pref", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        edit.putLong(stringBuilder.append(c.Cn()).toString(), j).commit();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.lSy = false;
        if (kVar != null && i2 == 0 && i == 0) {
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", Integer.valueOf(kVar.getType()));
            if (kVar.getType() == 539) {
                if (i == 0 && i2 == 0) {
                    o oVar = (o) kVar;
                    final aad aad = (oVar.gLB == null || oVar.gLB.hnR.hnY == null) ? null : (aad) oVar.gLB.hnR.hnY;
                    if (aad == null || aad.wqu == null) {
                        if (this.lSz != null) {
                            this.lSz.eL(false);
                        }
                        if (this.inI != null && this.inI.isShowing()) {
                            this.inI.dismiss();
                            return;
                        }
                        return;
                    }
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            i.cu(bi.Wy());
                            com.tencent.mm.plugin.exdevice.h.c aER = ad.aER();
                            List<b> linkedList = new LinkedList();
                            Cursor Tq = aER.Tq();
                            Iterator it;
                            ake ake;
                            boolean z;
                            Iterator it2;
                            asl asl;
                            akf akf;
                            ake ake2;
                            br zM;
                            com.tencent.mm.sdk.e.c bVar;
                            if (Tq == null || !Tq.moveToFirst()) {
                                if (Tq != null) {
                                    Tq.close();
                                }
                                for (b bVar2 : linkedList) {
                                    it = aad.wqu.iterator();
                                    while (it.hasNext()) {
                                        ake = ((asl) it.next()).vSI;
                                        if (!bVar2.field_deviceType.equals(ake.vQr) && bVar2.field_deviceID.equals(ake.kyJ)) {
                                            z = true;
                                            break;
                                        }
                                    }
                                    z = false;
                                    if (!z) {
                                        x.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", bVar2.field_deviceID, bVar2.field_deviceType);
                                        i.d(bVar2);
                                        ad.aER().cx(bVar2.field_deviceID, bVar2.field_deviceType);
                                        ad.aFc();
                                        e.ad(bVar2.field_deviceID, false);
                                    }
                                }
                                it2 = aad.wqu.iterator();
                                while (it2.hasNext()) {
                                    asl = (asl) it2.next();
                                    akf = asl.vSJ;
                                    ake2 = asl.vSI;
                                    if (!(ake2 == null || akf == null || bi.oN(ake2.kyJ))) {
                                        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", ake2.kyJ, ake2.vQr, Integer.valueOf(asl.wGR));
                                        zM = ad.aER().zM(ake2.kyJ);
                                        if (2 != asl.wGR) {
                                            x.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", ake2.kyJ, akf.vSj, akf.wxU);
                                            if (zM != null) {
                                                i.d(zM);
                                                ad.aER().cx(zM.field_deviceID, zM.field_deviceType);
                                                ad.aFc();
                                                e.ad(zM.field_deviceID, false);
                                            }
                                        } else {
                                            bVar = new b();
                                            bVar.field_deviceID = ake2.kyJ;
                                            bVar.field_deviceType = ake2.vQr;
                                            bVar.field_connProto = akf.wxV;
                                            bVar.field_connStrategy = akf.wxW;
                                            bVar.field_closeStrategy = akf.wxX;
                                            if (!(akf.ggP != 2 || zM == null || zM.ggL == null)) {
                                                akf.hxj = zM.ggL;
                                            }
                                            bVar.cZ(akf.hxj);
                                            bVar.dP(akf.wyd);
                                            bVar.dO(akf.wyc);
                                            bVar.dN(akf.wyb);
                                            bVar.eZ(akf.wye);
                                            bVar.dL(akf.nlA);
                                            bVar.dM(akf.nkN);
                                            bVar.fa(akf.ggP);
                                            bVar.an(akf.ggQ);
                                            bVar.dQ(akf.ggR);
                                            bVar.dR(akf.ggS);
                                            bVar.dS(akf.ggT);
                                            bVar.dT(akf.ggU);
                                            bVar.field_url = "";
                                            bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.Aa(com.tencent.mm.plugin.exdevice.j.b.Ab(akf.vSj));
                                            bVar.field_md5Str = g.s(new String(ake2.vQr + ake2.kyJ).getBytes());
                                            bVar.field_authKey = akf.vPY;
                                            bVar.field_brandName = akf.wxU;
                                            if (bVar.field_mac == 0) {
                                                bVar.field_mac = System.currentTimeMillis();
                                            }
                                            if (zM == null) {
                                                z = ad.aER().b(bVar);
                                                if (z) {
                                                    ad.aFc();
                                                    e.ad(bVar.field_deviceID, true);
                                                }
                                            } else {
                                                z = ad.aER().e(bVar) == 0;
                                            }
                                            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", Boolean.valueOf(z), bVar.field_brandName, bVar.field_deviceID, ake2.vQr, bVar.field_connProto, Integer.valueOf(bVar.field_connStrategy), Integer.valueOf(bVar.field_closeStrategy), Long.valueOf(bVar.field_mac));
                                        }
                                    }
                                }
                            }
                            do {
                                b bVar3 = new b();
                                bVar3.b(Tq);
                                linkedList.add(bVar3);
                            } while (Tq.moveToNext());
                            if (Tq != null) {
                                Tq.close();
                            }
                            for (b bVar22 : linkedList) {
                                it = aad.wqu.iterator();
                                while (it.hasNext()) {
                                    ake = ((asl) it.next()).vSI;
                                    if (!bVar22.field_deviceType.equals(ake.vQr)) {
                                    }
                                }
                                z = false;
                                if (!z) {
                                    x.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", bVar22.field_deviceID, bVar22.field_deviceType);
                                    i.d(bVar22);
                                    ad.aER().cx(bVar22.field_deviceID, bVar22.field_deviceType);
                                    ad.aFc();
                                    e.ad(bVar22.field_deviceID, false);
                                }
                            }
                            it2 = aad.wqu.iterator();
                            while (it2.hasNext()) {
                                asl = (asl) it2.next();
                                akf = asl.vSJ;
                                ake2 = asl.vSI;
                                x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", ake2.kyJ, ake2.vQr, Integer.valueOf(asl.wGR));
                                zM = ad.aER().zM(ake2.kyJ);
                                if (2 != asl.wGR) {
                                    bVar = new b();
                                    bVar.field_deviceID = ake2.kyJ;
                                    bVar.field_deviceType = ake2.vQr;
                                    bVar.field_connProto = akf.wxV;
                                    bVar.field_connStrategy = akf.wxW;
                                    bVar.field_closeStrategy = akf.wxX;
                                    akf.hxj = zM.ggL;
                                    bVar.cZ(akf.hxj);
                                    bVar.dP(akf.wyd);
                                    bVar.dO(akf.wyc);
                                    bVar.dN(akf.wyb);
                                    bVar.eZ(akf.wye);
                                    bVar.dL(akf.nlA);
                                    bVar.dM(akf.nkN);
                                    bVar.fa(akf.ggP);
                                    bVar.an(akf.ggQ);
                                    bVar.dQ(akf.ggR);
                                    bVar.dR(akf.ggS);
                                    bVar.dS(akf.ggT);
                                    bVar.dT(akf.ggU);
                                    bVar.field_url = "";
                                    bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.Aa(com.tencent.mm.plugin.exdevice.j.b.Ab(akf.vSj));
                                    bVar.field_md5Str = g.s(new String(ake2.vQr + ake2.kyJ).getBytes());
                                    bVar.field_authKey = akf.vPY;
                                    bVar.field_brandName = akf.wxU;
                                    if (bVar.field_mac == 0) {
                                        bVar.field_mac = System.currentTimeMillis();
                                    }
                                    if (zM == null) {
                                        z = ad.aER().b(bVar);
                                        if (z) {
                                            ad.aFc();
                                            e.ad(bVar.field_deviceID, true);
                                        }
                                    } else if (ad.aER().e(bVar) == 0) {
                                    }
                                    x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", Boolean.valueOf(z), bVar.field_brandName, bVar.field_deviceID, ake2.vQr, bVar.field_connProto, Integer.valueOf(bVar.field_connStrategy), Integer.valueOf(bVar.field_closeStrategy), Long.valueOf(bVar.field_mac));
                                } else {
                                    x.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", ake2.kyJ, akf.vSj, akf.wxU);
                                    if (zM != null) {
                                        i.d(zM);
                                        ad.aER().cx(zM.field_deviceID, zM.field_deviceType);
                                        ad.aFc();
                                        e.ad(zM.field_deviceID, false);
                                    }
                                }
                            }
                        }
                    });
                    if (this.lSz != null) {
                        this.lSz.eL(true);
                    }
                } else {
                    x.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                    if (this.lSz != null) {
                        this.lSz.eL(false);
                    }
                    if (this.inI != null && this.inI.isShowing()) {
                        this.inI.dismiss();
                        return;
                    }
                    return;
                }
            }
            if (this.inI != null && this.inI.isShowing()) {
                this.inI.dismiss();
                return;
            }
            return;
        }
        x.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", Integer.valueOf(i2), Integer.valueOf(i));
    }
}
