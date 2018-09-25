package com.hb.sb.jpademo.app.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "t_cust")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@Column
    private String name;
}