package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.f.a.ll;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;

public class SettingsModifyNameUI extends MMActivity implements a {
    private r ioc = null;
    private boolean lfM = false;
    private c lfQ = new c<ll>() {
        {
            this.xmG = ll.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ll llVar = (ll) bVar;
            String str = llVar.fDF.fDG;
            String str2 = llVar.fDF.fDH;
            int i = llVar.fDF.ret;
            if (i != 0 && str2 != null) {
                h.b(SettingsModifyNameUI.this, str2, str, true);
                if (SettingsModifyNameUI.this.qmQ != null) {
                    as.Hm();
                    com.tencent.mm.y.c.Fe().c(SettingsModifyNameUI.this.qmQ);
                }
            } else if (i == 0 && SettingsModifyNameUI.this.lfM) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(4, SettingsModifyNameUI.this.lgU.getText().toString());
                SettingsModifyNameUI.this.finish();
            }
            if (SettingsModifyNameUI.this.ioc != null) {
                SettingsModifyNameUI.this.ioc.dismiss();
            }
            return true;
        }
    };
    private MMEditText lgU;
    private e.b qmQ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xmy.b(this.lfQ);
        initView();
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.xmy.c(this.lfQ);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dso;
    }

    protected final void initView() {
        setMMTitle(R.l.dso);
        this.lgU = (MMEditText) findViewById(R.h.cMD);
        MMEditText mMEditText = this.lgU;
        as.Hm();
        mMEditText.setText(i.b(this, (String) com.tencent.mm.y.c.Db().get(4, null), this.lgU.getTextSize()));
        this.lgU.setSelection(this.lgU.getText().length());
        this.lgU.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SettingsModifyNameUI.this.enableOptionMenu(true);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        com.tencent.mm.ui.tools.a.c fl = com.tencent.mm.ui.tools.a.c.d(this.lgU).fl(1, 32);
        fl.zwQ = false;
        fl.a(null);
        a(0, getString(R.l.dGI), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String obj = SettingsModifyNameUI.this.lgU.getText().toString();
                String zP = com.tencent.mm.j.b.zP();
                if (bi.oN(zP) || !obj.matches(".*[" + zP + "].*")) {
                    com.tencent.mm.ui.tools.a.c.d(SettingsModifyNameUI.this.lgU).fl(1, 32).a(SettingsModifyNameUI.this);
                    return true;
                }
                h.b(SettingsModifyNameUI.this.mController.xRr, SettingsModifyNameUI.this.getString(R.l.epR, new Object[]{zP}), SettingsModifyNameUI.this.getString(R.l.dGZ), true);
                return false;
            }
        }, p.b.xSe);
        enableOptionMenu(false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsModifyNameUI.this.aWY();
                SettingsModifyNameUI.this.finish();
                return true;
            }
        });
    }

    public final void vE(String str) {
        x.i("MiroMsg.SettingsModifyNameUI", "Set New NickName : " + str);
        this.lfM = true;
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.ioc = h.a(context, getString(R.l.dUO), false, null);
        this.qmQ = q.q(2, str);
    }

    public final void anp() {
        h.h(this, R.l.eMf, R.l.eMh);
    }

    public final void aeD() {
        h.h(this, R.l.eMg, R.l.eMh);
    }
}
