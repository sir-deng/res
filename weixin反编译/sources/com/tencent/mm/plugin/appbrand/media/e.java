package com.tencent.mm.plugin.appbrand.media;

import android.text.TextUtils;
import com.tencent.mm.ab.a;
import com.tencent.mm.ab.d;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.media.a.c;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e {
    public static a b(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            x.e("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam, sourceData or src is null, sourceData:%s, src:%s", str4, str3);
            return null;
        }
        x.i("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam audioId:%s, sourceData:%s", str2, str4);
        a aVar = new a();
        aVar.appId = str;
        aVar.foy = str2;
        aVar.processName = str6;
        aVar.hmc = str3;
        aVar.fromScene = 0;
        try {
            JSONObject jSONObject = new JSONObject(str4);
            int optInt = jSONObject.optInt("startTime", 0);
            boolean optBoolean = jSONObject.optBoolean("autoplay", false);
            boolean optBoolean2 = jSONObject.optBoolean("loop", false);
            double optDouble = jSONObject.optDouble("volume", 1.0d);
            aVar.hmd = optInt;
            aVar.hme = optInt;
            aVar.hmf = optBoolean;
            aVar.hmg = optBoolean2;
            aVar.hmi = optDouble;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", e, "parseAudioPlayParam", new Object[0]);
        }
        if (str3.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            aVar.filePath = str3.substring(9);
            x.i("MicroMsg.Audio.AudioPlayerParamParser", "filePath:%s", aVar.filePath);
            return aVar;
        } else if (str3.startsWith("http://") || str3.startsWith("https://")) {
            return aVar;
        } else {
            d bB = c.bB(str3, str5);
            if (bB.isOpen()) {
                aVar.filePath = str3;
                aVar.hmj = bB;
                return aVar;
            }
            x.e("MicroMsg.Audio.AudioPlayerParamParser", "the wxa audioDataSource not found for src %s", str3);
            try {
                bB.close();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", e2, "", new Object[0]);
            }
            return null;
        }
    }
}
