package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.nx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class SettingsChattingUI extends MMPreference {
    private f inW;
    private boolean isDeleteCancel = false;
    private ProgressDialog qob = null;

    static /* synthetic */ void b(SettingsChattingUI settingsChattingUI) {
        as.Hm();
        List cju = c.Fk().cju();
        if (cju.size() > 0) {
            List A = l.A(cju);
            if (A != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= A.size()) {
                        break;
                    }
                    if (((Boolean) A.get(i2)).booleanValue()) {
                        a.ihO.cB((String) cju.get(i2));
                    }
                    i = i2 + 1;
                }
            }
        }
        bb.a(new bb.a() {
            public final boolean HH() {
                return SettingsChattingUI.this.isDeleteCancel;
            }

            public final void HG() {
                if (SettingsChattingUI.this.qob != null) {
                    SettingsChattingUI.this.qob.dismiss();
                    SettingsChattingUI.this.qob = null;
                }
                com.tencent.mm.sdk.b.a.xmy.m(new nx());
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (g.Do().CF()) {
            initView();
        } else {
            finish();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.eLo);
        this.inW = this.yrJ;
        if (g.Dq().Db().getInt(89, 0) != 2) {
            this.inW.Zv("settings_recovery");
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsChattingUI.this.aWY();
                SettingsChattingUI.this.finish();
                return true;
            }
        });
    }

    protected void onResume() {
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            as.Hm();
            checkBoxPreference.tYU = ((Boolean) c.Db().get(26, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.ysp = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_enter_button_send");
        if (checkBoxPreference != null) {
            as.Hm();
            checkBoxPreference.tYU = ((Boolean) c.Db().get(66832, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.ysp = false;
        }
        Preference Zu = this.inW.Zu("settings_text_size");
        if (Zu != null) {
            Zu.setSummary(getString(SetTextSizeUI.dv(this)));
        }
        this.inW.notifyDataSetChanged();
    }

    public final int XK() {
        return R.o.fcC;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.idX;
        boolean z2 = true;
        switch (str.hashCode()) {
            case -1776646462:
                if (str.equals("settings_chatting_bg")) {
                    z2 = true;
                    break;
                }
                break;
            case -1565531065:
                if (str.equals("settings_bak_chat")) {
                    z2 = true;
                    break;
                }
                break;
            case -1550690765:
                if (str.equals("settings_reset")) {
                    z2 = true;
                    break;
                }
                break;
            case -1439483675:
                if (str.equals("settings_voice_play_mode")) {
                    z2 = false;
                    break;
                }
                break;
            case -409015247:
                if (str.equals("settings_recovery")) {
                    z2 = true;
                    break;
                }
                break;
            case 624882802:
                if (str.equals("settings_enter_button_send")) {
                    z2 = true;
                    break;
                }
                break;
            case 1789437336:
                if (str.equals("settings_emoji_manager")) {
                    z2 = true;
                    break;
                }
                break;
        }
        Intent intent;
        switch (z2) {
            case false:
                as.Hm();
                boolean booleanValue = ((Boolean) c.Db().get(26, Boolean.valueOf(false))).booleanValue();
                String str2 = "MicroMsg.SettingsChattingUI";
                String str3 = "set voice mode from %B to %B";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(booleanValue);
                objArr[1] = Boolean.valueOf(!booleanValue);
                x.d(str2, str3, objArr);
                as.Hm();
                t Db = c.Db();
                if (!booleanValue) {
                    z = true;
                }
                Db.set(26, Boolean.valueOf(z));
                return true;
            case true:
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_enter_button_send");
                if (checkBoxPreference == null) {
                    return true;
                }
                x.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", Boolean.valueOf(checkBoxPreference.isChecked()));
                as.Hm();
                c.Db().set(66832, Boolean.valueOf(z2));
                return true;
            case true:
                MMWizardActivity.A(this.mController.xRr, new Intent().setClassName(this.mController.xRr, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI"));
                return true;
            case true:
                intent = new Intent();
                intent.setClass(this, SettingsChattingBackgroundUI.class);
                this.mController.xRr.startActivity(intent);
                return true;
            case true:
                intent = new Intent();
                intent.putExtra("10931", 2);
                d.b(this.mController.xRr, "emoji", ".ui.EmojiMineUI", intent);
                return true;
            case true:
                h.a(this.mController.xRr, getResources().getString(R.l.eNd), "", getString(R.l.dEz), getString(R.l.dEy), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ArrayList arrayList;
                        com.tencent.mm.plugin.report.service.g.pWK.h(14553, Integer.valueOf(5), Integer.valueOf(2), "");
                        com.tencent.mm.plugin.report.service.g.pWK.a(324, 0, 1, false);
                        SettingsChattingUI.this.isDeleteCancel = false;
                        SettingsChattingUI settingsChattingUI = SettingsChattingUI.this;
                        Context context = SettingsChattingUI.this;
                        SettingsChattingUI.this.getString(R.l.dGZ);
                        settingsChattingUI.qob = h.a(context, SettingsChattingUI.this.getString(R.l.dHn), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                SettingsChattingUI.this.isDeleteCancel = true;
                            }
                        });
                        as.Hm();
                        List<au> bab = c.Fh().bab();
                        if (bab != null) {
                            x.i("MicroMsg.WalletConvDelCheckLogic", "checkGetUnProcessorWalletConversation, msgInfoList size: %s", Integer.valueOf(bab.size()));
                            Collection hashSet = new HashSet();
                            for (au auVar : bab) {
                                if (!hashSet.contains(auVar.field_talker)) {
                                    as.Hm();
                                    if (c.Fk().XF(auVar.field_talker) != null && e.ab(auVar)) {
                                        hashSet.add(auVar.field_talker);
                                    }
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(hashSet);
                            arrayList = arrayList2;
                        } else {
                            arrayList = null;
                        }
                        if (arrayList == null || arrayList.size() <= 0) {
                            SettingsChattingUI.b(SettingsChattingUI.this);
                            return;
                        }
                        SettingsChattingUI.this.qob.dismiss();
                        h.a(SettingsChattingUI.this, false, SettingsChattingUI.this.getString(R.l.eWx, new Object[]{Integer.valueOf(arrayList.size())}), null, SettingsChattingUI.this.getString(R.l.enQ), SettingsChattingUI.this.getString(R.l.dUd), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.plugin.report.service.g.pWK.h(14553, Integer.valueOf(5), Integer.valueOf(4), "");
                                SettingsChattingUI.this.isDeleteCancel = true;
                                if (arrayList.size() <= 1) {
                                    Intent intent = new Intent();
                                    intent.putExtra("Chat_User", (String) arrayList.get(0));
                                    intent.addFlags(67108864);
                                    d.a(SettingsChattingUI.this, ".ui.chatting.ChattingUI", intent);
                                    return;
                                }
                                Intent intent2 = new Intent();
                                intent2.putStringArrayListExtra("key_conversation_list", arrayList);
                                d.a(SettingsChattingUI.this, ".ui.conversation.SettingCheckUnProcessWalletConvUI", intent2);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.plugin.report.service.g.pWK.h(14553, Integer.valueOf(5), Integer.valueOf(3), "");
                                SettingsChattingUI.this.qob.show();
                                SettingsChattingUI.this.isDeleteCancel = false;
                                SettingsChattingUI.b(SettingsChattingUI.this);
                            }
                        }, -1, R.e.brm);
                    }
                }, null);
                return true;
            case true:
                intent = new Intent().setClassName(this.mController.xRr, "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
                intent.putExtra("scene", 1);
                this.mController.xRr.startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}
