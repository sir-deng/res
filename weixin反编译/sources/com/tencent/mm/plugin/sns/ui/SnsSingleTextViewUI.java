package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.qk;
import com.tencent.mm.f.a.ql;
import com.tencent.mm.f.a.qm;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;

public class SnsSingleTextViewUI extends MMActivity {
    private String fvn;
    private ClipboardManager mCW;
    private d otp = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    if (SnsSingleTextViewUI.this.rMH != null && SnsSingleTextViewUI.this.rMH.getText() != null) {
                        SnsSingleTextViewUI.this.mCW.setText(SnsSingleTextViewUI.this.rMH.getText());
                        h.bu(SnsSingleTextViewUI.this.mController.xRr, SnsSingleTextViewUI.this.mController.xRr.getString(j.dEE));
                        if (SnsSingleTextViewUI.this.rew != null) {
                            int i2 = a.qlf;
                            a.d(2, bi.fM(SnsSingleTextViewUI.this.rew.field_snsId), bi.We(SnsSingleTextViewUI.this.rMH.getText().toString()));
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    if (SnsSingleTextViewUI.this.rMH != null && SnsSingleTextViewUI.this.rMH.getText() != null) {
                        cg cgVar = new cg();
                        com.tencent.mm.plugin.sns.i.a.a(cgVar, SnsSingleTextViewUI.this.fvn, SnsSingleTextViewUI.this.rMH.getText());
                        cgVar.frk.activity = SnsSingleTextViewUI.this;
                        cgVar.frk.frr = 18;
                        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                        return;
                    }
                    return;
                case 6:
                    if (SnsSingleTextViewUI.this.rMH != null && SnsSingleTextViewUI.this.rMH.getText() != null) {
                        Intent intent = new Intent();
                        m LR = ae.bwf().LR(SnsSingleTextViewUI.this.fvn);
                        intent.putExtra("k_username", LR == null ? "" : LR.field_userName);
                        intent.putExtra("k_expose_msg_id", LR == null ? Integer.valueOf(0) : LR.byG());
                        intent.putExtra("showShare", false);
                        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                        com.tencent.mm.bl.d.b(SnsSingleTextViewUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        return;
                    }
                    return;
                case 14:
                    if (SnsSingleTextViewUI.this.rMH != null && SnsSingleTextViewUI.this.rMH.getText() != null) {
                        ao.o(ae.bwf().LR(SnsSingleTextViewUI.this.fvn));
                        return;
                    }
                    return;
                case 16:
                    if (SnsSingleTextViewUI.this.rMH != null && SnsSingleTextViewUI.this.rMH.getText() != null) {
                        ao.p(ae.bwf().LR(SnsSingleTextViewUI.this.fvn));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private TextView rMH;
    private boolean rMI = false;
    private SnsTranslateResultView rMJ;
    private c rMK = new c<ql>() {
        {
            this.xmG = ql.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ql qlVar = (ql) bVar;
            if ((qlVar instanceof ql) && SnsSingleTextViewUI.this.rew != null && SnsSingleTextViewUI.this.rew.byG().equals(qlVar.fIR.id)) {
                ao.cd(SnsSingleTextViewUI.this.rew.byG(), 8);
                SnsSingleTextViewUI.this.rMJ.setVisibility(0);
                SnsSingleTextViewUI.this.rMJ.yh(2);
                SnsSingleTextViewUI.this.rMI = false;
            }
            return false;
        }
    };
    private c rML = new c<qk>() {
        {
            this.xmG = qk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qk qkVar = (qk) bVar;
            if ((qkVar instanceof qk) && SnsSingleTextViewUI.this.rew != null && SnsSingleTextViewUI.this.rew.byG().equals(qkVar.fIP.id)) {
                ao.cd(SnsSingleTextViewUI.this.rew.byG(), 8);
                String str = qkVar.fIP.result;
                String str2 = qkVar.fIP.fIQ;
                if (bi.oN(str)) {
                    SnsSingleTextViewUI.this.rMJ.setVisibility(8);
                    ao.ce(SnsSingleTextViewUI.this.rew.byG(), 8);
                } else {
                    SnsSingleTextViewUI.this.rMJ.setVisibility(0);
                    SnsSingleTextViewUI.this.rMJ.a(null, 1, str, str2, true);
                    SnsSingleTextViewUI.this.rMI = true;
                }
            }
            return false;
        }
    };
    private c rMM = new c<qm>() {
        {
            this.xmG = qm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qm qmVar = (qm) bVar;
            if ((qmVar instanceof qm) && SnsSingleTextViewUI.this.rew.byG().equals(qmVar.fIS.id)) {
                ao.ce(qmVar.fIS.id, 8);
                SnsSingleTextViewUI.this.rMJ.setVisibility(8);
                SnsSingleTextViewUI.this.rMI = false;
            }
            return false;
        }
    };
    protected int requestType = 0;
    private m rew;
    private String text;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mCW = (ClipboardManager) getSystemService("clipboard");
        setMMTitle(j.qQk);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsSingleTextViewUI.this.finish();
                return true;
            }
        });
        this.text = getIntent().getStringExtra("sns_text_show");
        this.fvn = bi.aD(getIntent().getStringExtra("sns_local_id"), "");
        this.rew = ae.bwf().LR(this.fvn);
        if (bi.oN(this.text)) {
            this.text = "";
        }
        this.rMH = (TextView) findViewById(f.qLA);
        this.rMH.setText(this.text, BufferType.SPANNABLE);
        i.f(this.rMH, 2);
        this.rMH.setOnTouchListener(new ab());
        new l(this).a(this.rMH, this, this.otp);
        this.rMJ = (SnsTranslateResultView) findViewById(f.qLG);
        this.rMJ.az(this.rMH.getTextSize());
        if (this.rew != null && ao.cf(this.rew.byG(), 8)) {
            ao.b KW = ao.KW(this.rew.byG());
            if (KW != null && KW.hjU) {
                this.rMJ.setVisibility(0);
                this.rMJ.a(null, 1, KW.result, KW.hrN, false);
                this.rMI = true;
            }
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.rMK);
        com.tencent.mm.sdk.b.a.xmy.b(this.rML);
        com.tencent.mm.sdk.b.a.xmy.b(this.rMM);
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.rMK);
        com.tencent.mm.sdk.b.a.xmy.c(this.rML);
        com.tencent.mm.sdk.b.a.xmy.c(this.rMM);
    }

    protected final int getLayoutId() {
        return g.qNV;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view instanceof TextView) {
            contextMenu.add(0, 0, 0, getString(j.dED));
            if (com.tencent.mm.bl.d.Pu("favorite")) {
                contextMenu.add(0, 1, 0, getString(j.eeR));
            }
            contextMenu.add(0, 6, 1, getString(j.qPv));
            if (this.rMI) {
                ao.b(contextMenu, true);
            } else {
                ao.a(contextMenu, true);
            }
        }
    }
}
