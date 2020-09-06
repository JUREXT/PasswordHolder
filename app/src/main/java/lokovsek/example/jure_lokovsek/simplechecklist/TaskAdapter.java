package lokovsek.example.jure_lokovsek.simplechecklist;

import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.jure_lokovsek.simplechecklist.R;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * Created by Jure_Lokovsek on 26. 03. 2018.
 */

public class TaskAdapter extends RealmBaseAdapter<Task> implements ListAdapter {

    private MainActivity activity;


    public TaskAdapter(MainActivity activity, @Nullable OrderedRealmCollection<Task> data) {
        super(data);
        this.activity = activity;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;

        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_list_row, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.taskName = (TextView) view.findViewById(R.id.task_item_name);
            viewHolder.isTaskDone =(CheckBox) view.findViewById(R.id.task_item_done);
            viewHolder.isTaskDone.setOnClickListener(listener);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        if(adapterData != null){
            Task task = adapterData.get(i);
            viewHolder.taskName.setText(task.getName());
            viewHolder.isTaskDone.setChecked(task.isDone());
            viewHolder.isTaskDone.setTag(i);
        }

        return view;
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = (Integer) view.getTag();
            if(adapterData != null){
                Task task = adapterData.get(position);
                activity.changeTaskDone(task.getId()); ////
            }
        }
    };

    public static class ViewHolder{
        TextView taskName;
        CheckBox isTaskDone;
    }

}
