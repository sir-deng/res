package com.tencent.mm.modelvoiceaction;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.DataUsageFeedback;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.mm.a.g;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class VoiceActionService extends SearchActionVerificationClientService {
    public final boolean a(Intent intent, boolean z) {
        if (z) {
            String stringExtra = intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_CHAT_ID");
            String stringExtra2 = intent.getStringExtra("android.intent.extra.TEXT");
            String username = af.OJ().kV(g.s(a.II(stringExtra).getBytes())).getUsername();
            f.aZN().C(username, stringExtra2, s.hs(username));
            try {
                String[] split = intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_URI").split("/");
                String str = (split == null || split.length <= 0) ? "" : split[split.length - 1];
                if (bi.oN(str)) {
                    x.e("MicroMsg.VoiceActionService", "extract contact Id error, %s %s", username, stringExtra);
                } else if (com.tencent.mm.pluginsdk.g.a.aZ(this, "android.permission.READ_CONTACTS")) {
                    Cursor query = getContentResolver().query(Data.CONTENT_URI, new String[]{"_id"}, "contact_id=? AND data1=? AND account_type=? AND mimetype=?", new String[]{str, stringExtra, "com.tencent.mm.account", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction"}, null);
                    if (query == null || query.getCount() <= 0) {
                        x.i("MicroMsg.VoiceActionService", "updateContactMarked: false");
                    } else {
                        query.moveToNext();
                        boolean z2 = getContentResolver().update(DataUsageFeedback.FEEDBACK_URI.buildUpon().appendPath(String.valueOf(query.getLong(0))).appendQueryParameter(Columns.TYPE, "short_text").build(), new ContentValues(), null, null) > 0;
                        x.i("MicroMsg.VoiceActionService", "updateContactMarked: %b", Boolean.valueOf(z2));
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    x.e("MicroMsg.VoiceActionService", "no contacts permission");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceActionService", e, "updateContactMarked error", new Object[0]);
            }
            return true;
        }
        x.i("MicroMsg.VoiceActionService", "Action is not verified");
        return false;
    }
}
