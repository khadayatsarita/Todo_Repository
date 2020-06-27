package com.saritac7190004.todoapp.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.saritac7190004.todoapp.dao.TodoDao;
import com.saritac7190004.todoapp.model.Todo;

/**
 * Created by Sarita on 6/12/2020.
 */
@Database(entities = Todo.class,version = 2)
public abstract class TodoDatabase extends RoomDatabase {

    public abstract TodoDao noteDao();

    private static TodoDatabase instance;

    public static synchronized TodoDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, TodoDatabase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private TodoDao todoDao;
        private PopulateDbAsyncTask(TodoDatabase todoDatabase){
            this.todoDao = todoDatabase.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            todoDao.insert(new Todo("Title 1","Description 1",1));
            todoDao.insert(new Todo("Title 2","Description 3",2));
            todoDao.insert(new Todo("Title 3","Description 3",3));
            return null;
        }
    }
}
