package com.tencent.tinker.loader;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;

public class TinkerUncaughtHandler implements UncaughtExceptionHandler {
    private final File AsV;
    private final Context context;
    private final UncaughtExceptionHandler xof = Thread.getDefaultUncaughtExceptionHandler();

    public TinkerUncaughtHandler(Context context) {
        this.context = context;
        this.AsV = SharePatchFileUtil.iC(context);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Throwable e;
        new StringBuilder("TinkerUncaughtHandler catch exception:").append(Log.getStackTraceString(th));
        this.xof.uncaughtException(thread, th);
        if (this.AsV != null && (Thread.getDefaultUncaughtExceptionHandler() instanceof TinkerUncaughtHandler)) {
            File parentFile = this.AsV.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                Object printWriter;
                try {
                    printWriter = new PrintWriter(new FileWriter(this.AsV, false));
                    try {
                        printWriter.println("process:" + ShareTinkerInternals.iK(this.context));
                        printWriter.println(ShareTinkerInternals.j(th));
                        SharePatchFileUtil.cA(printWriter);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            new StringBuilder("print crash file error:").append(Log.getStackTraceString(e));
                            SharePatchFileUtil.cA(printWriter);
                            Process.killProcess(Process.myPid());
                        } catch (Throwable th2) {
                            e = th2;
                            SharePatchFileUtil.cA(printWriter);
                            throw e;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    printWriter = null;
                    new StringBuilder("print crash file error:").append(Log.getStackTraceString(e));
                    SharePatchFileUtil.cA(printWriter);
                    Process.killProcess(Process.myPid());
                } catch (Throwable th3) {
                    e = th3;
                    printWriter = null;
                    SharePatchFileUtil.cA(printWriter);
                    throw e;
                }
                Process.killProcess(Process.myPid());
            }
        }
    }
}
