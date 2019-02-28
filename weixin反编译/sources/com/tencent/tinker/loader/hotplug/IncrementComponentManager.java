package com.tencent.tinker.loader.hotplug;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class IncrementComponentManager {
    private static final Map<String, ActivityInfo> Atn = new HashMap();
    private static final Map<String, IntentFilter> Ato = new HashMap();
    private static final AttrTranslator<ActivityInfo> Atp = new AttrTranslator<ActivityInfo>() {
        final /* synthetic */ void a(Context context, String str, String str2, Object obj) {
            int i = 0;
            ActivityInfo activityInfo = (ActivityInfo) obj;
            if ("name".equals(str)) {
                if (str2.charAt(i) == '.') {
                    activityInfo.name = context.getPackageName() + str2;
                } else {
                    activityInfo.name = str2;
                }
            } else if ("parentActivityName".equals(str)) {
                if (VERSION.SDK_INT < 16) {
                    return;
                }
                if (str2.charAt(i) == '.') {
                    activityInfo.parentActivityName = context.getPackageName() + str2;
                } else {
                    activityInfo.parentActivityName = str2;
                }
            } else if ("exported".equals(str)) {
                activityInfo.exported = "true".equalsIgnoreCase(str2);
            } else if ("launchMode".equals(str)) {
                if (!"standard".equalsIgnoreCase(str2)) {
                    if ("singleTop".equalsIgnoreCase(str2)) {
                        i = 1;
                    } else if ("singleTask".equalsIgnoreCase(str2)) {
                        i = 2;
                    } else if ("singleInstance".equalsIgnoreCase(str2)) {
                        i = 3;
                    }
                }
                activityInfo.launchMode = i;
            } else if ("theme".equals(str)) {
                activityInfo.theme = context.getResources().getIdentifier(str2, "style", context.getPackageName());
            } else if ("uiOptions".equals(str)) {
                if (VERSION.SDK_INT >= 14) {
                    activityInfo.uiOptions = Integer.decode(str2).intValue();
                }
            } else if ("permission".equals(str)) {
                activityInfo.permission = str2;
            } else if ("taskAffinity".equals(str)) {
                activityInfo.taskAffinity = str2;
            } else if ("multiprocess".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 1;
                } else {
                    activityInfo.flags &= -2;
                }
            } else if ("finishOnTaskLaunch".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 2;
                } else {
                    activityInfo.flags &= -3;
                }
            } else if ("clearTaskOnLaunch".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 4;
                } else {
                    activityInfo.flags &= -5;
                }
            } else if ("noHistory".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= FileUtils.S_IWUSR;
                } else {
                    activityInfo.flags &= -129;
                }
            } else if ("alwaysRetainTaskState".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 8;
                } else {
                    activityInfo.flags &= -9;
                }
            } else if ("stateNotNeeded".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 16;
                } else {
                    activityInfo.flags &= -17;
                }
            } else if ("excludeFromRecents".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 32;
                } else {
                    activityInfo.flags &= -33;
                }
            } else if ("allowTaskReparenting".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 64;
                } else {
                    activityInfo.flags &= -65;
                }
            } else if ("finishOnCloseSystemDialogs".equals(str)) {
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 256;
                } else {
                    activityInfo.flags &= -257;
                }
            } else if ("showOnLockScreen".equals(str) || "showForAllUsers".equals(str)) {
                if (VERSION.SDK_INT >= 23) {
                    i = ShareReflectUtil.e(ActivityInfo.class, "FLAG_SHOW_FOR_ALL_USERS");
                    if ("true".equalsIgnoreCase(str2)) {
                        activityInfo.flags = i | activityInfo.flags;
                        return;
                    }
                    activityInfo.flags = (i ^ -1) & activityInfo.flags;
                }
            } else if ("immersive".equals(str)) {
                if (VERSION.SDK_INT < 18) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 2048;
                } else {
                    activityInfo.flags &= -2049;
                }
            } else if ("hardwareAccelerated".equals(str)) {
                if (VERSION.SDK_INT < 11) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= WXMediaMessage.TITLE_LENGTH_LIMIT;
                } else {
                    activityInfo.flags &= -513;
                }
            } else if ("documentLaunchMode".equals(str)) {
                if (VERSION.SDK_INT >= 21) {
                    activityInfo.documentLaunchMode = Integer.decode(str2).intValue();
                }
            } else if ("maxRecents".equals(str)) {
                if (VERSION.SDK_INT >= 21) {
                    activityInfo.maxRecents = Integer.decode(str2).intValue();
                }
            } else if ("configChanges".equals(str)) {
                activityInfo.configChanges = Integer.decode(str2).intValue();
            } else if ("windowSoftInputMode".equals(str)) {
                activityInfo.softInputMode = Integer.decode(str2).intValue();
            } else if ("persistableMode".equals(str)) {
                if (VERSION.SDK_INT >= 21) {
                    activityInfo.persistableMode = Integer.decode(str2).intValue();
                }
            } else if ("allowEmbedded".equals(str)) {
                i = ShareReflectUtil.e(ActivityInfo.class, "FLAG_ALLOW_EMBEDDED");
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags = i | activityInfo.flags;
                    return;
                }
                activityInfo.flags = (i ^ -1) & activityInfo.flags;
            } else if ("autoRemoveFromRecents".equals(str)) {
                if (VERSION.SDK_INT < 21) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 8192;
                } else {
                    activityInfo.flags &= -8193;
                }
            } else if ("relinquishTaskIdentity".equals(str)) {
                if (VERSION.SDK_INT < 21) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= Downloads.RECV_BUFFER_SIZE;
                } else {
                    activityInfo.flags &= -4097;
                }
            } else if ("resumeWhilePausing".equals(str)) {
                if (VERSION.SDK_INT < 21) {
                    return;
                }
                if ("true".equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 16384;
                } else {
                    activityInfo.flags &= -16385;
                }
            } else if ("screenOrientation".equals(str)) {
                if (!"unspecified".equalsIgnoreCase(str2)) {
                    if ("behind".equalsIgnoreCase(str2)) {
                        i = 3;
                    } else if (!"landscape".equalsIgnoreCase(str2)) {
                        if ("portrait".equalsIgnoreCase(str2)) {
                            i = 1;
                        } else if ("reverseLandscape".equalsIgnoreCase(str2)) {
                            i = 8;
                        } else if ("reversePortrait".equalsIgnoreCase(str2)) {
                            i = 9;
                        } else if ("sensorLandscape".equalsIgnoreCase(str2)) {
                            i = 6;
                        } else if ("sensorPortrait".equalsIgnoreCase(str2)) {
                            i = 7;
                        } else if ("sensor".equalsIgnoreCase(str2)) {
                            i = 4;
                        } else if ("fullSensor".equalsIgnoreCase(str2)) {
                            i = 10;
                        } else if ("nosensor".equalsIgnoreCase(str2)) {
                            i = 5;
                        } else if ("user".equalsIgnoreCase(str2)) {
                            i = 2;
                        } else if (VERSION.SDK_INT >= 18 && "fullUser".equalsIgnoreCase(str2)) {
                            i = 13;
                        } else if (VERSION.SDK_INT >= 18 && "locked".equalsIgnoreCase(str2)) {
                            i = 14;
                        } else if (VERSION.SDK_INT >= 18 && "userLandscape".equalsIgnoreCase(str2)) {
                            i = 11;
                        } else if (VERSION.SDK_INT >= 18 && "userPortrait".equalsIgnoreCase(str2)) {
                            i = 12;
                        }
                    }
                    activityInfo.screenOrientation = i;
                }
                i = -1;
                activityInfo.screenOrientation = i;
            } else if ("label".equals(str)) {
                try {
                    i = context.getResources().getIdentifier(str2, "string", IncrementComponentManager.xLm);
                } catch (Throwable th) {
                }
                if (i != 0) {
                    activityInfo.labelRes = i;
                } else {
                    activityInfo.nonLocalizedLabel = str2;
                }
            } else if ("icon".equals(str)) {
                try {
                    activityInfo.icon = context.getResources().getIdentifier(str2, null, IncrementComponentManager.xLm);
                } catch (Throwable th2) {
                }
            } else if ("banner".equals(str)) {
                if (VERSION.SDK_INT >= 20) {
                    try {
                        activityInfo.banner = context.getResources().getIdentifier(str2, null, IncrementComponentManager.xLm);
                    } catch (Throwable th3) {
                    }
                }
            } else if ("logo".equals(str)) {
                try {
                    activityInfo.logo = context.getResources().getIdentifier(str2, null, IncrementComponentManager.xLm);
                } catch (Throwable th4) {
                }
            }
        }

        final void a(int i, XmlPullParser xmlPullParser) {
            try {
                if (xmlPullParser.getEventType() != 2 || !"activity".equals(xmlPullParser.getName())) {
                    throw new IllegalStateException("unexpected xml parser state when parsing incremental component manifest.");
                }
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    };
    private static Context gOj = null;
    private static volatile boolean gQM = false;
    private static String xLm = null;

    private static abstract class AttrTranslator<T_RESULT> {
        abstract void a(Context context, String str, String str2, T_RESULT t_result);

        private AttrTranslator() {
        }

        /* synthetic */ AttrTranslator(byte b) {
            this();
        }

        final void a(Context context, XmlPullParser xmlPullParser, T_RESULT t_result) {
            int i = 0;
            a(0, xmlPullParser);
            int attributeCount = xmlPullParser.getAttributeCount();
            while (i < attributeCount) {
                if ("android".equals(xmlPullParser.getAttributePrefix(i))) {
                    a(context, xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i), t_result);
                }
                i++;
            }
        }

        void a(int i, XmlPullParser xmlPullParser) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r9, com.tencent.tinker.loader.shareutil.ShareSecurityCheck r10) {
        /*
        r4 = 0;
        r3 = 1;
        r5 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.class;
        monitor-enter(r5);
        r1 = r10.Avd;	 Catch:{ all -> 0x007d }
        r2 = "assets/inc_component_meta.txt";
        r1 = r1.containsKey(r2);	 Catch:{ all -> 0x007d }
        if (r1 != 0) goto L_0x00b1;
    L_0x0010:
        r1 = 0;
    L_0x0011:
        monitor-exit(r5);
        return r1;
    L_0x0013:
        r1 = r2 instanceof android.content.ContextWrapper;	 Catch:{ all -> 0x007d }
        if (r1 == 0) goto L_0x0023;
    L_0x0017:
        r0 = r2;
        r0 = (android.content.ContextWrapper) r0;	 Catch:{ all -> 0x007d }
        r1 = r0;
        r9 = r1.getBaseContext();	 Catch:{ all -> 0x007d }
        if (r9 == 0) goto L_0x0023;
    L_0x0021:
        r2 = r9;
        goto L_0x0013;
    L_0x0023:
        gOj = r2;	 Catch:{ all -> 0x007d }
        r1 = r2.getPackageName();	 Catch:{ all -> 0x007d }
        xLm = r1;	 Catch:{ all -> 0x007d }
        r1 = r10.Avd;	 Catch:{ all -> 0x007d }
        r6 = "assets/inc_component_meta.txt";
        r1 = r1.get(r6);	 Catch:{ all -> 0x007d }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x007d }
        r6 = new java.io.StringReader;	 Catch:{ all -> 0x007d }
        r6.<init>(r1);	 Catch:{ all -> 0x007d }
        r4 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x00ae, all -> 0x0099 }
        r4.setInput(r6);	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        r1 = r4.getEventType();	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
    L_0x0046:
        if (r1 == r3) goto L_0x009b;
    L_0x0048:
        switch(r1) {
            case 2: goto L_0x0050;
            default: goto L_0x004b;
        };	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
    L_0x004b:
        r1 = r4.next();	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        goto L_0x0046;
    L_0x0050:
        r1 = r4.getName();	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        r7 = "activity";
        r7 = r7.equalsIgnoreCase(r1);	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        if (r7 == 0) goto L_0x0080;
    L_0x005d:
        r1 = a(r2, r4);	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        r7 = Atn;	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        r8 = r1.name;	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        r7.put(r8, r1);	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        goto L_0x004b;
    L_0x0069:
        r1 = move-exception;
        r2 = r4;
    L_0x006b:
        r3 = new java.io.IOException;	 Catch:{ all -> 0x0071 }
        r3.<init>(r1);	 Catch:{ all -> 0x0071 }
        throw r3;	 Catch:{ all -> 0x0071 }
    L_0x0071:
        r1 = move-exception;
        r4 = r2;
    L_0x0073:
        if (r4 == 0) goto L_0x0079;
    L_0x0075:
        r2 = 0;
        r4.setInput(r2);	 Catch:{ Throwable -> 0x00ac }
    L_0x0079:
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.cA(r6);	 Catch:{ all -> 0x007d }
        throw r1;	 Catch:{ all -> 0x007d }
    L_0x007d:
        r1 = move-exception;
        monitor-exit(r5);
        throw r1;
    L_0x0080:
        r7 = "service";
        r7 = r7.equalsIgnoreCase(r1);	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        if (r7 != 0) goto L_0x004b;
    L_0x0089:
        r7 = "receiver";
        r7 = r7.equalsIgnoreCase(r1);	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        if (r7 != 0) goto L_0x004b;
    L_0x0092:
        r7 = "provider";
        r7.equalsIgnoreCase(r1);	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        goto L_0x004b;
    L_0x0099:
        r1 = move-exception;
        goto L_0x0073;
    L_0x009b:
        r1 = 1;
        gQM = r1;	 Catch:{ XmlPullParserException -> 0x0069, all -> 0x0099 }
        if (r4 == 0) goto L_0x00a4;
    L_0x00a0:
        r1 = 0;
        r4.setInput(r1);	 Catch:{ Throwable -> 0x00aa }
    L_0x00a4:
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.cA(r6);	 Catch:{ all -> 0x007d }
        r1 = r3;
        goto L_0x0011;
    L_0x00aa:
        r1 = move-exception;
        goto L_0x00a4;
    L_0x00ac:
        r2 = move-exception;
        goto L_0x0079;
    L_0x00ae:
        r1 = move-exception;
        r2 = r4;
        goto L_0x006b;
    L_0x00b1:
        r2 = r9;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.IncrementComponentManager.a(android.content.Context, com.tencent.tinker.loader.shareutil.ShareSecurityCheck):boolean");
    }

    private static synchronized ActivityInfo a(Context context, XmlPullParser xmlPullParser) {
        ActivityInfo activityInfo;
        synchronized (IncrementComponentManager.class) {
            activityInfo = new ActivityInfo();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            activityInfo.applicationInfo = applicationInfo;
            activityInfo.packageName = xLm;
            activityInfo.processName = applicationInfo.processName;
            activityInfo.launchMode = 0;
            activityInfo.permission = applicationInfo.permission;
            activityInfo.screenOrientation = -1;
            activityInfo.taskAffinity = applicationInfo.taskAffinity;
            if (VERSION.SDK_INT >= 11 && (applicationInfo.flags & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
                activityInfo.flags |= WXMediaMessage.TITLE_LENGTH_LIMIT;
            }
            if (VERSION.SDK_INT >= 21) {
                activityInfo.documentLaunchMode = 0;
            }
            if (VERSION.SDK_INT >= 14) {
                activityInfo.uiOptions = applicationInfo.uiOptions;
            }
            Atp.a(context, xmlPullParser, activityInfo);
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                } else if (!(next == 3 || next == 4)) {
                    String name = xmlPullParser.getName();
                    if ("intent-filter".equalsIgnoreCase(name)) {
                        a(activityInfo.name, xmlPullParser);
                    } else if ("meta-data".equalsIgnoreCase(name)) {
                        a(activityInfo, xmlPullParser);
                    }
                }
            }
        }
        return activityInfo;
    }

    private static synchronized void a(String str, XmlPullParser xmlPullParser) {
        synchronized (IncrementComponentManager.class) {
            IntentFilter intentFilter = new IntentFilter();
            Object attributeValue = xmlPullParser.getAttributeValue(null, DownloadInfo.PRIORITY);
            if (!TextUtils.isEmpty(attributeValue)) {
                intentFilter.setPriority(Integer.decode(attributeValue).intValue());
            }
            if (!TextUtils.isEmpty(xmlPullParser.getAttributeValue(null, "autoVerify"))) {
                try {
                    ShareReflectUtil.c(IntentFilter.class, "setAutoVerify", Boolean.TYPE).invoke(intentFilter, new Object[]{Boolean.valueOf("true".equalsIgnoreCase(attributeValue))});
                } catch (Throwable th) {
                }
            }
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                    Ato.put(str, intentFilter);
                } else if (!(next == 3 || next == 4)) {
                    String name = xmlPullParser.getName();
                    if ("action".equals(name)) {
                        name = xmlPullParser.getAttributeValue(null, "name");
                        if (name != null) {
                            intentFilter.addAction(name);
                        }
                    } else if ("category".equals(name)) {
                        name = xmlPullParser.getAttributeValue(null, "name");
                        if (name != null) {
                            intentFilter.addCategory(name);
                        }
                    } else if (SlookAirButtonFrequentContactAdapter.DATA.equals(name)) {
                        name = xmlPullParser.getAttributeValue(null, "mimeType");
                        if (name != null) {
                            try {
                                intentFilter.addDataType(name);
                            } catch (Throwable e) {
                                throw new XmlPullParserException("bad mimeType", xmlPullParser, e);
                            }
                        }
                        name = xmlPullParser.getAttributeValue(null, "scheme");
                        if (name != null) {
                            intentFilter.addDataScheme(name);
                        }
                        if (VERSION.SDK_INT >= 19) {
                            name = xmlPullParser.getAttributeValue(null, "ssp");
                            if (name != null) {
                                intentFilter.addDataSchemeSpecificPart(name, 0);
                            }
                            name = xmlPullParser.getAttributeValue(null, "sspPrefix");
                            if (name != null) {
                                intentFilter.addDataSchemeSpecificPart(name, 1);
                            }
                            name = xmlPullParser.getAttributeValue(null, "sspPattern");
                            if (name != null) {
                                intentFilter.addDataSchemeSpecificPart(name, 2);
                            }
                        }
                        name = xmlPullParser.getAttributeValue(null, "host");
                        String attributeValue2 = xmlPullParser.getAttributeValue(null, "port");
                        if (name != null) {
                            intentFilter.addDataAuthority(name, attributeValue2);
                        }
                        name = xmlPullParser.getAttributeValue(null, "path");
                        if (name != null) {
                            intentFilter.addDataPath(name, 0);
                        }
                        name = xmlPullParser.getAttributeValue(null, "pathPrefix");
                        if (name != null) {
                            intentFilter.addDataPath(name, 1);
                        }
                        name = xmlPullParser.getAttributeValue(null, "pathPattern");
                        if (name != null) {
                            intentFilter.addDataPath(name, 2);
                        }
                    }
                    d(xmlPullParser);
                }
            }
            Ato.put(str, intentFilter);
        }
    }

    private static synchronized void a(ActivityInfo activityInfo, XmlPullParser xmlPullParser) {
        synchronized (IncrementComponentManager.class) {
            ClassLoader classLoader = IncrementComponentManager.class.getClassLoader();
            Object attributeValue = xmlPullParser.getAttributeValue(null, "name");
            String attributeValue2 = xmlPullParser.getAttributeValue(null, Columns.VALUE);
            if (!TextUtils.isEmpty(attributeValue)) {
                if (activityInfo.metaData == null) {
                    activityInfo.metaData = new Bundle(classLoader);
                }
                activityInfo.metaData.putString(attributeValue, attributeValue2);
            }
        }
    }

    private static void d(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    private static synchronized void Es() {
        synchronized (IncrementComponentManager.class) {
            if (gQM) {
            } else {
                throw new IllegalStateException("Not initialized!!");
            }
        }
    }

    public static boolean acp(String str) {
        Es();
        return str != null && Atn.containsKey(str);
    }

    public static ActivityInfo acq(String str) {
        Es();
        return str != null ? (ActivityInfo) Atn.get(str) : null;
    }

    public static ResolveInfo ap(Intent intent) {
        Object className;
        int i;
        Es();
        int i2 = -1;
        IntentFilter intentFilter = null;
        int i3 = 0;
        ComponentName component = intent.getComponent();
        int i4;
        if (component != null) {
            className = component.getClassName();
            if (Atn.containsKey(className)) {
                i4 = 0;
            } else {
                className = null;
                i4 = -1;
            }
            i = i4;
        } else {
            Iterator it = Ato.entrySet().iterator();
            String str = null;
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                Object obj;
                int i5;
                IntentFilter intentFilter2;
                Entry entry = (Entry) it.next();
                String str2 = (String) entry.getKey();
                IntentFilter intentFilter3 = (IntentFilter) entry.getValue();
                i4 = intentFilter3.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "Tinker.IncrementCompMgr");
                if (i4 == -3 || i4 == -4 || i4 == -2 || i4 == -1) {
                    obj = null;
                } else {
                    obj = 1;
                }
                i2 = intentFilter3.getPriority();
                if (obj == null || i2 <= i) {
                    i5 = i3;
                    intentFilter2 = intentFilter;
                    str2 = str;
                    i2 = i;
                } else {
                    int i6 = i4;
                    intentFilter2 = intentFilter3;
                    i5 = i6;
                }
                i3 = i5;
                intentFilter = intentFilter2;
                str = str2;
            }
            String str3 = str;
        }
        if (className == null) {
            return null;
        }
        ResolveInfo resolveInfo = new ResolveInfo();
        resolveInfo.activityInfo = (ActivityInfo) Atn.get(className);
        resolveInfo.filter = intentFilter;
        resolveInfo.match = i3;
        resolveInfo.priority = i;
        resolveInfo.resolvePackageName = xLm;
        resolveInfo.icon = resolveInfo.activityInfo.icon;
        resolveInfo.labelRes = resolveInfo.activityInfo.labelRes;
        return resolveInfo;
    }

    private IncrementComponentManager() {
        throw new UnsupportedOperationException();
    }
}
