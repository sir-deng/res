package com.tencent.mm.ui.voicesearch;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VoiceSearchResultUI extends MMActivity {
    private int hLe = 2;
    private TextView lmw;
    private int mhz = -1;
    int showType = 1;
    private String zzA = null;
    private b zzL;
    private String[] zzM;
    private boolean zzN = false;
    boolean zzO = false;
    private ListView zzy;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.zzN = false;
    }

    protected final void initView() {
        this.zzy = (ListView) findViewById(R.h.cXd);
        this.lmw = (TextView) findViewById(R.h.cez);
        this.zzM = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
        this.zzA = getIntent().getStringExtra("VoiceSearchResultUI_Error");
        this.mhz = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
        this.showType = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
        this.hLe = this.showType == 1 ? 2 : 1;
        this.zzO = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
        x.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", Integer.valueOf(this.showType), Boolean.valueOf(this.zzO));
        this.zzL = new b(getApplicationContext(), this.showType);
        this.zzL.nH(false);
        List linkedList = new LinkedList();
        switch (this.showType) {
            case 2:
                linkedList.add("lbsapp");
                linkedList.add("shakeapp");
                linkedList.add("qqfriend");
                linkedList.add("facebookapp");
                linkedList.add("feedsapp");
                linkedList.add("fmessage");
                linkedList.add("voipapp");
                linkedList.add("voicevoipapp");
                linkedList.add("voiceinputapp");
                linkedList.add("linkedinplugin");
                linkedList.add("notifymessage");
                int Gj = q.Gj();
                if ((Gj & 1) != 0) {
                    linkedList.add("qqmail");
                }
                if (!(s.GM() && (Gj & 2) == 0)) {
                    linkedList.add("tmessage");
                }
                if ((Gj & 32) != 0) {
                    linkedList.add("qmessage");
                }
                if ((Gj & FileUtils.S_IWUSR) != 0) {
                    linkedList.add("qqsync");
                }
                if ((Gj & 16) != 0) {
                    linkedList.add("medianote");
                }
                if ((SQLiteGlobal.journalSizeLimit & Gj) != 0) {
                    linkedList.add("newsapp");
                }
                if (!((262144 & Gj) == 0 && s.GL())) {
                    linkedList.add("blogapp");
                }
                if ((65536 & Gj) != 0) {
                    linkedList.add("masssendapp");
                }
                if ((Gj & 33554432) != 0) {
                    linkedList.add("voiceinputapp");
                    break;
                }
                break;
        }
        if (this.zzL != null) {
            this.zzL.dv(linkedList);
        }
        this.zzy.setAdapter(this.zzL);
        this.lmw.setVisibility(8);
        x.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.mhz);
        if (this.showType == 2) {
            setMMTitle("");
            this.zzM = K(this.zzM);
        } else {
            setMMTitle(getString(R.l.dtS));
        }
        setMMTitle(getString(R.l.dtS));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!VoiceSearchResultUI.this.zzN) {
                    g.pWK.k(10452, VoiceSearchResultUI.this.hLe + "," + VoiceSearchResultUI.this.mhz + "," + (VoiceSearchResultUI.this.zzM == null ? 0 : VoiceSearchResultUI.this.zzM.length) + ",0");
                }
                if (VoiceSearchResultUI.this.zzO) {
                    VoiceSearchResultUI.this.moveTaskToBack(true);
                }
                VoiceSearchResultUI.this.finish();
                return true;
            }
        });
        this.zzy.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!VoiceSearchResultUI.this.zzN) {
                    g.pWK.k(10452, VoiceSearchResultUI.this.hLe + "," + VoiceSearchResultUI.this.mhz + "," + (VoiceSearchResultUI.this.zzM == null ? 0 : VoiceSearchResultUI.this.zzM.length) + "," + i);
                }
                ag oz = VoiceSearchResultUI.this.zzL.oz(i);
                Context context = VoiceSearchResultUI.this;
                String str = oz.field_username;
                String AX = oz.AX();
                if (str != null && str.length() > 0) {
                    x.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact " + str);
                    Intent intent;
                    if (context.showType == 3) {
                        intent = new Intent();
                        intent.putExtra("Select_Conv_User", str);
                        context.setResult(-1, intent);
                        context.finish();
                    } else if (context.showType != 1 && !s.hr(str) && !s.gI(str) && !s.eX(str) && !s.gF(str) && !VoiceSearchResultUI.aaT(AX)) {
                        Intent intent2 = new Intent(context, SearchConversationResultUI.class);
                        intent2.putExtra("SearchConversationResult_User", AX);
                        context.startActivity(intent2);
                    } else if (context.showType == 1) {
                        intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        if (s.gF(str)) {
                            intent.putExtra("Is_group_card", true);
                        }
                        if (str != null && str.length() > 0) {
                            e.a(intent, str);
                            if (context.zzO) {
                                context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                                context.finish();
                                return;
                            }
                            d.b(context, "profile", ".ui.ContactInfoUI", intent);
                        }
                    } else if (context.showType != 2) {
                    } else {
                        if (bi.oN(str)) {
                            x.e("MicroMsg.VoiceSearchResultUI", "username is null " + str);
                        } else if (s.gN(str)) {
                            if (q.Gr()) {
                                d.b(context.mController.xRr, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (s.gP(str)) {
                            if (q.Go()) {
                                d.b(context.mController.xRr, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (s.gO(str)) {
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (s.gT(str)) {
                            MMAppMgr.cancelNotification(str);
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (s.gL(str)) {
                            if (q.GA()) {
                                context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (s.gY(str)) {
                            if (q.Gv()) {
                                intent = new Intent();
                                intent.putExtra(Columns.TYPE, 20);
                                d.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                                return;
                            }
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (s.hf(str)) {
                            if (q.Gw()) {
                                intent = new Intent();
                                intent.putExtra(Columns.TYPE, 11);
                                d.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                                return;
                            }
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (s.gQ(str)) {
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else if (s.gR(str)) {
                            if (q.Gy()) {
                                d.b(context, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (s.gX(str)) {
                            if (q.Gs()) {
                                context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                            }
                        } else if (s.gV(str) || s.gW(str) || s.gS(str) || s.gZ(str) || s.ha(str) || s.gM(str) || s.hi(str)) {
                            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        } else {
                            context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                        }
                    }
                }
            }
        });
        L(this.zzM);
    }

    private static String[] K(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        x.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + strArr.length);
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (String str : strArr) {
            String gw = r.gw(str);
            x.d("MicroMsg.VoiceSearchResultUI", "displayname " + gw);
            if (!hashMap.containsValue(gw) || !s.eX(str)) {
                x.d("MicroMsg.VoiceSearchResultUI", "username " + str);
                hashMap.put(gw, str);
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void onDestroy() {
        super.onDestroy();
        this.zzL.aUU();
    }

    public void onPause() {
        super.onPause();
        this.zzN = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (!this.zzN) {
                g.pWK.k(10452, this.hLe + "," + this.mhz + "," + (this.zzM == null ? 0 : this.zzM.length) + ",0");
            }
            if (this.zzO) {
                moveTaskToBack(true);
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    static boolean aaT(String str) {
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = as.Hm().hgk.a(s.hgU, null, str);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!string.endsWith("@chatroom")) {
                    arrayList2.add(string);
                }
                x.d("MicroMsg.VoiceSearchResultUI", "block user " + string);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceSearchResultUI", e, "", new Object[0]);
            }
        }
        cursorArr[1] = as.Hm().hgl.a(str, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        int count = cursorArr[1].getCount();
        int count2 = cursorArr[0].getCount();
        cursorArr[0].close();
        cursorArr[1].close();
        x.d("MicroMsg.VoiceSearchResultUI", "contactCount " + count + " conversationCount " + count2);
        if (count + count2 <= 1) {
            return true;
        }
        return false;
    }

    private void L(String[] strArr) {
        List arrayList = new ArrayList();
        if (!(strArr == null || this.zzL == null)) {
            for (String str : strArr) {
                if (this.zzL.aaS(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.lmw.setVisibility(0);
            if (this.zzA != null) {
                this.lmw.setText(this.zzA);
            } else {
                this.lmw.setText(getString(R.l.dDf));
            }
        } else {
            this.lmw.setVisibility(8);
        }
        if (this.zzL != null) {
            this.zzL.dH(arrayList);
        }
    }

    protected final int getLayoutId() {
        return R.i.dtS;
    }
}
