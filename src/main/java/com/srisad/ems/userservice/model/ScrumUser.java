package com.srisad.ems.userservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "scrum_user")
@Data
public class ScrumUser {
   
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   @Column(name = "user_id")
   private Long id;
   
   @Column(name = "user_name")
   private String name;
   
   @Column(name = "user_title")
   private String title;
   
}
