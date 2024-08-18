package nk.lx.ums_backend.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String trueName;

    private String telephone;

    private String email;

    @JsonIgnore
    private String password;

    @Builder.Default
    private Date registerDate= new Date();

    @JsonIgnore
    private Integer valid;
}

