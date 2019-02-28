package com.tencent.mm.plugin.af;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

public final class a extends ContentObserver {
    private boolean hpb = false;
    private Context mContext;
    private ContentResolver qDZ;
    private boolean qEa = false;
    private boolean qEb = false;
    public a qEc;
    private long qEd = 0;
    public String[] qEe;

    public interface a {
        void sD(String str);
    }

    public a(Context context) {
        super(ag.fetchFreeHandler());
        this.mContext = context;
    }

    public final void start() {
        this.qEa = false;
        this.qEb = false;
        this.hpb = false;
        boolean a = com.tencent.mm.pluginsdk.g.a.a((Activity) this.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "");
        x.i("MicroMsg.SmsVerifyObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", Boolean.valueOf(a), bi.chl(), this.mContext);
        try {
            long j;
            Uri parse = Uri.parse("content://sms/inbox");
            this.qDZ = this.mContext.getContentResolver();
            String str = "( ";
            if (this.qEe != null) {
                int i = 0;
                while (i < this.qEe.length) {
                    String str2 = i == this.qEe.length + -1 ? str + " body like \"%" + this.qEe[i] + "%\" ) " : str + "body like \"%" + this.qEe[i] + "%\" or ";
                    i++;
                    str = str2;
                }
                x.v("MicroMsg.SmsVerifyObserver", "sql where:" + str);
            } else {
                str = "";
            }
            Cursor query = this.qDZ.query(parse, new String[]{FFmpegMetadataRetriever.METADATA_KEY_DATE}, str, null, "date desc limit 1");
            if (query == null || query.getCount() <= 0) {
                j = 0;
            } else {
                query.moveToFirst();
                j = query.getLong(0);
            }
            if (query != null) {
                query.close();
            }
            this.qEd = j;
            this.mContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
        }
    }

    public final void stop() {
        if (this.mContext != null) {
            try {
                this.mContext.getContentResolver().unregisterContentObserver(this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
            }
        }
        this.hpb = true;
    }

    public final void onChange(boolean z) {
        String str = null;
        super.onChange(z);
        try {
            if (!this.qEa && !this.hpb && !this.qEb) {
                Uri parse = Uri.parse("content://sms/inbox");
                this.qDZ = this.mContext.getContentResolver();
                String[] strArr = new String[]{"body", "_id", FFmpegMetadataRetriever.METADATA_KEY_DATE};
                String str2 = "( ";
                if (this.qEe != null) {
                    int i = 0;
                    while (i < this.qEe.length) {
                        str2 = i == this.qEe.length + -1 ? str2 + " body like \"%" + this.qEe[i] + "%\" ) " : str2 + "body like \"%" + this.qEe[i] + "%\" or ";
                        i++;
                    }
                    str = str2 + " and date > " + this.qEd + " ";
                    x.v("MicroMsg.SmsVerifyObserver", "sql where:" + str);
                }
                if (str != null && !str.equals("")) {
                    Cursor query = this.qDZ.query(parse, strArr, str, null, "date desc");
                    if (query != null) {
                        int i2 = -1;
                        long j = 0;
                        while (query.moveToNext()) {
                            int position;
                            long j2 = query.getLong(2);
                            if (j2 > j) {
                                position = query.getPosition();
                            } else {
                                j2 = j;
                                position = i2;
                            }
                            i2 = position;
                            j = j2;
                        }
                        if (i2 >= 0) {
                            query.moveToPosition(i2);
                            str2 = aI(0, query.getString(query.getColumnIndex("body")));
                            if (!bi.oN(str2) && str2.length() == 6) {
                                if (this.qEc != null) {
                                    this.qEc.sD(str2);
                                }
                                this.qEb = true;
                            }
                        }
                        query.close();
                    }
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
        }
    }

    private String aI(int i, String str) {
        while (i < str.length()) {
            while (i < str.length() && !Character.isDigit(str.charAt(i))) {
                i++;
            }
            int i2 = i + 1;
            while (i2 < str.length() && Character.isDigit(str.charAt(i2))) {
                i2++;
            }
            String substring = str.substring(i, i2);
            x.v("MicroMsg.SmsVerifyObserver", "verify number from sms:" + substring);
            if (substring.length() == 6) {
                return substring;
            }
            i = i2 + 1;
        }
        return null;
    }
}
