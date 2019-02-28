package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.MMAutoAdjustTextView;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CleanChattingDetailUI extends MMActivity implements h {
    private ProgressDialog inI;
    private int index;
    private View krT;
    CheckBox krV;
    private GridHeadersGridView lml;
    MMAutoAdjustTextView lmn;
    private Button lmo;
    private b lnw;
    private b lnx;
    private e lny;

    static /* synthetic */ void b(CleanChattingDetailUI cleanChattingDetailUI) {
        if (d.ayP() != null) {
            Object arrayList = new ArrayList();
            arrayList.addAll(cleanChattingDetailUI.lnw.krN);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                arrayList2.add(cleanChattingDetailUI.lnx.lkR.get(intValue));
                cleanChattingDetailUI.lnx.lkR.remove(intValue);
            }
            if (!cleanChattingDetailUI.lnx.ayH()) {
                d.ayR().remove(cleanChattingDetailUI.index);
                x.i("MicroMsg.CleanChattingDetailUI", "Delete username=%s", cleanChattingDetailUI.lnx.username);
            }
            cleanChattingDetailUI.lnw.azf();
            cleanChattingDetailUI.lnw.notifyDataSetChanged();
            if (cleanChattingDetailUI.lny != null) {
                cleanChattingDetailUI.lny.aza();
            }
            cleanChattingDetailUI.lny = new e(d.ayP(), cleanChattingDetailUI, arrayList2);
            cleanChattingDetailUI.lny.start();
            cleanChattingDetailUI.inI.show();
            cleanChattingDetailUI.inI.setMessage(cleanChattingDetailUI.getString(R.l.dTX, new Object[]{"0%"}));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.ayY();
        this.index = getIntent().getIntExtra("key_position", -1);
        if (this.index < 0) {
            finish();
        } else if (d.ayR() == null) {
            finish();
        } else {
            this.krT = findViewById(R.h.bKf);
            this.krV = (CheckBox) findViewById(R.h.bKe);
            this.lmn = (MMAutoAdjustTextView) findViewById(R.h.caP);
            this.lmo = (Button) findViewById(R.h.bBF);
            oF(0);
            this.lnx = (b) d.ayR().get(this.index);
            if (s.eX(this.lnx.username)) {
                setMMTitle(r.L(this.lnx.username, this.lnx.username));
            } else {
                setMMTitle(r.gw(this.lnx.username));
            }
            this.lml = (GridHeadersGridView) findViewById(R.h.bWd);
            this.lml.setNumColumns(3);
            this.lnw = new b(this, this.lnx.lkR);
            this.lml.zob = this.lnw.llZ;
            this.lml.setOnItemClickListener(this.lnw.kMo);
            this.lml.setOnScrollListener(this.lnw.lmb);
            this.lml.setAdapter(this.lnw);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    CleanChattingDetailUI.this.finish();
                    return false;
                }
            });
            this.krT.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    b a = CleanChattingDetailUI.this.lnw;
                    if (a.krN.size() == a.jRO.size()) {
                        a.krN.clear();
                    } else {
                        for (int i = 0; i < a.jRO.size(); i++) {
                            a.krN.add(Integer.valueOf(i));
                        }
                    }
                    a.azg();
                    CleanChattingDetailUI.this.lnw.notifyDataSetChanged();
                }
            });
            this.lmo.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.ui.base.h.a(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(R.l.dUi), "", CleanChattingDetailUI.this.getString(R.l.caM), CleanChattingDetailUI.this.getString(R.l.cancel), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            CleanChattingDetailUI.b(CleanChattingDetailUI.this);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            });
            getString(R.l.dGZ);
            this.inI = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dTM), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            this.inI.dismiss();
        }
    }

    protected final int getLayoutId() {
        return R.i.deB;
    }

    public final void oF(int i) {
        this.lmo.setEnabled(i > 0);
    }

    protected void onDestroy() {
        if (this.inI.isShowing()) {
            this.inI.dismiss();
        }
        if (this.lny != null) {
            this.lny.aza();
        }
        d.ayZ();
        d.ayX();
        super.onDestroy();
    }

    public final void cp(int i, int i2) {
        this.inI.setMessage(getString(R.l.dTX, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void bX(long j) {
        this.inI.dismiss();
        d.bV(d.ayV() + j);
        d.bS(d.ayS() - j);
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dTN, new Object[]{bi.by(j)}), "", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (CleanChattingDetailUI.this.lnx.lkR.size() == 0) {
                    CleanChattingDetailUI.this.finish();
                }
            }
        });
    }
}
