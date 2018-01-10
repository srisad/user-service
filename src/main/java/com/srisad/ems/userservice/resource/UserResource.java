package com.srisad.ems.userservice.resource;

import com.srisad.ems.userservice.dto.TaskDto;
import com.srisad.ems.userservice.dto.UserStoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {

   @Autowired
   RestTemplate restTemplate;

   @Autowired
   ModelMapper modelMapper;

   @GetMapping("/{userId}/user-stories")
   public List<UserStoryDto> getUserStoriesByUser(@PathVariable Integer userId) {

      ResponseEntity<List<Integer>> storyResponse = restTemplate.exchange("http://user-story-service/user-stories/" + userId,
            HttpMethod.GET,
            null,
            ParameterizedTypeReference.forType(List.class));

      List<Integer> storyList = storyResponse.getBody();
      return storyList.stream().map(storyId ->
            new UserStoryDto(storyId, this.getTasksForStory(storyId))
      ).collect(Collectors.toList());
   }

   private List<TaskDto> getTasksForStory(Integer storyId) {
      ResponseEntity<List<TaskDto>> taskResponse = restTemplate.exchange("http://task-service/tasks/" + storyId,
            HttpMethod.GET,
            null,
            ParameterizedTypeReference.forType(List.class));

      List<TaskDto> taskList = taskResponse.getBody();
      return taskList;
   }
}
