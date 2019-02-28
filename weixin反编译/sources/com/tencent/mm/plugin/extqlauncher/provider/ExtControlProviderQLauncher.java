package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.extqlauncher.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class ExtControlProviderQLauncher extends ExtContentProviderBase {
    private static final UriMatcher mfY;
    private static final String[] mfw = new String[]{"retCode"};
    private static final String[] mhW = new String[]{SlookAirButtonFrequentContactAdapter.ID, "count"};
    private Context context;
    private String[] mfJ;
    private int mhX = -1;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mfY = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
        mfY.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
        mfY.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
    }

    public ExtControlProviderQLauncher(String[] strArr, int i, Context context) {
        this.mfJ = strArr;
        this.mhX = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.d("MicroMsg.ExtControlProviderQLauncher", "query()");
        a(uri, this.context, this.mhX, this.mfJ);
        if (uri == null) {
            pI(3);
            return null;
        } else if (bi.oN(this.mfS) || bi.oN(aGt())) {
            pI(3);
            return null;
        } else if (!arF()) {
            pI(1);
            return this.kAL;
        } else if (cA(this.context)) {
            Cursor matrixCursor;
            switch (this.mhX) {
                case 18:
                    x.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
                    if (this.context == null) {
                        pI(4);
                        return null;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                    matrixCursor = new MatrixCursor(mfw);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(1)});
                    pI(0);
                    return matrixCursor;
                case 19:
                    x.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
                    if (this.context == null) {
                        pI(4);
                        return null;
                    }
                    d.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", new Intent());
                    matrixCursor = new MatrixCursor(mfw);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(1)});
                    pI(0);
                    return matrixCursor;
                case 20:
                    return t(strArr2);
                default:
                    pI(3);
                    return null;
            }
        } else {
            x.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
            pI(2);
            return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor t(String[] strArr) {
        x.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
        if (this.context == null) {
            pI(4);
            return null;
        } else if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
            pI(3);
            return null;
        } else {
            MatrixCursor matrixCursor = new MatrixCursor(mhW);
            int i = 0;
            while (i < strArr.length && i < 10) {
                try {
                    if (!bi.oN(strArr[i])) {
                        if (strArr[i].equals("0")) {
                            Object[] objArr = new Object[2];
                            objArr[0] = strArr[i];
                            b.aGI();
                            objArr[1] = Integer.valueOf(b.aGJ());
                            matrixCursor.addRow(objArr);
                        } else {
                            String wj = com.tencent.mm.plugin.base.model.b.wj(strArr[i]);
                            if (bi.oN(wj)) {
                                continue;
                            } else {
                                as.Hm();
                                if (c.Fk().XF(wj) != null) {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(c.Fk().XF(wj).field_unReadCount)});
                                } else {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(0)});
                                }
                            }
                        }
                    }
                    i++;
                } catch (Exception e) {
                    x.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", e.getMessage());
                    pI(4);
                    matrixCursor.close();
                    return null;
                }
            }
            pI(0);
            return matrixCursor;
        }
    }
}
