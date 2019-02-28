package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.f;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.clean.ui.PieView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.HashSet;

public class CleanMsgUI extends MMActivity {
    private ProgressDialog inI;
    private View lmB;
    private PieView lmC;
    private TextView lmD;
    private Button lmE;
    private Button lmF;
    private TextView lmG;
    private TextView lmH;
    private TextView lmI;
    private TextView lmJ;
    private View lmK;
    private TextView lmL;
    private TextView lmM;
    private TextView lmN;
    private TextView lmO;
    private TextView lmP;
    private TextView lmQ;
    private LinearLayout lmR;

    static /* synthetic */ void a(CleanMsgUI cleanMsgUI, HashSet hashSet) {
        x.i("MicroMsg.CleanMsgUI", "%d begin deleteOtherAcc", Integer.valueOf(cleanMsgUI.hashCode()));
        g.pWK.a(714, 11, 1, false);
        new f(hashSet, new h() {
            public final void cp(int i, int i2) {
                CleanMsgUI.this.inI.setMessage(CleanMsgUI.this.getString(R.l.dTX, new Object[]{((i * 100) / i2) + "%"}));
            }

            public final void bX(final long j) {
                x.i("MicroMsg.CleanMsgUI", "onDeleteEnd %d ", Long.valueOf(j));
                ah.y(new Runnable() {
                    public final void run() {
                        long j = 0;
                        if (CleanMsgUI.this.inI != null) {
                            CleanMsgUI.this.inI.dismiss();
                        }
                        long j2 = j.azc().lkJ;
                        long j3 = j.azc().lkJ - j;
                        if (j3 < 0) {
                            j2 = j.azc().lkH - j2;
                        } else {
                            j2 = j.azc().lkH - j;
                            j = j3;
                        }
                        j.azc().lkJ = j;
                        j.azc().lkH = j2;
                        CleanMsgUI.this.c(j.azc().lkH, j.azc().lkI, j.azc().lkJ);
                    }
                });
                g.pWK.a(714, 13, 1, false);
            }
        }).start();
        cleanMsgUI.inI.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.pWK.a(714, 10, 1, false);
        this.lmD = (TextView) findViewById(R.h.cDA);
        this.lmC = (PieView) findViewById(R.h.cCJ);
        this.lmE = (Button) findViewById(R.h.bWc);
        this.lmF = (Button) findViewById(R.h.bWg);
        this.lmB = findViewById(R.h.bKg);
        this.lmG = (TextView) findViewById(R.h.cZr);
        this.lmG.setTextSize(1, 16.0f);
        this.lmH = (TextView) findViewById(R.h.cBZ);
        this.lmH.setTextSize(1, 16.0f);
        this.lmI = (TextView) findViewById(R.h.cCc);
        this.lmI.setTextSize(1, 16.0f);
        this.lmJ = (TextView) findViewById(R.h.cji);
        this.lmJ.setTextSize(1, 16.0f);
        this.lmL = (TextView) findViewById(R.h.bWf);
        this.lmM = (TextView) findViewById(R.h.bWh);
        this.lmQ = (TextView) findViewById(R.h.car);
        this.lmR = (LinearLayout) findViewById(R.h.cas);
        this.lmN = (TextView) findViewById(R.h.cZv);
        this.lmO = (TextView) findViewById(R.h.cCa);
        this.lmP = (TextView) findViewById(R.h.cCe);
        this.lmK = findViewById(R.h.cBY);
        setMMTitle(R.l.dTT);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CleanMsgUI.this.finish();
                return false;
            }
        });
        this.lmF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.ui.base.h.a(CleanMsgUI.this, CleanMsgUI.this.getString(R.l.dTV, new Object[]{bi.fL(j.azc().lkJ)}), "", CleanMsgUI.this.getString(R.l.dGf), CleanMsgUI.this.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CleanMsgUI.a(CleanMsgUI.this, j.azc().lli);
                    }
                }, null, R.e.btC);
            }
        });
        this.lmE.setEnabled(true);
        this.lmE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                CleanMsgUI.this.startActivityForResult(new Intent(CleanMsgUI.this, CleanChattingUI.class), 0);
                g.pWK.a(714, 12, 1, false);
            }
        });
        getString(R.l.dGZ);
        this.inI = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dTM), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.inI.dismiss();
        c(j.azc().lkH, j.azc().lkI, j.azc().lkJ);
    }

    protected final int getLayoutId() {
        return R.i.deF;
    }

    private void c(long j, long j2, long j3) {
        int i;
        if (j <= 0) {
            j = 1;
            g.pWK.a(714, 61, 1, false);
        }
        int i2 = (int) ((360 * j2) / j);
        if (j2 <= 0 || i2 >= 5) {
            i = i2;
        } else {
            i = 5;
        }
        i2 = 0;
        if (j3 > 0) {
            i2 = (int) ((360 * j3) / j);
            if (i2 < 5) {
                i2 = 5;
            }
        }
        long j4 = (j - j2) - j3;
        int i3 = (int) ((100 * j2) / j);
        int i4 = (int) ((100 * j3) / j);
        int i5 = (int) ((100 * j4) / j);
        x.i("MicroMsg.CleanMsgUI", "update acc[%d %d] otherAcc[%d %d] other[%d %d] wechat[%d] stack[%s]", Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j), bi.chl());
        this.lmC.llR = i;
        this.lmC.llT = i2;
        this.lmC.fCn = 1;
        this.lmB.setVisibility(0);
        this.lmG.setText(bi.by(j2));
        this.lmH.setText(bi.by(j3));
        this.lmI.setText(bi.by(j4));
        if (j3 > 0) {
            this.lmK.setVisibility(0);
            this.lmF.setEnabled(true);
        } else {
            this.lmF.setEnabled(false);
            this.lmK.setVisibility(0);
        }
        this.lmN.setText(getString(R.l.dTK));
        this.lmO.setText(getString(R.l.dTU));
        this.lmP.setText(getString(R.l.dTW));
        if (((Integer) com.tencent.mm.kernel.g.Dq().Db().get(a.USERINFO_CALC_WX_SCAN_SHOW_FILE_INT, Integer.valueOf(0))).intValue() > 0) {
            this.lmR.setVisibility(0);
            this.lmQ.setVisibility(0);
            TextView textView = this.lmQ;
            HashMap hashMap = j.azc().llu;
            StringBuffer stringBuffer = new StringBuffer();
            if (!hashMap.isEmpty()) {
                for (String str : hashMap.keySet()) {
                    stringBuffer.append(str).append(" : ").append(bi.by(((Long) hashMap.get(str)).longValue())).append("\n");
                }
            }
            textView.setText(stringBuffer.toString());
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        c(j.azc().lkH, j.azc().lkI, j.azc().lkJ);
    }
}
