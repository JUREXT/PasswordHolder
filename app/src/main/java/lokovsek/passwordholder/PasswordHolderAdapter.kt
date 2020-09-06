package lokovsek.passwordholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jurelokovsek.passwordholder.R
import java.util.*

/**
 * Created by Jure_Lokovsek on 26. 03. 2018.
 */
class PasswordHolderAdapter : RecyclerView.Adapter<PasswordHolderAdapter.ViewHolder>() {

    private var data: List<PasswordHolder> = ArrayList();

    fun setData(data: List<PasswordHolder>) {
        this.data = data;
        notifyDataSetChanged();
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.task_list_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return data.size;
    }

    //    public TaskAdapter(MainActivity activity, @Nullable OrderedRealmCollection<PasswordHolder> data) {
    //        super(data);
    //        this.activity = activity;
    //    }
    //    @Override
    //    public View getView(int i, View view, ViewGroup viewGroup) {
    //        final ViewHolder viewHolder;
    //
    //        if(view == null){
    //            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_list_row, viewGroup, false);
    //            viewHolder = new ViewHolder();
    //            viewHolder.taskName = (TextView) view.findViewById(R.id.task_item_name);
    //            viewHolder.isTaskDone =(CheckBox) view.findViewById(R.id.task_item_done);
    //            viewHolder.isTaskDone.setOnClickListener(listener);
    //            view.setTag(viewHolder);
    //        }else{
    //            viewHolder = (ViewHolder) view.getTag();
    //        }
    //
    //        if(adapterData != null){
    //            PasswordHolder passwordHolder = adapterData.get(i);
    //            viewHolder.taskName.setText(passwordHolder.getName());
    //            viewHolder.isTaskDone.setChecked(passwordHolder.isDone());
    //            viewHolder.isTaskDone.setTag(i);
    //        }
    //
    //        return view;
    //    }
    inner class ViewHolder(view: View?) : RecyclerView.ViewHolder(view!!)
}