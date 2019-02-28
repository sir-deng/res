package com.tencent.mm.modelsimple;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.Profile;
import android.telephony.TelephonyManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.b;
import com.tencent.mm.network.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public final class c {
    @TargetApi(14)
    public static String z(Context context, String str) {
        String str2;
        Throwable e;
        ContentResolver contentResolver;
        Cursor cursor;
        String str3;
        int columnIndex;
        int i;
        Cursor query;
        Throwable th;
        Throwable e2;
        Throwable e3;
        Throwable th2;
        Cursor cursor2;
        x.i("MicroMsg.ContactsUtil", "Get phone number. country code : %s", str);
        if (context == null) {
            x.e("MicroMsg.ContactsUtil", "The context is null.");
            return null;
        }
        String networkCountryIso;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String str4 = null;
        String str5 = null;
        try {
            str4 = telephonyManager.getLine1Number();
            str5 = telephonyManager.getSimCountryIso();
            try {
                if (bi.oN(str5)) {
                    networkCountryIso = telephonyManager.getNetworkCountryIso();
                } else {
                    networkCountryIso = str5;
                }
                try {
                    if (bi.oN(networkCountryIso)) {
                        networkCountryIso = Locale.getDefault().getCountry();
                    }
                    str2 = networkCountryIso;
                    networkCountryIso = str4;
                } catch (Exception e4) {
                    e = e4;
                    x.printErrStackTrace("MicroMsg.ContactsUtil", e, "", new Object[0]);
                    x.e("MicroMsg.ContactsUtil", "get line number got exception");
                    str2 = networkCountryIso;
                    networkCountryIso = str4;
                    if (bi.oN(networkCountryIso)) {
                        str4 = networkCountryIso.trim();
                        networkCountryIso = ap.fw(str4, str2);
                        x.i("MicroMsg.ContactsUtil", "get num : %s, extract country code  : %s, iso : %s", str4, networkCountryIso, str2);
                        if (bi.oN(networkCountryIso)) {
                            networkCountryIso = str4;
                        } else {
                            networkCountryIso = str4.substring((str4.startsWith("+") ? 1 : 0) + networkCountryIso.length());
                            x.i("MicroMsg.ContactsUtil", "after deal, the num is %s", networkCountryIso);
                        }
                        x.i("MicroMsg.ContactsUtil", "Got phone number by TelephonyManager.");
                        return networkCountryIso;
                    } else if (a.aZ(context, "android.permission.READ_CONTACTS")) {
                        contentResolver = context.getContentResolver();
                        cursor = null;
                        str3 = null;
                        if (!f.fO(14)) {
                            x.i("MicroMsg.ContactsUtil", "The device os API version is higher than 14.");
                            try {
                                cursor = contentResolver.query(Profile.CONTENT_URI, new String[]{"has_phone_number"}, null, null, null);
                                columnIndex = cursor.getColumnIndex("has_phone_number");
                                if (columnIndex != -1) {
                                    i = cursor.getInt(columnIndex);
                                    x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                                    cursor.close();
                                    if (i > 0) {
                                        try {
                                            query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, SlookAirButtonFrequentContactAdapter.DATA), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                            if (query == null) {
                                                try {
                                                    if (query.moveToFirst()) {
                                                        columnIndex = query.getColumnIndex("data1");
                                                        if (columnIndex != -1) {
                                                            str3 = query.getString(columnIndex);
                                                            try {
                                                                x.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", str3);
                                                            } catch (Throwable e22) {
                                                                th = e22;
                                                                str4 = str3;
                                                                try {
                                                                    x.printErrStackTrace("MicroMsg.ContactsUtil", th, "", new Object[0]);
                                                                    x.d("MicroMsg.ContactsUtil", "query crashed");
                                                                    if (!(query == null || query.isClosed())) {
                                                                        query.close();
                                                                        str3 = str4;
                                                                        cursor = query;
                                                                        if (bi.oN(str3)) {
                                                                            if (!bi.oN(A(context, d.bx(context)))) {
                                                                                try {
                                                                                    query = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{A(context, d.bx(context))}, null);
                                                                                    if (query != null) {
                                                                                        try {
                                                                                            if (query.moveToFirst()) {
                                                                                                columnIndex = query.getInt(query.getColumnIndex("has_phone_number"));
                                                                                                if (query == null) {
                                                                                                    query.close();
                                                                                                    cursor = query;
                                                                                                } else {
                                                                                                    cursor = query;
                                                                                                }
                                                                                                x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                                                                if (columnIndex > 0) {
                                                                                                    try {
                                                                                                        cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                                                                                        do {
                                                                                                            str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                                                                            if (!bi.oN(str3)) {
                                                                                                                x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                                                                break;
                                                                                                            }
                                                                                                        } while (cursor.moveToNext());
                                                                                                        if (cursor != null) {
                                                                                                            cursor.close();
                                                                                                        }
                                                                                                    } catch (Throwable e32) {
                                                                                                        x.printErrStackTrace("MicroMsg.ContactsUtil", e32, "", new Object[0]);
                                                                                                        if (cursor != null) {
                                                                                                            cursor.close();
                                                                                                        }
                                                                                                    } catch (Throwable th3) {
                                                                                                        if (cursor != null) {
                                                                                                            cursor.close();
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        } catch (Throwable e222) {
                                                                                            th2 = e222;
                                                                                            cursor2 = query;
                                                                                            e = th2;
                                                                                            try {
                                                                                                x.printErrStackTrace("MicroMsg.ContactsUtil", e, "", new Object[0]);
                                                                                                if (cursor2 != null) {
                                                                                                    cursor2.close();
                                                                                                    cursor = cursor2;
                                                                                                    columnIndex = 0;
                                                                                                } else {
                                                                                                    cursor = cursor2;
                                                                                                    columnIndex = 0;
                                                                                                }
                                                                                                x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                                                                if (columnIndex > 0) {
                                                                                                    cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                                                                                    do {
                                                                                                        str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                                                                        if (!bi.oN(str3)) {
                                                                                                            x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                                                            break;
                                                                                                        }
                                                                                                    } while (cursor.moveToNext());
                                                                                                    if (cursor != null) {
                                                                                                        cursor.close();
                                                                                                    }
                                                                                                }
                                                                                                if (!bi.oN(str3)) {
                                                                                                    networkCountryIso = ap.fw(str3, str2);
                                                                                                    x.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                                                                                    if (!bi.oN(networkCountryIso)) {
                                                                                                        if (str3.startsWith("+")) {
                                                                                                            networkCountryIso = "+" + networkCountryIso;
                                                                                                        } else if (!str3.startsWith(networkCountryIso)) {
                                                                                                            networkCountryIso = null;
                                                                                                        }
                                                                                                        if (networkCountryIso != null) {
                                                                                                            str3 = str3.substring(networkCountryIso.length());
                                                                                                        }
                                                                                                    }
                                                                                                    x.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                                                                                                }
                                                                                                return str3;
                                                                                            } catch (Throwable th4) {
                                                                                                e32 = th4;
                                                                                                cursor = cursor2;
                                                                                                if (cursor != null) {
                                                                                                    cursor.close();
                                                                                                }
                                                                                                throw e32;
                                                                                            }
                                                                                        } catch (Throwable th5) {
                                                                                            e32 = th5;
                                                                                            cursor = query;
                                                                                            if (cursor != null) {
                                                                                                cursor.close();
                                                                                            }
                                                                                            throw e32;
                                                                                        }
                                                                                    }
                                                                                    columnIndex = 0;
                                                                                    if (query == null) {
                                                                                        cursor = query;
                                                                                    } else {
                                                                                        query.close();
                                                                                        cursor = query;
                                                                                    }
                                                                                } catch (Throwable e2222) {
                                                                                    e = e2222;
                                                                                    cursor2 = cursor;
                                                                                } catch (Throwable th6) {
                                                                                    e32 = th6;
                                                                                    if (cursor != null) {
                                                                                        cursor.close();
                                                                                    }
                                                                                    throw e32;
                                                                                }
                                                                                x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                                                if (columnIndex > 0) {
                                                                                    cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                                                                    do {
                                                                                        str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                                                        if (!bi.oN(str3)) {
                                                                                            x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                                            break;
                                                                                        }
                                                                                    } while (cursor.moveToNext());
                                                                                    if (cursor != null) {
                                                                                        cursor.close();
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        if (bi.oN(str3)) {
                                                                            networkCountryIso = ap.fw(str3, str2);
                                                                            x.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                                                            if (bi.oN(networkCountryIso)) {
                                                                                if (str3.startsWith("+")) {
                                                                                    networkCountryIso = "+" + networkCountryIso;
                                                                                } else if (str3.startsWith(networkCountryIso)) {
                                                                                    networkCountryIso = null;
                                                                                }
                                                                                if (networkCountryIso != null) {
                                                                                    str3 = str3.substring(networkCountryIso.length());
                                                                                }
                                                                            }
                                                                            x.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                                                                        }
                                                                        return str3;
                                                                    }
                                                                    str3 = str4;
                                                                    cursor = query;
                                                                    if (bi.oN(str3)) {
                                                                        if (bi.oN(A(context, d.bx(context)))) {
                                                                            query = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{A(context, d.bx(context))}, null);
                                                                            if (query != null) {
                                                                                if (query.moveToFirst()) {
                                                                                    columnIndex = query.getInt(query.getColumnIndex("has_phone_number"));
                                                                                    if (query == null) {
                                                                                        query.close();
                                                                                        cursor = query;
                                                                                    } else {
                                                                                        cursor = query;
                                                                                    }
                                                                                    x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                                                    if (columnIndex > 0) {
                                                                                        cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                                                                        do {
                                                                                            str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                                                            if (!bi.oN(str3)) {
                                                                                                x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                                                break;
                                                                                            }
                                                                                        } while (cursor.moveToNext());
                                                                                        if (cursor != null) {
                                                                                            cursor.close();
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            columnIndex = 0;
                                                                            if (query == null) {
                                                                                cursor = query;
                                                                            } else {
                                                                                query.close();
                                                                                cursor = query;
                                                                            }
                                                                            x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                                            if (columnIndex > 0) {
                                                                                cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                                                                do {
                                                                                    str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                                                    if (!bi.oN(str3)) {
                                                                                        x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                                        break;
                                                                                    }
                                                                                } while (cursor.moveToNext());
                                                                                if (cursor != null) {
                                                                                    cursor.close();
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    if (bi.oN(str3)) {
                                                                        networkCountryIso = ap.fw(str3, str2);
                                                                        x.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                                                        if (bi.oN(networkCountryIso)) {
                                                                            if (str3.startsWith("+")) {
                                                                                networkCountryIso = "+" + networkCountryIso;
                                                                            } else if (str3.startsWith(networkCountryIso)) {
                                                                                networkCountryIso = null;
                                                                            }
                                                                            if (networkCountryIso != null) {
                                                                                str3 = str3.substring(networkCountryIso.length());
                                                                            }
                                                                        }
                                                                        x.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                                                                    }
                                                                    return str3;
                                                                } catch (Throwable th7) {
                                                                    e32 = th7;
                                                                    query.close();
                                                                    throw e32;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    query.close();
                                                    str4 = str3;
                                                } catch (Throwable e22222) {
                                                    th = e22222;
                                                    str4 = null;
                                                    x.printErrStackTrace("MicroMsg.ContactsUtil", th, "", new Object[0]);
                                                    x.d("MicroMsg.ContactsUtil", "query crashed");
                                                    query.close();
                                                    str3 = str4;
                                                    cursor = query;
                                                    if (bi.oN(str3)) {
                                                        if (bi.oN(A(context, d.bx(context)))) {
                                                            query = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{A(context, d.bx(context))}, null);
                                                            if (query != null) {
                                                                if (query.moveToFirst()) {
                                                                    columnIndex = query.getInt(query.getColumnIndex("has_phone_number"));
                                                                    if (query == null) {
                                                                        query.close();
                                                                        cursor = query;
                                                                    } else {
                                                                        cursor = query;
                                                                    }
                                                                    x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                                    if (columnIndex > 0) {
                                                                        cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                                                        do {
                                                                            str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                                            if (!bi.oN(str3)) {
                                                                                x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                                break;
                                                                            }
                                                                        } while (cursor.moveToNext());
                                                                        if (cursor != null) {
                                                                            cursor.close();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            columnIndex = 0;
                                                            if (query == null) {
                                                                cursor = query;
                                                            } else {
                                                                query.close();
                                                                cursor = query;
                                                            }
                                                            x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                            if (columnIndex > 0) {
                                                                cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                                                do {
                                                                    str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                                    if (!bi.oN(str3)) {
                                                                        x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                        break;
                                                                    }
                                                                } while (cursor.moveToNext());
                                                                if (cursor != null) {
                                                                    cursor.close();
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (bi.oN(str3)) {
                                                        networkCountryIso = ap.fw(str3, str2);
                                                        x.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                                        if (bi.oN(networkCountryIso)) {
                                                            if (str3.startsWith("+")) {
                                                                networkCountryIso = "+" + networkCountryIso;
                                                            } else if (str3.startsWith(networkCountryIso)) {
                                                                networkCountryIso = null;
                                                            }
                                                            if (networkCountryIso != null) {
                                                                str3 = str3.substring(networkCountryIso.length());
                                                            }
                                                        }
                                                        x.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                                                    }
                                                    return str3;
                                                }
                                            }
                                            str4 = null;
                                            query.close();
                                            str3 = str4;
                                            cursor = query;
                                        } catch (Throwable e222222) {
                                            th = e222222;
                                            query = cursor;
                                            str4 = null;
                                        } catch (Throwable th8) {
                                            e32 = th8;
                                            query = cursor;
                                            if (!(query == null || query.isClosed())) {
                                                query.close();
                                            }
                                            throw e32;
                                        }
                                    }
                                }
                                i = 0;
                                try {
                                    x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                                    cursor.close();
                                } catch (Exception e5) {
                                    e222222 = e5;
                                    try {
                                        x.printErrStackTrace("MicroMsg.ContactsUtil", e222222, "", new Object[0]);
                                        x.d("MicroMsg.ContactsUtil", "query crashed");
                                        cursor.close();
                                        if (i > 0) {
                                            query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, SlookAirButtonFrequentContactAdapter.DATA), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                            if (query == null) {
                                                str4 = null;
                                            } else {
                                                if (query.moveToFirst()) {
                                                    columnIndex = query.getColumnIndex("data1");
                                                    if (columnIndex != -1) {
                                                        str3 = query.getString(columnIndex);
                                                        x.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", str3);
                                                    }
                                                }
                                                query.close();
                                                str4 = str3;
                                            }
                                            query.close();
                                            str3 = str4;
                                            cursor = query;
                                        }
                                        if (bi.oN(str3)) {
                                            if (bi.oN(A(context, d.bx(context)))) {
                                                query = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{A(context, d.bx(context))}, null);
                                                if (query != null) {
                                                    if (query.moveToFirst()) {
                                                        columnIndex = query.getInt(query.getColumnIndex("has_phone_number"));
                                                        if (query == null) {
                                                            query.close();
                                                            cursor = query;
                                                        } else {
                                                            cursor = query;
                                                        }
                                                        x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                        if (columnIndex > 0) {
                                                            cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                                            do {
                                                                str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                                if (!bi.oN(str3)) {
                                                                    x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                                    break;
                                                                }
                                                            } while (cursor.moveToNext());
                                                            if (cursor != null) {
                                                                cursor.close();
                                                            }
                                                        }
                                                    }
                                                }
                                                columnIndex = 0;
                                                if (query == null) {
                                                    cursor = query;
                                                } else {
                                                    query.close();
                                                    cursor = query;
                                                }
                                                x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                if (columnIndex > 0) {
                                                    cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                                    do {
                                                        str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                        if (!bi.oN(str3)) {
                                                            x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                            break;
                                                        }
                                                    } while (cursor.moveToNext());
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                }
                                            }
                                        }
                                        if (bi.oN(str3)) {
                                            networkCountryIso = ap.fw(str3, str2);
                                            x.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                            if (bi.oN(networkCountryIso)) {
                                                if (str3.startsWith("+")) {
                                                    networkCountryIso = "+" + networkCountryIso;
                                                } else if (str3.startsWith(networkCountryIso)) {
                                                    networkCountryIso = null;
                                                }
                                                if (networkCountryIso != null) {
                                                    str3 = str3.substring(networkCountryIso.length());
                                                }
                                            }
                                            x.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                                        }
                                        return str3;
                                    } catch (Throwable th9) {
                                        if (!(cursor == null || cursor.isClosed())) {
                                            cursor.close();
                                        }
                                    }
                                }
                            } catch (Exception e6) {
                                e222222 = e6;
                                i = 0;
                                x.printErrStackTrace("MicroMsg.ContactsUtil", e222222, "", new Object[0]);
                                x.d("MicroMsg.ContactsUtil", "query crashed");
                                if (!(cursor == null || cursor.isClosed())) {
                                    cursor.close();
                                }
                                if (i > 0) {
                                    query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, SlookAirButtonFrequentContactAdapter.DATA), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                    if (query == null) {
                                        if (query.moveToFirst()) {
                                            columnIndex = query.getColumnIndex("data1");
                                            if (columnIndex != -1) {
                                                str3 = query.getString(columnIndex);
                                                x.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", str3);
                                            }
                                        }
                                        query.close();
                                        str4 = str3;
                                    } else {
                                        str4 = null;
                                    }
                                    query.close();
                                    str3 = str4;
                                    cursor = query;
                                }
                                if (bi.oN(str3)) {
                                    if (bi.oN(A(context, d.bx(context)))) {
                                        query = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{A(context, d.bx(context))}, null);
                                        if (query != null) {
                                            if (query.moveToFirst()) {
                                                columnIndex = query.getInt(query.getColumnIndex("has_phone_number"));
                                                if (query == null) {
                                                    query.close();
                                                    cursor = query;
                                                } else {
                                                    cursor = query;
                                                }
                                                x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                                if (columnIndex > 0) {
                                                    cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                                    do {
                                                        str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                        if (!bi.oN(str3)) {
                                                            x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                            break;
                                                        }
                                                    } while (cursor.moveToNext());
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                }
                                            }
                                        }
                                        columnIndex = 0;
                                        if (query == null) {
                                            cursor = query;
                                        } else {
                                            query.close();
                                            cursor = query;
                                        }
                                        x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                        if (columnIndex > 0) {
                                            cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                            do {
                                                str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                if (!bi.oN(str3)) {
                                                    x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                    break;
                                                }
                                            } while (cursor.moveToNext());
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                        }
                                    }
                                }
                                if (bi.oN(str3)) {
                                    networkCountryIso = ap.fw(str3, str2);
                                    x.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                                    if (bi.oN(networkCountryIso)) {
                                        if (str3.startsWith("+")) {
                                            networkCountryIso = "+" + networkCountryIso;
                                        } else if (str3.startsWith(networkCountryIso)) {
                                            networkCountryIso = null;
                                        }
                                        if (networkCountryIso != null) {
                                            str3 = str3.substring(networkCountryIso.length());
                                        }
                                    }
                                    x.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                                }
                                return str3;
                            }
                            if (i > 0) {
                                query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, SlookAirButtonFrequentContactAdapter.DATA), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                if (query == null) {
                                    str4 = null;
                                } else {
                                    if (query.moveToFirst()) {
                                        columnIndex = query.getColumnIndex("data1");
                                        if (columnIndex != -1) {
                                            str3 = query.getString(columnIndex);
                                            x.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", str3);
                                        }
                                    }
                                    query.close();
                                    str4 = str3;
                                }
                                query.close();
                                str3 = str4;
                                cursor = query;
                            }
                        }
                        if (bi.oN(str3)) {
                            if (bi.oN(A(context, d.bx(context)))) {
                                query = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{A(context, d.bx(context))}, null);
                                if (query != null) {
                                    if (query.moveToFirst()) {
                                        columnIndex = query.getInt(query.getColumnIndex("has_phone_number"));
                                        if (query == null) {
                                            query.close();
                                            cursor = query;
                                        } else {
                                            cursor = query;
                                        }
                                        x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                        if (columnIndex > 0) {
                                            cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                            do {
                                                str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                                if (!bi.oN(str3)) {
                                                    x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                    break;
                                                }
                                            } while (cursor.moveToNext());
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                        }
                                    }
                                }
                                columnIndex = 0;
                                if (query == null) {
                                    cursor = query;
                                } else {
                                    query.close();
                                    cursor = query;
                                }
                                x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                if (columnIndex > 0) {
                                    cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                    do {
                                        str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                        if (!bi.oN(str3)) {
                                            x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                            break;
                                        }
                                    } while (cursor.moveToNext());
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                }
                            }
                        }
                        if (bi.oN(str3)) {
                            networkCountryIso = ap.fw(str3, str2);
                            x.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                            if (bi.oN(networkCountryIso)) {
                                if (str3.startsWith("+")) {
                                    networkCountryIso = "+" + networkCountryIso;
                                } else if (str3.startsWith(networkCountryIso)) {
                                    networkCountryIso = null;
                                }
                                if (networkCountryIso != null) {
                                    str3 = str3.substring(networkCountryIso.length());
                                }
                            }
                            x.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                        }
                        return str3;
                    } else {
                        x.e("MicroMsg.ContactsUtil", "no contact permission");
                        return null;
                    }
                }
            } catch (Throwable e322) {
                th2 = e322;
                networkCountryIso = str5;
                e = th2;
                x.printErrStackTrace("MicroMsg.ContactsUtil", e, "", new Object[0]);
                x.e("MicroMsg.ContactsUtil", "get line number got exception");
                str2 = networkCountryIso;
                networkCountryIso = str4;
                if (bi.oN(networkCountryIso)) {
                    str4 = networkCountryIso.trim();
                    networkCountryIso = ap.fw(str4, str2);
                    x.i("MicroMsg.ContactsUtil", "get num : %s, extract country code  : %s, iso : %s", str4, networkCountryIso, str2);
                    if (bi.oN(networkCountryIso)) {
                        networkCountryIso = str4;
                    } else {
                        if (str4.startsWith("+")) {
                        }
                        networkCountryIso = str4.substring((str4.startsWith("+") ? 1 : 0) + networkCountryIso.length());
                        x.i("MicroMsg.ContactsUtil", "after deal, the num is %s", networkCountryIso);
                    }
                    x.i("MicroMsg.ContactsUtil", "Got phone number by TelephonyManager.");
                    return networkCountryIso;
                } else if (a.aZ(context, "android.permission.READ_CONTACTS")) {
                    contentResolver = context.getContentResolver();
                    cursor = null;
                    str3 = null;
                    if (f.fO(14)) {
                        x.i("MicroMsg.ContactsUtil", "The device os API version is higher than 14.");
                        cursor = contentResolver.query(Profile.CONTENT_URI, new String[]{"has_phone_number"}, null, null, null);
                        columnIndex = cursor.getColumnIndex("has_phone_number");
                        if (columnIndex != -1) {
                            i = cursor.getInt(columnIndex);
                            x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                            cursor.close();
                            if (i > 0) {
                                query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, SlookAirButtonFrequentContactAdapter.DATA), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                if (query == null) {
                                    str4 = null;
                                } else {
                                    if (query.moveToFirst()) {
                                        columnIndex = query.getColumnIndex("data1");
                                        if (columnIndex != -1) {
                                            str3 = query.getString(columnIndex);
                                            x.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", str3);
                                        }
                                    }
                                    query.close();
                                    str4 = str3;
                                }
                                query.close();
                                str3 = str4;
                                cursor = query;
                            }
                        }
                        i = 0;
                        x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                        cursor.close();
                        if (i > 0) {
                            query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, SlookAirButtonFrequentContactAdapter.DATA), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                            if (query == null) {
                                if (query.moveToFirst()) {
                                    columnIndex = query.getColumnIndex("data1");
                                    if (columnIndex != -1) {
                                        str3 = query.getString(columnIndex);
                                        x.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", str3);
                                    }
                                }
                                query.close();
                                str4 = str3;
                            } else {
                                str4 = null;
                            }
                            query.close();
                            str3 = str4;
                            cursor = query;
                        }
                    }
                    if (bi.oN(str3)) {
                        if (bi.oN(A(context, d.bx(context)))) {
                            query = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{A(context, d.bx(context))}, null);
                            if (query != null) {
                                if (query.moveToFirst()) {
                                    columnIndex = query.getInt(query.getColumnIndex("has_phone_number"));
                                    if (query == null) {
                                        query.close();
                                        cursor = query;
                                    } else {
                                        cursor = query;
                                    }
                                    x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                                    if (columnIndex > 0) {
                                        cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                        do {
                                            str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                            if (!bi.oN(str3)) {
                                                x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                                break;
                                            }
                                        } while (cursor.moveToNext());
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                    }
                                }
                            }
                            columnIndex = 0;
                            if (query == null) {
                                cursor = query;
                            } else {
                                query.close();
                                cursor = query;
                            }
                            x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                            if (columnIndex > 0) {
                                cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                do {
                                    str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                    if (!bi.oN(str3)) {
                                        x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                        break;
                                    }
                                } while (cursor.moveToNext());
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                    if (bi.oN(str3)) {
                        networkCountryIso = ap.fw(str3, str2);
                        x.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                        if (bi.oN(networkCountryIso)) {
                            if (str3.startsWith("+")) {
                                networkCountryIso = "+" + networkCountryIso;
                            } else if (str3.startsWith(networkCountryIso)) {
                                networkCountryIso = null;
                            }
                            if (networkCountryIso != null) {
                                str3 = str3.substring(networkCountryIso.length());
                            }
                        }
                        x.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
                    }
                    return str3;
                } else {
                    x.e("MicroMsg.ContactsUtil", "no contact permission");
                    return null;
                }
            }
        } catch (Throwable e3222) {
            th2 = e3222;
            networkCountryIso = str5;
            e = th2;
        }
        if (bi.oN(networkCountryIso)) {
            str4 = networkCountryIso.trim();
            networkCountryIso = ap.fw(str4, str2);
            x.i("MicroMsg.ContactsUtil", "get num : %s, extract country code  : %s, iso : %s", str4, networkCountryIso, str2);
            if (bi.oN(networkCountryIso)) {
                if (str4.startsWith("+")) {
                }
                networkCountryIso = str4.substring((str4.startsWith("+") ? 1 : 0) + networkCountryIso.length());
                x.i("MicroMsg.ContactsUtil", "after deal, the num is %s", networkCountryIso);
            } else {
                networkCountryIso = str4;
            }
            x.i("MicroMsg.ContactsUtil", "Got phone number by TelephonyManager.");
            return networkCountryIso;
        } else if (a.aZ(context, "android.permission.READ_CONTACTS")) {
            x.e("MicroMsg.ContactsUtil", "no contact permission");
            return null;
        } else {
            contentResolver = context.getContentResolver();
            cursor = null;
            str3 = null;
            if (f.fO(14)) {
                x.i("MicroMsg.ContactsUtil", "The device os API version is higher than 14.");
                cursor = contentResolver.query(Profile.CONTENT_URI, new String[]{"has_phone_number"}, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    columnIndex = cursor.getColumnIndex("has_phone_number");
                    if (columnIndex != -1) {
                        i = cursor.getInt(columnIndex);
                        x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                        if (!(cursor == null || cursor.isClosed())) {
                            cursor.close();
                        }
                        if (i > 0) {
                            query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, SlookAirButtonFrequentContactAdapter.DATA), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                            if (query == null) {
                                if (query.moveToFirst()) {
                                    columnIndex = query.getColumnIndex("data1");
                                    if (columnIndex != -1) {
                                        str3 = query.getString(columnIndex);
                                        x.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", str3);
                                    }
                                }
                                query.close();
                                str4 = str3;
                            } else {
                                str4 = null;
                            }
                            if (!(query == null || query.isClosed())) {
                                query.close();
                                str3 = str4;
                                cursor = query;
                            }
                            str3 = str4;
                            cursor = query;
                        }
                    }
                }
                i = 0;
                x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + i);
                cursor.close();
                if (i > 0) {
                    query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, SlookAirButtonFrequentContactAdapter.DATA), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                    if (query == null) {
                        str4 = null;
                    } else {
                        if (query.moveToFirst()) {
                            columnIndex = query.getColumnIndex("data1");
                            if (columnIndex != -1) {
                                str3 = query.getString(columnIndex);
                                x.i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", str3);
                            }
                        }
                        query.close();
                        str4 = str3;
                    }
                    query.close();
                    str3 = str4;
                    cursor = query;
                }
            }
            if (bi.oN(str3)) {
                if (bi.oN(A(context, d.bx(context)))) {
                    query = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{A(context, d.bx(context))}, null);
                    if (query != null) {
                        if (query.moveToFirst()) {
                            columnIndex = query.getInt(query.getColumnIndex("has_phone_number"));
                            if (query == null) {
                                query.close();
                                cursor = query;
                            } else {
                                cursor = query;
                            }
                            x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                            if (columnIndex > 0) {
                                cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                if (cursor != null && cursor.moveToFirst()) {
                                    do {
                                        str3 = cursor.getString(cursor.getColumnIndex("data1"));
                                        if (!bi.oN(str3)) {
                                            x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                            break;
                                        }
                                    } while (cursor.moveToNext());
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                    columnIndex = 0;
                    if (query == null) {
                        cursor = query;
                    } else {
                        query.close();
                        cursor = query;
                    }
                    x.i("MicroMsg.ContactsUtil", "The phone count of the profile is " + columnIndex);
                    if (columnIndex > 0) {
                        cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                        do {
                            str3 = cursor.getString(cursor.getColumnIndex("data1"));
                            if (!bi.oN(str3)) {
                                x.i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str3);
                                break;
                            }
                        } while (cursor.moveToNext());
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (bi.oN(str3)) {
                networkCountryIso = ap.fw(str3, str2);
                x.i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str3, networkCountryIso, str2);
                if (bi.oN(networkCountryIso)) {
                    if (str3.startsWith("+")) {
                        networkCountryIso = "+" + networkCountryIso;
                    } else if (str3.startsWith(networkCountryIso)) {
                        networkCountryIso = null;
                    }
                    if (networkCountryIso != null) {
                        str3 = str3.substring(networkCountryIso.length());
                    }
                }
                x.i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str3);
            }
            return str3;
        }
    }

    private static String A(Context context, String str) {
        String str2;
        Throwable e;
        String str3 = null;
        x.i("MicroMsg.ContactsUtil", "Get contactId by email, email = %s", str);
        if (context == null) {
            x.e("MicroMsg.ContactsUtil", "context is null.");
            return null;
        } else if (bi.oN(str)) {
            x.i("MicroMsg.ContactsUtil", "email is null.");
            return null;
        } else {
            try {
                Cursor query = context.getContentResolver().query(Email.CONTENT_URI, new String[]{"contact_id", "data1"}, "data1=?", new String[]{str}, null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        do {
                            try {
                                str3 = query.getString(query.getColumnIndex("contact_id"));
                                if (!bi.oN(str3)) {
                                    x.i("MicroMsg.ContactsUtil", "Have got contactId ,contactId is [%s]", str3);
                                    str2 = str3;
                                    break;
                                }
                            } catch (Throwable e2) {
                                e = e2;
                                str2 = str3;
                            }
                        } while (query.moveToNext());
                        str2 = str3;
                    } else {
                        str2 = null;
                    }
                    try {
                        query.close();
                    } catch (Exception e3) {
                        e = e3;
                        x.printErrStackTrace("MicroMsg.ContactsUtil", e, "getContactIdByEmail error", new Object[0]);
                        return str2;
                    }
                }
                str2 = null;
            } catch (Throwable e22) {
                e = e22;
                str2 = null;
                x.printErrStackTrace("MicroMsg.ContactsUtil", e, "getContactIdByEmail error", new Object[0]);
                return str2;
            }
            return str2;
        }
    }

    @TargetApi(14)
    public static String bo(Context context) {
        x.i("MicroMsg.ContactsUtil", "Get name of a contacts record or profile.");
        if (context == null) {
            x.e("MicroMsg.ContactsUtil", "context is null.");
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (a.aZ(context, "android.permission.READ_CONTACTS")) {
            String str;
            Cursor query;
            if (f.fN(14)) {
                Cursor query2;
                x.i("MicroMsg.ContactsUtil", "The Android API version is higher than 14.");
                try {
                    query2 = contentResolver.query(Profile.CONTENT_URI, new String[]{SlookAirButtonFrequentContactAdapter.DISPLAY_NAME}, null, null, null);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ContactsUtil", e, "", new Object[0]);
                    x.d("MicroMsg.ContactsUtil", "query crashed");
                    query2 = null;
                }
                if (query2 != null) {
                    String string;
                    if (query2.moveToFirst()) {
                        string = query2.getString(query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                        x.i("MicroMsg.ContactsUtil", "Have got name from profile, name is %s", string);
                    } else {
                        string = null;
                    }
                    query2.close();
                    str = string;
                    if (bi.oN(str)) {
                        if (bi.oN(A(context, d.bx(context)))) {
                            query = contentResolver.query(Data.CONTENT_URI, new String[]{SlookAirButtonFrequentContactAdapter.DISPLAY_NAME}, "contact_id=?", new String[]{r5}, null);
                            if (query != null) {
                                if (query.moveToFirst()) {
                                    str = query.getString(query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                                    x.i("MicroMsg.ContactsUtil", "Have got name from contacts, name is %s", str);
                                }
                                query.close();
                            }
                        } else {
                            x.i("MicroMsg.ContactsUtil", "contactId is null.");
                            return null;
                        }
                    }
                    return str;
                }
            }
            str = null;
            if (bi.oN(str)) {
                if (bi.oN(A(context, d.bx(context)))) {
                    query = contentResolver.query(Data.CONTENT_URI, new String[]{SlookAirButtonFrequentContactAdapter.DISPLAY_NAME}, "contact_id=?", new String[]{r5}, null);
                    if (query != null) {
                        if (query.moveToFirst()) {
                            str = query.getString(query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                            x.i("MicroMsg.ContactsUtil", "Have got name from contacts, name is %s", str);
                        }
                        query.close();
                    }
                } else {
                    x.i("MicroMsg.ContactsUtil", "contactId is null.");
                    return null;
                }
            }
            return str;
        }
        x.e("MicroMsg.ContactsUtil", "no contact permission");
        return null;
    }

    @TargetApi(14)
    public static Bitmap bp(Context context) {
        x.i("MicroMsg.ContactsUtil", "Get bitmap of a contacts record or profile.");
        if (context == null) {
            x.e("MicroMsg.ContactsUtil", "context is null.");
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Bitmap bitmap = null;
        if (a.aZ(context, "android.permission.READ_CONTACTS")) {
            int lastIndexOf;
            Bitmap my;
            Cursor cursor = null;
            if (f.fN(14)) {
                x.i("MicroMsg.ContactsUtil", "The Android API version is higher than 14.");
                try {
                    cursor = contentResolver.query(Profile.CONTENT_URI, new String[]{"_id"}, null, null, null);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ContactsUtil", e, "", new Object[0]);
                    x.d("MicroMsg.ContactsUtil", "query crashed");
                }
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Cursor query;
                        cursor.close();
                        try {
                            query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, SlookAirButtonFrequentContactAdapter.DATA), new String[]{"data15", "data_sync1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/photo"}, null);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.ContactsUtil", e2, "", new Object[0]);
                            x.d("MicroMsg.ContactsUtil", "query crashed");
                            query = cursor;
                        }
                        if (query != null) {
                            if (query.moveToFirst()) {
                                byte[] blob;
                                if (ao.isWifi(context) || ao.is3G(context) || ao.is4G(context)) {
                                    x.i("MicroMsg.ContactsUtil", "The network status is wifi or 3G or 4G.");
                                    String string = query.getString(query.getColumnIndex("data_sync1"));
                                    x.i("MicroMsg.ContactsUtil", "get sync avatar url : [%s]", string);
                                    if (!bi.oN(string)) {
                                        lastIndexOf = string.lastIndexOf("https:");
                                        x.i("MicroMsg.ContactsUtil", "check is exist https download url :[%d]", Integer.valueOf(lastIndexOf));
                                        if (lastIndexOf >= 0) {
                                            my = my(string.substring(lastIndexOf));
                                            x.i("MicroMsg.ContactsUtil", "Get image from google sync account in profile,url:[%s]", r3);
                                            if (!(my == null || my.isRecycled())) {
                                                query.close();
                                                return my;
                                            }
                                            lastIndexOf = query.getColumnIndex("data15");
                                            if (lastIndexOf != -1) {
                                                blob = query.getBlob(lastIndexOf);
                                                x.i("MicroMsg.ContactsUtil", "get bitmap data is null : [%b]", Boolean.valueOf(bi.by(blob)));
                                                if (!bi.by(blob)) {
                                                    x.i("MicroMsg.ContactsUtil", "Get image from profile personal icon.");
                                                    my = BitmapFactory.decodeByteArray(blob, 0, blob.length);
                                                }
                                            }
                                        }
                                    }
                                }
                                my = null;
                                lastIndexOf = query.getColumnIndex("data15");
                                if (lastIndexOf != -1) {
                                    blob = query.getBlob(lastIndexOf);
                                    x.i("MicroMsg.ContactsUtil", "get bitmap data is null : [%b]", Boolean.valueOf(bi.by(blob)));
                                    if (bi.by(blob)) {
                                        x.i("MicroMsg.ContactsUtil", "Get image from profile personal icon.");
                                        my = BitmapFactory.decodeByteArray(blob, 0, blob.length);
                                    }
                                }
                            } else {
                                my = null;
                            }
                            query.close();
                            bitmap = my;
                        }
                    } else {
                        cursor.close();
                    }
                }
            }
            if (bitmap == null || bitmap.isRecycled()) {
                String A = A(context, d.bx(context));
                if (bi.oN(A)) {
                    x.i("MicroMsg.ContactsUtil", "contactId is null.");
                    return null;
                }
                Cursor query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"photo_id", "raw_contact_id"}, "contact_id=?", new String[]{A}, null);
                if (query2 != null) {
                    if (query2.moveToFirst()) {
                        while (true) {
                            long j;
                            if (ao.isWifi(context) || ao.is3G(context) || ao.is4G(context)) {
                                x.i("MicroMsg.ContactsUtil", "The network status is wifi or 3G or 4G.");
                                String string2 = query2.getString(query2.getColumnIndex("raw_contact_id"));
                                Cursor query3 = contentResolver.query(Data.CONTENT_URI, new String[]{"data15", "data_sync1"}, "mimetype=? AND raw_contact_id=?", new String[]{"vnd.android.cursor.item/photo", string2}, null);
                                if (query3 != null) {
                                    if (query3.moveToFirst()) {
                                        int columnIndex = query3.getColumnIndex("data_sync1");
                                        if (columnIndex != -1) {
                                            String string3 = query3.getString(columnIndex);
                                            if (!bi.oN(string3)) {
                                                lastIndexOf = string3.lastIndexOf("https:");
                                                if (lastIndexOf >= 0) {
                                                    bitmap = my(string3.substring(lastIndexOf));
                                                    if (!(bitmap == null || bitmap.isRecycled())) {
                                                        x.i("MicroMsg.ContactsUtil", "Get image from google sync account in contacts,url:[%s]", string3);
                                                        query3.close();
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    query3.close();
                                }
                            }
                            x.i("MicroMsg.ContactsUtil", "Get bitmap from contacts icon.");
                            int columnIndex2 = query2.getColumnIndex("photo_id");
                            if (columnIndex2 != -1) {
                                j = query2.getLong(columnIndex2);
                                x.i("MicroMsg.ContactsUtil", "Have got photoId,photoId is " + j);
                            } else {
                                j = 0;
                            }
                            if (j > 0) {
                                my = BitmapFactory.decodeStream(Contacts.openContactPhotoInputStream(contentResolver, ContentUris.withAppendedId(Contacts.CONTENT_URI, bi.getLong(A, 0))));
                                if (!(my == null || my.isRecycled())) {
                                    x.i("MicroMsg.ContactsUtil", "Get image from contacts through google account.");
                                    bitmap = my;
                                    break;
                                }
                            }
                            my = bitmap;
                            if (!query2.moveToNext()) {
                                bitmap = my;
                                break;
                            }
                            bitmap = my;
                        }
                    }
                    query2.close();
                }
            }
            return bitmap;
        }
        x.e("MicroMsg.ContactsUtil", "no contact permission");
        return null;
    }

    private static Bitmap my(String str) {
        Throwable e;
        Throwable th;
        Bitmap bitmap = null;
        x.i("MicroMsg.ContactsUtil", "Get bitmap by HTTPS request. url = %s", str);
        if (bi.oN(str)) {
            x.e("MicroMsg.ContactsUtil", "url is null or nil.");
        } else {
            String trim = str.trim();
            if (trim.startsWith("https:")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                v ol;
                InputStream inputStream;
                try {
                    ol = b.ol(trim);
                    try {
                        inputStream = ol.ick.getInputStream();
                        if (inputStream == null) {
                            try {
                                x.e("MicroMsg.ContactsUtil", "getInputStream failed. url:%s", trim);
                                try {
                                    ol.ick.disconnect();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    byteArrayOutputStream.close();
                                } catch (Throwable e2) {
                                    x.e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e2.getMessage());
                                    x.printErrStackTrace("MicroMsg.ContactsUtil", e2, "", new Object[0]);
                                }
                            } catch (IOException e3) {
                                e2 = e3;
                                try {
                                    x.e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, IOException : %s", e2.getMessage());
                                    x.printErrStackTrace("MicroMsg.ContactsUtil", e2, "", new Object[0]);
                                    if (ol != null) {
                                        try {
                                            ol.ick.disconnect();
                                        } catch (Throwable e22) {
                                            x.e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e22.getMessage());
                                            x.printErrStackTrace("MicroMsg.ContactsUtil", e22, "", new Object[0]);
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    byteArrayOutputStream.close();
                                    return bitmap;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (ol != null) {
                                        try {
                                            ol.ick.disconnect();
                                        } catch (Throwable e222) {
                                            x.e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e222.getMessage());
                                            x.printErrStackTrace("MicroMsg.ContactsUtil", e222, "", new Object[0]);
                                            throw th;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    byteArrayOutputStream.close();
                                    throw th;
                                }
                            } catch (Exception e4) {
                                e222 = e4;
                                x.e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, Exception : %s", e222.getMessage());
                                x.printErrStackTrace("MicroMsg.ContactsUtil", e222, "", new Object[0]);
                                if (ol != null) {
                                    try {
                                        ol.ick.disconnect();
                                    } catch (Throwable e2222) {
                                        x.e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e2222.getMessage());
                                        x.printErrStackTrace("MicroMsg.ContactsUtil", e2222, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                byteArrayOutputStream.close();
                                return bitmap;
                            }
                        }
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        bitmap = d.bn(byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.close();
                        try {
                            ol.ick.disconnect();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (Throwable e22222) {
                            x.e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e22222.getMessage());
                            x.printErrStackTrace("MicroMsg.ContactsUtil", e22222, "", new Object[0]);
                        }
                    } catch (IOException e5) {
                        e22222 = e5;
                        inputStream = null;
                    } catch (Exception e6) {
                        e22222 = e6;
                        inputStream = null;
                        x.e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, Exception : %s", e22222.getMessage());
                        x.printErrStackTrace("MicroMsg.ContactsUtil", e22222, "", new Object[0]);
                        if (ol != null) {
                            ol.ick.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        byteArrayOutputStream.close();
                        return bitmap;
                    } catch (Throwable e222222) {
                        inputStream = null;
                        th = e222222;
                        if (ol != null) {
                            ol.ick.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e7) {
                    e222222 = e7;
                    ol = null;
                    inputStream = null;
                } catch (Exception e8) {
                    e222222 = e8;
                    ol = null;
                    inputStream = null;
                    x.e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, Exception : %s", e222222.getMessage());
                    x.printErrStackTrace("MicroMsg.ContactsUtil", e222222, "", new Object[0]);
                    if (ol != null) {
                        ol.ick.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    byteArrayOutputStream.close();
                    return bitmap;
                } catch (Throwable e2222222) {
                    ol = null;
                    inputStream = null;
                    th = e2222222;
                    if (ol != null) {
                        ol.ick.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
            x.e("MicroMsg.ContactsUtil", "this is not the correct https url.");
        }
        return bitmap;
    }
}
