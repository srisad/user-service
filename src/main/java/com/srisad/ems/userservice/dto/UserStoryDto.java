package com.srisad.ems.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class UserStoryDto {
   
   private Integer storyId;

   private List<TaskDto> tasks;
   
}
