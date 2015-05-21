package com.tp.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Created by dev on 21/05/15.
 */
public class InstructionQueue {

    public ArrayList<InstructionMessage> instructionQueue = new ArrayList<InstructionMessage>();

    public ArrayList<InstructionMessage> getInstructionQueue() {
        return instructionQueue;
    }

    public void setInstructionQueue(ArrayList<InstructionMessage> instructionQueue) {
        this.instructionQueue = instructionQueue;
    }

    public void addToList(InstructionMessage im) {
        this.getInstructionQueue().add(im);
        sortCollection();
    }

    public void removeFromList(InstructionMessage im) {
        this.getInstructionQueue().remove(im);
        sortCollection();
    }

    public void removeFromList(int index) {
        this.getInstructionQueue().remove(index);
        sortCollection();
    }

    public InstructionQueue(ArrayList<InstructionMessage> instructionQueue) {
        this.instructionQueue = instructionQueue;
    }

    public InstructionQueue() {
    }

    public InstructionQueue(int initialSize) throws Exception {
        if (initialSize < 0) {
            throw new Exception("Cannot create list with size less than 0");
        }
        this.instructionQueue = new ArrayList<InstructionMessage>(initialSize);
    }

    @Override
    public String toString() {
        return "InstructionQueue{" +
                "instructionQueue=" + instructionQueue +
                '}';
    }

    private void sortCollection() {
        Collections.sort(this.getInstructionQueue(), new Comparator<InstructionMessage>() {
            @Override
            public int compare(InstructionMessage o1, InstructionMessage o2) {
                return Long.valueOf(o1.getInstructionType()).compareTo(Long.valueOf(o2.getInstructionType()));
            }
        });
    }

    public int getInstructionQueueSize() {
        return this.getInstructionQueue().size();
    }

    public boolean isInstructionQueueEmpty() {
        return this.getInstructionQueue().size() == 0;
    }

    public InstructionMessage getFirstMessage() {
        if (!isInstructionQueueEmpty()) {
            return this.getInstructionQueue().get(0);
        } else {
            return null;
        }
    }



}
