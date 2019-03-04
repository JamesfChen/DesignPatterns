package com.hawksjamesf.designpatterns;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.markzhai.recyclerview.BaseViewAdapter;
import com.github.markzhai.recyclerview.MultiTypeAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.hawksjamesf.designpatterns.databinding.FragmentCreationalPatternsBinding;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Jul/20/2018  Fri
 */

public class CreationalPatternsFragment extends Fragment {

    public static CreationalPatternsFragment newInstance() {
        return new CreationalPatternsFragment();
    }

    enum CreationalPatternsEnum {
        Singleton("Singleton"),
        Builder("Builder"),
        Factory_Method("Factory_Method"),
        Abstract_Factory("Abstract_Factory");
        private String des;

        CreationalPatternsEnum(String des) {
            this.des = des;
        }
    }

    private FragmentCreationalPatternsBinding mBinding;
    private List<String> mData = Arrays.asList(
            CreationalPatternsEnum.Singleton.des,
            CreationalPatternsEnum.Builder.des,
            CreationalPatternsEnum.Factory_Method.des,
            CreationalPatternsEnum.Abstract_Factory.des);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_creational_patterns, container, false);
        return mBinding.getRoot();
    }

    CreationalAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new CreationalAdapter(getActivity());
        adapter.setPresenter(new Presenter());
        mBinding.rlv.setAdapter(adapter);
        mBinding.rlv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        mBinding.rlv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        adapter.addAll(mData, 0);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public class CreationalAdapter extends MultiTypeAdapter {
        public CreationalAdapter(Context context) {
            super(context);
            addViewTypeToLayoutMap(0, R.layout.item_creational);
        }
    }

    public class Presenter implements BaseViewAdapter.Presenter {
        public void onClick() {
            Snackbar.make(
                    mBinding.getRoot(),
                    "creational patterns",
                    Snackbar.LENGTH_SHORT)
                    .setActionTextColor(getResources().getColor(R.color.colorAccent))
                    .setAction("action", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .show();

        }


    }

}
