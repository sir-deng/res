package com.tencent.mm.lib.riskscanner;

import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.PrintWriter;
import java.io.StringWriter;

final class a {
    private static ThreadLocal<Long> gWa = new ThreadLocal();

    public static void Ev() {
        x.i("MicroMsg.RiskScannerReportService", "Report scan triggering.");
        d.pVE.a(590, 0, 1, true);
        gWa.set(Long.valueOf(bi.Wz()));
    }

    public static void c(Throwable th) {
        StringWriter stringWriter;
        Throwable th2;
        PrintWriter printWriter = null;
        x.i("MicroMsg.RiskScannerReportService", "Report an exception with message: %s", th.getMessage());
        gWa.remove();
        d.pVE.a(590, 4, 1, true);
        StringWriter stringWriter2;
        PrintWriter printWriter2;
        try {
            stringWriter2 = new StringWriter();
            try {
                printWriter2 = new PrintWriter(stringWriter2);
                try {
                    th.printStackTrace(printWriter2);
                    printWriter2.flush();
                    d.pVE.a(14177, "-1," + stringWriter2.toString().replace(",", "##"), false, true);
                    try {
                        stringWriter2.close();
                    } catch (Throwable th3) {
                    }
                    try {
                        printWriter2.close();
                    } catch (Throwable th4) {
                    }
                } catch (Throwable th5) {
                    printWriter = printWriter2;
                    th2 = th5;
                    if (stringWriter2 != null) {
                        try {
                            stringWriter2.close();
                        } catch (Throwable th6) {
                        }
                    }
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Throwable th7) {
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th8) {
                th2 = th8;
                if (stringWriter2 != null) {
                    stringWriter2.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th2;
            }
        } catch (Throwable th9) {
            th2 = th9;
            stringWriter2 = null;
            if (stringWriter2 != null) {
                stringWriter2.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
            throw th2;
        }
    }

    public static void gJ(int i) {
        x.i("MicroMsg.RiskScannerReportService", "Report scan result, %d", Integer.valueOf(i));
        switch (i) {
            case -10:
                d.pVE.a(590, 2, 1, true);
                return;
            case 0:
                Long l = (Long) gWa.get();
                if (l != null) {
                    x.i("MicroMsg.RiskScannerReportService", "Scan cost: %d ms", Long.valueOf(bi.Wz() - l.longValue()));
                    d.pVE.c(590, 5, 1, (int) r4, true);
                    return;
                }
                d.pVE.a(590, 1, 1, true);
                return;
            default:
                d.pVE.a(590, 3, 1, true);
                return;
        }
    }
}
