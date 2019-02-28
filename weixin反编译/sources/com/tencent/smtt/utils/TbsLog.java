package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.List;

public class TbsLog {
    private static boolean AkH = false;
    private static boolean AkI = true;
    private static t AkJ = null;
    public static final int TBSLOG_CODE_SDK_BASE = 1000;
    public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
    public static final int TBSLOG_CODE_SDK_INIT = 999;
    public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
    public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
    public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
    public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
    public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
    public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
    public static final String X5LOGTAG = "x5logtag";
    public static int sLogMaxCount = 10;
    public static List<String> sTbsLogList = new LinkedList();

    public static void addLog(int i, String str, Object... objArr) {
        synchronized (sTbsLogList) {
            try {
                if (sTbsLogList.size() > sLogMaxCount) {
                    int size = sTbsLogList.size() - sLogMaxCount;
                    while (true) {
                        int i2 = size - 1;
                        if (size <= 0 || sTbsLogList.size() <= 0) {
                            break;
                        }
                        sTbsLogList.remove(0);
                        size = i2;
                    }
                }
                String str2 = null;
                if (str != null) {
                    try {
                        str2 = String.format(str, objArr);
                    } catch (Exception e) {
                    }
                }
                if (str2 == null) {
                    str2 = "";
                }
                sTbsLogList.add(String.format("[%d][%d][%c][%d]%s", new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(1), Character.valueOf('0'), Integer.valueOf(i), str2}));
            } catch (Exception e2) {
            }
        }
    }

    public static void app_extra(String str, Context context) {
        int i = 0;
        try {
            Context applicationContext = context.getApplicationContext();
            String[] strArr = new String[]{"com.tencent.tbs", "com.tencent.mtt", "com.tencent.mm", "com.tencent.mobileqq", "com.tencent.mtt.sdk.test", "com.qzone"};
            String[] strArr2 = new String[]{"DEMO", "QB", "WX", "QQ", "TEST", "QZ"};
            while (i < 6) {
                if (applicationContext.getPackageName().contains(strArr[i])) {
                    i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + strArr2[i] + "!");
                    break;
                }
                i++;
            }
            if (i == 6) {
                i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
            }
        } catch (Throwable th) {
            w(str, "app_extra exception:" + Log.getStackTraceString(th));
        }
    }

    public static void d(String str, String str2) {
        if (AkJ != null) {
        }
    }

    public static void d(String str, String str2, boolean z) {
        d(str, str2);
        if (AkJ != null && AkH && z) {
            AkJ.acb(str + ": " + str2);
        }
    }

    public static void e(String str, String str2) {
        if (AkJ != null) {
            AkJ.bu("(E)-" + str + "-TBS:" + str2);
        }
    }

    public static void e(String str, String str2, boolean z) {
        e(str, str2);
        if (AkJ != null && AkH && z) {
            AkJ.acb(str + ": " + str2);
        }
    }

    public static String getTbsLogFilePath() {
        return t.AkL != null ? t.AkL.getAbsolutePath() : null;
    }

    public static void i(String str, String str2) {
        if (AkJ != null) {
            AkJ.bu("(I)-" + str + "-TBS:" + str2);
        }
    }

    public static void i(String str, String str2, boolean z) {
        i(str, str2);
        if (AkJ != null && AkH && z) {
            AkJ.acb(str + ": " + str2);
        }
    }

    public static synchronized void initIfNeed(Context context) {
        synchronized (TbsLog.class) {
            if (AkJ == null) {
                setTbsLogClient(new t(context));
            }
        }
    }

    public static void setLogView(TextView textView) {
        if (textView != null && AkJ != null) {
            AkJ.setLogView(textView);
        }
    }

    public static boolean setTbsLogClient(t tVar) {
        if (tVar == null) {
            return false;
        }
        AkJ = tVar;
        t.setWriteLogJIT(AkI);
        return true;
    }

    public static void setWriteLogJIT(boolean z) {
        AkI = z;
        if (AkJ != null) {
            t.setWriteLogJIT(z);
        }
    }

    public static void v(String str, String str2) {
        if (AkJ != null) {
        }
    }

    public static void v(String str, String str2, boolean z) {
        v(str, str2);
        if (AkJ != null && AkH && z) {
            AkJ.acb(str + ": " + str2);
        }
    }

    public static void w(String str, String str2) {
        if (AkJ != null) {
            AkJ.bu("(W)-" + str + "-TBS:" + str2);
        }
    }

    public static void w(String str, String str2, boolean z) {
        w(str, str2);
        if (AkJ != null && AkH && z) {
            AkJ.acb(str + ": " + str2);
        }
    }

    public static synchronized void writeLogToDisk() {
        synchronized (TbsLog.class) {
            if (AkJ != null) {
                AkJ.writeLogToDisk();
            }
        }
    }
}
