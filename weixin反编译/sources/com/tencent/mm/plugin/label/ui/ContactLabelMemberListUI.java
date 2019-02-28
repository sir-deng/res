package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;

public class ContactLabelMemberListUI extends MMActivity {
    private TextView krX;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            x.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", Integer.valueOf(message.what));
            switch (message.what) {
                case 5001:
                    ContactLabelMemberListUI.this.aVL();
                    return;
                default:
                    x.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
                    return;
            }
        }
    };
    private b nUP = new b() {
        public final void a(int i, m mVar, Object obj) {
            x.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", Integer.valueOf(i), obj);
            if (ContactLabelMemberListUI.this.mHandler != null) {
                ContactLabelMemberListUI.this.mHandler.removeMessages(5001);
                ContactLabelMemberListUI.this.mHandler.sendEmptyMessageDelayed(5001, 300);
            }
        }
    };
    private ListView nVe;
    private a nVf;
    private String nVg;
    private String nVh;

    static /* synthetic */ void a(ContactLabelMemberListUI contactLabelMemberListUI, int i) {
        if (contactLabelMemberListUI.nVf != null && i <= contactLabelMemberListUI.nVf.getCount()) {
            com.tencent.mm.f.b.ag agVar = contactLabelMemberListUI.nVf.sc(i).jQP;
            if (agVar != null && !bi.oN(agVar.field_username) && agVar.field_deleteFlag != 1) {
                if (s.hg(agVar.field_username)) {
                    x.e("MicroMsg.Label.ContactLabelMemberListUI", "error, 4.5 do not contain this contact %s", agVar.field_username);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", agVar.field_username);
                intent.putExtra("Contact_Alias", agVar.vU());
                intent.putExtra("Contact_Nick", agVar.AW());
                intent.putExtra("Contact_QuanPin", agVar.vY());
                intent.putExtra("Contact_PyInitial", agVar.vX());
                intent.putExtra("Contact_Sex", agVar.fXa);
                intent.putExtra("Contact_Province", agVar.getProvince());
                intent.putExtra("Contact_City", agVar.getCity());
                intent.putExtra("Contact_Signature", agVar.signature);
                a.ihN.d(intent, (Context) contactLabelMemberListUI);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.deY;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nVg = getIntent().getStringExtra("label_id");
        this.nVh = getIntent().getStringExtra("label_name");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelMemberListUI.this.finish();
                return false;
            }
        });
        addTextOptionMenu(0, getString(R.l.esM), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.setClass(ContactLabelMemberListUI.this, ContactLabelEditUI.class);
                intent.putExtra("label_id", ContactLabelMemberListUI.this.nVg);
                intent.putExtra("label_name", ContactLabelMemberListUI.this.nVh);
                ContactLabelMemberListUI.this.startActivityForResult(intent, 10001);
                return false;
            }
        });
        setMMTitle(this.nVh);
        this.nVe = (ListView) findViewById(R.h.bYl);
        this.krX = (TextView) findViewById(R.h.empty);
        if (bi.oN(this.nVg)) {
            x.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
            finish();
        }
        this.nVf = new a(this.mController.xRr);
        this.nVe.setAdapter(this.nVf);
        this.nVe.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ContactLabelMemberListUI.a(ContactLabelMemberListUI.this, i);
            }
        });
        this.nVe.setEmptyView(this.krX);
    }

    protected void onResume() {
        as.Hm();
        c.Ff().a(this.nUP);
        super.onResume();
        aVL();
    }

    protected void onPause() {
        as.Hm();
        c.Ff().b(this.nUP);
        super.onPause();
    }

    protected void onDestroy() {
        if (this.nVf != null) {
            this.nVf.aUU();
            this.nVf.xQN = null;
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 10001:
                if (i2 == -1) {
                    finish();
                    return;
                } else {
                    aVL();
                    return;
                }
            default:
                x.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", Integer.valueOf(i));
                return;
        }
    }

    private void aVL() {
        if (this.nVf != null) {
            this.nVf.nVa = com.tencent.mm.plugin.label.a.a.aVD().DX(this.nVg);
            this.nVf.a(null, null);
        }
        this.nVh = com.tencent.mm.plugin.label.a.a.aVD().DT(this.nVg);
        if (!bi.oN(this.nVh)) {
            setMMTitle(this.nVh);
        }
    }
}
