package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
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
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanChattingUI extends MMActivity implements h {
    private List<c> dataList = new ArrayList();
    private ProgressDialog inI;
    private View krT;
    private CheckBox krV;
    private TextView krW;
    private Button lmo;
    private a lmt;
    private ListView lmu;
    private TextView lmv;
    private TextView lmw;
    private boolean lmx = false;

    static /* synthetic */ void b(CleanChattingUI cleanChattingUI) {
        Object arrayList = new ArrayList();
        arrayList.addAll(cleanChattingUI.lmt.krN);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            c oC = cleanChattingUI.lmt.oC(intValue);
            if (oC != null) {
                arrayList2.add(oC.username);
                cleanChattingUI.dataList.remove(intValue);
            }
        }
        cleanChattingUI.lmt.azf();
        cleanChattingUI.lmt.notifyDataSetChanged();
        e.post(new b(arrayList2, null, cleanChattingUI), "delete-clean");
        cleanChattingUI.inI.setMessage(cleanChattingUI.getString(R.l.dTX, new Object[]{"0%"}));
        cleanChattingUI.inI.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CleanChattingUI", "Create!!");
        setMMTitle(R.l.dTT);
        this.lmu = (ListView) findViewById(R.h.bWe);
        this.lmt = new a(this, this.dataList);
        this.lmu.setAdapter(this.lmt);
        this.lmu.setEmptyView(findViewById(R.h.cew));
        this.lmw = (TextView) findViewById(R.h.ces);
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
                c oC = CleanChattingUI.this.lmt.oC(i);
                if (oC != null) {
                    Intent intent = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
                    intent.putExtra("key_username", oC.username);
                    intent.putExtra("key_pos", i);
                    CleanChattingUI.this.startActivityForResult(intent, 0);
                    g.pWK.a(714, 21, 1, false);
                }
            }
        });
        this.lmo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.ui.base.h.a(CleanChattingUI.this, CleanChattingUI.this.getString(R.l.dUh), "", CleanChattingUI.this.getString(R.l.caM), CleanChattingUI.this.getString(R.l.cancel), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CleanChattingUI.b(CleanChattingUI.this);
                        g.pWK.a(714, 22, 1, false);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        this.krT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                a a = CleanChattingUI.this.lmt;
                if (a.krN.size() == a.getCount()) {
                    a.krN.clear();
                } else {
                    for (int i = 0; i < a.getCount(); i++) {
                        a.krN.add(Integer.valueOf(i));
                    }
                }
                a.notifyDataSetChanged();
                a.llV.a(a.krN);
            }
        });
        getString(R.l.dGZ);
        this.inI = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dTM), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.inI.dismiss();
        g.pWK.a(714, 20, 1, false);
    }

    public final void a(HashSet<Integer> hashSet) {
        if (this.lmt == null) {
            x.w("MicroMsg.CleanChattingUI", "on click check box but adapter is null");
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            c oC = this.lmt.oC(intValue);
            if (oC != null) {
                j = oC.size + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            this.lmv.setText(getString(R.l.dYF, new Object[]{bi.by(j)}));
            this.lmo.setEnabled(true);
            if (hashSet.size() == this.lmt.getCount()) {
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
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.lmt != null && this.dataList.isEmpty()) {
            com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                public final void run() {
                    if (!CleanChattingUI.this.lmx) {
                        x.i("MicroMsg.CleanChattingUI", "load contact cursor now");
                        CleanChattingUI.this.lmx = true;
                        ah.y(new Runnable() {
                            public final void run() {
                                CleanChattingUI.this.lmw.setText(CleanChattingUI.this.getString(R.l.dDS, new Object[]{" "}));
                            }
                        });
                        Cursor aty = com.tencent.mm.plugin.i.b.atn().ato().aty();
                        if (aty != null) {
                            while (aty.moveToNext()) {
                                c cVar = new c();
                                cVar.username = aty.getString(0);
                                cVar.size = aty.getLong(1);
                                CleanChattingUI.this.dataList.add(cVar);
                            }
                        }
                        ah.y(new Runnable() {
                            public final void run() {
                                CleanChattingUI.this.lmt.notifyDataSetChanged();
                                CleanChattingUI.this.lmw.setText(R.l.dTL);
                            }
                        });
                    }
                }
            });
        }
    }

    protected final int getLayoutId() {
        return R.i.deD;
    }

    public final void cp(final int i, final int i2) {
        ah.y(new Runnable() {
            public final void run() {
                CleanChattingUI.this.inI.setMessage(CleanChattingUI.this.getString(R.l.dTX, new Object[]{((i * 100) / i2) + "%"}));
            }
        });
    }

    public final void bX(final long j) {
        x.i("MicroMsg.CleanChattingUI", "%s onDeleteEnd [%d] ", hashCode(), Long.valueOf(j));
        j.azc().lkI -= j;
        j.azc().lkH -= j;
        ah.y(new Runnable() {
            public final void run() {
                CleanChattingUI.this.inI.dismiss();
                com.tencent.mm.ui.base.h.b(CleanChattingUI.this, CleanChattingUI.this.getString(R.l.dTN, new Object[]{bi.by(j)}), "", true);
                CleanChattingUI.this.lmw.setText(CleanChattingUI.this.getString(R.l.dDS, new Object[]{" "}));
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("key_pos", -1);
            long longExtra = intent.getLongExtra("key_delete_size", 0);
            if (intExtra > 0 && intExtra < this.dataList.size()) {
                c cVar = (c) this.dataList.get(intExtra);
                if (cVar != null) {
                    if (cVar.size == longExtra) {
                        this.dataList.remove(intExtra);
                    } else {
                        cVar.size -= longExtra;
                    }
                }
            }
        }
        this.lmt.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
    }
}
