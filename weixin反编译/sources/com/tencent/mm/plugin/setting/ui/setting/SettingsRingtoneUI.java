package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.j.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p.b;

public class SettingsRingtoneUI extends MMActivity implements OnItemClickListener, Runnable {
    private Cursor BA;
    private ag mHandler;
    private RingtoneManager qqG;
    LayoutInflater qqH;
    private int qqI = -1;
    private int qqJ = -1;
    private Ringtone qqK;

    private class a extends BaseAdapter {
        int count = 0;
        Cursor fui;
        int padding = 0;

        public final /* synthetic */ Object getItem(int i) {
            return kF(i);
        }

        public a(Cursor cursor) {
            this.fui = cursor;
            this.count = cursor.getCount() + 1;
            x.d("RingtonePickerActivity", "count = " + this.count);
            this.padding = SettingsRingtoneUI.this.getResources().getDimensionPixelSize(R.f.bvK);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) SettingsRingtoneUI.this.qqH.inflate(R.i.select_dialog_singlechoice, null);
            if (i == 0) {
                checkedTextView.setBackgroundResource(R.g.bBy);
                checkedTextView.setText(R.l.eMt);
            } else {
                checkedTextView.setBackgroundResource(R.g.bBy);
                checkedTextView.setText(kF(i));
            }
            checkedTextView.setPadding(this.padding, 0, this.padding, 0);
            checkedTextView.setCheckMarkDrawable(R.g.bFt);
            return checkedTextView;
        }

        public final int getCount() {
            return this.count;
        }

        private String kF(int i) {
            if (this.fui.isClosed() || !this.fui.moveToPosition(i - 1)) {
                return "";
            }
            return this.fui.getString(this.fui.getColumnIndex("title"));
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ag();
        this.qqH = LayoutInflater.from(this);
        this.qqG = new RingtoneManager(this);
        this.qqG.setType(2);
        setVolumeControlStream(5);
        this.qqK = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(2));
        setMMTitle(R.l.eMu);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsRingtoneUI.this.aWY();
                SettingsRingtoneUI.this.finish();
                return true;
            }
        });
        a(0, getString(R.l.eLO), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String uri;
                Editor edit = SettingsRingtoneUI.this.getSharedPreferences(ad.cgf(), 0).edit();
                if (SettingsRingtoneUI.this.qqJ != 0) {
                    Uri a = SettingsRingtoneUI.this.qqG.getRingtoneUri(SettingsRingtoneUI.this.qqJ - 1);
                    x.d("RingtonePickerActivity", "set ringtone to " + a);
                    if (a != null) {
                        uri = a.toString();
                        String a2 = RingtoneManager.getRingtone(SettingsRingtoneUI.this, a).getTitle(SettingsRingtoneUI.this);
                        edit.putString("settings.ringtone.name", a2);
                        x.d("RingtonePickerActivity", "ringtone name: " + a2);
                    } else {
                        uri = f.gJJ;
                        edit.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(R.l.eMt));
                        x.d("RingtonePickerActivity", "set ringtone follow system");
                    }
                } else {
                    uri = f.gJJ;
                    edit.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(R.l.eMt));
                    x.d("RingtonePickerActivity", "set ringtone follow system");
                }
                edit.commit();
                f.eQ(uri);
                SettingsRingtoneUI.this.finish();
                return true;
            }
        }, b.xSe);
        ListView listView = (ListView) findViewById(R.h.cMF);
        View view = new View(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvw);
        view.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        View view2 = new View(this);
        view2.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        view.setClickable(false);
        view2.setClickable(false);
        listView.addHeaderView(view);
        listView.addFooterView(view2);
        this.BA = this.qqG.getCursor();
        listView.setAdapter(new a(this.BA));
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
        String zz = com.tencent.mm.j.a.zz();
        if (zz != f.gJJ) {
            int ringtonePosition = this.qqG.getRingtonePosition(Uri.parse(zz));
            if (ringtonePosition >= 0) {
                ringtonePosition += 2;
            } else {
                ringtonePosition = 1;
            }
            this.qqI = ringtonePosition;
            if (this.qqI == 1) {
                getSharedPreferences(ad.cgf(), 0).edit().putString("settings.ringtone.name", getString(R.l.eMt)).commit();
                x.d("RingtonePickerActivity", "set ringtone follow system");
            }
            this.qqJ = this.qqI - 1;
        } else {
            this.qqI = 1;
        }
        listView.setItemChecked(this.qqI, true);
        listView.setSelection(this.qqI);
    }

    protected final int getLayoutId() {
        return R.i.dsp;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mHandler.removeCallbacks(this);
        this.qqJ = i - 1;
        this.mHandler.postDelayed(this, 300);
    }

    public void run() {
        if (!isFinishing()) {
            Ringtone ringtone;
            if (this.qqJ == 0) {
                ringtone = this.qqK;
            } else {
                ringtone = this.qqG.getRingtone(this.qqJ - 1);
            }
            if (ringtone != null) {
                try {
                    ringtone.play();
                } catch (Throwable e) {
                    x.printErrStackTrace("RingtonePickerActivity", e, "play ringtone error", new Object[0]);
                }
            }
        }
    }

    protected void onStop() {
        this.qqG.stopPreviousRingtone();
        super.onStop();
    }

    protected void onDestroy() {
        this.mHandler.removeCallbacks(this);
        if (!(this.BA == null || this.BA.isClosed())) {
            this.BA.close();
            this.BA = null;
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25) {
            return super.onKeyUp(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
