package com.tencent.mm.y;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.x;

public final class z {
    private c hhs;

    public z(c cVar) {
        this.hhs = cVar;
    }

    static int a(boolean z, String str, boolean z2) {
        int i = 3;
        a Xv = c.Ff().Xv(str);
        if (Xv == null) {
            Xv = new x();
        }
        if (((int) Xv.gKO) == 0) {
            Xv.setUsername(str);
            Xv.An();
            x(Xv);
            if (z2) {
                i = 4;
            }
            Xv.eC(i);
            Xv.Aw();
            c.Ff().S(Xv);
            return 1;
        } else if (!z) {
            return 3;
        } else {
            Xv.Aw();
            c.Ff().a(str, Xv);
            return 2;
        }
    }

    public static void w(x xVar) {
        ag xVar2;
        if (xVar2 == null) {
            xVar2 = new x();
        }
        if (((int) xVar2.gKO) == 0) {
            xVar2.setUsername("filehelper");
            as.Hm();
            if (c.Fk().XF(xVar2.field_username) == null) {
                xVar2.Ao();
            } else {
                xVar2.An();
            }
            xVar2.eC(3);
            as.Hm();
            c.Ff().R(xVar2);
        }
    }

    static void x(x xVar) {
        String str = xVar.field_username;
        Context context = ad.getContext();
        if (str.equals("qqsync")) {
            xVar.dc(context.getString(R.l.eoS));
            xVar.dd(context.getString(R.l.eoT));
            xVar.de(context.getString(R.l.eoU));
        }
        if (str.equals("floatbottle")) {
            xVar.dc(context.getString(R.l.eoa));
            xVar.dd(context.getString(R.l.eob));
            xVar.de(context.getString(R.l.eoc));
        }
        if (str.equals("shakeapp")) {
            xVar.dc(context.getString(R.l.eoZ));
            xVar.dd(context.getString(R.l.epa));
            xVar.de(context.getString(R.l.epb));
        }
        if (str.equals("lbsapp")) {
            xVar.dc(context.getString(R.l.eot));
            xVar.dd(context.getString(R.l.eou));
            xVar.de(context.getString(R.l.eov));
        }
        if (str.equals("medianote")) {
            xVar.dc(context.getString(R.l.eoC));
            xVar.dd(context.getString(R.l.eoD));
            xVar.de(context.getString(R.l.eoE));
        }
        if (str.equals("newsapp")) {
            xVar.dc(context.getString(R.l.eoV));
            xVar.dd(context.getString(R.l.eoW));
            xVar.de(context.getString(R.l.eoX));
        }
        if (str.equals("facebookapp")) {
            xVar.dc(context.getString(R.l.eoh));
            xVar.dd(context.getString(R.l.eoi));
            xVar.de(context.getString(R.l.eoj));
        }
        if (str.equals("qqfriend")) {
            xVar.dc(context.getString(R.l.eoM));
            xVar.dd(context.getString(R.l.eoN));
            xVar.de(context.getString(R.l.eoO));
        }
        if (str.equals("masssendapp")) {
            xVar.dc(context.getString(R.l.eoz));
            xVar.dd(context.getString(R.l.eoA));
            xVar.de(context.getString(R.l.eoB));
        }
        if (str.equals("feedsapp")) {
            xVar.dc(context.getString(R.l.eok));
            xVar.dd(context.getString(R.l.eol));
            xVar.de(context.getString(R.l.eom));
        }
        if (str.equals("fmessage")) {
            xVar.dc(context.getString(R.l.eon));
            xVar.dd(context.getString(R.l.eoo));
            xVar.de(context.getString(R.l.eop));
        }
        if (str.equals("voipapp")) {
            xVar.dc(context.getString(R.l.epg));
            xVar.dd(context.getString(R.l.eph));
            xVar.de(context.getString(R.l.epi));
        }
        if (str.equals("officialaccounts")) {
            xVar.dc(context.getString(R.l.eoJ));
            xVar.dd(context.getString(R.l.eoK));
            xVar.de(context.getString(R.l.eoL));
        }
        if (str.equals("helper_entry")) {
            xVar.dc(context.getString(R.l.eoq));
            xVar.dd(context.getString(R.l.eor));
            xVar.de(context.getString(R.l.eos));
        }
        if (str.equals("cardpackage")) {
            xVar.dc(context.getString(R.l.eod));
            xVar.dd(context.getString(R.l.eoe));
            xVar.de(context.getString(R.l.eog));
        }
        if (str.equals("voicevoipapp")) {
            xVar.dc(context.getString(R.l.epj));
            xVar.dd(context.getString(R.l.epk));
            xVar.de(context.getString(R.l.epl));
        }
        if (str.equals("voiceinputapp")) {
            xVar.dc(context.getString(R.l.epd));
            xVar.dd(context.getString(R.l.epe));
            xVar.de(context.getString(R.l.epf));
        }
        if (str.equals("qqmail")) {
            xVar.dc(context.getString(R.l.eoP));
            xVar.dd(context.getString(R.l.eoQ));
            xVar.de(context.getString(R.l.eoR));
        }
        if (str.equals("linkedinplugin")) {
            xVar.dc(context.getString(R.l.eow));
            xVar.dd(context.getString(R.l.eox));
            xVar.de(context.getString(R.l.eoy));
        }
        if (str.equals("notifymessage")) {
            xVar.dc(context.getString(R.l.eoG));
            xVar.dd(context.getString(R.l.eoH));
            xVar.de(context.getString(R.l.eoI));
        }
        if (str.equals("appbrandcustomerservicemsg")) {
            xVar.dc(context.getString(R.l.enX));
            xVar.dd(context.getString(R.l.enY));
            xVar.de(context.getString(R.l.enZ));
        }
    }
}
