package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l {
    private static j hbL = new j();
    private static m hbM = new m();
    private static int hbN = -1;

    public abstract Bitmap a(String str, Options options, DecodeResultLogger decodeResultLogger);

    public abstract Bitmap a(String str, Rect rect, Options options, DecodeResultLogger decodeResultLogger);

    public abstract void h(Bitmap bitmap);

    public static l EH() {
        if (hbN == -1) {
            if (EI()) {
                hbN = 1;
            } else {
                hbN = 2;
            }
        }
        switch (hbN) {
            case 1:
                return hbL;
            case 2:
                return hbM;
            default:
                return hbM;
        }
    }

    public static boolean EI() {
        boolean fN = d.fN(19);
        boolean chn = bi.chn();
        x.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", Boolean.valueOf(fN), Boolean.valueOf(chn), Boolean.valueOf(fN));
        return fN;
    }

    protected static void e(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            if (inputStream instanceof FileInputStream) {
                inputStream = new j((FileInputStream) inputStream);
            } else {
                inputStream = new BufferedInputStream(inputStream, 65536);
            }
        }
        try {
            inputStream.reset();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PlatformBitmapFactory", e, "reset stream error: %s", e.getMessage());
        }
    }
}
