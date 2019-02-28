package com.tencent.mm.plugin.clean.ui.newui;

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class CleanChattingUI extends MMActivity implements h {
    private ProgressDialog inI;
    private View krT;
    private CheckBox krV;
    private TextView krW;
    private Button lmo;
    private ListView lmu;
    private TextView lmv;
    private a lnB;
    private e lny;

    static /* synthetic */ void a(CleanChattingUI cleanChattingUI) {
        if (d.ayP() != null) {
            Object arrayList = new ArrayList();
            arrayList.addAll(cleanChattingUI.lnB.krN);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (intValue < d.ayR().size()) {
                    arrayList2.addAll(((b) d.ayR().get(intValue)).lkR);
                    d.ayR().remove(intValue);
                }
            }
            cleanChattingUI.lnB.azf();
            cleanChattingUI.lnB.notifyDataSetChanged();
            if (cleanChattingUI.lny != null) {
                cleanChattingUI.lny.aza();
            }
            cleanChattingUI.lny = new e(d.ayP(), cleanChattingUI, arrayList2);
            cleanChattingUI.lny.start();
            cleanChattingUI.inI.show();
            cleanChattingUI.inI.setMessage(cleanChattingUI.getString(R.l.dTX, new Object[]{"0%"}));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.ayY();
        x.i("MicroMsg.CleanChattingUI", "Create!!");
        setMMTitle(R.l.dTZ);
        this.lmu = (ListView) findViewById(R.h.bWe);
        this.lnB = new a(this);
        this.lmu.setAdapter(this.lnB);
        this.lmu.setEmptyView(findViewById(R.h.cew));
        this.krT = findViewById(R.h.bKf);
        this.lmv = (TextView) findViewById(R.h.caP);
        this.krV = (CheckBox) findViewById(R.h.bKe);
        this.krW = (TextView) findViewById(R.h.bKd);
        if (!w.cfR()) {
            this.lmv.setTextSize(1, 14.0f);
            this.krW.setTextSize(1, 14.0f);
        }
        this.lmo = (Button) findViewById(R.h.bBF);
        this.lmo.setEnabled(false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CleanChattingUI.this.finish();
                return false;
            }
        });
        this.lmu.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
                intent.putExtra("key_position", i);
                CleanChattingUI.this.startActivityForResult(intent, 0);
            }
        });
        this.lmo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.ui.base.h.a(CleanChattingUI.this, CleanChattingUI.this.getString(R.l.dUh), "", CleanChattingUI.this.getString(R.l.caM), CleanChattingUI.this.getString(R.l.cancel), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CleanChattingUI.a(CleanChattingUI.this);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        this.krT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                a b = CleanChattingUI.this.lnB;
                if (b.krN.size() == b.getCount()) {
                    b.krN.clear();
                } else {
                    for (int i = 0; i < b.getCount(); i++) {
                        b.krN.add(Integer.valueOf(i));
                    }
                }
                b.notifyDataSetChanged();
                b.lns.a(b.krN);
            }
        });
        getString(R.l.dGZ);
        this.inI = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dTM), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.inI.dismiss();
    }

    public final void a(HashSet<Integer> hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < d.ayR().size()) {
                i = (int) (((b) d.ayR().get(intValue)).fxb + ((long) i));
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || i > 0) {
            this.lmv.setText(getString(R.l.dYF, new Object[]{bi.by((long) i)}));
            this.lmo.setEnabled(true);
            if (hashSet.size() == this.lnB.getCount()) {
                this.krV.setChecked(true);
                return;
            } else {
                this.krV.setChecked(false);
                return;
            }
        }
        this.lmv.setText("");
        this.lmo.setEnabled(false);
        this.krV.setChecked(false);
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

    protected final int getLayoutId() {
        return R.i.deD;
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
                if (d.ayR() != null && d.ayR().size() == 0) {
                    CleanChattingUI.this.finish();
                }
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.lnB.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
    }
}
