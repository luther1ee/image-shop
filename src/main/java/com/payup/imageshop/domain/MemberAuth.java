package com.payup.imageshop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "member_auth")
public class MemberAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAuthNo;

    @Column(name = "user_no")
    private Long userNo;

    @Column(length = 50)
    private String auth;

    @CreationTimestamp
    private Date regDate;
    @UpdateTimestamp
    private Date updDate;
}
