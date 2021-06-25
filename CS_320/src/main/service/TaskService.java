package com.josh.massey.service;

import com.josh.massey.model.Task;
import java.util.HashMap;

public class TaskService {

  private final HashMap<String, Task> tasks = new HashMap<>();

  public boolean addTask(String id, String name, String description) {
    boolean added = false;
    Task t = new Task(id, description, name);
    if (!tasks.containsKey(id) && t.getName() != null) {
      tasks.put(id, t);
      added = true;
    }
    return added;
  }

  public boolean deleteTask(String id) {
    return tasks.remove(id) != null;
  }

  public boolean updateTask(String id, String field, String value) {
    boolean updated = false;
    if (tasks.get(id) != null) {
      Task t = tasks.get(id);
      switch (field) {
        case "name":
          updated = t.setName(value);
          break;
        case "description":
          updated = t.setDescription(value);
          break;
      }
    }
    return updated;
  }
}
