package note.entity;

import java.util.Date;

public class noteTab {
    private Integer tabId;

    private Integer tabGrade;

    private Integer tabSub;

    private Integer tabChapter;

    private String tabName;

    private Integer tabType;

    private Date createTime;

    public Integer getTabId() {
        return tabId;
    }

    public void setTabId(Integer tabId) {
        this.tabId = tabId;
    }

    public Integer getTabGrade() {
        return tabGrade;
    }

    public void setTabGrade(Integer tabGrade) {
        this.tabGrade = tabGrade;
    }

    public Integer getTabSub() {
        return tabSub;
    }

    public void setTabSub(Integer tabSub) {
        this.tabSub = tabSub;
    }

    public Integer getTabChapter() {
        return tabChapter;
    }

    public void setTabChapter(Integer tabChapter) {
        this.tabChapter = tabChapter;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName == null ? null : tabName.trim();
    }

    public Integer getTabType() {
        return tabType;
    }

    public void setTabType(Integer tabType) {
        this.tabType = tabType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}