package lokovsek.example.jure_lokovsek.simplechecklist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jure_lokovsek.simplechecklist.R;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private Realm realm;
    private Context context;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.task_list);
        context = MainActivity.this;
        realm = Realm.getDefaultInstance();

        RealmResults<Task> seznamTaks = realm.where(Task.class).findAll(); /// ob zagonu poišče vse vnose in jih shrabi v seznam
        final TaskAdapter taskAdapter = new TaskAdapter(this, seznamTaks); // naredim adapter objekt
        listView.setAdapter(taskAdapter); //listview določim adapter s podatki

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Task task =(Task) adapterView.getAdapter().getItem(i);
                final EditText taskEditText = new EditText(context);   // da lahko vnašam tekst
                taskEditText.setText(task.getName());
                final AlertDialog dialog = new AlertDialog.Builder(context)
                        .setTitle(R.string.editItem)
                        .setView(taskEditText) // določim kaj se naj prikaže kot možnost vnosa
                        .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // TODO: 5/4/17 Save Edited Task
                                String taskName = String.valueOf(taskEditText.getText());
                                String taskId = task.getId();
                                if(taskEditText.length() > 0){
                                    changeTaskName(taskId, taskName);
                                }else{
                                    myToastChoice(context, "noChangeEmptyIsert"); ///No change made, empty string
                                }
                            }
                        })
                        .setNegativeButton(R.string.delete, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // TODO: 5/4/17 Delete Task
                                deleteTask(task.getId());
                            }
                        }).create();

                dialog.show();
            }///
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Klikni tukaj!", listener).show();
                final EditText taskEditText = new EditText(context);
                AlertDialog dialog = new AlertDialog.Builder(context)
                        .setTitle(R.string.addItem)
                        .setView(taskEditText)
                        .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                final String taskName = String.valueOf(taskEditText.getText());
                                if(taskName.length() > 0){
                                    realm.executeTransactionAsync(new Realm.Transaction() {
                                        @Override
                                        public void execute(Realm realm) {
                                            realm.createObject(Task.class, UUID.randomUUID().toString()).setName(taskName); // shrani nov objekt
                                        }
                                    });
                                }else{
                                    myToastChoice(context, "noChangeEmptyIsert"); ///No change made, empty string, nothing happens
                                }
                            }
                        }).setNegativeButton(R.string.cancel, null).create();
                dialog.show();
            }
        });

    }

    private void changeTaskName(final String id, final String name){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Task task = realm.where(Task.class).equalTo("id", id).findFirst();
                task.setName(name);
            }
        });
    }

    private  void deleteTask(final String id){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(Task.class).equalTo("id", id).findFirst().deleteFromRealm();
            }
        });
    }

    private void deleteAllDone(){
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(R.string.deleteAllDone)
                .setIcon(R.drawable.ic_check_true)
                .setPositiveButton(R.string.deleteAll, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        realm.executeTransactionAsync(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                               realm.where(Task.class).equalTo("done", true).findAll().deleteAllFromRealm();
                            }
                        });
                        myToastChoice(context, "deleteAll"); ///delete all
                    }
                }).setNegativeButton(R.string.cancel, null).create();
        dialog.show();
    }

    private void deleteAllUnDone(){
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(R.string.delateAllNotDone)
                .setIcon(R.drawable.ic_check_false)
                .setPositiveButton(R.string.deleteAll, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        realm.executeTransactionAsync(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                realm.where(Task.class).equalTo("done", false).findAll().deleteAllFromRealm();
                            }
                        });
                        myToastChoice(context, "deleteAll"); ///delete all
                    }
                }).setNegativeButton(R.string.cancel, null).create();
        dialog.show();
    }

    public void changeTaskDone(final String id) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Task task = realm.where(Task.class).equalTo("id", id).findFirst();
                task.setDone(!task.isDone());
            }
        });
    }

    private void deleteAll() {
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(R.string.deleteAll)
                .setIcon(R.drawable.ic_delete_all)
                .setPositiveButton(R.string.deleteAll, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        realm.executeTransactionAsync(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                realm.where(Task.class).findAll().deleteAllFromRealm();
                            }
                        });
                        myToastChoice(context, "deleteAll"); ///delete all
                    }
                }).setNegativeButton(R.string.cancel, null).create();
        dialog.show();
    }

    private void myToast(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_LONG).show();
    }

    private void myToastChoice(Context context, String choice){
        if(choice.equals("noChangeEmptyIsert")){
            myToast(context, this.getString(R.string.noChangeEmptyIsert));
        }else if(choice.equals("deleteAll")){
            myToast(context, this.getString(R.string.done));
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delateAllNotDone) {
           // myToast(context, this.getString(R.string.deleted));
            deleteAllUnDone();
            return true;
        }
        if (id == R.id.action_deleteAllDoneTasks) {
          //  myToast(context, this.getString(R.string.deleted));
            deleteAllDone();
            return true;
        }
        if (id == R.id.action_deleteAll) {
            deleteAll();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
