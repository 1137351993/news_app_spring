package com.example.gotitapplication.home;

import static android.content.ContentValues.TAG;
import static com.example.gotitapplication.MainActivity2.account;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.gotitapplication.R;
import com.example.gotitapplication.news_list;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{
    private ViewPager pager;
    private FragmentAdapter fragmentAdapter;
    private List<TabFragment> fragmentList;
    private TabLayout tabLayout;
    private ImageButton imageButton;
    private EditText editText;
    private List<String> mTitles;
    private String [] title={"社会新闻","国内新闻","国际新闻","娱乐新闻","体育新闻","NBA新闻","足球新闻",
            "科技新闻","创业新闻"};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.home_fragment,container,false);
        pager=view.findViewById(R.id.page);
        tabLayout=view.findViewById(R.id.tab_layout);
        imageButton=(ImageButton) view.findViewById(R.id.menu_add);
        editText=(EditText) view.findViewById(R.id.et_search_text);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key="%"+editText.getText()+"%";
                Log.w(TAG, "run:ulawhedaljsbcalsbcliwyehfljdksbcxhuchzlkjcxiiiiiiii "+key);
                Intent intent = new Intent(getActivity(), news_list.class);
                intent.putExtra("key", key);
                intent.putExtra("operationName", 4);
                intent.putExtra("account", account);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        fragmentList=new ArrayList<>();
        mTitles=new ArrayList<>();
        for(int i=0;i<title.length;i++){
            mTitles.add(title[i]);
            fragmentList.add(new TabFragment(title[i]));
        }

        fragmentAdapter=new FragmentAdapter(getActivity().getSupportFragmentManager(),fragmentList,mTitles);
        pager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(pager);//与ViewPage建立关系
    }


}