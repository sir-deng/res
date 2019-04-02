package com.helen.baselib.RxManager;

import android.support.annotation.NonNull;

import com.helen.baselib.commountutils.LogUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * 用RxJava实现的EventBus
 */
public class RxBus {
    private static RxBus instance;

    private RxBus() {
    }

    private ConcurrentHashMap<Object, List<Subject>> subjectMapper = new ConcurrentHashMap<>();


    public static RxBus getInstance() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }

    /**
     * 订阅事件源
     *
     * @param observable
     * @param action1
     * @return
     */
    public RxBus OnEvent(Observable<?> observable, Action1<Object> action1) {
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(action1, new
                Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
        return getInstance();
    }

    public <T> Observable<T> register(@NonNull Object tag) {
        List<Subject> subjectList = subjectMapper.get(tag);
        if (null == subjectList) {
            subjectList = new ArrayList<>();
            subjectMapper.put(tag, subjectList);
        }
        Subject<T, T> subject;
        subjectList.add(subject = PublishSubject.<T>create());
        LogUtils.logd("register" + tag + " size" + subjectList.size());
        return subject;
    }

    public void unregister(Object tag) {
        List<Subject> subjects = subjectMapper.get(tag);
        if (null != subjects) {
            subjectMapper.remove(tag);
        }
    }

    public RxBus unregister(Object tag, Observable<?> observable) {
        if (null == observable) return getInstance();
        List<Subject> subjects = subjectMapper.get(tag);
        if (null != subjects) {
            subjects.remove(observable);
            if (isEmpty(subjects)) {
                subjectMapper.remove(tag);
                LogUtils.logd("unregister" + tag + " size" + subjects.size());
            }
        }
        return getInstance();
    }

    public static boolean isEmpty(Collection<Subject> collection) {
        return null == collection || collection.isEmpty();
    }

    public void post(@NonNull Object obj) {
        post(obj.getClass().getName(), obj);
    }

    /**
     * 发送事件
     * @param tag
     * @param content
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void post(@NonNull Object tag, @NonNull Object content) {
        LogUtils.logd("post" + "eventName: " + tag);
        List<Subject> subjects = subjectMapper.get(tag);
        if (!isEmpty(subjects)) {
            for (Subject subject : subjects) {
                subject.onNext(content);
                LogUtils.logd("onEvent" + " eventName" + tag);
            }
        }
    }
}
