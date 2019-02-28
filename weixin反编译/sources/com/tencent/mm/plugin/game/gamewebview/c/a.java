package com.tencent.mm.plugin.game.gamewebview.c;

import android.net.Uri;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.akw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class a {
    public static String aAM;
    public static List<akw> ndD;
    public static String ndE = "";
    public static String ndF;
    public static Map<Integer, String> ndG = new HashMap();
    public static String uin;

    public static String b(String str, String str2, JSONObject jSONObject) {
        if (ndG.containsKey(Integer.valueOf(str.hashCode()))) {
            return (String) ndG.remove(Integer.valueOf(str.hashCode()));
        }
        if (str2.equalsIgnoreCase("POST")) {
            return b(str, jSONObject);
        }
        if (str2.equalsIgnoreCase("GET")) {
            return a(str, jSONObject);
        }
        return null;
    }

    public static void c(String str, String str2, JSONObject jSONObject) {
        ndG.put(Integer.valueOf(str.hashCode()), b(str, str2, jSONObject));
    }

    private static String a(String str, JSONObject jSONObject) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Cp(c(str, jSONObject))).openConnection();
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(false);
            f(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            x.i("MicroMsg.GameWebViewRequest", "GET, code = " + responseCode);
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String n = n(inputStream);
                inputStream.close();
                x.d("MicroMsg.GameWebViewRequest", n);
                return n;
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewRequest", e.getMessage());
        }
        return null;
    }

    private static String b(String str, JSONObject jSONObject) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            f(httpURLConnection);
            if (jSONObject != null) {
                String jSONObject2 = jSONObject.toString();
                if (jSONObject2 != null) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, ProtocolPackage.ServerEncoding));
                    bufferedWriter.write(jSONObject2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            x.i("MicroMsg.GameWebViewRequest", "POST, code = " + responseCode);
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String n = n(inputStream);
                inputStream.close();
                x.d("MicroMsg.GameWebViewRequest", n);
                return n;
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewRequest", e.getMessage());
        }
        return null;
    }

    private static String c(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            String str2;
            Uri parse = Uri.parse(str);
            String query = parse.getQuery();
            Iterator keys = jSONObject.keys();
            if (bi.oN(query)) {
                query = "";
            } else {
                query = query + "&";
            }
            while (true) {
                str2 = query;
                if (!keys.hasNext()) {
                    break;
                }
                query = (String) keys.next();
                query = str2 + query + "=" + jSONObject.optString(query) + "&";
            }
            try {
                str = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str2.substring(0, str2.lastIndexOf("&")), parse.getFragment()).toString();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GameWebViewRequest", e, "", new Object[0]);
            }
            x.d("MicroMsg.GameWebViewRequest", "url: " + str);
        }
        return str;
    }

    private static String Cp(String str) {
        if (!(bi.oN(uin) || bi.oN(aAM) || bi.oN(ndF))) {
            String str2;
            Uri parse = Uri.parse(str);
            String query = parse.getQuery();
            if (bi.oN(query)) {
                query = "";
            } else {
                query = query + "&";
            }
            if (!bi.oN(uin)) {
                query = query + "uin=" + uin + "&";
            }
            if (!bi.oN(aAM)) {
                query = query + "key=" + aAM + "&";
            }
            if (bi.oN(ndF)) {
                str2 = query;
            } else {
                str2 = query + "pass_ticket=" + ndF;
            }
            try {
                str = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str2, parse.getFragment()).toString();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GameWebViewRequest", e, "", new Object[0]);
            }
            x.d("MicroMsg.GameWebViewRequest", "url: " + str);
        }
        return str;
    }

    private static void f(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setRequestProperty("User-agent", ndE);
        for (akw akw : ndD) {
            httpURLConnection.setRequestProperty(akw.vUa, akw.pWq);
        }
    }

    private static String n(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray(), ProtocolPackage.ServerEncoding);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                x.e("MicroMsg.GameWebViewRequest", "inputStream2Str: " + e.getMessage());
                return "";
            }
        }
    }

    public static void h(String str, List<akw> list) {
        if (!bi.oN(str)) {
            Uri parse = Uri.parse(str);
            uin = parse.getQueryParameter(OpenSDKTool4Assistant.EXTRA_UIN);
            aAM = parse.getQueryParameter("key");
            ndF = parse.getQueryParameter("pass_ticket");
        }
        ndD = list;
    }
}
