package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.f.a.ll;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.asb;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;

public class ModRemarkRoomNameUI extends MMActivity implements a {
    private String iTE;
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
                h.b(ModRemarkRoomNameUI.this, str2, str, true);
                if (ModRemarkRoomNameUI.this.lgV != null) {
                    as.Hm();
                    com.tencent.mm.y.c.Fe().c(ModRemarkRoomNameUI.this.lgV);
                }
            } else if (i == 0 && ModRemarkRoomNameUI.this.lfM) {
                Intent intent = new Intent();
                intent.putExtra("room_name", ModRemarkRoomNameUI.this.lgT);
                ModRemarkRoomNameUI.this.setResult(-1, intent);
                ModRemarkRoomNameUI.this.finish();
            }
            if (ModRemarkRoomNameUI.this.ioc != null) {
                ModRemarkRoomNameUI.this.ioc.dismiss();
            }
            return false;
        }
    };
    private String lgT = "";
    private MMEditText lgU;
    private e.b lgV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iTE = getIntent().getStringExtra("RoomInfo_Id");
        com.tencent.mm.sdk.b.a.xmy.b(this.lfQ);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.eEZ);
        this.lgU = (MMEditText) findViewById(R.h.cxg);
        final CharSequence oM = bi.oM(getIntent().getStringExtra("room_name"));
        if (bi.oN(oM)) {
            this.lgU.setHint(i.b(this, ((com.tencent.mm.plugin.chatroom.b.b) g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fo().gw(this.iTE), this.lgU.getTextSize()));
            this.lgU.setEllipsize(TruncateAt.END);
        } else {
            this.lgU.setText(i.b(this, oM, this.lgU.getTextSize()));
        }
        this.lgU.setSelection(this.lgU.getText().length());
        this.lgU.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!oM.equals(charSequence)) {
                    ModRemarkRoomNameUI.this.enableOptionMenu(true);
                }
                if (charSequence.length() > 0) {
                    ModRemarkRoomNameUI.this.lgU.setEllipsize(null);
                } else {
                    ModRemarkRoomNameUI.this.lgU.setEllipsize(TruncateAt.END);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        com.tencent.mm.ui.tools.a.c fl = com.tencent.mm.ui.tools.a.c.d(this.lgU).fl(1, 32);
        fl.zwQ = false;
        fl.a(null);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ModRemarkRoomNameUI.this.setResult(0);
                ModRemarkRoomNameUI.this.finish();
                return true;
            }
        });
        a(0, getString(R.l.dGI), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ModRemarkRoomNameUI.this.aWY();
                String str = "";
                String zP = com.tencent.mm.j.b.zP();
                if (bi.oN(zP) || !str.matches(".*[" + zP + "].*")) {
                    com.tencent.mm.ui.tools.a.c.d(ModRemarkRoomNameUI.this.lgU).fl(1, 32).a(ModRemarkRoomNameUI.this);
                    return true;
                }
                h.b(ModRemarkRoomNameUI.this.mController.xRr, ModRemarkRoomNameUI.this.getString(R.l.epR, new Object[]{zP}), ModRemarkRoomNameUI.this.getString(R.l.dGZ), true);
                return false;
            }
        }, p.b.xSe);
        enableOptionMenu(false);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.lfQ);
    }

    protected final int getLayoutId() {
        return R.i.dox;
    }

    public final void vE(String str) {
        this.lgT = str;
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.ioc = h.a(context, getString(R.l.dUO), false, null);
        com.tencent.mm.bp.a asb = new asb();
        asb.vNv = new bet().Vf(bi.oM(this.iTE));
        asb.wGm = new bet().Vf(bi.oM(str));
        this.lgV = new e.a(27, asb);
        this.lfM = true;
        as.Hm();
        com.tencent.mm.y.c.Fe().b(this.lgV);
    }

    public final void anp() {
        h.h(this, R.l.eMf, R.l.eMh);
    }

    public final void aeD() {
        h.h(this, R.l.eMg, R.l.eMh);
    }
}
