package com.tencent.mm.plugin.bottle.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.d.a;
import com.tencent.mm.ac.n;
import com.tencent.mm.ax.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.HashMap;
import java.util.Map.Entry;

public class BottlePersonalInfoUI extends MMPreference implements a {
    private SharedPreferences hbz;
    private f inW;
    private c kHX;
    private HashMap<Integer, Integer> kHY = new HashMap();
    private int status;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n.JF().d(this);
        initView();
    }

    public void onDestroy() {
        com.tencent.mm.plugin.bottle.a.ihO.un();
        n.JF().e(this);
        super.onDestroy();
    }

    protected final void initView() {
        boolean z = true;
        setMMTitle(R.l.eNH);
        this.inW = this.yrJ;
        this.inW.addPreferencesFromResource(R.o.fbA);
        this.hbz = this.hbz;
        this.status = q.Gc();
        if (getIntent().getBooleanExtra("is_allow_set", true)) {
            this.kHX = new c(this, this.inW);
        } else {
            f fVar = this.inW;
            fVar.Zv("settings_sex");
            fVar.Zv("settings_district");
            fVar.Zv("settings_signature");
            fVar.Zv("bottle_settings_change_avatar_alert");
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("bottle_settings_show_at_main");
        if ((this.status & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            z = false;
        }
        checkBoxPreference.tYU = z;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BottlePersonalInfoUI.this.finish();
                return true;
            }
        });
    }

    public void onResume() {
        HeadImgPreference headImgPreference = (HeadImgPreference) this.inW.Zu("bottle_settings_change_avatar");
        Bitmap a = b.a(x.Xk(q.FY()), false, -1);
        if (a == null) {
            a = b.a(q.FY(), false, -1);
        }
        if (a != null) {
            headImgPreference.O(a);
        }
        headImgPreference.ugx = new OnClickListener() {
            public final void onClick(View view) {
                new com.tencent.mm.pluginsdk.ui.f(BottlePersonalInfoUI.this.mController.xRr, x.Xk(q.FY())).caN();
            }
        };
        if (this.kHX != null) {
            this.kHX.update();
        }
        super.onResume();
    }

    public void onPause() {
        c.ast();
        as.Hm();
        c.Db().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.kHY.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            as.Hm();
            c.Fe().b(new g(intValue, intValue2));
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch  " + intValue + " " + intValue2);
        }
        this.kHY.clear();
        super.onPause();
    }

    public final int XK() {
        return R.o.fbz;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 2;
        String str = preference.idX;
        if (str.equals("bottle_settings_change_avatar")) {
            as.Hm();
            if (c.isSDCardAvailable()) {
                k.a((Activity) this, 2, null);
                return true;
            }
            u.fJ(this);
            return false;
        } else if (str.equals("settings_district")) {
            return this.kHX.asv();
        } else {
            if (str.equals("settings_signature")) {
                return this.kHX.asu();
            }
            if (str.equals("bottle_settings_show_at_main")) {
                boolean z = this.hbz.getBoolean("bottle_settings_show_at_main", true);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch change : open = " + z + " item value = 32768 functionId = 14");
                if (z) {
                    this.status |= WXMediaMessage.THUMB_LENGTH_LIMIT;
                } else {
                    this.status &= -32769;
                }
                if (z) {
                    i = 1;
                }
                this.kHY.put(Integer.valueOf(14), Integer.valueOf(i));
                return true;
            } else if (!str.equals("bottle_settings_clear_data")) {
                return false;
            } else {
                h.a(this.mController.xRr, this.mController.xRr.getString(R.l.dUR), "", this.mController.xRr.getString(R.l.dEz), this.mController.xRr.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        i.aso();
                    }
                }, null);
                return true;
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Context applicationContext;
        String b;
        Intent intent2;
        switch (i) {
            case 2:
                if (intent != null) {
                    applicationContext = getApplicationContext();
                    as.Hm();
                    b = k.b(applicationContext, intent, c.Fp());
                    if (b != null) {
                        intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        n.JF();
                        intent2.putExtra("CropImage_OutputPath", d.x(x.Xk(q.FY()), true));
                        intent2.putExtra("CropImage_ImgPath", b);
                        com.tencent.mm.plugin.bottle.a.ihN.a(intent2, 4, this, intent);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                applicationContext = getApplicationContext();
                as.Hm();
                b = k.b(applicationContext, intent, c.Fp());
                if (b != null) {
                    intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_OutputPath", b);
                    intent2.putExtra("CropImage_ImgPath", b);
                    com.tencent.mm.plugin.bottle.a.ihN.a((Activity) this, intent2, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    b = intent.getStringExtra("CropImage_OutputPath");
                    if (b == null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BottleSettignsPersonalInfoUI", "crop picture failed");
                        return;
                    } else {
                        new p(this.mController.xRr, b).c(2, null);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final void jk(String str) {
        if (str != null && str.equals(x.Xk(q.FY()))) {
            Bitmap decodeResource;
            Bitmap a = b.a(str, false, -1);
            if (a == null) {
                a = b.a(q.FY(), false, -1);
            }
            if (a == null) {
                decodeResource = BitmapFactory.decodeResource(getResources(), R.g.bBC);
            } else {
                decodeResource = a;
            }
            ((HeadImgPreference) this.inW.Zu("bottle_settings_change_avatar")).O(decodeResource);
        }
    }
}
