package note.entity;

import java.util.Date;

public class noteNote {
    private Integer noteId;

    private String noteTitle;

    private String noteBody;

    private String noteImage;

    private Integer noteType;

    private Integer createUser;

    private Date createTime;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle == null ? null : noteTitle.trim();
    }

    public String getNoteBody() {
        return noteBody;
    }

    public void setNoteBody(String noteBody) {
        this.noteBody = noteBody == null ? null : noteBody.trim();
    }

    public String getNoteImage() {
        return noteImage;
    }

    public void setNoteImage(String noteImage) {
        this.noteImage = noteImage == null ? null : noteImage.trim();
    }

    public Integer getNoteType() {
        return noteType;
    }

    public void setNoteType(Integer noteType) {
        this.noteType = noteType;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}