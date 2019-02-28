package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.o;

public class IPCallAllRecordUI extends MMActivity {
    private String fJt;
    private String fJv;
    private ListView nOl;
    private boolean nOm = false;

    private class a extends o<k> {

        class a {
            TextView ikq;
            TextView nOo;
            TextView nOp;

            a() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            k kVar = (k) obj;
            if (kVar == null) {
                kVar = new k();
            }
            kVar.b(cursor);
            return kVar;
        }

        public a(Context context) {
            super(context, null);
            mb(true);
        }

        public final void XH() {
            Cursor cursor = null;
            if (!bi.oN(IPCallAllRecordUI.this.fJt)) {
                String a = IPCallAllRecordUI.this.fJt;
                if (!bi.oN(a)) {
                    c Di = i.aUk().Di(a);
                    if (!(Di == null || Di.xrR == -1)) {
                        cursor = i.aUl().dC(Di.xrR);
                    }
                }
            } else if (!bi.oN(IPCallAllRecordUI.this.fJv)) {
                cursor = i.aUl().Dm(IPCallAllRecordUI.this.fJv);
            }
            setCursor(cursor);
        }

        protected final void XI() {
            aUU();
            XH();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = IPCallAllRecordUI.this.getLayoutInflater().inflate(R.i.dmo, viewGroup, false);
                aVar = new a();
                aVar.nOo = (TextView) view.findViewById(R.h.cDZ);
                aVar.nOp = (TextView) view.findViewById(R.h.cEb);
                aVar.ikq = (TextView) view.findViewById(R.h.cEc);
                view.setTag(aVar);
            }
            k kVar = (k) getItem(i);
            aVar = (a) view.getTag();
            aVar.nOp.setText(com.tencent.mm.plugin.ipcall.b.a.DO(kVar.field_phonenumber));
            if (kVar.field_duration > 0) {
                aVar.ikq.setText(com.tencent.mm.plugin.ipcall.b.c.dF(kVar.field_duration));
            } else {
                aVar.ikq.setText(com.tencent.mm.plugin.ipcall.b.c.sa(kVar.field_status));
            }
            aVar.nOo.setText(com.tencent.mm.plugin.ipcall.b.c.dD(kVar.field_calltime));
            return view;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fJv = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
        this.fJt = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
        this.nOm = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
        setMMTitle(R.l.err);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                IPCallAllRecordUI.this.finish();
                return true;
            }
        });
        this.nOl = (ListView) findViewById(R.h.bKc);
        this.nOl.setAdapter(new a(this));
    }

    protected final int getLayoutId() {
        return R.i.dmb;
    }
}
