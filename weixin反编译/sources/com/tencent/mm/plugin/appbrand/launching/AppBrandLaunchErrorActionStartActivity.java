package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.mm.bl.d;
import com.tencent.wcdb.database.SQLiteDatabase;

final class AppBrandLaunchErrorActionStartActivity extends AppBrandLaunchErrorAction {
    final String jCe;
    final String jCf;
    final Intent jCg;

    AppBrandLaunchErrorActionStartActivity(String str, int i, String str2, String str3, Intent intent) {
        super(str, i);
        this.jCe = str2;
        this.jCf = str3;
        this.jCg = intent;
    }

    @Keep
    AppBrandLaunchErrorActionStartActivity(Parcel parcel) {
        super(parcel);
        this.jCe = parcel.readString();
        this.jCf = parcel.readString();
        this.jCg = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.jCe);
        parcel.writeString(this.jCf);
        parcel.writeParcelable(this.jCg, 0);
    }

    final void cb(Context context) {
        Intent intent = this.jCg;
        if (context instanceof Activity) {
            intent.setFlags(intent.getFlags() & -268435457);
        } else {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        d.b(context, this.jCe, this.jCf, intent);
    }
}
