package com.tencent.mm.plugin.photoedit;

import com.tencent.mm.R;
import com.tencent.mm.ap.l;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class PhotoEditProxy extends a {
    public PhotoEditProxy(d dVar) {
        super(dVar);
    }

    public int doFav(String str) {
        return ((Integer) REMOTE_CALL("doFavInMM", str)).intValue();
    }

    public void sendImage(String str, String str2, String str3, String str4) {
        REMOTE_CALL("sendImageInMM", str, str2, str3, str4);
    }

    public boolean isAutoSave() {
        return ((Boolean) REMOTE_CALL("isAutoSavePhotoInMM", new Object[0])).booleanValue();
    }

    public String getSelfUsername() {
        return (String) REMOTE_CALL("getSelfUsernameInMM", new Object[0]);
    }

    public String getFullPath(String str) {
        return (String) REMOTE_CALL("getFullPathInMM", str);
    }

    @f
    public void sendImageInMM(String str, String str2, String str3, String str4) {
        as.CN().a(new l(4, str3, str4, str2, 0, null, 0, "", "", true, R.g.bAI), 0);
        com.tencent.mm.plugin.messenger.a.f.aZN().dq(str, str4);
    }

    @f
    public String getSelfUsernameInMM() {
        return q.FY();
    }

    @f
    public boolean isAutoSavePhotoInMM() {
        as.Hm();
        return c.Db().getBoolean(w.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
    }

    @f
    public int doFavInMM(String str) {
        cg cgVar = new cg();
        com.tencent.mm.pluginsdk.model.f.a(cgVar, 2, str);
        cgVar.frk.frr = 44;
        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
        x.i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", str);
        return cgVar.frl.ret;
    }

    @f
    public String getFullPathInMM(String str) {
        return o.PC().getFullPath(str);
    }
}
