package com.example.mjie_.android_day07testa1.presenter;

import com.example.mjie_.android_day07testa1.bean.Objects;
import com.example.mjie_.android_day07testa1.callback.CallBack;
import com.example.mjie_.android_day07testa1.model.ImpMymodel;
import com.example.mjie_.android_day07testa1.views.Myview;

public class ImpMypresenter implements Mypresenter, CallBack {
    private ImpMymodel impMymodel;
    private Myview myview;

    public ImpMypresenter(ImpMymodel impMymodel, Myview myview) {
        this.impMymodel = impMymodel;
        this.myview = myview;
    }

    @Override
    public void getData() {
        if (impMymodel != null) {
            impMymodel.getData(this);
        }
    }

    @Override
    public void onOk(Objects objects) {
        if (impMymodel != null) {
            myview.onOk(objects);
        }
    }

    @Override
    public void onNo(String error) {
        if (impMymodel != null) {
            myview.onNo(error);
        }
    }
}
