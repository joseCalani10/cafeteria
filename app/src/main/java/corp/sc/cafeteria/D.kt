package corp.sc.cafeteria

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class D(context: Context, mode:Boolean) : SQLiteOpenHelper(context, "task", null, 1) {
    var mode:Boolean=mode
    var context = context

    override fun onCreate(s:SQLiteDatabase){
        val sql="create table usuario(id integer primary key,nombres text,usu text,correo text,clave text);"
        val sql2="create table productos(id integer primary key,nombre text,categoria integer,precio integer,descripcion text,foto text);"
        s.execSQL(sql)
        s.execSQL(sql2)
        Toast.makeText(this.context,"bienvenido!",Toast.LENGTH_LONG).show()
    }

    override fun onUpgrade(db:SQLiteDatabase,oldversion:Int,newVersion:Int){
        //TDO
    }

    fun run(): SQLiteDatabase {
        return if(this.mode)
            this.writableDatabase
        else this.readableDatabase
    }
}