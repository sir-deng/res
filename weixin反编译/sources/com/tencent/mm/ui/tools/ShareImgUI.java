package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.k.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.mm.y.as;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareImgUI extends AutoLoginActivity implements e {
    String filePath = null;
    private ag handler = new ag() {
        public final void handleMessage(Message message) {
            ShareImgUI.d(ShareImgUI.this);
            if (bi.oN(ShareImgUI.this.filePath)) {
                x.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
                ShareImgUI.this.Hd(0);
                ShareImgUI.this.finish();
                return;
            }
            ShareImgUI.c(ShareImgUI.this);
        }
    };
    private ProgressDialog inI = null;
    private Intent intent = null;
    String text = null;
    Uri uri = null;
    ArrayList<String> zpK = null;

    private class a implements Runnable {
        private Uri aMK;
        private c zvV;

        public a(Uri uri, c cVar) {
            this.aMK = uri;
            this.zvV = cVar;
        }

        public final void run() {
            ShareImgUI.this.filePath = ShareImgUI.a(ShareImgUI.this, this.aMK);
            if (bi.oN(ShareImgUI.this.filePath) || !new File(ShareImgUI.this.filePath).exists()) {
                if (ShareImgUI.aaB(ShareImgUI.this.getContentResolver().getType(this.aMK)) == 3) {
                    ShareImgUI.this.filePath = d.a(ShareImgUI.this.getContentResolver(), this.aMK);
                } else {
                    ShareImgUI.this.filePath = d.a(ShareImgUI.this.getContentResolver(), this.aMK, 1);
                }
            }
            if (this.zvV != null) {
                this.zvV.cyt();
            }
        }
    }

    private interface b {
        void al(ArrayList<String> arrayList);
    }

    public interface c {
        void cyt();
    }

    static /* synthetic */ String a(ShareImgUI shareImgUI, Uri uri) {
        String scheme = uri.getScheme();
        if (bi.oN(scheme)) {
            x.e("MicroMsg.ShareImgUI", "input uri error. %s", uri);
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            x.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_FILE");
            return uri.getPath();
        } else if (scheme.equalsIgnoreCase("content")) {
            x.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
            Cursor query = shareImgUI.getContentResolver().query(uri, null, null, null, null);
            if (query == null) {
                x.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor is null");
                return null;
            } else if (query.getCount() <= 0 || !query.moveToFirst()) {
                query.close();
                x.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
                return null;
            } else {
                String toLowerCase = uri.toString().toLowerCase();
                if (toLowerCase.startsWith("content://com.android.contacts/contacts/as_vcard") || toLowerCase.startsWith("content://com.android.contacts/contacts/as_multi_vcard") || toLowerCase.startsWith("content://com.mediatek.calendarimporter") || ((shareImgUI.intent != null && shareImgUI.intent.getType().equals("text/x-vcalendar")) || q.gHP.gGH == 1)) {
                    return shareImgUI.a(uri, query);
                }
                query.close();
                return bi.f(shareImgUI, uri);
            }
        } else {
            x.e("MicroMsg.ShareImgUI", "unknown scheme");
            return null;
        }
    }

    static /* synthetic */ void a(ShareImgUI shareImgUI, final b bVar, final ArrayList arrayList) {
        if (bVar != null) {
            shareImgUI.runOnUiThread(new Runnable() {
                public final void run() {
                    bVar.al(arrayList);
                }
            });
        }
    }

    static /* synthetic */ boolean a(ShareImgUI shareImgUI, ArrayList arrayList, Parcelable parcelable) {
        if (parcelable == null || !(parcelable instanceof Uri)) {
            x.e("MicroMsg.ShareImgUI", "getMultiSendFilePath failed, error parcelable, %s", parcelable);
        } else {
            Uri uri = (Uri) parcelable;
            if (!bi.m(uri) || uri.getScheme() == null) {
                x.e("MicroMsg.ShareImgUI", "unaccepted uri: " + uri);
            } else {
                String f = bi.f(shareImgUI, uri);
                if (!bi.oN(f)) {
                    if (bi.WB(f) && aaA(f)) {
                        x.i("MicroMsg.ShareImgUI", "multisend file path: " + f);
                        arrayList.add(f);
                        return true;
                    }
                    x.w("MicroMsg.ShareImgUI", "multisend tries to send illegal img: " + f);
                }
            }
        }
        return false;
    }

    static /* synthetic */ void c(ShareImgUI shareImgUI) {
        Intent intent = shareImgUI.getIntent();
        int aaB = aaB(intent.resolveType(shareImgUI));
        if (aaB == 0 && p.Vw(shareImgUI.filePath)) {
            x.i("MicroMsg.ShareImgUI", "fix msg type to emoji.");
            aaB = 5;
        }
        x.i("MicroMsg.ShareImgUI", "filepath:[%s], msgType:%d, text:%s", shareImgUI.filePath, Integer.valueOf(aaB), shareImgUI.text);
        if (aaB == -1) {
            x.e("MicroMsg.ShareImgUI", "launch, msgType is invalid");
        } else if (!bi.oN(shareImgUI.filePath) && bi.WB(shareImgUI.filePath) && !aaA(shareImgUI.filePath)) {
            x.w("MicroMsg.ShareImgUI", "try to share illegal image.");
            shareImgUI.Hd(0);
        } else if (aaB == 3 && !bi.oN(shareImgUI.filePath)) {
            shareImgUI.aaH(shareImgUI.filePath);
        } else if (shareImgUI.text == null || aaB != 0 || bi.oN(shareImgUI.filePath)) {
            if (aaB == 5 && !bi.oN(shareImgUI.filePath)) {
                if (com.tencent.mm.a.e.bN(shareImgUI.filePath) > com.tencent.mm.j.b.zM()) {
                    g.pWK.h(13459, Integer.valueOf(com.tencent.mm.a.e.bN(shareImgUI.filePath)), Integer.valueOf(1), "", Integer.valueOf(2));
                    shareImgUI.cyS();
                    return;
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                if ((com.tencent.mm.sdk.platformtools.d.decodeFile(shareImgUI.filePath, options) != null && options.outHeight > com.tencent.mm.j.b.zL()) || options.outWidth > com.tencent.mm.j.b.zL()) {
                    g.pWK.h(13459, Integer.valueOf(com.tencent.mm.a.e.bN(shareImgUI.filePath)), Integer.valueOf(1), "", Integer.valueOf(2));
                    shareImgUI.cyS();
                    return;
                }
            }
            if (!t.a(shareImgUI.getIntent(), "Intro_Switch", false) && as.Ho() && !as.Cz()) {
                intent.setData(shareImgUI.uri);
                intent.setClass(shareImgUI, MsgRetransmitUI.class);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864);
                intent.putExtra("Retr_File_Name", shareImgUI.filePath);
                intent.putStringArrayListExtra("Retr_File_Path_List", shareImgUI.zpK);
                intent.putExtra("Retr_Msg_Type", aaB);
                intent.putExtra("Retr_Scene", 1);
                intent.putExtra("Retr_start_where_you_are", false);
                shareImgUI.startActivity(intent);
            } else if (!shareImgUI.cyR()) {
                shareImgUI.Hd(0);
            }
        } else {
            shareImgUI.aaH(shareImgUI.filePath);
        }
        shareImgUI.finish();
    }

    static /* synthetic */ void d(ShareImgUI shareImgUI) {
        if (shareImgUI.inI != null && shareImgUI.inI.isShowing()) {
            shareImgUI.inI.dismiss();
        }
    }

    protected final boolean z(Intent intent) {
        return true;
    }

    protected final boolean bgf() {
        if (as.Ho() && !as.Cz()) {
            return false;
        }
        x.w("MicroMsg.ShareImgUI", "not login");
        this.intent = getIntent();
        YC();
        return true;
    }

    protected final void a(com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a aVar, Intent intent) {
        switch (aVar) {
            case LOGIN_OK:
                this.intent = intent;
                x.i("MicroMsg.ShareImgUI", "now permission = %d", Integer.valueOf(bi.getInt(com.tencent.mm.j.g.Af().getValue("SystemShareControlBitset"), 0)));
                if ((bi.getInt(com.tencent.mm.j.g.Af().getValue("SystemShareControlBitset"), 0) & 1) > 0) {
                    x.e("MicroMsg.ShareImgUI", "now allowed to share to friend");
                    finish();
                    return;
                }
                x.i("MicroMsg.ShareImgUI", "postLogin, text = %s", t.j(intent, "android.intent.extra.TEXT"));
                if (bi.oN(t.j(intent, "android.intent.extra.TEXT"))) {
                    YC();
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                showDialog();
                as.CN().a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (e) this);
                as.CN().a(new ak(format, 15, null), 0);
                return;
            default:
                finish();
                com.tencent.mm.ui.base.b.fH(this);
                return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (e) this);
    }

    private void YC() {
        if (this.intent == null) {
            x.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
            Hd(0);
            finish();
            return;
        }
        String action = this.intent.getAction();
        final Bundle extras = this.intent.getExtras();
        if (bi.oN(action)) {
            x.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
            Hd(0);
            finish();
            return;
        }
        this.text = t.j(this.intent, "android.intent.extra.TEXT");
        if (extras != null) {
            Parcelable parcelable = extras.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                this.uri = (Uri) parcelable;
                if (!bi.m(this.uri)) {
                    x.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", this.uri);
                    Hd(0);
                    finish();
                    return;
                }
            }
        }
        if (action.equals("android.intent.action.SEND")) {
            x.i("MicroMsg.ShareImgUI", "send signal: " + action);
            if (this.uri == null) {
                boolean z;
                Intent intent = getIntent();
                if (intent == null) {
                    x.e("MicroMsg.ShareImgUI", "intent is null");
                    z = false;
                } else {
                    String j = t.j(intent, "android.intent.extra.TEXT");
                    if (j == null || j.length() == 0) {
                        x.i("MicroMsg.ShareImgUI", "text is null");
                        z = false;
                    } else {
                        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(j));
                        wXMediaMessage.description = j;
                        Req req = new Req();
                        req.transaction = null;
                        req.message = wXMediaMessage;
                        extras = new Bundle();
                        req.toBundle(extras);
                        extras.putInt(ConstantsAPI.SDK_VERSION, 620823552);
                        extras.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
                        extras.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                        intent = new Intent();
                        intent.setClass(this, SelectConversationUI.class);
                        intent.putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras(extras).putExtra("animation_pop_in", true));
                        if (!as.Ho() || as.Cz()) {
                            x.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
                        } else {
                            startActivity(intent);
                        }
                        z = true;
                    }
                }
                x.i("MicroMsg.ShareImgUI", "dealWithText: %b", Boolean.valueOf(z));
                if (!z) {
                    Hd(0);
                }
                finish();
                return;
            }
            showDialog();
            com.tencent.mm.sdk.f.e.post(new a(this.uri, new c() {
                public final void cyt() {
                    ShareImgUI.this.handler.sendEmptyMessage(0);
                }
            }), "ShareImgUI_getFilePath");
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && extras != null && extras.containsKey("android.intent.extra.STREAM")) {
            x.i("MicroMsg.ShareImgUI", "send multi: " + action);
            final b anonymousClass2 = new b() {
                public final void al(ArrayList<String> arrayList) {
                    ShareImgUI.this.zpK = arrayList;
                    if (ShareImgUI.this.zpK == null || ShareImgUI.this.zpK.size() == 0) {
                        x.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
                        ShareImgUI.this.Hd(1);
                        ShareImgUI.this.finish();
                        return;
                    }
                    Iterator it = ShareImgUI.this.zpK.iterator();
                    while (it.hasNext()) {
                        if (p.Vw((String) it.next())) {
                            x.i("MicroMsg.ShareImgUI", "%s is not image", (String) it.next());
                            ShareImgUI.this.Hd(1);
                            ShareImgUI.this.finish();
                            return;
                        }
                    }
                    String resolveType = ShareImgUI.this.getIntent().resolveType(ShareImgUI.this);
                    if (resolveType == null || !resolveType.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                        x.i("MicroMsg.ShareImgUI", "mime type is no timage, try to set it");
                        ShareImgUI.this.getIntent().setDataAndType(ShareImgUI.this.getIntent().getData(), "image/*");
                    }
                    ShareImgUI.c(ShareImgUI.this);
                }
            };
            final long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    r11 = this;
                    r9 = 1;
                    r6 = 0;
                    r10 = 0;
                    r0 = r2;
                    r1 = "android.intent.extra.STREAM";
                    r0 = r0.getParcelableArrayList(r1);
                    if (r0 == 0) goto L_0x00a4;
                L_0x000e:
                    r1 = r0.size();
                    if (r1 <= 0) goto L_0x00a4;
                L_0x0014:
                    r2 = new java.util.ArrayList;
                    r2.<init>();
                    r5 = new java.util.concurrent.CountDownLatch;
                    r1 = r0.size();
                    r5.<init>(r1);
                    r4 = new boolean[r9];
                    r4[r10] = r10;
                    r7 = r0.iterator();
                L_0x002a:
                    r0 = r7.hasNext();
                    if (r0 == 0) goto L_0x0054;
                L_0x0030:
                    r3 = r7.next();
                    r3 = (android.os.Parcelable) r3;
                    r0 = new com.tencent.mm.ui.tools.ShareImgUI$4$1;
                    r1 = r11;
                    r0.<init>(r2, r3, r4, r5);
                    r1 = new java.lang.StringBuilder;
                    r8 = "getMultiSendFilePathListItem";
                    r1.<init>(r8);
                    r3 = r3.toString();
                    r1 = r1.append(r3);
                    r1 = r1.toString();
                    com.tencent.mm.sdk.f.e.post(r0, r1);
                    goto L_0x002a;
                L_0x0054:
                    r5.await();	 Catch:{ InterruptedException -> 0x006d }
                L_0x0057:
                    r0 = r4[r10];
                    if (r0 == 0) goto L_0x0081;
                L_0x005b:
                    r0 = "MicroMsg.ShareImgUI";
                    r1 = "hy: has non path img";
                    com.tencent.mm.sdk.platformtools.x.d(r0, r1);
                    r1 = com.tencent.mm.ui.tools.ShareImgUI.this;
                    r0 = r3;
                L_0x0068:
                    r2 = r6;
                L_0x0069:
                    com.tencent.mm.ui.tools.ShareImgUI.a(r1, r0, r2);
                L_0x006c:
                    return;
                L_0x006d:
                    r0 = move-exception;
                    r1 = "MicroMsg.ShareImgUI";
                    r3 = "hy: timeout when getmulti";
                    r5 = new java.lang.Object[r10];
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r3, r5);
                    r0 = com.tencent.mm.ui.tools.ShareImgUI.this;
                    r1 = r3;
                    com.tencent.mm.ui.tools.ShareImgUI.a(r0, r1, r6);
                    goto L_0x0057;
                L_0x0081:
                    r0 = "MicroMsg.ShareImgUI";
                    r1 = "hy: getMultiSendFilePathList done. using: %d ms";
                    r3 = new java.lang.Object[r9];
                    r4 = java.lang.System.currentTimeMillis();
                    r8 = r4;
                    r4 = r4 - r8;
                    r4 = java.lang.Long.valueOf(r4);
                    r3[r10] = r4;
                    com.tencent.mm.sdk.platformtools.x.i(r0, r1, r3);
                    r1 = com.tencent.mm.ui.tools.ShareImgUI.this;
                    r0 = r3;
                    r3 = r2.size();
                    if (r3 <= 0) goto L_0x0068;
                L_0x00a3:
                    goto L_0x0069;
                L_0x00a4:
                    r0 = "MicroMsg.ShareImgUI";
                    r1 = "getParcelableArrayList failed";
                    com.tencent.mm.sdk.platformtools.x.e(r0, r1);
                    r0 = com.tencent.mm.ui.tools.ShareImgUI.this;
                    r1 = r3;
                    com.tencent.mm.ui.tools.ShareImgUI.a(r0, r1, r6);
                    goto L_0x006c;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.ShareImgUI.4.run():void");
                }
            }, "getMultiSendFilePathList");
        } else {
            x.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
            Hd(0);
            finish();
        }
    }

    private boolean cyR() {
        Intent intent = new Intent(this, ShareImgUI.class);
        if ("android.intent.action.SEND".equals(getIntent().getAction())) {
            if (bi.oN(this.filePath)) {
                return false;
            }
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
            intent.setAction("android.intent.action.SEND");
            intent.setType(getIntent().getType());
        } else if (!"android.intent.action.SEND_MULTIPLE".equals(getIntent().getAction()) || bi.cC(this.zpK)) {
            return false;
        } else {
            ArrayList arrayList = new ArrayList(this.zpK.size());
            Iterator it = this.zpK.iterator();
            while (it.hasNext()) {
                arrayList.add(Uri.fromFile(new File((String) it.next())));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.setType(getIntent().getType());
        }
        intent.addFlags(67108864);
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), intent);
        return true;
    }

    private static boolean aaA(String str) {
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        boolean b = p.b(str, decodeResultLogger);
        if (!b && decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            g.pWK.k(12712, KVStatHelper.getKVStatString(str, 3, decodeResultLogger));
        }
        return b;
    }

    private void aaH(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is empty");
        } else if (bi.WA(str)) {
            String str2 = "";
            int bN = com.tencent.mm.a.e.bN(str);
            x.i("MicroMsg.ShareImgUI", "filelength: [%d]", Integer.valueOf(bN));
            if (bN == 0) {
                x.e("MicroMsg.ShareImgUI", "dealWithFile fail, fileLength is 0");
            } else if (bN > 10485760) {
                x.e("MicroMsg.ShareImgUI", "summerbig dealWithFile fail, fileLength is too large fileLength[%d],filePath[%s] ", Integer.valueOf(bN), str);
                Toast.makeText(this, R.l.ePE, 1).show();
            } else {
                WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
                wXMediaMessage.title = new File(str).getName();
                if (str2.length() > 0) {
                    wXMediaMessage.description = str2;
                } else {
                    wXMediaMessage.description = bi.by((long) bN);
                }
                if (bN < 30720) {
                    wXMediaMessage.thumbData = com.tencent.mm.a.e.d(str, 0, -1);
                } else {
                    x.i("MicroMsg.ShareImgUI", "thumb data is exceed 30k, ignore");
                }
                Req req = new Req();
                req.transaction = null;
                req.message = wXMediaMessage;
                Bundle bundle = new Bundle();
                req.toBundle(bundle);
                bundle.putInt(ConstantsAPI.SDK_VERSION, 620823552);
                bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
                bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                Intent intent = new Intent();
                intent.setClass(this, SelectConversationUI.class);
                intent.putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
                if (!as.Ho() || as.Cz()) {
                    x.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                    MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
                    return;
                }
                startActivity(intent);
            }
        } else {
            x.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is refer to private file.");
        }
    }

    private String a(Uri uri, Cursor cursor) {
        AssetFileDescriptor openAssetFileDescriptor;
        FileNotFoundException e;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        IOException e2;
        Exception e3;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                try {
                    str = cursor.getString(columnIndex);
                } catch (Exception e4) {
                    x.w("MicroMsg.ShareImgUI", "try to get Vcard Name fail: %s", e4.getMessage());
                }
                if (!(str == null || str == null)) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                x.i("MicroMsg.ShareImgUI", "vcard file name: " + str);
            }
            cursor.close();
            try {
                openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
            } catch (IOException e6) {
                e2 = e6;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e7) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Exception e8) {
                e3 = e8;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                x.e("MicroMsg.ShareImgUI", e3.toString());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e9) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e10) {
                        throw th;
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
            try {
                fileInputStream = openAssetFileDescriptor.createInputStream();
                try {
                    as.Hm();
                    if (com.tencent.mm.y.c.isSDCardAvailable()) {
                        String str2 = com.tencent.mm.compatible.util.e.bnF + "share";
                        str = com.tencent.mm.compatible.util.e.bnF + "share/" + str;
                        File file = new File(str2);
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(str);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        fileOutputStream = new FileOutputStream(str, false);
                    } else {
                        deleteFile(str);
                        String str3 = getFilesDir().getPath() + "/" + str;
                        fileOutputStream = openFileOutput(str, 0);
                        str = str3;
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    fileOutputStream = null;
                    try {
                        x.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e12) {
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream2 = fileOutputStream;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (IOException e13) {
                    e2 = e13;
                    fileOutputStream = null;
                    x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Exception e14) {
                    e3 = e14;
                    fileOutputStream = null;
                    x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    x.e("MicroMsg.ShareImgUI", e3.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 5120);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e15) {
                            return str;
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream == null) {
                        return str;
                    }
                    fileOutputStream.close();
                    return str;
                } catch (FileNotFoundException e16) {
                    e = e16;
                    x.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (IOException e17) {
                    e2 = e17;
                    x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Exception e18) {
                    e3 = e18;
                    x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    x.e("MicroMsg.ShareImgUI", e3.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                fileOutputStream = null;
                fileInputStream = null;
            } catch (IOException e20) {
                e2 = e20;
                fileOutputStream = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Exception e21) {
                e3 = e21;
                fileOutputStream = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                x.e("MicroMsg.ShareImgUI", e3.toString());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        }
        return null;
    }

    private static int aaB(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ShareImgUI", "map : mimeType is null");
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.equalsIgnoreCase("image/gif")) {
            return 5;
        }
        if (toLowerCase.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            return 0;
        }
        if (toLowerCase.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            return 1;
        }
        x.d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
        return 3;
    }

    private void Hd(int i) {
        switch (i) {
            case 1:
                Toast.makeText(this, R.l.ePD, 1).show();
                return;
            default:
                Toast.makeText(this, R.l.ePF, 1).show();
                return;
        }
    }

    private void cyS() {
        Toast.makeText(this, R.l.dZW, 1).show();
        finish();
    }

    private void showDialog() {
        getString(R.l.dGZ);
        this.inI = h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                ShareImgUI.this.finish();
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        as.CN().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (e) this);
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
        }
        if (i == 0 && i2 == 0) {
            YC();
        } else {
            finish();
        }
    }
}
