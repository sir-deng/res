package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONStringer;

public final class ai {
    public static String OT(String str) {
        File file = new File(e.gJf);
        if (!file.mkdirs()) {
            x.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + file.exists());
        }
        if (!file.exists()) {
            x.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", e.gJf);
        }
        x.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", str, file.getAbsolutePath() + File.separator + str + ".jpg");
        return file.getAbsolutePath() + File.separator + str + ".jpg";
    }

    public static Intent OU(String str) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(new File(OT(str))));
        return intent;
    }

    public static Intent bRF() {
        return new Intent("android.media.action.VIDEO_CAPTURE");
    }

    public static Intent bRG() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    public static String OV(String str) {
        x.i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", str);
        if (bi.oN(str)) {
            return null;
        }
        x.i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", str, "weixin://resourceid/" + ac.VF(str));
        return "weixin://resourceid/" + ac.VF(str);
    }

    public static String OW(String str) {
        WebViewJSSDKFileItem OS = f.bSo().OS(str);
        if (OS != null) {
            x.i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", OS.jlG);
            return OS.jlG;
        }
        x.e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", str);
        return null;
    }

    public static String X(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return jSONArray.toString();
            }
            jSONArray.put((String) arrayList.get(i2));
            i = i2 + 1;
        }
    }

    public static String Y(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            return "";
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            for (int i = 0; i < arrayList.size(); i++) {
                String str = (String) arrayList.get(i);
                jSONStringer.key("localId");
                jSONStringer.value(str);
            }
            jSONStringer.endObject();
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            return "";
        }
    }

    public static String b(String str, String str2, int i, int i2, int i3, int i4) {
        if (bi.oN(str)) {
            x.e("MicroMsg.WebviewJSSDKUtil", "parseVideoItemToJson localId is null");
            return "";
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            jSONStringer.key("localId");
            jSONStringer.value(str);
            jSONStringer.key("thumbLocalId");
            jSONStringer.value(str2);
            jSONStringer.key(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
            jSONStringer.value(String.valueOf(i));
            jSONStringer.key("height");
            jSONStringer.value(String.valueOf(i2));
            jSONStringer.key("width");
            jSONStringer.value(String.valueOf(i3));
            jSONStringer.key("size");
            jSONStringer.value(String.valueOf(i4));
            jSONStringer.endObject();
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            return "";
        }
    }

    private static InputStream OX(String str) {
        x.i("MicroMsg.WebviewJSSDKUtil", "getDataFromLocalId : %s", str);
        if (bi.oN(str) || bi.oN(str) || !com.tencent.mm.a.e.bO(str)) {
            return null;
        }
        try {
            return new FileInputStream(str);
        } catch (Exception e) {
            x.e("MicroMsg.WebviewJSSDKUtil", "init file input stream error : %s", e.getMessage());
            return null;
        }
    }

    public static InputStream OY(String str) {
        if (!bi.oN(str)) {
            return OX(str);
        }
        x.e("MicroMsg.WebviewJSSDKUtil", "local is is null or nil");
        return null;
    }

    public static String OZ(String str) {
        return "_USER_FOR_WEBVIEW_JSAPI" + o.k(str, bi.Wy());
    }
}
