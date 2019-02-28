package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.x;

final class b {
    static void c(String str, l lVar) {
        q SB = a.voG.SB(str);
        if (SB == null) {
            x.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "networkRequest already completed, but get null record with urlKey = %s", str);
        } else if ("WebViewCache".equals(SB.field_groupId1)) {
            SB.field_contentType = lVar.aBD;
            a.voG.g(SB);
            f fVar = new f(SB.field_url, SB.field_filePath, SB.field_fileVersion, SB.field_appId, SB.field_groupId2, SB.field_packageId, SB.field_wvCacheType, lVar.aBD, lVar.fNf, lVar.vox);
            WebViewCacheDownloadHelper.bSd();
            WebViewCacheDownloadHelper.a(fVar);
        } else {
            x.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "mismatch groupId, urlKey = %s, record.groupId = %s", str, SB.field_groupId1);
        }
    }
}
