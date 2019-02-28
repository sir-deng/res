package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 414;
    public static final String NAME = "searchContacts";
    private List<String[]> jmq;

    public final void a(final j jVar, final JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiSearchContacts", "data is null, err");
            jVar.E(i, e("fail:invalid data", null));
            return;
        }
        x.i("MicroMsg.JsApiSearchContacts", "JsApiSearchContacts invoke");
        x.d("MicroMsg.JsApiSearchContacts", "data:%s", jSONObject);
        Context a = a(jVar);
        if (a == null) {
            x.e("MicroMsg.JsApiSearchContacts", "getPageContext failed, appid is %s", jVar.mAppId);
            jVar.E(i, e("fail", null));
            return;
        }
        boolean z;
        com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i == 48) {
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        jVar.E(i, e.this.e("fail:system permission denied", null));
                    } else {
                        e.this.a(jVar, jSONObject, i);
                    }
                }
            }
        });
        Activity a2 = a(jVar);
        if (a2 == null) {
            jVar.E(i, e("fail", null));
            z = false;
        } else {
            z = com.tencent.mm.pluginsdk.g.a.a(a2, "android.permission.READ_CONTACTS", 48, "", "");
            if (z) {
                com.tencent.mm.plugin.appbrand.a.pj(jVar.mAppId);
            }
        }
        if (z) {
            String optString = jSONObject.optString("phoneNumber");
            Map hashMap;
            if (optString.length() < 8) {
                x.e("MicroMsg.JsApiSearchContacts", "phoneNumber is short");
                hashMap = new HashMap();
                hashMap.put("result", "");
                jVar.E(i, e("ok", hashMap));
                return;
            }
            if (this.jmq == null) {
                this.jmq = bW(a);
            }
            if (this.jmq == null) {
                x.e("MicroMsg.JsApiSearchContacts", "addressList is null, err");
                jVar.E(i, e("fail", null));
                return;
            }
            JSONArray jSONArray = new JSONArray();
            if (!(this.jmq == null || this.jmq.isEmpty())) {
                for (String[] strArr : this.jmq) {
                    String str = strArr[2];
                    if (str == null) {
                        str = null;
                    } else {
                        str = str.replaceAll("\\D", "");
                        if (str.startsWith("86")) {
                            str = str.substring(2);
                        }
                    }
                    String aD = bi.aD(strArr[1], "");
                    if (!bi.oN(str) && bi(optString, str)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("phoneNumber", str);
                            jSONObject2.put("name", aD);
                            jSONArray.put(jSONObject2);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.JsApiSearchContacts", e, "", new Object[0]);
                        }
                    }
                }
            }
            x.d("MicroMsg.JsApiSearchContacts", "resultArray:%s", jSONArray.toString());
            hashMap = new HashMap();
            hashMap.put("result", jSONArray.toString());
            jVar.E(i, e("ok", hashMap));
            return;
        }
        x.i("MicroMsg.JsApiSearchContacts", "check permission");
    }

    private static boolean bi(String str, String str2) {
        if (bi.oN(str) || bi.oN(str2)) {
            x.e("MicroMsg.JsApiSearchContacts", "phoneNumber or targetPhoneNumber is null, return false");
            return false;
        }
        int length = str.length();
        int length2 = str2.length();
        if (length < 8) {
            x.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, return false", Integer.valueOf(str.length()));
            return false;
        } else if (length > length2) {
            x.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, targetPhoneNumberSize:%d return false", Integer.valueOf(length), Integer.valueOf(length2));
            return false;
        } else {
            length2 = 0;
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) != str2.charAt(i)) {
                    length2++;
                    if (length2 > 3) {
                        break;
                    }
                }
            }
            return length2 <= 3;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.String[]> bW(android.content.Context r10) {
        /*
        r9 = 1;
        r8 = 0;
        r7 = 0;
        r6 = new java.util.LinkedList;
        r6.<init>();
        r0 = r10.getContentResolver();
        r1 = "android.permission.READ_CONTACTS";
        r1 = com.tencent.mm.pluginsdk.g.a.aZ(r10, r1);
        if (r1 != 0) goto L_0x0020;
    L_0x0015:
        r0 = "MicroMsg.JsApiSearchContacts";
        r1 = "no contact permission";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r6;
    L_0x001f:
        return r0;
    L_0x0020:
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;	 Catch:{ Exception -> 0x003a }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = "sort_key_alt";
        r0 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x003a }
        r1 = r0;
    L_0x002d:
        if (r1 != 0) goto L_0x0063;
    L_0x002f:
        r0 = "MicroMsg.JsApiSearchContacts";
        r1 = "getMobileInfo: mobile is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r6;
        goto L_0x001f;
    L_0x003a:
        r1 = move-exception;
        r2 = "MicroMsg.JsApiSearchContacts";
        r3 = "";
        r4 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        r2 = "MicroMsg.JsApiSearchContacts";
        r3 = "exception in getMoblieOrderInfo(), [%s]";
        r4 = new java.lang.Object[r9];
        r1 = r1.getMessage();
        r4[r8] = r1;
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        r2 = r7;
        r3 = r7;
        r4 = r7;
        r5 = r7;
        r0 = r0.query(r1, r2, r3, r4, r5);
        r1 = r0;
        goto L_0x002d;
    L_0x0063:
        r0 = r1.getCount();	 Catch:{ Exception -> 0x00b9 }
        if (r0 <= 0) goto L_0x00b3;
    L_0x0069:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x00b9 }
        if (r0 == 0) goto L_0x00b3;
    L_0x006f:
        r0 = "display_name";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00b9 }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x00b9 }
        r2 = "contact_id";
        r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x00b9 }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x00b9 }
        r3 = "data1";
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x00b9 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x00b9 }
        r4 = "raw_contact_id";
        r4 = r1.getColumnIndex(r4);	 Catch:{ Exception -> 0x00b9 }
        r4 = r1.getString(r4);	 Catch:{ Exception -> 0x00b9 }
        r5 = 4;
        r5 = new java.lang.String[r5];	 Catch:{ Exception -> 0x00b9 }
        r7 = 0;
        r5[r7] = r2;	 Catch:{ Exception -> 0x00b9 }
        r2 = 1;
        r5[r2] = r0;	 Catch:{ Exception -> 0x00b9 }
        r0 = 2;
        r5[r0] = r3;	 Catch:{ Exception -> 0x00b9 }
        r0 = 3;
        r5[r0] = r4;	 Catch:{ Exception -> 0x00b9 }
        r6.add(r5);	 Catch:{ Exception -> 0x00b9 }
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x00b9 }
        if (r0 != 0) goto L_0x006f;
    L_0x00b3:
        r1.close();
    L_0x00b6:
        r0 = r6;
        goto L_0x001f;
    L_0x00b9:
        r0 = move-exception;
        r2 = "MicroMsg.JsApiSearchContacts";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00dd }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);	 Catch:{ all -> 0x00dd }
        r2 = "MicroMsg.JsApiSearchContacts";
        r3 = "exception in getMoblieOrderInfo()2, [%s]";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00dd }
        r5 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x00dd }
        r4[r5] = r0;	 Catch:{ all -> 0x00dd }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x00dd }
        r1.close();
        goto L_0x00b6;
    L_0x00dd:
        r0 = move-exception;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.contact.e.bW(android.content.Context):java.util.List<java.lang.String[]>");
    }
}
