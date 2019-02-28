package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ax.i;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.List;

public class BindFacebookUI extends MMWizardActivity implements e {
    private OnCancelListener kbY;
    private c xWa;
    private ProgressDialog xWb;
    private g xWc;

    private final class a implements com.tencent.mm.ui.f.a.c.a {
        private a() {
        }

        /* synthetic */ a(BindFacebookUI bindFacebookUI, byte b) {
            this();
        }

        public final void k(Bundle bundle) {
            x.d("MicroMsg.BindFacebookUI", "token:" + BindFacebookUI.this.xWa.ytm);
            as.Hm();
            com.tencent.mm.y.c.Db().set(65830, BindFacebookUI.this.xWa.ytm);
            if (BindFacebookUI.this.xWa.zkX != 0) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(65832, Long.valueOf(BindFacebookUI.this.xWa.zkX));
            }
            BindFacebookUI.this.xWb = ProgressDialog.show(BindFacebookUI.this, BindFacebookUI.this.getString(R.l.dGZ), BindFacebookUI.this.getString(R.l.eeq), true);
            BindFacebookUI.this.xWb.setOnCancelListener(BindFacebookUI.this.kbY);
            BindFacebookUI.this.xWc = new g(1, BindFacebookUI.this.xWa.ytm);
            as.CN().a(BindFacebookUI.this.xWc, 0);
            BindFacebookUI.mg(true);
        }

        public final void a(d dVar) {
            x.d("MicroMsg.BindFacebookUI", "onFacebookError:" + dVar.zle);
            h.b(BindFacebookUI.this, dVar.getMessage(), BindFacebookUI.this.getString(R.l.dVe), true);
            BindFacebookUI.mg(false);
        }

        public final void a(b bVar) {
            x.d("MicroMsg.BindFacebookUI", "onError:" + bVar.getMessage());
            h.b(BindFacebookUI.this, bVar.getMessage(), BindFacebookUI.this.getString(R.l.dVe), true);
            BindFacebookUI.mg(false);
        }

        public final void onCancel() {
            x.d("MicroMsg.BindFacebookUI", "onCancel");
            BindFacebookUI.mg(false);
        }
    }

    static /* synthetic */ void mg(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.ax.i.a(32, z ? "0" : "1"));
        as.Hm();
        com.tencent.mm.y.c.Fe().b(new i(arrayList));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        as.CN().a(183, (e) this);
        initView();
    }

    protected void onPause() {
        super.onPause();
        as.CN().b(183, (e) this);
    }

    protected final int getLayoutId() {
        return R.i.dbh;
    }

    protected final void initView() {
        this.xWa = new c("290293790992170");
        this.kbY = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (BindFacebookUI.this.xWc != null) {
                    as.CN().c(BindFacebookUI.this.xWc);
                }
            }
        };
        addTextOptionMenu(0, getString(R.l.dFF), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindFacebookUI.this.En(1);
                return true;
            }
        });
        setMMTitle(R.l.dKJ);
        TextView textView = (TextView) findViewById(R.h.cLV);
        textView.setVisibility(4);
        textView.setText(R.l.dKI);
        Button button = (Button) findViewById(R.h.bNd);
        button.setVisibility(0);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BindFacebookUI.this.xWa.a(BindFacebookUI.this, FacebookAuthUI.xWt, new a(BindFacebookUI.this, (byte) 0));
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 183) {
            if (this.xWb != null) {
                this.xWb.dismiss();
            }
            if (!com.tencent.mm.plugin.c.a.ihO.a(this.mController.xRr, i, i2, str)) {
                int i3 = ((g) kVar).opType;
                if (i == 0 && i2 == 0) {
                    if (i3 == 1) {
                        as.Hm();
                        com.tencent.mm.y.c.Fk().XE("facebookapp");
                        as.Hm();
                        com.tencent.mm.y.c.Fh().Fj("facebookapp");
                    }
                    En(1);
                } else if (i == 4 && i2 == -67) {
                    Toast.makeText(this, R.l.ees, 1).show();
                } else if (i == 4 && i2 == -5) {
                    Toast.makeText(this, i3 == 1 ? R.l.eeo : R.l.eet, 1).show();
                } else {
                    Toast.makeText(this, i3 == 0 ? R.l.dVh : R.l.dVe, 1).show();
                }
            }
        }
    }
}
