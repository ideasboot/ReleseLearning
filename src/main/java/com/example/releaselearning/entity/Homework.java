package com.example.releaselearning.entity;

import cn.hutool.core.date.DateTime;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_homework")
public class Homework {

    @Id
    @NotEmpty(message = "作业题目不能为空")
    @Column(name = "homework_id")
    private String homeworkId;

    @NotEmpty(message = "作业内容不能为空")
    @Column(name = "homework_content")
    private String homeworkContent;

    @NotNull(message = "所属班级不能为空")
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
    @JoinColumn(name = "class_id")
    private Class classId;

}
