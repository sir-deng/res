package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MassSendSelectContactUI extends MMBaseSelectContactUI {
    private HashSet<String> ikQ;
    private List<String> koG;
    private Button otD;
    private boolean otE;
    private MultiSelectContactView otF;

    protected final void Xc() {
        super.Xc();
        this.koG = new ArrayList();
        this.koG.addAll(s.cwZ());
        this.koG.addAll(s.cxa());
        this.koG.add(q.FY());
        this.ikQ = new HashSet();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.MassSendSelectContactUI", "create!");
        this.otF = this.otF;
        if (this.otF == null) {
            finish();
            return;
        }
        this.otF.setBackgroundDrawable(null);
        a(1, getString(R.l.cvu), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                x.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
                List F = bi.F((String[]) MassSendSelectContactUI.this.ikQ.toArray(new String[0]));
                if (F == null) {
                    x.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
                    return false;
                }
                F.remove(q.FY());
                String d = bi.d(F, ";");
                Intent intent = new Intent(MassSendSelectContactUI.this, MassSendMsgUI.class);
                intent.putExtra("mass_send_contact_list", d);
                MassSendSelectContactUI.this.startActivity(intent);
                return true;
            }
        }, b.xSe);
        this.otD = (Button) findViewById(R.h.cKI);
        this.otD.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z;
                x.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
                n nVar = (n) ((HeaderViewListAdapter) MassSendSelectContactUI.this.pxs.getAdapter()).getWrappedAdapter();
                if (MassSendSelectContactUI.this.otE) {
                    MassSendSelectContactUI.this.otD.setText(R.l.euZ);
                    Iterator it = MassSendSelectContactUI.this.ikQ.iterator();
                    while (it.hasNext()) {
                        MassSendSelectContactUI.this.otF.SL((String) it.next());
                    }
                    MassSendSelectContactUI.this.ikQ.clear();
                } else {
                    MassSendSelectContactUI.this.otD.setText(R.l.euS);
                    int count = nVar.getCount();
                    for (int i = 0; i < count; i++) {
                        a GF = nVar.GF(i);
                        if (!(GF == null || GF.jQP == null || MassSendSelectContactUI.this.ikQ.contains(GF.jQP.field_username))) {
                            MassSendSelectContactUI.this.ikQ.add(GF.jQP.field_username);
                            MassSendSelectContactUI.this.otF.SL(GF.jQP.field_username);
                        }
                    }
                }
                MassSendSelectContactUI massSendSelectContactUI = MassSendSelectContactUI.this;
                if (MassSendSelectContactUI.this.otE) {
                    z = false;
                } else {
                    z = true;
                }
                massSendSelectContactUI.otE = z;
                MassSendSelectContactUI.this.sK(MassSendSelectContactUI.this.ikQ.size());
                nVar.notifyDataSetChanged();
            }
        });
        this.otF.vrh = new MultiSelectContactView.a() {
            public final void oW(String str) {
                if (str != null) {
                    MassSendSelectContactUI.this.ikQ.remove(str);
                    MassSendSelectContactUI.this.sK(MassSendSelectContactUI.this.ikQ.size());
                }
            }
        };
        sK(this.ikQ.size());
    }

    private void sK(int i) {
        if (i > 0) {
            updateOptionMenuText(1, getString(R.l.cvu) + "(" + this.ikQ.size() + ")");
            enableOptionMenu(1, true);
            return;
        }
        updateOptionMenuText(1, getString(R.l.cvu));
        enableOptionMenu(1, false);
    }

    protected final void ET(String str) {
        g.pWK.h(11225, Integer.valueOf(1), Integer.valueOf(0));
        Intent intent = new Intent();
        intent.putExtra("label", str);
        intent.putExtra("always_select_contact", bi.d(new ArrayList(this.ikQ), ","));
        intent.putExtra("list_attr", s.p(16384, 64));
        d.a((Context) this, ".ui.contact.SelectLabelContactUI", intent, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            switch (i) {
                case 0:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (bi.oN(stringExtra)) {
                        x.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    x.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        String str = split[i3];
                        if (this.ikQ.add(str)) {
                            this.otF.SL(str);
                        }
                        i3++;
                    }
                    sK(this.ikQ.size());
                    cwP().notifyDataSetChanged();
                    if (this.liK != null) {
                        this.liK.clearFocus();
                        this.liK.cyP();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dnl;
    }

    public final void jd(int i) {
        n cwP = cwP();
        a GF = cwP.GF(i - this.pxs.getHeaderViewsCount());
        if (GF != null && GF.jQP != null) {
            x.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", GF.jQP.field_username);
            String str = GF.jQP.field_username;
            cwV();
            if (this.ikQ.contains(str)) {
                this.ikQ.remove(str);
                this.otF.SL(str);
            } else {
                this.ikQ.add(str);
                this.otF.SL(str);
            }
            sK(this.ikQ.size());
            cwP.notifyDataSetChanged();
            cwV();
            cwW();
        }
    }

    protected final boolean Xd() {
        return false;
    }

    protected final boolean Xe() {
        return true;
    }

    protected final String Xf() {
        return getString(R.l.eva);
    }

    protected final o Xg() {
        c.a aVar = new c.a();
        aVar.yZR = true;
        return new c(this, this.koG, true, aVar);
    }

    protected final m Xh() {
        return new com.tencent.mm.ui.contact.q(this, this.koG, true, this.scene);
    }

    public final boolean a(a aVar) {
        if (!aVar.zbR || aVar.jQP == null) {
            return false;
        }
        return this.ikQ.contains(aVar.jQP.field_username);
    }

    public final int[] aYB() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    protected final boolean aZI() {
        return true;
    }
}
