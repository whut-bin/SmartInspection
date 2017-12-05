package com.whut.smartinspection.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.whut.greendao.gen.SubDao;
import com.whut.greendao.gen.TaskItemDao;
import com.whut.smartinspection.R;
import com.whut.smartinspection.adapters.TaskPageListAdapter;
import com.whut.smartinspection.application.SApplication;
import com.whut.smartinspection.model.Sub;
import com.whut.smartinspection.model.TaskItem;
import com.whut.smartlibrary.base.SwipeBackActivity;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.whut.smartinspection.adapters.TaskPageListAdapter.TaskPageItem;

public class CompletedTaskActivity extends SwipeBackActivity {


    @BindView(R.id.gd_task_page_menu)
    ListView taskmenu;

    TaskPageListAdapter taskPageListAdapter ;
    List<TaskPageListAdapter.TaskPageItem> list = new ArrayList<TaskPageListAdapter.TaskPageItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_task);
        ButterKnife.bind(this);

        initView();
        initData();
    }
    private void initView(){
        taskPageListAdapter = new TaskPageListAdapter(this,list);
        taskmenu.setAdapter(taskPageListAdapter);
        taskmenu.setEmptyView(null);
        final Intent intent = new Intent(this,FullInspectionActivity.class);
        taskmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TaskPageListAdapter tpl = (TaskPageListAdapter)adapterView.getAdapter();
                TaskPageItem item  = (TaskPageItem)tpl.getItem(i);
                intent.putExtra("item",item);
                intent.putExtra("pageFlag","1");
                startActivity(intent);

            }
        });
    }
    private void initData(){
        TaskItemDao taskItemDao = SApplication.getInstance().getDaoSession().getTaskItemDao();
        QueryBuilder<TaskItem> qb = taskItemDao.queryBuilder();

        SubDao subDao = SApplication.getInstance().getDaoSession().getSubDao();
        QueryBuilder<Sub> qbSub = subDao.queryBuilder();

        List<TaskItem> listTemp = qb.list();
        for (TaskItem taskItem   :listTemp ) {
            if(taskItem.getStatus() == 1){
                TaskPageListAdapter.TaskPageItem item = new TaskPageListAdapter.TaskPageItem();
                item.setText(taskItem.getContent());
                item.setNumber(taskItem.getWorker());
                item.setId(taskItem.getSubstationId());
                //查找变电站id
                Sub subTemp = qbSub.where(SubDao.Properties.Idd.eq(taskItem.getId())).unique();
                item.setStationName(subTemp.getName());
                list.add(item);

            }
        }
        taskPageListAdapter.notifyDataSetChanged();
    }
    @OnClick({R.id.tv_com_back})
    public void onClick(View view) {
        switch (view.getId()) {
            // 返回
            case R.id.tv_com_back:
                finish();
                break;
            default:
                break;
        }
    }

}