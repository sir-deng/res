package com.tencent.mm.plugin.gcm.modelgcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.gcm.a;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.f.a.gl;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import java.util.List;

public class GcmBroadcastReceiver extends BroadcastReceiver {
    static List<Pair<Long, Long>> nDM = new LinkedList();
    private static volatile boolean nDN = false;
    private static WakerLock wakerlock = null;

    public static void aSG() {
        nDM.clear();
    }

    public void onReceive(Context context, Intent intent) {
        x.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive in.");
        String aSK;
        String stringExtra;
        if (intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION")) {
            final a aSH = a.aSH();
            aSK = aSH.aSK();
            stringExtra = intent.getStringExtra("registration_id");
            x.i("GcmBroadcastReceiver", "REGISTRATION intent received:" + intent.toString());
            if (intent.getStringExtra("error") == null) {
                if (!(intent.getStringExtra("unregistered") != null || stringExtra == null || aSK.compareTo(stringExtra) == 0)) {
                    if (aa.VV() == null) {
                        x.w("GcmBroadcastReceiver", "gcm reg id recv, but mmpushcore not init, id = " + stringExtra);
                    } else {
                        aSH.af(context, stringExtra);
                        aa.VV().post(new Runnable() {
                            public final void run() {
                                aSH.aSN();
                            }
                        });
                    }
                }
            }
            d.pVE.a(452, 25, 1, false);
            return;
        }
        final a aSH2 = a.aSH();
        Object[] objArr;
        if (aSH2 == null || bi.oN(aSH2.aSK())) {
            aSK = "GcmBroadcastReceiver";
            stringExtra = "Gcm push is not reg to server. reg == null[%b], isRegToSvr[%b]";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(aSH2 == null);
            objArr[1] = Boolean.valueOf(aSH2 == null ? false : aSH2.aSP());
            x.i(aSK, stringExtra, objArr);
            g.pWK.k(11250, new StringBuilder("1,2").toString());
            d.pVE.a(452, aSH2 == null ? 26 : 27, 1, false);
        } else if (aSH2.aSL()) {
            d.pVE.a(452, 42, 1, false);
            if (nDN) {
                x.i("GcmBroadcastReceiver", "Gcm push isRegistrationExpired and reNewalRegistting return");
                d.pVE.a(452, 44, 1, false);
            } else if (aa.VV() == null) {
                x.i("GcmBroadcastReceiver", "Gcm push isRegistrationExpired but handler is null wait for next push");
            } else {
                nDN = true;
                aa.VV().postDelayed(new Runnable() {
                    public final void run() {
                        x.i("GcmBroadcastReceiver", "Gcm push isRegistrationExpired reNewalRegistting start ");
                        d.pVE.a(452, 43, 1, false);
                        aSH2.aSJ();
                    }
                }, 500);
            }
        } else {
            nDN = false;
            try {
                if (k.aX(context)) {
                    x.i("GcmBroadcastReceiver", "Logout or exit MM. no need show Notification.");
                    g.pWK.k(11250, new StringBuilder("1,2").toString());
                    d.pVE.a(452, 28, 1, false);
                    return;
                }
                Bundle extras = intent.getExtras();
                a.J(context);
                aSK = a.c(intent);
                if (extras.isEmpty()) {
                    x.i("GcmBroadcastReceiver", "Intent extras is empty: ");
                    g.pWK.k(11250, new StringBuilder("1,0").toString());
                    d.pVE.a(452, 29, 1, false);
                    return;
                }
                String string = extras.getString("seq");
                String string2 = extras.getString(OpenSDKTool4Assistant.EXTRA_UIN);
                String string3 = extras.getString("cmd");
                String string4 = extras.getString("username");
                String string5 = extras.getString("time");
                String string6 = extras.getString("collapse_key");
                String string7 = extras.getString("sound");
                String string8 = extras.getString("alert");
                String string9 = extras.getString("msgType");
                String string10 = extras.getString("badge");
                String string11 = extras.getString("from");
                extras.getString("ext");
                if ("send_error".equals(aSK)) {
                    aSK = "GcmBroadcastReceiver";
                    stringExtra = "Send error:. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]";
                    objArr = new Object[11];
                    objArr[0] = string;
                    objArr[1] = string2;
                    objArr[2] = string3;
                    objArr[3] = bi.Wz(string4);
                    objArr[4] = string5;
                    objArr[5] = string6;
                    objArr[6] = string7;
                    objArr[7] = Integer.valueOf(string8 == null ? -1 : string8.length());
                    objArr[8] = string9;
                    objArr[9] = string10;
                    objArr[10] = string11;
                    x.i(aSK, stringExtra, objArr);
                    g.pWK.k(11250, new StringBuilder("1,1").toString());
                    d.pVE.a(452, 30, 1, false);
                } else if ("deleted_messages".equals(aSK)) {
                    x.i("GcmBroadcastReceiver", "Deleted messages on server.");
                    g.pWK.k(11250, new StringBuilder("1,1").toString());
                    d.pVE.a(452, 31, 1, false);
                } else if ("gcm".equals(aSK)) {
                    d.pVE.a(452, 32, 1, false);
                    aSK = "GcmBroadcastReceiver";
                    stringExtra = "Received gcm msg. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]";
                    objArr = new Object[11];
                    objArr[0] = string;
                    objArr[1] = string2;
                    objArr[2] = string3;
                    objArr[3] = bi.Wz(string4);
                    objArr[4] = string5;
                    objArr[5] = string6;
                    objArr[6] = string7;
                    objArr[7] = Integer.valueOf(string8 == null ? -1 : string8.length());
                    objArr[8] = string9;
                    objArr[9] = string10;
                    objArr[10] = string11;
                    x.i(aSK, stringExtra, objArr);
                    long j = bi.oN(string2) ? 0 : bi.getLong(string2, 0);
                    long j2 = bi.oN(string) ? 0 : bi.getLong(string, 0);
                    long j3 = bi.oN(string3) ? 0 : bi.getLong(string3, 0);
                    int CH = com.tencent.mm.kernel.a.CH();
                    if (j == 0 || !Integer.toHexString(CH).equals(Long.toHexString(j))) {
                        x.e("GcmBroadcastReceiver", "Logined user changed. no need show Notification.uin:" + j + ", oldUin:" + CH);
                        g.pWK.k(11250, new StringBuilder("1,3").toString());
                        d dVar = d.pVE;
                        if (j == 0) {
                            j3 = 33;
                        } else {
                            j3 = 34;
                        }
                        dVar.a(452, j3, 1, false);
                        return;
                    }
                    Object obj;
                    for (Pair pair : nDM) {
                        if (((Long) pair.first).longValue() == j3 && ((Long) pair.second).longValue() == j2) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        x.w("GcmBroadcastReceiver", "already has this seq:" + j2);
                        d.pVE.a(452, 35, 1, false);
                        return;
                    }
                    nDM.add(Pair.create(Long.valueOf(j3), Long.valueOf(j2)));
                    if (nDM.size() > 60) {
                        nDM.remove(0);
                    }
                    if (wakerlock == null) {
                        wakerlock = new WakerLock(context);
                        x.i("GcmBroadcastReceiver", "start new wakerlock");
                    }
                    wakerlock.lock(200, "GcmBroadcastReceiver.onReceive");
                    b glVar = new gl();
                    glVar.fxs.type = 13;
                    com.tencent.mm.sdk.b.a.xmy.m(glVar);
                }
                x.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive out.");
            } catch (Throwable e) {
                x.e("GcmBroadcastReceiver", "GcmBroadcastReceiver error :" + e.toString());
                x.printErrStackTrace("GcmBroadcastReceiver", e, "", new Object[0]);
                d.pVE.a(452, 36, 1, false);
            }
        }
    }
}
