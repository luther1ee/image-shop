package com.payup.imageshop.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "codeDetails")
@Entity
@EqualsAndHashCode(of = "groupCode")
@Table(name="code_group")
public class CodeGroup {
    @Id
    @Column(length = 3)
    private String groupCode;

    @Column(length = 30, nullable = false)
    private String groupName;

    @Column(length = 1)
    private String useYn = "Y";

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany
    @JoinColumn(name = "groupCode")
    private List<CodeDetail> codeDetails;
}
