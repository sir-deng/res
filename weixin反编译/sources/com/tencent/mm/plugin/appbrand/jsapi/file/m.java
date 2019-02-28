package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends a {
    private static final int CTRL_INDEX = 278;
    private static final String NAME = "getFileInfo";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String str;
        final String str2 = jVar.mAppId;
        final String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, "");
        if ("sha1".equalsIgnoreCase(jSONObject.optString("digestAlgorithm", "md5"))) {
            str = "sha1";
        } else {
            str = "md5";
        }
        if (bi.oN(optString)) {
            jVar.E(i, e("fail:invalid data", null));
            return;
        }
        final j jVar2 = jVar;
        final int i2 = i;
        e.post(new Runnable() {
            public final void run() {
                AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str2, optString);
                if (itemByLocalId == null) {
                    jVar2.E(i2, m.this.e("fail:file doesn't exist", null));
                    return;
                }
                File file = new File(itemByLocalId.hjJ);
                String str = str;
                Object obj = -1;
                switch (str.hashCode()) {
                    case 107902:
                        if (str.equals("md5")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 3528965:
                        if (str.equals("sha1")) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        obj = g.i(file);
                        break;
                    case 1:
                        obj = m.v(file);
                        break;
                    default:
                        obj = "";
                        break;
                }
                Map hashMap = new HashMap(2);
                hashMap.put("size", Long.valueOf(file.length()));
                hashMap.put("digest", obj);
                jVar2.E(i2, m.this.e("ok", hashMap));
            }
        }, "AppBrandJsApiGetFileInfo");
    }

    static String v(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            try {
                InputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    String bigInteger;
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            instance.update(bArr, 0, read);
                        } else {
                            bigInteger = new BigInteger(1, instance.digest()).toString(16);
                            try {
                                fileInputStream.close();
                                return bigInteger;
                            } catch (IOException e) {
                                x.e("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", e);
                                return bigInteger;
                            }
                        }
                    } catch (IOException e2) {
                        bigInteger = "";
                        try {
                            fileInputStream.close();
                            return bigInteger;
                        } catch (IOException e3) {
                            x.e("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", e3);
                            return bigInteger;
                        }
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e32) {
                            x.e("MicroMsg.JsApiGetFileInfo", "Exception on closing MD5 input stream", e32);
                        }
                        throw th;
                    }
                }
            } catch (FileNotFoundException e4) {
                x.e("MicroMsg.JsApiGetFileInfo", "Exception while getting FileInputStream", e4);
                return "";
            }
        } catch (NoSuchAlgorithmException e5) {
            x.e("MicroMsg.JsApiGetFileInfo", "Exception while getting Digest", e5);
            return "";
        }
    }
}
