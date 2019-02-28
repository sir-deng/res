package com.tencent.mm.plugin.appbrand.o;

import android.database.Cursor;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.s;
import java.util.Map;
import org.xwalk.core.R;

public final class a implements com.tencent.mm.storage.as.a {
    public final void a(ae aeVar, as asVar) {
        if (aeVar != null && !bi.oN(aeVar.field_username)) {
            String str = aeVar.field_username;
            com.tencent.mm.k.a Xv = ((h) g.h(h.class)).Ff().Xv(str);
            if (Xv == null || ((int) Xv.gKO) == 0) {
                x.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", str);
            } else if (com.tencent.mm.storage.x.fX(str) && !s.gU(str)) {
                x.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
                aeVar.dJ("appbrandcustomerservicemsg");
                ae XF = ((h) g.h(h.class)).Fk().XF("appbrandcustomerservicemsg");
                if (XF == null) {
                    x.i("MicroMsg.AppBrandConversionExtension", "create parentConv");
                    XF = new ae("appbrandcustomerservicemsg");
                    XF.cjn();
                    a(aeVar, XF);
                    ((h) g.h(h.class)).Fk().d(XF);
                    return;
                }
                x.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                XF.dJ(null);
                a(aeVar, XF);
                ((h) g.h(h.class)).Fk().a(XF, "appbrandcustomerservicemsg");
            } else if (s.hp(str)) {
                x.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                aeVar.dJ(null);
            }
        }
    }

    private static void a(ae aeVar, ae aeVar2) {
        ak akVar;
        au Fd;
        String str = null;
        Cursor c = ((h) g.h(h.class)).Fk().c(s.hgZ, null, "appbrandcustomerservicemsg");
        if (c != null) {
            ak akVar2;
            if (c.getCount() <= 0 || !c.moveToFirst()) {
                akVar2 = null;
            } else {
                akVar2 = new ae();
                akVar2.b(c);
            }
            c.close();
            akVar = akVar2;
        } else {
            akVar = null;
        }
        if (akVar != null) {
            x.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation username is %s", akVar.field_username);
            Fd = ((h) g.h(h.class)).aZO().Fd(akVar.field_username);
        } else {
            x.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation is null");
            Fd = ((h) g.h(h.class)).aZO().Fd(aeVar.field_username);
        }
        if (Fd == null || Fd.field_msgId <= 0) {
            x.e("MicroMsg.AppBrandConversionExtension", "the last of msg is null'");
            aeVar2.cjn();
            return;
        }
        aeVar2.ac(Fd);
        aeVar2.setContent(Fd.field_talker + ":" + Fd.field_content);
        aeVar2.dG(Integer.toString(Fd.getType()));
        b ux = ((h) g.h(h.class)).Fk().ux();
        if (ux != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            Fd.dU(aeVar.field_parentRef);
            Fd.setContent(aeVar2.field_content);
            ux.a(Fd, pString, pString2, pInt, true);
            int type = Fd.getType();
            String str2 = Fd.field_content;
            if (!bi.oN(str2)) {
                switch (type) {
                    case R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                        Map y = bj.y(str2, "msg");
                        if (y != null) {
                            x.d("MicroMsg.AppBrandConversionExtension", "[oneliang][parseConversationMsgContentTitle] title:%s", (String) y.get(".msg.appmsg.title"));
                            str = r0;
                            break;
                        }
                        break;
                }
            }
            aeVar2.dH(bi.oM(pString.value).concat(bi.oN(str) ? "" : " " + bi.oM(str)));
            aeVar2.dI(pString2.value);
            aeVar2.eT(pInt.value);
        }
    }
}
