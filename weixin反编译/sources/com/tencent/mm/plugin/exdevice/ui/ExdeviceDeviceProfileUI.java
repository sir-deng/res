package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.y;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.cu;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.br;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.m;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class ExdeviceDeviceProfileUI extends MMPreference implements e {
    private String bpq;
    private r jqf;
    private String lRC;
    private String lRD;
    private long lSM;
    private String lWS;
    private String lXR;
    private String lXS;
    private String lXk;
    private int lYP;
    private r lYX = null;
    private String lZU;
    private String lZV;
    private boolean lZW;
    private String lZX;
    private boolean lZY;
    private String lZZ;
    private b maa;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
        r10 = this;
        r6 = 2;
        r3 = 1;
        r2 = 0;
        super.onCreate(r11);
        r0 = new com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$1;
        r0.<init>();
        r10.setBackBtn(r0);
        r0 = com.tencent.mm.R.l.ecN;
        r10.setMMTitle(r0);
        r0 = new com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$7;
        r0.<init>();
        r10.maa = r0;
        r0 = r10.getIntent();
        r1 = "device_mac";
        r1 = r0.getStringExtra(r1);
        r10.bpq = r1;
        r1 = "device_ble_simple_proto";
        r4 = 0;
        r4 = r0.getLongExtra(r1, r4);
        r10.lSM = r4;
        r1 = "device_jump_url";
        r1 = r0.getStringExtra(r1);
        r10.lZU = r1;
        r1 = "device_brand_name";
        r1 = r0.getStringExtra(r1);
        r10.lRC = r1;
        r1 = "device_id";
        r1 = r0.getStringExtra(r1);
        r10.lRD = r1;
        r1 = "device_type";
        r1 = r0.getStringExtra(r1);
        r10.lWS = r1;
        r1 = "bind_ticket";
        r1 = r0.getStringExtra(r1);
        r10.lXS = r1;
        r1 = "subscribe_flag";
        r1 = r0.getIntExtra(r1, r2);
        r10.lYP = r1;
        r1 = "device_has_bound";
        r1 = r0.getBooleanExtra(r1, r2);
        r10.lZW = r1;
        r1 = "device_title";
        r1 = r0.getStringExtra(r1);
        r10.lXR = r1;
        r1 = "device_alias";
        r1 = r0.getStringExtra(r1);
        r10.lZV = r1;
        r1 = "device_desc";
        r1 = r0.getStringExtra(r1);
        r10.lXk = r1;
        r1 = "device_icon_url";
        r0 = r0.getStringExtra(r1);
        r10.lZX = r0;
        r0 = r10.lRD;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x00a5;
    L_0x009d:
        r0 = r10.lWS;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x00cb;
    L_0x00a5:
        r0 = "MicroMsg.ExdeviceDeviceProfileUI";
        r1 = "deviceId or deviceType is null.";
        r4 = new java.lang.Object[r6];
        r5 = r10.lRD;
        r4[r2] = r5;
        r5 = r10.lWS;
        r4[r3] = r5;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r4);
    L_0x00b8:
        if (r2 != 0) goto L_0x01b4;
    L_0x00ba:
        r0 = r10.mController;
        r0 = r0.xRr;
        r1 = com.tencent.mm.R.l.edu;
        r0 = android.widget.Toast.makeText(r0, r1, r3);
        r0.show();
        r10.finish();
    L_0x00ca:
        return;
    L_0x00cb:
        r0 = com.tencent.mm.plugin.exdevice.model.ad.aER();
        r1 = r10.lRD;
        r4 = r10.lWS;
        r0 = r0.cv(r1, r4);
        if (r0 == 0) goto L_0x01a9;
    L_0x00d9:
        r10.lZW = r3;
        r1 = r10.lZV;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x00eb;
    L_0x00e3:
        r1 = r0.ggL;
        r1 = com.tencent.mm.sdk.platformtools.bi.oM(r1);
        r10.lZV = r1;
    L_0x00eb:
        r1 = r10.lXR;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x00fb;
    L_0x00f3:
        r1 = r0.ggM;
        r1 = com.tencent.mm.sdk.platformtools.bi.oM(r1);
        r10.lXR = r1;
    L_0x00fb:
        r1 = r10.lRC;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x010b;
    L_0x0103:
        r1 = r0.field_brandName;
        r1 = com.tencent.mm.sdk.platformtools.bi.oM(r1);
        r10.lRC = r1;
    L_0x010b:
        r1 = r10.lXk;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x011b;
    L_0x0113:
        r1 = r0.ggN;
        r1 = com.tencent.mm.sdk.platformtools.bi.oM(r1);
        r10.lXk = r1;
    L_0x011b:
        r1 = r10.lZX;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x012b;
    L_0x0123:
        r1 = r0.iconUrl;
        r1 = com.tencent.mm.sdk.platformtools.bi.oM(r1);
        r10.lZX = r1;
    L_0x012b:
        r1 = r10.lZU;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x013b;
    L_0x0133:
        r1 = r0.jumpUrl;
        r1 = com.tencent.mm.sdk.platformtools.bi.oM(r1);
        r10.lZU = r1;
    L_0x013b:
        r0 = r0.ggP;
        if (r0 != r6) goto L_0x01b1;
    L_0x013f:
        r10.lZY = r3;
        r0 = r10.lXR;
        r10.lZZ = r0;
        r0 = com.tencent.mm.plugin.exdevice.model.ad.aER();
        r0 = r0.aFw();
        r4 = r0.iterator();
    L_0x0151:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x01b1;
    L_0x0157:
        r0 = r4.next();
        r0 = (com.tencent.mm.plugin.exdevice.h.b) r0;
        r1 = r0.field_deviceType;
        r5 = r10.lWS;
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x0151;
    L_0x0167:
        r1 = r0.ggU;
        if (r1 == 0) goto L_0x0151;
    L_0x016b:
        r5 = r1.length();
        if (r5 <= 0) goto L_0x0151;
    L_0x0171:
        r5 = ",";
        r5 = r1.split(r5);
        r1 = r2;
    L_0x0179:
        r6 = r5.length;
        if (r1 >= r6) goto L_0x0151;
    L_0x017c:
        r6 = r5[r1];
        r7 = r10.lRD;
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x01a1;
    L_0x0186:
        r6 = r0.ggL;
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r6 == 0) goto L_0x01a4;
    L_0x018e:
        r6 = r0.ggM;
        r10.lZZ = r6;
    L_0x0192:
        r6 = "MicroMsg.ExdeviceDeviceProfileUI";
        r7 = "mGateWayTitle %s";
        r8 = new java.lang.Object[r3];
        r9 = r10.lZZ;
        r8[r2] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
    L_0x01a1:
        r1 = r1 + 1;
        goto L_0x0179;
    L_0x01a4:
        r6 = r0.ggL;
        r10.lZZ = r6;
        goto L_0x0192;
    L_0x01a9:
        r0 = r10.lXS;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x00b8;
    L_0x01b1:
        r2 = r3;
        goto L_0x00b8;
    L_0x01b4:
        r10.aFE();
        goto L_0x00ca;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.onCreate(android.os.Bundle):void");
    }

    private void aFE() {
        String str;
        f fVar;
        boolean z;
        f fVar2 = this.yrJ;
        DeviceProfileHeaderPreference deviceProfileHeaderPreference = (DeviceProfileHeaderPreference) fVar2.Zu("device_profile_header");
        deviceProfileHeaderPreference.a(1, new OnClickListener() {
            public final void onClick(View view) {
                h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.l.eds), "", "", 50, ExdeviceDeviceProfileUI.this.maa);
            }
        });
        deviceProfileHeaderPreference.a(4, new OnClickListener() {
            public final void onClick(View view) {
                h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.l.eds), ExdeviceDeviceProfileUI.this.lZV, "", 50, ExdeviceDeviceProfileUI.this.maa);
            }
        });
        a(deviceProfileHeaderPreference);
        deviceProfileHeaderPreference.dL(this.lZX);
        KeyValuePreference keyValuePreference = (KeyValuePreference) fVar2.Zu("connect_setting");
        KeyValuePreference keyValuePreference2 = (KeyValuePreference) fVar2.Zu("user_list");
        ((KeyValuePreference) fVar2.Zu("message_manage")).mE(true);
        keyValuePreference.mE(true);
        keyValuePreference2.mE(true);
        fVar2.bl("message_manage", true);
        fVar2.bl("connect_setting", true);
        fVar2.bl("user_list", true);
        if (this.lZY) {
            fVar2.bl("sub_device_desc", false);
            fVar2.Zu("sub_device_desc").setTitle(getResources().getString(R.l.eea, new Object[]{this.lZZ}));
            fVar2.bl("bind_device", true);
            str = "unbind_device";
            fVar = fVar2;
            z = true;
        } else {
            fVar2.bl("sub_device_desc", true);
            fVar2.bl("bind_device", this.lZW);
            String str2 = "unbind_device";
            if (this.lZW) {
                str = str2;
                fVar = fVar2;
                z = false;
            } else {
                str = str2;
                fVar = fVar2;
                z = true;
            }
        }
        fVar.bl(str, z);
        if (bi.oN(this.lZU)) {
            fVar2.bl("open_device_panel", true);
        }
    }

    private void a(DeviceProfileHeaderPreference deviceProfileHeaderPreference) {
        CharSequence charSequence = bi.oN(this.lXR) ? this.lRC : this.lXR;
        if (bi.oN(this.lZV)) {
            deviceProfileHeaderPreference.setName(charSequence);
            deviceProfileHeaderPreference.zP("");
            deviceProfileHeaderPreference.C(3, false);
            deviceProfileHeaderPreference.C(4, false);
            deviceProfileHeaderPreference.C(1, this.lZW);
        } else {
            deviceProfileHeaderPreference.setName(this.lZV);
            deviceProfileHeaderPreference.zP(getString(R.l.edn, new Object[]{charSequence}));
            deviceProfileHeaderPreference.C(3, true);
            deviceProfileHeaderPreference.C(4, true);
            deviceProfileHeaderPreference.C(1, false);
        }
        charSequence = this.lXk;
        deviceProfileHeaderPreference.lXk = charSequence;
        if (deviceProfileHeaderPreference.lXh != null) {
            deviceProfileHeaderPreference.lXh.setText(charSequence);
        }
    }

    public final int XK() {
        return R.o.fbX;
    }

    public final boolean a(f fVar, Preference preference) {
        x.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", preference.idX);
        String str;
        final k kVar;
        if ("bind_device".equals(preference.idX)) {
            if (bi.oN(this.lXS)) {
                x.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
                k mVar = new m(com.tencent.mm.plugin.exdevice.j.b.Aa(this.bpq), this.lRC, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, this.lSM);
                j(mVar);
                as.CN().a(1262, (e) this);
                as.CN().a(mVar, 0);
            } else {
                x.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
                str = this.lXS;
                int i = this.lYP;
                as.CN().a(536, (e) this);
                com.tencent.mm.sdk.b.b cuVar = new cu();
                cuVar.frS.frU = str;
                cuVar.frS.opType = 1;
                cuVar.frS.frV = i;
                a.xmy.m(cuVar);
                kVar = cuVar.frT.frW;
                getString(R.l.dGZ);
                this.lYX = h.a((Context) this, getString(R.l.ecP), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().b(536, ExdeviceDeviceProfileUI.this);
                        com.tencent.mm.sdk.b.b cuVar = new cu();
                        cuVar.frS.opType = 2;
                        cuVar.frS.frW = kVar;
                        a.xmy.m(cuVar);
                    }
                });
            }
        } else if ("unbind_device".equals(preference.idX)) {
            ake ake = new ake();
            ake.kyJ = this.lRD;
            ake.vQr = this.lWS;
            br cv = ad.aER().cv(this.lRD, this.lWS);
            if (cv != null) {
                str = cv.ggU;
                if (str != null && str.length() > 0) {
                    String[] split = str.split(",");
                    for (String cx : split) {
                        ad.aER().cx(cx, this.lWS);
                    }
                }
            }
            kVar = new com.tencent.mm.plugin.exdevice.model.x(ake, 2);
            j(kVar);
            as.CN().a(537, (e) this);
            as.CN().a(kVar, 0);
        } else if ("open_device_panel".equals(preference.idX)) {
            com.tencent.mm.plugin.exdevice.model.f.V(this.mController.xRr, this.lZU);
        } else if ("contact_info_biz_go_chatting".equals(preference.idX)) {
            as.Hm();
            ag Xv = c.Ff().Xv(this.lRC);
            Intent intent = new Intent();
            intent.putExtra("device_id", this.lRD);
            intent.putExtra("device_type", this.lWS);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", this.lXS);
            if (Xv != null) {
                if (com.tencent.mm.k.a.ga(Xv.field_type) && Xv.ciN()) {
                    y.Ml().jN(Xv.field_username);
                    intent.putExtra("Chat_User", this.lRC);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.exdevice.a.lPD.e(intent, this.mController.xRr);
                } else {
                    intent.putExtra("Contact_User", this.lRC);
                    intent.putExtra("force_get_contact", true);
                    d.b(this.mController.xRr, "profile", ".ui.ContactInfoUI", intent);
                }
            }
        } else if (!("message_manage".equals(preference.idX) || "connect_setting".equals(preference.idX) || "user_list".equals(preference.idX))) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar == null) {
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
            return;
        }
        x.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", Integer.valueOf(kVar.getType()));
        if (kVar instanceof l) {
            aFy();
            as.CN().b(kVar.getType(), (e) this);
            if (i == 0 && i2 == 0) {
                aFG();
                f(ad.aER().cv(this.lRD, this.lWS));
                runOnUiThread(new Runnable() {
                    public final void run() {
                        ExdeviceDeviceProfileUI.this.lZW = true;
                        ExdeviceDeviceProfileUI.this.aFE();
                        ExdeviceDeviceProfileUI.this.yrJ.notifyDataSetChanged();
                    }
                });
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType()));
            aFF();
        } else if (kVar instanceof m) {
            aFy();
            as.CN().b(kVar.getType(), (e) this);
            com.tencent.mm.plugin.exdevice.h.b cK = ad.aER().cK(com.tencent.mm.plugin.exdevice.j.b.Aa(this.bpq));
            if (i == 0 && i2 == 0 && cK != null) {
                f(cK);
                runOnUiThread(new Runnable() {
                    public final void run() {
                        ExdeviceDeviceProfileUI.this.lZW = true;
                        ExdeviceDeviceProfileUI.this.aFE();
                        ExdeviceDeviceProfileUI.this.yrJ.notifyDataSetChanged();
                    }
                });
                aFG();
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType()));
            aFF();
        } else if (kVar instanceof com.tencent.mm.plugin.exdevice.model.y) {
            aFy();
            as.CN().b(1263, (e) this);
            if (i == 0 && i2 == 0) {
                this.lZV = ((com.tencent.mm.plugin.exdevice.model.y) kVar).ggL;
                runOnUiThread(new Runnable() {
                    public final void run() {
                        ExdeviceDeviceProfileUI.this.a((DeviceProfileHeaderPreference) ExdeviceDeviceProfileUI.this.yrJ.Zu("device_profile_header"));
                    }
                });
                com.tencent.mm.sdk.e.c cv = ad.aER().cv(this.lRD, this.lWS);
                if (cv == null) {
                    x.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", this.lRD, this.lWS);
                    return;
                }
                cv.cZ(this.lZV);
                ad.aER().c(cv, new String[0]);
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType()));
            Toast.makeText(this.mController.xRr, getString(R.l.edr), 1).show();
        } else if (kVar instanceof com.tencent.mm.plugin.exdevice.model.x) {
            aFy();
            if (i == 0 && i2 == 0) {
                runOnUiThread(new Runnable() {
                    public final void run() {
                        ExdeviceDeviceProfileUI.this.lZV = null;
                        ExdeviceDeviceProfileUI.this.lZW = false;
                        ExdeviceDeviceProfileUI.this.aFE();
                        ExdeviceDeviceProfileUI.this.yrJ.notifyDataSetChanged();
                    }
                });
                finish();
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType()));
            runOnUiThread(new Runnable() {
                public final void run() {
                    Toast.makeText(ExdeviceDeviceProfileUI.this.mController.xRr, R.l.eeb, 1).show();
                }
            });
        }
    }

    private void f(com.tencent.mm.plugin.exdevice.h.b bVar) {
        if (bVar != null) {
            this.lRD = bVar.field_deviceID;
            this.lWS = bVar.field_deviceType;
            this.lZV = bi.oM(bVar.ggL);
            this.lXR = bi.oM(bVar.ggM);
            this.lRC = bi.oM(bVar.field_brandName);
            this.lXk = bi.oM(bVar.ggN);
            this.lZX = bi.oM(bVar.iconUrl);
            this.lZU = bi.oM(bVar.jumpUrl);
        }
    }

    private void aFy() {
        runOnUiThread(new Runnable() {
            public final void run() {
                if (ExdeviceDeviceProfileUI.this.jqf != null && ExdeviceDeviceProfileUI.this.jqf.isShowing()) {
                    ExdeviceDeviceProfileUI.this.jqf.dismiss();
                }
                if (ExdeviceDeviceProfileUI.this.lYX != null && ExdeviceDeviceProfileUI.this.lYX.isShowing()) {
                    ExdeviceDeviceProfileUI.this.lYX.dismiss();
                }
            }
        });
    }

    private void aFF() {
        runOnUiThread(new Runnable() {
            public final void run() {
                h.b(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.l.ecI), ExdeviceDeviceProfileUI.this.getString(R.l.dGZ), true);
            }
        });
    }

    private void aFG() {
        runOnUiThread(new Runnable() {
            public final void run() {
                Context context = ExdeviceDeviceProfileUI.this;
                ExdeviceDeviceProfileUI.this.getString(R.l.dGZ);
                final r a = h.a(context, ExdeviceDeviceProfileUI.this.getString(R.l.ecR), false, null);
                new al(new al.a() {
                    public final boolean uG() {
                        ExdeviceDeviceProfileUI.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                a.dismiss();
                            }
                        });
                        return true;
                    }
                }, false).K(1000, 1000);
            }
        });
    }

    private void j(final k kVar) {
        runOnUiThread(new Runnable() {
            public final void run() {
                ExdeviceDeviceProfileUI.this.jqf = h.a(ExdeviceDeviceProfileUI.this.mController.xRr, ExdeviceDeviceProfileUI.this.getString(R.l.dHn), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(kVar);
                    }
                });
            }
        });
    }
}
