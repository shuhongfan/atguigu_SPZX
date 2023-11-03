package com.atguigu.spzx.model.dto.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "请求参数实体类")
public class AssginRoleDto {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "角色id的List集合")
    private List<Long> roleIdList;

}
