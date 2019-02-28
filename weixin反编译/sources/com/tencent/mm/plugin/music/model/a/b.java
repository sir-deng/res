package com.tencent.mm.plugin.music.model.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ab.c;
import com.tencent.mm.f.a.t;
import com.tencent.mm.plugin.music.model.g.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    Object lQt = new Object();
    private LinkedList<String> oPJ = new LinkedList();
    HashMap<String, e> oPK = new HashMap();
    LinkedList<String> oPL = new LinkedList();
    HashMap<String, e> oPM = new HashMap();
    LinkedList<String> oPN = new LinkedList();
    LinkedList<String> oPO = new LinkedList();
    HashMap<String, String> oPP = new HashMap();
    HashMap<String, LinkedList<String>> oPQ = new HashMap();
    HashMap<String, com.tencent.mm.ab.a> oPR = new HashMap();
    private HashMap<String, c> oPS = new HashMap();
    private LinkedList<String> oPT = new LinkedList();
    HashMap<String, Integer> oPU = new HashMap();
    private LinkedList<String> oPV = new LinkedList();
    boolean oPW = false;
    private boolean oPX = false;
    long oPY = 0;
    private long oPZ = 0;
    private a oQa = new a() {
        public final void onStart(String str) {
            e GB = b.this.GB(str);
            if (GB == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
                return;
            }
            b.this.e(str, GB);
            synchronized (b.this.lQt) {
                b.this.oPW = false;
            }
            ah.K(b.this.oQc);
        }

        public final void GJ(String str) {
            e GB = b.this.GB(str);
            if (GB == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
                return;
            }
            b.this.b(str, GB);
            b.this.f(str, GB);
            b.a(b.this);
            b.this.ben();
        }

        public final void As(String str) {
            e GB = b.this.GB(str);
            if (GB == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
                return;
            }
            b.this.b(str, GB);
            b.this.f(str, GB);
            b.a(b.this);
            b.this.ben();
        }

        public final void GK(String str) {
            e GB = b.this.GB(str);
            if (GB == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
                return;
            }
            b.this.b(str, GB);
            b.this.f(str, GB);
            b.a(b.this);
            b.this.ben();
        }

        public final void onError(String str) {
            e GB = b.this.GB(str);
            if (GB == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
                return;
            }
            int intValue;
            Object obj;
            b.this.b(str, GB);
            b bVar = b.this;
            int i = GB.lPJ;
            if (bVar.oPU.containsKey(str)) {
                intValue = ((Integer) bVar.oPU.get(str)).intValue();
            } else {
                intValue = 0;
            }
            if (intValue > 0) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
                bVar.oPU.remove(str);
            } else if (66 != i) {
                bVar.oPU.remove(str);
            } else if (bVar.GI(str)) {
                bVar.oPU.put(str, Integer.valueOf(intValue + 1));
                obj = 1;
                if (obj == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
                    b.this.ber();
                    b.this.a(str, null);
                }
                x.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
                b.this.f(str, GB);
                b.a(b.this);
                b.this.ben();
                return;
            }
            obj = null;
            if (obj == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
                b.this.f(str, GB);
                b.a(b.this);
                b.this.ben();
                return;
            }
            x.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
            b.this.ber();
            b.this.a(str, null);
        }
    };
    private Runnable oQb = new Runnable() {
        public final void run() {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
            Iterator it = b.this.oPO.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (b.this.GA(str) == 0) {
                    b.this.GC(str);
                }
            }
        }
    };
    Runnable oQc = new Runnable() {
        public final void run() {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
            Iterator it = b.this.oPO.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                String str = (String) it.next();
                if (b.this.GA(str) == 0) {
                    b bVar = b.this;
                    x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", str);
                    LinkedList linkedList = (LinkedList) bVar.oPQ.get(str);
                    if (linkedList == null || linkedList.size() == 0) {
                        x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
                    } else {
                        synchronized (bVar.lQt) {
                            Iterator it2 = linkedList.iterator();
                            while (it2.hasNext()) {
                                String str2 = (String) it2.next();
                                e eVar = (e) bVar.oPK.remove(str2);
                                bVar.oPL.remove(str2);
                                if (eVar != null) {
                                    bVar.b(str2, eVar);
                                    x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
                                    if (eVar.hml) {
                                        b.d(str2, eVar);
                                    } else {
                                        b.c(str2, eVar);
                                    }
                                }
                            }
                            Iterator it3 = linkedList.iterator();
                            while (it3.hasNext()) {
                                str = (String) it3.next();
                                e eVar2 = (e) bVar.oPM.remove(str);
                                bVar.oPN.remove(str);
                                if (eVar2 != null) {
                                    bVar.b(str, eVar2);
                                    x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                                    if (eVar2.hml) {
                                        b.d(str, eVar2);
                                    } else {
                                        b.c(str, eVar2);
                                    }
                                }
                            }
                        }
                    }
                    i2 = 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            if (i == 0) {
                synchronized (b.this.lQt) {
                    b.this.oPW = true;
                }
                b.this.oPY = System.currentTimeMillis();
                ah.h(b.this.oQc, 1800000);
            }
        }
    };

    public interface a {
        void As(String str);

        void GJ(String str);

        void GK(String str);

        void onError(String str);

        void onStart(String str);
    }

    public class b implements Comparator<com.tencent.mm.ab.a> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            com.tencent.mm.ab.a aVar = (com.tencent.mm.ab.a) obj;
            com.tencent.mm.ab.a aVar2 = (com.tencent.mm.ab.a) obj2;
            if (aVar.hmh > aVar2.hmh) {
                return 1;
            }
            return aVar.hmh < aVar2.hmh ? -1 : 0;
        }
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar.beo() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!bVar.oPX || currentTimeMillis - bVar.oPZ >= 10000) {
                synchronized (bVar.lQt) {
                    bVar.oPX = true;
                }
                bVar.oPZ = currentTimeMillis;
                x.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayIfPaused, delay_ms:%d", Integer.valueOf(600000));
                ah.K(bVar.oQb);
                ah.h(bVar.oQb, 600000);
                return;
            }
            return;
        }
        synchronized (bVar.lQt) {
            bVar.oPX = false;
        }
        ah.K(bVar.oQb);
    }

    public b() {
        bel();
    }

    public final void bel() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
        this.oPJ.clear();
        synchronized (this.lQt) {
            String str;
            Iterator it = this.oPL.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                c(str, (e) this.oPK.remove(str));
            }
            this.oPL.clear();
            this.oPK.clear();
            it = this.oPN.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                c(str, (e) this.oPM.remove(str));
            }
            this.oPN.clear();
            this.oPM.clear();
        }
        Iterator it2 = this.oPO.iterator();
        while (it2.hasNext()) {
            LinkedList linkedList = (LinkedList) this.oPQ.remove((String) it2.next());
            if (linkedList != null) {
                linkedList.clear();
            }
        }
        this.oPO.clear();
        this.oPP.clear();
        this.oPQ.clear();
        this.oPR.clear();
        this.oPS.clear();
        this.oPU.clear();
        this.oPV.clear();
        ah.K(this.oQb);
        ah.K(this.oQc);
        this.oPW = false;
        this.oPX = false;
    }

    private void dB(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", str, str2);
            if (!this.oPO.contains(str)) {
                this.oPO.add(str);
            }
            if (!this.oPJ.contains(str2)) {
                this.oPJ.add(str2);
            }
            LinkedList linkedList = (LinkedList) this.oPQ.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList();
            }
            if (!linkedList.contains(str2)) {
                linkedList.add(str2);
            }
            this.oPQ.put(str, linkedList);
        }
    }

    public final String dC(String str, String str2) {
        int i;
        x.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
        LinkedList linkedList = (LinkedList) this.oPQ.get(str);
        synchronized (this.lQt) {
            if (linkedList != null) {
                if (linkedList.contains(str2) && (this.oPL.contains(str2) || this.oPN.contains(str2))) {
                    i = 1;
                }
            }
            i = 0;
        }
        int GA = GA(str);
        if (TextUtils.isEmpty(str2)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            az(604, str2);
            return null;
        } else if (GA >= 10) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", Integer.valueOf(GA));
            dB(str, str2);
            return null;
        } else if (i != 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
            az(603, str2);
            return null;
        } else {
            dB(str, str2);
            GF(str2);
            e bem = bem();
            bem.a(this.oQa);
            bem.GL(str2);
            f(str2, bem);
            x.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", str, str2);
            return str2;
        }
    }

    public final boolean b(com.tencent.mm.ab.a aVar) {
        boolean z = false;
        if (aVar == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
            az(605, "");
            return false;
        } else if (TextUtils.isEmpty(aVar.foy)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
            az(604, aVar.foy);
            return false;
        } else if (this.oPJ.contains(aVar.foy)) {
            e GB;
            x.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
            String GE = GE(aVar.foy);
            com.tencent.mm.ab.a iQ = iQ(aVar.foy);
            if (GA(GE) >= 10) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", Integer.valueOf(GA(GE)));
                this.oPR.put(aVar.foy, aVar);
                x.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", Boolean.valueOf(aVar.hmf));
                if (aVar.hmf && GH(aVar.foy)) {
                    ber();
                } else if (aVar.hmf) {
                    az(600, aVar.foy);
                    return false;
                } else {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
                    GB = GB(aVar.foy);
                    if (GB != null) {
                        GB.c(aVar);
                        GB.bey();
                    }
                    return true;
                }
            }
            GF(aVar.foy);
            e GB2 = GB(aVar.foy);
            if (GB2 == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", aVar.foy);
                GB = bem();
                GB.a(this.oQa);
                GB.GL(aVar.foy);
                GB.c(aVar);
                if (aVar.hmf) {
                    e(aVar.foy, GB);
                    aVar.hmh = System.currentTimeMillis();
                    GB.d(aVar);
                } else {
                    f(aVar.foy, GB);
                    GB.bey();
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
                }
            } else {
                x.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", aVar.foy);
                if (aVar.hmf) {
                    e(aVar.foy, GB2);
                    aVar.hmh = System.currentTimeMillis();
                    GB2.c(aVar);
                    if (iQ != null && !iQ.a(aVar)) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
                        if (GB2.Qx() || GB2.Qy() || GB2.beI() || GB2.isPrepared() || GB2.isPaused()) {
                            GB2.stopPlay();
                        }
                        GB2.d(aVar);
                    } else if (GB2.Qx()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
                    } else if (GB2.Qy() && GB2.isPaused()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
                        GB2.resume();
                    } else if (GB2.isPrepared()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
                        GB2.resume();
                    } else if (GB2.beI()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
                    } else {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
                        GB2.d(aVar);
                    }
                } else {
                    synchronized (this.lQt) {
                        if (this.oPL.contains(aVar.foy)) {
                            z = true;
                        }
                    }
                    if (z) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
                    } else {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
                        f(aVar.foy, GB2);
                    }
                    GB2.c(aVar);
                    if (!(iQ == null || iQ.a(aVar))) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
                        if (GB2.Qx() || GB2.Qy() || GB2.beI() || GB2.isPrepared() || GB2.isPaused()) {
                            GB2.stopPlay();
                        }
                    }
                    GB2.bey();
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
                }
            }
            this.oPP.put(GE, aVar.processName);
            this.oPR.put(aVar.foy, aVar);
            return true;
        } else {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
            az(601, aVar.foy);
            return false;
        }
    }

    public final boolean a(String str, com.tencent.mm.ab.a aVar) {
        com.tencent.mm.ab.a aVar2 = (com.tencent.mm.ab.a) this.oPR.get(str);
        if ((!this.oPJ.contains(str) || aVar2 == null) && aVar != null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", str);
            if (aVar == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", str);
            } else {
                x.i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", str);
                this.oPP.put(aVar.appId, aVar.processName);
                this.oPR.put(aVar.foy, aVar);
                dB(aVar.appId, str);
                this.oPU.remove(str);
            }
            if (aVar2 == null) {
                aVar2 = aVar;
            }
        } else if (!this.oPJ.contains(str)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
            az(601, str);
            return false;
        } else if (aVar2 == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
            az(602, str);
            return false;
        }
        x.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", str);
        if (GA(GE(str)) >= 10) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", Integer.valueOf(GA(GE(str))));
            if (GH(str)) {
                ber();
            } else {
                az(600, str);
                return false;
            }
        }
        e GB = GB(str);
        if (GB == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
            GF(str);
            x.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", str);
            GB = bem();
            GB.a(this.oQa);
            GB.GL(str);
            e(str, GB);
            aVar2.hmf = true;
            aVar2.hmd = 0;
            aVar2.hmh = System.currentTimeMillis();
            GB.d(aVar2);
            return true;
        }
        e(str, GB);
        this.oPR.put(str, aVar2);
        if (GB.Qy() && !GB.Qx()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
            GB.resume();
        } else if (GB.isPrepared()) {
            aVar2.hmf = true;
            aVar2.hmh = System.currentTimeMillis();
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
            GB.resume();
            aVar2.hmd = 0;
            GB.c(aVar2);
        } else if (GB.beI()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
            aVar2.hmf = true;
            aVar2.hmh = System.currentTimeMillis();
            GB.c(aVar2);
        } else if (GB.Qy()) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
            return false;
        } else {
            aVar2.hmf = true;
            aVar2.hmh = System.currentTimeMillis();
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
            GB.d(aVar2);
            aVar2.hmd = 0;
        }
        return true;
    }

    public final boolean Gx(String str) {
        e GB = GB(str);
        if (GB == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
            return false;
        }
        x.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", str);
        GB.stopPlay();
        com.tencent.mm.ab.a aVar = (com.tencent.mm.ab.a) this.oPR.get(str);
        if (aVar != null) {
            aVar.hmd = 0;
            aVar.hmf = true;
        }
        b(str, GB);
        f(str, GB);
        return true;
    }

    public final boolean Gy(String str) {
        e GB = GB(str);
        if (GB == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
            return false;
        }
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", str);
        c(str, GB);
        synchronized (this.lQt) {
            this.oPK.remove(str);
            this.oPL.remove(str);
            this.oPM.remove(str);
            this.oPN.remove(str);
        }
        this.oPJ.remove(str);
        Iterator it = this.oPO.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            LinkedList linkedList = (LinkedList) this.oPQ.get(str2);
            if (linkedList != null && linkedList.contains(str)) {
                linkedList.remove(str);
                if (linkedList.size() == 0) {
                    this.oPQ.remove(str2);
                    this.oPO.remove(str2);
                    this.oPP.remove(str2);
                }
                this.oPR.remove(str);
                this.oPS.remove(str);
                return true;
            }
        }
        this.oPR.remove(str);
        this.oPS.remove(str);
        return true;
    }

    final boolean bK(String str, int i) {
        com.tencent.mm.ab.a aVar = (com.tencent.mm.ab.a) this.oPR.get(str);
        if (aVar == null) {
            return false;
        }
        aVar.hmd = i;
        return true;
    }

    public final c Gz(String str) {
        e GB = GB(str);
        if (GB != null) {
            return GB.beL();
        }
        return (c) this.oPS.get(str);
    }

    public final int GA(String str) {
        int size;
        int beo = beo();
        synchronized (this.lQt) {
            int size2 = this.oPJ.size();
            size = this.oPK.size();
            int size3 = this.oPM.size();
            LinkedList linkedList = (LinkedList) this.oPQ.get(str);
            int size4 = linkedList == null ? 0 : linkedList.size();
            x.i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", Integer.valueOf(size2), Integer.valueOf(size), Integer.valueOf(size3), Integer.valueOf(size4), Integer.valueOf(beo));
        }
        return size;
    }

    public final com.tencent.mm.ab.a iQ(String str) {
        if (this.oPR.containsKey(str)) {
            return (com.tencent.mm.ab.a) this.oPR.get(str);
        }
        return null;
    }

    final e GB(String str) {
        if (this.oPK.containsKey(str)) {
            return (e) this.oPK.get(str);
        }
        if (this.oPM.containsKey(str)) {
            return (e) this.oPM.get(str);
        }
        return null;
    }

    public final void GC(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", str);
        LinkedList linkedList = (LinkedList) this.oPQ.get(str);
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
        } else if (this.oPK.isEmpty() && this.oPM.isEmpty()) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                e eVar = (e) this.oPM.get(str2);
                if (eVar != null) {
                    a(str2, eVar);
                }
            }
            x.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", Integer.valueOf(this.oPK.size()));
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                e eVar2 = (e) this.oPK.get(str3);
                if (eVar2 != null) {
                    a(str3, eVar2);
                    f(str3, eVar2);
                }
            }
        }
    }

    public final void GD(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", str);
        LinkedList linkedList = (LinkedList) this.oPQ.remove(str);
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            return;
        }
        synchronized (this.lQt) {
            String str2;
            e eVar;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                eVar = (e) this.oPK.remove(str2);
                this.oPL.remove(str2);
                x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
                c(str2, eVar);
                this.oPR.remove(str2);
                this.oPS.remove(str2);
            }
            it = linkedList.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                eVar = (e) this.oPM.remove(str2);
                this.oPN.remove(str2);
                x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                c(str2, eVar);
                this.oPR.remove(str2);
                this.oPS.remove(str2);
            }
        }
        this.oPJ.removeAll(linkedList);
        this.oPO.remove(str);
        this.oPP.remove(str);
    }

    private void az(int i, String str) {
        x.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", Integer.valueOf(i), str);
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
            str = com.tencent.mm.ab.b.JD();
        }
        com.tencent.mm.sdk.b.b tVar = new t();
        tVar.foD.action = 4;
        tVar.foD.state = "error";
        tVar.foD.errCode = h.ua(i);
        tVar.foD.foE = h.ub(i);
        tVar.foD.foy = str;
        tVar.foD.appId = GE(str);
        com.tencent.mm.sdk.b.a.xmy.a(tVar, Looper.getMainLooper());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.mm.plugin.music.model.a.e bem() {
        /*
        r18 = this;
        r2 = "MicroMsg.Audio.AudioPlayerMgr";
        r3 = "createOrReusePlayer";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r0 = r18;
        r9 = r0.lQt;
        monitor-enter(r9);
        r0 = r18;
        r2 = r0.oPM;	 Catch:{ all -> 0x00e1 }
        r2 = r2.size();	 Catch:{ all -> 0x00e1 }
        if (r2 != 0) goto L_0x001f;
    L_0x0018:
        r7 = new com.tencent.mm.plugin.music.model.a.e;	 Catch:{ all -> 0x00e1 }
        r7.<init>();	 Catch:{ all -> 0x00e1 }
        monitor-exit(r9);	 Catch:{ all -> 0x00e1 }
    L_0x001e:
        return r7;
    L_0x001f:
        r7 = 0;
        r6 = "";
        r4 = 0;
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00e1 }
        r0 = r18;
        r2 = r0.oPN;	 Catch:{ all -> 0x00e1 }
        r12 = r2.iterator();	 Catch:{ all -> 0x00e1 }
    L_0x0031:
        r2 = r12.hasNext();	 Catch:{ all -> 0x00e1 }
        if (r2 == 0) goto L_0x0086;
    L_0x0037:
        r2 = r12.next();	 Catch:{ all -> 0x00e1 }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x00e1 }
        r0 = r18;
        r3 = r0.oPM;	 Catch:{ all -> 0x00e1 }
        r3 = r3.get(r2);	 Catch:{ all -> 0x00e1 }
        r3 = (com.tencent.mm.plugin.music.model.a.e) r3;	 Catch:{ all -> 0x00e1 }
        if (r3 == 0) goto L_0x0031;
    L_0x0049:
        r8 = r3.hml;	 Catch:{ all -> 0x00e1 }
        if (r8 != 0) goto L_0x006a;
    L_0x004d:
        r8 = r3.isCompleted();	 Catch:{ all -> 0x00e1 }
        if (r8 != 0) goto L_0x006a;
    L_0x0053:
        r8 = r3.isStopped();	 Catch:{ all -> 0x00e1 }
        if (r8 != 0) goto L_0x006a;
    L_0x0059:
        r8 = r3.oQi;	 Catch:{ all -> 0x00e1 }
        if (r8 == 0) goto L_0x0084;
    L_0x005d:
        r8 = r3.oQi;	 Catch:{ all -> 0x00e1 }
        r8 = r8.getPlayerState();	 Catch:{ all -> 0x00e1 }
        r13 = 9;
        if (r8 != r13) goto L_0x0082;
    L_0x0067:
        r8 = 1;
    L_0x0068:
        if (r8 == 0) goto L_0x00ef;
    L_0x006a:
        r14 = 0;
        r8 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1));
        if (r8 == 0) goto L_0x0076;
    L_0x0070:
        r14 = r3.gLZ;	 Catch:{ all -> 0x00e1 }
        r8 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1));
        if (r8 >= 0) goto L_0x00ef;
    L_0x0076:
        r4 = r3.gLZ;	 Catch:{ all -> 0x00e1 }
        r16 = r4;
        r4 = r2;
        r5 = r3;
        r2 = r16;
    L_0x007e:
        r6 = r4;
        r7 = r5;
        r4 = r2;
        goto L_0x0031;
    L_0x0082:
        r8 = 0;
        goto L_0x0068;
    L_0x0084:
        r8 = 0;
        goto L_0x0068;
    L_0x0086:
        if (r7 == 0) goto L_0x00e7;
    L_0x0088:
        r2 = r10 - r4;
        r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x00e7;
    L_0x0090:
        r2 = "MicroMsg.Audio.AudioPlayerMgr";
        r3 = "player is be reuse to play again with other audio";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ all -> 0x00e1 }
        r2 = "MicroMsg.Audio.AudioPlayerMgr";
        r3 = "unmarkPlayer, unmark player by audioId:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00e1 }
        r5 = 0;
        r4[r5] = r6;	 Catch:{ all -> 0x00e1 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ all -> 0x00e1 }
        r0 = r18;
        r3 = r0.lQt;	 Catch:{ all -> 0x00e1 }
        monitor-enter(r3);	 Catch:{ all -> 0x00e1 }
        r0 = r18;
        r2 = r0.oPN;	 Catch:{ all -> 0x00e4 }
        r2 = r2.contains(r6);	 Catch:{ all -> 0x00e4 }
        if (r2 == 0) goto L_0x00c5;
    L_0x00b7:
        r0 = r18;
        r2 = r0.oPM;	 Catch:{ all -> 0x00e4 }
        r2.remove(r6);	 Catch:{ all -> 0x00e4 }
        r0 = r18;
        r2 = r0.oPN;	 Catch:{ all -> 0x00e4 }
        r2.remove(r6);	 Catch:{ all -> 0x00e4 }
    L_0x00c5:
        r0 = r18;
        r2 = r0.oPL;	 Catch:{ all -> 0x00e4 }
        r2 = r2.contains(r6);	 Catch:{ all -> 0x00e4 }
        if (r2 == 0) goto L_0x00dd;
    L_0x00cf:
        r0 = r18;
        r2 = r0.oPL;	 Catch:{ all -> 0x00e4 }
        r2.remove(r6);	 Catch:{ all -> 0x00e4 }
        r0 = r18;
        r2 = r0.oPK;	 Catch:{ all -> 0x00e4 }
        r2.remove(r6);	 Catch:{ all -> 0x00e4 }
    L_0x00dd:
        monitor-exit(r3);	 Catch:{ all -> 0x00e4 }
        monitor-exit(r9);	 Catch:{ all -> 0x00e1 }
        goto L_0x001e;
    L_0x00e1:
        r2 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00e1 }
        throw r2;
    L_0x00e4:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00e4 }
        throw r2;	 Catch:{ all -> 0x00e1 }
    L_0x00e7:
        monitor-exit(r9);	 Catch:{ all -> 0x00e1 }
        r7 = new com.tencent.mm.plugin.music.model.a.e;
        r7.<init>();
        goto L_0x001e;
    L_0x00ef:
        r2 = r4;
        r4 = r6;
        r5 = r7;
        goto L_0x007e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.model.a.b.bem():com.tencent.mm.plugin.music.model.a.e");
    }

    private String GE(String str) {
        Iterator it = this.oPO.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            LinkedList linkedList = (LinkedList) this.oPQ.get(str2);
            if (linkedList != null && linkedList.contains(str)) {
                return str2;
            }
        }
        return "";
    }

    private void a(String str, e eVar) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", str);
        com.tencent.mm.ab.a aVar = (com.tencent.mm.ab.a) this.oPR.get(str);
        if (aVar != null && eVar.Qx() && eVar.Qy()) {
            aVar.hmf = true;
            aVar.hmd = eVar.beK();
        } else if (aVar != null && eVar.Qy()) {
            aVar.hmf = true;
            aVar.hmd = eVar.beK();
        } else if (aVar != null) {
            aVar.hmf = true;
            aVar.hmd = 0;
        }
        b(str, eVar);
        c Gz = Gz(str);
        if (Gz != null && eVar.Qx()) {
            Gz.hmk = true;
        }
        if (eVar.Qx() || eVar.Qy() || eVar.beI() || eVar.isPrepared() || eVar.isPaused()) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
            eVar.hml = true;
            eVar.beJ();
            return;
        }
        x.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
        eVar.hml = true;
        eVar.oQl = true;
    }

    final void b(String str, e eVar) {
        this.oPS.put(str, eVar.beL());
    }

    static void c(String str, e eVar) {
        if (eVar == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", str);
            return;
        }
        if (eVar.Qx() || eVar.Qy() || eVar.beI() || eVar.isPrepared() || eVar.isPaused()) {
            eVar.stopPlay();
        }
        eVar.release();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", str);
    }

    static void d(String str, e eVar) {
        x.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
        c(str, eVar);
    }

    final void e(String str, e eVar) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", str);
        synchronized (this.lQt) {
            if (this.oPN.contains(str)) {
                this.oPM.remove(str);
                this.oPN.remove(str);
            }
            if (!this.oPL.contains(str)) {
                this.oPL.add(str);
                this.oPK.put(str, eVar);
            }
        }
    }

    final void f(String str, e eVar) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", str);
        synchronized (this.lQt) {
            if (this.oPL.contains(str)) {
                this.oPK.remove(str);
                this.oPL.remove(str);
            }
            if (!this.oPN.contains(str)) {
                this.oPN.add(str);
                this.oPM.put(str, eVar);
            }
        }
    }

    public final void ben() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.oPW || currentTimeMillis - this.oPY >= 10000) {
            this.oPY = currentTimeMillis;
            synchronized (this.lQt) {
                this.oPW = true;
            }
            x.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", Integer.valueOf(1800000));
            ah.K(this.oQc);
            ah.h(this.oQc, 1800000);
        }
    }

    private int beo() {
        int i;
        synchronized (this.lQt) {
            Iterator it = this.oPN.iterator();
            i = 0;
            while (it.hasNext()) {
                boolean z;
                int i2;
                String str = (String) it.next();
                e GB = GB(str);
                if (GB == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
                    c Gz = Gz(str);
                    z = Gz != null ? Gz.hmk : false;
                } else {
                    z = GB.isPaused();
                }
                if (z) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        return i;
    }

    private void GF(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
        int size = this.oPK.size();
        int size2 = this.oPM.size();
        int beo = beo();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(beo));
        if (size >= 10) {
            bep();
        } else if (beo >= 6) {
            bep();
        } else if (size + beo >= 8) {
            bep();
        }
        String GE = GE(str);
        beo = this.oPK.size();
        size = this.oPM.size();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", Integer.valueOf(beo), Integer.valueOf(size));
        Iterator it;
        String str2;
        if (size >= 50) {
            it = this.oPO.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                if (!(str2 == null || str2.equalsIgnoreCase(GE))) {
                    GG(str2);
                }
            }
        } else if (size + beo >= 50) {
            it = this.oPO.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                if (!(str2 == null || str2.equalsIgnoreCase(GE))) {
                    GG(str2);
                }
            }
        } else {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleStopPlayerByAppId");
        }
        size = this.oPM.size();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", Integer.valueOf(beo), Integer.valueOf(size));
        if (size >= 50) {
            beq();
        } else if (size + beo >= 50) {
            beq();
        } else {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleAllStopPlayer");
        }
    }

    private void bep() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
        synchronized (this.lQt) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.oPN);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                e eVar = (e) this.oPM.get(str);
                if (eVar != null && eVar.isPaused()) {
                    a(str, eVar);
                }
            }
        }
    }

    private void beq() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
        synchronized (this.lQt) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.oPN);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                e eVar = (e) this.oPM.remove(str);
                this.oPN.remove(str);
                if (eVar != null) {
                    if (eVar.hml) {
                        b(str, eVar);
                        d(str, eVar);
                    } else if (!eVar.isPaused()) {
                        b(str, eVar);
                        c(str, eVar);
                    }
                }
            }
        }
    }

    private void GG(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", str);
        LinkedList linkedList = (LinkedList) this.oPQ.get(str);
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            return;
        }
        synchronized (this.lQt) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                e eVar = (e) this.oPM.remove(str2);
                this.oPN.remove(str2);
                if (eVar != null) {
                    b(str2, eVar);
                    x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                    if (eVar.hml) {
                        d(str2, eVar);
                    } else {
                        c(str2, eVar);
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean GH(java.lang.String r17) {
        /*
        r16 = this;
        r5 = 0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r7 = new java.util.HashMap;
        r7.<init>();
        r8 = new java.util.HashMap;
        r8.<init>();
        r0 = r16;
        r4 = r0.lQt;
        monitor-enter(r4);
        r0 = r16;
        r1 = r0.oPK;	 Catch:{ all -> 0x0091 }
        r9 = r1.size();	 Catch:{ all -> 0x0091 }
        r1 = 10;
        if (r9 >= r1) goto L_0x003e;
    L_0x0021:
        r0 = r16;
        r1 = r0.oPT;	 Catch:{ all -> 0x0091 }
        r1.clear();	 Catch:{ all -> 0x0091 }
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r2 = "playerCount:%d is not need to remove";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0091 }
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x0091 }
        r3[r5] = r6;	 Catch:{ all -> 0x0091 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ all -> 0x0091 }
        r1 = 0;
        monitor-exit(r4);	 Catch:{ all -> 0x0091 }
    L_0x003d:
        return r1;
    L_0x003e:
        r0 = r16;
        r1 = r0.oPL;	 Catch:{ all -> 0x0091 }
        r6 = r1.iterator();	 Catch:{ all -> 0x0091 }
    L_0x0046:
        r1 = r6.hasNext();	 Catch:{ all -> 0x0091 }
        if (r1 == 0) goto L_0x00c6;
    L_0x004c:
        r1 = r6.next();	 Catch:{ all -> 0x0091 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0091 }
        r0 = r16;
        r2 = r0.oPR;	 Catch:{ all -> 0x0091 }
        r1 = r2.get(r1);	 Catch:{ all -> 0x0091 }
        r1 = (com.tencent.mm.ab.a) r1;	 Catch:{ all -> 0x0091 }
        if (r1 == 0) goto L_0x0046;
    L_0x005e:
        r2 = r1.hmc;	 Catch:{ all -> 0x0091 }
        if (r2 == 0) goto L_0x0046;
    L_0x0062:
        r2 = r1.hmc;	 Catch:{ all -> 0x0091 }
        r2 = r7.containsKey(r2);	 Catch:{ all -> 0x0091 }
        if (r2 != 0) goto L_0x0094;
    L_0x006a:
        r2 = r1.hmc;	 Catch:{ all -> 0x0091 }
        r10 = 1;
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x0091 }
        r7.put(r2, r10);	 Catch:{ all -> 0x0091 }
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0091 }
        r2.<init>();	 Catch:{ all -> 0x0091 }
        r10 = r1.foy;	 Catch:{ all -> 0x0091 }
        r2.add(r10);	 Catch:{ all -> 0x0091 }
        r10 = r1.hmc;	 Catch:{ all -> 0x0091 }
        r8.put(r10, r2);	 Catch:{ all -> 0x0091 }
    L_0x0083:
        r2 = r1.hmc;	 Catch:{ all -> 0x0091 }
        r2 = r3.contains(r2);	 Catch:{ all -> 0x0091 }
        if (r2 != 0) goto L_0x0046;
    L_0x008b:
        r1 = r1.hmc;	 Catch:{ all -> 0x0091 }
        r3.add(r1);	 Catch:{ all -> 0x0091 }
        goto L_0x0046;
    L_0x0091:
        r1 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0091 }
        throw r1;
    L_0x0094:
        r2 = r1.hmc;	 Catch:{ all -> 0x0091 }
        r2 = r7.get(r2);	 Catch:{ all -> 0x0091 }
        r2 = (java.lang.Integer) r2;	 Catch:{ all -> 0x0091 }
        r2 = r2.intValue();	 Catch:{ all -> 0x0091 }
        r2 = r2 + 1;
        r10 = r1.hmc;	 Catch:{ all -> 0x0091 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0091 }
        r7.put(r10, r2);	 Catch:{ all -> 0x0091 }
        r2 = r1.hmc;	 Catch:{ all -> 0x0091 }
        r2 = r8.get(r2);	 Catch:{ all -> 0x0091 }
        r2 = (java.util.ArrayList) r2;	 Catch:{ all -> 0x0091 }
        r10 = r1.foy;	 Catch:{ all -> 0x0091 }
        r10 = r2.contains(r10);	 Catch:{ all -> 0x0091 }
        if (r10 != 0) goto L_0x00c0;
    L_0x00bb:
        r10 = r1.foy;	 Catch:{ all -> 0x0091 }
        r2.add(r10);	 Catch:{ all -> 0x0091 }
    L_0x00c0:
        r10 = r1.hmc;	 Catch:{ all -> 0x0091 }
        r8.put(r10, r2);	 Catch:{ all -> 0x0091 }
        goto L_0x0083;
    L_0x00c6:
        monitor-exit(r4);	 Catch:{ all -> 0x0091 }
        r4 = "";
        com.tencent.mm.y.as.Hm();
        r1 = com.tencent.mm.y.c.Db();
        r2 = com.tencent.mm.storage.w.a.USERINFO_MUSIC_RREMOVE_PLAYING_AUDIO_PLAYER_GROUP_COUNT_INT_SYNC;
        r6 = 3;
        r6 = java.lang.Integer.valueOf(r6);
        r1 = r1.get(r2, r6);
        r1 = (java.lang.Integer) r1;
        r6 = r1.intValue();
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r2 = "removePlayerGroupMinCount:%d";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = java.lang.Integer.valueOf(r6);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r10);
        r10 = r3.iterator();
        r3 = r6;
    L_0x00fa:
        r1 = r10.hasNext();
        if (r1 == 0) goto L_0x0137;
    L_0x0100:
        r1 = r10.next();
        r1 = (java.lang.String) r1;
        r2 = r7.get(r1);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r11 = "MicroMsg.Audio.AudioPlayerMgr";
        r12 = "count:%d, url:%s";
        r13 = 2;
        r13 = new java.lang.Object[r13];
        r14 = 0;
        r15 = java.lang.Integer.valueOf(r2);
        r13[r14] = r15;
        r14 = 1;
        r13[r14] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r11, r12, r13);
        if (r2 < r6) goto L_0x0257;
    L_0x0128:
        r5 = 1;
        if (r3 >= r2) goto L_0x0253;
    L_0x012b:
        r3 = r1;
    L_0x012c:
        r4 = android.text.TextUtils.isEmpty(r3);
        if (r4 == 0) goto L_0x025c;
    L_0x0132:
        r3 = r5;
    L_0x0133:
        r4 = r1;
        r5 = r3;
        r3 = r2;
        goto L_0x00fa;
    L_0x0137:
        if (r5 == 0) goto L_0x0250;
    L_0x0139:
        r0 = r16;
        r1 = r0.oPR;
        r0 = r17;
        r1 = r1.get(r0);
        r1 = (com.tencent.mm.ab.a) r1;
        if (r1 == 0) goto L_0x0250;
    L_0x0147:
        if (r4 == 0) goto L_0x0250;
    L_0x0149:
        r1 = r1.hmc;
        r1 = r4.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x0250;
    L_0x0151:
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r2 = "srcUrl is same, not remove and don't play again";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r5 = 0;
        r2 = r5;
    L_0x015c:
        if (r2 == 0) goto L_0x023f;
    L_0x015e:
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r3 = "need to remove player";
        com.tencent.mm.sdk.platformtools.x.i(r1, r3);
        r1 = r8.get(r4);
        r1 = (java.util.ArrayList) r1;
        if (r1 == 0) goto L_0x0211;
    L_0x016f:
        r3 = r1.size();
        if (r3 <= 0) goto L_0x0211;
    L_0x0175:
        r3 = new java.util.LinkedList;
        r3.<init>();
        r4 = r1.iterator();
    L_0x017e:
        r1 = r4.hasNext();
        if (r1 == 0) goto L_0x019a;
    L_0x0184:
        r1 = r4.next();
        r1 = (java.lang.String) r1;
        r0 = r16;
        r5 = r0.oPR;
        r1 = r5.get(r1);
        r1 = (com.tencent.mm.ab.a) r1;
        if (r1 == 0) goto L_0x017e;
    L_0x0196:
        r3.add(r1);
        goto L_0x017e;
    L_0x019a:
        r1 = new com.tencent.mm.plugin.music.model.a.b$b;
        r0 = r16;
        r1.<init>();
        java.util.Collections.sort(r3, r1);
        r4 = new java.util.LinkedList;
        r4.<init>();
        r3 = r3.iterator();
    L_0x01ad:
        r1 = r3.hasNext();
        if (r1 == 0) goto L_0x01bf;
    L_0x01b3:
        r1 = r3.next();
        r1 = (com.tencent.mm.ab.a) r1;
        r1 = r1.foy;
        r4.add(r1);
        goto L_0x01ad;
    L_0x01bf:
        r1 = r9 + -10;
        if (r1 <= 0) goto L_0x0214;
    L_0x01c3:
        r3 = r4.size();
        if (r3 <= r1) goto L_0x0214;
    L_0x01c9:
        r1 = r1 + 1;
        r3 = "MicroMsg.Audio.AudioPlayerMgr";
        r5 = "removeCount should be %d";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r1);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r3, r5, r6);
        r3 = r4.size();
        r1 = r3 - r1;
        if (r1 >= 0) goto L_0x01e7;
    L_0x01e6:
        r1 = 1;
    L_0x01e7:
        r0 = r16;
        r3 = r0.oPT;
        r5 = r4.size();
        r1 = r4.subList(r1, r5);
        r3.addAll(r1);
    L_0x01f6:
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r3 = "need remove and stop player count : %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r16;
        r6 = r0.oPT;
        r6 = r6.size();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);
    L_0x0211:
        r1 = r2;
        goto L_0x003d;
    L_0x0214:
        if (r1 <= 0) goto L_0x022d;
    L_0x0216:
        r3 = r4.size();
        if (r3 >= r1) goto L_0x022d;
    L_0x021c:
        r0 = r16;
        r1 = r0.oPT;
        r3 = 1;
        r5 = r4.size();
        r3 = r4.subList(r3, r5);
        r1.addAll(r3);
        goto L_0x01f6;
    L_0x022d:
        r0 = r16;
        r1 = r0.oPT;
        r3 = r4.size();
        r3 = r3 + -1;
        r3 = r4.get(r3);
        r1.add(r3);
        goto L_0x01f6;
    L_0x023f:
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r3 = "not need to remove player";
        com.tencent.mm.sdk.platformtools.x.i(r1, r3);
        r0 = r16;
        r1 = r0.oPT;
        r1.clear();
        goto L_0x0211;
    L_0x0250:
        r2 = r5;
        goto L_0x015c;
    L_0x0253:
        r2 = r3;
        r3 = r4;
        goto L_0x012c;
    L_0x0257:
        r2 = r3;
        r1 = r4;
        r3 = r5;
        goto L_0x0133;
    L_0x025c:
        r1 = r3;
        r3 = r5;
        goto L_0x0133;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.model.a.b.GH(java.lang.String):boolean");
    }

    final void ber() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
        Iterator it = this.oPT.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", (String) it.next());
            Gx(r0);
        }
        it = this.oPV.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", (String) it.next());
            Gx(r0);
        }
        this.oPT.clear();
        this.oPV.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean GI(java.lang.String r14) {
        /*
        r13 = this;
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "canRemoveAudioPlayerInPlayingListForTry";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r4 = 0;
        r5 = new java.util.ArrayList;
        r5.<init>();
        r6 = new java.util.HashMap;
        r6.<init>();
        r7 = new java.util.HashMap;
        r7.<init>();
        r2 = r13.lQt;
        monitor-enter(r2);
        r0 = r13.oPK;	 Catch:{ all -> 0x008a }
        r0 = r0.size();	 Catch:{ all -> 0x008a }
        r1 = 5;
        if (r0 > r1) goto L_0x003b;
    L_0x0025:
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r3 = "playerCount:%d is not need to remove for try";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x008a }
        r5 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x008a }
        r4[r5] = r0;	 Catch:{ all -> 0x008a }
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);	 Catch:{ all -> 0x008a }
        r4 = 0;
        monitor-exit(r2);	 Catch:{ all -> 0x008a }
    L_0x003a:
        return r4;
    L_0x003b:
        r0 = r13.oPL;	 Catch:{ all -> 0x008a }
        r3 = r0.iterator();	 Catch:{ all -> 0x008a }
    L_0x0041:
        r0 = r3.hasNext();	 Catch:{ all -> 0x008a }
        if (r0 == 0) goto L_0x00bf;
    L_0x0047:
        r0 = r3.next();	 Catch:{ all -> 0x008a }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x008a }
        r1 = r13.oPR;	 Catch:{ all -> 0x008a }
        r0 = r1.get(r0);	 Catch:{ all -> 0x008a }
        r0 = (com.tencent.mm.ab.a) r0;	 Catch:{ all -> 0x008a }
        if (r0 == 0) goto L_0x0041;
    L_0x0057:
        r1 = r0.hmc;	 Catch:{ all -> 0x008a }
        if (r1 == 0) goto L_0x0041;
    L_0x005b:
        r1 = r0.hmc;	 Catch:{ all -> 0x008a }
        r1 = r6.containsKey(r1);	 Catch:{ all -> 0x008a }
        if (r1 != 0) goto L_0x008d;
    L_0x0063:
        r1 = r0.hmc;	 Catch:{ all -> 0x008a }
        r8 = 1;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x008a }
        r6.put(r1, r8);	 Catch:{ all -> 0x008a }
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x008a }
        r1.<init>();	 Catch:{ all -> 0x008a }
        r8 = r0.foy;	 Catch:{ all -> 0x008a }
        r1.add(r8);	 Catch:{ all -> 0x008a }
        r8 = r0.hmc;	 Catch:{ all -> 0x008a }
        r7.put(r8, r1);	 Catch:{ all -> 0x008a }
    L_0x007c:
        r1 = r0.hmc;	 Catch:{ all -> 0x008a }
        r1 = r5.contains(r1);	 Catch:{ all -> 0x008a }
        if (r1 != 0) goto L_0x0041;
    L_0x0084:
        r0 = r0.hmc;	 Catch:{ all -> 0x008a }
        r5.add(r0);	 Catch:{ all -> 0x008a }
        goto L_0x0041;
    L_0x008a:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x008a }
        throw r0;
    L_0x008d:
        r1 = r0.hmc;	 Catch:{ all -> 0x008a }
        r1 = r6.get(r1);	 Catch:{ all -> 0x008a }
        r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x008a }
        r1 = r1.intValue();	 Catch:{ all -> 0x008a }
        r1 = r1 + 1;
        r8 = r0.hmc;	 Catch:{ all -> 0x008a }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x008a }
        r6.put(r8, r1);	 Catch:{ all -> 0x008a }
        r1 = r0.hmc;	 Catch:{ all -> 0x008a }
        r1 = r7.get(r1);	 Catch:{ all -> 0x008a }
        r1 = (java.util.ArrayList) r1;	 Catch:{ all -> 0x008a }
        r8 = r0.foy;	 Catch:{ all -> 0x008a }
        r8 = r1.contains(r8);	 Catch:{ all -> 0x008a }
        if (r8 != 0) goto L_0x00b9;
    L_0x00b4:
        r8 = r0.foy;	 Catch:{ all -> 0x008a }
        r1.add(r8);	 Catch:{ all -> 0x008a }
    L_0x00b9:
        r8 = r0.hmc;	 Catch:{ all -> 0x008a }
        r7.put(r8, r1);	 Catch:{ all -> 0x008a }
        goto L_0x007c;
    L_0x00bf:
        monitor-exit(r2);	 Catch:{ all -> 0x008a }
        r0 = r13.oPR;
        r0 = r0.get(r14);
        r0 = (com.tencent.mm.ab.a) r0;
        r2 = r5.iterator();
    L_0x00cc:
        r1 = r2.hasNext();
        if (r1 == 0) goto L_0x00f0;
    L_0x00d2:
        r1 = r2.next();
        r1 = (java.lang.String) r1;
        if (r0 == 0) goto L_0x00cc;
    L_0x00da:
        if (r1 == 0) goto L_0x00cc;
    L_0x00dc:
        r3 = r0.hmc;
        r1 = r1.equalsIgnoreCase(r3);
        if (r1 == 0) goto L_0x00cc;
    L_0x00e4:
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "srcUrl is same, not remove and don't play again for try";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r4 = 0;
        goto L_0x003a;
    L_0x00f0:
        r3 = "";
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "removePlayerGroupMinCountForTry:%d";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r8 = 0;
        r9 = 2;
        r9 = java.lang.Integer.valueOf(r9);
        r2[r8] = r9;
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);
        r2 = 2;
        r5 = r5.iterator();
    L_0x010c:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x014a;
    L_0x0112:
        r0 = r5.next();
        r0 = (java.lang.String) r0;
        r1 = r6.get(r0);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r8 = "MicroMsg.Audio.AudioPlayerMgr";
        r9 = "count:%d, url:%s";
        r10 = 2;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = java.lang.Integer.valueOf(r1);
        r10[r11] = r12;
        r11 = 1;
        r10[r11] = r0;
        com.tencent.mm.sdk.platformtools.x.d(r8, r9, r10);
        r8 = 2;
        if (r1 < r8) goto L_0x01dc;
    L_0x013b:
        r4 = 1;
        if (r2 >= r1) goto L_0x01d8;
    L_0x013e:
        r2 = r0;
    L_0x013f:
        r3 = android.text.TextUtils.isEmpty(r2);
        if (r3 == 0) goto L_0x01e1;
    L_0x0145:
        r2 = r4;
    L_0x0146:
        r3 = r0;
        r4 = r2;
        r2 = r1;
        goto L_0x010c;
    L_0x014a:
        if (r4 == 0) goto L_0x01cd;
    L_0x014c:
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "need to remove player";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r7.get(r3);
        r0 = (java.util.ArrayList) r0;
        if (r0 == 0) goto L_0x003a;
    L_0x015d:
        r1 = r0.size();
        if (r1 <= 0) goto L_0x003a;
    L_0x0163:
        r1 = new java.util.LinkedList;
        r1.<init>();
        r2 = r0.iterator();
    L_0x016c:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0186;
    L_0x0172:
        r0 = r2.next();
        r0 = (java.lang.String) r0;
        r3 = r13.oPR;
        r0 = r3.get(r0);
        r0 = (com.tencent.mm.ab.a) r0;
        if (r0 == 0) goto L_0x016c;
    L_0x0182:
        r1.add(r0);
        goto L_0x016c;
    L_0x0186:
        r0 = new com.tencent.mm.plugin.music.model.a.b$b;
        r0.<init>();
        java.util.Collections.sort(r1, r0);
        r2 = new java.util.LinkedList;
        r2.<init>();
        r1 = r1.iterator();
    L_0x0197:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x01a9;
    L_0x019d:
        r0 = r1.next();
        r0 = (com.tencent.mm.ab.a) r0;
        r0 = r0.foy;
        r2.add(r0);
        goto L_0x0197;
    L_0x01a9:
        r0 = r13.oPV;
        r1 = r2.getLast();
        r0.add(r1);
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "need remove and stop player count for try: %d";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r5 = r13.oPV;
        r5 = r5.size();
        r5 = java.lang.Integer.valueOf(r5);
        r2[r3] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        goto L_0x003a;
    L_0x01cd:
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "not need to remove player for try";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x003a;
    L_0x01d8:
        r1 = r2;
        r2 = r3;
        goto L_0x013f;
    L_0x01dc:
        r1 = r2;
        r0 = r3;
        r2 = r4;
        goto L_0x0146;
    L_0x01e1:
        r0 = r2;
        r2 = r4;
        goto L_0x0146;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.model.a.b.GI(java.lang.String):boolean");
    }
}
