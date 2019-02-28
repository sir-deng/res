package com.tencent.mm.plugin.aj.a;

import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public final class g {
    private static Map<Integer, k> tqO = new HashMap();
    private static Map<Integer, c> tqP = new HashMap();

    public static Properties o(File file) {
        Throwable e;
        Properties properties = new Properties();
        if (file != null && file.isFile()) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    e.c(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
                        e.c(fileInputStream);
                        return properties;
                    } catch (Throwable th) {
                        e = th;
                        e.c(fileInputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
                e.c(fileInputStream);
                return properties;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                e.c(fileInputStream);
                throw e;
            }
        }
        return properties;
    }

    public static final String zZ(int i) {
        StringBuilder append = new StringBuilder().append(i).append("_");
        com.tencent.mm.kernel.g.Do();
        return append.append(o.getString(a.Cn())).append("_").append(System.currentTimeMillis()).toString();
    }

    static {
        tqO.put(Integer.valueOf(1), new k("fts_browse/res", "wrd_template.zip", "browse"));
        tqO.put(Integer.valueOf(0), new k("fts/res", "fts_template.zip", ""));
        Map map = tqP;
        Integer valueOf = Integer.valueOf(0);
        Ab(0);
        map.put(valueOf, j.bPK());
        map = tqP;
        valueOf = Integer.valueOf(1);
        Ab(1);
        map.put(valueOf, j.bPK());
    }

    public static k Aa(int i) {
        return (k) tqO.get(Integer.valueOf(i));
    }

    private static String Ab(int i) {
        return ((k) tqO.get(Integer.valueOf(i))).Ro() + File.separator + "app.html";
    }

    public static String bPF() {
        tqO.get(Integer.valueOf(1));
        return "app.html";
    }

    public static String bPG() {
        tqO.get(Integer.valueOf(1));
        return "config.conf";
    }

    public static void bPH() {
        Iterator it = tqP.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public static void Ac(int i) {
        ((c) tqP.get(Integer.valueOf(i))).bPD();
    }

    public static int Ad(int i) {
        k kVar = (k) tqO.get(Integer.valueOf(i));
        String str = TextUtils.isEmpty(kVar.trd) ? "config.conf" : kVar.trd + File.separator + "config.conf";
        AssetManager assets = ad.getContext().getAssets();
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = assets.open(str);
            properties.load(inputStream);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, e.getMessage(), new Object[0]);
        } finally {
            e.c(inputStream);
        }
        return Integer.valueOf(properties.getProperty("version", "1")).intValue();
    }

    public static boolean Ae(int i) {
        x.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", Integer.valueOf(i));
        return ((k) tqO.get(Integer.valueOf(i))).Np() > 1;
    }

    public static int Af(int i) {
        return ((k) tqO.get(Integer.valueOf(i))).Np();
    }

    public static boolean Ag(int i) {
        OutputStream outputStream = null;
        AssetManager assets = ad.getContext().getAssets();
        String bPN = ((k) tqO.get(Integer.valueOf(i))).bPN();
        k kVar = (k) tqO.get(Integer.valueOf(i));
        String str = TextUtils.isEmpty(kVar.trd) ? kVar.trc : kVar.trd + File.separator + kVar.trc;
        if (bi.oN(bPN) || bi.oN(str)) {
            x.w("MicroMsg.WebSearch.WebSearchApiLogic", "copyTemplateFromAsset no dstPath or template path!");
            return false;
        }
        InputStream open;
        try {
            open = assets.open(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            x.e("MicroMsg.WebSearch.WebSearchApiLogic", "file inputStream not found");
            return false;
        }
        File file = new File(bPN);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            outputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                d(open, outputStream);
                return true;
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e22, "", new Object[0]);
                return false;
            } finally {
                e.c(open);
                e.a(outputStream);
            }
        } else {
            e.c(open);
            return false;
        }
    }

    private static void d(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String Ah(int i) {
        return ((k) tqO.get(Integer.valueOf(i))).bPN();
    }

    public static int Ai(int i) {
        return ((k) tqO.get(Integer.valueOf(i))).bPL();
    }

    public static String Aj(int i) {
        return ((k) tqO.get(Integer.valueOf(i))).Ro();
    }

    public static String Ak(int i) {
        return ((k) tqO.get(Integer.valueOf(An(i)))).Ro();
    }

    public static String Al(int i) {
        return ((k) tqO.get(Integer.valueOf(An(i)))).trc;
    }

    public static int Am(int i) {
        return ((k) tqO.get(Integer.valueOf(An(i)))).Np();
    }

    private static int An(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return -1;
        }
    }

    public static String bPI() {
        return o(new File(((k) tqO.get(Integer.valueOf(1))).Ro(), "config_data.conf")).getProperty("kv_set", "");
    }

    public static String bgl() {
        if (ao.isWifi(ad.getContext())) {
            return "wifi";
        }
        if (ao.is4G(ad.getContext())) {
            return "4g";
        }
        if (ao.is3G(ad.getContext())) {
            return "3g";
        }
        if (ao.is2G(ad.getContext())) {
            return "2g";
        }
        if (ao.isConnected(ad.getContext())) {
            return "";
        }
        return "fail";
    }

    public static aou Jk() {
        try {
            String str = (String) com.tencent.mm.kernel.g.Dq().Db().get(67591, null);
            if (str != null) {
                aou aou = new aou();
                String[] split = str.split(",");
                aou.wjv = Integer.valueOf(split[0]).intValue();
                aou.wjy = Integer.valueOf(split[1]).intValue();
                aou.vXy = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                aou.vXx = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                x.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", Float.valueOf(aou.vXy), Float.valueOf(aou.vXx));
                return aou;
            }
            x.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            x.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", e.getMessage());
            return null;
        }
    }
}
