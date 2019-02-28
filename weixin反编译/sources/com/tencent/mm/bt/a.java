package com.tencent.mm.bt;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.protocal.c.bkc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;

public final class a implements e {
    public static a xjG = new a();
    public static b xjH = new b();
    public static c xjI = new c();
    private com.tencent.mm.ap.a.a lTD;
    private String xjC;
    private ArrayList<EmojiInfo> xjD = new ArrayList();
    private HashMap<String, ArrayList<EmojiInfo>> xjE = new HashMap();
    private ArrayList<EmojiGroupInfo> xjF = new ArrayList();

    public static class b {
        public static boolean Dq(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("key", i);
            return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getBoolean", null, bundle).getBoolean("key", false);
        }

        public static String aW(int i, String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("key", i);
            return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getString", null, bundle).getString("key", str);
        }

        public static void Vg(String str) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.TYPE, Integer.valueOf(-29414086));
            contentValues.put(Columns.VALUE, str);
            ad.getContext().getContentResolver().update(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), contentValues, null, null);
        }
    }

    public static class a {
    }

    public static class c extends com.tencent.mm.j.e {
        public final synchronized void kt() {
            this.gJU = true;
            a.ceF();
            b bVar = a.xjH;
            l(b.aW(278529, null), false);
            a.ceF();
            bVar = a.xjH;
            l(b.aW(278530, null), false);
        }
    }

    public final String yF(String str) {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yF(str);
        }
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getCurLangDesc", str, null).getString(SlookAirButtonFrequentContactAdapter.DATA, "");
    }

    public final bkc aBG() {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aBG();
        }
        return null;
    }

    public final void a(bkc bkc) {
        if (((h) g.Dn().CU()).DZ()) {
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(bkc);
        }
    }

    public final int aBH() {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aBH();
        }
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countCustomEmoji", null, null).getInt(SlookAirButtonFrequentContactAdapter.DATA, 0);
    }

    public final int yS(String str) {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yS(str);
        }
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countProductId", str, null).getInt(SlookAirButtonFrequentContactAdapter.DATA, 0);
    }

    public final int aBJ() {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aBJ();
        }
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getDownloadedCount", null, null).getInt(SlookAirButtonFrequentContactAdapter.DATA, 0);
    }

    public final boolean a(EmojiGroupInfo emojiGroupInfo) {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(emojiGroupInfo);
        }
        return false;
    }

    public final ArrayList<EmojiGroupInfo> aBI() {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aBI();
        }
        if (this.xjF.size() == 0) {
            Bundle call = ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiGroupInfoList", null, null);
            if (call != null) {
                call.setClassLoader(EmojiGroupInfo.class.getClassLoader());
                if (call.containsKey(SlookAirButtonFrequentContactAdapter.DATA)) {
                    this.xjF.addAll(call.getParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA));
                    x.i("MicroMsg.EmotionStorageResolver", "[getEmojiGroupInfoListExport] size%s", Integer.valueOf(r0.size()));
                }
            }
        }
        return this.xjF;
    }

    public final ArrayList<EmojiInfo> aBK() {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aBK();
        }
        if (this.xjD.size() == 0) {
            Bundle call = ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAllCustomEmoji", "false", null);
            if (call != null) {
                call.setClassLoader(EmojiInfo.class.getClassLoader());
                if (call.containsKey(SlookAirButtonFrequentContactAdapter.DATA)) {
                    this.xjD.addAll(call.getParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA));
                    x.i("MicroMsg.EmotionStorageResolver", "[getAllCustomEmojiExport] size:%s", Integer.valueOf(r0.size()));
                }
            }
        }
        return this.xjD;
    }

    public final ArrayList<EmojiInfo> yT(String str) {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yT(str);
        }
        ArrayList<EmojiInfo> arrayList = (ArrayList) this.xjE.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.xjE.put(str, arrayList);
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        Bundle call = ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiListByGroupId", str, null);
        if (call == null) {
            return arrayList;
        }
        call.setClassLoader(EmojiInfo.class.getClassLoader());
        if (!call.containsKey(SlookAirButtonFrequentContactAdapter.DATA)) {
            return arrayList;
        }
        arrayList.addAll(call.getParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA));
        x.i("MicroMsg.EmotionStorageResolver", "[getEmojiListByGroupIdExport] size%s", Integer.valueOf(r1.size()));
        return arrayList;
    }

    public final com.tencent.mm.ap.a.a aBL() {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aBL();
        }
        if (this.lTD == null) {
            com.tencent.mm.ap.a.a.b.a aVar = new com.tencent.mm.ap.a.a.b.a(ad.getContext());
            aVar.hEZ = new com.tencent.mm.view.d.a();
            this.lTD = new com.tencent.mm.ap.a.a(aVar.PP());
        }
        return this.lTD;
    }

    public final void f(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Dn().CU()).DZ()) {
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().f(aVar);
        }
    }

    public final byte[] a(EmojiInfo emojiInfo) {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(emojiInfo);
        }
        if (emojiInfo == null) {
            x.w("MicroMsg.EmotionStorageResolver", "[decodeEmojiDataExport] failed. emoji is null.");
            return null;
        }
        String clq = emojiInfo.clq();
        byte[] d = com.tencent.mm.a.e.d(clq, 0, com.tencent.mm.a.e.bN(clq));
        if (com.tencent.mm.a.e.bN(clq) <= 0 || d == null || d.length < 10) {
            x.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path is no exist :%s ", clq);
            return null;
        }
        Object obj = new byte[10];
        System.arraycopy(d, 0, obj, 0, 10);
        if ((emojiInfo.field_reserved4 & EmojiInfo.xJc) != EmojiInfo.xJc || p.br(obj)) {
            return d;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int bN = com.tencent.mm.a.e.bN(clq);
        if (bN > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            bN = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        byte[] d2 = com.tencent.mm.a.e.d(clq, 0, bN);
        if (bi.oN(aBz())) {
            Object obj2 = null;
        } else {
            d2 = AesEcb.aesCryptEcb(d2, aBz().getBytes(), false, false);
        }
        if (bi.by(d2) || bi.by(d)) {
            x.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path:%s return original ", clq);
            return d;
        }
        System.arraycopy(d2, 0, d, 0, bN);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        x.d("MicroMsg.EmotionStorageResolver", "decode emoji file length:%d use time:%d", Integer.valueOf(d.length), Long.valueOf(currentTimeMillis2));
        return d;
    }

    public final void g(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Dn().CU()).DZ()) {
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(aVar);
        }
    }

    public final void h(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Dn().CU()).DZ()) {
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().h(aVar);
        }
    }

    public final void i(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Dn().CU()).DZ()) {
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().i(aVar);
        }
    }

    public final EmojiInfo c(EmojiInfo emojiInfo) {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().c(emojiInfo);
        }
        Bundle bundle = new Bundle(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        bundle = ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getRamdomEmoji", null, bundle);
        if (bundle == null) {
            x.e("MicroMsg.EmotionStorageResolver", "[getRamdomEmoji] bunndle is null! ");
            return null;
        }
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        if (bundle.containsKey(SlookAirButtonFrequentContactAdapter.DATA)) {
            return (EmojiInfo) bundle.getParcelable(SlookAirButtonFrequentContactAdapter.DATA);
        }
        boolean z;
        String str = "MicroMsg.EmotionStorageResolver";
        String str2 = "[getRamdomEmoji] bundle is null?";
        Object[] objArr = new Object[1];
        if (bundle == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.e(str, str2, objArr);
        return null;
    }

    private static String aBz() {
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiKey", null, null).getString("key", "");
    }

    public final String FJ() {
        if (((h) g.Dn().CU()).DZ()) {
            this.xjC = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().FJ();
        } else if (bi.oN(this.xjC)) {
            this.xjC = ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAccPath", null, null).getString("path");
        }
        return this.xjC;
    }

    public static a ceF() {
        return xjG;
    }

    public final void onDestroy() {
        this.xjF.clear();
    }

    public final boolean aBM() {
        if (((h) g.Dn().CU()).DZ()) {
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aBM();
        }
        return true;
    }
}
