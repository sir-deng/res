package com.tencent.mm.ui.bindgooglecontact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.protocal.c.apg;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.friend.InviteFriendUI;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.y.as;
import com.tencent.rtmp.TXLiveConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkUpdater;

public class GoogleFriendUI extends MMActivity implements OnItemClickListener, com.tencent.mm.ac.d.a, e, a {
    private boolean Mu = false;
    private HashMap<String, o> hAT = new HashMap();
    private String hAU;
    private int jCE;
    private ProgressDialog lzx;
    private String nVj;
    private TextView nzj;
    private boolean ysW = false;
    private String ysY;
    private com.tencent.mm.ao.c ytA;
    private ArrayList<o> ytB = new ArrayList();
    private String ytq;
    private ListView yty;
    private a ytz;

    public enum a {
        SUCCESS,
        NO_CONTACT,
        ACCESS_DEDY,
        OTHER
    }

    class c extends AsyncTask<Void, Void, Void> {
        private String ytm;
        private boolean yto;
        private String ytq;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aST();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPostExecute");
            GoogleFriendUI.a(GoogleFriendUI.this, this.yto, this.ytm);
        }

        public c(String str) {
            this.ytq = str;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPreExecute");
            this.yto = false;
        }

        private Void aST() {
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "doInBackground");
            try {
                String str = "";
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("refresh_token", this.ytq));
                arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
                arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
                arrayList.add(new BasicNameValuePair("grant_type", "refresh_token"));
                String N = n.N(arrayList);
                x.i("MicroMsg.GoogleContact.GoogleFriendUI", "QueryString:%s" + N);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(N);
                bufferedWriter.flush();
                bufferedWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                x.e("MicroMsg.GoogleContact.GoogleFriendUI", "responseCode:" + responseCode);
                if (200 == responseCode) {
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    bufferedReader.close();
                    str = stringBuffer.toString();
                    x.i("MicroMsg.GoogleContact.GoogleFriendUI", "exchange token respone:%s" + str);
                }
                httpURLConnection.disconnect();
                x.i("MicroMsg.GoogleContact.GoogleFriendUI", "refresh response:%s", str);
                this.ytm = new JSONObject(str).optString("access_token");
                this.yto = true;
            } catch (ProtocolException e) {
                x.e("MicroMsg.GoogleContact.GoogleFriendUI", "ProtocolException:%s", e.getMessage());
            } catch (MalformedURLException e2) {
                x.e("MicroMsg.GoogleContact.GoogleFriendUI", "MalformedURLException:%s", e2.getMessage());
            } catch (IOException e3) {
                x.e("MicroMsg.GoogleContact.GoogleFriendUI", "IOException:%s", e3.getMessage());
            } catch (JSONException e4) {
                x.e("MicroMsg.GoogleContact.GoogleFriendUI", "JSONException:%s", e4.getMessage());
            }
            return null;
        }
    }

    class b extends AsyncTask<Void, Void, Void> {
        private String hAU;
        private Context mContext;
        private a ytK;

        /* synthetic */ b(GoogleFriendUI googleFriendUI, Context context, String str, byte b) {
            this(context, str);
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aST();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPostExecute");
            if (this.ytK != a.SUCCESS) {
                GoogleFriendUI.a(GoogleFriendUI.this, this.ytK, null);
            } else if (GoogleFriendUI.this.ytB == null || GoogleFriendUI.this.ytB.size() <= 0) {
                GoogleFriendUI.a(GoogleFriendUI.this, a.NO_CONTACT, null);
            } else {
                GoogleFriendUI.a(GoogleFriendUI.this, a.SUCCESS, GoogleFriendUI.this.ytB);
            }
        }

        private b(Context context, String str) {
            this.ytK = a.OTHER;
            this.mContext = context;
            this.hAU = str;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
            GoogleFriendUI.this.ytB.clear();
            GoogleFriendUI.this.hAT.clear();
        }

        private Void aST() {
            x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
            int i = 0;
            int i2 = 1;
            while (true) {
                try {
                    String r;
                    Object obj;
                    x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", Integer.valueOf(i2), Integer.valueOf(i));
                    x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + "json" + "&max-results=100&start-index=" + i2 + "&access_token=" + this.hAU).toString());
                    HttpURLConnection httpURLConnection = (HttpURLConnection) r6.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
                    int responseCode = httpURLConnection.getResponseCode();
                    x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", Integer.valueOf(responseCode));
                    if (responseCode == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        r = r(inputStream);
                        inputStream.close();
                    } else {
                        if (responseCode == 401) {
                            x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
                        } else {
                            x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
                        }
                        httpURLConnection.disconnect();
                        r = null;
                    }
                    responseCode = new JSONObject(r).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
                    if (responseCode > 0) {
                        ZA(r);
                    }
                    if (responseCode - i2 > 100) {
                        i2 += 100;
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null || GoogleFriendUI.this.Mu) {
                        this.ytK = a.SUCCESS;
                    } else {
                        i = responseCode;
                    }
                } catch (IOException e) {
                    this.ytK = a.ACCESS_DEDY;
                    x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + e.getMessage());
                } catch (JSONException e2) {
                    this.ytK = a.OTHER;
                    x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + e2.getMessage());
                }
            }
            this.ytK = a.SUCCESS;
            return null;
        }

        private static String r(InputStream inputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[20480];
            while (true) {
                int read = inputStream.read(bArr, 0, 20480);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }

        private void ZA(String str) {
            JSONArray jSONArray = new JSONObject(str).getJSONObject("feed").getJSONArray("entry");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string;
                    int lastIndexOf;
                    int i2;
                    String string2;
                    CharSequence substring;
                    int i3;
                    o oVar;
                    String str2 = "";
                    String str3 = "";
                    String str4 = "";
                    JSONObject optJSONObject = jSONArray.getJSONObject(i).optJSONObject(SlookAirButtonFrequentContactAdapter.ID);
                    JSONObject optJSONObject2 = jSONArray.getJSONObject(i).optJSONObject("title");
                    JSONArray optJSONArray = jSONArray.getJSONObject(i).optJSONArray("gd$email");
                    JSONArray optJSONArray2 = jSONArray.getJSONObject(i).optJSONArray("link");
                    if (optJSONObject != null) {
                        string = optJSONObject.getString("$t");
                        lastIndexOf = string.lastIndexOf("/");
                        if (lastIndexOf > 0) {
                            string = string.substring(lastIndexOf + 1);
                            if (optJSONObject2 == null) {
                                str2 = optJSONObject2.getString("$t");
                            } else {
                                str2 = str3;
                            }
                            if (optJSONArray2 != null) {
                                for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    string2 = optJSONArray2.getJSONObject(i2).getString("rel");
                                    lastIndexOf = string2.lastIndexOf("#");
                                    if (lastIndexOf > 0) {
                                        substring = string2.substring(lastIndexOf + 1);
                                        if (!TextUtils.isEmpty(substring) && SlookAirButtonFrequentContactAdapter.PHOTO.equals(substring)) {
                                            str4 = optJSONArray2.getJSONObject(i2).getString("href");
                                        }
                                    }
                                }
                            }
                            str3 = str4;
                            if (optJSONArray != null) {
                                for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    string2 = optJSONArray.getJSONObject(i3).getString("address");
                                    if (!(TextUtils.isEmpty(string2) || !bi.VZ(string2) || string2.equals(GoogleFriendUI.this.ysY))) {
                                        oVar = new o();
                                        oVar.field_googleid = string;
                                        oVar.field_googleitemid = string + string2;
                                        oVar.field_googlename = str2;
                                        oVar.field_googlephotourl = str3;
                                        oVar.field_googlegmail = string2;
                                        if (!GoogleFriendUI.this.hAT.containsKey(string2)) {
                                            GoogleFriendUI.this.ytB.add(oVar);
                                            GoogleFriendUI.this.hAT.put(string2, oVar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    string = str2;
                    if (optJSONObject2 == null) {
                        str2 = str3;
                    } else {
                        str2 = optJSONObject2.getString("$t");
                    }
                    if (optJSONArray2 != null) {
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            string2 = optJSONArray2.getJSONObject(i2).getString("rel");
                            lastIndexOf = string2.lastIndexOf("#");
                            if (lastIndexOf > 0) {
                                substring = string2.substring(lastIndexOf + 1);
                                str4 = optJSONArray2.getJSONObject(i2).getString("href");
                            }
                        }
                    }
                    str3 = str4;
                    if (optJSONArray != null) {
                        for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                            string2 = optJSONArray.getJSONObject(i3).getString("address");
                            oVar = new o();
                            oVar.field_googleid = string;
                            oVar.field_googleitemid = string + string2;
                            oVar.field_googlename = str2;
                            oVar.field_googlephotourl = str3;
                            oVar.field_googlegmail = string2;
                            if (!GoogleFriendUI.this.hAT.containsKey(string2)) {
                                GoogleFriendUI.this.ytB.add(oVar);
                                GoogleFriendUI.this.hAT.put(string2, oVar);
                            }
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(GoogleFriendUI googleFriendUI, a aVar, ArrayList arrayList) {
        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] success:%s", aVar);
        if (aVar == a.SUCCESS && !googleFriendUI.Mu) {
            googleFriendUI.ytA = new com.tencent.mm.ao.c(arrayList, googleFriendUI.jCE, googleFriendUI.hAT, googleFriendUI.hAU);
            as.CN().a(googleFriendUI.ytA, 0);
        } else if (aVar == a.NO_CONTACT) {
            googleFriendUI.alW();
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "Google Contact is Empty.");
            googleFriendUI.mG(true);
        } else if (aVar == a.ACCESS_DEDY) {
            googleFriendUI.alW();
            if (ao.isConnected(googleFriendUI)) {
                x.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] start bindGoogleContactUI No Login or network unavaile.");
                googleFriendUI.startActivity(new Intent(googleFriendUI, BindGoogleContactUI.class));
                googleFriendUI.finish();
                return;
            }
            googleFriendUI.mG(false);
        } else if (!googleFriendUI.Mu) {
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] start bindGoogleContactUI unknow error");
            googleFriendUI.alW();
            googleFriendUI.startActivity(new Intent(googleFriendUI, BindGoogleContactUI.class));
            googleFriendUI.finish();
        }
    }

    static /* synthetic */ void a(GoogleFriendUI googleFriendUI, boolean z, String str) {
        if (!z || TextUtils.isEmpty(str)) {
            googleFriendUI.alW();
            googleFriendUI.mG(false);
            return;
        }
        googleFriendUI.hAU = str;
        as.Hm();
        com.tencent.mm.y.c.Db().set(208902, str);
        googleFriendUI.crm();
    }

    protected final int getLayoutId() {
        return R.i.dly;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.Hm();
        this.ysY = (String) com.tencent.mm.y.c.Db().get(208903, null);
        if (TextUtils.isEmpty(this.ysY)) {
            finish();
        }
        this.jCE = getIntent().getIntExtra("enter_scene", 0);
        this.ytz = new a(this, this.ysY);
        this.ytz.ytr = this;
        initView();
        this.ysW = n.bj(this);
        if (this.ysW) {
            x.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
        } else {
            crl();
        }
        af.OR().clear();
    }

    protected void onResume() {
        super.onResume();
        as.CN().a(488, (e) this);
        as.CN().a(489, (e) this);
        com.tencent.mm.ac.n.JF().d(this);
        if (this.ytz != null) {
            this.ytz.XH();
        }
    }

    protected void onStop() {
        super.onStop();
        as.CN().b(488, (e) this);
        as.CN().b(489, (e) this);
        com.tencent.mm.ac.n.JF().e(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        af.OR().clear();
    }

    protected final void initView() {
        setMMTitle(R.l.enB);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GoogleFriendUI.this.finish();
                return true;
            }
        });
        this.nzj = (TextView) findViewById(R.h.empty);
        this.yty = (ListView) findViewById(R.h.cnz);
        this.yty.setAdapter(this.ytz);
        this.yty.setOnItemClickListener(this);
        p pVar = new p(true, true);
        pVar.zvw = new com.tencent.mm.ui.tools.p.b() {
            public final boolean pc(String str) {
                return false;
            }

            public final void pd(String str) {
                GoogleFriendUI.this.nVj = bi.oL(str);
                if (GoogleFriendUI.this.ytz != null) {
                    GoogleFriendUI.this.ytz.Ds(GoogleFriendUI.this.nVj);
                }
            }

            public final void XA() {
            }

            public final void XB() {
            }

            public final void XC() {
            }

            public final void XD() {
            }
        };
        a(pVar);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", Integer.valueOf(i));
        if (this.ytz != null) {
            o oVar = (o) this.ytz.getItem(i - this.yty.getHeaderViewsCount());
            if (oVar != null) {
                String str = oVar.field_username;
                x.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", oVar.field_googlegmail, str);
                as.Hm();
                ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
                Intent intent;
                if ((Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) && TextUtils.isEmpty(oVar.field_nickname)) {
                    intent = new Intent(this, InviteFriendUI.class);
                    intent.putExtra("friend_type", 2);
                    intent.putExtra("friend_user_name", str);
                    intent.putExtra("friend_num", oVar.field_googlegmail);
                    intent.putExtra("friend_nick", oVar.field_googlename);
                    intent.putExtra("friend_weixin_nick", oVar.field_nickname);
                    intent.putExtra("friend_googleID", oVar.field_googleid);
                    intent.putExtra("friend_googleItemID", oVar.field_googleitemid);
                    intent.putExtra("friend_scene", 58);
                    intent.putExtra("Contact_Scene", 58);
                    startActivity(intent);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Nick", oVar.field_nickname);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("verify_gmail", oVar.field_googlegmail);
                intent.putExtra("profileName", oVar.field_googlename);
                intent.putExtra("Contact_Source_FMessage", 58);
                intent.putExtra("Contact_Scene", 58);
                if (str != null && str.length() > 0) {
                    com.tencent.mm.plugin.c.a.ihN.d(intent, this.mController.xRr);
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
            return;
        }
        if (i2 == -1) {
            this.ysW = intent.getBooleanExtra("gpservices", false);
            crl();
            return;
        }
        this.ysW = intent.getBooleanExtra("gpservices", false);
        finish();
    }

    private void crl() {
        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
        if (this.ysW) {
            as.Hm();
            this.hAU = (String) com.tencent.mm.y.c.Db().get(208901, null);
        } else {
            as.Hm();
            this.hAU = (String) com.tencent.mm.y.c.Db().get(208902, null);
            as.Hm();
            this.ytq = (String) com.tencent.mm.y.c.Db().get(208904, null);
        }
        if (TextUtils.isEmpty(this.hAU) || (!this.ysW && TextUtils.isEmpty(this.ytq))) {
            G(BindGoogleContactUI.class);
            finish();
        } else if (this.ysW) {
            crm();
        } else {
            aDd();
            new c(this.ytq).execute(new Void[0]);
        }
    }

    public final void FC(int i) {
        if (this.ytz != null) {
            o oVar = (o) this.ytz.getItem(i);
            if (oVar != null) {
                switch (oVar.field_status) {
                    case 0:
                        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                            public final void a(boolean z, boolean z2, String str, String str2) {
                                x.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", Boolean.valueOf(z), Boolean.valueOf(z2));
                                if (z || z2) {
                                    x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", str2);
                                    af.OR().M(str2, 1);
                                } else {
                                    af.OR().M(str2, 2);
                                }
                                GoogleFriendUI.this.ytz.XH();
                            }
                        });
                        String str = oVar.field_googleitemid;
                        aVar.vtD = false;
                        aVar.vtC = true;
                        aVar.vtE = str;
                        aVar.vtD = false;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(Integer.valueOf(58));
                        aVar.b(oVar.field_username, linkedList, true);
                        oVar.field_googlecgistatus = 0;
                        af.OR().b(oVar);
                        this.ytz.XH();
                        return;
                    case 1:
                        Cursor lc = af.OR().lc(oVar.field_googleid);
                        if (lc == null || lc.getCount() <= 1) {
                            a(oVar, null);
                        } else {
                            a(lc, oVar);
                        }
                        if (lc != null) {
                            lc.close();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.GoogleContact.GoogleFriendUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = TextUtils.isEmpty(str) ? "" : str;
        x.i(str2, str3, objArr);
        int type = kVar.getType();
        if (i != 0 || i2 != 0) {
            switch (type) {
                case 30:
                case 137:
                    if (i2 == -87) {
                        h.b(this, getString(R.l.dUK), "", true);
                    } else if ((i2 == -24 || i2 == XWalkUpdater.ERROR_SET_VERNUM) && !bi.oN(str)) {
                        Toast.makeText(this, str, 1).show();
                    }
                    if (this.ytz != null) {
                        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", ((com.tencent.mm.pluginsdk.model.o) kVar).hAN);
                        af.OR().M(r0, 2);
                        this.ytz.XH();
                        break;
                    }
                    break;
                case 488:
                    mG(false);
                    break;
                case 489:
                    if (this.ytz != null) {
                        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(((com.tencent.mm.ao.b) kVar).Pg().kyA));
                        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", r11.hAN);
                        af.OR().M(r0, 1);
                        this.ytz.XH();
                        break;
                    }
                    break;
                default:
                    x.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                    break;
            }
        }
        switch (type) {
            case 30:
            case 137:
                if (this.ytz != null) {
                    x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", ((com.tencent.mm.pluginsdk.model.o) kVar).hAN);
                    af.OR().M(r0, 1);
                    this.ytz.XH();
                    break;
                }
                break;
            case 488:
                a(((com.tencent.mm.ao.c) kVar).Ph());
                break;
            case 489:
                if (this.ytz != null) {
                    x.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(((com.tencent.mm.ao.b) kVar).Pg().kyA));
                    x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", r11.hAN);
                    af.OR().M(r0, 1);
                    this.ytz.XH();
                    break;
                }
                break;
            default:
                x.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                break;
        }
        alW();
    }

    public final void jk(String str) {
        if (this.ytz != null) {
            this.ytz.notifyDataSetChanged();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void a(Cursor cursor, final o oVar) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                o oVar2 = new o();
                oVar2.b(cursor);
                arrayList.add(oVar2.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(oVar2);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.mController.xRr;
        String string = getResources().getString(R.l.enI);
        getResources().getString(R.l.dEy);
        h.a(context, string, arrayList, arrayList2, new d() {
            public final void cr(int i, int i2) {
                if (i2 != -1) {
                    GoogleFriendUI.this.a((o) arrayList3.get(i2), oVar);
                }
            }
        });
    }

    private void a(o oVar, o oVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar.field_googlegmail);
        k bVar = new com.tencent.mm.ao.b(arrayList);
        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", oVar.field_googleitemid);
        as.CN().a(bVar, 0);
        if (oVar2 == null) {
            bVar.hAN = oVar.field_googleitemid;
            oVar.field_googlecgistatus = 0;
            af.OR().b(oVar);
        } else {
            bVar.hAN = oVar2.field_googleitemid;
            oVar2.field_googlecgistatus = 0;
            af.OR().b(oVar2);
        }
        this.ytz.XH();
    }

    private void crm() {
        this.Mu = false;
        aDd();
        new b(this, this, this.hAU, (byte) 0).execute(new Void[0]);
    }

    private synchronized void a(apg apg) {
        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", Integer.valueOf(apg.kyA));
        if (this.ytz != null) {
            this.ytz.XH();
        }
    }

    private void mG(boolean z) {
        CharSequence string;
        this.nzj.setVisibility(0);
        if (!ao.isConnected(this)) {
            string = getString(R.l.enH);
        } else if (z) {
            string = getString(R.l.enA);
        } else {
            string = getString(R.l.enz);
        }
        this.nzj.setText(string);
    }

    private void aDd() {
        if (this.lzx == null || !this.lzx.isShowing()) {
            getString(R.l.dGZ);
            this.lzx = h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    GoogleFriendUI.this.Mu = true;
                    as.CN().c(GoogleFriendUI.this.ytA);
                }
            });
        }
    }

    private void alW() {
        if (this.lzx != null && this.lzx.isShowing()) {
            this.lzx.dismiss();
        }
    }
}
