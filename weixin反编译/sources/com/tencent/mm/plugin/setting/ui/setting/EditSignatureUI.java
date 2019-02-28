package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.ll;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bj;
import com.tencent.mm.y.q;

public class EditSignatureUI extends MMActivity {
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
            if (i != 0 && EditSignatureUI.this.qmP != null) {
                h.b(EditSignatureUI.this, str2, str, true);
                if (EditSignatureUI.this.qmQ != null) {
                    as.Hm();
                    com.tencent.mm.y.c.Fe().c(EditSignatureUI.this.qmQ);
                }
            } else if (i == 0 && EditSignatureUI.this.lfM) {
                str = EditSignatureUI.this.qmP.getText().toString().trim();
                as.Hm();
                com.tencent.mm.y.c.Db().set(12291, str);
                EditSignatureUI.this.finish();
            }
            if (EditSignatureUI.this.ioc != null) {
                EditSignatureUI.this.ioc.dismiss();
            }
            return true;
        }
    };
    private TextView qmF;
    private MMEditText qmP;
    private e.b qmQ;
    final bj qmR = bj.HW();

    private class a implements TextWatcher {
        private int qmT;

        private a() {
            this.qmT = 60;
        }

        /* synthetic */ a(EditSignatureUI editSignatureUI, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            EditSignatureUI.this.enableOptionMenu(true);
        }

        public final void afterTextChanged(Editable editable) {
            this.qmT = com.tencent.mm.ui.tools.h.be(60, editable.toString());
            if (this.qmT < 0) {
                this.qmT = 0;
            }
            if (EditSignatureUI.this.qmF != null) {
                EditSignatureUI.this.qmF.setText(this.qmT);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dfG;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xmy.b(this.lfQ);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.lfQ);
    }

    protected final void initView() {
        setMMTitle(R.l.eNm);
        this.qmP = (MMEditText) findViewById(R.h.content);
        this.qmF = (TextView) findViewById(R.h.cZN);
        as.Hm();
        this.qmP.setText(i.b(this, bi.oM((String) com.tencent.mm.y.c.Db().get(12291, null)), this.qmP.getTextSize()));
        this.qmP.setSelection(this.qmP.getText().length());
        this.qmF.setText(com.tencent.mm.ui.tools.h.be(60, this.qmP.getEditableText().toString()));
        com.tencent.mm.ui.tools.a.c.d(this.qmP).fl(0, 60).a(null);
        this.qmP.addTextChangedListener(new a());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EditSignatureUI.this.aWY();
                EditSignatureUI.this.finish();
                return true;
            }
        });
        a(0, getString(R.l.dGI), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = EditSignatureUI.this.qmP.getText().toString().trim();
                String zP = com.tencent.mm.j.b.zP();
                if (bi.oN(zP) || !trim.matches(".*[" + zP + "].*")) {
                    EditSignatureUI editSignatureUI = EditSignatureUI.this;
                    Context context = EditSignatureUI.this.mController.xRr;
                    EditSignatureUI.this.getString(R.l.dGZ);
                    editSignatureUI.ioc = h.a(context, EditSignatureUI.this.getString(R.l.dUO), false, null);
                    EditSignatureUI.this.qmQ = q.q(18, trim);
                    EditSignatureUI.this.lfM = true;
                    EditSignatureUI.this.aWY();
                    return true;
                }
                h.b(EditSignatureUI.this.mController.xRr, EditSignatureUI.this.getString(R.l.epR, new Object[]{zP}), EditSignatureUI.this.getString(R.l.dGZ), true);
                return false;
            }
        }, p.b.xSe);
        enableOptionMenu(false);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
