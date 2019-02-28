package com.tencent.recovery.log;

import android.os.Process;
import android.util.Log;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.storage.MMappedFileStorage;
import com.tencent.rtmp.sharp.jni.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecoveryFileLog implements RecoveryLogImpl {
    private MMappedFileStorage AaI;
    private SimpleDateFormat AaJ;
    private boolean AaK;

    public final synchronized void bs(String str, boolean z) {
        this.AaI.f(str.getBytes(), z);
    }

    public final void v(String str, String str2, Object... objArr) {
        bs(am("V", str, String.format(str2, objArr)), false);
        if (this.AaK) {
            String.format(str2, objArr);
        }
    }

    public final void i(String str, String str2, Object... objArr) {
        bs(am("I", str, String.format(str2, objArr)), false);
        if (this.AaK) {
            String.format(str2, objArr);
        }
    }

    public final void w(String str, String str2, Object... objArr) {
        bs(am(QLog.TAG_REPORTLEVEL_COLORUSER, str, String.format(str2, objArr)), false);
        if (this.AaK) {
            String.format(str2, objArr);
        }
    }

    public final void d(String str, String str2, Object... objArr) {
        bs(am(QLog.TAG_REPORTLEVEL_DEVELOPER, str, String.format(str2, objArr)), false);
        if (this.AaK) {
            String.format(str2, objArr);
        }
    }

    public final void e(String str, String str2, Object... objArr) {
        bs(am(QLog.TAG_REPORTLEVEL_USER, str, String.format(str2, objArr)), false);
        if (this.AaK) {
            String.format(str2, objArr);
        }
    }

    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        bs(am(QLog.TAG_REPORTLEVEL_USER, str, String.format(str2, objArr) + "  " + Log.getStackTraceString(th)), false);
        if (this.AaK) {
            String.format(str2, objArr);
        }
    }

    private String am(String str, String str2, String str3) {
        String format = this.AaJ.format(new Date());
        return String.format("%s​%s​[%d][%d][%s]: %s​​", new Object[]{str, str2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), format, str3});
    }
}
