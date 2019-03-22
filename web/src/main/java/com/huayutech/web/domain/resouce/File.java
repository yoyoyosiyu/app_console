package com.huayutech.web.domain.resouce;



import javax.persistence.*;

@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Column
    String filename;

    @Column
    String url;

    @Column
    @Temporal(TemporalType.TIME)
    int createAt;

}
