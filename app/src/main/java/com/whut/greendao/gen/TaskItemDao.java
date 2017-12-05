package com.whut.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.whut.smartinspection.model.TaskItem;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TASK_ITEM".
*/
public class TaskItemDao extends AbstractDao<TaskItem, Long> {

    public static final String TABLENAME = "TASK_ITEM";

    /**
     * Properties of entity TaskItem.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "id");
        public final static Property Idd = new Property(1, String.class, "idd", false, "IDD");
        public final static Property Content = new Property(2, String.class, "content", false, "CONTENT");
        public final static Property Type = new Property(3, String.class, "type", false, "TYPE");
        public final static Property Worker = new Property(4, String.class, "worker", false, "WORKER");
        public final static Property Date = new Property(5, String.class, "date", false, "DATE");
        public final static Property Status = new Property(6, int.class, "status", false, "STATUS");
        public final static Property SubstationId = new Property(7, String.class, "substationId", false, "SUBSTATION_ID");
        public final static Property PatrolTypeId = new Property(8, int.class, "patrolTypeId", false, "PATROL_TYPE_ID");
    }


    public TaskItemDao(DaoConfig config) {
        super(config);
    }
    
    public TaskItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TASK_ITEM\" (" + //
                "\"id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"IDD\" TEXT," + // 1: idd
                "\"CONTENT\" TEXT," + // 2: content
                "\"TYPE\" TEXT," + // 3: type
                "\"WORKER\" TEXT," + // 4: worker
                "\"DATE\" TEXT," + // 5: date
                "\"STATUS\" INTEGER NOT NULL ," + // 6: status
                "\"SUBSTATION_ID\" TEXT," + // 7: substationId
                "\"PATROL_TYPE_ID\" INTEGER NOT NULL );"); // 8: patrolTypeId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TASK_ITEM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TaskItem entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String idd = entity.getIdd();
        if (idd != null) {
            stmt.bindString(2, idd);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(4, type);
        }
 
        String worker = entity.getWorker();
        if (worker != null) {
            stmt.bindString(5, worker);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(6, date);
        }
        stmt.bindLong(7, entity.getStatus());
 
        String substationId = entity.getSubstationId();
        if (substationId != null) {
            stmt.bindString(8, substationId);
        }
        stmt.bindLong(9, entity.getPatrolTypeId());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TaskItem entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String idd = entity.getIdd();
        if (idd != null) {
            stmt.bindString(2, idd);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(4, type);
        }
 
        String worker = entity.getWorker();
        if (worker != null) {
            stmt.bindString(5, worker);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(6, date);
        }
        stmt.bindLong(7, entity.getStatus());
 
        String substationId = entity.getSubstationId();
        if (substationId != null) {
            stmt.bindString(8, substationId);
        }
        stmt.bindLong(9, entity.getPatrolTypeId());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public TaskItem readEntity(Cursor cursor, int offset) {
        TaskItem entity = new TaskItem( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // idd
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // content
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // type
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // worker
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // date
            cursor.getInt(offset + 6), // status
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // substationId
            cursor.getInt(offset + 8) // patrolTypeId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TaskItem entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIdd(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setContent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setType(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setWorker(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDate(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setStatus(cursor.getInt(offset + 6));
        entity.setSubstationId(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPatrolTypeId(cursor.getInt(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TaskItem entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TaskItem entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TaskItem entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}