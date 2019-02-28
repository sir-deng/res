package com.tencent.wework.api;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.wcdb.FileUtils;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import com.tencent.wework.api.utils.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class WWAPIImpl implements IWWAPI {
    private static final String[] AyF = new String[]{"com.tencent.wework", "com.tencent.weworklocal"};
    private String AyG;
    private BroadcastReceiver AyH = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                if (WWAPIImpl.this.AyG.equals(intent.getScheme())) {
                    final BaseMessage n = BaseMessage.n(intent.getData());
                    if (n instanceof WWBaseRespMessage) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                try {
                                    WWAPIImpl.this.qYo.get(((WWBaseRespMessage) n).transaction);
                                    WWAPIImpl.this.qYo.remove(((WWBaseRespMessage) n).transaction);
                                } catch (Throwable th) {
                                    Log.e("WWAPIImpl", "handle message failed", th);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                Log.w("WWAPIImpl", "invalid schema: " + intent.getScheme());
            } catch (Throwable th) {
                Log.e("WWAPIImpl", "handle broadcast failed", th);
            }
        }
    };
    private Context context;
    private Map<String, Object> qYo = new HashMap();

    public WWAPIImpl(Context context) {
        this.context = context;
    }

    public final boolean cIZ() {
        int acS;
        for (String str : AyF) {
            acS = acS(str);
            if (acS != 0) {
                Log.i("WWAPIImpl", "getWWAppSupportAPI, pkg: " + str + ", versioncode: " + acS);
                break;
            }
        }
        acS = 0;
        return acS >= 100;
    }

    public final String cJa() {
        String[] strArr = AyF;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                PackageManager packageManager = this.context.getPackageManager();
                str = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
                if (TextUtils.isEmpty(str)) {
                    return "企业微信";
                }
                return str;
            } catch (Throwable th) {
                Log.w("WWAPIImpl", "getWWAppName failed", th);
                i++;
            }
        }
        return "企业微信";
    }

    public final boolean a(BaseMessage baseMessage) {
        String[] strArr = AyF;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            String acR = acR(str);
            Log.d("WWAPIImpl", "isValidSignature, pkg: " + str + ", signature: " + acR);
            if ("011A40266C8C75D181DDD8E4DDC50075".equals(acR)) {
                Intent intent = new Intent("com.tencent.wework.apihost");
                intent.setClassName(str, "com.tencent.wework.apihost.WWAPIActivity");
                intent.addFlags(411041792);
                try {
                    baseMessage.setContext(this.context);
                    intent.putExtras(BaseMessage.b(baseMessage));
                    intent.putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.AyH.getClass()), 134217728));
                    this.context.startActivity(intent);
                    Log.i("WWAPIImpl", "sendMessage, start WWAPIActivity, pkg: " + str);
                    return true;
                } catch (Throwable th) {
                    Log.w("WWAPIImpl", "sendMessage failed, pkg: " + str, th);
                }
            } else {
                i++;
            }
        }
        return false;
    }

    private String acR(String str) {
        try {
            return bV(this.context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
        } catch (Throwable th) {
            Log.w("WWAPIImpl", "getSignature failed, pkg: " + str, th);
            return "";
        }
    }

    private int acS(String str) {
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(str, FileUtils.S_IWUSR);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.versionCode;
        } catch (Throwable th) {
            Log.w("WWAPIImpl", "getVersioncode failed, pkg: " + str, th);
            return 0;
        }
    }

    private static String bV(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                stringBuilder.append(Integer.toHexString((b & 240) >>> 4));
                stringBuilder.append(Integer.toHexString(b & 15));
            }
            return stringBuilder.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
