package com.hb.sb.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "t_items")
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	@Column
    private String name;
	@Column
    private String description;
}