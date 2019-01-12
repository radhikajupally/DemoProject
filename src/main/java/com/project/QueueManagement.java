package com.project;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.log4j.Logger;

public class QueueManagement {

    private static final Logger log = Logger.getLogger(QueueManagement.class);

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        addElementsToQueue(queue);
        log.info("Queue size is : " + queue.size());

        printQueue(queue);
    }

    private static void printQueue(Queue<String> queue) {
        while (!queue.isEmpty()) {
            log.info(queue.poll());
        }
    }

    private static void addElementsToQueue(Queue<String> queue) {
        queue.add("Java");
        queue.add("Spring");
        queue.add("Hibernate");
        queue.add("Restful services");
        queue.add("Angular");
    }
}