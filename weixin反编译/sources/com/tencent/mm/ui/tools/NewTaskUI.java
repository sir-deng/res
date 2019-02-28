package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.f.a.iz;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.mm.y.as;
import com.tencent.wcdb.database.SQLiteDatabase;

public class NewTaskUI extends MMBaseActivity implements e {
    static NewTaskUI zve;
    private ProgressDialog inI = null;
    private SecurityImage xSF = null;
    private c xWw = new c<iz>() {
        {
            this.xmG = iz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iz izVar = (iz) bVar;
            if (izVar == null || izVar.fAw == null) {
                return false;
            }
            x.i("MicroMsg.NewTaskUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", izVar.fAw.content, izVar.fAw.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", izVar.fAw.content);
            intent.putExtra("key_disaster_url", izVar.fAw.url);
            intent.setClass(ad.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ad.getContext().startActivity(intent);
            return true;
        }
    };
    private i zvf = new i();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.NewTaskUI", "onCreate :%d", Integer.valueOf(hashCode()));
        setContentView(R.i.daS);
        as.CN().a(701, (e) this);
        zve = this;
        final k vVar = new v(0, "", "", "");
        as.CN().a(vVar, 0);
        getString(R.l.dGZ);
        this.inI = h.a((Context) this, getString(R.l.etS), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(vVar);
            }
        });
    }

    public void onResume() {
        a.xmy.b(this.xWw);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        a.xmy.c(this.xWw);
    }

    public void onDestroy() {
        x.i("MicroMsg.NewTaskUI", "onDestroy :%d", Integer.valueOf(hashCode()));
        if (equals(zve)) {
            zve = null;
        }
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
        }
        if (this.xSF != null) {
            this.xSF.dismiss();
        }
        as.CN().b(701, (e) this);
        super.onDestroy();
    }

    public static NewTaskUI cyO() {
        return zve;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
        }
        if (i == 4 && i2 == -3) {
            x.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", Boolean.valueOf(as.Hp()));
            if (t.a(zve, i, i2, new Intent().setClass(zve, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                return;
            }
        }
        if (i == 4 && (i2 == -6 || i2 == -311 || i2 == -310)) {
            if (kVar instanceof v) {
                v vVar = (v) kVar;
                this.zvf.xXY = vVar.Sg();
                this.zvf.xXX = vVar.Ou();
                this.zvf.xXV = vVar.Ov();
                this.zvf.xXW = vVar.Sh();
                x.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.zvf.xXV + " img len" + this.zvf.xXX.length + " " + g.zo());
            }
            if (this.xSF == null) {
                this.xSF = SecurityImage.a.a(this, R.l.eEv, this.zvf.xXY, this.zvf.xXX, this.zvf.xXV, this.zvf.xXW, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.this.zvf.xXV + " img len" + NewTaskUI.this.zvf.xXX.length + " " + g.zo());
                        if (NewTaskUI.this.xSF == null) {
                            x.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
                            return;
                        }
                        final k vVar = new v(NewTaskUI.this.zvf.xXY, NewTaskUI.this.xSF.cpt(), NewTaskUI.this.xSF.xXV, NewTaskUI.this.xSF.xXW);
                        as.CN().a(vVar, 0);
                        NewTaskUI newTaskUI = NewTaskUI.this;
                        Context context = NewTaskUI.this;
                        NewTaskUI.this.getString(R.l.dGZ);
                        newTaskUI.inI = h.a(context, NewTaskUI.this.getString(R.l.etS), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(vVar);
                            }
                        });
                    }
                }, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        if (NewTaskUI.zve != null) {
                            NewTaskUI.zve = null;
                            NewTaskUI.this.finish();
                        }
                    }
                }, new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        NewTaskUI.this.xSF = null;
                    }
                }, this.zvf);
                return;
            }
            x.d("MicroMsg.NewTaskUI", "imgSid:" + this.zvf.xXV + " img len" + this.zvf.xXX.length + " " + g.zo());
            this.xSF.a(this.zvf.xXY, this.zvf.xXX, this.zvf.xXV, this.zvf.xXW);
            return;
        }
        zve = null;
        finish();
    }
}
