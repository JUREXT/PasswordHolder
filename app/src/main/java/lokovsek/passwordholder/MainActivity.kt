package lokovsek.passwordholder

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jurelokovsek.passwordholder.R
import com.jurelokovsek.passwordholder.databinding.ActivityMainBinding

// TODO: ref -> https://www.youtube.com/watch?v=ZkROXHrlugs&ab_channel=LemubitAcademy


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewBinding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(viewBinding.root)

        viewBinding.fab.setOnClickListener(View.OnClickListener {
            Log.d("Main", "This is main")

        });

//        listView =(ListView)findViewById(R.id.task_list);
//        context = MainActivity.this;
//        realm = Realm.getDefaultInstance();
//
//        RealmResults<PasswordHolder> seznamTaks = realm.where(PasswordHolder.class).findAll(); /// ob zagonu poišče vse vnose in jih shrabi v seznam
//        final TaskAdapter taskAdapter = new TaskAdapter(this, seznamTaks); // naredim adapter objekt
//        listView.setAdapter(taskAdapter); //listview določim adapter s podatki
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                final PasswordHolder passwordHolder =(PasswordHolder) adapterView.getAdapter().getItem(i);
//                final EditText taskEditText = new EditText(context);   // da lahko vnašam tekst
//                taskEditText.setText(passwordHolder.getName());
//                final AlertDialog dialog = new AlertDialog.Builder(context)
//                        .setTitle(R.string.editItem)
//                        .setView(taskEditText) // določim kaj se naj prikaže kot možnost vnosa
//                        .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                // TODO: 5/4/17 Save Edited Task
//                                String taskName = String.valueOf(taskEditText.getText());
//                                String taskId = passwordHolder.getId();
//                                if(taskEditText.length() > 0){
//                                    changeTaskName(taskId, taskName);
//                                }else{
//                                    myToastChoice(context, "noChangeEmptyIsert"); ///No change made, empty string
//                                }
//                            }
//                        })
//                        .setNegativeButton(R.string.delete, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                // TODO: 5/4/17 Delete Task
//                                deleteTask(passwordHolder.getId());
//                            }
//                        }).create();
//
//                dialog.show();
//            }///
//        });
//
//
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Klikni tukaj!", listener).show();
//                final EditText taskEditText = new EditText(context);
//                AlertDialog dialog = new AlertDialog.Builder(context)
//                        .setTitle(R.string.addItem)
//                        .setView(taskEditText)
//                        .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                final String taskName = String.valueOf(taskEditText.getText());
//                                if(taskName.length() > 0){
//                                    realm.executeTransactionAsync(new Realm.Transaction() {
//                                        @Override
//                                        public void execute(Realm realm) {
//                                            realm.createObject(PasswordHolder.class, UUID.randomUUID().toString()).setName(taskName); // shrani nov objekt
//                                        }
//                                    });
//                                }else{
//                                    myToastChoice(context, "noChangeEmptyIsert"); ///No change made, empty string, nothing happens
//                                }
//                            }
//                        }).setNegativeButton(R.string.cancel, null).create();
//                dialog.show();
//            }
//        });
    }

    private fun test() {
        
    }

    //    private void changeTaskName(final String id, final String name){
    //        realm.executeTransactionAsync(new Realm.Transaction() {
    //            @Override
    //            public void execute(Realm realm) {
    //                PasswordHolder passwordHolder = realm.where(PasswordHolder.class).equalTo("id", id).findFirst();
    //                passwordHolder.setName(name);
    //            }
    //        });
    //    }
    //
    //    private  void deleteTask(final String id){
    //        realm.executeTransactionAsync(new Realm.Transaction() {
    //            @Override
    //            public void execute(Realm realm) {
    //                realm.where(PasswordHolder.class).equalTo("id", id).findFirst().deleteFromRealm();
    //            }
    //        });
    //    }
    //
    //    private void deleteAllDone(){
    //        AlertDialog dialog = new AlertDialog.Builder(context)
    //                .setTitle(R.string.deleteAllDone)
    //                .setIcon(R.drawable.ic_check_true)
    //                .setPositiveButton(R.string.deleteAll, new DialogInterface.OnClickListener() {
    //                    @Override
    //                    public void onClick(DialogInterface dialogInterface, int i) {
    //                        realm.executeTransactionAsync(new Realm.Transaction() {
    //                            @Override
    //                            public void execute(Realm realm) {
    //                               realm.where(PasswordHolder.class).equalTo("done", true).findAll().deleteAllFromRealm();
    //                            }
    //                        });
    //                        myToastChoice(context, "deleteAll"); ///delete all
    //                    }
    //                }).setNegativeButton(R.string.cancel, null).create();
    //        dialog.show();
    //    }
    //
    //    private void deleteAllUnDone(){
    //        AlertDialog dialog = new AlertDialog.Builder(context)
    //                .setTitle(R.string.delateAllNotDone)
    //                .setIcon(R.drawable.ic_check_false)
    //                .setPositiveButton(R.string.deleteAll, new DialogInterface.OnClickListener() {
    //                    @Override
    //                    public void onClick(DialogInterface dialogInterface, int i) {
    //                        realm.executeTransactionAsync(new Realm.Transaction() {
    //                            @Override
    //                            public void execute(Realm realm) {
    //                                realm.where(PasswordHolder.class).equalTo("done", false).findAll().deleteAllFromRealm();
    //                            }
    //                        });
    //                        myToastChoice(context, "deleteAll"); ///delete all
    //                    }
    //                }).setNegativeButton(R.string.cancel, null).create();
    //        dialog.show();
    //    }
    //
    //    public void changeTaskDone(final String id) {
    //        realm.executeTransactionAsync(new Realm.Transaction() {
    //            @Override
    //            public void execute(Realm realm) {
    //                PasswordHolder passwordHolder = realm.where(PasswordHolder.class).equalTo("id", id).findFirst();
    //                passwordHolder.setDone(!passwordHolder.isDone());
    //            }
    //        });
    //    }
    //
    //    private void deleteAll() {
    //        AlertDialog dialog = new AlertDialog.Builder(context)
    //                .setTitle(R.string.deleteAll)
    //                .setIcon(R.drawable.ic_delete_all)
    //                .setPositiveButton(R.string.deleteAll, new DialogInterface.OnClickListener() {
    //                    @Override
    //                    public void onClick(DialogInterface dialogInterface, int i) {
    //                        realm.executeTransactionAsync(new Realm.Transaction() {
    //                            @Override
    //                            public void execute(Realm realm) {
    //                                realm.where(PasswordHolder.class).findAll().deleteAllFromRealm();
    //                            }
    //                        });
    //                        myToastChoice(context, "deleteAll"); ///delete all
    //                    }
    //                }).setNegativeButton(R.string.cancel, null).create();
    //        dialog.show();
    //    }
    //
    //    private void myToast(Context context, String msg){
    //        Toast.makeText(context,msg, Toast.LENGTH_LONG).show();
    //    }
    //
    //    private void myToastChoice(Context context, String choice){
    //        if(choice.equals("noChangeEmptyIsert")){
    //            myToast(context, this.getString(R.string.noChangeEmptyIsert));
    //        }else if(choice.equals("deleteAll")){
    //            myToast(context, this.getString(R.string.done));
    //        }
    //    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == R.id.action_delateAllNotDone) {
            // myToast(context, this.getString(R.string.deleted));
            //  deleteAllUnDone();
            return true
        }
        if (id == R.id.action_deleteAllDoneTasks) {
            //  myToast(context, this.getString(R.string.deleted));
            // deleteAllDone();
            return true
        }
        return if (id == R.id.action_deleteAll) {
            // deleteAll();
            true
        } else super.onOptionsItemSelected(item)
    }
}