package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;
import java.util.List;
import junit.framework.Assert;

public final class h implements a {
    Context context;
    private String iTE;
    private f inW;
    private x jQP;
    q lfE;
    private boolean pnl;
    private boolean pnm;
    private int pnn;
    private int poP;
    ContactListExpandPreference poQ;

    public h(Context context) {
        this.context = context;
        this.poQ = new ContactListExpandPreference(context, 0);
    }

    public final boolean ww(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetGroupCard", "handleEvent " + str);
        as.Hm();
        ag Xv = c.Ff().Xv(str);
        if (Xv != null && ((int) Xv.gKO) > 0) {
            Intent intent = new Intent();
            intent.setClass(this.context, ContactInfoUI.class);
            intent.putExtra("Contact_User", Xv.field_username);
            this.context.startActivity(intent);
        }
        return true;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(bi.oM(xVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        this.inW = fVar;
        this.jQP = xVar;
        this.pnl = z;
        this.pnn = i;
        this.pnm = ((Activity) this.context).getIntent().getBooleanExtra("User_Verify", false);
        this.poP = ((Activity) this.context).getIntent().getIntExtra("Kdel_from", -1);
        this.iTE = xVar.field_username;
        as.Hm();
        this.lfE = c.Fo().hH(this.iTE);
        this.inW.removeAll();
        this.inW.a(new PreferenceSmallCategory(this.context));
        this.poQ.setKey("roominfo_contact_anchor");
        this.inW.a(this.poQ);
        this.inW.a(new PreferenceCategory(this.context));
        Preference normalUserFooterPreference = new NormalUserFooterPreference(this.context);
        normalUserFooterPreference.setLayoutResource(R.i.deR);
        normalUserFooterPreference.setKey("contact_info_footer_normal");
        if (normalUserFooterPreference.a(this.jQP, "", this.pnl, this.pnm, false, this.pnn, this.poP, false, false, 0, "")) {
            this.inW.a(normalUserFooterPreference);
        }
        this.poQ.a(this.inW, this.poQ.idX);
        List gl = m.gl(this.iTE);
        this.poQ.lh(false).li(false);
        this.poQ.n(this.iTE, gl);
        this.poQ.a(new ContactListExpandPreference.a() {
            public final void ov(int i) {
            }

            public final void ow(int i) {
                if (h.this.poQ.Cs(i)) {
                    String Ct = h.this.poQ.Ct(i);
                    if (!bi.oN(Ct)) {
                        Intent intent = new Intent();
                        intent.setClass(h.this.context, ContactInfoUI.class);
                        intent.putExtra("Contact_User", Ct);
                        intent.putExtra("Contact_RoomNickname", h.this.lfE.gw(Ct));
                        h.this.context.startActivity(intent);
                    }
                }
            }

            public final void ayt() {
            }

            public final void ox(int i) {
            }
        });
        return true;
    }

    public final boolean asz() {
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.inW.Zu("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.asz();
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
