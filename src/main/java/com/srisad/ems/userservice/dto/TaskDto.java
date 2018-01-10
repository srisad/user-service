package com.srisad.ems.userservice.dto;

public class TaskDto {
   
   private Integer taskId;
   
   private String taskDescription;

   public TaskDto() {
   }

   public TaskDto(Integer taskId, String taskDescription) {
      this.taskId = taskId;
      this.taskDescription = taskDescription;
   }

   public Integer getTaskId() {
      return taskId;
   }

   public TaskDto setTaskId(Integer taskId) {
      this.taskId = taskId;
      return this;
   }

   public String getTaskDescription() {
      return taskDescription;
   }

   public TaskDto setTaskDescription(String taskDescription) {
      this.taskDescription = taskDescription;
      return this;
   }
}

