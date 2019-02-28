package com.tencent.mm.bf;

import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bup;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class g {
    String iau;
    LinkedHashMap<String, a> iav = new LinkedHashMap();
    final ReadWriteLock iaw = new ReentrantReadWriteLock();
    private StringBuilder iax = new StringBuilder();

    public class a {
        public String data;
        public boolean iaA;
        public int iaB;
        public int iaC;
        public int iaD;
        public boolean iaE;
        public String iay;
        public boolean iaz;

        public a() {
            long nextInt = 4294967295L & ((long) new Random(System.currentTimeMillis()).nextInt());
            long currentTimeMillis = ((4294967295L & System.currentTimeMillis()) << 32) | nextInt;
            if (currentTimeMillis < 0) {
                currentTimeMillis = Math.abs(currentTimeMillis);
            }
            x.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", Long.valueOf(nextInt), Long.toBinaryString(nextInt), Long.valueOf(r2), Long.toBinaryString(r2), Long.valueOf(currentTimeMillis), Long.toBinaryString(currentTimeMillis), g.this.iau, g.this.iau + String.valueOf(currentTimeMillis));
            this.iay = r6;
            this.iaz = false;
            this.iaA = false;
            this.iaB = Integer.MAX_VALUE;
            this.iaC = 0;
            this.iaD = -1;
            this.data = null;
            this.iaE = false;
        }
    }

    public g(String str) {
        this.iau = str;
    }

    public final LinkedList<bet> Vf() {
        LinkedList<bet> linkedList = new LinkedList();
        this.iaw.readLock().lock();
        for (a aVar : this.iav.values()) {
            if (aVar.iaz) {
                linkedList.add(new bet().Vf(aVar.iay));
            }
        }
        this.iaw.readLock().unlock();
        return linkedList;
    }

    public final String getResult() {
        this.iax.setLength(0);
        this.iaw.readLock().lock();
        for (a aVar : this.iav.values()) {
            if (aVar.data != null) {
                this.iax.append(aVar.data);
            }
        }
        this.iaw.readLock().unlock();
        return this.iax.toString();
    }

    public final boolean Vg() {
        this.iaw.readLock().lock();
        if (this.iav.size() == 0) {
            x.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
            return false;
        }
        boolean z;
        for (a aVar : this.iav.values()) {
            x.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", aVar.iay, Boolean.valueOf(aVar.iaA), Boolean.valueOf(aVar.iaE));
            if (!((a) r3.next()).iaE) {
                z = false;
                break;
            }
        }
        z = true;
        this.iaw.readLock().unlock();
        return z;
    }

    public final void X(List<bup> list) {
        String str;
        String str2 = "MicroMsg.ShortSentenceContainer";
        String str3 = "updateVoiceInfoResult respVTList size %s innerContainer %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
        this.iaw.readLock().lock();
        if (this.iav.size() == 0) {
            this.iaw.readLock().unlock();
            str = "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (a aVar : this.iav.values()) {
                stringBuilder.append(aVar.iay).append(", ");
            }
            if (stringBuilder.length() <= 3) {
                this.iaw.readLock().unlock();
                str = stringBuilder.append("]").toString();
            } else {
                stringBuilder.setLength(stringBuilder.length() - 2);
                this.iaw.readLock().unlock();
                str = stringBuilder.append("]").toString();
            }
        }
        objArr[1] = str;
        x.d(str2, str3, objArr);
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.ShortSentenceContainer", "respList == null");
            return;
        }
        this.iaw.readLock().lock();
        for (bup bup : list) {
            if (bup == null) {
                x.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
            } else {
                a aVar2 = (a) this.iav.get(bup.wdG);
                if (aVar2 == null) {
                    x.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", bup.wdG);
                } else if (bup == null) {
                    x.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
                } else {
                    String str4 = "MicroMsg.ShortSentenceContainer";
                    String str5 = "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s";
                    Object[] objArr2 = new Object[12];
                    objArr2[0] = bup.wdG;
                    objArr2[1] = Integer.valueOf(bup.xbZ);
                    Integer valueOf = (bup.wZP == null || bup.wZP.wRm == null) ? null : Integer.valueOf(bup.wZP.wRk);
                    objArr2[2] = valueOf;
                    objArr2[3] = Boolean.valueOf(bup.vSa != 0);
                    objArr2[4] = Integer.valueOf(bup.vSa);
                    objArr2[5] = aVar2.iay;
                    objArr2[6] = Boolean.valueOf(aVar2.iaz);
                    objArr2[7] = Boolean.valueOf(aVar2.iaA);
                    objArr2[8] = Integer.valueOf(aVar2.iaB);
                    objArr2[9] = Integer.valueOf(aVar2.iaD);
                    objArr2[10] = aVar2.data == null ? null : Integer.valueOf(aVar2.data.length());
                    objArr2[11] = Boolean.valueOf(aVar2.iaE);
                    x.d(str4, str5, objArr2);
                    if (bup.xbZ < aVar2.iaD || aVar2.iaE) {
                        x.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
                    } else {
                        aVar2.iaD = bup.xbZ;
                        str3 = (bup.wZP == null || bup.wZP.wRm == null) ? null : bup.wZP.wRm.cec();
                        aVar2.data = str3;
                        aVar2.iaE = bup.vSa != 0;
                        str3 = "MicroMsg.ShortSentenceContainer";
                        str4 = "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s";
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = bup.wdG;
                        objArr3[1] = Integer.valueOf(aVar2.iaD);
                        objArr3[2] = Boolean.valueOf(aVar2.iaE);
                        objArr3[3] = Integer.valueOf(aVar2.data == null ? -1 : aVar2.data.length());
                        x.i(str3, str4, objArr3);
                        if (bup.vSa == 2) {
                            x.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", bup.wdG);
                        }
                    }
                }
            }
        }
        this.iaw.readLock().unlock();
    }

    public final void iQ(int i) {
        x.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", Integer.valueOf(i));
        if (i < 0) {
            throw new IllegalStateException("splitShortSentence file mark less than zero. mark: " + i);
        }
        this.iaw.readLock().lock();
        if (this.iav.size() == 0) {
            x.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
            return;
        }
        a aVar = null;
        for (a aVar2 : this.iav.values()) {
        }
        if (aVar2 == null) {
            throw new IllegalStateException("splitShortSentence last info is null");
        }
        x.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", Integer.valueOf(aVar2.iaB), aVar2.iay, Integer.valueOf(i));
        aVar2.iaB = i;
        this.iaw.readLock().unlock();
    }

    public final a iR(int i) {
        this.iaw.readLock().lock();
        if (this.iav.size() == 0) {
            return null;
        }
        for (a aVar : this.iav.values()) {
            x.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", Integer.valueOf(i), Integer.valueOf(aVar.iaB), Boolean.valueOf(aVar.iaA));
            if (!aVar.iaA && i <= aVar.iaB) {
                break;
            }
        }
        a aVar2 = null;
        this.iaw.readLock().unlock();
        return aVar2;
    }
}
