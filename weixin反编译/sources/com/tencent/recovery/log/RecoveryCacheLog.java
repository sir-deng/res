package com.tencent.recovery.log;

import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import java.util.ArrayList;
import java.util.List;

public class RecoveryCacheLog implements RecoveryLogImpl {
    List<LogItem> AaD = new ArrayList(100);

    private class LogItem {
        String AaE;
        Object[] AaF;
        Throwable AaG;
        int level;
        String tag;

        private LogItem() {
        }

        /* synthetic */ LogItem(RecoveryCacheLog recoveryCacheLog, byte b) {
            this();
        }
    }

    public final void v(String str, String str2, Object... objArr) {
        if (this.AaD.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 1;
            logItem.tag = str;
            logItem.AaE = str2;
            logItem.AaF = objArr;
            this.AaD.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void d(String str, String str2, Object... objArr) {
        if (this.AaD.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 2;
            logItem.tag = str;
            logItem.AaE = str2;
            logItem.AaF = objArr;
            this.AaD.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void i(String str, String str2, Object... objArr) {
        if (this.AaD.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 3;
            logItem.tag = str;
            logItem.AaE = str2;
            logItem.AaF = objArr;
            this.AaD.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void w(String str, String str2, Object... objArr) {
        if (this.AaD.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 4;
            logItem.tag = str;
            logItem.AaE = str2;
            logItem.AaF = objArr;
            this.AaD.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void e(String str, String str2, Object... objArr) {
        if (this.AaD.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 5;
            logItem.tag = str;
            logItem.AaE = str2;
            logItem.AaF = objArr;
            this.AaD.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (this.AaD.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 5;
            logItem.tag = str;
            logItem.AaE = str2;
            logItem.AaF = objArr;
            logItem.AaG = th;
            this.AaD.add(logItem);
        }
        String.format(str2, objArr);
    }
}
