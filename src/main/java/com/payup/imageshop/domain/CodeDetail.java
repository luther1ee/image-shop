package com.payup.imageshop.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"groupCode", "codeValue"})
@Entity
@Table(name = "code_detail")
@IdClass(CodeDetailId.class)
public class CodeDetail implements Serializable {
    @Id
    @Column(length = 3)
    private String groupCode;

    @Id
    @Column(length = 3)
    private String codeValue;

    @Column(length = 30, nullable = false)
    private String codeName;

    private int sortSeq;

    @Column(length = 1)
    private String useYn = "Y";

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
