package com.tencent.mm.crash;

import android.app.IntentService;
import android.content.Intent;
import android.os.Build;
import com.tencent.mm.a.c;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class CrashUploaderService extends IntentService {
    static final HashMap<String, Integer> gKR;

    public CrashUploaderService() {
        super("CrashUploaderService");
    }

    static {
        HashMap hashMap = new HashMap(16);
        gKR = hashMap;
        hashMap.put("exception", Integer.valueOf(10001));
        gKR.put("anr", Integer.valueOf(10002));
        gKR.put("handler", Integer.valueOf(10003));
        gKR.put("sql", Integer.valueOf(10004));
        gKR.put("permission", Integer.valueOf(10005));
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            File file;
            String stringExtra = intent.getStringExtra("INTENT_EXTRA_EXCEPTION_MSG");
            String stringExtra2 = intent.getStringExtra("INTENT_EXTRA_USER_NAME");
            String stringExtra3 = intent.getStringExtra("INTENT_EXTRA_SDCARD_PATH");
            String stringExtra4 = intent.getStringExtra("INTENT_EXTRA_DATA_PATH");
            String stringExtra5 = intent.getStringExtra("INTENT_EXTRA_UIN");
            int i = 0;
            try {
                i = Integer.decode(intent.getStringExtra("INTENT_EXTRA_CLIENT_VERSION")).intValue();
            } catch (Error e) {
            }
            String stringExtra6 = intent.getStringExtra("INTENT_EXTRA_DEVICE_TYPE");
            String stringExtra7 = intent.getStringExtra("INTENT_EXTRA_HOST");
            String stringExtra8 = intent.getStringExtra("INTENT_EXTRA_TAG");
            if (stringExtra8 == null || stringExtra8.length() == 0) {
                stringExtra8 = "exception";
            }
            String str = (stringExtra2 + "," + stringExtra6 + "_" + i + "_" + Build.CPU_ABI + ",") + "exception,time_" + bi.Wx() + ",error_" + stringExtra;
            try {
                file = new File(stringExtra3);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            if (bi.bA(file2.lastModified()) > 2592000000L) {
                                file2.delete();
                            }
                        }
                    }
                } else {
                    file.mkdirs();
                }
                i(stringExtra3 + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()) + ".txt", str, stringExtra5);
            } catch (Exception e2) {
            }
            file = new File(stringExtra4);
            if (!file.exists()) {
                file.mkdir();
            }
            stringExtra = stringExtra4 + stringExtra5;
            File file3 = new File(stringExtra);
            if (file3.length() > HardCoderJNI.ACTION_NET_TX) {
                file3.delete();
            }
            i(stringExtra, str, stringExtra5);
            byte[] e3 = e.e(stringExtra, 0, -1);
            if (!bi.by(e3) && a(stringExtra2, e3, i, stringExtra6, stringExtra7, stringExtra8)) {
                file3.delete();
            }
        }
    }

    private static void i(String str, String str2, String str3) {
        if (!new File(str).exists()) {
            StringBuilder stringBuilder = new StringBuilder();
            if (bi.oN(str3) || str3.equals("0")) {
                stringBuilder.append("uin[" + Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode()) + "] ");
            } else {
                stringBuilder.append("uin[" + str3 + "] ");
            }
            stringBuilder.append(x.cfZ());
            stringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
            stringBuilder.append("\n");
            e.d(str, stringBuilder.toString().getBytes());
        }
        e.d(str, (str2 + "\n").getBytes());
    }

    private static boolean a(String str, byte[] bArr, int i, String str2, String str3, String str4) {
        String toLowerCase = g.s(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}).getBytes()).toLowerCase();
        byte[] q = q.q(bArr);
        PByteArray pByteArray = new PByteArray();
        c.a(pByteArray, q, toLowerCase.getBytes());
        StringBuilder append = new StringBuilder().append(str3).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(i)).append("&devicetype=").append(str2).append("&filelength=").append(r0).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=").append(bi.e((Integer) gKR.get(str4)));
        if (!(str == null || str.equals(""))) {
            append.append("&username=").append(str);
        }
        try {
            HttpClient defaultHttpClient = new DefaultHttpClient();
            HttpUriRequest httpPost = new HttpPost(append.toString());
            HttpEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPost.setEntity(byteArrayEntity);
            x.i("MicroMsg.CrashUploaderService", bi.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()));
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CrashUploaderService", e, "", new Object[0]);
            return false;
        }
    }
}
