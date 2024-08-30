package collection.deque.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskScheduler {

    public Queue<Task> tasks = new ArrayDeque<>();

    public void addTask(Task task) {
        tasks.offer(task);
    }

    public int getRemainingTask() {
        return tasks.size();
    }

    public void processNextTask() {
        Task task = tasks.poll();
        if (task != null) {
            task.execute();
        }
    }
}
