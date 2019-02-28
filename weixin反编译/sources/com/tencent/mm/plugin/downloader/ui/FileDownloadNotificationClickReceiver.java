package com.tencent.mm.plugin.downloader.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.f.a.qt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public class FileDownloadNotificationClickReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.FileDownloadNotificationClickReceiver", "onReceive");
        String by = bi.by(context);
        x.i("MicroMsg.FileDownloadNotificationClickReceiver", "topActivityName = " + by);
        Bundle extras = intent.getExtras();
        if (bi.oM(by).equals("com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI")) {
            b qtVar = new qt();
            qtVar.fJr.bundle = extras;
            a.xmy.m(qtVar);
            return;
        }
        Intent intent2 = new Intent(context, FileDownloadConfirmUI.class);
        intent2.putExtras(extras);
        intent2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent2);
    }
}
