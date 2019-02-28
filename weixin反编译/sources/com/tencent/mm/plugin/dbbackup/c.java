package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bs;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDebug.IOTraceStats;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class c implements a {
    private d luT;

    c(d dVar) {
        this.luT = dVar;
    }

    private boolean cs(final Context context) {
        if (g.Dq().CX() == null) {
            h.h(context, R.l.eDa, R.l.dGZ);
        } else {
            context.getString(R.l.dGZ);
            final ProgressDialog a = h.a(context, context.getString(R.l.eCZ), false, null);
            final bs bYG = ((b) g.h(b.class)).bYG();
            bYG.Id();
            d dVar = this.luT;
            b anonymousClass1 = new b() {
                public final void oM(final int i) {
                    bYG.Ie();
                    ah.y(new Runnable() {
                        public final void run() {
                            int i;
                            if (a != null) {
                                a.dismiss();
                            }
                            switch (i) {
                                case -3:
                                    i = R.l.eDa;
                                    break;
                                case -2:
                                    i = R.l.eDb;
                                    break;
                                case 0:
                                    i = R.l.eDc;
                                    break;
                                default:
                                    i = R.l.eCY;
                                    break;
                            }
                            h.h(context, i, R.l.dGZ);
                        }
                    });
                }
            };
            File file = new File(ad.getContext().getFilesDir(), "DBRecoverStarted");
            WakerLock wakerLock = new WakerLock(ad.getContext());
            b anonymousClass5 = new com.tencent.mm.plugin.dbbackup.d.AnonymousClass5(file, anonymousClass1, wakerLock);
            x.i("MicroMsg.SubCoreDBBackup", "Database recover started.");
            wakerLock.lock();
            com.tencent.mm.plugin.report.service.g.pWK.a(181, 28, 1, true);
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
            anonymousClass5.oM(-1);
        }
        return true;
    }

    private boolean b(final Context context, String[] strArr) {
        int i = -1;
        int i2 = 0;
        String str = g.Dq().cachePath;
        final String str2 = str + "ctest/";
        final String str3 = str + "EnMicroMsg.db";
        final String str4 = str2 + "EnMicroMsg.db";
        final String[] strArr2 = new String[]{"", "-journal", "-wal", ".sm", ".bak"};
        if (strArr.length > 1) {
            String str5 = strArr[1];
            switch (str5.hashCode()) {
                case -778987502:
                    if (str5.equals("clear-test")) {
                        i = 2;
                        break;
                    }
                    break;
                case 1220142353:
                    if (str5.equals("make-test")) {
                        i = 0;
                        break;
                    }
                    break;
                case 1933703003:
                    if (str5.equals("recover-test")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    if (FileOp.bO(str2)) {
                        Toast.makeText(context, "Corruption test database exists.\nClear or recover before creating a new one.", 1).show();
                        return true;
                    }
                    as.Hm();
                    com.tencent.mm.y.c.Fc().clK().close();
                    FileOp.ml(str2);
                    while (i2 < 5) {
                        String str6 = strArr2[i2];
                        FileOp.at(str3 + str6, str4 + str6);
                        i2++;
                    }
                    d.cu(context);
                    return true;
                case 1:
                    if (FileOp.bO(str2)) {
                        final Context context2 = context;
                        h.a(context, "Do you really want to recover test database?\nYour current database WILL BE LOST.", null, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                as.Hm();
                                com.tencent.mm.y.c.Fc().clK().close();
                                for (String str : strArr2) {
                                    FileOp.deleteFile(str3 + str);
                                    FileOp.at(str4 + str, str3 + str);
                                }
                                FileOp.G(str2, false);
                                d.cu(context2);
                            }
                        }, null);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    return true;
                case 2:
                    if (FileOp.bO(str2)) {
                        h.a(context, "Do you really want to clear test database?\nIt can't be recovered anymore.", null, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                FileOp.G(str2, false);
                                Toast.makeText(context, "Corruption test database cleared.", 0).show();
                            }
                        }, null);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    return true;
                default:
                    return false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.TITLE_LENGTH_LIMIT);
        str3 = g.Dq().CX();
        stringBuilder.append("Corrupted DB: ");
        if (str3 == null) {
            stringBuilder.append("not exist");
        } else {
            stringBuilder.append(str3.contains("/ctest/") ? "test" : "exists");
            stringBuilder.append("\nCorrupted DB size: ").append(FileOp.mi(str3));
            stringBuilder.append("\nSaved master exists: ").append(FileOp.bO(str3 + ".sm"));
            stringBuilder.append("\nContent backup exists: ").append(FileOp.bO(str3 + ".bak"));
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(8388627);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16744704);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setMovementMethod(new ScrollingMovementMethod());
        i = context.getResources().getDimensionPixelSize(R.f.bvw);
        textView.setPadding(i, i, i, i);
        h.a(context, null, textView, null);
        return true;
    }

    private static boolean ct(Context context) {
        int lastErrorLine = SQLiteDebug.getLastErrorLine();
        ArrayList lastIOTraceStats = SQLiteDebug.getLastIOTraceStats();
        if (!(lastIOTraceStats == null || lastIOTraceStats.isEmpty())) {
            Object encodeToString;
            IOTraceStats iOTraceStats = (IOTraceStats) lastIOTraceStats.get(0);
            String str = "";
            try {
                as.Hm();
                str = com.tencent.mm.a.g.s((q.yL() + com.tencent.mm.y.c.Cn()).getBytes()).substring(0, 7);
            } catch (Exception e) {
            }
            CharSequence format = String.format("DB corrupted (line: %d, hash: %s) => %s", new Object[]{Integer.valueOf(lastErrorLine), str, iOTraceStats.toString()});
            Object obj = "";
            if (iOTraceStats.lastReadPage != null) {
                obj = Base64.encodeToString(iOTraceStats.lastReadPage, 0);
            }
            String str2 = "";
            if (iOTraceStats.lastJournalReadPage != null) {
                encodeToString = Base64.encodeToString(iOTraceStats.lastJournalReadPage, 0);
            } else {
                String encodeToString2 = str2;
            }
            Map hashMap = new HashMap();
            hashMap.put("lastReadPage", obj);
            hashMap.put("lastJournalReadPage", encodeToString2);
            com.tencent.mm.plugin.report.service.g.pWK.c("DBCorrupt", format, hashMap);
            View textView = new TextView(context);
            textView.setText(format);
            textView.setGravity(8388627);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16744704);
            textView.setTypeface(Typeface.MONOSPACE);
            textView.setMovementMethod(new ScrollingMovementMethod());
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvw);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            h.a(context, null, textView, null);
        }
        return true;
    }

    private static boolean c(Context context, String[] strArr) {
        CharSequence charSequence;
        t Db = g.Dq().Db();
        if (strArr.length > 1) {
            try {
                int intValue = Integer.decode(strArr[1]).intValue();
                if (intValue > 2 || intValue < 0) {
                    throw new NumberFormatException();
                }
                Db.set(89, Integer.valueOf(intValue));
                Db.lO(true);
                charSequence = "Recovery status set to " + intValue;
            } catch (NumberFormatException e) {
                charSequence = "Recovery status must be 0, 1 or 2";
            }
        } else {
            charSequence = "Recovery status is " + Db.getInt(89, 0);
        }
        Toast.makeText(context, charSequence, 0).show();
        return true;
    }

    public final boolean a(Context context, String[] strArr) {
        String str = strArr[0];
        boolean z = true;
        switch (str.hashCode()) {
            case -1955673212:
                if (str.equals("//recover")) {
                    z = true;
                    break;
                }
                break;
            case -1870250080:
                if (str.equals("//backupdb")) {
                    z = true;
                    break;
                }
                break;
            case -1832373669:
                if (str.equals("//recover-status")) {
                    z = true;
                    break;
                }
                break;
            case -1648083177:
                if (str.equals("//post-recover")) {
                    z = true;
                    break;
                }
                break;
            case -896707907:
                if (str.equals("//iotracedb")) {
                    z = true;
                    break;
                }
                break;
            case -398050965:
                if (str.equals("//corruptdb")) {
                    z = true;
                    break;
                }
                break;
            case -137452885:
                if (str.equals("//repairdb")) {
                    z = true;
                    break;
                }
                break;
            case 1483443294:
                if (str.equals("//recover-old")) {
                    z = false;
                    break;
                }
                break;
            case 1793722114:
                if (str.equals("//recoverdb")) {
                    z = true;
                    break;
                }
                break;
        }
        final long nanoTime;
        final Context context2;
        String str2;
        final ProgressDialog a;
        switch (z) {
            case false:
                return cs(context);
            case true:
                Intent intent = new Intent(context, DBRecoveryUI.class);
                intent.putExtra("scene", 2);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
                return true;
            case true:
                as.Hm();
                d.aAm();
                Toast.makeText(context, "Post recovery cleanup done.", 0).show();
                return true;
            case true:
                if (strArr.length <= 1 || !strArr[1].equals("cipher")) {
                    final boolean z2 = strArr.length > 1 && strArr[1].equals("incremental");
                    nanoTime = System.nanoTime();
                    final ProgressDialog a2 = h.a(context, "Backing database up. Please wait...", false, null);
                    context2 = context;
                    if (this.luT.a(z2, new b() {
                        public final void oM(final int i) {
                            ah.y(new Runnable() {
                                public final void run() {
                                    CharSequence format;
                                    if (a2 != null) {
                                        a2.dismiss();
                                    }
                                    if (i == 0) {
                                        String str = "Database (%s) backup succeeded, elapsed %.2f seconds.";
                                        Object[] objArr = new Object[2];
                                        objArr[0] = z2 ? "incremental" : "new";
                                        objArr[1] = Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f);
                                        format = String.format(str, objArr);
                                    } else if (i == 1) {
                                        format = "Database backup canceled.";
                                    } else {
                                        format = "Database backup failed.";
                                    }
                                    Toast.makeText(context2, format, 0).show();
                                }
                            });
                        }
                    })) {
                        return true;
                    }
                    if (a2 != null) {
                        a2.dismiss();
                    }
                    Toast.makeText(context, "Database is busy.", 0).show();
                    return true;
                }
                as.Hm();
                t Db = com.tencent.mm.y.c.Db();
                if (strArr.length > 2) {
                    str = strArr[2];
                    z = true;
                    switch (str.hashCode()) {
                        case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                            if (str.equals("0")) {
                                z = true;
                                break;
                            }
                            break;
                        case org.xwalk.core.R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                            if (str.equals("1")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3521:
                            if (str.equals("no")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3551:
                            if (str.equals("on")) {
                                z = true;
                                break;
                            }
                            break;
                        case 109935:
                            if (str.equals("off")) {
                                z = true;
                                break;
                            }
                            break;
                        case 119527:
                            if (str.equals("yes")) {
                                z = false;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                        case true:
                        case true:
                            Db.setInt(237571, 0);
                            Db.lO(true);
                            break;
                        case true:
                        case true:
                        case true:
                            Db.setInt(237571, 1);
                            Db.lO(true);
                            break;
                    }
                }
                Toast.makeText(context, "Database backup with cipher: " + (Db.getInt(237571, 0) == 0), 0).show();
                return true;
            case true:
                str2 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(R.l.dGZ);
                a = h.a(context, context.getString(R.l.eCZ), false, null);
                context2 = context;
                this.luT.a(str2, new b() {
                    public final void oM(final int i) {
                        ah.y(new Runnable() {
                            public final void run() {
                                CharSequence format;
                                if (a != null) {
                                    a.dismiss();
                                }
                                if (i == 0) {
                                    format = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[]{Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f)});
                                } else if (i == 1) {
                                    format = "Database recovery canceled.";
                                } else {
                                    format = "Database recovery failed.";
                                }
                                Toast.makeText(context2, format, 0).show();
                            }
                        });
                    }
                });
                return true;
            case true:
                str2 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(R.l.dGZ);
                a = h.a(context, context.getString(R.l.eCZ), false, null);
                context2 = context;
                int b = this.luT.b(str2, new b() {
                    public final void oM(final int i) {
                        ah.y(new Runnable() {
                            public final void run() {
                                CharSequence format;
                                if (a != null) {
                                    a.dismiss();
                                }
                                if (i == 0) {
                                    format = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[]{Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f)});
                                } else if (i == 1) {
                                    format = "Database recovery canceled.";
                                } else {
                                    format = "Database recovery failed.";
                                }
                                Toast.makeText(context2, format, 0).show();
                            }
                        });
                    }
                });
                if (b == 0) {
                    return true;
                }
                if (a != null) {
                    a.dismiss();
                }
                switch (b) {
                    case -3:
                        b = R.l.eDa;
                        break;
                    case -2:
                        b = R.l.eDb;
                        break;
                    default:
                        b = R.l.eCY;
                        break;
                }
                Toast.makeText(context, b, 1).show();
                return true;
            case true:
                return b(context, strArr);
            case true:
                return ct(context);
            case true:
                return c(context, strArr);
            default:
                return false;
        }
    }
}
