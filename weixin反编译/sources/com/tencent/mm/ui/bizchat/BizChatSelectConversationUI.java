package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.a.c;
import com.tencent.mm.af.a.h;
import com.tencent.mm.af.a.j;
import com.tencent.mm.af.n;
import com.tencent.mm.af.y;
import com.tencent.mm.bl.d;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import java.util.HashMap;

@a(19)
public class BizChatSelectConversationUI extends MMBaseSelectContactUI implements n {
    private String kMt = null;
    private int scene = 0;
    private r tipDialog = null;
    j ywl;
    private TextView yxi;

    static /* synthetic */ void a(BizChatSelectConversationUI bizChatSelectConversationUI) {
        bizChatSelectConversationUI.ywl = y.Mp().ca(y.Mp().cb(bizChatSelectConversationUI.kMt));
        if (bizChatSelectConversationUI.ywl == null || bi.oN(bizChatSelectConversationUI.ywl.field_addMemberUrl)) {
            String str = "MicroMsg.BizChatSelectConversationUI";
            String str2 = "field_addMemberUrl:%s";
            Object[] objArr = new Object[1];
            objArr[0] = bizChatSelectConversationUI.ywl != null ? bizChatSelectConversationUI.ywl.field_addMemberUrl : null;
            x.i(str, str2, objArr);
            Toast.makeText(bizChatSelectConversationUI, bizChatSelectConversationUI.getString(R.l.dMA), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", bizChatSelectConversationUI.ywl.field_addMemberUrl);
        x.i("MicroMsg.BizChatSelectConversationUI", "KRawUrl :%s", bizChatSelectConversationUI.ywl.field_addMemberUrl);
        intent.putExtra("useJs", true);
        d.b(bizChatSelectConversationUI.mController.xRr, "webview", ".ui.tools.WebViewUI", intent, 1);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
        crC();
        String cb = y.Mp().cb(this.kMt);
        this.ywl = y.Mp().ca(cb);
        String str = "MicroMsg.BizChatSelectConversationUI";
        String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
        Object[] objArr = new Object[3];
        objArr[0] = this.kMt;
        objArr[1] = cb;
        if (this.ywl == null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (bi.oN(cb) || this.ywl == null || this.ywl.MA() || bi.oN(this.ywl.field_addMemberUrl)) {
            y.Mr();
            h.a(this.kMt, (n) this);
            getString(R.l.dGZ);
            this.tipDialog = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    BizChatSelectConversationUI.this.finish();
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void crC() {
        if (bi.oN(this.kMt)) {
            this.kMt = getIntent().getStringExtra("enterprise_biz_name");
            if (bi.oN(this.kMt)) {
                x.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
                finish();
            }
        }
    }

    protected final o Xg() {
        crC();
        return new d(this, this.kMt);
    }

    protected final m Xh() {
        crC();
        return new p(this, this.kMt);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.yxi == null) {
            OnClickListener anonymousClass1 = new OnClickListener() {
                public final void onClick(View view) {
                    BizChatSelectConversationUI.a(BizChatSelectConversationUI.this);
                }
            };
            CharSequence string = getString(R.l.eJz);
            View inflate = v.fw(this).inflate(R.i.dlD, null);
            inflate.setOnClickListener(anonymousClass1);
            TextView textView = (TextView) inflate.findViewById(R.h.bYU);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.yxi = textView;
        }
        this.yxi.setVisibility(i);
    }

    protected final void aYC() {
        super.aYC();
    }

    public final void jd(int i) {
        if (i < this.pxs.getHeaderViewsCount()) {
            x.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
        } else if (this.pxs.getAdapter().getItem(i) instanceof a) {
            a aVar = (a) this.pxs.getAdapter().getItem(i);
            if (aVar != null) {
                String str = aVar.username;
                long j = aVar.kMn;
                if (str == null || j == -1) {
                    x.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", str, Long.valueOf(j));
                    return;
                }
                a(str, j, aVar.ikG);
            }
        } else {
            x.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
        }
    }

    private void a(final String str, final long j, CharSequence charSequence) {
        x.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", str);
        if (this.scene == 2) {
            long j2;
            if (getIntent().getBooleanExtra("enterprise_extra_params", true)) {
                j2 = j;
                e.a(this.mController, j2, getString(R.l.eES), String.valueOf(charSequence), getString(R.l.dGL), new com.tencent.mm.pluginsdk.ui.applet.o.a() {
                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            Intent intent = new Intent();
                            intent.putExtra("enterprise_biz_name", str);
                            intent.putExtra("key_biz_chat_id", j);
                            intent.putExtra("key_is_biz_chat", true);
                            BizChatSelectConversationUI.this.setResult(-1, intent);
                            BizChatSelectConversationUI.this.finish();
                        }
                    }
                });
                return;
            }
            j2 = j;
            e.a(this.mController, j2, getString(R.l.eES), String.valueOf(charSequence), getString(R.l.dGL), new com.tencent.mm.pluginsdk.ui.applet.o.a() {
                public final void a(boolean z, String str, int i) {
                    if (z) {
                        Intent intent = new Intent();
                        intent.putExtra("enterprise_biz_name", str);
                        intent.putExtra("key_biz_chat_id", j);
                        intent.putExtra("key_is_biz_chat", true);
                        BizChatSelectConversationUI.this.setResult(-1, intent);
                        BizChatSelectConversationUI.this.finish();
                    }
                }
            });
        } else if (this.scene == 1) {
            HashMap hashMap = (HashMap) getIntent().getSerializableExtra("enterprise_extra_params");
            String str2 = (String) hashMap.get("title");
            e.a(this.mController, str2, (String) hashMap.get("img_url"), (String) hashMap.get("desc"), null, true, getResources().getString(R.l.dGL), new com.tencent.mm.pluginsdk.ui.applet.o.a() {
                public final void a(boolean z, String str, int i) {
                    if (z) {
                        Intent intent = new Intent();
                        intent.putExtra("enterprise_biz_name", str);
                        intent.putExtra("key_biz_chat_id", j);
                        intent.putExtra("key_is_biz_chat", true);
                        if (!bi.oN(str)) {
                            intent.putExtra("enterprise_share_append_text", str);
                        }
                        BizChatSelectConversationUI.this.setResult(-1, intent);
                        BizChatSelectConversationUI.this.finish();
                    }
                }
            });
        }
    }

    protected final boolean Xe() {
        return false;
    }

    protected final String Xf() {
        return com.tencent.mm.y.r.gw(this.kMt);
    }

    protected final boolean Xd() {
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    boolean z;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        String str;
                        x.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        ws wsVar = new ws();
                        c cVar = new c();
                        if (this.ywl != null) {
                            str = this.ywl.field_addMemberUrl;
                        } else {
                            str = null;
                        }
                        cVar.field_addMemberUrl = str;
                        cVar.field_brandUserName = this.kMt;
                        if (!com.tencent.mm.af.a.e.a(cVar, string, null, wsVar)) {
                            z = false;
                        } else if (cVar.field_bizChatLocalId != -1) {
                            a(this.kMt, cVar.field_bizChatLocalId, cVar.field_chatName);
                            z = true;
                        } else {
                            y.Mr();
                            final com.tencent.mm.af.a.n a = h.a(this.kMt, wsVar, (n) this);
                            getString(R.l.dGZ);
                            this.tipDialog = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dCP), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    as.CN().c(a);
                                }
                            });
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        Toast.makeText(this, getString(R.l.eFf), 0).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, k kVar) {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (kVar.getType() == 1355) {
            c ko = y.Mn().ko(((com.tencent.mm.af.a.n) kVar).MF().wfx.wnN.vUb);
            if (ko == null) {
                Toast.makeText(ad.getContext(), getString(R.l.eFf), 0).show();
            } else {
                a(this.kMt, ko.field_bizChatLocalId, ko.field_chatName);
            }
        }
    }
}
