package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import com.tencent.mm.ac.n;
import com.tencent.mm.bp.b;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.ccu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class p extends i<WxaAttributes> {
    public final h hiZ;

    public final /* synthetic */ boolean a(c cVar, boolean z) {
        cVar = (WxaAttributes) cVar;
        cVar.field_usernameHash = cVar.field_username.hashCode();
        super.a(cVar, z);
        return f("username", "appId") != null;
    }

    public final /* synthetic */ boolean b(c cVar, boolean z, String[] strArr) {
        WxaAttributes wxaAttributes = (WxaAttributes) cVar;
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        return super.b(wxaAttributes, z, strArr);
    }

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        return a((WxaAttributes) cVar, strArr);
    }

    public p(h hVar) {
        super(hVar, WxaAttributes.iHi, "WxaAttributesTable", WxaAttributes.fNF);
        this.hiZ = hVar;
    }

    public final WxaAttributes f(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        if (!bi.oN(str) && str.endsWith("@app")) {
            Cursor a = this.hiZ.a("WxaAttributesTable", bi.G(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"usernameHash"}), new String[]{String.valueOf(str.hashCode())}, null, null, null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.b(a);
                    wxaAttributes.field_username = str;
                }
                a.close();
            }
        }
        return wxaAttributes;
    }

    public final WxaAttributes g(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        if (!bi.oN(str)) {
            Cursor a = this.hiZ.a("WxaAttributesTable", bi.G(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"appId"}), new String[]{str}, null, null, null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.b(a);
                    wxaAttributes.field_appId = str;
                }
                a.close();
            }
        }
        return wxaAttributes;
    }

    final long rh(String str) {
        WxaAttributes f = f(str, "appInfo");
        if (f == null || f.acq() == null) {
            return 0;
        }
        return f.acq().iMP;
    }

    public final boolean a(String str, b bVar, List<ccu> list) {
        if (bi.cC(list)) {
            return false;
        }
        int i;
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        if (a(wxaAttributes, "username")) {
            boolean i2 = false;
        } else {
            i2 = 1;
        }
        int i3 = 0;
        for (ccu ccu : list) {
            if (ccu != null) {
                i3 = a(wxaAttributes, ccu) | i3;
            }
        }
        if (i3 != 0) {
            if (i2 != 0) {
                b((c) wxaAttributes);
            } else {
                c(wxaAttributes, "username");
            }
            try {
                if (g.Do().CF()) {
                    com.tencent.mm.ac.h hVar;
                    int i4;
                    boolean i42;
                    ag xVar;
                    String str2 = wxaAttributes.field_username;
                    String str3 = wxaAttributes.field_nickname;
                    String str4 = wxaAttributes.field_bigHeadURL;
                    String str5 = wxaAttributes.field_smallHeadURL;
                    com.tencent.mm.ac.h jp = n.JW().jp(str2);
                    if (jp == null) {
                        hVar = new com.tencent.mm.ac.h();
                        i42 = 1;
                    } else {
                        hVar = jp;
                        i42 = false;
                    }
                    if (!bi.oM(str5).equals(hVar.JN())) {
                        hVar.hnh = str5;
                        i42 = 1;
                    }
                    if (!bi.oM(str4).equals(hVar.JM())) {
                        hVar.hni = str4;
                        i42 = 1;
                    }
                    if (i42 != 0) {
                        hVar.username = str2;
                        hVar.bC(true);
                        hVar.fEo = 31;
                        n.JW().a(hVar);
                    }
                    ag Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(str2);
                    if (Xv == null) {
                        xVar = new x();
                    } else {
                        xVar = Xv;
                    }
                    if (((int) xVar.gKO) == 0) {
                        xVar.setUsername(str2);
                        i42 = 1;
                    } else {
                        i42 = false;
                    }
                    if (!str3.equals(xVar.field_nickname)) {
                        xVar.dc(str3);
                        xVar.dd(com.tencent.mm.platformtools.c.oE(str3));
                        xVar.de(com.tencent.mm.platformtools.c.oD(str3));
                        i42 = 1;
                    }
                    if (i42 != 0) {
                        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Q(xVar);
                    }
                }
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WxaAttrStorage", e, "flushContactInMainDB", new Object[0]);
            }
        }
        e.Zz().a(wxaAttributes.field_appId, wxaAttributes.acs());
        wxaAttributes.field_syncTimeSecond = bi.Wx();
        wxaAttributes.field_syncVersion = bi.bA(bVar == null ? new byte[0] : bVar.oz);
        c(wxaAttributes, "username");
        return i3;
    }

    private static boolean a(WxaAttributes wxaAttributes, ccu ccu) {
        if ("NickName".equals(ccu.vUa) && !aZ(ccu.pWq, wxaAttributes.field_nickname)) {
            wxaAttributes.field_nickname = bi.oM(ccu.pWq);
            return true;
        } else if ("BrandIconURL".equals(ccu.vUa) && !aZ(ccu.pWq, wxaAttributes.field_brandIconURL)) {
            wxaAttributes.field_brandIconURL = ccu.pWq;
            return true;
        } else if ("BigHeadImgUrl".equals(ccu.vUa) && !aZ(ccu.pWq, wxaAttributes.field_bigHeadURL)) {
            wxaAttributes.field_bigHeadURL = ccu.pWq;
            return true;
        } else if ("SmallHeadImgUrl".equals(ccu.vUa) && !aZ(ccu.pWq, wxaAttributes.field_smallHeadURL)) {
            wxaAttributes.field_smallHeadURL = ccu.pWq;
            return true;
        } else if (!"Signature".equals(ccu.vUa) || aZ(ccu.pWq, wxaAttributes.field_signature)) {
            if ("WxAppOpt".equals(ccu.vUa)) {
                int i = bi.getInt(ccu.pWq, 0);
                if (i != wxaAttributes.field_appOpt) {
                    wxaAttributes.field_appOpt = i;
                    return true;
                }
            }
            if ("RegisterSource".equals(ccu.vUa) && !aZ(ccu.pWq, wxaAttributes.field_registerSource)) {
                wxaAttributes.field_registerSource = ccu.pWq;
                return true;
            } else if ("WxaAppInfo".equals(ccu.vUa) && !aZ(ccu.pWq, wxaAttributes.field_appInfo)) {
                wxaAttributes.field_appInfo = ccu.pWq;
                try {
                    JSONObject jSONObject = new JSONObject(ccu.pWq);
                    wxaAttributes.field_appId = jSONObject.getString("Appid");
                    m.a(wxaAttributes.field_appId, n.h(jSONObject).vOA);
                    return true;
                } catch (Exception e) {
                    return true;
                }
            } else if ("WxaAppVersionInfo".equalsIgnoreCase(ccu.vUa) && !aZ(ccu.pWq, wxaAttributes.field_versionInfo)) {
                wxaAttributes.field_versionInfo = ccu.pWq;
                return true;
            } else if ("BindWxaInfo".equals(ccu.vUa) && !aZ(ccu.pWq, wxaAttributes.field_bindWxaInfo)) {
                wxaAttributes.field_bindWxaInfo = ccu.pWq;
                return true;
            } else if ("WxaAppDynamic".equals(ccu.vUa) && !aZ(ccu.pWq, wxaAttributes.field_dynamicInfo)) {
                wxaAttributes.field_dynamicInfo = ccu.pWq;
                return true;
            } else if (!"MMBizMenu".equals(ccu.vUa) || aZ(ccu.pWq, wxaAttributes.field_bizMenu)) {
                return false;
            } else {
                wxaAttributes.field_bizMenu = ccu.pWq;
                return true;
            }
        } else {
            wxaAttributes.field_signature = ccu.pWq;
            return true;
        }
    }

    private static boolean aZ(String str, String str2) {
        return bi.oM(str).equals(bi.oM(str2));
    }

    private boolean a(WxaAttributes wxaAttributes, String... strArr) {
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        return super.b((c) wxaAttributes, strArr);
    }
}
