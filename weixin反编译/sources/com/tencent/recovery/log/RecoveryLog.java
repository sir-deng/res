package com.tencent.recovery.log;

import java.util.ArrayList;

public class RecoveryLog {
    private static RecoveryLogImpl hLM = new RecoveryCacheLog();

    public interface RecoveryLogImpl {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (hLM != null) {
            hLM.i(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (hLM != null) {
            hLM.e(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (hLM != null) {
            hLM.printErrStackTrace(str, th, str2, objArr);
        }
    }

    public static void a(RecoveryLogImpl recoveryLogImpl) {
        if (hLM instanceof RecoveryCacheLog) {
            RecoveryCacheLog recoveryCacheLog = (RecoveryCacheLog) hLM;
            int size = recoveryCacheLog.AaD.size();
            for (int i = 0; i < size; i++) {
                LogItem logItem = (LogItem) recoveryCacheLog.AaD.get(i);
                switch (logItem.level) {
                    case 1:
                        recoveryLogImpl.v(logItem.tag, logItem.AaE, logItem.AaF);
                        break;
                    case 2:
                        recoveryLogImpl.d(logItem.tag, logItem.AaE, logItem.AaF);
                        break;
                    case 3:
                        recoveryLogImpl.i(logItem.tag, logItem.AaE, logItem.AaF);
                        break;
                    case 4:
                        recoveryLogImpl.w(logItem.tag, logItem.AaE, logItem.AaF);
                        break;
                    case 5:
                        if (logItem.AaG == null) {
                            recoveryLogImpl.e(logItem.tag, logItem.AaE, logItem.AaF);
                            break;
                        } else {
                            recoveryLogImpl.printErrStackTrace(logItem.tag, logItem.AaG, logItem.AaE, logItem.AaF);
                            break;
                        }
                    default:
                        break;
                }
            }
            recoveryCacheLog.AaD = new ArrayList();
        }
        hLM = recoveryLogImpl;
    }

    public static void cEc() {
        if (hLM instanceof RecoveryFileLog) {
            ((RecoveryFileLog) hLM).bs("", true);
        }
    }

    public static RecoveryLogImpl cEd() {
        return hLM;
    }
}
