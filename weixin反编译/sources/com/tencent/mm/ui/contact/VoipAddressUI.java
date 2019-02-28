package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI extends MMBaseSelectContactUI {
    private List<String> koG;
    private String talker = "";
    private boolean zdZ = false;
    private boolean zea = false;
    private c zeb = new c<sr>() {
        {
            this.xmG = sr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            switch (((sr) bVar).fLl.fvG) {
                case 7:
                    VoipAddressUI.this.finish();
                    break;
                case 8:
                    VoipAddressUI.this.finish();
                    break;
            }
            return false;
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.xmy.b(this.zeb);
    }

    public final void jd(int i) {
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) this.pxs.getAdapter().getItem(i);
        if (aVar != null && aVar.jQP != null) {
            this.talker = aVar.jQP.field_username;
            if (this.zea) {
                bkj();
            } else {
                bki();
            }
        }
    }

    private void bki() {
        x.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), bi.chl(), this);
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            b srVar = new sr();
            srVar.fLl.fvG = 5;
            srVar.fLl.talker = this.talker;
            srVar.fLl.context = this;
            int i = this.zdZ ? 2 : 1;
            srVar.fLl.fLg = 3;
            g.pWK.h(11033, Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0));
            a.xmy.m(srVar);
            aWY();
        }
    }

    private void bkj() {
        x.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 19, "", "")), bi.chl(), this);
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 19, "", "")) {
            x.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), bi.chl(), this);
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "")) {
                b srVar = new sr();
                srVar.fLl.fvG = 5;
                srVar.fLl.talker = this.talker;
                srVar.fLl.context = this;
                int i = this.zdZ ? 2 : 1;
                srVar.fLl.fLg = 2;
                g.pWK.h(11033, Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0));
                a.xmy.m(srVar);
                aWY();
            }
        }
    }

    protected final void Xc() {
        super.Xc();
        String stringExtra = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
        this.zea = getIntent().getBooleanExtra("voip_video", true);
        if (stringExtra != null) {
            this.zdZ = true;
            if (stringExtra.equals("launch_type_voip")) {
                this.zea = true;
            } else if (stringExtra.equals("launch_type_voip_audio")) {
                this.zea = false;
            }
        }
        this.koG = new ArrayList();
        this.koG.addAll(s.cwZ());
        this.koG.addAll(s.cxa());
    }

    protected final o Xg() {
        c.a aVar = new c.a();
        aVar.yZR = true;
        aVar.yZQ = true;
        return new c(this, this.koG, false, aVar);
    }

    protected final m Xh() {
        return new q(this, this.koG, false, this.scene);
    }

    public static void fS(Context context) {
        int i = 0;
        boolean z = 1 == bi.getInt(com.tencent.mm.j.g.Af().getValue("VOIPCallType"), 0);
        Intent intent = new Intent(context, VoipAddressUI.class);
        intent.putExtra("Add_address_titile", context.getString(R.l.dDz));
        intent.putExtra("voip_video", z);
        context.startActivity(intent);
        g gVar = g.pWK;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(1);
        if (!z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        gVar.h(11034, objArr);
    }

    protected final boolean Xe() {
        return true;
    }

    public final int[] aYB() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public void onDestroy() {
        a.xmy.c(this.zeb);
        super.onDestroy();
    }

    protected final void aYC() {
        if (this.zdZ) {
            Intent intent = new Intent(this, LauncherUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
        }
        aWY();
        finish();
    }

    protected final String Xf() {
        String stringExtra = getIntent().getStringExtra("Add_address_titile");
        if (bi.oN(stringExtra)) {
            return stringExtra;
        }
        return getString(R.l.dDz);
    }

    protected final boolean Xd() {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.VoipAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    bkj();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.ezZ : R.l.eAd;
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(i2), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            VoipAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            case 82:
                if (iArr[0] == 0) {
                    bki();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.eAc), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            VoipAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }
}
