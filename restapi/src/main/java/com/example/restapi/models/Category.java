package com.example.restapi.models;

import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "category")
public class Category {
    
    @Id
    @Column(name = "category_uuid")
    private String Category_Id;

    @Column(name = "categoryname")
    private String CategoryName;

    @ManyToOne
    private Category category;

    @OneToMany


    public Category() {
    }


    public Category(String Category_Id, String CategoryNaem, Menu menu) {
        //this.Category_Id = Category_Id;
        this.CategoryName = CategoryNaem;
        this.menu = menu;
    }

    /*public String getCategory_Id() {
        return this.Category_Id;
    }

    public void setCategory_Id(String Category_Id) {
        this.Category_Id = Category_Id;
    }
*/
    public String getCategoryNaem() {
        return this.CategoryName;
    }

    public void setCategoryNaem(String CategoryNaem) {
        this.CategoryName = CategoryNaem;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
}
