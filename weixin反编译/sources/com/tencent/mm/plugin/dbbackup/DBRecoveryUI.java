package com.tencent.mm.plugin.dbbackup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.dbbackup.a.a;
import com.tencent.mm.plugin.dbbackup.a.a.b;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Arrays;

public class DBRecoveryUI extends MMActivity implements b {
    private static final int[] lvq = new int[]{0, 5, 70, 80, 90, 100, 100};
    private int itU;
    private a lvh;
    private View lvi;
    private View lvj;
    private ProgressBar lvk;
    private TextView lvl;
    private View lvm;
    private int lvn;
    private boolean lvo;
    private OnClickListener lvp = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            if (DBRecoveryUI.this.itU != 0) {
                DBRecoveryUI.this.lvi.setVisibility(0);
                DBRecoveryUI.this.lvj.setVisibility(8);
                return;
            }
            d.aAn();
        }
    };

    static /* synthetic */ void e(DBRecoveryUI dBRecoveryUI) {
        if (dBRecoveryUI.lvh != null) {
            x.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
            return;
        }
        StringBuilder append = new StringBuilder().append(q.yL());
        g.Do();
        byte[] bytes = append.append(com.tencent.mm.kernel.a.Cn()).toString().getBytes();
        String CX = g.Dq().CX();
        String path = g.Dq().gRU.getPath();
        String str = path + "-recovery";
        dBRecoveryUI.lvn = 0;
        String str2 = g.Dq().gRT + "dbback/";
        a.a aVar = new a.a();
        aVar.lwu = dBRecoveryUI;
        aVar.lwr = com.tencent.mm.a.g.t(bytes);
        aVar.lws = com.tencent.mm.a.g.s(bytes).substring(0, 7).getBytes();
        aVar.lwn = CX;
        aVar.lwm = path;
        aVar.lwl = str;
        aVar.lwo = g.Dq().cachePath + "heavyDetailInfo";
        aVar.lwt = dBRecoveryUI.itU == 0;
        a.a yf = aVar.ye(CX + ".sm").yf(CX + ".bak").ye(str2 + "corrupted/EnMicroMsg.db.sm").yf(str2 + "corrupted/EnMicroMsg.db.bak").ye(str2 + "EnMicroMsg.db.sm").yf(str2 + "EnMicroMsg.db.bak");
        a aVar2 = new a();
        aVar2.lwl = yf.lwl;
        aVar2.lwm = yf.lwm;
        aVar2.lwn = yf.lwn;
        aVar2.lwo = yf.lwo;
        aVar2.lwp = new ArrayList(yf.lwp);
        aVar2.lwq = new ArrayList(yf.lwq);
        aVar2.lwr = Arrays.copyOf(yf.lwr, yf.lwr.length);
        aVar2.lws = Arrays.copyOf(yf.lws, yf.lws.length);
        aVar2.lwt = yf.lwt;
        aVar2.lwu = yf.lwu;
        dBRecoveryUI.lvh = aVar2;
        dBRecoveryUI.lvh.execute(new Void[0]);
        dBRecoveryUI.lvo = true;
    }

    static /* synthetic */ void f(DBRecoveryUI dBRecoveryUI) {
        if (dBRecoveryUI.lvh != null) {
            dBRecoveryUI.lvh.mCancellationSignal.cancel();
            x.i("MicroMsg.DBRecoveryTask", "Recovery cancel triggered.");
            dBRecoveryUI.lvh = null;
            return;
        }
        x.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.itU = getIntent().getIntExtra("scene", 2);
        this.lvo = false;
        setMMTitle(R.l.dYl);
        this.lvi = findViewById(R.h.cPo);
        this.lvj = findViewById(R.h.ccu);
        this.lvk = (ProgressBar) findViewById(R.h.cEf);
        this.lvl = (TextView) findViewById(R.h.cEi);
        View findViewById = findViewById(R.h.cPl);
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (g.Dq().CX() == null) {
                    h.h(DBRecoveryUI.this, R.l.dYo, R.l.dGZ);
                    return;
                }
                DBRecoveryUI.this.lvi.setVisibility(8);
                DBRecoveryUI.this.lvj.setVisibility(0);
                DBRecoveryUI.this.lvm.setEnabled(true);
                DBRecoveryUI.e(DBRecoveryUI.this);
            }
        });
        this.lvm = findViewById(R.h.bPp);
        this.lvm.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DBRecoveryUI.this.lvm.setEnabled(false);
                DBRecoveryUI.f(DBRecoveryUI.this);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (DBRecoveryUI.this.lvo) {
                    DBRecoveryUI.this.lvm.callOnClick();
                } else {
                    DBRecoveryUI.this.finish();
                }
                return true;
            }
        });
        if (this.itU == 0) {
            findViewById.callOnClick();
        }
        d.pVE.a(181, (long) (this.itU + 51), 1, true);
    }

    public void onBackPressed() {
        if (this.lvo) {
            this.lvm.callOnClick();
        } else {
            finish();
        }
    }

    protected final int getLayoutId() {
        return R.i.dfv;
    }

    public final void I(int i, int i2, int i3) {
        float f = 1.0f;
        if (i > 0 && i <= 6) {
            if (i3 > 0) {
                int i4 = lvq[i - 1];
                int i5 = lvq[i] - i4;
                float f2 = ((float) i2) / ((float) i3);
                if (f2 <= 1.0f) {
                    f = f2;
                }
                this.lvk.setProgress((int) ((f * ((float) i5)) + ((float) i4)));
            } else if (this.lvn != i) {
                this.lvk.setProgress(lvq[i - 1]);
            }
            this.lvn = i;
            String str = getResources().getStringArray(R.c.bqO)[i - 1];
            this.lvl.setText(String.format(str, new Object[]{Integer.valueOf(i2)}));
        }
    }

    public final void r(long j, long j2) {
        this.lvo = false;
        aAj();
        h.a((Context) this, getString(R.l.dYp, new Object[]{Long.valueOf((j2 / 1024) / 1024), Long.valueOf((j / 1024) / 1024)}), getString(R.l.cSb), false, this.lvp);
    }

    public final void onSuccess() {
        this.lvo = false;
        final i a = h.a((Context) this, R.l.dYq, R.l.dGZ, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                DBRecoveryUI.this.finish();
                d.aAn();
            }
        });
        ah.h(new Runnable() {
            public final void run() {
                a.dismiss();
                DBRecoveryUI.this.finish();
                d.aAn();
            }
        }, 5000);
    }

    public final void aAi() {
        this.lvo = false;
        aAj();
        h.a((Context) this, R.l.dYm, R.l.cSb, false, this.lvp);
    }

    public final void afW() {
        this.lvo = false;
        aAj();
        h.a((Context) this, R.l.dYn, R.l.cSb, false, this.lvp);
    }

    private static void aAj() {
        t Db = g.Dq().Db();
        Db.set(89, Integer.valueOf(2));
        Db.lO(true);
    }
}
