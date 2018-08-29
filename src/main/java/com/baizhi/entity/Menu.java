package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Menu implements Serializable {
    private int id;
    private String title;
    private String content;
    private String href;
    private String iconCls;
    private int parentId;
    private List<Menu> menus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                parentId == menu.parentId &&
                Objects.equals(title, menu.title) &&
                Objects.equals(content, menu.content) &&
                Objects.equals(href, menu.href) &&
                Objects.equals(iconCls, menu.iconCls) &&
                Objects.equals(menus, menu.menus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, content, href, iconCls, parentId, menus);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parentId=" + parentId +
                ", menus=" + menus +
                '}';
    }

    public Menu(int id, String title, String content, String href, String iconCls, int parentId, List<Menu> menus) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.href = href;
        this.iconCls = iconCls;
        this.parentId = parentId;
        this.menus = menus;
    }

    public Menu() {
    }
}
