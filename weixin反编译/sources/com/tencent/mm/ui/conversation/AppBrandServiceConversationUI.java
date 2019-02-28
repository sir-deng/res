package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.kz;
import com.tencent.mm.f.a.o;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.qi;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.conversation.d.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.s;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Keep
public final class AppBrandServiceConversationUI extends BaseConversationUI {
    private static final String TAG = "MicroMsg.AppBrandServiceConversationUI";
    private View contentView;

    @Keep
    public static class AppBrandServiceConversationFmUI extends b implements d {
        private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
        private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
        private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
        private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
        private d adapter;
        private com.tencent.mm.ui.appbrand.a appBrandServiceActionSheet;
        private ListView appbrandMessageLV;
        private l contextMenuHelper;
        private ae conversation;
        private TextView emptyTipTv;
        private int fromScene;
        private boolean isDeleteCancel = false;
        private String mAppId;
        private String mSceneId;
        private String superUsername;
        private String talker = "";
        private r tipDialog = null;

        private static class a extends d {
            List<String> gKH;
            private Paint jbA = new Paint();
            private String username;
            private c<kz> yyz;
            private HashMap<String, Boolean> zeK;
            private HashMap<String, String> zeL;

            a(Context context, String str, com.tencent.mm.ui.o.a aVar) {
                super(context, aVar);
                this.username = str;
                this.zeK = new HashMap();
                this.zeL = new HashMap();
                this.gKH = new ArrayList();
                this.yyz = new c<kz>() {
                    {
                        this.xmG = kz.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        boolean z = false;
                        kz kzVar = (kz) bVar;
                        if (kzVar.fDc.foe != null) {
                            x.d("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId:%s,event.newValue:%d", kzVar.fDc.foe, Integer.valueOf(kzVar.fDc.fDd));
                            if ((kzVar.fDc.fDd & 2) > 0) {
                                z = true;
                            }
                            a.this.zeK.remove(kzVar.fDc.foe);
                            a.this.zeK.put(kzVar.fDc.foe, Boolean.valueOf(z));
                            a.this.notifyDataSetChanged();
                        } else {
                            x.e("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId is null");
                        }
                        return true;
                    }
                };
                com.tencent.mm.sdk.b.a.xmy.b(this.yyz);
            }

            public final void XH() {
                as.Hm();
                setCursor(com.tencent.mm.y.c.Fk().c(s.hgZ, this.koG, this.username));
                if (this.xQN != null) {
                    this.xQN.XE();
                }
                super.notifyDataSetChanged();
            }

            protected final void a(String str, g gVar) {
                boolean z;
                Boolean bool = (Boolean) this.zeK.get(str);
                if (bool == null) {
                    WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(str);
                    z = rf != null && (rf.field_appOpt & 2) > 0;
                    this.zeK.put(str, bool);
                } else {
                    z = bool.booleanValue();
                }
                if (z) {
                    gVar.ywg.setVisibility(0);
                    gVar.ywg.setImageResource(R.k.dxz);
                } else {
                    gVar.ywg.setVisibility(8);
                }
                CharSequence charSequence = (String) this.zeL.get(str);
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = com.tencent.mm.ui.appbrand.b.Zj(com.tencent.mm.ui.appbrand.b.Zi(str));
                    if (!TextUtils.isEmpty(charSequence)) {
                        this.zeL.put(str, charSequence);
                    }
                }
                LayoutParams layoutParams;
                if (TextUtils.isEmpty(charSequence)) {
                    layoutParams = (LayoutParams) gVar.ywd.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.weight = 0.0f;
                    gVar.ywd.setLayoutParams(layoutParams);
                } else {
                    int i;
                    int dimensionPixelOffset;
                    int dimensionPixelOffset2;
                    float f;
                    float f2;
                    float f3;
                    gVar.zgq.setVisibility(0);
                    gVar.zgq.setText(this.context.getString(R.l.dEx, new Object[]{charSequence}));
                    if (this.context.getResources().getDisplayMetrics() != null) {
                        i = this.context.getResources().getDisplayMetrics().widthPixels;
                    } else {
                        i = 0;
                    }
                    if (com.tencent.mm.bu.a.ez(this.context)) {
                        dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.f.bvF);
                        dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.f.buE);
                    } else {
                        dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.f.bvG);
                        dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.f.buF);
                    }
                    int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(R.f.bvw);
                    int dimensionPixelOffset4 = this.context.getResources().getDimensionPixelOffset(R.f.bvK);
                    d dVar = (d) this.yvZ.get(str);
                    String charSequence2 = (dVar == null || dVar.nickName == null) ? "" : dVar.nickName.toString();
                    if (charSequence2 == null) {
                        f = 0.0f;
                    } else {
                        this.jbA.setTextSize(this.yvW);
                        f = this.jbA.measureText(charSequence2);
                    }
                    float f4 = 48.0f + f;
                    int dimensionPixelOffset5 = this.context.getResources().getDimensionPixelOffset(R.f.buF);
                    int dimensionPixelOffset6 = this.context.getResources().getDimensionPixelOffset(R.f.bvA);
                    x.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", Integer.valueOf(i), Integer.valueOf(dimensionPixelOffset), Integer.valueOf(dimensionPixelOffset2));
                    f = 0.0f;
                    if (i > 0) {
                        f = (float) ((((i - dimensionPixelOffset) - dimensionPixelOffset3) - dimensionPixelOffset4) - dimensionPixelOffset2);
                    }
                    if (f4 > f || f4 >= f || f <= 0.0f) {
                        f2 = 0.6f;
                        f3 = 0.4f;
                    } else {
                        f3 = Math.min(f4 / f, (((f - ((float) dimensionPixelOffset5)) - ((float) dimensionPixelOffset6)) - 48.0f) / f);
                        f2 = f3;
                        f3 = 1.0f - f3;
                    }
                    layoutParams = (LayoutParams) gVar.ywd.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = f2;
                    gVar.ywd.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) gVar.zgq.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = f3;
                    gVar.zgq.setLayoutParams(layoutParams);
                }
                com.tencent.mm.pluginsdk.ui.a.b.o(gVar.ikK, str);
                if (!this.gKH.contains(str)) {
                    this.gKH.add(str);
                }
            }

            public final void detach() {
                this.zeK = null;
                com.tencent.mm.sdk.b.a.xmy.c(this.yyz);
            }
        }

        public void onActivityCreated(Bundle bundle) {
            x.i(TAG, "onActivityCreated");
            super.onActivityCreated(bundle);
            this.superUsername = getStringExtra("Contact_User");
            if (TextUtils.isEmpty(this.superUsername)) {
                this.superUsername = "appbrandcustomerservicemsg";
            }
            this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
            x.i(TAG, "fromScene:%d", Integer.valueOf(this.fromScene));
            as.Hm();
            this.mSceneId = System.currentTimeMillis() + intToString(com.tencent.mm.y.c.Cn());
            initView();
            addIconOptionMenu(1, R.k.dvS, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(AppBrandServiceConversationFmUI.this.getContext(), ServiceNotifySettingsUI.class);
                    intent.putExtra("mode", 1);
                    intent.putExtra("scene_id", AppBrandServiceConversationFmUI.this.mSceneId);
                    AppBrandServiceConversationFmUI.this.startActivity(intent);
                    return true;
                }
            });
            as.Hm();
            com.tencent.mm.y.c.Fk().a(this.adapter);
            cleadAllServiceAppBrandUnreadCount();
            enterConversationReport();
            batchSyncForWxaContact();
        }

        private void cleadAllServiceAppBrandUnreadCount() {
            com.tencent.mm.sdk.b.a.xmy.m(new o());
        }

        protected int getLayoutId() {
            return R.i.dtj;
        }

        public String getUserName() {
            return this.superUsername;
        }

        public void onDestroy() {
            if (as.Hp()) {
                as.Hm();
                com.tencent.mm.y.c.Fk().b(this.adapter);
            }
            batchSyncForWxaContact();
            if (this.adapter != null) {
                this.adapter.onDestroy();
            }
            super.onDestroy();
        }

        public void onResume() {
            x.i(TAG, "on resume");
            if (this.adapter != null) {
                this.adapter.onResume();
            }
            super.onResume();
        }

        public void onPause() {
            x.i(TAG, "on pause");
            as.Hm();
            com.tencent.mm.y.c.Fk().XH(this.superUsername);
            if (this.adapter != null) {
                this.adapter.onPause();
            }
            super.onPause();
        }

        private void batchSyncForWxaContact() {
            if (this.adapter != null && this.adapter.getCount() != 0) {
                x.i(TAG, "batchSyncForWxaContact, size:%d", Integer.valueOf(this.adapter.getCount()));
                if (this.adapter instanceof a) {
                    List list = ((a) this.adapter).gKH;
                    if (list != null && list.size() > 0) {
                        ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).ab(list);
                    }
                }
            }
        }

        private String intToString(int i) {
            return new BigInteger(Integer.toBinaryString(i), 2).toString();
        }

        private void enterConversationReport() {
            String str = "";
            if (this.adapter == null) {
                x.d(TAG, "adapter is null!");
                return;
            }
            int i;
            Object obj;
            int i2;
            as.Hm();
            ak XF = com.tencent.mm.y.c.Fk().XF("appbrandcustomerservicemsg");
            if (XF == null || bi.oN(XF.field_username)) {
                i = 0;
            } else {
                i = XF.field_unReadCount;
            }
            ae aeVar = (ae) this.adapter.getItem(0);
            if (aeVar == null || bi.oN(aeVar.field_username)) {
                String obj2 = str;
            } else {
                String oM = bi.oM(aeVar.field_content);
                WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(aeVar.field_username);
                this.mAppId = rf == null ? null : rf.field_appId;
                obj2 = oM;
            }
            if (i > 0) {
                int count = this.adapter.getCount();
                int i3 = 0;
                i2 = 0;
                while (i3 < count) {
                    int i4;
                    aeVar = (ae) this.adapter.getItem(i3);
                    if (aeVar.field_unReadMuteCount + aeVar.field_unReadCount > 0) {
                        i4 = i2 + 1;
                    } else {
                        i4 = i2;
                    }
                    i3++;
                    i2 = i4;
                }
            } else {
                i2 = 0;
            }
            x.d(TAG, "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", Integer.valueOf(13797), this.mSceneId, Integer.valueOf(i), Integer.valueOf(i2), this.mAppId, obj2);
            com.tencent.mm.plugin.report.service.g.pWK.h(13797, this.mSceneId, Integer.valueOf(i), Integer.valueOf(i2), this.mAppId, Long.valueOf(bi.Wx()), Integer.valueOf(0), obj2);
        }

        public void customerMsgOperateReport(int i) {
            x.d(TAG, "stev report(%s), eventId : %s, appId %s, sceneId %s", Integer.valueOf(13798), Integer.valueOf(i), this.mAppId, this.mSceneId);
            com.tencent.mm.plugin.report.service.g.pWK.h(13798, Integer.valueOf(i), this.mAppId, Integer.valueOf(0), this.mSceneId, Long.valueOf(bi.Wx()));
        }

        public void entryCustomerMsgDialogReport(String str, int i) {
            as.Hm();
            ak XF = com.tencent.mm.y.c.Fk().XF(str);
            if (XF == null) {
                x.e(TAG, "cvs:%s is null, error", str);
                return;
            }
            int i2 = XF.field_unReadCount;
            String oM = bi.oM(this.mSceneId);
            x.d(TAG, "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", Integer.valueOf(13799), this.mAppId, Integer.valueOf(i), Integer.valueOf(i2), oM);
            com.tencent.mm.plugin.report.service.g.pWK.h(13799, this.mAppId, Integer.valueOf(i), Integer.valueOf(i2), oM, Long.valueOf(bi.Wx()));
        }

        protected void initView() {
            setMMTitle(getString(R.l.dEb));
            this.appbrandMessageLV = (ListView) findViewById(R.h.cSC);
            this.emptyTipTv = (TextView) findViewById(R.h.ceo);
            this.emptyTipTv.setText(R.l.dEd);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppBrandServiceConversationFmUI.this.finish();
                    return true;
                }
            });
            this.appBrandServiceActionSheet = new com.tencent.mm.ui.appbrand.a(thisActivity());
            this.adapter = new a(thisActivity(), this.superUsername, new com.tencent.mm.ui.o.a() {
                public final void XE() {
                    AppBrandServiceConversationFmUI.this.setShowView(AppBrandServiceConversationFmUI.this.adapter.getCount());
                }

                public final void XF() {
                }
            });
            this.adapter.a(new MMSlideDelView.c() {
                public final int ci(View view) {
                    return AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(view);
                }
            });
            this.adapter.a(new f() {
                public final void t(View view, int i) {
                    AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(view, i, 0);
                }
            });
            this.appbrandMessageLV.setAdapter(this.adapter);
            this.contextMenuHelper = new l(thisActivity());
            this.appbrandMessageLV.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppBrandServiceConversationFmUI.this.conversation = (ae) AppBrandServiceConversationFmUI.this.adapter.getItem(i);
                    ak access$400 = AppBrandServiceConversationFmUI.this.conversation;
                    if (access$400 == null) {
                        x.e(AppBrandServiceConversationFmUI.TAG, "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(AppBrandServiceConversationFmUI.this.adapter.getCount()));
                        AppBrandServiceConversationFmUI.this.adapter.notifyDataSetChanged();
                        return;
                    }
                    AppBrandServiceConversationFmUI.this.talker = access$400.field_username;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("finish_direct", false);
                    bundle.putBoolean("key_need_send_video", false);
                    bundle.putString("key_scene_id", AppBrandServiceConversationFmUI.this.mSceneId);
                    bundle.putInt("app_brand_chatting_from_scene", AppBrandServiceConversationFmUI.this.fromScene);
                    AppBrandServiceConversationFmUI.this.ui.startChatting(access$400.field_username, bundle, true);
                    AppBrandServiceConversationFmUI.this.entryCustomerMsgDialogReport(access$400.field_username, AppBrandServiceConversationFmUI.this.fromScene);
                }
            });
            this.appbrandMessageLV.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppBrandServiceConversationFmUI.this.conversation = (ae) AppBrandServiceConversationFmUI.this.adapter.getItem(i);
                    AppBrandServiceConversationFmUI.this.talker = AppBrandServiceConversationFmUI.this.conversation.field_username;
                    AppBrandServiceConversationFmUI.this.contextMenuHelper.a(view, i, j, AppBrandServiceConversationFmUI.this, AppBrandServiceConversationFmUI.this);
                    return true;
                }
            });
            this.adapter.a(new MMSlideDelView.c() {
                public final int ci(View view) {
                    return AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(view);
                }
            });
            this.adapter.a(new f() {
                public final void t(View view, int i) {
                    AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(view, i, 0);
                }
            });
            this.adapter.a(new e() {
                public final void bp(Object obj) {
                    if (obj == null) {
                        x.e(AppBrandServiceConversationFmUI.TAG, "onItemDel object null");
                        return;
                    }
                    AppBrandServiceConversationFmUI.this.delConversationAndMsg(obj.toString());
                }
            });
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (!(this.talker == null || this.talker.isEmpty())) {
                this.talker = "";
            }
            if (i2 == -1) {
            }
        }

        private void setShowView(int i) {
            if (i <= 0) {
                this.emptyTipTv.setVisibility(0);
                this.appbrandMessageLV.setVisibility(8);
                return;
            }
            this.emptyTipTv.setVisibility(8);
            this.appbrandMessageLV.setVisibility(0);
        }

        private void delConversationAndMsg(String str) {
            if (bi.oN(str)) {
                x.e(TAG, "Delete Conversation and messages fail because username is null or nil.");
                return;
            }
            asyncDelMsg(str);
            as.Hm();
            com.tencent.mm.y.c.Fk().XE(str);
        }

        private void asyncDelMsg(String str) {
            x.i(TAG, "async del msg talker:%s", str);
            as.Hm();
            cg Fc = com.tencent.mm.y.c.Fh().Fc(str);
            com.tencent.mm.bp.a qiVar = new qi();
            qiVar.wfM = new bet().Vf(bi.oM(str));
            qiVar.vNT = Fc.field_msgSvrId;
            as.Hm();
            com.tencent.mm.y.c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(8, qiVar));
            this.isDeleteCancel = false;
            Context thisActivity = thisActivity();
            getString(R.l.dGZ);
            final ProgressDialog a = h.a(thisActivity, getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppBrandServiceConversationFmUI.this.isDeleteCancel = true;
                }
            });
            customerMsgOperateReport(5);
            bb.a(str, new com.tencent.mm.y.bb.a() {
                public final boolean HH() {
                    return AppBrandServiceConversationFmUI.this.isDeleteCancel;
                }

                public final void HG() {
                    if (a != null) {
                        a.dismiss();
                    }
                }
            });
        }

        public void onMMMenuItemSelected(MenuItem menuItem, int i) {
            as.Hm();
            com.tencent.mm.k.a Xv = com.tencent.mm.y.c.Ff().Xv(this.talker);
            if (Xv == null || ((int) Xv.gKO) == 0) {
                x.e(TAG, "changed biz stick status failed, contact is null, talker = " + this.talker);
                return;
            }
            switch (menuItem.getItemId()) {
                case 1:
                    this.appBrandServiceActionSheet.username = this.talker;
                    this.appBrandServiceActionSheet.scene = this.fromScene;
                    this.appBrandServiceActionSheet.yeh = this.mSceneId;
                    this.appBrandServiceActionSheet.klg = true;
                    this.appBrandServiceActionSheet.show(3);
                    return;
                case 2:
                    this.appBrandServiceActionSheet.username = this.talker;
                    this.appBrandServiceActionSheet.scene = this.fromScene;
                    this.appBrandServiceActionSheet.yeh = this.mSceneId;
                    this.appBrandServiceActionSheet.klg = true;
                    this.appBrandServiceActionSheet.show(4);
                    return;
                case 3:
                    delConversationAndMsg(this.talker);
                    return;
                default:
                    return;
            }
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(this.talker);
            int i = (rf == null || (rf.field_appOpt & 2) <= 0) ? 0 : 1;
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.dEh);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.dEi);
            }
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.dYG);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.contentView = v.fw(this).inflate(R.i.dbx, null);
        setContentView(this.contentView);
        this.conversationFm = new AppBrandServiceConversationFmUI();
        getSupportFragmentManager().aT().a(R.h.cwx, this.conversationFm).commit();
        com.tencent.mm.pluginsdk.e.a(this, this.contentView);
    }

    public final void finish() {
        super.finish();
    }

    protected final a getChattingUIFragment() {
        return new AppBrandServiceChattingUI.a();
    }
}
