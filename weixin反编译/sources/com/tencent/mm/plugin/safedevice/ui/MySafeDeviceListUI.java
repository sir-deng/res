package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.safedevice.a.c;
import com.tencent.mm.plugin.safedevice.ui.SafeDeviceListPreference.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import java.util.LinkedList;
import java.util.List;

public class MySafeDeviceListUI extends MMPreference implements e, com.tencent.mm.sdk.e.j.a {
    private ag handler = new ag() {
        public final void handleMessage(Message message) {
            MySafeDeviceListUI.this.inW.notifyDataSetChanged();
            super.handleMessage(message);
        }
    };
    private ProgressDialog inI = null;
    private f inW;
    private int pXr = -2;
    private List<SafeDeviceListPreference> pXs;
    private a pXt;
    private boolean pXu = true;
    private List<c> pXv;
    private OnMenuItemClickListener pXw = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            MySafeDeviceListUI.a(MySafeDeviceListUI.this);
            return true;
        }
    };

    private class a implements com.tencent.mm.plugin.safedevice.ui.SafeDeviceListPreference.a, b {
        private a() {
        }

        /* synthetic */ a(MySafeDeviceListUI mySafeDeviceListUI, byte b) {
            this();
        }

        public final void Je(String str) {
            MySafeDeviceListUI.this.inW.Zv(str);
            MySafeDeviceListUI.this.handler.sendEmptyMessage(0);
            MySafeDeviceListUI.this.addTextOptionMenu(0, MySafeDeviceListUI.this.getString(R.l.eHa), MySafeDeviceListUI.this.pXw);
            MySafeDeviceListUI.this.pXr = MySafeDeviceListUI.this.pXr ^ -1;
            MySafeDeviceListUI.this.hJ(MySafeDeviceListUI.this.pXu);
        }

        public final void Jf(String str) {
            x.e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed" + str);
        }
    }

    static /* synthetic */ void a(MySafeDeviceListUI mySafeDeviceListUI) {
        if (mySafeDeviceListUI.pXs != null && mySafeDeviceListUI.pXs.size() > 0) {
            mySafeDeviceListUI.pXr ^= -1;
            for (SafeDeviceListPreference vU : mySafeDeviceListUI.pXs) {
                vU.vU(mySafeDeviceListUI.pXr);
            }
            mySafeDeviceListUI.inW.notifyDataSetChanged();
        }
        if (mySafeDeviceListUI.pXr == 1) {
            mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(R.l.dFw), mySafeDeviceListUI.pXw);
        } else {
            mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(R.l.eHa), mySafeDeviceListUI.pXw);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a((int) HardCoderJNI.SCENE_QUIT_CHATTING, (e) this);
        as.CN().a(361, (e) this);
        com.tencent.mm.plugin.safedevice.a.f.bpa().c(this);
        initView();
        final k rVar = new r(q.FY());
        as.CN().a(rVar, 0);
        getString(R.l.dGZ);
        this.inI = h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(rVar);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b((int) HardCoderJNI.SCENE_QUIT_CHATTING, (e) this);
        as.CN().b(361, (e) this);
        com.tencent.mm.plugin.safedevice.a.f.bpa().j(this);
    }

    protected void onResume() {
        super.onResume();
        this.pXu = q.Gg();
        hJ(this.pXu);
    }

    public final int XK() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        if (bi.oN(str)) {
            x.e("MicroMsg.MySafeDeviceListUI", "null key");
            return false;
        }
        if (str.equals("safe_device_verify_check")) {
            final boolean isChecked = ((CheckBoxPreference) preference).isChecked();
            if (!isChecked) {
                h.b(this, R.l.eGW, R.l.eGV, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        MySafeDeviceListUI.this.pXu = isChecked;
                        MySafeDeviceListUI.this.hJ(MySafeDeviceListUI.this.pXu);
                        com.tencent.mm.plugin.safedevice.a.e.x(false, true);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        MySafeDeviceListUI.this.hJ(MySafeDeviceListUI.this.pXu);
                        if (MySafeDeviceListUI.this.pXr == 1) {
                            for (SafeDeviceListPreference vU : MySafeDeviceListUI.this.pXs) {
                                vU.vU(MySafeDeviceListUI.this.pXr);
                            }
                            MySafeDeviceListUI.this.handler.sendEmptyMessage(0);
                        }
                    }
                });
            } else if (!this.pXu) {
                as.Hm();
                if (((Integer) com.tencent.mm.y.c.Db().get(64, Integer.valueOf(-1))).intValue() != 1) {
                    h.b(this, R.l.eHn, R.l.eHo, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            as.Hm();
                            String str = (String) com.tencent.mm.y.c.Db().get(6, null);
                            if (bi.oN(str)) {
                                x.d("MicroMsg.MySafeDeviceListUI", "not bind mobile");
                                return;
                            }
                            Intent intent = new Intent(MySafeDeviceListUI.this, SecurityAccountIntroUI.class);
                            intent.putExtra("binded_mobile", str);
                            intent.putExtra("re_open_verify", true);
                            MMWizardActivity.A(MySafeDeviceListUI.this, intent);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MySafeDeviceListUI.this.hJ(MySafeDeviceListUI.this.pXu);
                        }
                    });
                } else {
                    this.pXu = isChecked;
                    hJ(this.pXu);
                    com.tencent.mm.plugin.safedevice.a.e.x(true, true);
                }
            }
        } else if (str.startsWith("mysafedevice_")) {
            SafeDeviceListPreference safeDeviceListPreference = (SafeDeviceListPreference) preference;
            if (safeDeviceListPreference != null) {
                final c cVar = safeDeviceListPreference.pXC;
                h.a(this.mController.xRr, getString(R.l.eHc), cVar.field_name, getString(R.l.eHf), -1, new h.b() {
                    public final boolean v(CharSequence charSequence) {
                        String trim = charSequence == null ? "" : charSequence.toString().trim();
                        if (trim.equals(cVar.field_name)) {
                            return true;
                        }
                        if (trim.length() <= 0) {
                            h.bu(MySafeDeviceListUI.this.mController.xRr, MySafeDeviceListUI.this.getString(R.l.eHb));
                            return false;
                        }
                        final k bVar = new com.tencent.mm.plugin.safedevice.a.b(cVar.field_uid, trim, cVar.field_devicetype);
                        as.CN().a(bVar, 0);
                        if (MySafeDeviceListUI.this.inI != null) {
                            MySafeDeviceListUI.this.inI.dismiss();
                        }
                        MySafeDeviceListUI.this.inI = h.a(MySafeDeviceListUI.this, com.tencent.mm.bu.a.ac(MySafeDeviceListUI.this, R.l.dHn), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(bVar);
                            }
                        });
                        return true;
                    }
                });
            }
        }
        return true;
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MySafeDeviceListUI.this.finish();
                return true;
            }
        });
        this.inW = this.yrJ;
        this.pXs = new LinkedList();
        this.pXt = new a();
        addTextOptionMenu(0, getString(R.l.eHa), this.pXw);
        setMMTitle(R.l.eGN);
    }

    private void hJ(boolean z) {
        this.pXs.clear();
        this.pXv = com.tencent.mm.plugin.safedevice.a.f.bpa().boX();
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fcr);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("safe_device_verify_check");
        if (checkBoxPreference != null) {
            checkBoxPreference.tYU = z;
        }
        if (this.pXv.size() == 0) {
            this.inW.Zv("my_safe_device_list_tip");
            showOptionMenu(false);
            return;
        }
        if (this.pXr == 1) {
            addTextOptionMenu(0, getString(R.l.eHa), this.pXw);
            this.pXr ^= -1;
        }
        for (c cVar : this.pXv) {
            Preference safeDeviceListPreference = new SafeDeviceListPreference(this);
            safeDeviceListPreference.setKey("mysafedevice_" + cVar.field_uid);
            safeDeviceListPreference.setTitle(i.a((Context) this, cVar.field_name));
            if (!com.tencent.mm.sdk.platformtools.f.xmW) {
                safeDeviceListPreference.setSummary(cVar.field_devicetype);
            }
            safeDeviceListPreference.pXE = this.pXt;
            safeDeviceListPreference.pXF = this.pXt;
            safeDeviceListPreference.pXC = cVar;
            this.inW.a(safeDeviceListPreference, -1);
            this.pXs.add(safeDeviceListPreference);
        }
        showOptionMenu(true);
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.MySafeDeviceListUI", "notify " + str);
        this.handler.post(new Runnable() {
            public final void run() {
                MySafeDeviceListUI.this.hJ(MySafeDeviceListUI.this.pXu);
            }
        });
    }

    public final void a(int r6, int r7, java.lang.String r8, com.tencent.mm.ad.k r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r4 = 0;
        r0 = r5.inI;
        if (r0 == 0) goto L_0x0015;
    L_0x0005:
        r0 = r5.inI;
        r0 = r0.isShowing();
        if (r0 == 0) goto L_0x0015;
    L_0x000d:
        r0 = r5.inI;
        r0.dismiss();
        r0 = 0;
        r5.inI = r0;
    L_0x0015:
        r0 = r9.getType();
        r1 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r0 != r1) goto L_0x0053;
    L_0x001d:
        if (r6 != 0) goto L_0x002d;
    L_0x001f:
        if (r7 != 0) goto L_0x002d;
    L_0x0021:
        r0 = com.tencent.mm.y.q.Gg();
        r5.pXu = r0;
        r0 = r5.pXu;
        r5.hJ(r0);
    L_0x002c:
        return;
    L_0x002d:
        r0 = com.tencent.mm.plugin.c.a.ihO;
        r0 = r0.a(r5, r6, r7, r8);
        if (r0 != 0) goto L_0x002c;
    L_0x0035:
        r0 = com.tencent.mm.R.l.eHd;
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = java.lang.Integer.valueOf(r6);
        r1[r4] = r2;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r7);
        r1[r2] = r3;
        r0 = r5.getString(r0, r1);
        r0 = android.widget.Toast.makeText(r5, r0, r4);
        r0.show();
        goto L_0x002c;
    L_0x0053:
        r0 = r9.getType();
        r1 = 361; // 0x169 float:5.06E-43 double:1.784E-321;
        if (r0 != r1) goto L_0x002c;
    L_0x005b:
        if (r6 != 0) goto L_0x0089;
    L_0x005d:
        if (r7 != 0) goto L_0x0089;
    L_0x005f:
        r9 = (com.tencent.mm.plugin.safedevice.a.b) r9;
        r0 = new com.tencent.mm.plugin.safedevice.a.c;
        r0.<init>();
        r1 = r9.fsb;
        r0.field_devicetype = r1;
        r1 = r9.deviceName;
        r0.field_name = r1;
        r1 = r9.ffG;
        r0.field_uid = r1;
        r2 = 0;
        r0.field_createtime = r2;
        r1 = com.tencent.mm.plugin.safedevice.a.f.bpa();
        r2 = new java.lang.String[r4];
        r1.c(r0, r2);
        r0 = com.tencent.mm.R.l.eHg;
        r0 = com.tencent.mm.bu.a.ac(r5, r0);
        com.tencent.mm.ui.base.h.bu(r5, r0);
        goto L_0x002c;
    L_0x0089:
        r0 = com.tencent.mm.plugin.c.a.ihO;
        r0 = r0.a(r5, r6, r7, r8);
        if (r0 == 0) goto L_0x002c;
    L_0x0091:
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }
}
