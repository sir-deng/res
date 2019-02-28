package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.protocal.c.aiq;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class e {
    ListView nNO;
    h nNP;
    View nNQ;
    IPCallAddressUI nNR;
    boolean nNS = false;
    TextView nNT = null;
    TextView nNU = null;
    LinearLayout nNV = null;
    TextView nNW = null;
    ImageView nNX = null;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.e$9 */
    class AnonymousClass9 implements d {
        final /* synthetic */ k nNZ;
        final /* synthetic */ int nOa;

        AnonymousClass9(k kVar, int i) {
            this.nNZ = kVar;
            this.nOa = i;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            if (i == 0) {
                e eVar = e.this;
                k kVar = this.nNZ;
                int i2 = this.nOa;
                l aUl;
                if (kVar.field_addressId > 0) {
                    aUl = i.aUl();
                    if (kVar.field_addressId > 0 && aUl.gLA.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)}) < 0) {
                        x.d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", Integer.valueOf(aUl.gLA.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)})), Long.valueOf(r4));
                    }
                } else {
                    aUl = i.aUl();
                    if (!bi.oN(kVar.field_phonenumber) && aUl.gLA.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber}) < 0) {
                        x.d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", Integer.valueOf(aUl.gLA.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber})), r1);
                    }
                }
                h hVar = eVar.nNP;
                hVar.nQX.remove(i2);
                hVar.notifyDataSetChanged();
                if (eVar.nNP.getCount() > 0) {
                    eVar.nNQ.setVisibility(8);
                } else {
                    eVar.nNQ.setVisibility(0);
                }
            }
        }
    }

    public e(IPCallAddressUI iPCallAddressUI, ListView listView, View view) {
        this.nNO = listView;
        this.nNR = iPCallAddressUI;
        this.nNQ = view;
    }

    public final void aUV() {
        ah.y(new Runnable() {
            public final void run() {
                as.Hm();
                if (((Boolean) c.Db().get(a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                    e.this.nNX.setVisibility(0);
                } else {
                    e.this.nNX.setVisibility(8);
                }
                as.Hm();
                String str = (String) c.Db().get(a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, (Object) "");
                as.Hm();
                String str2 = (String) c.Db().get(a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, (Object) "");
                if (!bi.oN(str)) {
                    e.this.nNW.setText(str);
                    e.this.nNV.setVisibility(0);
                } else if (bi.oN(str2)) {
                    e.this.nNW.setText("");
                    e.this.nNV.setVisibility(8);
                } else {
                    e.this.nNW.setText(str2);
                    e.this.nNV.setVisibility(0);
                }
            }
        });
    }

    public final void aUW() {
        ah.y(new Runnable() {
            public final void run() {
                aiq aVw = com.tencent.mm.plugin.ipcall.b.c.aVw();
                if (aVw != null) {
                    e.this.nNT.setText(aVw.wwE);
                    if (bi.oN(aVw.wwM)) {
                        e.this.nNU.setText("");
                        e.this.nNU.setVisibility(8);
                        return;
                    }
                    e.this.nNU.setText(aVw.wwM);
                    e.this.nNU.setVisibility(0);
                    return;
                }
                e.this.nNT.setText("");
                e.this.nNU.setText("");
                e.this.nNU.setVisibility(8);
            }
        });
    }
}
