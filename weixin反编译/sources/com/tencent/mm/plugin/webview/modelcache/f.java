package com.tencent.mm.plugin.webview.modelcache;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.f.b.en;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class f extends en {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "urlMd5Hashcode";
        aVar.xrT.put("urlMd5Hashcode", "INTEGER");
        stringBuilder.append(" urlMd5Hashcode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.xrT.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "domain";
        aVar.xrT.put("domain", "TEXT");
        stringBuilder.append(" domain TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "version";
        aVar.xrT.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "localPath";
        aVar.xrT.put("localPath", "TEXT");
        stringBuilder.append(" localPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = DownloadInfo.CONTENTTYPE;
        aVar.xrT.put(DownloadInfo.CONTENTTYPE, "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "contentLength";
        aVar.xrT.put("contentLength", "LONG");
        stringBuilder.append(" contentLength LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "isLatestVersion";
        aVar.xrT.put("isLatestVersion", "INTEGER");
        stringBuilder.append(" isLatestVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "createTime";
        aVar.xrT.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "accessTime";
        aVar.xrT.put("accessTime", "LONG");
        stringBuilder.append(" accessTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "expireTime";
        aVar.xrT.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "cacheType";
        aVar.xrT.put("cacheType", "INTEGER");
        stringBuilder.append(" cacheType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "configId";
        aVar.xrT.put("configId", "TEXT");
        stringBuilder.append(" configId TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "protocol";
        aVar.xrT.put("protocol", "INTEGER");
        stringBuilder.append(" protocol INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "packageId";
        aVar.xrT.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "contentMd5";
        aVar.xrT.put("contentMd5", "TEXT");
        stringBuilder.append(" contentMd5 TEXT");
        aVar.columns[17] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + " {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebViewCacheRes", e, "", new Object[0]);
        }
        return stringBuilder.append(" }").toString();
    }
}
