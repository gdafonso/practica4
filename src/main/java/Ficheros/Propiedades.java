package Ficheros;

import java.sql.Date;
import java.util.ArrayList;
import java.io.Serializable;

public class Propiedades implements Serializable
{
    private int id;
    private String name;
    private int length;
    private String canRead;
    private String canWrite;
    private Date lastModified;

	@Override
    public String toString() {
        return String.valueOf(this.name);
    }
    
    public Propiedades() {
    }
    
    public Propiedades(final int id, final String name, final int length, final String canRead, final String canWrite, final Date lastModified) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.canRead = canRead;
        this.canWrite = canWrite;
        this.lastModified = lastModified;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void setLength(final int length) {
        this.length = length;
    }
    
    public String getCanRead() {
        return this.canRead;
    }
    
    public void setCanRead(final String canRead) {
        this.canRead = canRead;
    }
    
    public String getCanWrite() {
        return this.canWrite;
    }
    
    public void setCanWrite(final String canWrite) {
        this.canWrite = canWrite;
    }
    
    public Date getLastModified() {
        return this.lastModified;
    }
    
    public void setLastModified(final Date lastModified) {
        this.lastModified = lastModified;
    }

}
