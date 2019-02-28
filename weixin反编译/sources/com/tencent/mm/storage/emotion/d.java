package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.bx.h;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class d extends i<EmojiInfo> implements a {
    public static final String[] gLy = new String[]{i.a(EmojiInfo.gKN, "EmojiInfo"), "CREATE INDEX IF NOT EXISTS emojiinfogrouptempindex  on EmojiInfo  (  groupId,temp )"};
    private static int[] xJe = new int[]{2, 4, 8};
    public e gLA;

    public final /* synthetic */ boolean b(c cVar) {
        return o((EmojiInfo) cVar);
    }

    public d(e eVar) {
        super(eVar, EmojiInfo.gKN, "EmojiInfo", null);
        this.gLA = eVar;
    }

    public final String getTableName() {
        return "EmojiInfo";
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final boolean fm(Context context) {
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init");
        EmojiInfo YB = YB("86cb157e9c44b2c9934e4e430790776d");
        EmojiInfo YB2 = YB("68f9864ca5c0a5d823ed7184e113a4aa");
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,group art custom catalog count:%d", Integer.valueOf(DQ(EmojiInfo.xIK)));
        if (YB != null || ((YB2 != null && YB2.wl().length() == 0) || r2 <= 2)) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for very old version");
            DS(EmojiInfo.xIJ);
            DS(EmojiInfo.xIM);
            DS(EmojiInfo.xIL);
        }
        YB = YB("9bd1281af3a31710a45b84d736363691");
        if (YB != null && YB.field_catalog == EmojiInfo.xIJ) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.0");
            DS(EmojiInfo.xIJ);
            DS(EmojiInfo.xIM);
            DS(EmojiInfo.xIL);
        }
        InputStream bk = EmojiInfo.bk(context, "icon_002_cover.png");
        if (bk != null) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.1,update emoji tuzi  for 4.4");
            DS(EmojiInfo.xIJ);
            DS(EmojiInfo.xIM);
            DS(EmojiInfo.xIL);
        }
        if (bk != null) {
            try {
                bk.close();
            } catch (Exception e) {
            }
        }
        if (DQ(EmojiInfo.xIJ) != 0) {
            return true;
        }
        InputStream inputStream = null;
        try {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml start.");
            long currentTimeMillis = System.currentTimeMillis();
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            List<EmojiInfo> a = a(new InputStream[]{inputStream});
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]parse xml time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a.size() > 0 && a.size() > 0) {
                h hVar;
                currentTimeMillis = -1;
                if (this.gLA instanceof h) {
                    h hVar2 = (h) this.gLA;
                    currentTimeMillis = hVar2.dA(Thread.currentThread().getId());
                    hVar = hVar2;
                } else {
                    hVar = null;
                }
                for (EmojiInfo YB3 : a) {
                    if (this.gLA.replace("EmojiInfo", "md5", YB3.vP()) < 0) {
                        if (hVar != null) {
                            hVar.fT(currentTimeMillis);
                        }
                    }
                }
                if (hVar != null) {
                    hVar.fT(currentTimeMillis);
                }
            }
            x.i("MicroMsg.emoji.EmojiInfoStorage", "insert time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            x.d("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e2) {
                    x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bi.i(e2));
                }
            }
        } catch (IOException e3) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init, db error. " + e3.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bi.i(e22));
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e4) {
                    x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bi.i(e4));
                }
            }
        }
        return true;
    }

    public final EmojiInfo n(EmojiInfo emojiInfo) {
        if (bi.oN(emojiInfo.Nx()) || emojiInfo.Nx().length() <= 0) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            return null;
        } else if (!o(emojiInfo)) {
            return null;
        } else {
            WI("create_emoji_info_notify");
            return emojiInfo;
        }
    }

    public final EmojiInfo b(String str, String str2, int i, int i2, int i3, String str3) {
        return a(str, str2, i, i2, i3, null, null, str3, 1);
    }

    public final EmojiInfo c(String str, String str2, int i, int i2, int i3, String str3) {
        return a(str, str2, i, i2, i3, null, null, str3, 1);
    }

    public final EmojiInfo a(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        return a(str, str2, i, i2, i3, null, str3, str4, 1);
    }

    private EmojiInfo a(String str, String str2, int i, int i2, int i3, String str3, String str4, String str5, int i4) {
        if (str == null || str.length() <= 0) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            return null;
        }
        EmojiInfo emojiInfo;
        if (str == null || str.length() <= 0) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            emojiInfo = null;
        } else {
            emojiInfo = YB(str);
            if (emojiInfo == null) {
                com.tencent.mm.plugin.emoji.d.aAS();
                emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aAT());
                emojiInfo.field_catalog = i;
            }
            emojiInfo.field_md5 = str;
            emojiInfo.field_svrid = str2;
            emojiInfo.field_type = i2;
            emojiInfo.field_size = i3;
            emojiInfo.field_state = EmojiInfo.xIT;
            emojiInfo.field_reserved1 = null;
            emojiInfo.field_reserved2 = null;
            emojiInfo.field_app_id = str4;
            emojiInfo.field_temp = 1;
            emojiInfo.field_reserved4 = 0;
            if (!TextUtils.isEmpty(str5)) {
                emojiInfo.field_groupId = str5;
            }
        }
        emojiInfo.field_state = EmojiInfo.xIV;
        if (!o(emojiInfo)) {
            return null;
        }
        WI("create_emoji_info_notify");
        return emojiInfo;
    }

    public final boolean o(EmojiInfo emojiInfo) {
        if (emojiInfo == null || !emojiInfo.cln()) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        long replace = this.gLA.replace("EmojiInfo", "md5", emojiInfo.vP());
        if (replace != -1) {
            WI(emojiInfo.Nx());
        }
        if (replace >= 0) {
            return true;
        }
        return false;
    }

    public final boolean p(EmojiInfo emojiInfo) {
        if (emojiInfo == null || !emojiInfo.cln()) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        int update = this.gLA.update("EmojiInfo", emojiInfo.vP(), "md5=?", new String[]{emojiInfo.Nx()});
        if (update > 0) {
            WI(emojiInfo.Nx());
            WI("event_update_emoji");
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean q(EmojiInfo emojiInfo) {
        if (emojiInfo == null || !emojiInfo.cln()) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        if (this.gLA.update("EmojiInfo", emojiInfo.vP(), "md5=?", new String[]{emojiInfo.Nx()}) <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.emotion.EmojiInfo YB(java.lang.String r12) {
        /*
        r11 = this;
        r2 = 1;
        r3 = 0;
        r9 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r12);
        if (r0 != 0) goto L_0x0011;
    L_0x0009:
        r0 = r12.length();
        r1 = 32;
        if (r0 == r1) goto L_0x0020;
    L_0x0011:
        r0 = "MicroMsg.emoji.EmojiInfoStorage";
        r1 = "md5 is null or invalue. md5:%s";
        r2 = new java.lang.Object[r2];
        r2[r3] = r12;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r9;
    L_0x001f:
        return r0;
    L_0x0020:
        r0 = r11.gLA;	 Catch:{ Exception -> 0x0055 }
        r1 = "EmojiInfo";
        r2 = 0;
        r3 = "md5=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0055 }
        r5 = 0;
        r4[r5] = r12;	 Catch:{ Exception -> 0x0055 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 2;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0055 }
        if (r1 == 0) goto L_0x0086;
    L_0x0039:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x007b, all -> 0x0078 }
        if (r0 == 0) goto L_0x0086;
    L_0x003f:
        r2 = new com.tencent.mm.storage.emotion.EmojiInfo;	 Catch:{ Exception -> 0x007b, all -> 0x0078 }
        com.tencent.mm.plugin.emoji.d.aAS();	 Catch:{ Exception -> 0x007b, all -> 0x0078 }
        r0 = com.tencent.mm.plugin.emoji.d.aAT();	 Catch:{ Exception -> 0x007b, all -> 0x0078 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x007b, all -> 0x0078 }
        r2.b(r1);	 Catch:{ Exception -> 0x0081, all -> 0x0078 }
        r0 = r2;
    L_0x004f:
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1.close();
        goto L_0x001f;
    L_0x0055:
        r0 = move-exception;
        r1 = r0;
        r0 = r9;
    L_0x0058:
        r2 = "MicroMsg.emoji.EmojiInfoStorage";
        r3 = "[getByMd5]Exception:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0071 }
        r5 = 0;
        r1 = r1.toString();	 Catch:{ all -> 0x0071 }
        r4[r5] = r1;	 Catch:{ all -> 0x0071 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0071 }
        if (r9 == 0) goto L_0x001f;
    L_0x006d:
        r9.close();
        goto L_0x001f;
    L_0x0071:
        r0 = move-exception;
    L_0x0072:
        if (r9 == 0) goto L_0x0077;
    L_0x0074:
        r9.close();
    L_0x0077:
        throw r0;
    L_0x0078:
        r0 = move-exception;
        r9 = r1;
        goto L_0x0072;
    L_0x007b:
        r0 = move-exception;
        r10 = r0;
        r0 = r9;
        r9 = r1;
        r1 = r10;
        goto L_0x0058;
    L_0x0081:
        r0 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r2;
        goto L_0x0058;
    L_0x0086:
        r0 = r9;
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.d.YB(java.lang.String):com.tencent.mm.storage.emotion.EmojiInfo");
    }

    private int DQ(int i) {
        int i2 = 0;
        Cursor cursor = null;
        try {
            cursor = this.gLA.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{String.valueOf(i), "0"}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i2 = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bi.i(e));
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i2;
    }

    public final int yS(String str) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor cursor = null;
        try {
            cursor = this.gLA.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{str, "0"}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                i = 0;
            } else {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bi.i(e));
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
                i = 0;
            } else {
                i = 0;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        x.d("MicroMsg.emoji.EmojiInfoStorage", "count product id use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return i;
    }

    public final int lP(boolean z) {
        int i = 0;
        Cursor cursor = null;
        String str = "select count(*)  from EmojiInfo where catalog=? ";
        String[] strArr = new String[]{EmojiGroupInfo.xIG};
        if (z) {
            str = "select  count(*) from EmojiInfo where catalog=?  or catalog=?";
            strArr = new String[]{String.valueOf(EmojiGroupInfo.xIF), String.valueOf(EmojiGroupInfo.xIG)};
        }
        try {
            cursor = this.gLA.a(str, strArr, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bi.i(e));
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final List<EmojiInfo> clr() {
        List<EmojiInfo> arrayList = new ArrayList();
        String[] strArr = new String[]{String.valueOf(EmojiGroupInfo.xIF), String.valueOf(EmojiGroupInfo.xIG), String.valueOf(EmojiInfo.xIW)};
        Cursor a = this.gLA.a("select  * from EmojiInfo where catalog=?  or catalog=? and state!=? order by reserved3 asc", strArr, 2);
        if (a.moveToFirst()) {
            do {
                com.tencent.mm.plugin.emoji.d.aAS();
                EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aAT());
                emojiInfo.b(a);
                arrayList.add(emojiInfo);
            } while (a.moveToNext());
        }
        a.close();
        return arrayList;
    }

    public final List<String> cls() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gLA.a("select md5 from EmojiInfo where catalog=?  order by reserved3 asc", new String[]{EmojiGroupInfo.xIG}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", bi.i(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<String> clt() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gLA.a("select md5 from EmojiInfo where catalog=? and source=?", new String[]{EmojiGroupInfo.xIG, EmojiInfo.xIZ}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", bi.i(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final Cursor DR(int i) {
        return this.gLA.query("EmojiInfo", null, "catalog=? and temp=?", new String[]{String.valueOf(i), "0"}, null, null, null);
    }

    private boolean DS(int i) {
        if (this.gLA.delete("EmojiInfo", "catalog=?", new String[]{String.valueOf(i)}) >= 0) {
            return true;
        }
        return false;
    }

    public final void a(Context context, EmojiInfo emojiInfo) {
        int available;
        if (emojiInfo.field_catalog == EmojiInfo.xIJ || emojiInfo.field_catalog == EmojiInfo.xIM || emojiInfo.field_catalog == EmojiInfo.xIL) {
            InputStream inputStream = null;
            try {
                inputStream = EmojiInfo.bk(context, emojiInfo.getName());
                if (inputStream != null) {
                    available = inputStream.available();
                } else {
                    available = 0;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bi.i(e));
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bi.i(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        available = 0;
                    } catch (Throwable e22) {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bi.i(e22));
                        available = 0;
                    }
                } else {
                    available = 0;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bi.i(e3));
                    }
                }
            }
        } else {
            available = com.tencent.mm.a.e.bN(emojiInfo.ptV + emojiInfo.Nx());
        }
        if (available != 0 && available != emojiInfo.field_size) {
            emojiInfo.field_size = available;
            p(emojiInfo);
        }
    }

    private static List<EmojiInfo> a(InputStream[] inputStreamArr) {
        List<EmojiInfo> arrayList = new ArrayList();
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            for (int i = 0; i <= 0; i++) {
                InputStream inputStream = inputStreamArr[i];
                if (inputStream != null) {
                    NodeList elementsByTagName = newDocumentBuilder.parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
                    for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                        Element element = (Element) elementsByTagName.item(i2);
                        int intValue = Integer.decode(element.getAttribute(SlookAirButtonFrequentContactAdapter.ID)).intValue();
                        NodeList elementsByTagName2 = element.getElementsByTagName("emoji");
                        for (int i3 = 0; i3 < elementsByTagName2.getLength(); i3++) {
                            com.tencent.mm.plugin.emoji.d.aAS();
                            EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aAT());
                            element = (Element) elementsByTagName2.item(i3);
                            emojiInfo.field_md5 = element.getAttribute("md5");
                            if (emojiInfo.cln()) {
                                String str;
                                emojiInfo.field_catalog = intValue;
                                emojiInfo.field_groupId = String.valueOf(intValue);
                                emojiInfo.field_name = element.getAttribute("name");
                                emojiInfo.field_type = Integer.decode(element.getAttribute(Columns.TYPE)).intValue();
                                Node firstChild = element.getFirstChild();
                                String data = firstChild instanceof CharacterData ? ((CharacterData) firstChild).getData() : "";
                                if (emojiInfo.field_type == EmojiInfo.TYPE_TEXT) {
                                    str = new String(Base64.decode(data, 0));
                                } else {
                                    str = data;
                                }
                                emojiInfo.field_content = str;
                                arrayList.add(emojiInfo);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "parse xml error; " + e.getMessage());
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.emotion.EmojiInfo YC(java.lang.String r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 2;
        r0 = "select * from EmojiInfo where +groupId = ? and temp=? limit 1 ";
        r1 = new java.lang.String[r1];
        r3 = 0;
        r1[r3] = r8;
        r3 = 1;
        r4 = "0";
        r1[r3] = r4;
        r3 = r7.gLA;	 Catch:{ Exception -> 0x0033 }
        r4 = 2;
        r1 = r3.a(r0, r1, r4);	 Catch:{ Exception -> 0x0033 }
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        if (r0 == 0) goto L_0x006b;
    L_0x001d:
        r3 = new com.tencent.mm.storage.emotion.EmojiInfo;	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        com.tencent.mm.plugin.emoji.d.aAS();	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        r0 = com.tencent.mm.plugin.emoji.d.aAT();	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        r3.b(r1);	 Catch:{ Exception -> 0x0066, all -> 0x005d }
        r0 = r3;
    L_0x002d:
        if (r1 == 0) goto L_0x0032;
    L_0x002f:
        r1.close();
    L_0x0032:
        return r0;
    L_0x0033:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0036:
        r3 = "MicroMsg.emoji.EmojiInfoStorage";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0056 }
        r5 = "getFirstEmojiByGroupId fail.";
        r4.<init>(r5);	 Catch:{ all -> 0x0056 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0056 }
        r1 = r4.append(r1);	 Catch:{ all -> 0x0056 }
        r1 = r1.toString();	 Catch:{ all -> 0x0056 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r1);	 Catch:{ all -> 0x0056 }
        if (r2 == 0) goto L_0x0032;
    L_0x0052:
        r2.close();
        goto L_0x0032;
    L_0x0056:
        r0 = move-exception;
    L_0x0057:
        if (r2 == 0) goto L_0x005c;
    L_0x0059:
        r2.close();
    L_0x005c:
        throw r0;
    L_0x005d:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0057;
    L_0x0060:
        r0 = move-exception;
        r6 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x0036;
    L_0x0066:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0036;
    L_0x006b:
        r0 = r2;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.d.YC(java.lang.String):com.tencent.mm.storage.emotion.EmojiInfo");
    }

    public final List<EmojiInfo> yK(String str) {
        List<EmojiInfo> arrayList = new ArrayList();
        String str2 = "select * from EmojiInfo where groupId=? and temp=? order by idx asc";
        Cursor cursor = null;
        try {
            cursor = this.gLA.a(str2, new String[]{str, "0"}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                com.tencent.mm.plugin.emoji.d.aAS();
                EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aAT());
                emojiInfo.b(cursor);
                arrayList.add(emojiInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.w("MicroMsg.emoji.EmojiInfoStorage", "[getEmojiListByGroupId] Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean cY(List<String> list) {
        boolean z = false;
        if (list == null || list.size() <= 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("catalog");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.xIH);
        stringBuilder.append(",");
        stringBuilder.append("source");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.xIY);
        stringBuilder.append(",");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.xJa);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        while (true) {
            boolean z2 = z;
            if (z2 >= list.size()) {
                break;
            }
            stringBuilder.append("'" + ((String) list.get(z2)) + "'");
            if (z2 < list.size() - 1) {
                stringBuilder.append(",");
            }
            z = z2 + 1;
        }
        stringBuilder.append(")");
        x.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        if (this.gLA.fD("EmojiInfo", stringBuilder.toString())) {
            WI("delete_emoji_info_notify");
        }
        return true;
    }

    public final boolean cZ(List<String> list) {
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin topCustomEmojiByMd5");
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] topCustomEmojiByMd5 failed. list is null");
            return false;
        }
        long dA;
        h hVar;
        List<String> cls = cls();
        if (this.gLA instanceof h) {
            h hVar2 = (h) this.gLA;
            dA = hVar2.dA(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            hVar = null;
            dA = -1;
        }
        int i = 1;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            String str;
            if (it.hasNext()) {
                str = (String) it.next();
                EmojiInfo YB = YB(str);
                if (!(YB == null || bi.oN(YB.Nx()))) {
                    YB.field_reserved3 = i2;
                    if (!cls.isEmpty()) {
                        cls.remove(str);
                    }
                    i2++;
                    if (this.gLA.replace("EmojiInfo", "md5", YB.vP()) < 0) {
                        if (hVar != null) {
                            hVar.fT(dA);
                        }
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return false;
                    }
                }
                i = i2;
            } else {
                if (!cls.isEmpty()) {
                    for (String str2 : cls) {
                        EmojiInfo YB2 = YB(str2);
                        if (!(YB2 == null || bi.oN(YB2.Nx()))) {
                            YB2.field_reserved3 = i2;
                            i2++;
                            if (this.gLA.replace("EmojiInfo", "md5", YB2.vP()) < 0) {
                                if (hVar != null) {
                                    hVar.fT(dA);
                                }
                                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                return false;
                            }
                        }
                    }
                }
                if (hVar != null) {
                    hVar.fT(dA);
                }
                String str3 = "MicroMsg.emoji.EmojiInfoStorage";
                String str4 = "[cpan] end topCustomEmojiByMd5 user time:%d succes. size:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
                x.i(str3, str4, objArr);
                return true;
            }
        }
    }

    public final boolean l(List<EmojiInfo> list, String str) {
        if (list.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "insert emoji list faild. list is null or size is 0.");
            return false;
        }
        long dA;
        h hVar;
        EmojiInfo emojiInfo;
        x.i("MicroMsg.emoji.EmojiInfoStorage", "insertEmojiList groupId:%s size:%d", str, Integer.valueOf(list.size()));
        if (this.gLA instanceof h) {
            h hVar2 = (h) this.gLA;
            dA = hVar2.dA(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            hVar = null;
            dA = -1;
        }
        List<EmojiInfo> yK = yK(str);
        Map hashMap = new HashMap();
        for (EmojiInfo emojiInfo2 : yK) {
            hashMap.put(emojiInfo2.Nx(), emojiInfo2);
        }
        for (int i = 0; i < list.size(); i++) {
            emojiInfo2 = (EmojiInfo) list.get(i);
            emojiInfo2.field_temp = 0;
            this.gLA.replace("EmojiInfo", "md5", emojiInfo2.vP());
            hashMap.remove(emojiInfo2.Nx());
        }
        for (Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            emojiInfo2 = (EmojiInfo) entry.getValue();
            emojiInfo2.field_temp = 1;
            this.gLA.update("EmojiInfo", emojiInfo2.vP(), "md5=?", new String[]{str2});
            x.d("MicroMsg.emoji.EmojiInfoStorage", "jacks modify excess emoji to %s", emojiInfo2.field_groupId);
        }
        if (hVar != null) {
            hVar.fT(dA);
        }
        return true;
    }

    public final boolean YD(String str) {
        boolean z = false;
        String str2 = "select * from EmojiInfo where md5=?";
        Cursor cursor = null;
        try {
            cursor = this.gLA.a(str2, new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get judge is Exist EmojiInfo fail. md5 id is %s, err: %s", str, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z;
    }

    public final boolean YE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.gLA.delete("EmojiInfo", "groupId = '" + str + "'", null) >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "Delete By ProductId fail." + e.getMessage());
            return false;
        }
    }

    public final List<String> clu() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gLA.a("select md5 from EmojiInfo where catalog=? or temp=?", new String[]{"85", "2"}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", bi.i(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int clv() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = this.gLA.rawQuery("select md5 from EmojiInfo where catalog=? or temp=?", new String[]{"85", "2"});
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getCount();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", bi.i(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final boolean ay(LinkedList<String> linkedList) {
        boolean z = false;
        if (linkedList == null || linkedList.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList failed. list is null");
            return false;
        }
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList list size :%d.", Integer.valueOf(linkedList.size()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.xJb);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        while (true) {
            boolean z2 = z;
            if (z2 < linkedList.size()) {
                stringBuilder.append("'" + ((String) linkedList.get(z2)) + "'");
                if (z2 < linkedList.size() - 1) {
                    stringBuilder.append(",");
                }
                z = z2 + 1;
            } else {
                stringBuilder.append(")");
                x.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
                return this.gLA.fD("EmojiInfo", stringBuilder.toString());
            }
        }
    }

    public final ArrayList<String> clw() {
        ArrayList<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gLA.a("select md5 from EmojiInfo where needupload=? and catalog=?", new String[]{String.valueOf(EmojiInfo.xJb), String.valueOf(EmojiGroupInfo.xIG)}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get need upload emoji MD5 list failed :%s", bi.i(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int clx() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = this.gLA.a("select reserved3 from EmojiInfo where catalog=? order by reserved3 desc limit 1", new String[]{String.valueOf(EmojiGroupInfo.xIG)}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "getCustomEmojiMaxIndex :%s", bi.i(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final ArrayList<EmojiInfo> cly() {
        Throwable e;
        Cursor a;
        try {
            a = this.gLA.a("SELECT * FROM EmojiInfo WHERE catalog =?  OR catalog=? OR groupId IS NOT NULL", new String[]{String.valueOf(EmojiGroupInfo.xIG), String.valueOf(EmojiGroupInfo.xIH)}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        ArrayList<EmojiInfo> arrayList = new ArrayList();
                        do {
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.b(a);
                            if ((emojiInfo.field_reserved4 & EmojiInfo.xJc) != EmojiInfo.xJc) {
                                arrayList.add(emojiInfo);
                            }
                        } while (a.moveToNext());
                        if (a == null) {
                            return arrayList;
                        }
                        a.close();
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "getAllStoreAndCustomEmoji :%s", bi.i(e));
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return null;
    }

    public final String getKey() {
        String string;
        Throwable e;
        EmojiInfo emojiInfo;
        Cursor a;
        try {
            a = this.gLA.a("SELECT md5 FROM EmojiInfo WHERE catalog =?", new String[]{"153"}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        string = a.getString(0);
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "had key :%s" + bi.Wz(string));
                        if (a == null) {
                            return string;
                        }
                        a.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "createKey :%s", bi.i(e));
                        if (a != null) {
                            a.close();
                        }
                        string = bi.eY(ad.getContext());
                        if (bi.oN(string)) {
                            string = com.tencent.mm.a.g.s("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
                        } else {
                            string = com.tencent.mm.a.g.s(string.getBytes());
                        }
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bi.Wz(string));
                        emojiInfo = new EmojiInfo();
                        emojiInfo.field_md5 = string;
                        emojiInfo.field_catalog = 153;
                        if (o(emojiInfo)) {
                            return string;
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        string = bi.eY(ad.getContext());
        if (bi.oN(string)) {
            string = com.tencent.mm.a.g.s(string.getBytes());
        } else {
            string = com.tencent.mm.a.g.s("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
        }
        x.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bi.Wz(string));
        emojiInfo = new EmojiInfo();
        emojiInfo.field_md5 = string;
        emojiInfo.field_catalog = 153;
        if (o(emojiInfo)) {
            return null;
        }
        return string;
    }

    public final boolean da(List<sf> list) {
        int i = 0;
        if (list == null || list.isEmpty()) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL failed. empty list");
            return false;
        }
        long dA;
        h hVar;
        x.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL size:%d", Integer.valueOf(list.size()));
        if (this.gLA instanceof h) {
            h hVar2 = (h) this.gLA;
            dA = hVar2.dA(Thread.currentThread().getId());
            x.i("MicroMsg.emoji.EmojiInfoStorage", "surround updateEmojiURL in a transaction, ticket = %d", Long.valueOf(dA));
            hVar = hVar2;
        } else {
            hVar = null;
            dA = -1;
        }
        while (i < list.size()) {
            sf sfVar = (sf) list.get(i);
            EmojiInfo YB = YB(sfVar.wgP);
            if (YB == null) {
                YB = new EmojiInfo();
                YB.field_md5 = sfVar.wgP;
                YB.field_catalog = EmojiInfo.xIH;
                x.i("MicroMsg.emoji.EmojiInfoStorage", "new emoji as received when updateEmoji url");
            }
            YB.field_cdnUrl = sfVar.nlE;
            YB.field_encrypturl = sfVar.wgR;
            YB.field_aeskey = sfVar.wgS;
            YB.field_designerID = sfVar.wgQ;
            YB.field_thumbUrl = sfVar.phv;
            YB.field_groupId = sfVar.vPI;
            p(YB);
            i++;
        }
        if (hVar != null) {
            hVar.fT(dA);
            x.i("MicroMsg.emoji.EmojiInfoStorage", "end updateList transaction");
        }
        return true;
    }
}
