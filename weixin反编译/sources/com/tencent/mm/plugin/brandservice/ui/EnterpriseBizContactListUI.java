package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.af.b;
import com.tencent.mm.af.d;
import com.tencent.mm.af.e;
import com.tencent.mm.af.f;
import com.tencent.mm.af.y;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.List;

public class EnterpriseBizContactListUI extends MMActivity {
    private long gAW;
    private long hSf = 0;
    public String kLP;
    private m kLQ;
    private EnterpriseBizContactListView kLR;
    private ag kLS;
    private boolean kLT = false;

    protected final int getLayoutId() {
        return R.i.dgv;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kLP = getIntent().getStringExtra("enterprise_biz_name");
        this.gAW = System.currentTimeMillis() / 1000;
        if (this.kLS == null) {
            this.kLS = new ag() {
                public final void handleMessage(Message message) {
                    if (message != null && message.what == 1 && EnterpriseBizContactListUI.this != null && !EnterpriseBizContactListUI.this.isFinishing()) {
                        y.Mv().jz(EnterpriseBizContactListUI.this.kLP);
                        y.Ml();
                        List jQ = e.jQ(EnterpriseBizContactListUI.this.kLP);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < jQ.size()) {
                                String str = (String) jQ.get(i2);
                                if (s.gH(str) && (f.kb(str) || f.eG(str))) {
                                    y.Mv().jz(str);
                                }
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }
            };
        } else {
            this.kLS.removeMessages(1);
        }
        this.kLS.sendEmptyMessageDelayed(1, 500);
    }

    protected void onResume() {
        super.onResume();
        if (s.gH(this.kLP)) {
            initView();
            if (!this.kLT) {
                int intExtra = getIntent().getIntExtra("enterprise_from_scene", 5);
                int i = -1;
                if (this.kLR != null) {
                    i = this.kLR.kLY;
                }
                b jA = y.Ms().jA(this.kLP);
                int i2 = jA != null ? jA.field_qyUin : 0;
                long j = jA != null ? jA.field_wwCorpId : 0;
                long j2 = jA != null ? jA.field_wwUserVid : 0;
                g.pWK.h(12892, this.kLP, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
                x.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.kLP, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
                this.kLT = true;
                return;
            }
            return;
        }
        x.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", this.kLP);
        finish();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.kLR != null) {
            EnterpriseBizContactListView.release();
        }
        if (this.gAW > 0 && this.hSf > 0) {
            long j = this.hSf - this.gAW;
            b jA = y.Ms().jA(this.kLP);
            int i = jA != null ? jA.field_qyUin : 0;
            int i2 = jA != null ? jA.field_userUin : 0;
            g.pWK.h(13465, "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j));
            x.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j));
        }
        super.onDestroy();
    }

    public void finish() {
        this.hSf = System.currentTimeMillis() / 1000;
        super.finish();
    }

    protected final void initView() {
        as.Hm();
        setMMTitle(c.Ff().Xv(this.kLP).AW());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EnterpriseBizContactListUI.this.aWY();
                EnterpriseBizContactListUI.this.finish();
                return true;
            }
        });
        if (!bi.oN(this.kLP)) {
            d jV = f.jV(this.kLP);
            if (jV != null && jV.Lk()) {
                addIconOptionMenu(1, R.l.dCx, R.k.duZ, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (EnterpriseBizContactListUI.this.kLQ != null) {
                            EnterpriseBizContactListUI.this.kLQ.dismiss();
                            EnterpriseBizContactListUI.this.kLQ = null;
                        }
                        EnterpriseBizContactListUI.this.kLQ = new m(EnterpriseBizContactListUI.this.mController.xRr);
                        EnterpriseBizContactListUI.this.kLQ.rQF = new p.c() {
                            public final void a(n nVar) {
                                nVar.aj(2, R.l.dWA, R.k.dAb);
                                nVar.aj(3, R.l.ecc, R.k.dvd);
                                nVar.aj(4, R.l.dCy, R.k.dvn);
                            }
                        };
                        EnterpriseBizContactListUI.this.kLQ.rQG = new p.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                Intent intent;
                                switch (menuItem.getItemId()) {
                                    case 2:
                                        intent = new Intent();
                                        intent.putExtra("Select_Talker_Name", EnterpriseBizContactListUI.this.kLP);
                                        intent.putExtra("Select_block_List", EnterpriseBizContactListUI.this.kLP);
                                        intent.putExtra("Select_Send_Card", true);
                                        intent.putExtra("Select_Conv_Type", 3);
                                        com.tencent.mm.bl.d.a(EnterpriseBizContactListUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                                        return;
                                    case 3:
                                        intent = new Intent(EnterpriseBizContactListUI.this, EnterpriseBizContactPlainListUI.class);
                                        intent.putExtra("enterprise_biz_name", EnterpriseBizContactListUI.this.kLP);
                                        intent.putExtra("enterprise_scene", 2);
                                        EnterpriseBizContactListUI.this.startActivity(intent);
                                        return;
                                    case 4:
                                        intent = new Intent();
                                        intent.putExtra("Contact_User", EnterpriseBizContactListUI.this.kLP);
                                        a.ihN.d(intent, EnterpriseBizContactListUI.this);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        EnterpriseBizContactListUI.this.kLQ.dN();
                        return false;
                    }
                });
            }
        }
        this.kLR = (EnterpriseBizContactListView) findViewById(R.h.ceF);
        this.kLR.kLP = this.kLP;
        this.kLR.kLW = false;
        this.kLR.refresh();
        this.kLR.atc();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.f.aZN().l(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.f.aZN().dq(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.snackbar.a.h(this, this.mController.xRr.getString(R.l.eip));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
