
package com.example.irfan.sistempakar.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.irfan.sistempakar.model.DiagnosaModel;
import com.example.irfan.sistempakar.model.Gejala;
import com.example.irfan.sistempakar.model.Penyakit;
import com.example.irfan.sistempakar.model.Solusi;
import com.example.irfan.sistempakar.model.User;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "sistempakar.db";

    public DBHelper (Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTablePenyakit(db);
        isiTablePenyakit(db);
        createTableGejala(db);
        isiTableGejala(db);
        createTableSolusi(db);
        isiTableSolusi(db);
        createTableUser(db);
        createTableDiagnosa(db);
//        createTableKeputusan(db);
//        isiTableKeputusan(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
        db.execSQL(SCRIPT_DELETE_TABLE);
    }
    //handle create Table User
    public void createTableUser(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS tbl_user");
        db.execSQL("CREATE TABLE if not exists tbl_user (id_user INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nama_user TEXT, umur_user TEXT, jenis_kelamin TEXT, alamat_user TEXT, notlp_user TEXT);");
    }

    //handle create table diagnosa
    public void createTableDiagnosa(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS tbl_diagnosa");
        db.execSQL("CREATE TABLE if not exists tbl_diagnosa (id_diagnosa INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, penyakit_id INTEGER, user_id INTEGER)");
    }

    //handle create Table Gejala
    public void createTableGejala(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS tbl_gejala");
        db.execSQL("CREATE TABLE if not exists tbl_gejala (id_gejala INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, penyakit_id INTEGER, kode_gejala TEXT, keterangan_gejala TEXT, FOREIGN KEY(penyakit_id) REFERENCES tbl_penyakit(id_penyakit));");
    }

    //handle create table Penyakit
    public void createTablePenyakit(SQLiteDatabase dbPenyakit)
    {
        dbPenyakit.execSQL("DROP TABLE IF EXISTS tbl_penyakit");
        dbPenyakit.execSQL("CREATE TABLE if not exists tbl_penyakit (id_penyakit INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, kode_penyakit TEXT, nama_penyakit TEXT, definisi_penyakit TEXT, image_penyakit TEXT)");
    }

    //handle create table solusi
    public void createTableSolusi(SQLiteDatabase dbSolusi)
    {
        dbSolusi.execSQL("DROP TABLE IF EXISTS tbl_solusi");
        dbSolusi.execSQL("CREATE TABLE IF NOT EXISTS tbl_solusi (id_solusi INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, penyakit_id INTEGER, keterangan_solusi TEXT, FOREIGN KEY(penyakit_id) REFERENCES tbl_penyakit(id_penyakit))");
    }

    //handle isi table
    public void isiTableGejala(SQLiteDatabase db) {
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (1, 'G01', 'Kebotakan berpola bulat atau pitak');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (1, 'G02', 'Kebotakan terjadi pada bagian bawah, samping, atau melingkari belakang kepala');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (1, 'G03', 'Rambut yang tumbuh kembali berbeda dengan rambut sebelumnya');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (2,'G04', 'kemerahan, gatal, nyeri, dan muncul bisul dikulit kepala');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (2,'G05', 'jarak dikulit kepala melebar');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (2,'G06', 'garis rambut di sekitar dahi yang terlihat lebih mundur');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (2,'G07', 'jerawat kecil yang muncul di kulit kepala');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (2,'G08', 'rambut mengalami penipisan dan patah');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (2,'G09', 'peradangan di folikel rambut');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (3,'G10', 'rambut menipis di area tertentu');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (3,'G11', 'penipisan biasanya terjadi di ubun-ubun');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (3,'G12', 'rambut rontok menumpuk di sarung bantal, lantai kamar mandi, atau sisir');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (3,'G13', 'rambut di bagian tubuh lain mengalami kerontokan');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (4,'G14', 'terdapat bentuk seboroit di kulit kepala');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (4,'G15','terdapat pola pustula(bernanah)');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (4,'G16', 'terdapat titik hitam');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (5,'G17', 'mencabuti rambut secara berulang');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (5,'G18', 'memiliki semacam kebiasaan dalam mencabut rambut');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (5,'G19', 'selalu tidak berhasil menahan dorongan untuk mencabut rambut');");
        db.execSQL("INSERT INTO tbl_gejala ('penyakit_id', 'kode_gejala', 'keterangan_gejala') VALUES (5,'G20', 'terdapat rasa cemas yang muncul sebelum mencabuti rambut');");

    }

    //handle isi table penyakit
    public void isiTablePenyakit(SQLiteDatabase dbPenyakit)
    {
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit ('kode_penyakit', 'nama_penyakit', 'definisi_penyakit', 'image_penyakit') VALUES ('P01', 'alopecia areata', 'Alopecia areata adalah kebotakan atau kerontokan rambut yang disebabkan oleh penyakit autoimun. Pada alopecia areata, sistem imun menyerang dan merusak folikel rambut, sehingga menyebabkan kerontokan dan kebotakan. Kulit kepala botak dengan bentuk pitak adalah salah satu tanda dari kondisi ini.', 'alopecia_areata');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit ('kode_penyakit', 'nama_penyakit', 'definisi_penyakit', 'image_penyakit') VALUES ('P02', 'alopecia traksi', 'Alopecia traksi adalah kerontokan rambut yang disebabkan oleh penarikan berulang yang sama, sering, dan berlangsung dalam waktu yang lama. Hal ini terjadi biasanya saat Anda sering mengikat rambut dengan kucir yang terlalu kencang atau mengepangnya. Tarikan yang terlalu kuat dan berulang dapat merusak folikel dan menarik rambut keluar dari kulit kepala. Akibatnya, rambut mengalami kerontokan.', 'alopecia_traksi');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit ('kode_penyakit', 'nama_penyakit', 'definisi_penyakit', 'image_penyakit') VALUES ('P03', 'telogen effluvium', 'Telogen effluvium (TE) adalah kondisi ketika rambut mengalami rambut rontok secara mendadak. Masalah kerontokan ini biasanya bersifat sementara, alias tidak permanen. Kondisi ini biasanya terjadi ketika ada perubahan jumlah folikel rambut yang menumbuhkan rambut.', 'telogen_effluvium');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit ('kode_penyakit', 'nama_penyakit', 'definisi_penyakit', 'image_penyakit') VALUES ('P04', 'tinea capitis', 'Tinea capitis adalah penyakit yang disebabkan oleh infeksi jamur dermatofit pada kulit kepala dan batang rambut. Penyakit ini lebih banyak dialami oleh anak-anak, terutama anak laki-laki usia 3-7 tahun. Tinea capitis sangat mudah menyebar melalui perantara benda yang sudah terpapar jamur dermatofit, atau kontak langsung dengan binatang atau orang yang terinfeksi.', 'tinea_capitis');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit ('kode_penyakit', 'nama_penyakit', 'definisi_penyakit', 'image_penyakit') VALUES ('P05', 'trikotilomania', 'Trikotilomania adalah gangguan mental yang membuat penderitanya memiliki dorongan tidak tertahankan untuk mencabuti rambut di kepalanya. Penderita trikotilomania juga memiliki keinginan untuk mencabuti rambut di bagian tubuh lain, seperti alis dan bulu mata.', 'trikotilomania');");

    }

    //handle isi solusi
    public void isiTableSolusi(SQLiteDatabase dbSolusi)
    {
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (1, 'menjalani konseling bersama psikolog');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (1, 'mengurangi konsumsi minuman yang mengandung kafein');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (1, 'mendengarkan musik yang menenangkan');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES(2, 'menggerai rambut dan kalau dikucir jangan terlalu ketat');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES(2, 'jangan pakai karet gelang untuk kucir rambut');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES(2, 'membatasi penggunaaan catokan dan juga bahan kimia lainnya seperti gel rambut yang keras');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (3, 'pola makan sehat dan bergizi');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (3, 'merawat rambut dengan hati-hati');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (3, 'kelola stress');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (4, 'selalu menjaga kebersihan tangan');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (4, 'mencuci rambut dan kulit kepala secara rutin dengan sampo');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (4, 'tidak berbagi penggunaan barang-barang, seperti sisir, handuk, dan baju dengan orang lain');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (4, 'menghindari hewan yang terinfeksi');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (5, 'jangan mengandalkan alkohol atau obat-obatan untuk meredakan stress');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (5, 'rutin berolahraga');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi ('penyakit_id', 'keterangan_solusi') VALUES (5, 'mengonsumsi makanan sehat dan bergizi seimbang');");
    }

    public void isiTableKeputusan(SQLiteDatabase dbKeputusan)
    {
        dbKeputusan.execSQL("INSERT INTO tbl_keputusan VALUES ('P01', 'G01', 'S1')");
        dbKeputusan.execSQL("INSERT INTO tbl_keputusan VALUES ('P01', 'G01', 'S1')");
    }

    public ArrayList<Gejala> getAllGejala() {
        ArrayList<Gejala> hasilList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM tbl_gejala";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Gejala modelHasil = new Gejala(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2),
                        cursor.getString(3)
                );
                hasilList.add(modelHasil);
            } while (cursor.moveToNext());
        }
        return hasilList;
    }

    public ArrayList<Penyakit> getAllPenyakit() {
        ArrayList<Penyakit> hasilList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM tbl_penyakit";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Penyakit modelHasil = new Penyakit(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                hasilList.add(modelHasil);
            } while (cursor.moveToNext());
        }
        return hasilList;
    }

    public Penyakit getRecordPenyakit(int idPenyakit) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("tbl_penyakit", new String[] {"id_penyakit", "kode_penyakit", "nama_penyakit","definisi_penyakit","image_penyakit"}, "id_penyakit" + "=?",
                new String[] { String.valueOf(idPenyakit) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Penyakit penyakit = new Penyakit(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4)
        );
        // return contact
        return penyakit;
    }

     public ArrayList<Gejala> getGejala(int idGejala) {
            ArrayList<Gejala> hasilList = new ArrayList<>();
            // Select All Query
            String selectQuery = "SELECT  * FROM tbl_gejala where penyakit_id = "+idGejala;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Gejala modelHasil = new Gejala(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2),
                        cursor.getString(3)
                );
                hasilList.add(modelHasil);
            } while (cursor.moveToNext());
        }
        return hasilList;
    }

    public ArrayList<Solusi> getSolusi(int idGejala) {
        ArrayList<Solusi> hasilList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM tbl_solusi where penyakit_id = "+idGejala;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Solusi modelHasil = new Solusi(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2)
                );
                hasilList.add(modelHasil);
            } while (cursor.moveToNext());
        }
        return hasilList;
    }

    public ArrayList<DiagnosaModel> getAllDiagnosa() {
        ArrayList<DiagnosaModel> hasilList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM tbl_diagnosa";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DiagnosaModel modelHasil = new DiagnosaModel(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        Integer.parseInt(cursor.getString(2))
                );
                hasilList.add(modelHasil);
            } while (cursor.moveToNext());
        }
        return hasilList;
    }

    public DiagnosaModel getDiagnosa() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM tbl_diagnosa ORDER BY id_diagnosa DESC LIMIT 1";
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null)
            cursor.moveToFirst();

        DiagnosaModel userModels = new DiagnosaModel(
                Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2))
        );
        // return contact
        return userModels;
    }

    public void addRecordUser(User user){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("nama_user", user.getNamaUser());
        values.put("umur_user", user.getUmurUser());
        values.put("jenis_kelamin", user.getJenisKelaminUser());
        values.put("alamat_user", user.getAlamat());
        values.put("notlp_user", user.getNoTelepon());

        db.insert("tbl_user", null, values);
        db.close();
    }

    public void addRecordDiagnosa(DiagnosaModel diagnosaModel){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("penyakit_id", diagnosaModel.getIdPenyakit());
        values.put("user_id", diagnosaModel.getIdUser());

        db.insert("tbl_diagnosa", null, values);
        db.close();
    }

    public User getLastRecordUser() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM tbl_user ORDER BY id_user DESC LIMIT 1";
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null)
            cursor.moveToFirst();

        User userModels = new User(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5)
        );
        // return contact
        return userModels;
    }

    public User getUser(int idUser) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM tbl_user where id_user="+idUser;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null)
            cursor.moveToFirst();

        User userModels = new User(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5)
        );
        // return contact
        return userModels;
    }

    public ArrayList<DiagnosaModel> getDiagnosaByUser(int idUser) {
        ArrayList<DiagnosaModel> hasilList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM tbl_diagnosa where user_id="+idUser;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DiagnosaModel modelHasil = new DiagnosaModel(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        Integer.parseInt(cursor.getString(2))
                );
                hasilList.add(modelHasil);
            } while (cursor.moveToNext());
        }
        return hasilList;
    }

    public Penyakit getPenyakit(int idPenyakit) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM tbl_penyakit where id_penyakit="+idPenyakit;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null)
            cursor.moveToFirst();

        Penyakit userModels = new Penyakit(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4)
        );
        // return contact
        return userModels;
    }

    //MENGHAPUS TABLE
    private static final String SCRIPT_DELETE_TABLE="DROP TABLE IF EXISTS " + DATABASE_NAME;
}
