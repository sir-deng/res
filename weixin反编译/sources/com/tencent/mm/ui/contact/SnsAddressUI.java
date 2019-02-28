package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.p.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI extends MMBaseSelectContactUI {
    private HashSet<String> ikQ;
    private List<String> koG;

    protected final void Xc() {
        super.Xc();
        this.koG = new ArrayList();
        Collection F = bi.F(bi.aD(getIntent().getStringExtra("Block_list"), "").split(","));
        Collection cwZ = s.cwZ();
        cwZ.addAll(F);
        this.koG.addAll(cwZ);
        this.koG.addAll(s.cxa());
        this.ikQ = new HashSet();
        String aD = bi.aD(getIntent().getStringExtra("Select_Contact"), "");
        if (!bi.oN(aD)) {
            this.ikQ.addAll(bi.F(aD.split(",")));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.SnsAddressUI", "Create!");
        a(1, getString(R.l.dGf), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                List F = bi.F((String[]) SnsAddressUI.this.ikQ.toArray(new String[0]));
                if (F == null || F.size() == 0) {
                    intent.putExtra("Select_Contact", "");
                } else {
                    intent.putExtra("Select_Contact", bi.d(F, ","));
                }
                SnsAddressUI.this.setResult(-1, intent);
                SnsAddressUI.this.finish();
                ah.h(new Runnable() {
                    public final void run() {
                        if (!SnsAddressUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                            SnsAddressUI.this.moveTaskToBack(true);
                        }
                    }
                }, 100);
                return true;
            }
        }, b.xSe);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsAddressUI.this.finish();
                if (!SnsAddressUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                    SnsAddressUI.this.moveTaskToBack(true);
                }
                return true;
            }
        });
        Iterator it = this.ikQ.iterator();
        while (it.hasNext()) {
            this.otF.SL((String) it.next());
        }
        this.otF.vrh = new a() {
            public final void oW(String str) {
                if (str != null) {
                    SnsAddressUI.this.ikQ.remove(str);
                    SnsAddressUI.this.Xi();
                }
            }
        };
        Xi();
    }

    public final void jd(int i) {
        n cwP = cwP();
        com.tencent.mm.ui.contact.a.a GF = cwP.GF(i - this.pxs.getHeaderViewsCount());
        if (GF != null && GF.jQP != null) {
            x.i("MicroMsg.SnsAddressUI", "ClickUser=%s", GF.jQP.field_username);
            String str = GF.jQP.field_username;
            cwV();
            if (this.ikQ.contains(str)) {
                this.ikQ.remove(str);
                this.otF.SL(str);
            } else if (this.ikQ.size() < v.xva) {
                this.ikQ.add(str);
                this.otF.SL(str);
            } else {
                Toast.makeText(this, R.l.eQk, 0).show();
                x.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", Integer.valueOf(v.xva));
            }
            Xi();
            cwP.notifyDataSetChanged();
        }
    }

    protected final boolean Xd() {
        return false;
    }

    protected final boolean Xe() {
        return true;
    }

    protected final String Xf() {
        return bi.aD(getIntent().getStringExtra("Add_address_titile"), "");
    }

    protected final o Xg() {
        c.a aVar = new c.a();
        aVar.yZR = true;
        aVar.yZY = true;
        aVar.zaa = getString(R.l.dDn);
        aVar.yZZ = bi.aD(getIntent().getStringExtra("Add_get_from_sns"), "");
        aVar.yYA = "@all.contact.without.chatroom.without.openim";
        return new c(this, this.koG, true, aVar);
    }

    protected final m Xh() {
        return new q(this, this.koG, true, this.scene);
    }

    private void Xi() {
        String format;
        boolean z;
        if (this.ikQ.size() == 0) {
            format = String.format("%s", new Object[]{getString(R.l.dGf)});
        } else {
            format = String.format("%s(%d/%d)", new Object[]{getString(R.l.dGf), Integer.valueOf(this.ikQ.size()), Integer.valueOf(v.xva)});
        }
        updateOptionMenuText(1, format);
        if (this.ikQ.size() >= 0) {
            z = true;
        } else {
            z = false;
        }
        enableOptionMenu(1, z);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 3:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (bi.oN(stringExtra)) {
                        x.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    x.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        String str = split[i3];
                        if (this.ikQ.add(str)) {
                            this.otF.SL(str);
                        }
                        i3++;
                    }
                    Xi();
                    cwP().notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
    }

    protected final boolean aZI() {
        return true;
    }

    protected final void ET(String str) {
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        Collection hashSet = new HashSet();
        hashSet.addAll(this.ikQ);
        intent.putExtra("always_select_contact", bi.d(new ArrayList(hashSet), ","));
        intent.putExtra("list_attr", s.p(16384, 64));
        startActivityForResult(intent, 3);
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.zbR || aVar.jQP == null) {
            return false;
        }
        return this.ikQ.contains(aVar.jQP.field_username);
    }

    public final int[] aYB() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public final void oW(String str) {
        this.ikQ.remove(str);
        cwP().notifyDataSetChanged();
        Xi();
    }
}
