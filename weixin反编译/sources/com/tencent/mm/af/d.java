package com.tencent.mm.af;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.f.b.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends z {
    protected static com.tencent.mm.sdk.e.c.a gKN;
    public static int hpW = 1;
    public static int hpX = 0;
    public static int hpY = 1;
    private static int hqb = 0;
    private static b hqc = null;
    private List<a> hpZ;
    public b hqa;

    public static class a {
        public String description;
        public String hqd;
        public String title;
        public String url;
    }

    public static class b {
        private String hqA;
        private boolean hqB = false;
        public int hqC;
        private g hqD;
        private String hqE;
        private String hqF;
        private boolean hqG = false;
        public a hqH;
        private List<WxaEntryInfo> hqI;
        public JSONObject hqe = null;
        private boolean hqf = true;
        public boolean hqg = false;
        public boolean hqh = false;
        public boolean hqi = false;
        private String hqj;
        private String hqk;
        private List<f> hql = null;
        private d hqm = null;
        private c hqn = null;
        private e hqo = null;
        a hqp = null;
        private boolean hqq = false;
        boolean hqr = false;
        int hqs;
        public boolean hqt = false;
        public int hqu = 0;
        private int hqv = 0;
        private String hqw;
        private b hqx = null;
        private int hqy = 0;
        private int hqz = d.hpX;

        public static class a {
            public ArrayList<String> hqJ;

            public static com.tencent.mm.af.d.b.a jG(java.lang.String r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
                /*
                r6 = 1;
                r2 = 0;
                r0 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
                if (r0 == 0) goto L_0x000a;
            L_0x0008:
                r0 = 0;
            L_0x0009:
                return r0;
            L_0x000a:
                r0 = new com.tencent.mm.af.d$b$a;
                r0.<init>();
                r1 = "MicroMsg.BizInfo";
                r3 = "BizAcctTransferInfo is [%s]";
                r4 = new java.lang.Object[r6];
                r4[r2] = r7;
                com.tencent.mm.sdk.platformtools.x.d(r1, r3, r4);
                r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0044 }
                r1.<init>(r7);	 Catch:{ Exception -> 0x0044 }
                r3 = "origin_name_list";	 Catch:{ Exception -> 0x0044 }
                r3 = r1.optJSONArray(r3);	 Catch:{ Exception -> 0x0044 }
                if (r3 == 0) goto L_0x0009;	 Catch:{ Exception -> 0x0044 }
            L_0x002a:
                r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0044 }
                r1.<init>();	 Catch:{ Exception -> 0x0044 }
                r0.hqJ = r1;	 Catch:{ Exception -> 0x0044 }
                r1 = r2;	 Catch:{ Exception -> 0x0044 }
            L_0x0032:
                r4 = r3.length();	 Catch:{ Exception -> 0x0044 }
                if (r1 >= r4) goto L_0x0009;	 Catch:{ Exception -> 0x0044 }
            L_0x0038:
                r4 = r0.hqJ;	 Catch:{ Exception -> 0x0044 }
                r5 = r3.optString(r1);	 Catch:{ Exception -> 0x0044 }
                r4.add(r5);	 Catch:{ Exception -> 0x0044 }
                r1 = r1 + 1;
                goto L_0x0032;
            L_0x0044:
                r1 = move-exception;
                r3 = "MicroMsg.BizInfo";
                r4 = "exception:%s";
                r5 = new java.lang.Object[r6];
                r1 = com.tencent.mm.sdk.platformtools.bi.i(r1);
                r5[r2] = r1;
                com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
                goto L_0x0009;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.a.jG(java.lang.String):com.tencent.mm.af.d$b$a");
            }
        }

        public static class b {
            public int hqK;
            public int hqL;
            public int hqM;

            public static com.tencent.mm.af.d.b.b jH(java.lang.String r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
                /*
                r0 = "MicroMsg.BizInfo";
                r1 = new java.lang.StringBuilder;
                r2 = "HardwareBizInfo = ";
                r1.<init>(r2);
                r1 = r1.append(r6);
                r1 = r1.toString();
                com.tencent.mm.sdk.platformtools.x.i(r0, r1);
                r0 = new com.tencent.mm.af.d$b$b;
                r0.<init>();
                if (r6 == 0) goto L_0x0023;
            L_0x001d:
                r1 = r6.length();
                if (r1 > 0) goto L_0x0024;
            L_0x0023:
                return r0;
            L_0x0024:
                r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0045 }
                r1.<init>(r6);	 Catch:{ JSONException -> 0x0045 }
                r2 = "hardware_flag";	 Catch:{ JSONException -> 0x0045 }
                r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x0045 }
                r0.hqK = r2;	 Catch:{ JSONException -> 0x0045 }
                r2 = "connect_status_display_mode";	 Catch:{ JSONException -> 0x0045 }
                r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x0045 }
                r0.hqL = r2;	 Catch:{ JSONException -> 0x0045 }
                r2 = "special_internal_brand_type";	 Catch:{ JSONException -> 0x0045 }
                r1 = r1.optInt(r2);	 Catch:{ JSONException -> 0x0045 }
                r0.hqM = r1;	 Catch:{ JSONException -> 0x0045 }
                goto L_0x0023;
            L_0x0045:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r3 = "exception:%s";
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r5 = 0;
                r1 = com.tencent.mm.sdk.platformtools.bi.i(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
                goto L_0x0023;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.b.jH(java.lang.String):com.tencent.mm.af.d$b$b");
            }

            public final boolean LN() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
                /*
                r1 = this;
                r0 = r1.hqK;
                r0 = r0 & 1;
                if (r0 <= 0) goto L_0x0008;
            L_0x0006:
                r0 = 1;
            L_0x0007:
                return r0;
            L_0x0008:
                r0 = 0;
                goto L_0x0007;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.b.LN():boolean");
            }
        }

        public static class g {
            public String hre;
            public String hrf;
            public boolean hrg;

            public static com.tencent.mm.af.d.b.g jM(java.lang.String r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
                /*
                r2 = 1;
                r3 = 0;
                r0 = "MicroMsg.BizInfo";
                r1 = "RegisterSource = %s";
                r4 = new java.lang.Object[r2];
                r4[r3] = r6;
                com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);
                r0 = new com.tencent.mm.af.d$b$g;
                r0.<init>();
                if (r6 == 0) goto L_0x001c;
            L_0x0016:
                r1 = r6.length();
                if (r1 > 0) goto L_0x001d;
            L_0x001c:
                return r0;
            L_0x001d:
                r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0042 }
                r1.<init>(r6);	 Catch:{ JSONException -> 0x0042 }
                r4 = "RegisterBody";	 Catch:{ JSONException -> 0x0042 }
                r4 = r1.optString(r4);	 Catch:{ JSONException -> 0x0042 }
                r0.hre = r4;	 Catch:{ JSONException -> 0x0042 }
                r4 = "IntroUrl";	 Catch:{ JSONException -> 0x0042 }
                r4 = r1.optString(r4);	 Catch:{ JSONException -> 0x0042 }
                r0.hrf = r4;	 Catch:{ JSONException -> 0x0042 }
                r4 = "IsClose";	 Catch:{ JSONException -> 0x0042 }
                r5 = 0;	 Catch:{ JSONException -> 0x0042 }
                r1 = r1.optInt(r4, r5);	 Catch:{ JSONException -> 0x0042 }
                if (r1 != r2) goto L_0x0055;	 Catch:{ JSONException -> 0x0042 }
            L_0x003e:
                r1 = r2;	 Catch:{ JSONException -> 0x0042 }
            L_0x003f:
                r0.hrg = r1;	 Catch:{ JSONException -> 0x0042 }
                goto L_0x001c;
            L_0x0042:
                r1 = move-exception;
                r4 = "MicroMsg.BizInfo";
                r5 = "exception in RegisterSource:%s";
                r2 = new java.lang.Object[r2];
                r1 = com.tencent.mm.sdk.platformtools.bi.i(r1);
                r2[r3] = r1;
                com.tencent.mm.sdk.platformtools.x.e(r4, r5, r2);
                goto L_0x001c;
            L_0x0055:
                r1 = r3;
                goto L_0x003f;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.g.jM(java.lang.String):com.tencent.mm.af.d$b$g");
            }
        }

        public static class c {
            public int hqN;
            public List<j> hqO = null;
            public int type;

            public static class a {
                public long appid = 0;
                public String hqP;
                public String hqQ;
                public int hqR;
                public String hqS;
                public String hqT;

                public static com.tencent.mm.af.d.b.c.a jJ(java.lang.String r6) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
                    /*
                    r0 = "MicroMsg.BizInfo";
                    r1 = new java.lang.StringBuilder;
                    r2 = "EnterpriseBizInfo = ";
                    r1.<init>(r2);
                    r1 = r1.append(r6);
                    r1 = r1.toString();
                    com.tencent.mm.sdk.platformtools.x.i(r0, r1);
                    r0 = new com.tencent.mm.af.d$b$c$a;
                    r0.<init>();
                    if (r6 == 0) goto L_0x0023;
                L_0x001d:
                    r1 = r6.length();
                    if (r1 > 0) goto L_0x0024;
                L_0x0023:
                    return r0;
                L_0x0024:
                    r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x005e }
                    r1.<init>(r6);	 Catch:{ JSONException -> 0x005e }
                    r2 = "belong";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.hqP = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "freeze_wording";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.hqQ = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "child_type";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.hqR = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "home_url";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.hqS = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "exattr";	 Catch:{ JSONException -> 0x005e }
                    r1 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r2 = com.tencent.mm.sdk.platformtools.bi.oN(r1);	 Catch:{ JSONException -> 0x005e }
                    if (r2 == 0) goto L_0x0073;	 Catch:{ JSONException -> 0x005e }
                L_0x005a:
                    r1 = 0;	 Catch:{ JSONException -> 0x005e }
                    r0.hqT = r1;	 Catch:{ JSONException -> 0x005e }
                    goto L_0x0023;
                L_0x005e:
                    r1 = move-exception;
                    r2 = "MicroMsg.BizInfo";
                    r3 = "exception:%s";
                    r4 = 1;
                    r4 = new java.lang.Object[r4];
                    r5 = 0;
                    r1 = com.tencent.mm.sdk.platformtools.bi.i(r1);
                    r4[r5] = r1;
                    com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
                    goto L_0x0023;
                L_0x0073:
                    r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x005e }
                    r2.<init>(r1);	 Catch:{ JSONException -> 0x005e }
                    r1 = "chat_extension_url";	 Catch:{ JSONException -> 0x005e }
                    r1 = r2.optString(r1);	 Catch:{ JSONException -> 0x005e }
                    r0.hqT = r1;	 Catch:{ JSONException -> 0x005e }
                    r1 = "app_id";	 Catch:{ JSONException -> 0x005e }
                    r2 = r2.optLong(r1);	 Catch:{ JSONException -> 0x005e }
                    r0.appid = r2;	 Catch:{ JSONException -> 0x005e }
                    goto L_0x0023;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.c.a.jJ(java.lang.String):com.tencent.mm.af.d$b$c$a");
                }
            }

            public static com.tencent.mm.af.d.b.c jI(java.lang.String r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
                /*
                r5 = 0;
                r0 = "MicroMsg.BizInfo";
                r1 = new java.lang.StringBuilder;
                r2 = "MenuInfo = ";
                r1.<init>(r2);
                r1 = r1.append(r6);
                r1 = r1.toString();
                com.tencent.mm.sdk.platformtools.x.i(r0, r1);
                r0 = new com.tencent.mm.af.d$b$c;
                r0.<init>();
                if (r6 == 0) goto L_0x0024;
            L_0x001e:
                r1 = r6.length();
                if (r1 > 0) goto L_0x0025;
            L_0x0024:
                return r0;
            L_0x0025:
                r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x004b }
                r1.<init>(r6);	 Catch:{ JSONException -> 0x004b }
                r2 = "update_time";	 Catch:{ JSONException -> 0x004b }
                r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x004b }
                r0.hqN = r2;	 Catch:{ JSONException -> 0x004b }
                r2 = "type";	 Catch:{ JSONException -> 0x004b }
                r3 = 0;	 Catch:{ JSONException -> 0x004b }
                r2 = r1.optInt(r2, r3);	 Catch:{ JSONException -> 0x004b }
                r0.type = r2;	 Catch:{ JSONException -> 0x004b }
                r2 = "button_list";	 Catch:{ JSONException -> 0x004b }
                r1 = r1.optJSONArray(r2);	 Catch:{ JSONException -> 0x004b }
                r1 = com.tencent.mm.af.j.c(r1);	 Catch:{ JSONException -> 0x004b }
                r0.hqO = r1;	 Catch:{ JSONException -> 0x004b }
                goto L_0x0024;
            L_0x004b:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r3 = "exception:%s";
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r1 = com.tencent.mm.sdk.platformtools.bi.i(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
                goto L_0x0024;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.c.jI(java.lang.String):com.tencent.mm.af.d$b$c");
            }
        }

        public static class e {
            public int hqZ;
            public String hra;
            public List<String> hrb;
            public String hrc;

            public static com.tencent.mm.af.d.b.e jL(java.lang.String r8) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
                /*
                r0 = 0;
                r3 = 0;
                r1 = com.tencent.mm.sdk.platformtools.bi.oN(r8);
                if (r1 == 0) goto L_0x0009;
            L_0x0008:
                return r0;
            L_0x0009:
                r1 = new com.tencent.mm.af.d$b$e;	 Catch:{ Exception -> 0x005c }
                r1.<init>();	 Catch:{ Exception -> 0x005c }
                r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x005c }
                r2.<init>(r8);	 Catch:{ Exception -> 0x005c }
                r4 = "reputation_level";	 Catch:{ Exception -> 0x005c }
                r5 = -1;	 Catch:{ Exception -> 0x005c }
                r4 = r2.optInt(r4, r5);	 Catch:{ Exception -> 0x005c }
                r1.hqZ = r4;	 Catch:{ Exception -> 0x005c }
                r4 = "scope_of_business";	 Catch:{ Exception -> 0x005c }
                r4 = r2.optString(r4);	 Catch:{ Exception -> 0x005c }
                r1.hra = r4;	 Catch:{ Exception -> 0x005c }
                r4 = "guarantee_detail_h5_url";	 Catch:{ Exception -> 0x005c }
                r4 = r2.optString(r4);	 Catch:{ Exception -> 0x005c }
                r1.hrc = r4;	 Catch:{ Exception -> 0x005c }
                r4 = "guarantee_info";	 Catch:{ Exception -> 0x005c }
                r4 = r2.optJSONArray(r4);	 Catch:{ Exception -> 0x005c }
                if (r4 == 0) goto L_0x005a;	 Catch:{ Exception -> 0x005c }
            L_0x0038:
                r5 = r4.length();	 Catch:{ Exception -> 0x005c }
                if (r5 <= 0) goto L_0x005a;	 Catch:{ Exception -> 0x005c }
            L_0x003e:
                r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x005c }
                r2.<init>();	 Catch:{ Exception -> 0x005c }
                r1.hrb = r2;	 Catch:{ Exception -> 0x005c }
                r2 = r3;	 Catch:{ Exception -> 0x005c }
            L_0x0046:
                if (r2 >= r5) goto L_0x005a;	 Catch:{ Exception -> 0x005c }
            L_0x0048:
                r6 = r4.getString(r2);	 Catch:{ Exception -> 0x005c }
                r7 = com.tencent.mm.sdk.platformtools.bi.oN(r6);	 Catch:{ Exception -> 0x005c }
                if (r7 != 0) goto L_0x0057;	 Catch:{ Exception -> 0x005c }
            L_0x0052:
                r7 = r1.hrb;	 Catch:{ Exception -> 0x005c }
                r7.add(r6);	 Catch:{ Exception -> 0x005c }
            L_0x0057:
                r2 = r2 + 1;
                goto L_0x0046;
            L_0x005a:
                r0 = r1;
                goto L_0x0008;
            L_0x005c:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r4 = "exception:%s";
                r5 = 1;
                r5 = new java.lang.Object[r5];
                r1 = com.tencent.mm.sdk.platformtools.bi.i(r1);
                r5[r3] = r1;
                com.tencent.mm.sdk.platformtools.x.e(r2, r4, r5);
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.e.jL(java.lang.String):com.tencent.mm.af.d$b$e");
            }
        }

        public static class d {
            public int hqU = 0;
            public String hqV;
            public String hqW;
            public String hqX;
            public String hqY;

            public static com.tencent.mm.af.d.b.d jK(java.lang.String r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
                /*
                r6 = 1;
                r5 = 0;
                r0 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
                if (r0 == 0) goto L_0x000a;
            L_0x0008:
                r0 = 0;
            L_0x0009:
                return r0;
            L_0x000a:
                r0 = "MicroMsg.BizInfo";
                r1 = "biz verify info is [%s]";
                r2 = new java.lang.Object[r6];
                r2[r5] = r7;
                com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
                r0 = new com.tencent.mm.af.d$b$d;
                r0.<init>();
                r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0071 }
                r1.<init>(r7);	 Catch:{ Exception -> 0x0071 }
                r2 = "Type";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optInt(r2);	 Catch:{ Exception -> 0x0071 }
                r0.hqU = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "Description";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.hqV = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "Name";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.hqW = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "IntroUrl";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.hqX = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "VerifySubTitle";	 Catch:{ Exception -> 0x0071 }
                r1 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.hqY = r1;	 Catch:{ Exception -> 0x0071 }
            L_0x004e:
                r1 = "MicroMsg.BizInfo";
                r2 = "type[%d],desc[%s],name[%s],url[%s]";
                r3 = 4;
                r3 = new java.lang.Object[r3];
                r4 = r0.hqU;
                r4 = java.lang.Integer.valueOf(r4);
                r3[r5] = r4;
                r4 = r0.hqV;
                r3[r6] = r4;
                r4 = 2;
                r5 = r0.hqW;
                r3[r4] = r5;
                r4 = 3;
                r5 = r0.hqX;
                r3[r4] = r5;
                com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
                goto L_0x0009;
            L_0x0071:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r3 = "exception:%s";
                r4 = new java.lang.Object[r6];
                r1 = com.tencent.mm.sdk.platformtools.bi.i(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
                goto L_0x004e;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.d.jK(java.lang.String):com.tencent.mm.af.d$b$d");
            }
        }

        public static class f {
            public String description;
            public String hrd;
            public String iconUrl;

            public static java.util.List<com.tencent.mm.af.d.b.f> b(org.json.JSONArray r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
                /*
                r2 = 0;
                r0 = new java.util.LinkedList;
                r0.<init>();
                if (r7 != 0) goto L_0x0009;
            L_0x0008:
                return r0;
            L_0x0009:
                r3 = r7.length();	 Catch:{ Exception -> 0x003a }
                r1 = r2;	 Catch:{ Exception -> 0x003a }
            L_0x000e:
                if (r1 >= r3) goto L_0x0008;	 Catch:{ Exception -> 0x003a }
            L_0x0010:
                r4 = new com.tencent.mm.af.d$b$f;	 Catch:{ Exception -> 0x003a }
                r4.<init>();	 Catch:{ Exception -> 0x003a }
                r5 = r7.optJSONObject(r1);	 Catch:{ Exception -> 0x003a }
                r6 = "icon";	 Catch:{ Exception -> 0x003a }
                r6 = r5.optString(r6);	 Catch:{ Exception -> 0x003a }
                r4.iconUrl = r6;	 Catch:{ Exception -> 0x003a }
                r6 = "description";	 Catch:{ Exception -> 0x003a }
                r6 = r5.optString(r6);	 Catch:{ Exception -> 0x003a }
                r4.description = r6;	 Catch:{ Exception -> 0x003a }
                r6 = "description_key";	 Catch:{ Exception -> 0x003a }
                r5 = r5.optString(r6);	 Catch:{ Exception -> 0x003a }
                r4.hrd = r5;	 Catch:{ Exception -> 0x003a }
                r0.add(r4);	 Catch:{ Exception -> 0x003a }
                r1 = r1 + 1;
                goto L_0x000e;
            L_0x003a:
                r1 = move-exception;
                r3 = "MicroMsg.BizInfo";
                r4 = "exception:%s";
                r5 = 1;
                r5 = new java.lang.Object[r5];
                r1 = com.tencent.mm.sdk.platformtools.bi.i(r1);
                r5[r2] = r1;
                com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.f.b(org.json.JSONArray):java.util.List<com.tencent.mm.af.d$b$f>");
            }
        }

        public final java.util.List<com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo> Lu() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r7 = this;
            r0 = 0;
            r1 = r7.hqI;
            if (r1 != 0) goto L_0x0083;
        L_0x0005:
            r1 = new java.util.LinkedList;
            r1.<init>();
            r7.hqI = r1;
            r1 = r7.hqe;
            if (r1 == 0) goto L_0x0083;
        L_0x0010:
            r1 = r7.hqe;
            r2 = "BindWxaInfo";
            r2 = r1.optString(r2);
            r1 = android.text.TextUtils.isEmpty(r2);
            if (r1 != 0) goto L_0x0081;
        L_0x001f:
            r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0080 }
            r1.<init>(r2);	 Catch:{ JSONException -> 0x0080 }
        L_0x0024:
            if (r1 == 0) goto L_0x0086;
        L_0x0026:
            r0 = "wxaEntryInfo";
            r0 = r1.optJSONArray(r0);
            r1 = r0;
        L_0x002e:
            if (r1 == 0) goto L_0x0083;
        L_0x0030:
            r0 = 0;
        L_0x0031:
            r2 = r1.length();
            if (r0 >= r2) goto L_0x0083;
        L_0x0037:
            r2 = r1.optJSONObject(r0);
            if (r2 == 0) goto L_0x007d;
        L_0x003d:
            r3 = "username";
            r3 = r2.optString(r3);
            r4 = "title";
            r4 = r2.optString(r4);
            r5 = "title_key";
            r5 = r2.optString(r5);
            r6 = "icon_url";
            r2 = r2.optString(r6);
            r6 = android.text.TextUtils.isEmpty(r3);
            if (r6 != 0) goto L_0x007d;
        L_0x005f:
            r6 = android.text.TextUtils.isEmpty(r4);
            if (r6 == 0) goto L_0x006b;
        L_0x0065:
            r6 = android.text.TextUtils.isEmpty(r5);
            if (r6 != 0) goto L_0x007d;
        L_0x006b:
            r6 = new com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo;
            r6.<init>();
            r6.username = r3;
            r6.title = r4;
            r6.iSQ = r5;
            r6.iconUrl = r2;
            r2 = r7.hqI;
            r2.add(r6);
        L_0x007d:
            r0 = r0 + 1;
            goto L_0x0031;
        L_0x0080:
            r1 = move-exception;
        L_0x0081:
            r1 = r0;
            goto L_0x0024;
        L_0x0083:
            r0 = r7.hqI;
            return r0;
        L_0x0086:
            r1 = r0;
            goto L_0x002e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.Lu():java.util.List<com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo>");
        }

        public final boolean Lv() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r3 = this;
            r2 = 1;
            r0 = r3.hqe;
            if (r0 == 0) goto L_0x0024;
        L_0x0005:
            r0 = r3.hqe;
            r1 = "WifiBizInfo";
            r0 = r0.optJSONObject(r1);
            if (r0 == 0) goto L_0x0024;
        L_0x0010:
            r0 = r3.hqe;
            r1 = "WifiBizInfo";
            r0 = r0.optJSONObject(r1);
            r1 = "IsWXWiFi";
            r0 = r0.optInt(r1);
            if (r0 != r2) goto L_0x0024;
        L_0x0022:
            r3.hqG = r2;
        L_0x0024:
            r0 = r3.hqG;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.Lv():boolean");
        }

        public final boolean Lw() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x0015;
        L_0x0004:
            r0 = r2.hqe;
            r1 = "NotifyManage";
            r0 = r0.optString(r1);
            r1 = com.tencent.mm.af.d.hpX;
            r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r1);
            r2.hqz = r0;
        L_0x0015:
            r0 = r2.hqz;
            r1 = com.tencent.mm.af.d.hpW;
            if (r0 != r1) goto L_0x001d;
        L_0x001b:
            r0 = 1;
        L_0x001c:
            return r0;
        L_0x001d:
            r0 = 0;
            goto L_0x001c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.Lw():boolean");
        }

        public final java.lang.String Lx() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hqe;
            r1 = "VerifyContactPromptTitle";
            r0 = r0.optString(r1);
            r2.hqj = r0;
        L_0x000f:
            r0 = r2.hqj;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.Lx():java.lang.String");
        }

        public final java.lang.String Ly() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hqe;
            r1 = "TrademarkUrl";
            r0 = r0.optString(r1);
            r2.hqE = r0;
        L_0x000f:
            r0 = r2.hqE;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.Ly():java.lang.String");
        }

        public final java.lang.String Lz() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hqe;
            r1 = "TrademarkName";
            r0 = r0.optString(r1);
            r2.hqF = r0;
        L_0x000f:
            r0 = r2.hqF;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.Lz():java.lang.String");
        }

        public final java.lang.String LA() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hqe;
            r1 = "ConferenceContactExpireTime";
            r0 = r0.optString(r1);
            r2.hqk = r0;
        L_0x000f:
            r0 = r2.hqk;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LA():java.lang.String");
        }

        public final java.util.List<com.tencent.mm.af.d.b.f> LB() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r2.hql;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r2.hqe;
            r1 = "Privilege";
            r0 = r0.optJSONArray(r1);
            r0 = com.tencent.mm.af.d.b.f.b(r0);
            r2.hql = r0;
        L_0x0017:
            r0 = r2.hql;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LB():java.util.List<com.tencent.mm.af.d$b$f>");
        }

        public final int LC() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hqe;
            r1 = "InteractiveMode";
            r0 = r0.optInt(r1);
            r2.hqy = r0;
        L_0x000f:
            r0 = r2.hqy;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LC():int");
        }

        public final com.tencent.mm.af.d.b.e LD() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r2.hqo;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r2.hqe;
            r1 = "PayShowInfo";
            r0 = r0.optString(r1);
            r0 = com.tencent.mm.af.d.b.e.jL(r0);
            r2.hqo = r0;
        L_0x0017:
            r0 = r2.hqo;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LD():com.tencent.mm.af.d$b$e");
        }

        public final com.tencent.mm.af.d.b.b LE() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.hqx;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.hqe;
            r1 = "HardwareBizInfo";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.af.d.b.b.jH(r0);
            r2.hqx = r0;
        L_0x0019:
            r0 = r2.hqx;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LE():com.tencent.mm.af.d$b$b");
        }

        public final com.tencent.mm.af.d.b.d LF() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r2.hqm;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r2.hqe;
            r1 = "VerifySource";
            r0 = r0.optString(r1);
            r0 = com.tencent.mm.af.d.b.d.jK(r0);
            r2.hqm = r0;
        L_0x0017:
            r0 = r2.hqm;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LF():com.tencent.mm.af.d$b$d");
        }

        public final com.tencent.mm.af.d.b.g LG() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.hqD;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.hqe;
            r1 = "RegisterSource";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.af.d.b.g.jM(r0);
            r2.hqD = r0;
        L_0x0019:
            r0 = r2.hqD;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LG():com.tencent.mm.af.d$b$g");
        }

        public final boolean Lg() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r3 = this;
            r0 = 0;
            r1 = r3.hqe;
            if (r1 == 0) goto L_0x0017;
        L_0x0005:
            r1 = r3.hqe;
            r2 = "ReportLocationType";
            r1 = r1.optString(r2);
            r1 = com.tencent.mm.sdk.platformtools.bi.getInt(r1, r0);
            if (r1 <= 0) goto L_0x0015;
        L_0x0014:
            r0 = 1;
        L_0x0015:
            r3.hqq = r0;
        L_0x0017:
            r0 = r3.hqq;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.Lg():boolean");
        }

        public final boolean LH() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r4 = this;
            r0 = 1;
            r1 = 0;
            r2 = r4.hqe;
            if (r2 == 0) goto L_0x0017;
        L_0x0006:
            r2 = r4.hqe;
            r3 = "IsTrademarkProtection";
            r2 = r2.optString(r3);
            r2 = com.tencent.mm.sdk.platformtools.bi.getInt(r2, r1);
            if (r2 != r0) goto L_0x001a;
        L_0x0015:
            r4.hqB = r0;
        L_0x0017:
            r0 = r4.hqB;
            return r0;
        L_0x001a:
            r0 = r1;
            goto L_0x0015;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LH():boolean");
        }

        public final int LI() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r3 = this;
            r0 = r3.hqe;
            if (r0 == 0) goto L_0x0010;
        L_0x0004:
            r0 = r3.hqe;
            r1 = "ServiceType";
            r2 = 0;
            r0 = r0.optInt(r1, r2);
            r3.hqv = r0;
        L_0x0010:
            r0 = r3.hqv;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LI():int");
        }

        public final java.lang.String LJ() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hqe;
            r1 = "SupportEmoticonLinkPrefix";
            r0 = r0.optString(r1);
            r2.hqw = r0;
        L_0x000f:
            r0 = r2.hqw;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LJ():java.lang.String");
        }

        public final com.tencent.mm.af.d.b.c LK() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.hqn;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.hqe;
            r1 = "MMBizMenu";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.af.d.b.c.jI(r0);
            r2.hqn = r0;
        L_0x0019:
            r0 = r2.hqn;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LK():com.tencent.mm.af.d$b$c");
        }

        public final java.lang.String LL() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.hqe;
            r1 = "ServicePhone";
            r0 = r0.optString(r1);
            r2.hqA = r0;
        L_0x000f:
            r0 = r2.hqA;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LL():java.lang.String");
        }

        private b() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r3 = this;
            r2 = 0;
            r1 = 0;
            r3.<init>();
            r3.hqe = r2;
            r0 = 1;
            r3.hqf = r0;
            r3.hqg = r1;
            r3.hqh = r1;
            r3.hqi = r1;
            r3.hql = r2;
            r3.hqm = r2;
            r3.hqn = r2;
            r3.hqo = r2;
            r3.hqp = r2;
            r3.hqq = r1;
            r3.hqr = r1;
            r3.hqt = r1;
            r3.hqu = r1;
            r3.hqv = r1;
            r3.hqx = r2;
            r3.hqy = r1;
            r0 = com.tencent.mm.af.d.hpX;
            r3.hqz = r0;
            r3.hqB = r1;
            r3.hqG = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.<init>():void");
        }

        static com.tencent.mm.af.d.b jF(java.lang.String r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r0 = new com.tencent.mm.af.d$b;
            r0.<init>();
            r1 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
            if (r1 == 0) goto L_0x000c;
        L_0x000b:
            return r0;
        L_0x000c:
            java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0017 }
            r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0017 }
            r1.<init>(r6);	 Catch:{ Exception -> 0x0017 }
            r0.hqe = r1;	 Catch:{ Exception -> 0x0017 }
            goto L_0x000b;
        L_0x0017:
            r1 = move-exception;
            r2 = "MicroMsg.BizInfo";
            r3 = "exception:%s";
            r4 = 1;
            r4 = new java.lang.Object[r4];
            r5 = 0;
            r1 = com.tencent.mm.sdk.platformtools.bi.i(r1);
            r4[r5] = r1;
            com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
            goto L_0x000b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.jF(java.lang.String):com.tencent.mm.af.d$b");
        }

        public final com.tencent.mm.af.d.b.c.a LM() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
            /*
            r2 = this;
            r0 = r2.hqe;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.hqp;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.hqe;
            r1 = "EnterpriseBizInfo";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.af.d.b.c.a.jJ(r0);
            r2.hqp = r0;
        L_0x0019:
            r0 = r2.hqp;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.d.b.LM():com.tencent.mm.af.d$b$c$a");
        }
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xrT.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "username";
        aVar.columns[1] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "brandList";
        aVar.xrT.put("brandList", "TEXT default '' ");
        stringBuilder.append(" brandList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "brandListVersion";
        aVar.xrT.put("brandListVersion", "TEXT");
        stringBuilder.append(" brandListVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "brandListContent";
        aVar.xrT.put("brandListContent", "TEXT");
        stringBuilder.append(" brandListContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "brandFlag";
        aVar.xrT.put("brandFlag", "INTEGER");
        stringBuilder.append(" brandFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "extInfo";
        aVar.xrT.put("extInfo", "TEXT");
        stringBuilder.append(" extInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "brandInfo";
        aVar.xrT.put("brandInfo", "TEXT");
        stringBuilder.append(" brandInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "brandIconURL";
        aVar.xrT.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "updateTime";
        aVar.xrT.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "hadAlert";
        aVar.xrT.put("hadAlert", "INTEGER");
        stringBuilder.append(" hadAlert INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "acceptType";
        aVar.xrT.put("acceptType", "INTEGER default '0' ");
        stringBuilder.append(" acceptType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "enterpriseFather";
        aVar.xrT.put("enterpriseFather", "TEXT");
        stringBuilder.append(" enterpriseFather TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "kfWorkerId";
        aVar.xrT.put("kfWorkerId", "TEXT");
        stringBuilder.append(" kfWorkerId TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "specialType";
        aVar.xrT.put("specialType", "INTEGER");
        stringBuilder.append(" specialType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "attrSyncVersion";
        aVar.xrT.put("attrSyncVersion", "TEXT");
        stringBuilder.append(" attrSyncVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "incrementUpdateTime";
        aVar.xrT.put("incrementUpdateTime", "LONG");
        stringBuilder.append(" incrementUpdateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[19] = "bitFlag";
        aVar.xrT.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        aVar.columns[20] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }

    public final b bK(boolean z) {
        if (this.hqa == null || z) {
            if (bi.oN(this.field_extInfo) || hqb != this.field_extInfo.hashCode()) {
                b jF = b.jF(this.field_extInfo);
                this.hqa = jF;
                hqc = jF;
                hqb = bi.oM(this.field_extInfo).hashCode();
            } else {
                this.hqa = hqc;
            }
        }
        return this.hqa;
    }

    public final boolean Lc() {
        return (this.field_brandFlag & 1) == 0;
    }

    public final boolean Ld() {
        return (this.field_brandFlag & 4) != 0;
    }

    public final boolean Le() {
        if (System.currentTimeMillis() - this.field_updateTime > 86400000) {
            return true;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        if (this.field_updateTime >= instance.getTimeInMillis()) {
            return false;
        }
        return true;
    }

    public final void Lf() {
        bK(false);
        b bVar = this.hqa;
        if (bVar.hqe != null) {
            bVar.hqs = bVar.hqe.optInt("ConnectorMsgType");
        }
        this.field_acceptType = bVar.hqs;
        this.field_type = bK(false).LI();
        if (Lm()) {
            hs(1);
        } else {
            this.field_bitFlag &= -2;
        }
    }

    public final boolean Lg() {
        bK(false);
        x.i("MicroMsg.BizInfo", "is report location, user %s %B", this.field_username, Boolean.valueOf(this.hqa.Lg()));
        return this.hqa.Lg();
    }

    public final boolean Lh() {
        bK(false);
        if (this.field_type == 1) {
            return true;
        }
        return false;
    }

    public final boolean Li() {
        bK(false);
        if (this.field_type == 0) {
            return true;
        }
        return false;
    }

    public final boolean Lj() {
        bK(false);
        if (this.field_type == 2 || this.field_type == 3) {
            return true;
        }
        return false;
    }

    public final boolean Lk() {
        bK(false);
        if (this.field_type == 2) {
            return true;
        }
        return false;
    }

    public final boolean Ll() {
        bK(false);
        if (this.field_type == 3) {
            return true;
        }
        return false;
    }

    public final boolean Lm() {
        bK(false);
        if (this.hqa == null || this.hqa.LM() == null) {
            return false;
        }
        boolean z = this.hqa.hqp.hqR == 1;
        if (z && !hr(1)) {
            hs(1);
            y.Ml().e(this);
        }
        if (!z) {
            return z;
        }
        x.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", this.field_username);
        return z;
    }

    public final boolean Ln() {
        bK(false);
        if (this.hqa == null || this.hqa.LM() == null) {
            return false;
        }
        boolean z = this.hqa.hqp.hqR == 2;
        if (z && !hr(2)) {
            hs(2);
            y.Ml().e(this);
        }
        if (!z) {
            return z;
        }
        x.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", this.field_username);
        return z;
    }

    public final String Lo() {
        bK(false);
        if (this.hqa != null) {
            a LM = this.hqa.LM();
            if (!(LM == null || LM.hqS == null || LM.hqS.isEmpty())) {
                return LM.hqS;
            }
        }
        return null;
    }

    public final long Lp() {
        bK(false);
        if (this.hqa == null) {
            return 0;
        }
        a LM = this.hqa.LM();
        if (LM == null || LM.appid == 0) {
            return 0;
        }
        return LM.appid;
    }

    public final boolean Lq() {
        bK(false);
        if (this.hqa == null) {
            x.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
            return true;
        } else if (this.hqa.LG() == null) {
            x.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
            return true;
        } else if (this.hqa.LG().hrg) {
            return false;
        } else {
            return true;
        }
    }

    public final String Lr() {
        bK(false);
        if (this.hqa != null) {
            a LM = this.hqa.LM();
            if (LM != null) {
                return LM.hqT;
            }
        }
        return null;
    }

    public final String Ls() {
        String str = bK(false).LM().hqP;
        if (bi.oN(str)) {
            x.e("MicroMsg.BizInfo", "check father: %s, %s", this.field_username, str);
        }
        return str;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }

    public final ContentValues vP() {
        return super.vP();
    }

    public final List<a> Lt() {
        if (this.hpZ != null) {
            return this.hpZ;
        }
        this.hpZ = new LinkedList();
        if (this.field_brandInfo == null || this.field_brandInfo.length() == 0) {
            return this.hpZ;
        }
        try {
            JSONArray optJSONArray = new JSONObject(this.field_brandInfo).optJSONArray("urls");
            for (int i = 0; i < optJSONArray.length(); i++) {
                a aVar = new a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                aVar.title = optJSONObject.optString("title");
                aVar.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                aVar.hqd = optJSONObject.optString("title_key");
                aVar.description = optJSONObject.optString("description");
                this.hpZ.add(aVar);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.BizInfo", "exception:%s", bi.i(e));
        }
        return this.hpZ;
    }

    private boolean hr(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    private void hs(int i) {
        this.field_bitFlag |= i;
    }
}
